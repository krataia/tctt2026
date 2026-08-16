.class public final Lsh/sth/somtam/ActivationActivity;
.super Landroid/app/Activity;
.source "ActivationActivity.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nActivationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivationActivity.kt\nsh/sth/somtam/ActivationActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,171:1\n1#2:172\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u000f2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0016H\u0014J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\u0006\u0010\u0007\u00a8\u0006\u001f"
    }
    d2 = {
        "Lsh/sth/somtam/ActivationActivity;",
        "Landroid/app/Activity;",
        "()V",
        "preferences",
        "Landroid/content/SharedPreferences;",
        "kotlin.jvm.PlatformType",
        "getPreferences",
        "()Landroid/content/SharedPreferences;",
        "preferences$delegate",
        "Lkotlin/Lazy;",
        "base64",
        "",
        "value",
        "",
        "beginActivation",
        "",
        "exchange",
        "Lorg/json/JSONObject;",
        "code",
        "verifier",
        "handle",
        "incoming",
        "Landroid/content/Intent;",
        "onCreate",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onNewIntent",
        "intent",
        "randomBase64",
        "size",
        "",
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


# instance fields
.field private final preferences$delegate:Lkotlin/Lazy;


# direct methods
.method public static synthetic $r8$lambda$aiP3wv_FYvb7gSzyjPMQFzq-r6c(Lsh/sth/somtam/ActivationActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-static {p0, p1, p2}, Lsh/sth/somtam/ActivationActivity;->handle$lambda$1(Lsh/sth/somtam/ActivationActivity;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 73
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 74
    new-instance v0, Lsh/sth/somtam/ActivationActivity$preferences$2;

    invoke-direct {v0, p0}, Lsh/sth/somtam/ActivationActivity$preferences$2;-><init>(Lsh/sth/somtam/ActivationActivity;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    invoke-static {v0}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    iput-object v0, p0, Lsh/sth/somtam/ActivationActivity;->preferences$delegate:Lkotlin/Lazy;

    .line 73
    return-void
.end method

.method private final base64([B)Ljava/lang/String;
    .locals 2
    .param p1, "value"    # [B

    .line 169
    const/16 v0, 0xb

    invoke-static {p1, v0}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v0

    const-string v1, "encodeToString(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v0
.end method

.method private final beginActivation()V
    .locals 8

    .line 129
    const/16 v0, 0x20

    invoke-direct {p0, v0}, Lsh/sth/somtam/ActivationActivity;->randomBase64(I)Ljava/lang/String;

    move-result-object v0

    .line 130
    .local v0, "state":Ljava/lang/String;
    const/16 v1, 0x30

    invoke-direct {p0, v1}, Lsh/sth/somtam/ActivationActivity;->randomBase64(I)Ljava/lang/String;

    move-result-object v1

    .line 131
    .local v1, "verifier":Ljava/lang/String;
    const-string v2, "SHA-256"

    invoke-static {v2}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v2

    sget-object v3, Lkotlin/text/Charsets;->US_ASCII:Ljava/nio/charset/Charset;

    invoke-virtual {v1, v3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v3

    const-string v4, "getBytes(...)"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v2

    .line 132
    .local v2, "digest":[B
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-direct {p0, v2}, Lsh/sth/somtam/ActivationActivity;->base64([B)Ljava/lang/String;

    move-result-object v3

    .line 133
    .local v3, "challenge":Ljava/lang/String;
    invoke-direct {p0}, Lsh/sth/somtam/ActivationActivity;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v4

    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    .line 134
    const-string v5, "pending_state"

    invoke-interface {v4, v5, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    .line 135
    const-string v5, "pkce_verifier"

    invoke-interface {v4, v5, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    .line 136
    const-string v5, "pending_at_ms"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-interface {v4, v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    .line 137
    invoke-interface {v4}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 138
    sget v4, Lsh/sth/somtam/R$string;->api_base_url:I

    invoke-virtual {p0, v4}, Lsh/sth/somtam/ActivationActivity;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

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

    .line 139
    const-string v5, "state"

    invoke-virtual {v4, v5, v0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v4

    .line 140
    const-string v5, "code_challenge"

    invoke-virtual {v4, v5, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v4

    .line 141
    invoke-virtual {v4}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v4

    .line 138
    nop

    .line 142
    .local v4, "uri":Landroid/net/Uri;
    new-instance v5, Landroid/content/Intent;

    const-string v6, "android.intent.action.VIEW"

    invoke-direct {v5, v6, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v5}, Lsh/sth/somtam/ActivationActivity;->startActivity(Landroid/content/Intent;)V

    .line 143
    invoke-virtual {p0}, Lsh/sth/somtam/ActivationActivity;->finish()V

    .line 144
    return-void
.end method

.method private final exchange(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 9
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "verifier"    # Ljava/lang/String;

    .line 147
    new-instance v0, Ljava/net/URL;

    sget v1, Lsh/sth/somtam/R$string;->api_base_url:I

    invoke-virtual {p0, v1}, Lsh/sth/somtam/ActivationActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/activate/exchange"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 148
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 147
    const-string v1, "null cannot be cast to non-null type java.net.HttpURLConnection"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 149
    .local v0, "connection":Ljava/net/HttpURLConnection;
    nop

    .line 150
    :try_start_0
    const-string v1, "POST"

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 151
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 152
    const/16 v2, 0x1f40

    invoke-virtual {v0, v2}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 153
    invoke-virtual {v0, v2}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 154
    const-string v2, "Content-Type"

    const-string v3, "application/json"

    invoke-virtual {v0, v2, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    const-string v2, "X-API-Key"

    sget v3, Lsh/sth/somtam/R$string;->api_key:I

    invoke-virtual {p0, v3}, Lsh/sth/somtam/ActivationActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    sget-object v2, Lsh/sth/somtam/AppRequestProfile;->INSTANCE:Lsh/sth/somtam/AppRequestProfile;

    move-object v3, p0

    check-cast v3, Landroid/content/Context;

    invoke-virtual {v2, v0, v3}, Lsh/sth/somtam/AppRequestProfile;->apply(Ljava/net/HttpURLConnection;Landroid/content/Context;)V

    .line 157
    new-instance v2, Lorg/json/JSONObject;

    const/4 v3, 0x2

    new-array v3, v3, [Lkotlin/Pair;

    const-string v4, "code"

    invoke-static {v4, p1}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v4

    const/4 v5, 0x0

    aput-object v4, v3, v5

    const-string v4, "verifier"

    invoke-static {v4, p2}, Lkotlin/TuplesKt;->to(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;

    move-result-object v4

    aput-object v4, v3, v1

    invoke-static {v3}, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "toString(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 158
    .local v2, "body":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v3

    check-cast v3, Ljava/io/Closeable;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_4

    :try_start_1
    move-object v4, v3

    check-cast v4, Ljava/io/OutputStream;

    .line 172
    .local v4, "it":Ljava/io/OutputStream;
    const/4 v6, 0x0

    .line 158
    .local v6, "$i$a$-use-ActivationActivity$exchange$1":I
    sget-object v7, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-virtual {v2, v7}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v7

    const-string v8, "getBytes(...)"

    invoke-static {v7, v8}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v4, v7}, Ljava/io/OutputStream;->write([B)V

    .end local v4    # "it":Ljava/io/OutputStream;
    .end local v6    # "$i$a$-use-ActivationActivity$exchange$1":I
    sget-object v4, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    const/4 v4, 0x0

    :try_start_2
    invoke-static {v3, v4}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    .line 159
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v3

    const/16 v6, 0xc8

    if-gt v6, v3, :cond_0

    const/16 v6, 0x12c

    if-ge v3, v6, :cond_0

    goto :goto_0

    :cond_0
    move v1, v5

    :goto_0
    if-eqz v1, :cond_2

    .line 160
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    const-string v3, "getInputStream(...)"

    invoke-static {v1, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v3, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    new-instance v5, Ljava/io/InputStreamReader;

    invoke-direct {v5, v1, v3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    check-cast v5, Ljava/io/Reader;

    instance-of v1, v5, Ljava/io/BufferedReader;

    if-eqz v1, :cond_1

    check-cast v5, Ljava/io/BufferedReader;

    goto :goto_1

    :cond_1
    new-instance v1, Ljava/io/BufferedReader;

    const/16 v3, 0x2000

    invoke-direct {v1, v5, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V

    move-object v5, v1

    :goto_1
    check-cast v5, Ljava/io/Closeable;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_4

    :try_start_3
    move-object v1, v5

    check-cast v1, Ljava/io/BufferedReader;

    .line 172
    .local v1, "it":Ljava/io/BufferedReader;
    const/4 v3, 0x0

    .line 160
    .local v3, "$i$a$-use-ActivationActivity$exchange$2":I
    move-object v6, v1

    check-cast v6, Ljava/io/Reader;

    invoke-static {v6}, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;

    move-result-object v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .end local v1    # "it":Ljava/io/BufferedReader;
    .end local v3    # "$i$a$-use-ActivationActivity$exchange$2":I
    :try_start_4
    invoke-static {v5, v4}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v6}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_4

    .line 162
    .end local v2    # "body":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 163
    nop

    .line 149
    return-object v1

    .line 160
    .restart local v2    # "body":Ljava/lang/String;
    :catchall_0
    move-exception v1

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local v2    # "body":Ljava/lang/String;
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    :try_start_5
    throw v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local v2    # "body":Ljava/lang/String;
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :catchall_1
    move-exception v3

    :try_start_6
    invoke-static {v5, v1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    throw v3

    .line 159
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :cond_2
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v3, "activation exchange rejected"

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    throw v1
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_4

    .line 158
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :catchall_2
    move-exception v1

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local v2    # "body":Ljava/lang/String;
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    :try_start_7
    throw v1
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local v2    # "body":Ljava/lang/String;
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :catchall_3
    move-exception v4

    :try_start_8
    invoke-static {v3, v1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    throw v4
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_4

    .line 162
    .end local v2    # "body":Ljava/lang/String;
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :catchall_4
    move-exception v1

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    throw v1
.end method

.method private final getPreferences()Landroid/content/SharedPreferences;
    .locals 1

    .line 74
    iget-object v0, p0, Lsh/sth/somtam/ActivationActivity;->preferences$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/SharedPreferences;

    return-object v0
.end method

.method private final handle(Landroid/content/Intent;)V
    .locals 11
    .param p1, "incoming"    # Landroid/content/Intent;

    .line 88
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    .line 89
    .local v0, "callback":Landroid/net/Uri;
    if-nez v0, :cond_0

    .line 90
    invoke-direct {p0}, Lsh/sth/somtam/ActivationActivity;->beginActivation()V

    .line 91
    return-void

    .line 93
    :cond_0
    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    const-string v2, "thctt-mob03"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    invoke-virtual {v0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v1

    const-string v2, "activate"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    goto :goto_1

    .line 97
    :cond_1
    const-string v1, "code"

    invoke-virtual {v0, v1}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_2

    invoke-virtual {p0}, Lsh/sth/somtam/ActivationActivity;->finish()V

    return-void

    .line 98
    .local v1, "code":Ljava/lang/String;
    :cond_2
    const-string v2, "state"

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_3

    invoke-virtual {p0}, Lsh/sth/somtam/ActivationActivity;->finish()V

    return-void

    .line 99
    .local v2, "returnedState":Ljava/lang/String;
    :cond_3
    invoke-direct {p0}, Lsh/sth/somtam/ActivationActivity;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "pending_state"

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_4

    invoke-virtual {p0}, Lsh/sth/somtam/ActivationActivity;->finish()V

    return-void

    .line 100
    .local v3, "expectedState":Ljava/lang/String;
    :cond_4
    invoke-direct {p0}, Lsh/sth/somtam/ActivationActivity;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v4

    const-string v6, "pkce_verifier"

    invoke-interface {v4, v6, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_5

    invoke-virtual {p0}, Lsh/sth/somtam/ActivationActivity;->finish()V

    return-void

    .line 101
    .local v4, "verifier":Ljava/lang/String;
    :cond_5
    invoke-direct {p0}, Lsh/sth/somtam/ActivationActivity;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v5

    const-string v6, "pending_at_ms"

    const-wide/16 v7, 0x0

    invoke-interface {v5, v6, v7, v8}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v5

    .line 102
    .local v5, "pendingAt":J
    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_7

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    sub-long/2addr v7, v5

    const-wide/32 v9, 0x493e0

    cmp-long v7, v7, v9

    if-lez v7, :cond_6

    goto :goto_0

    .line 107
    :cond_6
    new-instance v7, Ljava/lang/Thread;

    .line 125
    new-instance v8, Lsh/sth/somtam/ActivationActivity$$ExternalSyntheticLambda0;

    invoke-direct {v8, p0, v1, v4}, Lsh/sth/somtam/ActivationActivity$$ExternalSyntheticLambda0;-><init>(Lsh/sth/somtam/ActivationActivity;Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    invoke-direct {v7, v8}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 125
    invoke-virtual {v7}, Ljava/lang/Thread;->start()V

    .line 126
    return-void

    .line 103
    :cond_7
    :goto_0
    invoke-virtual {p0}, Lsh/sth/somtam/ActivationActivity;->finish()V

    .line 104
    return-void

    .line 94
    .end local v1    # "code":Ljava/lang/String;
    .end local v2    # "returnedState":Ljava/lang/String;
    .end local v3    # "expectedState":Ljava/lang/String;
    .end local v4    # "verifier":Ljava/lang/String;
    .end local v5    # "pendingAt":J
    :cond_8
    :goto_1
    invoke-virtual {p0}, Lsh/sth/somtam/ActivationActivity;->finish()V

    .line 95
    return-void
.end method

.method private static final handle$lambda$1(Lsh/sth/somtam/ActivationActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p0, "this$0"    # Lsh/sth/somtam/ActivationActivity;
    .param p1, "$code"    # Ljava/lang/String;
    .param p2, "$verifier"    # Ljava/lang/String;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$code"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$verifier"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 108
    nop

    .line 109
    :try_start_0
    invoke-direct {p0, p1, p2}, Lsh/sth/somtam/ActivationActivity;->exchange(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 110
    .local v0, "response":Lorg/json/JSONObject;
    sget-object v1, Lsh/sth/somtam/ChallengeCapability;->INSTANCE:Lsh/sth/somtam/ChallengeCapability;

    .line 111
    move-object v2, p0

    check-cast v2, Landroid/content/Context;

    .line 112
    const-string v3, "capability"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "getString(...)"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 113
    const-string v4, "expires_in"

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    .line 110
    invoke-virtual {v1, v2, v3, v4, v5}, Lsh/sth/somtam/ChallengeCapability;->store(Landroid/content/Context;Ljava/lang/String;J)V

    .line 115
    nop

    .line 116
    new-instance v1, Landroid/content/Intent;

    move-object v2, p0

    check-cast v2, Landroid/content/Context;

    const-class v3, Lsh/sth/somtam/MainActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object v2, v1

    .local v2, "$this$handle_u24lambda_u241_u24lambda_u240":Landroid/content/Intent;
    const/4 v3, 0x0

    .line 117
    .local v3, "$i$a$-apply-ActivationActivity$handle$1$1":I
    const/high16 v4, 0x24000000

    invoke-virtual {v2, v4}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 118
    nop

    .line 116
    .end local v2    # "$this$handle_u24lambda_u241_u24lambda_u240":Landroid/content/Intent;
    .end local v3    # "$i$a$-apply-ActivationActivity$handle$1$1":I
    nop

    .line 115
    invoke-virtual {p0, v1}, Lsh/sth/somtam/ActivationActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .end local v0    # "response":Lorg/json/JSONObject;
    goto :goto_0

    .line 123
    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lsh/sth/somtam/ActivationActivity;->finish()V

    throw v0

    .line 120
    :catch_0
    move-exception v0

    .line 123
    :goto_0
    invoke-virtual {p0}, Lsh/sth/somtam/ActivationActivity;->finish()V

    .line 124
    nop

    .line 125
    return-void
.end method

.method private final randomBase64(I)Ljava/lang/String;
    .locals 4
    .param p1, "size"    # I

    .line 166
    new-array v0, p1, [B

    .line 172
    move-object v1, v0

    .local v1, "it":[B
    const/4 v2, 0x0

    .line 166
    .local v2, "$i$a$-also-ActivationActivity$randomBase64$1":I
    new-instance v3, Ljava/security/SecureRandom;

    invoke-direct {v3}, Ljava/security/SecureRandom;-><init>()V

    invoke-virtual {v3, v1}, Ljava/security/SecureRandom;->nextBytes([B)V

    .end local v1    # "it":[B
    .end local v2    # "$i$a$-also-ActivationActivity$randomBase64$1":I
    invoke-direct {p0, v0}, Lsh/sth/somtam/ActivationActivity;->base64([B)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 77
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 78
    invoke-virtual {p0}, Lsh/sth/somtam/ActivationActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "getIntent(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lsh/sth/somtam/ActivationActivity;->handle(Landroid/content/Intent;)V

    .line 79
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    const-string v0, "intent"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 82
    invoke-super {p0, p1}, Landroid/app/Activity;->onNewIntent(Landroid/content/Intent;)V

    .line 83
    invoke-virtual {p0, p1}, Lsh/sth/somtam/ActivationActivity;->setIntent(Landroid/content/Intent;)V

    .line 84
    invoke-direct {p0, p1}, Lsh/sth/somtam/ActivationActivity;->handle(Landroid/content/Intent;)V

    .line 85
    return-void
.end method
