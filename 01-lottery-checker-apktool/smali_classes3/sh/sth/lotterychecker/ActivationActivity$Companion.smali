.class public final Lsh/sth/lotterychecker/ActivationActivity$Companion;
.super Ljava/lang/Object;
.source "ActivationActivity.kt"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lsh/sth/lotterychecker/ActivationActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Companion"
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nActivationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivationActivity.kt\nsh/sth/lotterychecker/ActivationActivity$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,157:1\n1#2:158\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u000c\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"
    }
    d2 = {
        "Lsh/sth/lotterychecker/ActivationActivity$Companion;",
        "",
        "()V",
        "CALLBACK_HOST",
        "",
        "CALLBACK_SCHEME",
        "PREFS",
        "RANDOM",
        "Ljava/security/SecureRandom;",
        "activationEnabled",
        "",
        "context",
        "Landroid/content/Context;",
        "(Landroid/content/Context;)Ljava/lang/Boolean;",
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


# direct methods
.method private constructor <init>()V
    .locals 0

    .line 120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    .locals 0

    invoke-direct {p0}, Lsh/sth/lotterychecker/ActivationActivity$Companion;-><init>()V

    return-void
.end method


# virtual methods
.method public final activationEnabled(Landroid/content/Context;)Ljava/lang/Boolean;
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 128
    new-instance v0, Ljava/net/URL;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget v2, Lsh/sth/lotterychecker/R$string;->api_base_url:I

    invoke-virtual {p1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/activation/status"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 129
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 128
    const-string v1, "null cannot be cast to non-null type java.net.HttpURLConnection"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 130
    .local v0, "connection":Ljava/net/HttpURLConnection;
    nop

    .line 131
    const/16 v1, 0x1f40

    const/4 v2, 0x0

    :try_start_0
    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 132
    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 133
    const-string v1, "X-API-Key"

    sget v3, Lsh/sth/lotterychecker/R$string;->api_key:I

    invoke-virtual {p1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    sget-object v1, Lsh/sth/lotterychecker/AppRequestProfile;->INSTANCE:Lsh/sth/lotterychecker/AppRequestProfile;

    invoke-virtual {v1, v0, p1}, Lsh/sth/lotterychecker/AppRequestProfile;->apply(Ljava/net/HttpURLConnection;Landroid/content/Context;)V

    .line 135
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    const/16 v3, 0xc8

    if-eq v1, v3, :cond_0

    .line 141
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 135
    return-object v2

    .line 136
    :cond_0
    :try_start_1
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    const-string v3, "getInputStream(...)"

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v3, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    new-instance v4, Ljava/io/InputStreamReader;

    invoke-direct {v4, v1, v3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    check-cast v4, Ljava/io/Reader;

    instance-of v1, v4, Ljava/io/BufferedReader;

    if-eqz v1, :cond_1

    check-cast v4, Ljava/io/BufferedReader;

    goto :goto_0

    :cond_1
    new-instance v1, Ljava/io/BufferedReader;

    const/16 v3, 0x2000

    invoke-direct {v1, v4, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V

    move-object v4, v1

    :goto_0
    check-cast v4, Ljava/io/Closeable;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    :try_start_2
    move-object v1, v4

    check-cast v1, Ljava/io/BufferedReader;

    .line 158
    .local v1, "it":Ljava/io/BufferedReader;
    const/4 v3, 0x0

    .line 136
    .local v3, "$i$a$-use-ActivationActivity$Companion$activationEnabled$response$1":I
    move-object v5, v1

    check-cast v5, Ljava/io/Reader;

    invoke-static {v5}, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;

    move-result-object v5
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .end local v1    # "it":Ljava/io/BufferedReader;
    .end local v3    # "$i$a$-use-ActivationActivity$Companion$activationEnabled$response$1":I
    :try_start_3
    invoke-static {v4, v2}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    move-object v1, v5

    .line 137
    .local v1, "response":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    const/16 v4, 0x1000

    if-le v3, v4, :cond_2

    :goto_1
    goto :goto_2

    :cond_2
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v4, "enabled"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    goto :goto_1

    .line 136
    .end local v1    # "response":Ljava/lang/String;
    :catchall_0
    move-exception v1

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "context":Landroid/content/Context;
    :try_start_4
    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "context":Landroid/content/Context;
    :catchall_1
    move-exception v3

    :try_start_5
    invoke-static {v4, v1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "context":Landroid/content/Context;
    throw v3
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 141
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "context":Landroid/content/Context;
    :catchall_2
    move-exception v1

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    throw v1

    .line 138
    :catch_0
    move-exception v1

    .line 139
    .local v1, "_":Ljava/lang/Exception;
    nop

    .line 141
    .end local v1    # "_":Ljava/lang/Exception;
    :goto_2
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 142
    nop

    .line 130
    return-object v2
.end method
