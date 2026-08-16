.class final Lsh/sth/lotterychecker/MainActivity$checkActivationState$1;
.super Lkotlin/jvm/internal/Lambda;
.source "MainActivity.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsh/sth/lotterychecker/MainActivity;->checkActivationState()V
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
.field final synthetic this$0:Lsh/sth/lotterychecker/MainActivity;


# direct methods
.method public static synthetic $r8$lambda$Aai5ngxAkZLRrxEp_EkX-jxGAtE(Ljava/lang/Boolean;Lsh/sth/lotterychecker/MainActivity;)V
    .locals 0

    invoke-static {p0, p1}, Lsh/sth/lotterychecker/MainActivity$checkActivationState$1;->invoke$lambda$0(Ljava/lang/Boolean;Lsh/sth/lotterychecker/MainActivity;)V

    return-void
.end method

.method constructor <init>(Lsh/sth/lotterychecker/MainActivity;)V
    .locals 1

    iput-object p1, p0, Lsh/sth/lotterychecker/MainActivity$checkActivationState$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method

.method private static final invoke$lambda$0(Ljava/lang/Boolean;Lsh/sth/lotterychecker/MainActivity;)V
    .locals 4
    .param p0, "$enabled"    # Ljava/lang/Boolean;
    .param p1, "this$0"    # Lsh/sth/lotterychecker/MainActivity;

    const-string v0, "this$0"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 83
    nop

    .line 84
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {p0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {p1}, Lsh/sth/lotterychecker/MainActivity;->access$launchActivation(Lsh/sth/lotterychecker/MainActivity;)V

    goto :goto_2

    .line 85
    :cond_0
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {p0, v1}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    const/4 v2, 0x0

    const-string v3, "resultText"

    if-eqz v1, :cond_2

    .line 86
    invoke-static {p1}, Lsh/sth/lotterychecker/MainActivity;->access$getResultText$p(Lsh/sth/lotterychecker/MainActivity;)Landroid/widget/TextView;

    move-result-object v1

    if-nez v1, :cond_1

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    move-object v2, v1

    :goto_0
    const-string v1, "\u0e1e\u0e23\u0e49\u0e2d\u0e21\u0e15\u0e23\u0e27\u0e08\u0e1c\u0e25\u0e2a\u0e25\u0e32\u0e01"

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 87
    invoke-static {p1, v0}, Lsh/sth/lotterychecker/MainActivity;->access$setActionsEnabled(Lsh/sth/lotterychecker/MainActivity;Z)V

    goto :goto_2

    .line 89
    :cond_2
    if-nez p0, :cond_4

    invoke-static {p1}, Lsh/sth/lotterychecker/MainActivity;->access$getResultText$p(Lsh/sth/lotterychecker/MainActivity;)Landroid/widget/TextView;

    move-result-object v0

    if-nez v0, :cond_3

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_3
    move-object v2, v0

    :goto_1
    const-string v0, "\u0e22\u0e31\u0e07\u0e40\u0e0a\u0e37\u0e48\u0e2d\u0e21\u0e15\u0e48\u0e2d\u0e1a\u0e23\u0e34\u0e01\u0e32\u0e23\u0e44\u0e21\u0e48\u0e44\u0e14\u0e49 \u0e01\u0e23\u0e38\u0e13\u0e32\u0e40\u0e1b\u0e34\u0e14\u0e41\u0e2d\u0e1b\u0e43\u0e2b\u0e21\u0e48\u0e2d\u0e35\u0e01\u0e04\u0e23\u0e31\u0e49\u0e07"

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 91
    :cond_4
    :goto_2
    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 80
    invoke-virtual {p0}, Lsh/sth/lotterychecker/MainActivity$checkActivationState$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .locals 4

    .line 81
    sget-object v0, Lsh/sth/lotterychecker/ActivationActivity;->Companion:Lsh/sth/lotterychecker/ActivationActivity$Companion;

    iget-object v1, p0, Lsh/sth/lotterychecker/MainActivity$checkActivationState$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    check-cast v1, Landroid/content/Context;

    invoke-virtual {v0, v1}, Lsh/sth/lotterychecker/ActivationActivity$Companion;->activationEnabled(Landroid/content/Context;)Ljava/lang/Boolean;

    move-result-object v0

    .line 82
    .local v0, "enabled":Ljava/lang/Boolean;
    iget-object v1, p0, Lsh/sth/lotterychecker/MainActivity$checkActivationState$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    iget-object v2, p0, Lsh/sth/lotterychecker/MainActivity$checkActivationState$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    new-instance v3, Lsh/sth/lotterychecker/MainActivity$checkActivationState$1$$ExternalSyntheticLambda0;

    invoke-direct {v3, v0, v2}, Lsh/sth/lotterychecker/MainActivity$checkActivationState$1$$ExternalSyntheticLambda0;-><init>(Ljava/lang/Boolean;Lsh/sth/lotterychecker/MainActivity;)V

    invoke-virtual {v1, v3}, Lsh/sth/lotterychecker/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 92
    return-void
.end method
