.class public Lsh/sth/skylink/PromoActivity;
.super Landroid/app/Activity;
.source "PromoActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lsh/sth/skylink/PromoActivity$SkyLinkBridge;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 11
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 34
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 35
    invoke-virtual {p0}, Lsh/sth/skylink/PromoActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "url"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 36
    .local v0, "url":Ljava/lang/String;
    invoke-virtual {p0}, Lsh/sth/skylink/PromoActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "vip_token"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 37
    .local v1, "vipToken":Ljava/lang/String;
    invoke-virtual {p0}, Lsh/sth/skylink/PromoActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "api_key"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 38
    .local v2, "apiKey":Ljava/lang/String;
    invoke-virtual {p0}, Lsh/sth/skylink/PromoActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "capability"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 40
    .local v3, "capability":Ljava/lang/String;
    new-instance v4, Landroid/webkit/WebView;

    invoke-direct {v4, p0}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 41
    .local v4, "wv":Landroid/webkit/WebView;
    invoke-virtual {v4}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v5

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 42
    invoke-static {v4}, Lsh/sth/skylink/AppRequestProfile;->configure(Landroid/webkit/WebView;)V

    .line 43
    new-instance v5, Lsh/sth/skylink/PromoActivity$SkyLinkBridge;

    invoke-direct {v5, v1}, Lsh/sth/skylink/PromoActivity$SkyLinkBridge;-><init>(Ljava/lang/String;)V

    const-string v7, "SkyLink"

    invoke-virtual {v4, v5, v7}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 44
    if-eqz v0, :cond_1

    if-eqz v2, :cond_1

    .line 45
    invoke-static {p0}, Lsh/sth/skylink/AppRequestProfile;->webHeaders(Landroid/content/Context;)Ljava/util/Map;

    move-result-object v5

    .line 46
    .local v5, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v7, "X-API-Key"

    invoke-interface {v5, v7, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    if-eqz v3, :cond_0

    .line 48
    const-string v7, "X-Challenge-Capability"

    invoke-interface {v5, v7, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    :cond_0
    invoke-virtual {v4, v0, v5}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;Ljava/util/Map;)V

    .line 51
    .end local v5    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    goto :goto_0

    .line 52
    :cond_1
    const-string v5, "about:blank"

    invoke-virtual {v4, v5}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 55
    :goto_0
    new-instance v5, Landroid/widget/TextView;

    invoke-direct {v5, p0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 56
    .local v5, "credit":Landroid/widget/TextView;
    sget v7, Lsh/sth/skylink/R$string;->footer_credit:I

    invoke-virtual {p0, v7}, Lsh/sth/skylink/PromoActivity;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 57
    new-instance v7, Landroid/widget/LinearLayout;

    invoke-direct {v7, p0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 58
    .local v7, "layout":Landroid/widget/LinearLayout;
    invoke-virtual {v7, v6}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 59
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v8, 0x0

    const/high16 v9, 0x3f800000    # 1.0f

    const/4 v10, -0x1

    invoke-direct {v6, v10, v8, v9}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    invoke-virtual {v7, v4, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 64
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v8, -0x2

    invoke-direct {v6, v10, v8}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v7, v5, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 68
    invoke-virtual {p0, v7}, Lsh/sth/skylink/PromoActivity;->setContentView(Landroid/view/View;)V

    .line 69
    return-void
.end method
