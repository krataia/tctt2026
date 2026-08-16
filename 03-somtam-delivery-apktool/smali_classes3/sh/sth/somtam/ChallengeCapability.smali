.class public final Lsh/sth/somtam/ChallengeCapability;
.super Ljava/lang/Object;
.source "ActivationActivity.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nActivationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivationActivity.kt\nsh/sth/somtam/ChallengeCapability\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,171:1\n1#2:172\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"
    }
    d2 = {
        "Lsh/sth/somtam/ChallengeCapability;",
        "",
        "()V",
        "EXPIRY_SAFETY_MS",
        "",
        "PREFS",
        "",
        "activationRequired",
        "",
        "context",
        "Landroid/content/Context;",
        "clear",
        "",
        "get",
        "launch",
        "store",
        "capability",
        "expiresInSeconds",
        "app_debug"
    }
    k = 0x1
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field private static final EXPIRY_SAFETY_MS:J = 0x2710L

.field public static final INSTANCE:Lsh/sth/somtam/ChallengeCapability;

.field private static final PREFS:Ljava/lang/String; = "challenge_access"


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lsh/sth/somtam/ChallengeCapability;

    invoke-direct {v0}, Lsh/sth/somtam/ChallengeCapability;-><init>()V

    sput-object v0, Lsh/sth/somtam/ChallengeCapability;->INSTANCE:Lsh/sth/somtam/ChallengeCapability;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final activationRequired(Landroid/content/Context;)Z
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 49
    new-instance v0, Ljava/net/URL;

    sget v1, Lsh/sth/somtam/R$string;->api_base_url:I

    invoke-virtual {p1, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/activation/status"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 50
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 49
    const-string v1, "null cannot be cast to non-null type java.net.HttpURLConnection"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 51
    .local v0, "connection":Ljava/net/HttpURLConnection;
    nop

    .line 52
    const/16 v1, 0x1f40

    :try_start_0
    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 53
    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 54
    const-string v1, "X-API-Key"

    sget v2, Lsh/sth/somtam/R$string;->api_key:I

    invoke-virtual {p1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    sget-object v1, Lsh/sth/somtam/AppRequestProfile;->INSTANCE:Lsh/sth/somtam/AppRequestProfile;

    invoke-virtual {v1, v0, p1}, Lsh/sth/somtam/AppRequestProfile;->apply(Ljava/net/HttpURLConnection;Landroid/content/Context;)V

    .line 56
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    const/16 v2, 0xc8

    const/4 v3, 0x0

    if-gt v2, v1, :cond_0

    const/16 v2, 0x12c

    if-ge v1, v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    move v1, v3

    :goto_0
    if-eqz v1, :cond_2

    .line 57
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    const-string v2, "getInputStream(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v2, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    new-instance v4, Ljava/io/InputStreamReader;

    invoke-direct {v4, v1, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    check-cast v4, Ljava/io/Reader;

    instance-of v1, v4, Ljava/io/BufferedReader;

    if-eqz v1, :cond_1

    check-cast v4, Ljava/io/BufferedReader;

    goto :goto_1

    :cond_1
    new-instance v1, Ljava/io/BufferedReader;

    const/16 v2, 0x2000

    invoke-direct {v1, v4, v2}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V

    move-object v4, v1

    :goto_1
    check-cast v4, Ljava/io/Closeable;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    :try_start_1
    move-object v1, v4

    check-cast v1, Ljava/io/BufferedReader;

    .line 172
    .local v1, "it":Ljava/io/BufferedReader;
    const/4 v2, 0x0

    .line 57
    .local v2, "$i$a$-use-ChallengeCapability$activationRequired$body$1":I
    move-object v5, v1

    check-cast v5, Ljava/io/Reader;

    invoke-static {v5}, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;

    move-result-object v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .end local v1    # "it":Ljava/io/BufferedReader;
    .end local v2    # "$i$a$-use-ChallengeCapability$activationRequired$body$1":I
    const/4 v1, 0x0

    :try_start_2
    invoke-static {v4, v1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    move-object v1, v5

    .line 58
    .local v1, "body":Ljava/lang/String;
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v4, "required"

    invoke-virtual {v2, v4, v3}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;Z)Z

    move-result v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 60
    .end local v1    # "body":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 61
    nop

    .line 51
    return v2

    .line 57
    :catchall_0
    move-exception v1

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "context":Landroid/content/Context;
    :try_start_3
    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "context":Landroid/content/Context;
    :catchall_1
    move-exception v2

    :try_start_4
    invoke-static {v4, v1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "context":Landroid/content/Context;
    throw v2

    .line 56
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "context":Landroid/content/Context;
    :cond_2
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "activation status unavailable"

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "context":Landroid/content/Context;
    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 60
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "context":Landroid/content/Context;
    :catchall_2
    move-exception v1

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    throw v1
.end method

.method public final clear(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 32
    const-string v0, "challenge_access"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 33
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "capability"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "expires_at_ms"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 34
    return-void
.end method

.method public final get(Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 23
    const-string v0, "challenge_access"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 24
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const-string v1, "expires_at_ms"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    cmp-long v1, v1, v3

    const/4 v2, 0x0

    if-gtz v1, :cond_0

    .line 25
    invoke-virtual {p0, p1}, Lsh/sth/somtam/ChallengeCapability;->clear(Landroid/content/Context;)V

    .line 26
    return-object v2

    .line 28
    :cond_0
    const-string v1, "capability"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public final launch(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 65
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lsh/sth/somtam/ActivationActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 66
    return-void
.end method

.method public final store(Landroid/content/Context;Ljava/lang/String;J)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "capability"    # Ljava/lang/String;
    .param p3, "expiresInSeconds"    # J

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "capability"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 37
    const/4 v1, 0x2

    const/4 v2, 0x0

    const-string v3, "ctcap1."

    const/4 v4, 0x0

    invoke-static {p2, v3, v4, v1, v2}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 38
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v5, 0x3e8

    mul-long/2addr v5, p3

    add-long/2addr v1, v5

    const-wide/16 v5, 0x2710

    sub-long/2addr v1, v5

    .line 39
    .local v1, "expiresAt":J
    const-string v3, "challenge_access"

    invoke-virtual {p1, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    .line 40
    invoke-interface {v3, v0, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 41
    const-string v3, "expires_at_ms"

    invoke-interface {v0, v3, v1, v2}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 42
    const-string v3, "pending_state"

    invoke-interface {v0, v3}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 43
    const-string v3, "pkce_verifier"

    invoke-interface {v0, v3}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 44
    const-string v3, "pending_at_ms"

    invoke-interface {v0, v3}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 45
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 46
    return-void

    .line 37
    .end local v1    # "expiresAt":J
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Failed requirement."

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
