.class public final Lsh/sth/lotterychecker/ActivationActivity;
.super Landroid/app/Activity;
.source "ActivationActivity.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lsh/sth/lotterychecker/ActivationActivity$Companion;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nActivationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivationActivity.kt\nsh/sth/lotterychecker/ActivationActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,157:1\n1#2:158\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u000f2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0016H\u0014J\u0018\u0010\u001c\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\u000c\u001a\u00020\u001dH\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002\u00a2\u0006\u000c\n\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\u0006\u0010\u0007\u00a8\u0006\u001f"
    }
    d2 = {
        "Lsh/sth/lotterychecker/ActivationActivity;",
        "Landroid/app/Activity;",
        "()V",
        "prefs",
        "Landroid/content/SharedPreferences;",
        "kotlin.jvm.PlatformType",
        "getPrefs",
        "()Landroid/content/SharedPreferences;",
        "prefs$delegate",
        "Lkotlin/Lazy;",
        "b64",
        "",
        "bytes",
        "",
        "begin",
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
        "random",
        "",
        "Companion",
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
.field private static final CALLBACK_HOST:Ljava/lang/String; = "activate"

.field private static final CALLBACK_SCHEME:Ljava/lang/String; = "thctt-mob01"

.field public static final Companion:Lsh/sth/lotterychecker/ActivationActivity$Companion;

.field private static final PREFS:Ljava/lang/String; = "activation"

.field private static final RANDOM:Ljava/security/SecureRandom;


# instance fields
.field private final prefs$delegate:Lkotlin/Lazy;


# direct methods
.method public static synthetic $r8$lambda$Rr9MRIcegIOEjTW2zaoPnxNU0OQ(Lsh/sth/lotterychecker/ActivationActivity;)V
    .locals 0

    invoke-static {p0}, Lsh/sth/lotterychecker/ActivationActivity;->handle$lambda$3$lambda$2(Lsh/sth/lotterychecker/ActivationActivity;)V

    return-void
.end method

.method public static synthetic $r8$lambda$_uGv87Uo89kWohO8PG-dLJx444w(Lsh/sth/lotterychecker/ActivationActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-static {p0, p1, p2}, Lsh/sth/lotterychecker/ActivationActivity;->handle$lambda$3(Lsh/sth/lotterychecker/ActivationActivity;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic $r8$lambda$phWbBUOpxNkS-ZgQuWndImYow7M(Lsh/sth/lotterychecker/ActivationActivity;)V
    .locals 0

    invoke-static {p0}, Lsh/sth/lotterychecker/ActivationActivity;->handle$lambda$3$lambda$1(Lsh/sth/lotterychecker/ActivationActivity;)V

    return-void
.end method

.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lsh/sth/lotterychecker/ActivationActivity$Companion;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lsh/sth/lotterychecker/ActivationActivity$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V

    sput-object v0, Lsh/sth/lotterychecker/ActivationActivity;->Companion:Lsh/sth/lotterychecker/ActivationActivity$Companion;

    .line 124
    new-instance v0, Ljava/security/SecureRandom;

    invoke-direct {v0}, Ljava/security/SecureRandom;-><init>()V

    sput-object v0, Lsh/sth/lotterychecker/ActivationActivity;->RANDOM:Ljava/security/SecureRandom;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 19
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 20
    new-instance v0, Lsh/sth/lotterychecker/ActivationActivity$prefs$2;

    invoke-direct {v0, p0}, Lsh/sth/lotterychecker/ActivationActivity$prefs$2;-><init>(Lsh/sth/lotterychecker/ActivationActivity;)V

    check-cast v0, Lkotlin/jvm/functions/Function0;

    invoke-static {v0}, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;

    move-result-object v0

    iput-object v0, p0, Lsh/sth/lotterychecker/ActivationActivity;->prefs$delegate:Lkotlin/Lazy;

    .line 19
    return-void
.end method

.method private final b64([B)Ljava/lang/String;
    .locals 1
    .param p1, "bytes"    # [B

    .line 116
    nop

    .line 117
    nop

    .line 115
    const/16 v0, 0xb

    invoke-static {p1, v0}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v0

    .line 118
    return-object v0
.end method

.method private final begin()V
    .locals 6

    .line 78
    const/16 v0, 0x20

    invoke-direct {p0, v0}, Lsh/sth/lotterychecker/ActivationActivity;->random(I)Ljava/lang/String;

    move-result-object v0

    .line 79
    .local v0, "state":Ljava/lang/String;
    const/16 v1, 0x30

    invoke-direct {p0, v1}, Lsh/sth/lotterychecker/ActivationActivity;->random(I)Ljava/lang/String;

    move-result-object v1

    .line 80
    .local v1, "verifier":Ljava/lang/String;
    const-string v2, "SHA-256"

    invoke-static {v2}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v2

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    sget-object v3, Ljava/nio/charset/StandardCharsets;->US_ASCII:Ljava/nio/charset/Charset;

    const-string v4, "US_ASCII"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v1, v3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v3

    const-string v4, "getBytes(...)"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v2

    const-string v3, "digest(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0, v2}, Lsh/sth/lotterychecker/ActivationActivity;->b64([B)Ljava/lang/String;

    move-result-object v2

    .line 81
    .local v2, "challenge":Ljava/lang/String;
    invoke-direct {p0}, Lsh/sth/lotterychecker/ActivationActivity;->getPrefs()Landroid/content/SharedPreferences;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    const-string v4, "state"

    invoke-interface {v3, v4, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    const-string v5, "verifier"

    invoke-interface {v3, v5, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 82
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget v5, Lsh/sth/lotterychecker/R$string;->api_base_url:I

    invoke-virtual {p0, v5}, Lsh/sth/lotterychecker/ActivationActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, "/activate"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 83
    invoke-virtual {v3}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v3

    .line 84
    invoke-virtual {v3, v4, v0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v3

    .line 85
    const-string v4, "code_challenge"

    invoke-virtual {v3, v4, v2}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v3

    .line 86
    invoke-virtual {v3}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v3

    .line 82
    nop

    .line 87
    .local v3, "uri":Landroid/net/Uri;
    new-instance v4, Landroid/content/Intent;

    const-string v5, "android.intent.action.VIEW"

    invoke-direct {v4, v5, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {p0, v4}, Lsh/sth/lotterychecker/ActivationActivity;->startActivity(Landroid/content/Intent;)V

    .line 88
    invoke-virtual {p0}, Lsh/sth/lotterychecker/ActivationActivity;->finish()V

    .line 89
    return-void
.end method

.method private final exchange(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 10
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "verifier"    # Ljava/lang/String;

    .line 92
    new-instance v0, Ljava/net/URL;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget v2, Lsh/sth/lotterychecker/R$string;->api_base_url:I

    invoke-virtual {p0, v2}, Lsh/sth/lotterychecker/ActivationActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/activate/exchange"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 93
    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 92
    const-string v1, "null cannot be cast to non-null type java.net.HttpURLConnection"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 94
    .local v0, "connection":Ljava/net/HttpURLConnection;
    nop

    .line 95
    :try_start_0
    const-string v1, "POST"

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 96
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setDoOutput(Z)V

    .line 97
    const/16 v2, 0x1f40

    invoke-virtual {v0, v2}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 98
    invoke-virtual {v0, v2}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 99
    const-string v2, "Content-Type"

    const-string v3, "application/json"

    invoke-virtual {v0, v2, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    const-string v2, "X-API-Key"

    sget v3, Lsh/sth/lotterychecker/R$string;->api_key:I

    invoke-virtual {p0, v3}, Lsh/sth/lotterychecker/ActivationActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    sget-object v2, Lsh/sth/lotterychecker/AppRequestProfile;->INSTANCE:Lsh/sth/lotterychecker/AppRequestProfile;

    move-object v3, p0

    check-cast v3, Landroid/content/Context;

    invoke-virtual {v2, v0, v3}, Lsh/sth/lotterychecker/AppRequestProfile;->apply(Ljava/net/HttpURLConnection;Landroid/content/Context;)V

    .line 102
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

    .line 103
    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "toString(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v3, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    const-string v4, "UTF_8"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v2

    const-string v3, "getBytes(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 102
    nop

    .line 104
    .local v2, "body":[B
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v3

    check-cast v3, Ljava/io/Closeable;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_4

    :try_start_1
    move-object v4, v3

    check-cast v4, Ljava/io/OutputStream;

    .line 158
    .local v4, "it":Ljava/io/OutputStream;
    const/4 v6, 0x0

    .line 104
    .local v6, "$i$a$-use-ActivationActivity$exchange$1":I
    invoke-virtual {v4, v2}, Ljava/io/OutputStream;->write([B)V

    .end local v4    # "it":Ljava/io/OutputStream;
    .end local v6    # "$i$a$-use-ActivationActivity$exchange$1":I
    sget-object v4, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    const/4 v4, 0x0

    :try_start_2
    invoke-static {v3, v4}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    .line 105
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_4

    const/16 v6, 0xc8

    if-ne v3, v6, :cond_0

    move v3, v1

    goto :goto_0

    :cond_0
    move v3, v5

    :goto_0
    const-string v6, "Failed requirement."

    if-eqz v3, :cond_4

    .line 106
    :try_start_3
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    const-string v7, "getInputStream(...)"

    invoke-static {v3, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v7, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    new-instance v8, Ljava/io/InputStreamReader;

    invoke-direct {v8, v3, v7}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    check-cast v8, Ljava/io/Reader;

    instance-of v3, v8, Ljava/io/BufferedReader;

    if-eqz v3, :cond_1

    check-cast v8, Ljava/io/BufferedReader;

    goto :goto_1

    :cond_1
    new-instance v3, Ljava/io/BufferedReader;

    const/16 v7, 0x2000

    invoke-direct {v3, v8, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V

    move-object v8, v3

    :goto_1
    check-cast v8, Ljava/io/Closeable;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_4

    :try_start_4
    move-object v3, v8

    check-cast v3, Ljava/io/BufferedReader;

    .line 158
    .local v3, "it":Ljava/io/BufferedReader;
    const/4 v7, 0x0

    .line 106
    .local v7, "$i$a$-use-ActivationActivity$exchange$response$1":I
    move-object v9, v3

    check-cast v9, Ljava/io/Reader;

    invoke-static {v9}, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;

    move-result-object v9
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .end local v3    # "it":Ljava/io/BufferedReader;
    .end local v7    # "$i$a$-use-ActivationActivity$exchange$response$1":I
    :try_start_5
    invoke-static {v8, v4}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    move-object v3, v9

    .line 107
    .local v3, "response":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    const/16 v7, 0x1000

    if-gt v4, v7, :cond_2

    goto :goto_2

    :cond_2
    move v1, v5

    :goto_2
    if-eqz v1, :cond_3

    .line 108
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_4

    .line 110
    .end local v2    # "body":[B
    .end local v3    # "response":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 111
    nop

    .line 94
    return-object v1

    .line 107
    .restart local v2    # "body":[B
    .restart local v3    # "response":Ljava/lang/String;
    :cond_3
    :try_start_6
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    throw v1
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_4

    .line 106
    .end local v3    # "response":Ljava/lang/String;
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :catchall_0
    move-exception v1

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local v2    # "body":[B
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    :try_start_7
    throw v1
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local v2    # "body":[B
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :catchall_1
    move-exception v3

    :try_start_8
    invoke-static {v8, v1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    throw v3

    .line 105
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :cond_4
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    throw v1
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_4

    .line 104
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :catchall_2
    move-exception v1

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local v2    # "body":[B
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    :try_start_9
    throw v1
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_3

    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local v2    # "body":[B
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :catchall_3
    move-exception v4

    :try_start_a
    invoke-static {v3, v1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "code":Ljava/lang/String;
    .end local p2    # "verifier":Ljava/lang/String;
    throw v4
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_4

    .line 110
    .end local v2    # "body":[B
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "code":Ljava/lang/String;
    .restart local p2    # "verifier":Ljava/lang/String;
    :catchall_4
    move-exception v1

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    throw v1
.end method

.method private final getPrefs()Landroid/content/SharedPreferences;
    .locals 1

    .line 20
    iget-object v0, p0, Lsh/sth/lotterychecker/ActivationActivity;->prefs$delegate:Lkotlin/Lazy;

    invoke-interface {v0}, Lkotlin/Lazy;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/SharedPreferences;

    return-object v0
.end method

.method private final handle(Landroid/content/Intent;)V
    .locals 7
    .param p1, "incoming"    # Landroid/content/Intent;

    .line 35
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v0

    .line 36
    .local v0, "callback":Landroid/net/Uri;
    const/4 v1, 0x0

    if-eqz v0, :cond_0

    const-string v2, "code"

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    :cond_0
    move-object v2, v1

    .line 37
    .local v2, "code":Ljava/lang/String;
    :goto_0
    if-nez v2, :cond_1

    .line 38
    invoke-direct {p0}, Lsh/sth/lotterychecker/ActivationActivity;->begin()V

    .line 39
    return-void

    .line 41
    :cond_1
    invoke-virtual {v0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v3

    const-string v4, "thctt-mob01"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    invoke-virtual {v0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v3

    const-string v4, "activate"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    goto :goto_2

    .line 45
    :cond_2
    const-string v3, "state"

    invoke-virtual {v0, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 46
    .local v4, "state":Ljava/lang/String;
    invoke-direct {p0}, Lsh/sth/lotterychecker/ActivationActivity;->getPrefs()Landroid/content/SharedPreferences;

    move-result-object v5

    const-string v6, "verifier"

    invoke-interface {v5, v6, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 47
    .local v5, "verifier":Ljava/lang/String;
    if-eqz v4, :cond_4

    invoke-direct {p0}, Lsh/sth/lotterychecker/ActivationActivity;->getPrefs()Landroid/content/SharedPreferences;

    move-result-object v6

    invoke-interface {v6, v3, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v4, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    if-nez v5, :cond_3

    goto :goto_1

    .line 52
    :cond_3
    new-instance v1, Ljava/lang/Thread;

    .line 74
    new-instance v3, Lsh/sth/lotterychecker/ActivationActivity$$ExternalSyntheticLambda0;

    invoke-direct {v3, p0, v2, v5}, Lsh/sth/lotterychecker/ActivationActivity$$ExternalSyntheticLambda0;-><init>(Lsh/sth/lotterychecker/ActivationActivity;Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    invoke-direct {v1, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 74
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 75
    return-void

    .line 48
    :cond_4
    :goto_1
    invoke-virtual {p0}, Lsh/sth/lotterychecker/ActivationActivity;->finish()V

    .line 49
    return-void

    .line 42
    .end local v4    # "state":Ljava/lang/String;
    .end local v5    # "verifier":Ljava/lang/String;
    :cond_5
    :goto_2
    invoke-virtual {p0}, Lsh/sth/lotterychecker/ActivationActivity;->finish()V

    .line 43
    return-void
.end method

.method private static final handle$lambda$3(Lsh/sth/lotterychecker/ActivationActivity;Ljava/lang/String;Ljava/lang/String;)V
    .locals 12
    .param p0, "this$0"    # Lsh/sth/lotterychecker/ActivationActivity;
    .param p1, "$code"    # Ljava/lang/String;
    .param p2, "$verifier"    # Ljava/lang/String;

    const-string v0, "capability"

    const-string v1, "this$0"

    invoke-static {p0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 53
    nop

    .line 54
    :try_start_0
    invoke-direct {p0, p1, p2}, Lsh/sth/lotterychecker/ActivationActivity;->exchange(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 55
    .local v1, "response":Lorg/json/JSONObject;
    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 56
    .local v2, "capability":Ljava/lang/String;
    const-string v3, "expires_in"

    const-wide/16 v4, 0xe10

    invoke-virtual {v1, v3, v4, v5}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;J)J

    move-result-wide v6

    const-wide/16 v8, 0x3c

    const-wide/16 v10, 0xe10

    invoke-static/range {v6 .. v11}, Lkotlin/ranges/RangesKt;->coerceIn(JJJ)J

    move-result-wide v3

    .line 57
    .local v3, "expiresIn":J
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    const-string v5, "ctcap1."

    const/4 v6, 0x2

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-static {v2, v5, v8, v6, v7}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 58
    invoke-direct {p0}, Lsh/sth/lotterychecker/ActivationActivity;->getPrefs()Landroid/content/SharedPreferences;

    move-result-object v5

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    .line 59
    invoke-interface {v5, v0, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 60
    const-string v5, "expiry"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    const/16 v8, 0x3e8

    int-to-long v8, v8

    mul-long/2addr v8, v3

    add-long/2addr v6, v8

    const/16 v8, 0x2710

    int-to-long v8, v8

    sub-long/2addr v6, v8

    invoke-interface {v0, v5, v6, v7}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 61
    const-string v5, "state"

    invoke-interface {v0, v5}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 62
    const-string v5, "verifier"

    invoke-interface {v0, v5}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 63
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 64
    new-instance v0, Lsh/sth/lotterychecker/ActivationActivity$$ExternalSyntheticLambda1;

    invoke-direct {v0, p0}, Lsh/sth/lotterychecker/ActivationActivity$$ExternalSyntheticLambda1;-><init>(Lsh/sth/lotterychecker/ActivationActivity;)V

    invoke-virtual {p0, v0}, Lsh/sth/lotterychecker/ActivationActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .end local v1    # "response":Lorg/json/JSONObject;
    .end local v2    # "capability":Ljava/lang/String;
    .end local v3    # "expiresIn":J
    goto :goto_0

    .line 57
    .restart local v1    # "response":Lorg/json/JSONObject;
    .restart local v2    # "capability":Ljava/lang/String;
    .restart local v3    # "expiresIn":J
    :cond_0
    const-string v0, "Failed requirement."

    new-instance v5, Ljava/lang/IllegalArgumentException;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v5, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .end local p0    # "this$0":Lsh/sth/lotterychecker/ActivationActivity;
    .end local p1    # "$code":Ljava/lang/String;
    .end local p2    # "$verifier":Ljava/lang/String;
    throw v5
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 68
    .end local v1    # "response":Lorg/json/JSONObject;
    .end local v2    # "capability":Ljava/lang/String;
    .end local v3    # "expiresIn":J
    .restart local p0    # "this$0":Lsh/sth/lotterychecker/ActivationActivity;
    .restart local p1    # "$code":Ljava/lang/String;
    .restart local p2    # "$verifier":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 69
    .local v0, "_":Ljava/lang/Exception;
    new-instance v1, Lsh/sth/lotterychecker/ActivationActivity$$ExternalSyntheticLambda2;

    invoke-direct {v1, p0}, Lsh/sth/lotterychecker/ActivationActivity$$ExternalSyntheticLambda2;-><init>(Lsh/sth/lotterychecker/ActivationActivity;)V

    invoke-virtual {p0, v1}, Lsh/sth/lotterychecker/ActivationActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 74
    .end local v0    # "_":Ljava/lang/Exception;
    :goto_0
    return-void
.end method

.method private static final handle$lambda$3$lambda$1(Lsh/sth/lotterychecker/ActivationActivity;)V
    .locals 3
    .param p0, "this$0"    # Lsh/sth/lotterychecker/ActivationActivity;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 65
    new-instance v0, Landroid/content/Intent;

    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    const-class v2, Lsh/sth/lotterychecker/MainActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lsh/sth/lotterychecker/ActivationActivity;->startActivity(Landroid/content/Intent;)V

    .line 66
    invoke-virtual {p0}, Lsh/sth/lotterychecker/ActivationActivity;->finish()V

    .line 67
    return-void
.end method

.method private static final handle$lambda$3$lambda$2(Lsh/sth/lotterychecker/ActivationActivity;)V
    .locals 3
    .param p0, "this$0"    # Lsh/sth/lotterychecker/ActivationActivity;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 70
    move-object v0, p0

    check-cast v0, Landroid/content/Context;

    const-string v1, "\u0e22\u0e31\u0e07\u0e40\u0e1b\u0e34\u0e14\u0e43\u0e0a\u0e49\u0e07\u0e32\u0e19\u0e44\u0e21\u0e48\u0e44\u0e14\u0e49 \u0e01\u0e23\u0e38\u0e13\u0e32\u0e25\u0e2d\u0e07\u0e43\u0e2b\u0e21\u0e48"

    check-cast v1, Ljava/lang/CharSequence;

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 71
    invoke-virtual {p0}, Lsh/sth/lotterychecker/ActivationActivity;->finish()V

    .line 72
    return-void
.end method

.method private final random(I)Ljava/lang/String;
    .locals 4
    .param p1, "bytes"    # I

    .line 114
    new-array v0, p1, [B

    .line 158
    move-object v1, v0

    .local v1, "it":[B
    const/4 v2, 0x0

    .line 114
    .local v2, "$i$a$-also-ActivationActivity$random$1":I
    sget-object v3, Lsh/sth/lotterychecker/ActivationActivity;->RANDOM:Ljava/security/SecureRandom;

    invoke-virtual {v3, v1}, Ljava/security/SecureRandom;->nextBytes([B)V

    .end local v1    # "it":[B
    .end local v2    # "$i$a$-also-ActivationActivity$random$1":I
    invoke-direct {p0, v0}, Lsh/sth/lotterychecker/ActivationActivity;->b64([B)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 23
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 24
    new-instance v0, Landroid/widget/TextView;

    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 158
    move-object v1, v0

    .local v1, "$this$onCreate_u24lambda_u240":Landroid/widget/TextView;
    const/4 v2, 0x0

    .line 24
    .local v2, "$i$a$-apply-ActivationActivity$onCreate$1":I
    const-string v3, "\u0e01\u0e33\u0e25\u0e31\u0e07\u0e22\u0e37\u0e19\u0e22\u0e31\u0e19\u0e01\u0e32\u0e23\u0e40\u0e1b\u0e34\u0e14\u0e43\u0e0a\u0e49\u0e07\u0e32\u0e19\u2026"

    check-cast v3, Ljava/lang/CharSequence;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .end local v1    # "$this$onCreate_u24lambda_u240":Landroid/widget/TextView;
    .end local v2    # "$i$a$-apply-ActivationActivity$onCreate$1":I
    check-cast v0, Landroid/view/View;

    invoke-virtual {p0, v0}, Lsh/sth/lotterychecker/ActivationActivity;->setContentView(Landroid/view/View;)V

    .line 25
    invoke-virtual {p0}, Lsh/sth/lotterychecker/ActivationActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "getIntent(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lsh/sth/lotterychecker/ActivationActivity;->handle(Landroid/content/Intent;)V

    .line 26
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    const-string v0, "intent"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 29
    invoke-super {p0, p1}, Landroid/app/Activity;->onNewIntent(Landroid/content/Intent;)V

    .line 30
    invoke-virtual {p0, p1}, Lsh/sth/lotterychecker/ActivationActivity;->setIntent(Landroid/content/Intent;)V

    .line 31
    invoke-direct {p0, p1}, Lsh/sth/lotterychecker/ActivationActivity;->handle(Landroid/content/Intent;)V

    .line 32
    return-void
.end method
