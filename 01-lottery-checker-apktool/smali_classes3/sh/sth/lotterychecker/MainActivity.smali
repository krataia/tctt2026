.class public final Lsh/sth/lotterychecker/MainActivity;
.super Landroidx/appcompat/app/AppCompatActivity;
.source "MainActivity.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lsh/sth/lotterychecker/MainActivity$ActivationRequiredException;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivity.kt\nsh/sth/lotterychecker/MainActivity\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,224:1\n1064#2,2:225\n1#3:227\n1224#4,2:228\n*S KotlinDebug\n*F\n+ 1 MainActivity.kt\nsh/sth/lotterychecker/MainActivity\n*L\n110#1:225,2\n217#1:228,2\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u00002\u00020\u0001:\u0001&B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0002J\u0008\u0010\u0012\u001a\u00020\u0011H\u0002J\u0008\u0010\u0013\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\rH\u0000\u00a2\u0006\u0002\u0008\u0019J\u0008\u0010\u001a\u001a\u00020\u0011H\u0002J\u0012\u0010\u001b\u001a\u00020\u00112\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\"\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0008\u0010!\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"
    }
    d2 = {
        "Lsh/sth/lotterychecker/MainActivity;",
        "Landroidx/appcompat/app/AppCompatActivity;",
        "()V",
        "activationLaunchStarted",
        "",
        "buySpecialButton",
        "Landroid/widget/Button;",
        "checkButton",
        "lotteryInput",
        "Landroid/widget/EditText;",
        "resultText",
        "Landroid/widget/TextView;",
        "sharedPrefsName",
        "",
        "storageMask",
        "",
        "buySpecialTicket",
        "",
        "checkActivationState",
        "checkLottery",
        "isActivationRequired",
        "connection",
        "Ljava/net/HttpURLConnection;",
        "isActivationRequiredBody",
        "body",
        "isActivationRequiredBody$app_debug",
        "launchActivation",
        "onCreate",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "request",
        "url",
        "apiKey",
        "capability",
        "setActionsEnabled",
        "enabled",
        "storeWinnerSecretInsecurely",
        "secret",
        "ActivationRequiredException",
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
.field private activationLaunchStarted:Z

.field private buySpecialButton:Landroid/widget/Button;

.field private checkButton:Landroid/widget/Button;

.field private lotteryInput:Landroid/widget/EditText;

.field private resultText:Landroid/widget/TextView;

.field private final sharedPrefsName:Ljava/lang/String;

.field private final storageMask:I


# direct methods
.method public static synthetic $r8$lambda$CHmLYqoR-YerRCZWyEHAqQnXE6Q(Lsh/sth/lotterychecker/MainActivity;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lsh/sth/lotterychecker/MainActivity;->onCreate$lambda$1(Lsh/sth/lotterychecker/MainActivity;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$q8G4zEojt43_krE-_5oEzaO9fd0(Lsh/sth/lotterychecker/MainActivity;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lsh/sth/lotterychecker/MainActivity;->onCreate$lambda$0(Lsh/sth/lotterychecker/MainActivity;Landroid/view/View;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 6

    .line 32
    invoke-direct {p0}, Landroidx/appcompat/app/AppCompatActivity;-><init>()V

    .line 41
    const/4 v4, 0x4

    const/4 v5, 0x0

    const-string v0, "winner_secrets.xml"

    const-string v1, ".xml"

    const-string v2, ""

    const/4 v3, 0x0

    invoke-static/range {v0 .. v5}, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lsh/sth/lotterychecker/MainActivity;->sharedPrefsName:Ljava/lang/String;

    .line 50
    const/16 v0, 0x5a

    iput v0, p0, Lsh/sth/lotterychecker/MainActivity;->storageMask:I

    .line 32
    return-void
.end method

.method public static final synthetic access$getResultText$p(Lsh/sth/lotterychecker/MainActivity;)Landroid/widget/TextView;
    .locals 1
    .param p0, "$this"    # Lsh/sth/lotterychecker/MainActivity;

    .line 32
    iget-object v0, p0, Lsh/sth/lotterychecker/MainActivity;->resultText:Landroid/widget/TextView;

    return-object v0
.end method

.method public static final synthetic access$launchActivation(Lsh/sth/lotterychecker/MainActivity;)V
    .locals 0
    .param p0, "$this"    # Lsh/sth/lotterychecker/MainActivity;

    .line 32
    invoke-direct {p0}, Lsh/sth/lotterychecker/MainActivity;->launchActivation()V

    return-void
.end method

.method public static final synthetic access$request(Lsh/sth/lotterychecker/MainActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "$this"    # Lsh/sth/lotterychecker/MainActivity;
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "apiKey"    # Ljava/lang/String;
    .param p3, "capability"    # Ljava/lang/String;

    .line 32
    invoke-direct {p0, p1, p2, p3}, Lsh/sth/lotterychecker/MainActivity;->request(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static final synthetic access$setActionsEnabled(Lsh/sth/lotterychecker/MainActivity;Z)V
    .locals 0
    .param p0, "$this"    # Lsh/sth/lotterychecker/MainActivity;
    .param p1, "enabled"    # Z

    .line 32
    invoke-direct {p0, p1}, Lsh/sth/lotterychecker/MainActivity;->setActionsEnabled(Z)V

    return-void
.end method

.method public static final synthetic access$storeWinnerSecretInsecurely(Lsh/sth/lotterychecker/MainActivity;Ljava/lang/String;)V
    .locals 0
    .param p0, "$this"    # Lsh/sth/lotterychecker/MainActivity;
    .param p1, "secret"    # Ljava/lang/String;

    .line 32
    invoke-direct {p0, p1}, Lsh/sth/lotterychecker/MainActivity;->storeWinnerSecretInsecurely(Ljava/lang/String;)V

    return-void
.end method

.method private final buySpecialTicket()V
    .locals 12

    .line 144
    iget-object v0, p0, Lsh/sth/lotterychecker/MainActivity;->resultText:Landroid/widget/TextView;

    if-nez v0, :cond_0

    const-string v0, "resultText"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_0
    const-string v1, "\u0e01\u0e33\u0e25\u0e31\u0e07\u0e22\u0e37\u0e19\u0e22\u0e31\u0e19\u0e01\u0e32\u0e23\u0e0b\u0e37\u0e49\u0e2d\u0e2a\u0e25\u0e32\u0e01\u0e1e\u0e34\u0e40\u0e28\u0e29\u2026"

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 145
    sget v0, Lsh/sth/lotterychecker/R$string;->api_key:I

    invoke-virtual {p0, v0}, Lsh/sth/lotterychecker/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    const-string v1, "getString(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 146
    .local v0, "apiKey":Ljava/lang/String;
    sget-object v1, Lsh/sth/lotterychecker/CapabilityStore;->INSTANCE:Lsh/sth/lotterychecker/CapabilityStore;

    move-object v2, p0

    check-cast v2, Landroid/content/Context;

    invoke-virtual {v1, v2}, Lsh/sth/lotterychecker/CapabilityStore;->get(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 147
    .local v1, "capability":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget v3, Lsh/sth/lotterychecker/R$string;->api_base_url:I

    invoke-virtual {p0, v3}, Lsh/sth/lotterychecker/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/api/purchase-material"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 148
    .local v2, "url":Ljava/lang/String;
    new-instance v3, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;

    invoke-direct {v3, p0, v2, v0, v1}, Lsh/sth/lotterychecker/MainActivity$buySpecialTicket$1;-><init>(Lsh/sth/lotterychecker/MainActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move-object v9, v3

    check-cast v9, Lkotlin/jvm/functions/Function0;

    const/16 v10, 0x1f

    const/4 v11, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-static/range {v4 .. v11}, Lkotlin/concurrent/ThreadsKt;->thread$default(ZZLjava/lang/ClassLoader;Ljava/lang/String;ILkotlin/jvm/functions/Function0;ILjava/lang/Object;)Ljava/lang/Thread;

    .line 163
    return-void
.end method

.method private final checkActivationState()V
    .locals 9

    .line 74
    sget-object v0, Lsh/sth/lotterychecker/CapabilityStore;->INSTANCE:Lsh/sth/lotterychecker/CapabilityStore;

    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    invoke-virtual {v0, v1}, Lsh/sth/lotterychecker/CapabilityStore;->get(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 75
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lsh/sth/lotterychecker/MainActivity;->setActionsEnabled(Z)V

    .line 76
    return-void

    .line 78
    :cond_0
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lsh/sth/lotterychecker/MainActivity;->setActionsEnabled(Z)V

    .line 79
    iget-object v0, p0, Lsh/sth/lotterychecker/MainActivity;->resultText:Landroid/widget/TextView;

    if-nez v0, :cond_1

    const-string v0, "resultText"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_1
    const-string v1, "\u0e01\u0e33\u0e25\u0e31\u0e07\u0e15\u0e23\u0e27\u0e08\u0e2a\u0e2d\u0e1a\u0e2a\u0e16\u0e32\u0e19\u0e30\u0e01\u0e32\u0e23\u0e40\u0e1b\u0e34\u0e14\u0e43\u0e0a\u0e49\u0e07\u0e32\u0e19\u2026"

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 80
    new-instance v0, Lsh/sth/lotterychecker/MainActivity$checkActivationState$1;

    invoke-direct {v0, p0}, Lsh/sth/lotterychecker/MainActivity$checkActivationState$1;-><init>(Lsh/sth/lotterychecker/MainActivity;)V

    move-object v6, v0

    check-cast v6, Lkotlin/jvm/functions/Function0;

    const/16 v7, 0x1f

    const/4 v8, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-static/range {v1 .. v8}, Lkotlin/concurrent/ThreadsKt;->thread$default(ZZLjava/lang/ClassLoader;Ljava/lang/String;ILkotlin/jvm/functions/Function0;ILjava/lang/Object;)Ljava/lang/Thread;

    .line 93
    return-void
.end method

.method private final checkLottery()V
    .locals 20

    .line 109
    move-object/from16 v6, p0

    iget-object v0, v6, Lsh/sth/lotterychecker/MainActivity;->lotteryInput:Landroid/widget/EditText;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    const-string v0, "lotteryInput"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-static {v0}, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 110
    .local v7, "number":Ljava/lang/String;
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v2, 0x6

    if-ne v0, v2, :cond_4

    move-object v0, v7

    check-cast v0, Ljava/lang/CharSequence;

    .local v0, "$this$all$iv":Ljava/lang/CharSequence;
    const/4 v2, 0x0

    .line 225
    .local v2, "$i$f$all":I
    const/4 v3, 0x0

    move v4, v3

    :goto_0
    invoke-interface {v0}, Ljava/lang/CharSequence;->length()I

    move-result v5

    if-ge v4, v5, :cond_2

    invoke-interface {v0, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v5

    .local v5, "element$iv":C
    move v8, v5

    .local v8, "it":C
    const/4 v9, 0x0

    .line 110
    .local v9, "$i$a$-all-MainActivity$checkLottery$1":I
    invoke-static {v8}, Ljava/lang/Character;->isDigit(C)Z

    move-result v10

    .line 225
    .end local v8    # "it":C
    .end local v9    # "$i$a$-all-MainActivity$checkLottery$1":I
    if-nez v10, :cond_1

    goto :goto_1

    .end local v5    # "element$iv":C
    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 226
    :cond_2
    const/4 v3, 0x1

    .line 110
    .end local v0    # "$this$all$iv":Ljava/lang/CharSequence;
    .end local v2    # "$i$f$all":I
    :goto_1
    if-nez v3, :cond_3

    goto :goto_2

    .line 116
    :cond_3
    sget v0, Lsh/sth/lotterychecker/R$string;->api_key:I

    invoke-virtual {v6, v0}, Lsh/sth/lotterychecker/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    const-string v0, "getString(...)"

    invoke-static {v3, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 117
    .local v3, "apiKey":Ljava/lang/String;
    sget-object v1, Lsh/sth/lotterychecker/CapabilityStore;->INSTANCE:Lsh/sth/lotterychecker/CapabilityStore;

    move-object v2, v6

    check-cast v2, Landroid/content/Context;

    invoke-virtual {v1, v2}, Lsh/sth/lotterychecker/CapabilityStore;->get(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v8

    .line 118
    .local v8, "capability":Ljava/lang/String;
    sget v1, Lsh/sth/lotterychecker/R$string;->api_base_url:I

    invoke-virtual {v6, v1}, Lsh/sth/lotterychecker/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v9, v1

    .line 119
    .local v9, "baseUrl":Ljava/lang/String;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/check?number="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 121
    .local v10, "url":Ljava/lang/String;
    new-instance v11, Lsh/sth/lotterychecker/MainActivity$checkLottery$2;

    move-object v0, v11

    move-object/from16 v1, p0

    move-object v2, v10

    move-object v4, v8

    move-object v5, v7

    invoke-direct/range {v0 .. v5}, Lsh/sth/lotterychecker/MainActivity$checkLottery$2;-><init>(Lsh/sth/lotterychecker/MainActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v17, v11

    check-cast v17, Lkotlin/jvm/functions/Function0;

    const/16 v18, 0x1f

    const/16 v19, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    invoke-static/range {v12 .. v19}, Lkotlin/concurrent/ThreadsKt;->thread$default(ZZLjava/lang/ClassLoader;Ljava/lang/String;ILkotlin/jvm/functions/Function0;ILjava/lang/Object;)Ljava/lang/Thread;

    .line 141
    return-void

    .line 111
    .end local v3    # "apiKey":Ljava/lang/String;
    .end local v8    # "capability":Ljava/lang/String;
    .end local v9    # "baseUrl":Ljava/lang/String;
    .end local v10    # "url":Ljava/lang/String;
    :cond_4
    :goto_2
    iget-object v0, v6, Lsh/sth/lotterychecker/MainActivity;->resultText:Landroid/widget/TextView;

    if-nez v0, :cond_5

    const-string v0, "resultText"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_3

    :cond_5
    move-object v1, v0

    :goto_3
    const-string v0, "\u0e01\u0e23\u0e38\u0e13\u0e32\u0e43\u0e2a\u0e48\u0e40\u0e25\u0e02\u0e2a\u0e25\u0e32\u0e01 6 \u0e2b\u0e25\u0e31\u0e01"

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 112
    return-void
.end method

.method private final isActivationRequired(Ljava/net/HttpURLConnection;)Z
    .locals 6
    .param p1, "connection"    # Ljava/net/HttpURLConnection;

    .line 202
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v0

    const/16 v1, 0x193

    const/4 v2, 0x0

    if-ne v0, v1, :cond_5

    .line 203
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, ""

    :cond_0
    const-string v1, "application/json"

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-static {v0, v1, v2, v3, v4}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    goto :goto_3

    .line 204
    :cond_1
    nop

    .line 205
    :try_start_0
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v0

    if-eqz v0, :cond_4

    sget-object v1, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    new-instance v3, Ljava/io/InputStreamReader;

    invoke-direct {v3, v0, v1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    check-cast v3, Ljava/io/Reader;

    instance-of v0, v3, Ljava/io/BufferedReader;

    if-eqz v0, :cond_2

    check-cast v3, Ljava/io/BufferedReader;

    goto :goto_0

    :cond_2
    new-instance v0, Ljava/io/BufferedReader;

    const/16 v1, 0x2000

    invoke-direct {v0, v3, v1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V

    move-object v3, v0

    :goto_0
    check-cast v3, Ljava/io/Closeable;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    move-object v0, v3

    check-cast v0, Ljava/io/BufferedReader;

    .line 227
    .local v0, "it":Ljava/io/BufferedReader;
    const/4 v1, 0x0

    .line 205
    .local v1, "$i$a$-use-MainActivity$isActivationRequired$body$1":I
    move-object v5, v0

    check-cast v5, Ljava/io/Reader;

    invoke-static {v5}, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;

    move-result-object v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .end local v0    # "it":Ljava/io/BufferedReader;
    .end local v1    # "$i$a$-use-MainActivity$isActivationRequired$body$1":I
    :try_start_2
    invoke-static {v3, v4}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    if-nez v5, :cond_3

    goto :goto_1

    :cond_3
    move-object v0, v5

    .line 206
    .local v0, "body":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lsh/sth/lotterychecker/MainActivity;->isActivationRequiredBody$app_debug(Ljava/lang/String;)Z

    move-result v2
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .end local v0    # "body":Ljava/lang/String;
    goto :goto_2

    .line 205
    :catchall_0
    move-exception v0

    .end local p1    # "connection":Ljava/net/HttpURLConnection;
    :try_start_3
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .restart local p1    # "connection":Ljava/net/HttpURLConnection;
    :catchall_1
    move-exception v1

    :try_start_4
    invoke-static {v3, v0}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    .end local p1    # "connection":Ljava/net/HttpURLConnection;
    throw v1
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    .restart local p1    # "connection":Ljava/net/HttpURLConnection;
    :cond_4
    :goto_1
    return v2

    .line 207
    :catch_0
    move-exception v0

    .line 208
    .local v0, "_":Ljava/lang/Exception;
    nop

    .line 204
    .end local v0    # "_":Ljava/lang/Exception;
    :goto_2
    return v2

    .line 203
    :cond_5
    :goto_3
    return v2
.end method

.method private final launchActivation()V
    .locals 3

    .line 101
    iget-boolean v0, p0, Lsh/sth/lotterychecker/MainActivity;->activationLaunchStarted:Z

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lsh/sth/lotterychecker/MainActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lsh/sth/lotterychecker/MainActivity;->isDestroyed()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 102
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lsh/sth/lotterychecker/MainActivity;->activationLaunchStarted:Z

    .line 103
    new-instance v0, Landroid/content/Intent;

    move-object v1, p0

    check-cast v1, Landroid/content/Context;

    const-class v2, Lsh/sth/lotterychecker/ActivationActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lsh/sth/lotterychecker/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 104
    invoke-virtual {p0}, Lsh/sth/lotterychecker/MainActivity;->finish()V

    .line 105
    return-void

    .line 101
    :cond_1
    :goto_0
    return-void
.end method

.method private static final onCreate$lambda$0(Lsh/sth/lotterychecker/MainActivity;Landroid/view/View;)V
    .locals 1
    .param p0, "this$0"    # Lsh/sth/lotterychecker/MainActivity;
    .param p1, "it"    # Landroid/view/View;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 64
    invoke-direct {p0}, Lsh/sth/lotterychecker/MainActivity;->checkLottery()V

    return-void
.end method

.method private static final onCreate$lambda$1(Lsh/sth/lotterychecker/MainActivity;Landroid/view/View;)V
    .locals 1
    .param p0, "this$0"    # Lsh/sth/lotterychecker/MainActivity;
    .param p1, "it"    # Landroid/view/View;

    const-string v0, "this$0"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 67
    invoke-direct {p0}, Lsh/sth/lotterychecker/MainActivity;->buySpecialTicket()V

    .line 68
    return-void
.end method

.method private final request(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "apiKey"    # Ljava/lang/String;
    .param p3, "capability"    # Ljava/lang/String;

    .line 180
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    const-string v1, "null cannot be cast to non-null type java.net.HttpURLConnection"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 181
    .local v0, "connection":Ljava/net/HttpURLConnection;
    nop

    .line 182
    :try_start_0
    const-string v1, "X-API-Key"

    invoke-virtual {v0, v1, p2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 183
    sget-object v1, Lsh/sth/lotterychecker/AppRequestProfile;->INSTANCE:Lsh/sth/lotterychecker/AppRequestProfile;

    move-object v2, p0

    check-cast v2, Landroid/content/Context;

    invoke-virtual {v1, v0, v2}, Lsh/sth/lotterychecker/AppRequestProfile;->apply(Ljava/net/HttpURLConnection;Landroid/content/Context;)V

    .line 184
    if-eqz p3, :cond_0

    .line 185
    const-string v1, "X-Challenge-Capability"

    invoke-virtual {v0, v1, p3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    :cond_0
    const/16 v1, 0x1f40

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 188
    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 189
    invoke-direct {p0, v0}, Lsh/sth/lotterychecker/MainActivity;->isActivationRequired(Ljava/net/HttpURLConnection;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 192
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    const/16 v2, 0xc8

    if-ne v1, v2, :cond_1

    const/4 v1, 0x1

    goto :goto_0

    :cond_1
    const/4 v1, 0x0

    :goto_0
    if-eqz v1, :cond_3

    .line 193
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    const-string v2, "getInputStream(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    sget-object v2, Lkotlin/text/Charsets;->UTF_8:Ljava/nio/charset/Charset;

    new-instance v3, Ljava/io/InputStreamReader;

    invoke-direct {v3, v1, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V

    check-cast v3, Ljava/io/Reader;

    instance-of v1, v3, Ljava/io/BufferedReader;

    if-eqz v1, :cond_2

    check-cast v3, Ljava/io/BufferedReader;

    goto :goto_1

    :cond_2
    new-instance v1, Ljava/io/BufferedReader;

    const/16 v2, 0x2000

    invoke-direct {v1, v3, v2}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;I)V

    move-object v3, v1

    :goto_1
    check-cast v3, Ljava/io/Closeable;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    :try_start_1
    move-object v1, v3

    check-cast v1, Ljava/io/BufferedReader;

    .line 227
    .local v1, "it":Ljava/io/BufferedReader;
    const/4 v2, 0x0

    .line 193
    .local v2, "$i$a$-use-MainActivity$request$1":I
    move-object v4, v1

    check-cast v4, Ljava/io/Reader;

    invoke-static {v4}, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;

    move-result-object v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .end local v1    # "it":Ljava/io/BufferedReader;
    .end local v2    # "$i$a$-use-MainActivity$request$1":I
    const/4 v1, 0x0

    :try_start_2
    invoke-static {v3, v1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 195
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 196
    nop

    .line 181
    return-object v4

    .line 193
    :catchall_0
    move-exception v1

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "url":Ljava/lang/String;
    .end local p2    # "apiKey":Ljava/lang/String;
    .end local p3    # "capability":Ljava/lang/String;
    :try_start_3
    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "url":Ljava/lang/String;
    .restart local p2    # "apiKey":Ljava/lang/String;
    .restart local p3    # "capability":Ljava/lang/String;
    :catchall_1
    move-exception v2

    :try_start_4
    invoke-static {v3, v1}, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable;Ljava/lang/Throwable;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "url":Ljava/lang/String;
    .end local p2    # "apiKey":Ljava/lang/String;
    .end local p3    # "capability":Ljava/lang/String;
    throw v2

    .line 192
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "url":Ljava/lang/String;
    .restart local p2    # "apiKey":Ljava/lang/String;
    .restart local p3    # "capability":Ljava/lang/String;
    :cond_3
    const-string v1, "Failed requirement."

    new-instance v2, Ljava/lang/IllegalArgumentException;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "url":Ljava/lang/String;
    .end local p2    # "apiKey":Ljava/lang/String;
    .end local p3    # "capability":Ljava/lang/String;
    throw v2

    .line 190
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "url":Ljava/lang/String;
    .restart local p2    # "apiKey":Ljava/lang/String;
    .restart local p3    # "capability":Ljava/lang/String;
    :cond_4
    new-instance v1, Lsh/sth/lotterychecker/MainActivity$ActivationRequiredException;

    invoke-direct {v1}, Lsh/sth/lotterychecker/MainActivity$ActivationRequiredException;-><init>()V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p1    # "url":Ljava/lang/String;
    .end local p2    # "apiKey":Ljava/lang/String;
    .end local p3    # "capability":Ljava/lang/String;
    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 195
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p1    # "url":Ljava/lang/String;
    .restart local p2    # "apiKey":Ljava/lang/String;
    .restart local p3    # "capability":Ljava/lang/String;
    :catchall_2
    move-exception v1

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    throw v1
.end method

.method private final setActionsEnabled(Z)V
    .locals 2
    .param p1, "enabled"    # Z

    .line 96
    iget-object v0, p0, Lsh/sth/lotterychecker/MainActivity;->checkButton:Landroid/widget/Button;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    const-string v0, "checkButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    invoke-virtual {v0, p1}, Landroid/widget/Button;->setEnabled(Z)V

    .line 97
    iget-object v0, p0, Lsh/sth/lotterychecker/MainActivity;->buySpecialButton:Landroid/widget/Button;

    if-nez v0, :cond_1

    const-string v0, "buySpecialButton"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    move-object v1, v0

    :goto_0
    invoke-virtual {v1, p1}, Landroid/widget/Button;->setEnabled(Z)V

    .line 98
    return-void
.end method

.method private final storeWinnerSecretInsecurely(Ljava/lang/String;)V
    .locals 6
    .param p1, "secret"    # Ljava/lang/String;

    .line 167
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 170
    .local v0, "now":J
    iget-object v2, p0, Lsh/sth/lotterychecker/MainActivity;->sharedPrefsName:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3}, Lsh/sth/lotterychecker/MainActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 171
    .local v2, "prefs":Landroid/content/SharedPreferences;
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    .line 172
    const-string v4, "special_ticket_purchased"

    const/4 v5, 0x1

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    .line 173
    const-string v4, "purchase_timestamp_ms"

    invoke-interface {v3, v4, v0, v1}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    .line 174
    const-string v4, "winner_secret"

    invoke-interface {v3, v4, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    .line 175
    const-string v4, "ticket_id"

    const-string v5, "TH-LOTO-2026-SPECIAL-0007"

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    .line 176
    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 177
    return-void
.end method


# virtual methods
.method public final isActivationRequiredBody$app_debug(Ljava/lang/String;)Z
    .locals 11
    .param p1, "body"    # Ljava/lang/String;

    const-string v0, "error"

    const-string v1, "body"

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 213
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x1000

    const/4 v3, 0x0

    if-le v1, v2, :cond_0

    return v3

    .line 214
    :cond_0
    nop

    .line 215
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 216
    .local v1, "json":Lorg/json/JSONObject;
    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    instance-of v2, v2, Ljava/lang/String;

    if-eqz v2, :cond_6

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v4, "activation_required"

    invoke-static {v2, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    goto :goto_1

    .line 217
    :cond_1
    invoke-virtual {v1}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v2

    const-string v4, "keys(...)"

    invoke-static {v2, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v2}, Lkotlin/sequences/SequencesKt;->asSequence(Ljava/util/Iterator;)Lkotlin/sequences/Sequence;

    move-result-object v2

    .local v2, "$this$all$iv":Lkotlin/sequences/Sequence;
    const/4 v4, 0x0

    .line 228
    .local v4, "$i$f$all":I
    invoke-interface {v2}, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    const/4 v7, 0x1

    if-eqz v6, :cond_5

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    .local v6, "element$iv":Ljava/lang/Object;
    move-object v8, v6

    check-cast v8, Ljava/lang/String;

    .local v8, "it":Ljava/lang/String;
    const/4 v9, 0x0

    .line 217
    .local v9, "$i$a$-all-MainActivity$isActivationRequiredBody$1":I
    invoke-static {v8, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_4

    const-string v10, "system_policy"

    invoke-static {v8, v10}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_4

    const-string v10, "policy"

    invoke-static {v8, v10}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v10
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    if-eqz v10, :cond_3

    goto :goto_0

    :cond_3
    move v7, v3

    .line 228
    .end local v8    # "it":Ljava/lang/String;
    .end local v9    # "$i$a$-all-MainActivity$isActivationRequiredBody$1":I
    :cond_4
    :goto_0
    if-nez v7, :cond_2

    goto :goto_1

    .line 229
    .end local v6    # "element$iv":Ljava/lang/Object;
    :cond_5
    move v3, v7

    .end local v1    # "json":Lorg/json/JSONObject;
    .end local v2    # "$this$all$iv":Lkotlin/sequences/Sequence;
    .end local v4    # "$i$f$all":I
    :cond_6
    :goto_1
    goto :goto_2

    .line 218
    :catch_0
    move-exception v0

    .line 219
    .local v0, "_":Ljava/lang/Exception;
    nop

    .line 214
    .end local v0    # "_":Ljava/lang/Exception;
    :goto_2
    return v3
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 53
    invoke-super {p0, p1}, Landroidx/appcompat/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 54
    sget v0, Lsh/sth/lotterychecker/R$layout;->activity_main:I

    invoke-virtual {p0, v0}, Lsh/sth/lotterychecker/MainActivity;->setContentView(I)V

    .line 56
    sget v0, Lsh/sth/lotterychecker/R$id;->lotteryInput:I

    invoke-virtual {p0, v0}, Lsh/sth/lotterychecker/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const-string v1, "findViewById(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lsh/sth/lotterychecker/MainActivity;->lotteryInput:Landroid/widget/EditText;

    .line 57
    sget v0, Lsh/sth/lotterychecker/R$id;->resultText:I

    invoke-virtual {p0, v0}, Lsh/sth/lotterychecker/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lsh/sth/lotterychecker/MainActivity;->resultText:Landroid/widget/TextView;

    .line 58
    sget v0, Lsh/sth/lotterychecker/R$id;->checkButton:I

    invoke-virtual {p0, v0}, Lsh/sth/lotterychecker/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lsh/sth/lotterychecker/MainActivity;->checkButton:Landroid/widget/Button;

    .line 59
    sget v0, Lsh/sth/lotterychecker/R$id;->buySpecialButton:I

    invoke-virtual {p0, v0}, Lsh/sth/lotterychecker/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lsh/sth/lotterychecker/MainActivity;->buySpecialButton:Landroid/widget/Button;

    .line 60
    sget v0, Lsh/sth/lotterychecker/R$id;->footerText:I

    invoke-virtual {p0, v0}, Lsh/sth/lotterychecker/MainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroid/widget/TextView;

    .line 62
    .local v0, "footerText":Landroid/widget/TextView;
    sget v1, Lsh/sth/lotterychecker/R$string;->about_text:I

    sget v2, Lsh/sth/lotterychecker/R$string;->footer_credit:I

    invoke-virtual {p0, v2}, Lsh/sth/lotterychecker/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    filled-new-array {v2}, [Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lsh/sth/lotterychecker/MainActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 64
    iget-object v1, p0, Lsh/sth/lotterychecker/MainActivity;->checkButton:Landroid/widget/Button;

    const/4 v2, 0x0

    if-nez v1, :cond_0

    const-string v1, "checkButton"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v1, v2

    :cond_0
    new-instance v3, Lsh/sth/lotterychecker/MainActivity$$ExternalSyntheticLambda0;

    invoke-direct {v3, p0}, Lsh/sth/lotterychecker/MainActivity$$ExternalSyntheticLambda0;-><init>(Lsh/sth/lotterychecker/MainActivity;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 66
    iget-object v1, p0, Lsh/sth/lotterychecker/MainActivity;->buySpecialButton:Landroid/widget/Button;

    if-nez v1, :cond_1

    const-string v1, "buySpecialButton"

    invoke-static {v1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    move-object v2, v1

    :goto_0
    new-instance v1, Lsh/sth/lotterychecker/MainActivity$$ExternalSyntheticLambda1;

    invoke-direct {v1, p0}, Lsh/sth/lotterychecker/MainActivity$$ExternalSyntheticLambda1;-><init>(Lsh/sth/lotterychecker/MainActivity;)V

    invoke-virtual {v2, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 70
    invoke-direct {p0}, Lsh/sth/lotterychecker/MainActivity;->checkActivationState()V

    .line 71
    return-void
.end method
