.class public final Lsh/sth/skylink/PromoActivity$SkyLinkBridge;
.super Ljava/lang/Object;
.source "PromoActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lsh/sth/skylink/PromoActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "SkyLinkBridge"
.end annotation


# instance fields
.field private final vipToken:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "t"    # Ljava/lang/String;

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lsh/sth/skylink/PromoActivity$SkyLinkBridge;->vipToken:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public unlockVip()Ljava/lang/String;
    .locals 1
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .line 29
    iget-object v0, p0, Lsh/sth/skylink/PromoActivity$SkyLinkBridge;->vipToken:Ljava/lang/String;

    return-object v0
.end method
