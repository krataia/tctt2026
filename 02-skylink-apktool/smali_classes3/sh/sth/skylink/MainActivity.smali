.class public Lsh/sth/skylink/MainActivity;
.super Landroid/app/Activity;
.source "MainActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lsh/sth/skylink/MainActivity$ActivationRequiredException;
    }
.end annotation


# instance fields
.field private volatile vipCheckInFlight:Z


# direct methods
.method public static synthetic $r8$lambda$5l2aEKkgBZJABk-PTZchlo2L-Hw(Lsh/sth/skylink/MainActivity;)V
    .locals 0

    invoke-direct {p0}, Lsh/sth/skylink/MainActivity;->launchActivation()V

    return-void
.end method

.method public static synthetic $r8$lambda$BaAZpUDojST_uXZZdo4uMe3rUNQ(Lsh/sth/skylink/MainActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;)V
    .locals 0

    invoke-direct/range {p0 .. p6}, Lsh/sth/skylink/MainActivity;->lambda$render$2(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$CWuwMXUzDHi_k0gGrTE6drVIJeo(Lsh/sth/skylink/MainActivity;Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lsh/sth/skylink/MainActivity;->lambda$render$4(Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;)V

    return-void
.end method

.method public static synthetic $r8$lambda$Rt4nVwyZfYyhlKH_8QdyqfYdIOA(Lsh/sth/skylink/MainActivity;Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;)V
    .locals 0

    invoke-direct/range {p0 .. p8}, Lsh/sth/skylink/MainActivity;->lambda$render$6(Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$l35z8s1BSmjvLG_arTP0c5zjp0Q(Lsh/sth/skylink/MainActivity;Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;Landroid/content/Intent;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3, p4}, Lsh/sth/skylink/MainActivity;->lambda$render$3(Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;Landroid/content/Intent;)V

    return-void
.end method

.method public static synthetic $r8$lambda$scEwJxIoCevVi-yD2ifcvaNckA8(Lsh/sth/skylink/MainActivity;Ljava/lang/Boolean;)V
    .locals 0

    invoke-direct {p0, p1}, Lsh/sth/skylink/MainActivity;->lambda$onCreate$0(Ljava/lang/Boolean;)V

    return-void
.end method

.method public static synthetic $r8$lambda$u0g8Lj2H_G-Y0VHUBbgwVYOPHY4(Lsh/sth/skylink/MainActivity;)V
    .locals 0

    invoke-direct {p0}, Lsh/sth/skylink/MainActivity;->lambda$onCreate$1()V

    return-void
.end method

.method public static synthetic $r8$lambda$vkLr5uQabxT3CeFeNGaHK91XbHQ(Lsh/sth/skylink/MainActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 0

    invoke-direct/range {p0 .. p7}, Lsh/sth/skylink/MainActivity;->lambda$render$5(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .line 36
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private static assembleToken()Ljava/lang/String;
    .locals 7

    .line 51
    const/16 v0, 0x2a

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    .line 60
    .local v0, "obf":[B
    const/16 v1, 0x5a

    .line 61
    .local v1, "key":B
    new-instance v2, Ljava/lang/StringBuilder;

    array-length v3, v0

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 62
    .local v2, "sb":Ljava/lang/StringBuilder;
    array-length v3, v0

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v3, :cond_0

    aget-byte v5, v0, v4

    .line 63
    .local v5, "b":B
    and-int/lit16 v6, v5, 0xff

    xor-int/lit8 v6, v6, 0x5a

    int-to-char v6, v6

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 62
    .end local v5    # "b":B
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 65
    :cond_0
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    nop

    :array_0
    .array-data 1
        0x7dt
        0x72t
        0x77t
        0x62t
        0x1t
        0x4t
        0x3t
        0x41t
        0x52t
        0x48t
        0x5dt
        0x57t
        0x1bt
        0x1t
        0x4t
        0x3t
        0x76t
        0x52t
        0x4ft
        0x53t
        0x52t
        0x46t
        0x45t
        0x12t
        0x51t
        0x4ft
        0x69t
        0x59t
        0x12t
        0xat
        0x1ct
        0x1t
        0x4ct
        0x46t
        0x7ct
        0x54t
        0x4at
        0x44t
        0x50t
        0x4t
        0x5at
        0x46t
    .end array-data
.end method

.method private static combineWithSalt(Ljava/lang/String;[B)Ljava/lang/String;
    .locals 4
    .param p0, "intermediate"    # Ljava/lang/String;
    .param p1, "salt"    # [B

    .line 74
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 75
    .local v0, "sb":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 76
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v2

    array-length v3, p1

    rem-int v3, v1, v3

    aget-byte v3, p1, v3

    and-int/lit16 v3, v3, 0xff

    xor-int/2addr v2, v3

    int-to-char v2, v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 75
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 78
    .end local v1    # "i":I
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private static hexToBytes(Ljava/lang/String;)[B
    .locals 4
    .param p0, "value"    # Ljava/lang/String;

    .line 271
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    new-array v0, v0, [B

    .line 272
    .local v0, "result":[B
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, v0

    if-ge v1, v2, :cond_0

    .line 273
    mul-int/lit8 v2, v1, 0x2

    mul-int/lit8 v3, v1, 0x2

    add-int/lit8 v3, v3, 0x2

    invoke-virtual {p0, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x10

    invoke-static {v2, v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 272
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 275
    .end local v1    # "i":I
    :cond_0
    return-object v0
.end method

.method private static isActivationRequired(Ljava/net/HttpURLConnection;)Z
    .locals 5
    .param p0, "connection"    # Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 230
    invoke-virtual {p0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v0

    const/16 v1, 0x193

    const/4 v2, 0x0

    if-ne v0, v1, :cond_7

    .line 231
    invoke-virtual {p0}, Ljava/net/HttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    .line 232
    invoke-virtual {p0}, Ljava/net/HttpURLConnection;->getContentType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "application/json"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_1

    .line 235
    :cond_0
    invoke-virtual {p0}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v0

    .line 236
    .local v0, "input":Ljava/io/InputStream;
    if-nez v0, :cond_2

    .line 240
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    .line 236
    :cond_1
    return v2

    .line 237
    :cond_2
    const/16 v1, 0x1001

    :try_start_0
    invoke-virtual {v0, v1}, Ljava/io/InputStream;->readNBytes(I)[B

    move-result-object v1

    .line 238
    .local v1, "body":[B
    array-length v3, v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const/16 v4, 0x1000

    if-le v3, v4, :cond_4

    .line 240
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    .line 238
    :cond_3
    return v2

    .line 239
    :cond_4
    :try_start_1
    new-instance v2, Ljava/lang/String;

    sget-object v3, Ljava/nio/charset/StandardCharsets;->UTF_8:Ljava/nio/charset/Charset;

    invoke-direct {v2, v1, v3}, Ljava/lang/String;-><init>([BLjava/nio/charset/Charset;)V

    invoke-static {v2}, Lsh/sth/skylink/MainActivity;->isActivationRequiredBody(Ljava/lang/String;)Z

    move-result v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 240
    if-eqz v0, :cond_5

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    .line 239
    :cond_5
    return v2

    .line 235
    .end local v1    # "body":[B
    :catchall_0
    move-exception v1

    if-eqz v0, :cond_6

    :try_start_2
    invoke-virtual {v0}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_0

    :catchall_1
    move-exception v2

    invoke-virtual {v1, v2}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    :cond_6
    :goto_0
    throw v1

    .line 233
    .end local v0    # "input":Ljava/io/InputStream;
    :cond_7
    :goto_1
    return v2
.end method

.method static isActivationRequiredBody(Ljava/lang/String;)Z
    .locals 6
    .param p0, "body"    # Ljava/lang/String;

    .line 245
    const-string v0, "error"

    const/4 v1, 0x0

    :try_start_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v3, 0x1000

    if-le v2, v3, :cond_0

    return v1

    .line 246
    :cond_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 247
    .local v2, "json":Lorg/json/JSONObject;
    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->opt(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    instance-of v3, v3, Ljava/lang/String;

    if-eqz v3, :cond_4

    const-string v3, "activation_required"

    .line 248
    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    goto :goto_1

    .line 249
    :cond_1
    invoke-virtual {v2}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v3

    .line 250
    .local v3, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 251
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 252
    .local v4, "key":Ljava/lang/String;
    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2

    const-string v5, "system_policy"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2

    const-string v5, "policy"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    if-nez v5, :cond_2

    return v1

    .line 253
    .end local v4    # "key":Ljava/lang/String;
    :cond_2
    goto :goto_0

    .line 254
    :cond_3
    const/4 v0, 0x1

    return v0

    .line 248
    .end local v3    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_4
    :goto_1
    return v1

    .line 255
    .end local v2    # "json":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 256
    .local v0, "ignored":Ljava/lang/Exception;
    return v1
.end method

.method private synthetic lambda$onCreate$0(Ljava/lang/Boolean;)V
    .locals 2
    .param p1, "enabled"    # Ljava/lang/Boolean;

    .line 90
    sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, p1}, Ljava/lang/Boolean;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 91
    invoke-direct {p0}, Lsh/sth/skylink/MainActivity;->launchActivation()V

    goto :goto_0

    .line 92
    :cond_0
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v0, p1}, Ljava/lang/Boolean;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 93
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lsh/sth/skylink/MainActivity;->render(Ljava/lang/String;)V

    goto :goto_0

    .line 95
    :cond_1
    new-instance v0, Landroid/widget/TextView;

    invoke-direct {v0, p0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 96
    .local v0, "error":Landroid/widget/TextView;
    const-string v1, "\u0e22\u0e31\u0e07\u0e40\u0e0a\u0e37\u0e48\u0e2d\u0e21\u0e15\u0e48\u0e2d\u0e1a\u0e23\u0e34\u0e01\u0e32\u0e23\u0e44\u0e21\u0e48\u0e44\u0e14\u0e49 \u0e01\u0e23\u0e38\u0e13\u0e32\u0e40\u0e1b\u0e34\u0e14\u0e41\u0e2d\u0e1b\u0e43\u0e2b\u0e21\u0e48\u0e2d\u0e35\u0e01\u0e04\u0e23\u0e31\u0e49\u0e07"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 97
    invoke-virtual {p0, v0}, Lsh/sth/skylink/MainActivity;->setContentView(Landroid/view/View;)V

    .line 99
    .end local v0    # "error":Landroid/widget/TextView;
    :goto_0
    return-void
.end method

.method private synthetic lambda$onCreate$1()V
    .locals 2

    .line 88
    invoke-static {p0}, Lsh/sth/skylink/ActivationActivity;->activationEnabled(Landroid/content/Context;)Ljava/lang/Boolean;

    move-result-object v0

    .line 89
    .local v0, "enabled":Ljava/lang/Boolean;
    new-instance v1, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda7;

    invoke-direct {v1, p0, v0}, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda7;-><init>(Lsh/sth/skylink/MainActivity;Ljava/lang/Boolean;)V

    invoke-virtual {p0, v1}, Lsh/sth/skylink/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 100
    return-void
.end method

.method private synthetic lambda$render$2(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;)V
    .locals 3
    .param p1, "apiBase"    # Ljava/lang/String;
    .param p2, "promoPath"    # Ljava/lang/String;
    .param p3, "apiKey"    # Ljava/lang/String;
    .param p4, "capability"    # Ljava/lang/String;
    .param p5, "vipToken"    # Ljava/lang/String;
    .param p6, "v"    # Landroid/view/View;

    .line 144
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lsh/sth/skylink/PromoActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 145
    .local v0, "i":Landroid/content/Intent;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "url"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 146
    const-string v1, "api_key"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 147
    const-string v1, "capability"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 148
    const-string v1, "vip_token"

    invoke-virtual {v0, v1, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 149
    invoke-virtual {p0, v0}, Lsh/sth/skylink/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 150
    return-void
.end method

.method private synthetic lambda$render$3(Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;Landroid/content/Intent;)V
    .locals 2
    .param p1, "checkVip"    # Landroid/widget/Button;
    .param p2, "tv"    # Landroid/widget/TextView;
    .param p3, "footer"    # Ljava/lang/String;
    .param p4, "i"    # Landroid/content/Intent;

    .line 173
    const/4 v0, 0x0

    iput-boolean v0, p0, Lsh/sth/skylink/MainActivity;->vipCheckInFlight:Z

    .line 174
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setEnabled(Z)V

    .line 175
    invoke-virtual {p0}, Lsh/sth/skylink/MainActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lsh/sth/skylink/MainActivity;->isDestroyed()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 178
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "\u0e22\u0e37\u0e19\u0e22\u0e31\u0e19\u0e2a\u0e34\u0e17\u0e18\u0e34\u0e4c\u0e01\u0e31\u0e1a SkyLink Plus \u0e41\u0e25\u0e49\u0e27\n\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 179
    invoke-virtual {p0, p4}, Lsh/sth/skylink/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 180
    return-void

    .line 176
    :cond_1
    :goto_0
    return-void
.end method

.method private synthetic lambda$render$4(Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 2
    .param p1, "checkVip"    # Landroid/widget/Button;
    .param p2, "tv"    # Landroid/widget/TextView;
    .param p3, "footer"    # Ljava/lang/String;

    .line 185
    const/4 v0, 0x0

    iput-boolean v0, p0, Lsh/sth/skylink/MainActivity;->vipCheckInFlight:Z

    .line 186
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/widget/Button;->setEnabled(Z)V

    .line 187
    invoke-virtual {p0}, Lsh/sth/skylink/MainActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lsh/sth/skylink/MainActivity;->isDestroyed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 188
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "\u0e22\u0e31\u0e07\u0e15\u0e23\u0e27\u0e08\u0e2a\u0e34\u0e17\u0e18\u0e34\u0e4c\u0e44\u0e21\u0e48\u0e44\u0e14\u0e49 \u0e01\u0e23\u0e38\u0e13\u0e32\u0e25\u0e2d\u0e07\u0e43\u0e2b\u0e21\u0e48\u0e2d\u0e35\u0e01\u0e04\u0e23\u0e31\u0e49\u0e07\n\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 190
    :cond_0
    return-void
.end method

.method private synthetic lambda$render$5(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 16
    .param p1, "apiBase"    # Ljava/lang/String;
    .param p2, "apiKey"    # Ljava/lang/String;
    .param p3, "capability"    # Ljava/lang/String;
    .param p4, "vipToken"    # Ljava/lang/String;
    .param p5, "checkVip"    # Landroid/widget/Button;
    .param p6, "tv"    # Landroid/widget/TextView;
    .param p7, "footer"    # Ljava/lang/String;

    .line 164
    move-object/from16 v7, p0

    move-object/from16 v8, p1

    move-object/from16 v9, p2

    move-object/from16 v10, p3

    move-object/from16 v11, p4

    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/api/vip-salt"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v7, v0, v9, v10}, Lsh/sth/skylink/MainActivity;->request(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 165
    .local v0, "saltJson":Ljava/lang/String;
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v2, "salt_hex"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lsh/sth/skylink/MainActivity;->hexToBytes(Ljava/lang/String;)[B

    move-result-object v1

    move-object v12, v1

    .line 166
    .local v12, "salt":[B
    invoke-static {v11, v12}, Lsh/sth/skylink/MainActivity;->combineWithSalt(Ljava/lang/String;[B)Ljava/lang/String;

    move-result-object v1

    move-object v13, v1

    .line 167
    .local v13, "token":Ljava/lang/String;
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lsh/sth/skylink/PromoActivity;

    invoke-direct {v1, v7, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object v14, v1

    .line 168
    .local v14, "i":Landroid/content/Intent;
    const-string v1, "url"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/api/vip?token="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {v13}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v14, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 169
    const-string v1, "api_key"

    invoke-virtual {v14, v1, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 170
    const-string v1, "capability"

    invoke-virtual {v14, v1, v10}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 171
    const-string v1, "vip_token"

    invoke-virtual {v14, v1, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 172
    new-instance v15, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda2;

    move-object v1, v15

    move-object/from16 v2, p0

    move-object/from16 v3, p5

    move-object/from16 v4, p6

    move-object/from16 v5, p7

    move-object v6, v14

    invoke-direct/range {v1 .. v6}, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda2;-><init>(Lsh/sth/skylink/MainActivity;Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;Landroid/content/Intent;)V

    invoke-virtual {v7, v15}, Lsh/sth/skylink/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_0
    .catch Lsh/sth/skylink/MainActivity$ActivationRequiredException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 191
    .end local v0    # "saltJson":Ljava/lang/String;
    .end local v12    # "salt":[B
    .end local v13    # "token":Ljava/lang/String;
    .end local v14    # "i":Landroid/content/Intent;
    move-object/from16 v2, p5

    move-object/from16 v3, p6

    move-object/from16 v4, p7

    goto :goto_0

    .line 183
    :catch_0
    move-exception v0

    .line 184
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda4;

    move-object/from16 v2, p5

    move-object/from16 v3, p6

    move-object/from16 v4, p7

    invoke-direct {v1, v7, v2, v3, v4}, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda4;-><init>(Lsh/sth/skylink/MainActivity;Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;)V

    invoke-virtual {v7, v1}, Lsh/sth/skylink/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 181
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v0

    move-object/from16 v2, p5

    move-object/from16 v3, p6

    move-object/from16 v4, p7

    .line 182
    .local v0, "e":Lsh/sth/skylink/MainActivity$ActivationRequiredException;
    new-instance v1, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda3;

    invoke-direct {v1, v7}, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda3;-><init>(Lsh/sth/skylink/MainActivity;)V

    invoke-virtual {v7, v1}, Lsh/sth/skylink/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 191
    .end local v0    # "e":Lsh/sth/skylink/MainActivity$ActivationRequiredException;
    nop

    .line 192
    :goto_0
    return-void
.end method

.method private synthetic lambda$render$6(Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;)V
    .locals 15
    .param p1, "checkVip"    # Landroid/widget/Button;
    .param p2, "tv"    # Landroid/widget/TextView;
    .param p3, "footer"    # Ljava/lang/String;
    .param p4, "apiBase"    # Ljava/lang/String;
    .param p5, "apiKey"    # Ljava/lang/String;
    .param p6, "capability"    # Ljava/lang/String;
    .param p7, "vipToken"    # Ljava/lang/String;
    .param p8, "v"    # Landroid/view/View;

    .line 156
    move-object v9, p0

    iget-boolean v0, v9, Lsh/sth/skylink/MainActivity;->vipCheckInFlight:Z

    if-eqz v0, :cond_0

    .line 157
    return-void

    .line 159
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, v9, Lsh/sth/skylink/MainActivity;->vipCheckInFlight:Z

    .line 160
    const/4 v0, 0x0

    move-object/from16 v10, p1

    invoke-virtual {v10, v0}, Landroid/widget/Button;->setEnabled(Z)V

    .line 161
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "\u0e01\u0e33\u0e25\u0e31\u0e07\u0e15\u0e23\u0e27\u0e08\u0e2a\u0e34\u0e17\u0e18\u0e34\u0e4c\u0e2a\u0e21\u0e32\u0e0a\u0e34\u0e01\u2026\n\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    move-object/from16 v11, p3

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object/from16 v12, p2

    invoke-virtual {v12, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 162
    new-instance v13, Ljava/lang/Thread;

    new-instance v14, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda1;

    move-object v0, v14

    move-object v1, p0

    move-object/from16 v2, p4

    move-object/from16 v3, p5

    move-object/from16 v4, p6

    move-object/from16 v5, p7

    move-object/from16 v6, p1

    move-object/from16 v7, p2

    move-object/from16 v8, p3

    invoke-direct/range {v0 .. v8}, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda1;-><init>(Lsh/sth/skylink/MainActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;)V

    invoke-direct {v13, v14}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 192
    invoke-virtual {v13}, Ljava/lang/Thread;->start()V

    .line 193
    return-void
.end method

.method private launchActivation()V
    .locals 2

    .line 261
    invoke-virtual {p0}, Lsh/sth/skylink/MainActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lsh/sth/skylink/MainActivity;->isDestroyed()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 264
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lsh/sth/skylink/ActivationActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lsh/sth/skylink/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 265
    invoke-virtual {p0}, Lsh/sth/skylink/MainActivity;->finish()V

    .line 266
    return-void

    .line 262
    :cond_1
    :goto_0
    return-void
.end method

.method private render(Ljava/lang/String;)V
    .locals 25
    .param p1, "capability"    # Ljava/lang/String;

    .line 108
    move-object/from16 v9, p0

    sget v0, Lsh/sth/skylink/R$string;->api_base:I

    invoke-virtual {v9, v0}, Lsh/sth/skylink/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 109
    .local v10, "apiBase":Ljava/lang/String;
    sget v0, Lsh/sth/skylink/R$string;->api_key:I

    invoke-virtual {v9, v0}, Lsh/sth/skylink/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v11

    .line 110
    .local v11, "apiKey":Ljava/lang/String;
    sget v0, Lsh/sth/skylink/R$string;->promo_endpoint:I

    invoke-virtual {v9, v0}, Lsh/sth/skylink/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v12

    .line 111
    .local v12, "promoPath":Ljava/lang/String;
    invoke-static {}, Lsh/sth/skylink/MainActivity;->assembleToken()Ljava/lang/String;

    move-result-object v13

    .line 112
    .local v13, "vipToken":Ljava/lang/String;
    sget v0, Lsh/sth/skylink/R$string;->footer_credit:I

    invoke-virtual {v9, v0}, Lsh/sth/skylink/MainActivity;->getString(I)Ljava/lang/String;

    move-result-object v14

    .line 114
    .local v14, "footer":Ljava/lang/String;
    new-instance v0, Landroid/widget/LinearLayout;

    invoke-direct {v0, v9}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    move-object v15, v0

    .line 115
    .local v15, "layout":Landroid/widget/LinearLayout;
    const/4 v0, 0x1

    invoke-virtual {v15, v0}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 116
    invoke-virtual/range {p0 .. p0}, Lsh/sth/skylink/MainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    const/high16 v2, 0x41800000    # 16.0f

    mul-float/2addr v1, v2

    float-to-int v8, v1

    .line 117
    .local v8, "padding":I
    invoke-virtual {v15, v8, v8, v8, v8}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 119
    new-instance v1, Landroid/widget/TextView;

    invoke-direct {v1, v9}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    move-object v7, v1

    .line 120
    .local v7, "header":Landroid/widget/TextView;
    const-string v1, "Bangkok SkyLink\n\u0e2a\u0e16\u0e32\u0e19\u0e35\u0e2a\u0e22\u0e32\u0e21\u0e40\u0e2b\u0e19\u0e37\u0e2d\n\u0e02\u0e1a\u0e27\u0e19\u0e16\u0e31\u0e14\u0e44\u0e1b 3 \u0e19\u0e32\u0e17\u0e35\n\u0e43\u0e2b\u0e49\u0e1a\u0e23\u0e34\u0e01\u0e32\u0e23\u0e1b\u0e01\u0e15\u0e34"

    invoke-virtual {v7, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 121
    const/high16 v1, 0x41b00000    # 22.0f

    invoke-virtual {v7, v1}, Landroid/widget/TextView;->setTextSize(F)V

    .line 122
    invoke-virtual {v15, v7}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 124
    new-instance v1, Landroid/widget/ImageView;

    invoke-direct {v1, v9}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    move-object v6, v1

    .line 125
    .local v6, "lineMap":Landroid/widget/ImageView;
    sget v1, Lsh/sth/skylink/R$drawable;->line_map:I

    invoke-virtual {v6, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 126
    invoke-virtual {v6, v0}, Landroid/widget/ImageView;->setAdjustViewBounds(Z)V

    .line 127
    const-string v0, "Bangkok SkyLink line map"

    invoke-virtual {v6, v0}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 128
    invoke-virtual {v15, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 130
    new-instance v0, Landroid/widget/ImageView;

    invoke-direct {v0, v9}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    move-object v5, v0

    .line 131
    .local v5, "ticketFrame":Landroid/widget/ImageView;
    sget v0, Lsh/sth/skylink/R$drawable;->ticket_frame:I

    invoke-virtual {v5, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 132
    const-string v0, "Ticket QR frame"

    invoke-virtual {v5, v0}, Landroid/widget/ImageView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 133
    invoke-virtual/range {p0 .. p0}, Lsh/sth/skylink/MainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    const/high16 v1, 0x42f00000    # 120.0f

    mul-float/2addr v0, v1

    float-to-int v4, v0

    .line 134
    .local v4, "ticketSize":I
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v0, v4, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v5, v0}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 135
    invoke-virtual {v15, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 137
    new-instance v0, Landroid/widget/TextView;

    invoke-direct {v0, v9}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    move-object v3, v0

    .line 138
    .local v3, "tv":Landroid/widget/TextView;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Bangkok SkyLink\n\n\u0e2a\u0e16\u0e32\u0e19\u0e30\u0e23\u0e30\u0e1a\u0e1a\u0e1e\u0e23\u0e49\u0e2d\u0e21\u0e43\u0e2b\u0e49\u0e1a\u0e23\u0e34\u0e01\u0e32\u0e23\n\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 139
    invoke-virtual {v15, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 141
    new-instance v0, Landroid/widget/Button;

    invoke-direct {v0, v9}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    move-object v2, v0

    .line 142
    .local v2, "openPromo":Landroid/widget/Button;
    const-string v0, "\u0e14\u0e39\u0e02\u0e49\u0e2d\u0e40\u0e2a\u0e19\u0e2d\u0e2a\u0e33\u0e2b\u0e23\u0e31\u0e1a\u0e1c\u0e39\u0e49\u0e42\u0e14\u0e22\u0e2a\u0e32\u0e23"

    invoke-virtual {v2, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 143
    new-instance v1, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda5;

    move-object v0, v1

    move-object/from16 v16, v7

    move-object v7, v1

    .end local v7    # "header":Landroid/widget/TextView;
    .local v16, "header":Landroid/widget/TextView;
    move-object/from16 v1, p0

    move/from16 v17, v8

    move-object v8, v2

    .end local v2    # "openPromo":Landroid/widget/Button;
    .local v8, "openPromo":Landroid/widget/Button;
    .local v17, "padding":I
    move-object v2, v10

    move-object/from16 v18, v3

    .end local v3    # "tv":Landroid/widget/TextView;
    .local v18, "tv":Landroid/widget/TextView;
    move-object v3, v12

    move/from16 v19, v4

    .end local v4    # "ticketSize":I
    .local v19, "ticketSize":I
    move-object v4, v11

    move-object/from16 v20, v5

    .end local v5    # "ticketFrame":Landroid/widget/ImageView;
    .local v20, "ticketFrame":Landroid/widget/ImageView;
    move-object/from16 v5, p1

    move-object/from16 v21, v6

    .end local v6    # "lineMap":Landroid/widget/ImageView;
    .local v21, "lineMap":Landroid/widget/ImageView;
    move-object v6, v13

    invoke-direct/range {v0 .. v6}, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda5;-><init>(Lsh/sth/skylink/MainActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v8, v7}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 151
    invoke-virtual {v15, v8}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 153
    new-instance v0, Landroid/widget/Button;

    invoke-direct {v0, v9}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    move-object v7, v0

    .line 154
    .local v7, "checkVip":Landroid/widget/Button;
    const-string v0, "\u0e15\u0e23\u0e27\u0e08\u0e2a\u0e34\u0e17\u0e18\u0e34\u0e4c SkyLink Plus"

    invoke-virtual {v7, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 155
    new-instance v6, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda6;

    move-object v0, v6

    move-object v2, v7

    move-object/from16 v3, v18

    move-object v4, v14

    move-object v5, v10

    move-object/from16 v22, v10

    move-object v10, v6

    .end local v10    # "apiBase":Ljava/lang/String;
    .local v22, "apiBase":Ljava/lang/String;
    move-object v6, v11

    move-object/from16 v23, v11

    move-object v11, v7

    .end local v7    # "checkVip":Landroid/widget/Button;
    .local v11, "checkVip":Landroid/widget/Button;
    .local v23, "apiKey":Ljava/lang/String;
    move-object/from16 v7, p1

    move-object/from16 v24, v8

    .end local v8    # "openPromo":Landroid/widget/Button;
    .local v24, "openPromo":Landroid/widget/Button;
    move-object v8, v13

    invoke-direct/range {v0 .. v8}, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda6;-><init>(Lsh/sth/skylink/MainActivity;Landroid/widget/Button;Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v11, v10}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 194
    invoke-virtual {v15, v11}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 196
    invoke-virtual {v9, v15}, Lsh/sth/skylink/MainActivity;->setContentView(Landroid/view/View;)V

    .line 197
    return-void
.end method

.method private static request(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "apiKey"    # Ljava/lang/String;
    .param p3, "capability"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .line 200
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 201
    .local v0, "connection":Ljava/net/HttpURLConnection;
    const-string v1, "X-API-Key"

    invoke-virtual {v0, v1, p2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 202
    invoke-static {v0, p0}, Lsh/sth/skylink/AppRequestProfile;->apply(Ljava/net/HttpURLConnection;Landroid/content/Context;)V

    .line 203
    if-eqz p3, :cond_0

    .line 204
    const-string v1, "X-Challenge-Capability"

    invoke-virtual {v0, v1, p3}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 206
    :cond_0
    const/16 v1, 0x1f40

    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    .line 207
    invoke-virtual {v0, v1}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 208
    invoke-static {v0}, Lsh/sth/skylink/MainActivity;->isActivationRequired(Ljava/net/HttpURLConnection;)Z

    move-result v1

    if-nez v1, :cond_5

    .line 212
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    const/16 v2, 0xc8

    if-ne v1, v2, :cond_4

    .line 216
    :try_start_0
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_4

    .line 217
    .local v1, "in":Ljava/io/InputStream;
    :try_start_1
    new-instance v2, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    .line 218
    .local v2, "out":Ljava/io/ByteArrayOutputStream;
    const/16 v3, 0x1000

    :try_start_2
    new-array v3, v3, [B

    .line 220
    .local v3, "buffer":[B
    :goto_0
    invoke-virtual {v1, v3}, Ljava/io/InputStream;->read([B)I

    move-result v4

    move v5, v4

    .local v5, "count":I
    const/4 v6, -0x1

    if-eq v4, v6, :cond_1

    .line 221
    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4, v5}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    goto :goto_0

    .line 223
    :cond_1
    const-string v4, "UTF-8"

    invoke-virtual {v2, v4}, Ljava/io/ByteArrayOutputStream;->toString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 224
    :try_start_3
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    if-eqz v1, :cond_2

    :try_start_4
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_4

    .line 225
    :cond_2
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 223
    return-object v4

    .line 216
    .end local v3    # "buffer":[B
    .end local v5    # "count":I
    :catchall_0
    move-exception v3

    :try_start_5
    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto :goto_1

    :catchall_1
    move-exception v4

    :try_start_6
    invoke-virtual {v3, v4}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local v1    # "in":Ljava/io/InputStream;
    .end local p0    # "context":Landroid/content/Context;
    .end local p1    # "url":Ljava/lang/String;
    .end local p2    # "apiKey":Ljava/lang/String;
    .end local p3    # "capability":Ljava/lang/String;
    :goto_1
    throw v3
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .end local v2    # "out":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local v1    # "in":Ljava/io/InputStream;
    .restart local p0    # "context":Landroid/content/Context;
    .restart local p1    # "url":Ljava/lang/String;
    .restart local p2    # "apiKey":Ljava/lang/String;
    .restart local p3    # "capability":Ljava/lang/String;
    :catchall_2
    move-exception v2

    if-eqz v1, :cond_3

    :try_start_7
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    goto :goto_2

    :catchall_3
    move-exception v3

    :try_start_8
    invoke-virtual {v2, v3}, Ljava/lang/Throwable;->addSuppressed(Ljava/lang/Throwable;)V

    .end local v0    # "connection":Ljava/net/HttpURLConnection;
    .end local p0    # "context":Landroid/content/Context;
    .end local p1    # "url":Ljava/lang/String;
    .end local p2    # "apiKey":Ljava/lang/String;
    .end local p3    # "capability":Ljava/lang/String;
    :cond_3
    :goto_2
    throw v2
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_4

    .line 225
    .end local v1    # "in":Ljava/io/InputStream;
    .restart local v0    # "connection":Ljava/net/HttpURLConnection;
    .restart local p0    # "context":Landroid/content/Context;
    .restart local p1    # "url":Ljava/lang/String;
    .restart local p2    # "apiKey":Ljava/lang/String;
    .restart local p3    # "capability":Ljava/lang/String;
    :catchall_4
    move-exception v1

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 226
    throw v1

    .line 213
    :cond_4
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 214
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "request rejected"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 209
    :cond_5
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 210
    new-instance v1, Lsh/sth/skylink/MainActivity$ActivationRequiredException;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Lsh/sth/skylink/MainActivity$ActivationRequiredException;-><init>(Lsh/sth/skylink/MainActivity$ActivationRequiredException-IA;)V

    throw v1
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 83
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 85
    invoke-static {p0}, Lsh/sth/skylink/ActivationActivity;->capability(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 86
    .local v0, "existingCapability":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 87
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda0;

    invoke-direct {v2, p0}, Lsh/sth/skylink/MainActivity$$ExternalSyntheticLambda0;-><init>(Lsh/sth/skylink/MainActivity;)V

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 100
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 101
    return-void

    .line 103
    :cond_0
    invoke-direct {p0, v0}, Lsh/sth/skylink/MainActivity;->render(Ljava/lang/String;)V

    .line 104
    return-void
.end method
