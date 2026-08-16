.class public final Lsh/sth/lotterychecker/CapabilityStore;
.super Ljava/lang/Object;
.source "ActivationActivity.kt"


# annotations
.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nActivationActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivationActivity.kt\nsh/sth/lotterychecker/CapabilityStore\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,157:1\n1#2:158\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"
    }
    d2 = {
        "Lsh/sth/lotterychecker/CapabilityStore;",
        "",
        "()V",
        "get",
        "",
        "context",
        "Landroid/content/Context;",
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
.field public static final INSTANCE:Lsh/sth/lotterychecker/CapabilityStore;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lsh/sth/lotterychecker/CapabilityStore;

    invoke-direct {v0}, Lsh/sth/lotterychecker/CapabilityStore;-><init>()V

    sput-object v0, Lsh/sth/lotterychecker/CapabilityStore;->INSTANCE:Lsh/sth/lotterychecker/CapabilityStore;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 147
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final get(Landroid/content/Context;)Ljava/lang/String;
    .locals 8
    .param p1, "context"    # Landroid/content/Context;

    const-string v0, "context"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 149
    const-string v0, "activation"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 150
    .local v0, "prefs":Landroid/content/SharedPreferences;
    const-wide/16 v2, 0x0

    const-string v4, "expiry"

    invoke-interface {v0, v4, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v2

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    cmp-long v2, v2, v5

    const-string v3, "capability"

    const/4 v5, 0x0

    if-gtz v2, :cond_0

    .line 151
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1, v3}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1, v4}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 152
    return-object v5

    .line 154
    :cond_0
    invoke-interface {v0, v3, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    move-object v3, v2

    .line 158
    .local v3, "it":Ljava/lang/String;
    const/4 v4, 0x0

    .line 154
    .local v4, "$i$a$-takeIf-CapabilityStore$get$1":I
    const-string v6, "ctcap1."

    const/4 v7, 0x2

    invoke-static {v3, v6, v1, v7, v5}, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z

    move-result v1

    .end local v3    # "it":Ljava/lang/String;
    .end local v4    # "$i$a$-takeIf-CapabilityStore$get$1":I
    if-eqz v1, :cond_1

    move-object v5, v2

    :cond_1
    return-object v5
.end method
