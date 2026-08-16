.class final Lsh/sth/somtam/MainActivity$onCreate$1;
.super Lkotlin/jvm/internal/Lambda;
.source "MainActivity.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsh/sth/somtam/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lkotlin/jvm/internal/Lambda;",
        "Lkotlin/jvm/functions/Function0<",
        "Lkotlin/Unit;",
        ">;"
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivity.kt\nsh/sth/somtam/MainActivity$onCreate$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\u0008\u0002"
    }
    d2 = {
        "<anonymous>",
        "",
        "invoke"
    }
    k = 0x3
    mv = {
        0x1,
        0x9,
        0x0
    }
    xi = 0x30
.end annotation


# instance fields
.field final synthetic this$0:Lsh/sth/somtam/MainActivity;


# direct methods
.method public static synthetic $r8$lambda$KCjFyL5nsroeyq3RDfXmmVAExBQ(Lsh/sth/somtam/MainActivity;)V
    .locals 0

    invoke-static {p0}, Lsh/sth/somtam/MainActivity$onCreate$1;->invoke$lambda$1(Lsh/sth/somtam/MainActivity;)V

    return-void
.end method

.method constructor <init>(Lsh/sth/somtam/MainActivity;)V
    .locals 1

    iput-object p1, p0, Lsh/sth/somtam/MainActivity$onCreate$1;->this$0:Lsh/sth/somtam/MainActivity;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method

.method private static final invoke$lambda$1(Lsh/sth/somtam/MainActivity;)V
    .locals 1
    .param p0, "this$0"    # Lsh/sth/somtam/MainActivity;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 113
    invoke-static {p0}, Lsh/sth/somtam/MainActivity;->access$launchActivation(Lsh/sth/somtam/MainActivity;)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 111
    invoke-virtual {p0}, Lsh/sth/somtam/MainActivity$onCreate$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .locals 4

    .line 112
    iget-object v0, p0, Lsh/sth/somtam/MainActivity$onCreate$1;->this$0:Lsh/sth/somtam/MainActivity;

    :try_start_0
    sget-object v1, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    .line 311
    .local v0, "$this$invoke_u24lambda_u240":Lsh/sth/somtam/MainActivity;
    const/4 v1, 0x0

    .line 112
    .local v1, "$i$a$-runCatching-MainActivity$onCreate$1$required$1":I
    sget-object v2, Lsh/sth/somtam/ChallengeCapability;->INSTANCE:Lsh/sth/somtam/ChallengeCapability;

    move-object v3, v0

    check-cast v3, Landroid/content/Context;

    invoke-virtual {v2, v3}, Lsh/sth/somtam/ChallengeCapability;->activationRequired(Landroid/content/Context;)Z

    move-result v2

    .end local v0    # "$this$invoke_u24lambda_u240":Lsh/sth/somtam/MainActivity;
    .end local v1    # "$i$a$-runCatching-MainActivity$onCreate$1$required$1":I
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    sget-object v1, Lkotlin/Result;->Companion:Lkotlin/Result$Companion;

    invoke-static {v0}, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0}, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    invoke-static {v0}, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x0

    :cond_0
    check-cast v0, Ljava/lang/Boolean;

    .line 113
    .local v0, "required":Ljava/lang/Boolean;
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v2, p0, Lsh/sth/somtam/MainActivity$onCreate$1;->this$0:Lsh/sth/somtam/MainActivity;

    new-instance v3, Lsh/sth/somtam/MainActivity$onCreate$1$$ExternalSyntheticLambda0;

    invoke-direct {v3, v2}, Lsh/sth/somtam/MainActivity$onCreate$1$$ExternalSyntheticLambda0;-><init>(Lsh/sth/somtam/MainActivity;)V

    invoke-virtual {v1, v3}, Lsh/sth/somtam/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 114
    :cond_1
    return-void
.end method
