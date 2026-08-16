.class final Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;
.super Lkotlin/jvm/internal/Lambda;
.source "MainActivity.kt"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsh/sth/lotterychecker/MainActivity;->buySpecialTicket()V
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
.field final synthetic $apiKey:Ljava/lang/String;

.field final synthetic $capability:Ljava/lang/String;

.field final synthetic $url:Ljava/lang/String;

.field final synthetic this$0:Lsh/sth/lotterychecker/MainActivity;


# direct methods
.method public static synthetic $r8$lambda$Bt5EnrHv0pgOL97x64dTPqljgOY(Lsh/sth/lotterychecker/MainActivity;)V
    .locals 0

    invoke-static {p0}, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->invoke$lambda$0(Lsh/sth/lotterychecker/MainActivity;)V

    return-void
.end method

.method public static synthetic $r8$lambda$DfGflr-nVngYpw7blG_SXgwUaOk(Lsh/sth/lotterychecker/MainActivity;)V
    .locals 0

    invoke-static {p0}, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->invoke$lambda$2(Lsh/sth/lotterychecker/MainActivity;)V

    return-void
.end method

.method public static synthetic $r8$lambda$MGuhcjMU47YSq1g1tuHvZTKdjlo(Lsh/sth/lotterychecker/MainActivity;)V
    .locals 0

    invoke-static {p0}, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->invoke$lambda$1(Lsh/sth/lotterychecker/MainActivity;)V

    return-void
.end method

.method constructor <init>(Lsh/sth/lotterychecker/MainActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    iput-object p1, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    iput-object p2, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->$url:Ljava/lang/String;

    iput-object p3, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->$apiKey:Ljava/lang/String;

    iput-object p4, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->$capability:Ljava/lang/String;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method

.method private static final invoke$lambda$0(Lsh/sth/lotterychecker/MainActivity;)V
    .locals 3
    .param p0, "this$0"    # Lsh/sth/lotterychecker/MainActivity;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 154
    invoke-static {p0}, Lsh/sth/lotterychecker/MainActivity;->access$getResultText$p(Lsh/sth/lotterychecker/MainActivity;)Landroid/widget/TextView;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, "resultText"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_0
    const-string v1, "\u0e2a\u0e25\u0e32\u0e01\u0e1e\u0e34\u0e40\u0e28\u0e29\u0e1e\u0e23\u0e49\u0e2d\u0e21\u0e15\u0e23\u0e27\u0e08\u0e2a\u0e2d\u0e1a\u0e43\u0e19\u0e1a\u0e31\u0e0d\u0e0a\u0e35\u0e02\u0e2d\u0e07\u0e04\u0e38\u0e13"

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 155
    move-object v0, p0

    check-cast v0, Landroid/content/Context;

    const-string v1, "\u0e2a\u0e31\u0e48\u0e07\u0e0b\u0e37\u0e49\u0e2d\u0e2a\u0e25\u0e32\u0e01\u0e1e\u0e34\u0e40\u0e28\u0e29\u0e40\u0e23\u0e35\u0e22\u0e1a\u0e23\u0e49\u0e2d\u0e22!"

    check-cast v1, Ljava/lang/CharSequence;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 156
    return-void
.end method

.method private static final invoke$lambda$1(Lsh/sth/lotterychecker/MainActivity;)V
    .locals 1
    .param p0, "this$0"    # Lsh/sth/lotterychecker/MainActivity;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 158
    invoke-static {p0}, Lsh/sth/lotterychecker/MainActivity;->access$launchActivation(Lsh/sth/lotterychecker/MainActivity;)V

    return-void
.end method

.method private static final invoke$lambda$2(Lsh/sth/lotterychecker/MainActivity;)V
    .locals 2
    .param p0, "this$0"    # Lsh/sth/lotterychecker/MainActivity;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 160
    invoke-static {p0}, Lsh/sth/lotterychecker/MainActivity;->access$getResultText$p(Lsh/sth/lotterychecker/MainActivity;)Landroid/widget/TextView;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, "resultText"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_0
    const-string v1, "\u0e22\u0e31\u0e07\u0e2a\u0e31\u0e48\u0e07\u0e0b\u0e37\u0e49\u0e2d\u0e2a\u0e25\u0e32\u0e01\u0e1e\u0e34\u0e40\u0e28\u0e29\u0e44\u0e21\u0e48\u0e44\u0e14\u0e49 \u0e01\u0e23\u0e38\u0e13\u0e32\u0e25\u0e2d\u0e07\u0e43\u0e2b\u0e21\u0e48\u0e2d\u0e35\u0e01\u0e04\u0e23\u0e31\u0e49\u0e07"

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 148
    invoke-virtual {p0}, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .locals 5

    .line 149
    nop

    .line 150
    :try_start_0
    iget-object v0, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    iget-object v1, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->$url:Ljava/lang/String;

    iget-object v2, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->$apiKey:Ljava/lang/String;

    iget-object v3, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->$capability:Ljava/lang/String;

    invoke-static {v0, v1, v2, v3}, Lsh/sth/lotterychecker/MainActivity;->access$request(Lsh/sth/lotterychecker/MainActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 151
    .local v0, "body":Ljava/lang/String;
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v2, "winner_secret"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 152
    .local v1, "encoded":Ljava/lang/String;
    iget-object v2, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-static {v2, v1}, Lsh/sth/lotterychecker/MainActivity;->access$storeWinnerSecretInsecurely(Lsh/sth/lotterychecker/MainActivity;Ljava/lang/String;)V

    .line 153
    iget-object v2, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    iget-object v3, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    new-instance v4, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1$$ExternalSyntheticLambda0;

    invoke-direct {v4, v3}, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1$$ExternalSyntheticLambda0;-><init>(Lsh/sth/lotterychecker/MainActivity;)V

    invoke-virtual {v2, v4}, Lsh/sth/lotterychecker/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Lsh/sth/lotterychecker/MainActivity$ActivationRequiredException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .end local v0    # "body":Ljava/lang/String;
    .end local v1    # "encoded":Ljava/lang/String;
    goto :goto_0

    .line 159
    :catch_0
    move-exception v0

    .line 160
    .local v0, "_":Ljava/lang/Exception;
    iget-object v1, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    iget-object v2, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    new-instance v3, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1$$ExternalSyntheticLambda2;

    invoke-direct {v3, v2}, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1$$ExternalSyntheticLambda2;-><init>(Lsh/sth/lotterychecker/MainActivity;)V

    invoke-virtual {v1, v3}, Lsh/sth/lotterychecker/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 157
    .end local v0    # "_":Ljava/lang/Exception;
    :catch_1
    move-exception v0

    .line 158
    .local v0, "_":Lsh/sth/lotterychecker/MainActivity$ActivationRequiredException;
    iget-object v1, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    iget-object v2, p0, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;->this$0:Lsh/sth/lotterychecker/MainActivity;

    new-instance v3, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1$$ExternalSyntheticLambda1;

    invoke-direct {v3, v2}, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1$$ExternalSyntheticLambda1;-><init>(Lsh/sth/lotterychecker/MainActivity;)V

    invoke-virtual {v1, v3}, Lsh/sth/lotterychecker/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 162
    .end local v0    # "_":Lsh/sth/lotterychecker/MainActivity$ActivationRequiredException;
    :goto_0
    return-void
.end method
