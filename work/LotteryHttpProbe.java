import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reproduces the Lottery Checker request profile with Java's HttpURLConnection.
 * The embedded API key is read from the decompiled resource file and is never
 * printed or copied into this helper.
 */
public final class LotteryHttpProbe {
    private static final String BASE_URL = "https://thctt-mob01-api.p7z.pw";
    private static final Pattern API_KEY = Pattern.compile(
            "<string\\s+name=\"api_key\">([^<]+)</string>");

    private LotteryHttpProbe() {}

    public static void main(String[] args) throws Exception {
        if (args.length < 3 || args.length > 4) {
            System.err.println(
                    "usage: LotteryHttpProbe <strings.xml> <endpoint-path> <install-id> [capability]");
            System.exit(2);
        }

        String apiKey = readApiKey(Path.of(args[0]));
        String endpoint = args[1];
        String installId = args[2];
        String capability = args.length == 4 ? args[3] : null;

        if (!endpoint.startsWith("/") || endpoint.contains(":") || endpoint.contains("//")) {
            throw new IllegalArgumentException("endpoint must be a path on the challenge API host");
        }
        if (!installId.matches("[A-Za-z0-9_-]{22}")) {
            throw new IllegalArgumentException("install-id is not canonical base64url shape");
        }

        HttpURLConnection connection =
                (HttpURLConnection) new URL(BASE_URL + endpoint).openConnection();
        try {
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            connection.setRequestProperty("X-API-Key", apiKey);
            connection.setRequestProperty(
                    "User-Agent", "THCTT-Mobile01/1 (Android; sh.sth.lotterychecker)");
            connection.setRequestProperty("X-THCTT-App-ID", "sh.sth.lotterychecker");
            connection.setRequestProperty("X-THCTT-App-Version", "1");
            connection.setRequestProperty("X-THCTT-Install-ID", installId);
            if (capability != null) {
                connection.setRequestProperty("X-Challenge-Capability", capability);
            }

            int code = connection.getResponseCode();
            System.out.println("HTTP " + code);
            printHeader(connection, "Content-Type");
            printHeader(connection, "Content-Length");
            printHeader(connection, "Location");
            printHeader(connection, "WWW-Authenticate");
            printHeader(connection, "Set-Cookie");
            printHeader(connection, "Server");

            InputStream stream = code >= 400
                    ? connection.getErrorStream()
                    : connection.getInputStream();
            if (stream != null) {
                System.out.println(readBody(stream, 8192));
            }
        } finally {
            connection.disconnect();
        }
    }

    private static String readApiKey(Path stringsXml) throws IOException {
        String xml = Files.readString(stringsXml, StandardCharsets.UTF_8);
        Matcher matcher = API_KEY.matcher(xml);
        if (!matcher.find()) {
            throw new IllegalArgumentException("api_key resource not found");
        }
        return matcher.group(1);
    }

    private static String readBody(InputStream stream, int limit) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            int character;
            while ((character = reader.read()) != -1 && result.length() < limit) {
                result.append((char) character);
            }
        }
        return result.toString();
    }

    private static void printHeader(HttpURLConnection connection, String name) {
        String value = connection.getHeaderField(name);
        if (value != null) {
            System.out.println(name + ": " + value);
        }
    }
}
