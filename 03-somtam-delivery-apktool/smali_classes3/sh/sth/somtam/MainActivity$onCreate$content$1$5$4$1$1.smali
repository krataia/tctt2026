.class final Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;
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
    value = "SMAP\nMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivity.kt\nsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n1#2:311\n*E\n"
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
.field final synthetic $this_apply:Landroid/widget/Button;

.field final synthetic this$0:Lsh/sth/somtam/MainActivity;


# direct methods
.method public static synthetic $r8$lambda$HLBExfXLiZb_-nMTRGkqkaknP0s(Landroid/widget/Button;)V
    .locals 0

    invoke-static {p0}, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->invoke$lambda$5(Landroid/widget/Button;)V

    return-void
.end method

.method public static synthetic $r8$lambda$Zw3glCzJ6GDPJdIZQKxmY24392Q(Lsh/sth/somtam/MainActivity;)V
    .locals 0

    invoke-static {p0}, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->invoke$lambda$4(Lsh/sth/somtam/MainActivity;)V

    return-void
.end method

.method public static synthetic $r8$lambda$cWWdkBFo_-MvJRit45qgksgDm6E(Lsh/sth/somtam/MainActivity;)V
    .locals 0

    invoke-static {p0}, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->invoke$lambda$2(Lsh/sth/somtam/MainActivity;)V

    return-void
.end method

.method public static synthetic $r8$lambda$mxIZdBOvPpbuXU7R0hYiRlQhBQg(Lsh/sth/somtam/MainActivity;)V
    .locals 0

    invoke-static {p0}, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->invoke$lambda$3(Lsh/sth/somtam/MainActivity;)V

    return-void
.end method

.method constructor <init>(Lsh/sth/somtam/MainActivity;Landroid/widget/Button;)V
    .locals 1

    iput-object p1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iput-object p2, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->$this_apply:Landroid/widget/Button;

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lkotlin/jvm/internal/Lambda;-><init>(I)V

    return-void
.end method

.method private static final invoke$lambda$2(Lsh/sth/somtam/MainActivity;)V
    .locals 3
    .param p0, "this$0"    # Lsh/sth/somtam/MainActivity;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 245
    move-object v0, p0

    check-cast v0, Landroid/content/Context;

    .line 246
    const-string v1, "Keep earning points to unlock Chef\'s Special."

    check-cast v1, Ljava/lang/CharSequence;

    .line 247
    nop

    .line 244
    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 248
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 249
    return-void
.end method

.method private static final invoke$lambda$3(Lsh/sth/somtam/MainActivity;)V
    .locals 3
    .param p0, "this$0"    # Lsh/sth/somtam/MainActivity;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 253
    move-object v0, p0

    check-cast v0, Landroid/content/Context;

    .line 254
    const-string v1, "\u0e01\u0e23\u0e38\u0e13\u0e32\u0e22\u0e37\u0e19\u0e22\u0e31\u0e19\u0e01\u0e32\u0e23\u0e43\u0e0a\u0e49\u0e07\u0e32\u0e19\u0e43\u0e19\u0e40\u0e1a\u0e23\u0e32\u0e27\u0e4c\u0e40\u0e0b\u0e2d\u0e23\u0e4c"

    check-cast v1, Ljava/lang/CharSequence;

    .line 255
    nop

    .line 252
    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 256
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 257
    invoke-static {p0}, Lsh/sth/somtam/MainActivity;->access$launchActivation(Lsh/sth/somtam/MainActivity;)V

    .line 258
    return-void
.end method

.method private static final invoke$lambda$4(Lsh/sth/somtam/MainActivity;)V
    .locals 3
    .param p0, "this$0"    # Lsh/sth/somtam/MainActivity;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 262
    move-object v0, p0

    check-cast v0, Landroid/content/Context;

    .line 263
    const-string v1, "Chef\'s Special service is temporarily unavailable."

    check-cast v1, Ljava/lang/CharSequence;

    .line 264
    nop

    .line 261
    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 265
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 266
    return-void
.end method

.method private static final invoke$lambda$5(Landroid/widget/Button;)V
    .locals 1
    .param p0, "$this_apply"    # Landroid/widget/Button;

    const-string v0, "$this_apply"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 268
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/widget/Button;->setEnabled(Z)V

    return-void
.end method


# virtual methods
.method public bridge synthetic invoke()Ljava/lang/Object;
    .locals 1

    .line 237
    invoke-virtual {p0}, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->invoke()V

    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method public final invoke()V
    .locals 5

    .line 238
    nop

    .line 239
    :try_start_0
    iget-object v0, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    invoke-virtual {v0}, Lsh/sth/somtam/MainActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "payload.bin"

    invoke-virtual {v0, v1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v0

    check-cast v0, Ljava/io/Closeable;
    :try_end_0
    .catch Lsh/sth/somtam/ActivationRequiredException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    :try_start_1
    move-object v1, v0

    check-cast v1, Ljava/io/InputStream;

    .line 311
    .local v1, "it":Ljava/io/InputStream;
    const/4 v2, 0x0

    .line 239
    .local v2, "$i$a$-use-MainActivity$onCreate$content$1$5$4$1$1$payload$1":I
    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-static {v1}, Lkotlin/io/ByteStreamsKt;->readBytes(Ljava/io/InputStream;)[B

    move-result-object v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .end local v1    # "it":Ljava/io/InputStream;
    .end local v2    # "$i$a$-use-MainActivity$onCreate$content$1$5$4$1$1$payload$1":I
    const/4 v1, 0x0

    :try_start_2
    invoke-static {v0, v1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    move-object v0, v3

    .line 240
    .local v0, "payload":[B
    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    invoke-static {v1}, Lsh/sth/somtam/MainActivity;->access$fetchKeyNonce(Lsh/sth/somtam/MainActivity;)[B

    move-result-object v1

    .line 241
    .local v1, "keyNonce":[B
    array-length v2, v1

    const/16 v3, 0x10

    if-ne v2, v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    :cond_0
    const/4 v2, 0x0

    :goto_0
    if-eqz v2, :cond_1

    .line 242
    iget-object v2, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    invoke-static {v2, v0, v1}, Lsh/sth/somtam/MainActivity;->access$processPayload(Lsh/sth/somtam/MainActivity;[B[B)Ljava/lang/String;

    .line 243
    iget-object v2, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v3, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    new-instance v4, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda0;

    invoke-direct {v4, v3}, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda0;-><init>(Lsh/sth/somtam/MainActivity;)V

    invoke-virtual {v2, v4}, Lsh/sth/somtam/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_2
    .catch Lsh/sth/somtam/ActivationRequiredException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 268
    .end local v0    # "payload":[B
    .end local v1    # "keyNonce":[B
    iget-object v0, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->$this_apply:Landroid/widget/Button;

    new-instance v2, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda1;

    invoke-direct {v2, v1}, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda1;-><init>(Landroid/widget/Button;)V

    goto :goto_1

    .line 311
    .restart local v0    # "payload":[B
    .restart local v1    # "keyNonce":[B
    :cond_1
    const/4 v2, 0x0

    .line 241
    .local v2, "$i$a$-require-MainActivity$onCreate$content$1$5$4$1$1$1":I
    :try_start_3
    const-string v3, "invalid key nonce"

    .end local v2    # "$i$a$-require-MainActivity$onCreate$content$1$5$4$1$1$1":I
    new-instance v2, Ljava/lang/IllegalArgumentException;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_3
    .catch Lsh/sth/somtam/ActivationRequiredException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 239
    .end local v0    # "payload":[B
    .end local v1    # "keyNonce":[B
    :catchall_0
    move-exception v1

    :try_start_4
    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    :catchall_1
    move-exception v2

    :try_start_5
    invoke-static {v0, v1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    throw v2
    :try_end_5
    .catch Lsh/sth/somtam/ActivationRequiredException; {:try_start_5 .. :try_end_5} :catch_1
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 268
    :catchall_2
    move-exception v0

    goto :goto_2

    .line 259
    :catch_0
    move-exception v0

    .line 260
    .local v0, "_":Ljava/lang/Exception;
    :try_start_6
    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v2, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    new-instance v3, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda3;

    invoke-direct {v3, v2}, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda3;-><init>(Lsh/sth/somtam/MainActivity;)V

    invoke-virtual {v1, v3}, Lsh/sth/somtam/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 268
    .end local v0    # "_":Ljava/lang/Exception;
    iget-object v0, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->$this_apply:Landroid/widget/Button;

    new-instance v2, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda1;

    invoke-direct {v2, v1}, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda1;-><init>(Landroid/widget/Button;)V

    goto :goto_1

    .line 250
    :catch_1
    move-exception v0

    .line 251
    .local v0, "_":Lsh/sth/somtam/ActivationRequiredException;
    :try_start_7
    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v2, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    new-instance v3, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda2;

    invoke-direct {v3, v2}, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda2;-><init>(Lsh/sth/somtam/MainActivity;)V

    invoke-virtual {v1, v3}, Lsh/sth/somtam/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_2

    .line 268
    .end local v0    # "_":Lsh/sth/somtam/ActivationRequiredException;
    iget-object v0, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->$this_apply:Landroid/widget/Button;

    new-instance v2, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda1;

    invoke-direct {v2, v1}, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda1;-><init>(Landroid/widget/Button;)V

    :goto_1
    invoke-virtual {v0, v2}, Lsh/sth/somtam/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 269
    nop

    .line 270
    return-void

    .line 268
    :goto_2
    iget-object v1, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->this$0:Lsh/sth/somtam/MainActivity;

    iget-object v2, p0, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1;->$this_apply:Landroid/widget/Button;

    new-instance v3, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda1;

    invoke-direct {v3, v2}, Lsh/sth/somtam/MainActivity$onCreate$content$1$5$4$1$1$$ExternalSyntheticLambda1;-><init>(Landroid/widget/Button;)V

    invoke-virtual {v1, v3}, Lsh/sth/somtam/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    throw v0
.end method
