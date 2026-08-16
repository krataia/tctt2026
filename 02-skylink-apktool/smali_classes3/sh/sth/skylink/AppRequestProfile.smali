.class public final Lsh/sth/skylink/AppRequestProfile;
.super Ljava/lang/Object;
.source "AppRequestProfile.java"


# static fields
.field public static final APP_ID:Ljava/lang/String; = "sh.sth.skylink"

.field public static final APP_VERSION:Ljava/lang/String; = "1"

.field private static final INSTALL_ID:Ljava/lang/String; = "install_id_v1"

.field private static final PREFS:Ljava/lang/String; = "request_profile"

.field private static final RANDOM:Ljava/security/SecureRandom;

.field public static final USER_AGENT:Ljava/lang/String; = "THCTT-Mobile02/1 (Android; sh.sth.skylink)"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 19
    new-instance v0, Ljava/security/SecureRandom;

    invoke-direct {v0}, Ljava/security/SecureRandom;-><init>()V

    sput-object v0, Lsh/sth/skylink/AppRequestProfile;->RANDOM:Ljava/security/SecureRandom;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static apply(Ljava/net/HttpURLConnection;Landroid/content/Context;)V
    .locals 2
    .param p0, "connection"    # Ljava/net/HttpURLConnection;
    .param p1, "context"    # Landroid/content/Context;

    .line 57
    const-string v0, "User-Agent"

    const-string v1, "THCTT-Mobile02/1 (Android; sh.sth.skylink)"

    invoke-virtual {p0, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    const-string v0, "X-THCTT-App-ID"

    const-string v1, "sh.sth.skylink"

    invoke-virtual {p0, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    const-string v0, "X-THCTT-App-Version"

    const-string v1, "1"

    invoke-virtual {p0, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    const-string v0, "X-THCTT-Install-ID"

    invoke-static {p1}, Lsh/sth/skylink/AppRequestProfile;->installId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    return-void
.end method

.method public static configure(Landroid/webkit/WebView;)V
    .locals 2
    .param p0, "webView"    # Landroid/webkit/WebView;

    .line 72
    invoke-virtual {p0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    const-string v1, "THCTT-Mobile02/1 (Android; sh.sth.skylink)"

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 73
    return-void
.end method

.method public static declared-synchronized installId(Landroid/content/Context;)Ljava/lang/String;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    const-class v0, Lsh/sth/skylink/AppRequestProfile;

    monitor-enter v0

    .line 24
    :try_start_0
    const-string v1, "request_profile"

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 25
    .local v1, "prefs":Landroid/content/SharedPreferences;
    const-string v3, "install_id_v1"

    const/4 v4, 0x0

    invoke-interface {v1, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 26
    .local v3, "existing":Ljava/lang/String;
    invoke-static {v3}, Lsh/sth/skylink/AppRequestProfile;->isCanonicalInstallId(Ljava/lang/String;)Z

    move-result v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v4, :cond_0

    .line 27
    monitor-exit v0

    return-object v3

    .line 29
    :cond_0
    const/16 v4, 0x10

    :try_start_1
    new-array v4, v4, [B

    .line 30
    .local v4, "bytes":[B
    sget-object v5, Lsh/sth/skylink/AppRequestProfile;->RANDOM:Ljava/security/SecureRandom;

    invoke-virtual {v5, v4}, Ljava/security/SecureRandom;->nextBytes([B)V

    .line 31
    const/16 v5, 0xb

    invoke-static {v4, v5}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v5

    .line 32
    .local v5, "value":Ljava/lang/String;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    const-string v7, "install_id_v1"

    invoke-interface {v6, v7, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 35
    const-string v6, "activation"

    invoke-virtual {p0, v6, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string v6, "capability"

    .line 36
    invoke-interface {v2, v6}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string v6, "expiry"

    invoke-interface {v2, v6}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-eqz v2, :cond_1

    .line 39
    monitor-exit v0

    return-object v5

    .line 37
    :cond_1
    :try_start_2
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v6, "cannot reset bound capability"

    invoke-direct {v2, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 33
    :cond_2
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v6, "cannot persist install profile"

    invoke-direct {v2, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 23
    .end local v1    # "prefs":Landroid/content/SharedPreferences;
    .end local v3    # "existing":Ljava/lang/String;
    .end local v4    # "bytes":[B
    .end local v5    # "value":Ljava/lang/String;
    .end local p0    # "context":Landroid/content/Context;
    :catchall_0
    move-exception p0

    monitor-exit v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw p0
.end method

.method private static isCanonicalInstallId(Ljava/lang/String;)Z
    .locals 5
    .param p0, "value"    # Ljava/lang/String;

    .line 43
    const/4 v0, 0x0

    if-eqz p0, :cond_2

    const-string v1, "[A-Za-z0-9_-]{22}"

    invoke-virtual {p0, v1}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    goto :goto_0

    .line 47
    :cond_0
    const/16 v1, 0xb

    :try_start_0
    invoke-static {p0, v1}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v2

    .line 48
    .local v2, "decoded":[B
    array-length v3, v2

    const/16 v4, 0x10

    if-ne v3, v4, :cond_1

    invoke-static {v2, v1}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    if-eqz v1, :cond_1

    const/4 v0, 0x1

    :cond_1
    return v0

    .line 51
    .end local v2    # "decoded":[B
    :catch_0
    move-exception v1

    .line 52
    .local v1, "ignored":Ljava/lang/IllegalArgumentException;
    return v0

    .line 44
    .end local v1    # "ignored":Ljava/lang/IllegalArgumentException;
    :cond_2
    :goto_0
    return v0
.end method

.method public static webHeaders(Landroid/content/Context;)Ljava/util/Map;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/Map<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 64
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 65
    .local v0, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "X-THCTT-App-ID"

    const-string v2, "sh.sth.skylink"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    const-string v1, "X-THCTT-App-Version"

    const-string v2, "1"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    const-string v1, "X-THCTT-Install-ID"

    invoke-static {p0}, Lsh/sth/skylink/AppRequestProfile;->installId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    return-object v0
.end method
