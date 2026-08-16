.class public final Lsh/sth/somtam/AppRequestProfile;
.super Ljava/lang/Object;
.source "AppRequestProfile.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nAppRequestProfile.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppRequestProfile.kt\nsh/sth/somtam/AppRequestProfile\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"
    }
    d2 = {
        "Lsh/sth/somtam/AppRequestProfile;",
        "",
        "()V",
        "APP_ID",
        "",
        "APP_VERSION",
        "INSTALL_ID",
        "PREFS",
        "USER_AGENT",
        "installPattern",
        "Lkotlin/text/Regex;",
        "random",
        "Ljava/security/SecureRandom;",
        "apply",
        "",
        "connection",
        "Ljava/net/HttpURLConnection;",
        "context",
        "Landroid/content/Context;",
        "installId",
        "isCanonicalInstallId",
        "",
        "value",
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
.field public static final APP_ID:Ljava/lang/String; = "sh.sth.somtam"

.field public static final APP_VERSION:Ljava/lang/String; = "1"

.field private static final INSTALL_ID:Ljava/lang/String; = "install_id_v1"

.field public static final INSTANCE:Lsh/sth/somtam/AppRequestProfile;

.field private static final PREFS:Ljava/lang/String; = "request_profile"

.field public static final USER_AGENT:Ljava/lang/String; = "THCTT-Mobile03/1 (Android; sh.sth.somtam)"

.field private static final installPattern:Lkotlin/text/Regex;

.field private static final random:Ljava/security/SecureRandom;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lsh/sth/somtam/AppRequestProfile;

    invoke-direct {v0}, Lsh/sth/somtam/AppRequestProfile;-><init>()V

    sput-object v0, Lsh/sth/somtam/AppRequestProfile;->INSTANCE:Lsh/sth/somtam/AppRequestProfile;

    .line 15
    new-instance v0, Ljava/security/SecureRandom;

    invoke-direct {v0}, Ljava/security/SecureRandom;-><init>()V

    sput-object v0, Lsh/sth/somtam/AppRequestProfile;->random:Ljava/security/SecureRandom;

    .line 16
    new-instance v0, Lkotlin/text/Regex;

    const-string v1, "^[A-Za-z0-9_-]{22}$"

    invoke-direct {v0, v1}, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V

    sput-object v0, Lsh/sth/somtam/AppRequestProfile;->installPattern:Lkotlin/text/Regex;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private final isCanonicalInstallId(Ljava/lang/String;)Z
    .locals 7
    .param p1, "value"    # Ljava/lang/String;

    .line 33
    sget-object v0, Lsh/sth/somtam/AppRequestProfile;->installPattern:Lkotlin/text/Regex;

    move-object v1, p1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Lkotlin/text/Regex;->matches(Ljava/lang/CharSequence;)Z

    move-result v0

    const/4 v1, 0x0

    if-nez v0, :cond_0

    return v1

    .line 34
    :cond_0
    :try_start_0
    sget-object v0, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    move-object v0, p0

    check-cast v0, Lsh/sth/somtam/AppRequestProfile;

    .local v0, "$this$isCanonicalInstallId_u24lambda_u244":Lsh/sth/somtam/AppRequestProfile;
    const/4 v2, 0x0

    .line 35
    .local v2, "$i$a$-runCatching-AppRequestProfile$isCanonicalInstallId$1":I
    const/16 v3, 0xb

    invoke-static {p1, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v4

    .line 36
    .local v4, "decoded":[B
    array-length v5, v4

    const/16 v6, 0x10

    if-ne v5, v6, :cond_1

    .line 37
    nop

    .line 38
    nop

    .line 36
    invoke-static {v4, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v3

    .line 39
    invoke-static {v3, p1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    const/4 v3, 0x1

    goto :goto_0

    :cond_1
    move v3, v1

    .line 36
    :goto_0
    nop

    .end local v0    # "$this$isCanonicalInstallId_u24lambda_u244":Lsh/sth/somtam/AppRequestProfile;
    .end local v2    # "$i$a$-runCatching-AppRequestProfile$isCanonicalInstallId$1":I
    .end local v4    # "decoded":[B
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    .line 34
    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    sget-object v2, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {v0}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 40
    :goto_1
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    move-object v0, v1

    :cond_2
    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 34
    return v0
.end method


# virtual methods
.method public final apply(Ljava/net/HttpURLConnection;Landroid/content/Context;)V
    .locals 2
    .param p1, "connection"    # Ljava/net/HttpURLConnection;
    .param p2, "context"    # Landroid/content/Context;

    const-string v0, "connection"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "context"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 44
    const-string v0, "User-Agent"

    const-string v1, "THCTT-Mobile03/1 (Android; sh.sth.somtam)"

    invoke-virtual {p1, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    const-string v0, "X-THCTT-App-ID"

    const-string v1, "sh.sth.somtam"

    invoke-virtual {p1, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    const-string v0, "X-THCTT-App-Version"

    const-string v1, "1"

    invoke-virtual {p1, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    const-string v0, "X-THCTT-Install-ID"

    invoke-virtual {p0, p2}, Lsh/sth/somtam/AppRequestProfile;->installId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    return-void
.end method

.method public final declared-synchronized installId(Landroid/content/Context;)Ljava/lang/String;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;

    monitor-enter p0

    :try_start_0
    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 20
    const-string v0, "request_profile"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 21
    .local v0, "prefs":Landroid/content/SharedPreferences;
    const-string v2, "install_id_v1"

    const/4 v3, 0x0

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    move-object v4, v2

    .line 51
    .local v4, "p0":Ljava/lang/String;
    const/4 v5, 0x0

    .line 21
    .local v5, "$i$a$-takeIf-AppRequestProfile$installId$1":I
    invoke-direct {p0, v4}, Lsh/sth/somtam/AppRequestProfile;->isCanonicalInstallId(Ljava/lang/String;)Z

    move-result v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .end local v4    # "p0":Ljava/lang/String;
    .end local v5    # "$i$a$-takeIf-AppRequestProfile$installId$1":I
    if-eqz v6, :cond_0

    move-object v3, v2

    :cond_0
    if-eqz v3, :cond_1

    move-object v1, v3

    .line 51
    .local v1, "it":Ljava/lang/String;
    const/4 v2, 0x0

    .line 21
    .local v2, "$i$a$-let-AppRequestProfile$installId$2":I
    monitor-exit p0

    return-object v1

    .line 23
    .end local v1    # "it":Ljava/lang/String;
    .end local v2    # "$i$a$-let-AppRequestProfile$installId$2":I
    .end local p0    # "this":Lsh/sth/somtam/AppRequestProfile;
    :cond_1
    const/16 v2, 0x10

    :try_start_1
    new-array v2, v2, [B

    sget-object v3, Lsh/sth/somtam/AppRequestProfile;->random:Ljava/security/SecureRandom;

    move-object v4, v2

    .line 51
    .local v4, "p0":[B
    const/4 v5, 0x0

    .line 23
    .local v5, "$i$a$-also-AppRequestProfile$installId$value$1":I
    invoke-virtual {v3, v4}, Ljava/security/SecureRandom;->nextBytes([B)V

    .line 24
    .end local v4    # "p0":[B
    .end local v5    # "$i$a$-also-AppRequestProfile$installId$value$1":I
    nop

    .line 22
    const/16 v3, 0xb

    invoke-static {v2, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v2

    .line 26
    .local v2, "value":Ljava/lang/String;
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    const-string v4, "install_id_v1"

    invoke-interface {v3, v4, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 27
    const-string v3, "challenge_access"

    invoke-virtual {p1, v3, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 28
    const-string v3, "capability"

    invoke-interface {v1, v3}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v3, "expires_at_ms"

    invoke-interface {v1, v3}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v1

    .line 27
    if-eqz v1, :cond_2

    .line 29
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-object v2

    .line 27
    :cond_2
    const/4 v1, 0x0

    .line 28
    .local v1, "$i$a$-check-AppRequestProfile$installId$4":I
    :try_start_2
    const-string v3, "cannot reset bound capability"

    .line 27
    .end local v1    # "$i$a$-check-AppRequestProfile$installId$4":I
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 51
    :cond_3
    const/4 v1, 0x0

    .line 26
    .local v1, "$i$a$-check-AppRequestProfile$installId$3":I
    const-string v3, "cannot persist install profile"

    .end local v1    # "$i$a$-check-AppRequestProfile$installId$3":I
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 19
    .end local v0    # "prefs":Landroid/content/SharedPreferences;
    .end local v2    # "value":Ljava/lang/String;
    .end local p1    # "context":Landroid/content/Context;
    :catchall_0
    move-exception p1

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw p1
.end method
