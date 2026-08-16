.class public final Lsh/sth/skylink/ActivationActivity;
.super Landroid/app/Activity;
.source "ActivationActivity.java"


# static fields
.field private static final CALLBACK_HOST:Ljava/lang/String; = "activate"

.field private static final CALLBACK_SCHEME:Ljava/lang/String; = "thctt-mob02"

.field private static final PREFS:Ljava/lang/String; = "activation"

.field private static final RANDOM:Ljava/security/SecureRandom;


# instance fields
.field private prefs:Landroid/content/SharedPreferences;


# direct methods
.method public static synthetic $r8$lambda$DCmmYm28_RRTFEv6lyIlWRpJwoc(Lsh/sth/skylink/ActivationActivity;)V
    .locals 0

    invoke-direct {p0}, Lsh/sth/skylink/ActivationActivity;->lambda$handle$0()V

    return-void
.end method

.method public static synthetic $r8$lambda$T_p22S_DiLPct_EqjvCIsvUfznk(Lsh/sth/skylink/ActivationActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lsh/sth/skylink/ActivationActivity;->lambda$handle$2(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic $r8$lambda$mM3vtC1mtdkWW9b5rpwhy3RTef8(Lsh/sth/skylink/ActivationActivity;)V
    .locals 0

    invoke-direct {p0}, Lsh/sth/skylink/ActivationActivity;->lambda$handle$1()V

    return-void
.end method

.method static constructor <clinit>()V
    .locals 1

    .line 26
    new-instance v0, Ljava/security/SecureRandom;

    invoke-direct {v0}, Ljava/security/SecureRandom;-><init>()V

    sput-object v0, Lsh/sth/skylink/ActivationActivity;->RANDOM:Ljava/security/SecureRandom;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 22
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method static activationEnabled(Landroid/content/Context;)Ljava/lang/Boolean;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .line 143
    const/4 v0, 0x0

    .line 145
    .local v0, "connection":Ljava/net/HttpURLConnection;
    const/4 v1, 0x0

    :try_start_0
    new-instance v2, Ljava/net/URL;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget v4, Lsh/sth/skylink/R$string;->api_base:I

    .line 146
    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/activation/status"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 147
    invoke-virtual {v2}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v2

    check-cast v2, Ljava/net/HttpURLConnection;

    move-object v0, v2

    .line 148
    const/16 v2, 0x1f40

    invoke-virtual {v0, v2}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 149
    invoke-virtual {v0, v2}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 150
    const-string v2, "X-API-Key"

    sget v3, Lsh/sth/skylink/R$string;->api_key:I

    invoke-virtual {p0, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 151
    invoke-static {v0, p0}, Lsh/sth/skylink/AppRequestProfile;->apply(Ljava/net/HttpURLConnection;Landroid/content/Context;)V

    .line 152
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    const/16 v3, 0xc8

    if-eq v2, v3, :cond_1

    .line 153
    nop

    .line 167
    if-eqz v0, :cond_0

    .line 168
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 153
    :cond_0
    return-object v1

    .line 156
    :cond_1
    :try_start_1
    new-instance v2, Ljava/io/BufferedReader;

    new-instance v3, Ljava/io/InputStreamReader;

    .line 157
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v4

    sget-object v5, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v3, v4, v5}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    invoke-direct {v2, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    .line 159
    .local v2, "reader":Ljava/io/BufferedReader;
    :try_start_2
    invoke-virtual {v2}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 160
    .local v3, "response":Ljava/lang/String;
    :try_start_3
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    .line 161
    .end local v2    # "reader":Ljava/io/BufferedReader;
    if-eqz v3, :cond_2

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v4, 0x1000

    if-gt v2, v4, :cond_2

    .line 162
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v4, "enabled"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    goto :goto_0

    .line 163
    :cond_2
    nop

    .line 167
    :goto_0
    if-eqz v0, :cond_3

    .line 168
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 161
    :cond_3
    return-object v1

    .line 156
    .end local v3    # "response":Ljava/lang/String;
    .restart local v2    # "reader":Ljava/io/BufferedReader;
    :catchall_0
    move-exception v3

    :try_start_4
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_1

    :catchall_1
    move-exception v4

    :try_start_5
    invoke-virtual {v3, v4}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p0    # "context":Landroid/content/Context;
    :goto_1
    throw v3
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 167
    .end local v2    # "reader":Ljava/io/BufferedReader;
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p0    # "context":Landroid/content/Context;
    :catchall_2
    move-exception v1

    if-eqz v0, :cond_4

    .line 168
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 170
    :cond_4
    throw v1

    .line 164
    :catch_0
    move-exception v2

    .line 165
    .local v2, "ignored":Ljava/lang/Exception;
    nop

    .line 167
    if-eqz v0, :cond_5

    .line 168
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 165
    :cond_5
    return-object v1
.end method

.method private static b64([B)Ljava/lang/String;
    .locals 1
    .param p0, "value"    # [B

    .line 190
    const/16 v0, 0xb

    invoke-static {p0, v0}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private begin()V
    .locals 6

    .line 93
    const-string v0, "state"

    const/16 v1, 0x20

    :try_start_0
    invoke-static {v1}, Lsh/sth/skylink/ActivationActivity;->random(I)Ljava/lang/String;

    move-result-object v1

    .line 94
    .local v1, "state":Ljava/lang/String;
    const/16 v2, 0x30

    invoke-static {v2}, Lsh/sth/skylink/ActivationActivity;->random(I)Ljava/lang/String;

    move-result-object v2

    .line 95
    .local v2, "verifier":Ljava/lang/String;
    const-string v3, "SHA-256"

    invoke-static {v3}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v3

    sget-object v4, Ljava/nio/charset/StandardCharsets;->US_ASCII:Ljava/nio/charset/Charset;

    .line 96
    invoke-virtual {v2, v4}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v3

    .line 95
    invoke-static {v3}, Lsh/sth/skylink/ActivationActivity;->b64([B)Ljava/lang/String;

    move-result-object v3

    .line 97
    .local v3, "challenge":Ljava/lang/String;
    iget-object v4, p0, Lsh/sth/skylink/ActivationActivity;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    invoke-interface {v4, v0, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    const-string v5, "verifier"

    invoke-interface {v4, v5, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    invoke-interface {v4}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 98
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget v5, Lsh/sth/skylink/R$string;->api_base:I

    invoke-virtual {p0, v5}, Lsh/sth/skylink/ActivationActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/activate"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v4

    .line 99
    invoke-virtual {v4, v0, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v4, "code_challenge"

    .line 100
    invoke-virtual {v0, v4, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    .line 101
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 102
    .local v0, "uri":Landroid/net/Uri;
    new-instance v4, Landroid/content/Intent;

    const-string v5, "android.intent.action.VIEW"

    invoke-direct {v4, v5, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v4}, Lsh/sth/skylink/ActivationActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 105
    .end local v0    # "uri":Landroid/net/Uri;
    .end local v1    # "state":Ljava/lang/String;
    .end local v2    # "verifier":Ljava/lang/String;
    .end local v3    # "challenge":Ljava/lang/String;
    goto :goto_0

    .line 103
    :catch_0
    move-exception v0

    .line 104
    .local v0, "ignored":Ljava/lang/Exception;
    const-string v1, "\u0e22\u0e31\u0e07\u0e40\u0e1b\u0e34\u0e14\u0e2b\u0e19\u0e49\u0e32\u0e01\u0e32\u0e23\u0e22\u0e37\u0e19\u0e22\u0e31\u0e19\u0e44\u0e21\u0e48\u0e44\u0e14\u0e49"

    const/4 v2, 0x1

    invoke-static {p0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 106
    .end local v0    # "ignored":Ljava/lang/Exception;
    :goto_0
    invoke-virtual {p0}, Lsh/sth/skylink/ActivationActivity;->finish()V

    .line 107
    return-void
.end method

.method static capability(Landroid/content/Context;)Ljava/lang/String;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .line 174
    const-string v0, "activation"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 175
    .local v0, "prefs":Landroid/content/SharedPreferences;
    const-wide/16 v1, 0x0

    const-string v3, "expiry"

    invoke-interface {v0, v3, v1, v2}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    cmp-long v1, v1, v4

    const-string v2, "capability"

    const/4 v4, 0x0

    if-gtz v1, :cond_0

    .line 176
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1, v3}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 177
    return-object v4

    .line 179
    :cond_0
    invoke-interface {v0, v2, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 180
    .local v1, "value":Ljava/lang/String;
    if-eqz v1, :cond_1

    const-string v2, "ctcap1."

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    move-object v4, v1

    :cond_1
    return-object v4
.end method

.method private exchange(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 6
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "verifier"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 110
    new-instance v0, Ljava/net/URL;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget v2, Lsh/sth/skylink/R$string;->api_base:I

    .line 111
    invoke-virtual {p0, v2}, Lsh/sth/skylink/ActivationActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/activate/exchange"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 112
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 114
    .local v0, "connection":Ljava/net/HttpURLConnection;
    :try_start_0
    const-string v1, "POST"

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 115
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 116
    const/16 v1, 0x1f40

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 117
    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 118
    const-string v1, "Content-Type"

    const-string v2, "application/json"

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    const-string v1, "X-API-Key"

    sget v2, Lsh/sth/skylink/R$string;->api_key:I

    invoke-virtual {p0, v2}, Lsh/sth/skylink/ActivationActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    invoke-static {v0, p0}, Lsh/sth/skylink/AppRequestProfile;->apply(Ljava/net/HttpURLConnection;Landroid/content/Context;)V

    .line 121
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    const-string v2, "code"

    invoke-virtual {v1, v2, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "verifier"

    invoke-virtual {v1, v2, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    move-result-object v1

    .line 122
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {v1, v2}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v1

    .line 123
    .local v1, "body":[B
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/io/OutputStream;->write([B)V

    .line 124
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v2

    const/16 v3, 0xc8

    if-ne v2, v3, :cond_1

    .line 128
    new-instance v2, Ljava/io/BufferedReader;

    new-instance v3, Ljava/io/InputStreamReader;

    .line 129
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v4

    sget-object v5, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v3, v4, v5}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    invoke-direct {v2, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    .line 131
    .local v2, "reader":Ljava/io/BufferedReader;
    :try_start_1
    invoke-virtual {v2}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 132
    .local v3, "response":Ljava/lang/String;
    :try_start_2
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V

    .line 133
    .end local v2    # "reader":Ljava/io/BufferedReader;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v4, 0x1000

    if-gt v2, v4, :cond_0

    .line 136
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 138
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 136
    return-object v2

    .line 134
    :cond_0
    :try_start_3
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v4, "invalid response"

    invoke-direct {v2, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 128
    .end local v3    # "response":Ljava/lang/String;
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local v2    # "reader":Ljava/io/BufferedReader;
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :catchall_0
    move-exception v3

    :try_start_4
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    goto :goto_0

    :catchall_1
    move-exception v4

    :try_start_5
    invoke-virtual {v3, v4}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    :goto_0
    throw v3

    .line 125
    .end local v2    # "reader":Ljava/io/BufferedReader;
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :cond_1
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "exchange rejected"

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    throw v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 138
    .end local v1    # "body":[B
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :catchall_2
    move-exception v1

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 139
    throw v1
.end method

.method private handle(Landroid/content/Intent;)V
    .locals 7
    .param p1, "intent"    # Landroid/content/Intent;

    .line 47
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    .line 48
    .local v0, "callback":Landroid/net/Uri;
    const/4 v1, 0x0

    if-nez v0, :cond_0

    move-object v2, v1

    goto :goto_0

    :cond_0
    const-string v2, "code"

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 49
    .local v2, "code":Ljava/lang/String;
    :goto_0
    if-nez v2, :cond_1

    .line 50
    invoke-direct {p0}, Lsh/sth/skylink/ActivationActivity;->begin()V

    .line 51
    return-void

    .line 53
    :cond_1
    const-string v3, "thctt-mob02"

    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    const-string v3, "activate"

    invoke-virtual {v0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    goto :goto_2

    .line 57
    :cond_2
    const-string v3, "state"

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 58
    .local v4, "state":Ljava/lang/String;
    iget-object v5, p0, Lsh/sth/skylink/ActivationActivity;->prefs:Landroid/content/SharedPreferences;

    const-string v6, "verifier"

    invoke-interface {v5, v6, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 59
    .local v5, "verifier":Ljava/lang/String;
    if-eqz v4, :cond_4

    iget-object v6, p0, Lsh/sth/skylink/ActivationActivity;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v6, v3, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    if-nez v5, :cond_3

    goto :goto_1

    .line 64
    :cond_3
    new-instance v1, Ljava/lang/Thread;

    new-instance v3, Lsh/sth/skylink/ActivationActivity$$ExternalSyntheticLambda0;

    invoke-direct {v3, p0, v2, v5}, Lsh/sth/skylink/ActivationActivity$$ExternalSyntheticLambda0;-><init>(Lsh/sth/skylink/ActivationActivity;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v1, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 88
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 89
    return-void

    .line 60
    :cond_4
    :goto_1
    invoke-virtual {p0}, Lsh/sth/skylink/ActivationActivity;->finish()V

    .line 61
    return-void

    .line 54
    .end local v4    # "state":Ljava/lang/String;
    .end local v5    # "verifier":Ljava/lang/String;
    :cond_5
    :goto_2
    invoke-virtual {p0}, Lsh/sth/skylink/ActivationActivity;->finish()V

    .line 55
    return-void
.end method

.method private synthetic lambda$handle$0()V
    .locals 2

    .line 79
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lsh/sth/skylink/MainActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lsh/sth/skylink/ActivationActivity;->startActivity(Landroid/content/Intent;)V

    .line 80
    invoke-virtual {p0}, Lsh/sth/skylink/ActivationActivity;->finish()V

    .line 81
    return-void
.end method

.method private synthetic lambda$handle$1()V
    .locals 2

    .line 84
    const-string v0, "\u0e22\u0e31\u0e07\u0e40\u0e1b\u0e34\u0e14\u0e43\u0e0a\u0e49\u0e07\u0e32\u0e19\u0e44\u0e21\u0e48\u0e44\u0e14\u0e49 \u0e01\u0e23\u0e38\u0e13\u0e32\u0e25\u0e2d\u0e07\u0e43\u0e2b\u0e21\u0e48"

    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 85
    invoke-virtual {p0}, Lsh/sth/skylink/ActivationActivity;->finish()V

    .line 86
    return-void
.end method

.method private synthetic lambda$handle$2(Ljava/lang/String;Ljava/lang/String;)V
    .locals 10
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "verifier"    # Ljava/lang/String;

    .line 66
    const-string v0, "capability"

    :try_start_0
    invoke-direct {p0, p1, p2}, Lsh/sth/skylink/ActivationActivity;->exchange(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 67
    .local v1, "response":Lorg/json/JSONObject;
    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 68
    .local v2, "capability":Ljava/lang/String;
    const-string v3, "expires_in"

    const-wide/16 v4, 0xe10

    invoke-virtual {v1, v3, v4, v5}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J

    move-result-wide v6

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v3

    const-wide/16 v5, 0x3c

    invoke-static {v5, v6, v3, v4}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v3

    .line 69
    .local v3, "expiresIn":J
    const-string v5, "ctcap1."

    invoke-virtual {v2, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 72
    iget-object v5, p0, Lsh/sth/skylink/ActivationActivity;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    .line 73
    invoke-interface {v5, v0, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v5, "expiry"

    .line 74
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    const-wide/16 v8, 0x3e8

    mul-long/2addr v8, v3

    add-long/2addr v6, v8

    const-wide/16 v8, 0x2710

    sub-long/2addr v6, v8

    invoke-interface {v0, v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v5, "state"

    .line 75
    invoke-interface {v0, v5}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v5, "verifier"

    .line 76
    invoke-interface {v0, v5}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 77
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 78
    new-instance v0, Lsh/sth/skylink/ActivationActivity$$ExternalSyntheticLambda1;

    invoke-direct {v0, p0}, Lsh/sth/skylink/ActivationActivity$$ExternalSyntheticLambda1;-><init>(Lsh/sth/skylink/ActivationActivity;)V

    invoke-virtual {p0, v0}, Lsh/sth/skylink/ActivationActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 87
    .end local v1    # "response":Lorg/json/JSONObject;
    .end local v2    # "capability":Ljava/lang/String;
    .end local v3    # "expiresIn":J
    goto :goto_0

    .line 70
    .restart local v1    # "response":Lorg/json/JSONObject;
    .restart local v2    # "capability":Ljava/lang/String;
    .restart local v3    # "expiresIn":J
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v5, "invalid capability"

    invoke-direct {v0, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    throw v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    .end local v1    # "response":Lorg/json/JSONObject;
    .end local v2    # "capability":Ljava/lang/String;
    .end local v3    # "expiresIn":J
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 83
    .local v0, "ignored":Ljava/lang/Exception;
    new-instance v1, Lsh/sth/skylink/ActivationActivity$$ExternalSyntheticLambda2;

    invoke-direct {v1, p0}, Lsh/sth/skylink/ActivationActivity$$ExternalSyntheticLambda2;-><init>(Lsh/sth/skylink/ActivationActivity;)V

    invoke-virtual {p0, v1}, Lsh/sth/skylink/ActivationActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 88
    .end local v0    # "ignored":Ljava/lang/Exception;
    :goto_0
    return-void
.end method

.method private static random(I)Ljava/lang/String;
    .locals 2
    .param p0, "size"    # I

    .line 184
    new-array v0, p0, [B

    .line 185
    .local v0, "value":[B
    sget-object v1, Lsh/sth/skylink/ActivationActivity;->RANDOM:Ljava/security/SecureRandom;

    invoke-virtual {v1, v0}, Ljava/security/SecureRandom;->nextBytes([B)V

    .line 186
    invoke-static {v0}, Lsh/sth/skylink/ActivationActivity;->b64([B)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "state"    # Landroid/os/Bundle;

    .line 31
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 32
    const-string v0, "activation"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lsh/sth/skylink/ActivationActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lsh/sth/skylink/ActivationActivity;->prefs:Landroid/content/SharedPreferences;

    .line 33
    new-instance v0, Landroid/widget/TextView;

    invoke-direct {v0, p0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 34
    .local v0, "progress":Landroid/widget/TextView;
    const-string v1, "\u0e01\u0e33\u0e25\u0e31\u0e07\u0e22\u0e37\u0e19\u0e22\u0e31\u0e19\u0e01\u0e32\u0e23\u0e40\u0e1b\u0e34\u0e14\u0e43\u0e0a\u0e49\u0e07\u0e32\u0e19\u2026"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 35
    invoke-virtual {p0, v0}, Lsh/sth/skylink/ActivationActivity;->setContentView(Landroid/view/View;)V

    .line 36
    invoke-virtual {p0}, Lsh/sth/skylink/ActivationActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-direct {p0, v1}, Lsh/sth/skylink/ActivationActivity;->handle(Landroid/content/Intent;)V

    .line 37
    return-void
.end method

.method public onNewIntent(Landroid/content/Intent;)V
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .line 41
    invoke-super {p0, p1}, Landroid/app/Activity;->onNewIntent(Landroid/content/Intent;)V

    .line 42
    invoke-virtual {p0, p1}, Lsh/sth/skylink/ActivationActivity;->setIntent(Landroid/content/Intent;)V

    .line 43
    invoke-direct {p0, p1}, Lsh/sth/skylink/ActivationActivity;->handle(Landroid/content/Intent;)V

    .line 44
    return-void
.end method
