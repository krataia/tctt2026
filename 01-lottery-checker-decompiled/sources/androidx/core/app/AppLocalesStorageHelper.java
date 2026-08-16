package androidx.core.app;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final boolean DEBUG = false;
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";
    private static final Object sAppLocaleStorageSync = new Object();

    private AppLocalesStorageHelper() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        r1 = r3.getAttributeValue(null, androidx.core.app.AppLocalesStorageHelper.LOCALE_RECORD_ATTRIBUTE_TAG);
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x006f: IF  (r2 I:??[int, boolean, OBJECT, ARRAY, byte, short, char] A[D('fis' java.io.FileInputStream)]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:47:0x0077 (LINE:95), block:B:42:0x006f */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068 A[Catch: all -> 0x007b, TryCatch #4 {, blocks: (B:5:0x0005, B:23:0x0048, B:36:0x0061, B:40:0x006d, B:39:0x0068, B:43:0x0071, B:47:0x0077, B:34:0x005d, B:49:0x0079, B:6:0x000c, B:7:0x0019, B:11:0x0024, B:17:0x0030, B:19:0x003c, B:32:0x0053), top: B:56:0x0005, inners: #2, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String readLocales(Context context) {
        String appLocales;
        FileInputStream fis;
        FileInputStream fis2;
        XmlPullParser parser;
        int outerDepth;
        synchronized (sAppLocaleStorageSync) {
            appLocales = "";
            try {
                try {
                    try {
                        fis2 = context.openFileInput(APPLICATION_LOCALES_RECORD_FILE);
                        try {
                            parser = Xml.newPullParser();
                            parser.setInput(fis2, "UTF-8");
                            outerDepth = parser.getDepth();
                        } catch (IOException | XmlPullParserException e) {
                            Log.w(TAG, "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file");
                            if (fis2 != null) {
                                fis2.close();
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        return "";
                    }
                } catch (Throwable th) {
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
            }
            while (true) {
                int type = parser.next();
                if (type == 1 || (type == 3 && parser.getDepth() <= outerDepth)) {
                    break;
                }
                if (type != 3 && type != 4) {
                    String tagName = parser.getName();
                    if (tagName.equals(LOCALE_RECORD_FILE_TAG)) {
                        break;
                    }
                    if (!appLocales.isEmpty()) {
                        context.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
                    }
                }
            }
            if (fis2 != null) {
                fis2.close();
            }
            if (!appLocales.isEmpty()) {
            }
        }
        return appLocales;
    }

    public static void persistLocales(Context context, String locales) {
        synchronized (sAppLocaleStorageSync) {
            if (locales.equals("")) {
                context.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
                return;
            }
            try {
                FileOutputStream fos = context.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);
                XmlSerializer serializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            serializer.setOutput(fos, null);
                            serializer.startDocument("UTF-8", true);
                            serializer.startTag(null, LOCALE_RECORD_FILE_TAG);
                            serializer.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, locales);
                            serializer.endTag(null, LOCALE_RECORD_FILE_TAG);
                            serializer.endDocument();
                        } catch (IOException e) {
                        }
                    } catch (Exception e2) {
                        Log.w(TAG, "Storing App Locales : Failed to persist app-locales in storage ", e2);
                        if (fos != null) {
                            fos.close();
                        }
                    }
                    if (fos != null) {
                        fos.close();
                    }
                } catch (Throwable th) {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                Log.w(TAG, String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", APPLICATION_LOCALES_RECORD_FILE));
            }
        }
    }
}
