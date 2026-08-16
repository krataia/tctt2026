.class final Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;
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
.field final synthetic $deliveryStatus:Landroid/widget/TextView;

.field final synthetic $this_apply:Landroid/widget/Button;

.field final synthetic this$0:Lsh/sth/somtam/MainActivity;


# direct methods
.method public static synthetic $r8$lambda$SDYf6BebjglRxhGJWGwPK-1EXEg(Landroid/widget/TextView;)V
    .locals 0

    invoke-static {p0}, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->invoke$lambda$2(Landroid/widget/TextView;)V

    return-void
.end method

.method public static synthetic $r8$lambda$WoUpefobCrTvVtJng4rgKuR2yoY(Landroid/widget/TextView;Lsh/sth/somtam/MainActivity;)V
    .locals 0

    invoke-static {p0, p1}, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->invoke$lambda$1(Landroid/widget/TextView;Lsh/sth/somtam/MainActivity;)V

    return-void
.end method

.method public static synthetic $r8$lambda$YBI9ujRuudp0EQ8-_CdxP8luIOg(Landroid/widget/Button;)V
    .locals 0

    invoke-static {p0}, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->invoke$lambda$3(Landroid/widget/Button;)V

    return-void
.end method

.method public static synthetic $r8$lambda$yGjPCVyigFrCskfu1wZzlpFSqaI(Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 0

    invoke-static {p0, p1}, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->invoke$lambda$0(Landroid/widget/TextView;Ljava/lang/String;)V

    return-void
.end method

.method constructor <init>(Lsh/sth/somtam/MainActivity;Landroid/widget/TextView;Landroid/widget/Button;)V
    .locals 1

    iput-object p1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iput-object p2, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->$deliveryStatus:Landroid/widget/TextView;

    iput-object p3, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->$this_apply:Landroid/widget/Button;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method

.method private static final invoke$lambda$0(Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 1
    .param p0, "$deliveryStatus"    # Landroid/widget/TextView;
    .param p1, "$status"    # Ljava/lang/String;

    const-string v0, "$deliveryStatus"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "$status"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 172
    move-object v0, p1

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method private static final invoke$lambda$1(Landroid/widget/TextView;Lsh/sth/somtam/MainActivity;)V
    .locals 1
    .param p0, "$deliveryStatus"    # Landroid/widget/TextView;
    .param p1, "this$0"    # Lsh/sth/somtam/MainActivity;

    const-string v0, "$deliveryStatus"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "this$0"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 175
    const-string v0, "\u0e01\u0e23\u0e38\u0e13\u0e32\u0e22\u0e37\u0e19\u0e22\u0e31\u0e19\u0e01\u0e32\u0e23\u0e43\u0e0a\u0e49\u0e07\u0e32\u0e19\u0e43\u0e19\u0e40\u0e1a\u0e23\u0e32\u0e27\u0e4c\u0e40\u0e0b\u0e2d\u0e23\u0e4c"

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 176
    invoke-static {p1}, Lsh/sth/somtam/MainActivity;->access$launchActivation(Lsh/sth/somtam/MainActivity;)V

    .line 177
    return-void
.end method

.method private static final invoke$lambda$2(Landroid/widget/TextView;)V
    .locals 1
    .param p0, "$deliveryStatus"    # Landroid/widget/TextView;

    const-string v0, "$deliveryStatus"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 181
    const-string v0, "\u0e22\u0e31\u0e07\u0e15\u0e23\u0e27\u0e08\u0e1e\u0e37\u0e49\u0e19\u0e17\u0e35\u0e48\u0e08\u0e31\u0e14\u0e2a\u0e48\u0e07\u0e44\u0e21\u0e48\u0e44\u0e14\u0e49 \u0e01\u0e23\u0e38\u0e13\u0e32\u0e25\u0e2d\u0e07\u0e2d\u0e35\u0e01\u0e04\u0e23\u0e31\u0e49\u0e07"

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 182
    return-void
.end method

.method private static final invoke$lambda$3(Landroid/widget/Button;)V
    .locals 1
    .param p0, "$this_apply"    # Landroid/widget/Button;

    const-string v0, "$this_apply"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 184
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/widget/Button;->setEnabled(Z)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 169
    invoke-virtual {p0}, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .locals 5

    .line 170
    nop

    .line 171
    :try_start_0
    iget-object v0, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    invoke-static {v0}, Lsh/sth/somtam/MainActivity;->access$fetchDeliveryStatus(Lsh/sth/somtam/MainActivity;)Ljava/lang/String;

    move-result-object v0

    .line 172
    .local v0, "status":Ljava/lang/String;
    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v2, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->$deliveryStatus:Landroid/widget/TextView;

    new-instance v3, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda0;

    invoke-direct {v3, v2, v0}, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda0;-><init>(Landroid/widget/TextView;Ljava/lang/String;)V

    invoke-virtual {v1, v3}, Lsh/sth/somtam/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Lsh/sth/somtam/ActivationRequiredException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 184
    .end local v0    # "status":Ljava/lang/String;
    iget-object v0, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->$this_apply:Landroid/widget/Button;

    new-instance v2, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda1;

    invoke-direct {v2, v1}, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda1;-><init>(Landroid/widget/Button;)V

    :goto_0
    invoke-virtual {v0, v2}, Lsh/sth/somtam/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 185
    goto :goto_1

    .line 184
    :catchall_0
    move-exception v0

    goto :goto_2

    .line 178
    :catch_0
    move-exception v0

    .line 179
    .local v0, "error":Ljava/lang/Exception;
    :try_start_1
    const-string v1, "SomtamDelivery"

    const-string v2, "delivery-status request failed"

    move-object v3, v0

    check-cast v3, Ljava/lang/Throwable;

    invoke-static {v1, v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 180
    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v2, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->$deliveryStatus:Landroid/widget/TextView;

    new-instance v3, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda3;

    invoke-direct {v3, v2}, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda3;-><init>(Landroid/widget/TextView;)V

    invoke-virtual {v1, v3}, Lsh/sth/somtam/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 184
    .end local v0    # "error":Ljava/lang/Exception;
    iget-object v0, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->$this_apply:Landroid/widget/Button;

    new-instance v2, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda1;

    invoke-direct {v2, v1}, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda1;-><init>(Landroid/widget/Button;)V

    goto :goto_0

    .line 173
    :catch_1
    move-exception v0

    .line 174
    .local v0, "_":Lsh/sth/somtam/ActivationRequiredException;
    :try_start_2
    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v2, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->$deliveryStatus:Landroid/widget/TextView;

    iget-object v3, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    new-instance v4, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda2;

    invoke-direct {v4, v2, v3}, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda2;-><init>(Landroid/widget/TextView;Lsh/sth/somtam/MainActivity;)V

    invoke-virtual {v1, v4}, Lsh/sth/somtam/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 184
    .end local v0    # "_":Lsh/sth/somtam/ActivationRequiredException;
    iget-object v0, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->$this_apply:Landroid/widget/Button;

    new-instance v2, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda1;

    invoke-direct {v2, v1}, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda1;-><init>(Landroid/widget/Button;)V

    goto :goto_0

    .line 186
    :goto_1
    return-void

    .line 184
    :goto_2
    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v2, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1;->$this_apply:Landroid/widget/Button;

    new-instance v3, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda1;

    invoke-direct {v3, v2}, Lsh/sth/somtam/MainActivity$onCreate$content$1$4$2$1$1$$ExternalSyntheticLambda1;-><init>(Landroid/widget/Button;)V

    invoke-virtual {v1, v3}, Lsh/sth/somtam/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    throw v0
.end method
