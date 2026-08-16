package kotlinx.coroutines.channels;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: Deprecated.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aJ\u0010\u0000\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00072\u001a\u0010\b\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\n0\t\"\u0006\u0012\u0002\b\u00030\nH\u0001¢\u0006\u0002\u0010\u000b\u001a!\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a1\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007*\u0006\u0012\u0002\b\u00030\nH\u0001\u001a!\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0007\u001aZ\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a0\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001aT\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010!\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\"\u001a\u00020\u0012H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010#\u001a+\u0010$\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\"\u001a\u00020\u0012H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010#\u001aT\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ai\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001727\u0010 \u001a3\b\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u001aT\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a$\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\b\b\u0000\u0010\u000e*\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0001\u001aA\u0010+\u001a\u0002H,\"\b\b\u0000\u0010\u000e*\u00020\u001b\"\u0010\b\u0001\u0010,*\n\u0012\u0006\b\u0000\u0012\u0002H\u000e0-*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a?\u0010+\u001a\u0002H,\"\b\b\u0000\u0010\u000e*\u00020\u001b\"\u000e\b\u0001\u0010,*\b\u0012\u0004\u0012\u0002H\u000e00*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0087@ø\u0001\u0000¢\u0006\u0002\u00101\u001a!\u00102\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a#\u00103\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a`\u00104\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172(\u00106\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50\n0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u00107\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00108\u001a\u0002H\u000eH\u0087@ø\u0001\u0000¢\u0006\u0002\u00109\u001a!\u0010:\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a)\u0010;\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00108\u001a\u0002H\u000eH\u0087@ø\u0001\u0000¢\u0006\u0002\u00109\u001a#\u0010<\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aZ\u0010=\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u00106\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ao\u0010>\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001727\u00106\u001a3\b\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0001ø\u0001\u0000¢\u0006\u0002\u0010(\u001au\u0010?\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\b\b\u0001\u00105*\u00020\u001b*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001729\u00106\u001a5\b\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u001a`\u0010@\u001a\b\u0012\u0004\u0012\u0002H50\n\"\u0004\b\u0000\u0010\u000e\"\b\b\u0001\u00105*\u00020\u001b*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172$\u00106\u001a \b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a?\u0010A\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0Cj\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`DH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010E\u001a?\u0010F\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010B\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000e0Cj\n\u0012\u0006\b\u0000\u0012\u0002H\u000e`DH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010E\u001a!\u0010G\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a$\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\b\b\u0000\u0010\u000e*\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0007\u001a!\u0010I\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a#\u0010J\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a0\u0010K\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001aT\u0010L\u001a\b\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a9\u0010M\u001a\u0002H,\"\u0004\b\u0000\u0010\u000e\"\u000e\b\u0001\u0010,*\b\u0012\u0004\u0012\u0002H\u000e00*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0081@ø\u0001\u0000¢\u0006\u0002\u00101\u001a;\u0010N\u001a\u0002H,\"\u0004\b\u0000\u0010\u000e\"\u0010\b\u0001\u0010,*\n\u0012\u0006\b\u0000\u0012\u0002H\u000e0-*\b\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a?\u0010O\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0P\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010Q*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0R0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aU\u0010O\u001a\u0002HS\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010Q\"\u0018\b\u0002\u0010S*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0015\u0012\u0006\b\u0000\u0012\u0002HQ0T*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0R0\n2\u0006\u0010.\u001a\u0002HSH\u0081@ø\u0001\u0000¢\u0006\u0002\u0010U\u001a'\u0010V\u001a\b\u0012\u0004\u0012\u0002H\u000e0W\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a'\u0010X\u001a\b\u0012\u0004\u0012\u0002H\u000e0Y\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a'\u0010Z\u001a\b\u0012\u0004\u0012\u0002H\u000e0[\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a.\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0]0\n\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001a?\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H50R0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105*\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002H50\nH\u0087\u0004\u001az\u0010^\u001a\b\u0012\u0004\u0012\u0002HQ0\n\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u00105\"\u0004\b\u0002\u0010Q*\b\u0012\u0004\u0012\u0002H\u000e0\n2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002H50\n2\b\b\u0002\u0010\u0016\u001a\u00020\u001726\u00106\u001a2\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(`\u0012\u0013\u0012\u0011H5¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(a\u0012\u0004\u0012\u0002HQ0\u0019H\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006b"}, d2 = {"consumesAll", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "channels", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "any", "", "E", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumes", "count", "", "distinct", "distinctBy", "K", "context", "Lkotlin/coroutines/CoroutineContext;", "selector", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "drop", "n", "dropWhile", "predicate", "elementAt", "index", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterNot", "filterNotNull", "filterNotNullTo", "C", "", "destination", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "first", "firstOrNull", "flatMap", "R", "transform", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapNotNull", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "requireNoNulls", "single", "singleOrNull", "take", "takeWhile", "toChannel", "toCollection", "toMap", "", "V", "Lkotlin/Pair;", "M", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", "", "toMutableSet", "", "toSet", "", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, xs = "kotlinx/coroutines/channels/ChannelsKt")
final /* synthetic */ class ChannelsKt__DeprecatedKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$any$1, reason: invalid class name */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {404}, m = "any", n = {"$this$consume$iv"}, s = {"L$0"})
    static final class AnonymousClass1<E> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.any(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$count$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "count", n = {"count", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class C00761<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00761(Continuation<? super C00761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.count(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {38}, m = "elementAt", n = {"$this$consume$iv", "index", "count"}, s = {"L$0", "I$0", "I$1"})
    static final class C00811<E> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00811(Continuation<? super C00811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.elementAt(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$elementAtOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF}, m = "elementAtOrNull", n = {"$this$consume$iv", "index", "count"}, s = {"L$0", "I$0", "I$1"})
    static final class C00821<E> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00821(Continuation<? super C00821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.elementAtOrNull(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "filterNotNullTo", n = {"destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class C00871<E, C extends Collection<? super E>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00871(Continuation<? super C00871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.filterNotNullTo((ReceiveChannel) null, (Collection) null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNullTo$3, reason: invalid class name */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {487, 242}, m = "filterNotNullTo", n = {"destination", "$this$consume$iv$iv", "destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass3<E, C extends SendChannel<? super E>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.filterNotNullTo((ReceiveChannel) null, (SendChannel) null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$first$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT}, m = "first", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
    static final class C00881<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00881(Continuation<? super C00881> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.first(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$firstOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {75}, m = "firstOrNull", n = {"$this$consume$iv", "iterator"}, s = {"L$0", "L$1"})
    static final class C00891<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00891(Continuation<? super C00891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.firstOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$indexOf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0}, l = {487}, m = "indexOf", n = {"element", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class C00911<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00911(Continuation<? super C00911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.indexOf(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$last$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {97, 100}, m = "last", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C00921<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00921(Continuation<? super C00921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.last(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastIndexOf$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 0}, l = {487}, m = "lastIndexOf", n = {"element", "lastIndex", "index", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C00931<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00931(Continuation<? super C00931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.lastIndexOf(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$lastOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1, 1}, l = {123, 126}, m = "lastOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C00941<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00941(Continuation<? super C00941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.lastOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$maxWith$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {TypedValues.CycleType.TYPE_EASING, TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE}, m = "maxWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "max"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class C00971<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00971(Continuation<? super C00971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.maxWith(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$minWith$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {434, 436}, m = "minWith", n = {"comparator", "$this$consume$iv", "iterator", "comparator", "$this$consume$iv", "iterator", "min"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class C00981<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00981(Continuation<? super C00981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.minWith(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$none$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0}, l = {447}, m = "none", n = {"$this$consume$iv"}, s = {"L$0"})
    static final class C00991<E> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00991(Continuation<? super C00991> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.none(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$single$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {136, 139}, m = "single", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C01011<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01011(Continuation<? super C01011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.single(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$singleOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {149, 152}, m = "singleOrNull", n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C01021<E> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01021(Continuation<? super C01021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt__DeprecatedKt.singleOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {487, 278}, m = "toChannel", n = {"destination", "$this$consume$iv$iv", "destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
    static final class C01051<E, C extends SendChannel<? super E>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C01051(Continuation<? super C01051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.toChannel(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toCollection$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toCollection", n = {"destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class C01061<E, C extends Collection<? super E>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C01061(Continuation<? super C01061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.toCollection(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$toMap$2, reason: invalid class name */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", f = "Deprecated.kt", i = {0, 0}, l = {487}, m = "toMap", n = {"destination", "$this$consume$iv$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass2<K, V, M extends Map<? super K, ? super V>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChannelsKt.toMap(null, null, this);
        }
    }

    public static final Function1<Throwable, Unit> consumesAll(final ReceiveChannel<?>... receiveChannelArr) {
        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.consumesAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) throws Throwable {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable cause) throws Throwable {
                Throwable exception = null;
                for (ReceiveChannel<?> receiveChannel : receiveChannelArr) {
                    try {
                        ChannelsKt.cancelConsumed(receiveChannel, cause);
                    } catch (Throwable e) {
                        if (exception == null) {
                            exception = e;
                        } else {
                            Throwable $this$addSuppressedThrowable$iv = exception;
                            ExceptionsKt.addSuppressed($this$addSuppressedThrowable$iv, e);
                        }
                    }
                }
                if (exception != null) {
                    Throwable it = exception;
                    throw it;
                }
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b A[Catch: all -> 0x00c3, TRY_LEAVE, TryCatch #1 {all -> 0x00c3, blocks: (B:26:0x0083, B:28:0x008b), top: B:54:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007a -> B:54:0x0083). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object elementAt(ReceiveChannel $this$consume$iv, int index, Continuation continuation) throws Throwable {
        C00811 c00811;
        ReceiveChannel $this$consume$iv2;
        Object $result;
        Throwable th;
        ReceiveChannel $this$consume$iv3;
        ChannelIterator channelIterator;
        int index2;
        int index3;
        Object obj;
        if (continuation instanceof C00811) {
            c00811 = (C00811) continuation;
            if ((c00811.label & Integer.MIN_VALUE) != 0) {
                c00811.label -= Integer.MIN_VALUE;
            } else {
                c00811 = new C00811(continuation);
            }
        }
        C00811 c008112 = c00811;
        Object $result2 = c008112.result;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c008112.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                try {
                    if (index < 0) {
                        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + index + '.');
                    }
                    ChannelIterator it = $this$consume$iv.iterator();
                    ReceiveChannel $this$consume$iv4 = $this$consume$iv;
                    int $i$f$consume = 0;
                    Throwable cause$iv = null;
                    int index4 = index;
                    try {
                        c008112.L$0 = $this$consume$iv4;
                        c008112.L$1 = it;
                        c008112.I$0 = index4;
                        c008112.I$1 = $i$f$consume;
                        c008112.label = 1;
                        Object objHasNext = it.hasNext(c008112);
                        if (objHasNext != $result3) {
                            return $result3;
                        }
                        Object obj2 = $result3;
                        $result = $result2;
                        $result2 = objHasNext;
                        th = cause$iv;
                        $this$consume$iv3 = $this$consume$iv4;
                        channelIterator = it;
                        index2 = index4;
                        index3 = $i$f$consume;
                        obj = obj2;
                        try {
                            if (((Boolean) $result2).booleanValue()) {
                                ReceiveChannel $this$consume$iv5 = $this$consume$iv3;
                                try {
                                    throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + index2 + '.');
                                } catch (Throwable th2) {
                                    e$iv = th2;
                                    $this$consume$iv2 = $this$consume$iv5;
                                    Throwable cause$iv2 = e$iv;
                                    try {
                                        throw e$iv;
                                    } catch (Throwable e$iv) {
                                        ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv2);
                                        throw e$iv;
                                    }
                                }
                            }
                            Object next = channelIterator.next();
                            int count = index3 + 1;
                            if (index2 == index3) {
                                ChannelsKt.cancelConsumed($this$consume$iv3, th);
                                return next;
                            }
                            ReceiveChannel $this$consume$iv6 = $this$consume$iv3;
                            cause$iv = th;
                            index4 = index2;
                            it = channelIterator;
                            $this$consume$iv4 = $this$consume$iv6;
                            $result2 = $result;
                            $result3 = obj;
                            $i$f$consume = count;
                            c008112.L$0 = $this$consume$iv4;
                            c008112.L$1 = it;
                            c008112.I$0 = index4;
                            c008112.I$1 = $i$f$consume;
                            c008112.label = 1;
                            Object objHasNext2 = it.hasNext(c008112);
                            if (objHasNext2 != $result3) {
                            }
                        } catch (Throwable th3) {
                            e$iv = th3;
                            $this$consume$iv2 = $this$consume$iv3;
                        }
                    } catch (Throwable th4) {
                        e$iv = th4;
                        $this$consume$iv2 = $this$consume$iv4;
                        Throwable cause$iv22 = e$iv;
                        throw e$iv;
                    }
                } catch (Throwable th5) {
                    e$iv = th5;
                    $this$consume$iv2 = $this$consume$iv;
                    Throwable cause$iv222 = e$iv;
                    throw e$iv;
                }
                break;
            case 1:
                int count2 = c008112.I$1;
                int index5 = c008112.I$0;
                ChannelIterator channelIterator2 = (ChannelIterator) c008112.L$1;
                ReceiveChannel receiveChannel = (ReceiveChannel) c008112.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    th = null;
                    $this$consume$iv3 = receiveChannel;
                    channelIterator = channelIterator2;
                    index2 = index5;
                    index3 = count2;
                    obj = $result3;
                    $result = $result2;
                    if (((Boolean) $result2).booleanValue()) {
                    }
                } catch (Throwable th6) {
                    e$iv = th6;
                    $this$consume$iv2 = receiveChannel;
                    Throwable cause$iv2222 = e$iv;
                    throw e$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008b A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #1 {all -> 0x00a5, blocks: (B:28:0x0083, B:30:0x008b), top: B:51:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007b -> B:51:0x0083). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object elementAtOrNull(ReceiveChannel $this$consume$iv, int index, Continuation continuation) throws Throwable {
        C00821 c00821;
        ReceiveChannel $this$consume$iv2;
        Throwable e$iv;
        int index2;
        int $i$f$consume;
        ReceiveChannel $this$consume$iv3;
        ChannelIterator it;
        Object $result;
        Throwable th;
        ChannelIterator channelIterator;
        int index3;
        int index4;
        Object obj;
        if (continuation instanceof C00821) {
            c00821 = (C00821) continuation;
            if ((c00821.label & Integer.MIN_VALUE) != 0) {
                c00821.label -= Integer.MIN_VALUE;
            } else {
                c00821 = new C00821(continuation);
            }
        }
        C00821 c008212 = c00821;
        Object $result2 = c008212.result;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c008212.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                if (index < 0) {
                    ChannelsKt.cancelConsumed($this$consume$iv, null);
                    return null;
                }
                Throwable cause$iv = null;
                try {
                    index2 = index;
                    $i$f$consume = 0;
                    $this$consume$iv3 = $this$consume$iv;
                    it = $this$consume$iv.iterator();
                } catch (Throwable th2) {
                    $this$consume$iv2 = $this$consume$iv;
                    e$iv = th2;
                    Throwable cause$iv2 = e$iv;
                    try {
                        throw e$iv;
                    } catch (Throwable e$iv2) {
                        ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv2);
                        throw e$iv2;
                    }
                }
                try {
                    c008212.L$0 = $this$consume$iv3;
                    c008212.L$1 = it;
                    c008212.I$0 = index2;
                    c008212.I$1 = $i$f$consume;
                    c008212.label = 1;
                    Object objHasNext = it.hasNext(c008212);
                    if (objHasNext != $result3) {
                        return $result3;
                    }
                    Object obj2 = $result3;
                    $result = $result2;
                    $result2 = objHasNext;
                    th = cause$iv;
                    channelIterator = it;
                    index3 = index2;
                    index4 = $i$f$consume;
                    obj = obj2;
                    try {
                        if (((Boolean) $result2).booleanValue()) {
                            ChannelsKt.cancelConsumed($this$consume$iv3, th);
                            return null;
                        }
                        Object next = channelIterator.next();
                        int count = index4 + 1;
                        if (index3 == index4) {
                            ChannelsKt.cancelConsumed($this$consume$iv3, th);
                            return next;
                        }
                        index2 = index3;
                        it = channelIterator;
                        cause$iv = th;
                        $result2 = $result;
                        $result3 = obj;
                        $i$f$consume = count;
                        c008212.L$0 = $this$consume$iv3;
                        c008212.L$1 = it;
                        c008212.I$0 = index2;
                        c008212.I$1 = $i$f$consume;
                        c008212.label = 1;
                        Object objHasNext2 = it.hasNext(c008212);
                        if (objHasNext2 != $result3) {
                        }
                    } catch (Throwable th3) {
                        e$iv = th3;
                        $this$consume$iv2 = $this$consume$iv3;
                        Throwable cause$iv22 = e$iv;
                        throw e$iv;
                    }
                } catch (Throwable th4) {
                    e$iv = th4;
                    $this$consume$iv2 = $this$consume$iv3;
                    Throwable cause$iv222 = e$iv;
                    throw e$iv;
                }
                break;
            case 1:
                int count2 = c008212.I$1;
                int index5 = c008212.I$0;
                ChannelIterator channelIterator2 = (ChannelIterator) c008212.L$1;
                ReceiveChannel receiveChannel = (ReceiveChannel) c008212.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    th = null;
                    $this$consume$iv3 = receiveChannel;
                    channelIterator = channelIterator2;
                    index3 = index5;
                    index4 = count2;
                    obj = $result3;
                    $result = $result2;
                    if (((Boolean) $result2).booleanValue()) {
                    }
                } catch (Throwable th5) {
                    e$iv = th5;
                    $this$consume$iv2 = receiveChannel;
                    Throwable cause$iv2222 = e$iv;
                    throw e$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #2 {all -> 0x003d, blocks: (B:13:0x0038, B:22:0x005f, B:24:0x0067, B:27:0x006f, B:28:0x0076), top: B:40:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006f A[Catch: all -> 0x003d, TRY_ENTER, TryCatch #2 {all -> 0x003d, blocks: (B:13:0x0038, B:22:0x005f, B:24:0x0067, B:27:0x006f, B:28:0x0076), top: B:40:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object first(ReceiveChannel $this$first, Continuation continuation) throws Throwable {
        C00881 c00881;
        ReceiveChannel $this$consume$iv;
        Throwable cause$iv;
        ReceiveChannel $this$consume$iv2;
        ChannelIterator iterator;
        Object objHasNext;
        if (continuation instanceof C00881) {
            c00881 = (C00881) continuation;
            if ((c00881.label & Integer.MIN_VALUE) != 0) {
                c00881.label -= Integer.MIN_VALUE;
            } else {
                c00881 = new C00881(continuation);
            }
        }
        C00881 c008812 = c00881;
        Object $result = c008812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c008812.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$consume$iv = $this$first;
                cause$iv = null;
                try {
                    iterator = $this$consume$iv.iterator();
                    c008812.L$0 = $this$consume$iv;
                    c008812.L$1 = iterator;
                    c008812.label = 1;
                    objHasNext = iterator.hasNext(c008812);
                    if (objHasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (((Boolean) objHasNext).booleanValue()) {
                        throw new NoSuchElementException("ReceiveChannel is empty.");
                    }
                    Object next = iterator.next();
                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                    return next;
                } catch (Throwable th) {
                    e$iv = th;
                    $this$consume$iv2 = $this$consume$iv;
                    Throwable cause$iv2 = e$iv;
                    try {
                        throw e$iv;
                    } catch (Throwable e$iv) {
                        ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv2);
                        throw e$iv;
                    }
                }
            case 1:
                iterator = (ChannelIterator) c008812.L$1;
                $this$consume$iv = (ReceiveChannel) c008812.L$0;
                cause$iv = null;
                try {
                    ResultKt.throwOnFailure($result);
                    objHasNext = $result;
                    if (((Boolean) objHasNext).booleanValue()) {
                    }
                } catch (Throwable th2) {
                    e$iv = th2;
                    $this$consume$iv2 = $this$consume$iv;
                    Throwable cause$iv22 = e$iv;
                    throw e$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006d A[Catch: all -> 0x0072, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0072, blocks: (B:22:0x0060, B:26:0x006d), top: B:37:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object firstOrNull(ReceiveChannel $this$firstOrNull, Continuation continuation) throws Throwable {
        C00891 c00891;
        ReceiveChannel $this$consume$iv;
        Throwable cause$iv;
        ReceiveChannel $this$consume$iv2;
        ChannelIterator iterator;
        Object objHasNext;
        if (continuation instanceof C00891) {
            c00891 = (C00891) continuation;
            if ((c00891.label & Integer.MIN_VALUE) != 0) {
                c00891.label -= Integer.MIN_VALUE;
            } else {
                c00891 = new C00891(continuation);
            }
        }
        C00891 c008912 = c00891;
        Object $result = c008912.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object next = null;
        switch (c008912.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$consume$iv = $this$firstOrNull;
                cause$iv = null;
                try {
                    iterator = $this$consume$iv.iterator();
                    c008912.L$0 = $this$consume$iv;
                    c008912.L$1 = iterator;
                    c008912.label = 1;
                    objHasNext = iterator.hasNext(c008912);
                    if (objHasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    try {
                        if (((Boolean) objHasNext).booleanValue()) {
                            next = iterator.next();
                            break;
                        }
                        ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                        return next;
                    } catch (Throwable th) {
                        e$iv = th;
                        $this$consume$iv2 = $this$consume$iv;
                        Throwable cause$iv2 = e$iv;
                        try {
                            throw e$iv;
                        } catch (Throwable e$iv) {
                            ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv2);
                            throw e$iv;
                        }
                    }
                } catch (Throwable th2) {
                    e$iv = th2;
                    $this$consume$iv2 = $this$consume$iv;
                    Throwable cause$iv22 = e$iv;
                    throw e$iv;
                }
            case 1:
                ChannelIterator iterator2 = (ChannelIterator) c008912.L$1;
                $this$consume$iv = (ReceiveChannel) c008912.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objHasNext = $result;
                    iterator = iterator2;
                    cause$iv = null;
                    if (((Boolean) objHasNext).booleanValue()) {
                    }
                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                    return next;
                } catch (Throwable th3) {
                    e$iv = th3;
                    $this$consume$iv2 = $this$consume$iv;
                    Throwable cause$iv222 = e$iv;
                    throw e$iv;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009e A[Catch: all -> 0x00eb, TryCatch #5 {all -> 0x00eb, blocks: (B:24:0x0096, B:26:0x009e, B:28:0x00aa), top: B:63:0x0096 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0089 -> B:63:0x0096). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object indexOf(ReceiveChannel $this$consume$iv$iv, Object element, Continuation continuation) throws Throwable {
        C00911 c00911;
        ReceiveChannel $this$consume$iv$iv2;
        Object element2;
        Object element3;
        ReceiveChannel $this$consume$iv$iv3;
        Object $result;
        ChannelIterator it;
        Ref.IntRef index;
        Ref.IntRef index2;
        Throwable cause$iv$iv;
        Object objHasNext;
        Object $result2;
        Throwable th;
        Object element4;
        Ref.IntRef index3;
        ReceiveChannel receiveChannel;
        ChannelIterator channelIterator;
        Ref.IntRef intRef;
        Object obj;
        Object obj2;
        if (continuation instanceof C00911) {
            c00911 = (C00911) continuation;
            if ((c00911.label & Integer.MIN_VALUE) != 0) {
                c00911.label -= Integer.MIN_VALUE;
            } else {
                c00911 = new C00911(continuation);
            }
        }
        Object $result3 = c00911.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00911.label) {
            case 0:
                ResultKt.throwOnFailure($result3);
                Ref.IntRef index4 = new Ref.IntRef();
                try {
                    element2 = element;
                    element3 = null;
                    $this$consume$iv$iv3 = $this$consume$iv$iv;
                    $result = null;
                    it = $this$consume$iv$iv.iterator();
                    index = index4;
                    index2 = null;
                    cause$iv$iv = null;
                    try {
                        c00911.L$0 = element2;
                        c00911.L$1 = index;
                        c00911.L$2 = $this$consume$iv$iv3;
                        c00911.L$3 = it;
                        c00911.label = 1;
                        objHasNext = it.hasNext(c00911);
                    } catch (Throwable th2) {
                        e$iv$iv = th2;
                        $this$consume$iv$iv2 = $this$consume$iv$iv3;
                    }
                } catch (Throwable th3) {
                    e$iv$iv = th3;
                    $this$consume$iv$iv2 = $this$consume$iv$iv;
                }
                if (objHasNext != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Object obj3 = $result;
                $result2 = $result3;
                $result3 = objHasNext;
                th = cause$iv$iv;
                element4 = element2;
                index3 = index;
                receiveChannel = $this$consume$iv$iv3;
                channelIterator = it;
                intRef = index2;
                obj = element3;
                obj2 = obj3;
                try {
                    if (((Boolean) $result3).booleanValue()) {
                        $this$consume$iv$iv2 = receiveChannel;
                        Throwable cause$iv$iv2 = th;
                        try {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv2);
                            return Boxing.boxInt(-1);
                        } catch (Throwable th4) {
                            e$iv$iv = th4;
                        }
                    } else {
                        Object e$iv = channelIterator.next();
                        if (Intrinsics.areEqual(element4, e$iv)) {
                            Integer numBoxInt = Boxing.boxInt(index3.element);
                            ChannelsKt.cancelConsumed(receiveChannel, th);
                            return numBoxInt;
                        }
                        ReceiveChannel $this$consume$iv$iv4 = receiveChannel;
                        Throwable cause$iv$iv3 = th;
                        try {
                            index3.element++;
                            ChannelIterator channelIterator2 = channelIterator;
                            $this$consume$iv$iv3 = $this$consume$iv$iv4;
                            $result3 = $result2;
                            $result = obj2;
                            element3 = obj;
                            index2 = intRef;
                            it = channelIterator2;
                            Object obj4 = element4;
                            cause$iv$iv = cause$iv$iv3;
                            index = index3;
                            element2 = obj4;
                            c00911.L$0 = element2;
                            c00911.L$1 = index;
                            c00911.L$2 = $this$consume$iv$iv3;
                            c00911.L$3 = it;
                            c00911.label = 1;
                            objHasNext = it.hasNext(c00911);
                            if (objHasNext != coroutine_suspended) {
                            }
                        } catch (Throwable th5) {
                            e$iv$iv = th5;
                            $this$consume$iv$iv2 = $this$consume$iv$iv4;
                        }
                    }
                } catch (Throwable th6) {
                    e$iv$iv = th6;
                    $this$consume$iv$iv2 = receiveChannel;
                }
                Throwable cause$iv$iv4 = e$iv$iv;
                try {
                    throw e$iv$iv;
                } catch (Throwable e$iv$iv) {
                    ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv4);
                    throw e$iv$iv;
                }
                break;
            case 1:
                ChannelIterator channelIterator3 = (ChannelIterator) c00911.L$3;
                ReceiveChannel receiveChannel2 = (ReceiveChannel) c00911.L$2;
                Ref.IntRef index5 = (Ref.IntRef) c00911.L$1;
                Object element5 = c00911.L$0;
                try {
                    ResultKt.throwOnFailure($result3);
                    th = null;
                    element4 = element5;
                    index3 = index5;
                    receiveChannel = receiveChannel2;
                    channelIterator = channelIterator3;
                    intRef = null;
                    obj = null;
                    obj2 = null;
                    $result2 = $result3;
                    if (((Boolean) $result3).booleanValue()) {
                    }
                } catch (Throwable th7) {
                    e$iv$iv = th7;
                    $this$consume$iv$iv2 = receiveChannel2;
                }
                Throwable cause$iv$iv42 = e$iv$iv;
                throw e$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008b A[Catch: all -> 0x00de, TRY_LEAVE, TryCatch #5 {all -> 0x00de, blocks: (B:27:0x0083, B:29:0x008b, B:45:0x00d6, B:46:0x00dd), top: B:65:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7 A[Catch: all -> 0x00cb, TRY_LEAVE, TryCatch #4 {all -> 0x00cb, blocks: (B:35:0x00af, B:37:0x00b7), top: B:63:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6 A[Catch: all -> 0x00de, TRY_ENTER, TryCatch #5 {all -> 0x00de, blocks: (B:27:0x0083, B:29:0x008b, B:45:0x00d6, B:46:0x00dd), top: B:65:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a6 -> B:63:0x00af). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object last(ReceiveChannel $this$last, Continuation continuation) throws Throwable {
        C00921 c00921;
        ReceiveChannel $this$consume$iv;
        int i;
        Object objHasNext;
        Throwable cause$iv;
        ChannelIterator iterator;
        Object $result;
        Throwable th;
        ReceiveChannel receiveChannel;
        ChannelIterator iterator2;
        Object obj;
        int i2;
        Object obj2;
        if (continuation instanceof C00921) {
            c00921 = (C00921) continuation;
            if ((c00921.label & Integer.MIN_VALUE) != 0) {
                c00921.label -= Integer.MIN_VALUE;
            } else {
                c00921 = new C00921(continuation);
            }
        }
        C00921 c009212 = c00921;
        Object last = c009212.result;
        Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c009212.label) {
            case 0:
                ResultKt.throwOnFailure(last);
                $this$consume$iv = $this$last;
                i = 0;
                try {
                    ChannelIterator iterator3 = $this$consume$iv.iterator();
                    c009212.L$0 = $this$consume$iv;
                    c009212.L$1 = iterator3;
                    c009212.label = 1;
                    objHasNext = iterator3.hasNext(c009212);
                    if (objHasNext == $result2) {
                        return $result2;
                    }
                    cause$iv = null;
                    iterator = iterator3;
                    try {
                        if (((Boolean) objHasNext).booleanValue()) {
                            throw new NoSuchElementException("ReceiveChannel is empty.");
                        }
                        int i3 = i;
                        ReceiveChannel $this$consume$iv2 = $this$consume$iv;
                        int i4 = i3;
                        Throwable th2 = cause$iv;
                        ChannelIterator iterator4 = iterator;
                        Object last2 = iterator.next();
                        Throwable cause$iv2 = th2;
                        try {
                            c009212.L$0 = $this$consume$iv2;
                            c009212.L$1 = iterator4;
                            c009212.L$2 = last2;
                            c009212.label = 2;
                            Object objHasNext2 = iterator4.hasNext(c009212);
                            if (objHasNext2 != $result2) {
                                return $result2;
                            }
                            Object obj3 = $result2;
                            $result = last;
                            last = objHasNext2;
                            th = cause$iv2;
                            receiveChannel = $this$consume$iv2;
                            iterator2 = iterator4;
                            obj = last2;
                            i2 = i4;
                            obj2 = obj3;
                            try {
                                if (((Boolean) last).booleanValue()) {
                                    ChannelsKt.cancelConsumed(receiveChannel, th);
                                    return obj;
                                }
                                ReceiveChannel $this$consume$iv3 = receiveChannel;
                                cause$iv2 = th;
                                int i5 = i2;
                                last2 = iterator2.next();
                                last = $result;
                                $result2 = obj2;
                                i4 = i5;
                                ChannelIterator channelIterator = iterator2;
                                $this$consume$iv2 = $this$consume$iv3;
                                iterator4 = channelIterator;
                                c009212.L$0 = $this$consume$iv2;
                                c009212.L$1 = iterator4;
                                c009212.L$2 = last2;
                                c009212.label = 2;
                                Object objHasNext22 = iterator4.hasNext(c009212);
                                if (objHasNext22 != $result2) {
                                }
                            } catch (Throwable th3) {
                                $this$consume$iv = receiveChannel;
                                e$iv = th3;
                                Throwable cause$iv3 = e$iv;
                                try {
                                    throw e$iv;
                                } catch (Throwable e$iv) {
                                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv3);
                                    throw e$iv;
                                }
                            }
                        } catch (Throwable th4) {
                            e$iv = th4;
                            $this$consume$iv = $this$consume$iv2;
                            Throwable cause$iv32 = e$iv;
                            throw e$iv;
                        }
                    } catch (Throwable th5) {
                        e$iv = th5;
                        Throwable cause$iv322 = e$iv;
                        throw e$iv;
                    }
                } catch (Throwable th6) {
                    e$iv = th6;
                    Throwable cause$iv3222 = e$iv;
                    throw e$iv;
                }
                break;
            case 1:
                iterator = (ChannelIterator) c009212.L$1;
                cause$iv = null;
                ReceiveChannel $this$consume$iv4 = (ReceiveChannel) c009212.L$0;
                try {
                    ResultKt.throwOnFailure(last);
                    objHasNext = last;
                    i = 0;
                    $this$consume$iv = $this$consume$iv4;
                    if (((Boolean) objHasNext).booleanValue()) {
                    }
                } catch (Throwable th7) {
                    e$iv = th7;
                    $this$consume$iv = $this$consume$iv4;
                    Throwable cause$iv32222 = e$iv;
                    throw e$iv;
                }
                break;
            case 2:
                Object last3 = c009212.L$2;
                ChannelIterator iterator5 = (ChannelIterator) c009212.L$1;
                ReceiveChannel receiveChannel2 = (ReceiveChannel) c009212.L$0;
                try {
                    ResultKt.throwOnFailure(last);
                    th = null;
                    receiveChannel = receiveChannel2;
                    iterator2 = iterator5;
                    obj = last3;
                    i2 = 0;
                    obj2 = $result2;
                    $result = last;
                    if (((Boolean) last).booleanValue()) {
                    }
                } catch (Throwable th8) {
                    e$iv = th8;
                    $this$consume$iv = receiveChannel2;
                    Throwable cause$iv322222 = e$iv;
                    throw e$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a9 A[Catch: all -> 0x00d7, TryCatch #2 {all -> 0x00d7, blocks: (B:24:0x00a1, B:26:0x00a9, B:28:0x00b4, B:29:0x00b8, B:30:0x00c8), top: B:46:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8 A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #2 {all -> 0x00d7, blocks: (B:24:0x00a1, B:26:0x00a9, B:28:0x00b4, B:29:0x00b8, B:30:0x00c8), top: B:46:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0093 -> B:46:0x00a1). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object lastIndexOf(ReceiveChannel $this$consumeEach$iv, Object element, Continuation continuation) throws Throwable {
        C00931 c00931;
        ReceiveChannel $this$consume$iv$iv;
        Object $result;
        Object element2;
        Ref.IntRef lastIndex;
        Ref.IntRef lastIndex2;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv;
        ChannelIterator channelIterator;
        Ref.IntRef intRef;
        Object obj;
        int $i$f$consume;
        if (continuation instanceof C00931) {
            c00931 = (C00931) continuation;
            if ((c00931.label & Integer.MIN_VALUE) != 0) {
                c00931.label -= Integer.MIN_VALUE;
            } else {
                c00931 = new C00931(continuation);
            }
        }
        Object $result2 = c00931.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00931.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                Ref.IntRef lastIndex3 = new Ref.IntRef();
                lastIndex3.element = -1;
                Ref.IntRef index = new Ref.IntRef();
                $this$consume$iv$iv = $this$consumeEach$iv;
                try {
                    Ref.IntRef index2 = lastIndex3;
                    Ref.IntRef lastIndex4 = null;
                    Object element3 = element;
                    Object element4 = null;
                    int $i$f$consume2 = 0;
                    Throwable cause$iv$iv2 = null;
                    Ref.IntRef index3 = index;
                    ChannelIterator it = $this$consume$iv$iv.iterator();
                    c00931.L$0 = element3;
                    c00931.L$1 = index2;
                    c00931.L$2 = index3;
                    c00931.L$3 = $this$consume$iv$iv;
                    c00931.L$4 = it;
                    c00931.label = 1;
                    Object objHasNext = it.hasNext(c00931);
                    if (objHasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    int i = $i$f$consume2;
                    $result = $result2;
                    $result2 = objHasNext;
                    element2 = element3;
                    lastIndex = index2;
                    lastIndex2 = index3;
                    $this$consume$iv$iv2 = $this$consume$iv$iv;
                    cause$iv$iv = cause$iv$iv2;
                    channelIterator = it;
                    intRef = lastIndex4;
                    obj = element4;
                    $i$f$consume = i;
                    try {
                        if (((Boolean) $result2).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv);
                            return Boxing.boxInt(lastIndex.element);
                        }
                        Object it2 = channelIterator.next();
                        if (Intrinsics.areEqual(element2, it2)) {
                            lastIndex.element = lastIndex2.element;
                        }
                        lastIndex2.element++;
                        $result2 = $result;
                        $i$f$consume2 = $i$f$consume;
                        element4 = obj;
                        lastIndex4 = intRef;
                        it = channelIterator;
                        cause$iv$iv2 = cause$iv$iv;
                        $this$consume$iv$iv = $this$consume$iv$iv2;
                        index3 = lastIndex2;
                        index2 = lastIndex;
                        element3 = element2;
                        c00931.L$0 = element3;
                        c00931.L$1 = index2;
                        c00931.L$2 = index3;
                        c00931.L$3 = $this$consume$iv$iv;
                        c00931.L$4 = it;
                        c00931.label = 1;
                        Object objHasNext2 = it.hasNext(c00931);
                        if (objHasNext2 != coroutine_suspended) {
                        }
                    } catch (Throwable th) {
                        e$iv$iv = th;
                        $this$consume$iv$iv = $this$consume$iv$iv2;
                        Throwable cause$iv$iv3 = e$iv$iv;
                        try {
                            throw e$iv$iv;
                        } catch (Throwable e$iv$iv) {
                            ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv3);
                            throw e$iv$iv;
                        }
                    }
                } catch (Throwable th2) {
                    e$iv$iv = th2;
                    Throwable cause$iv$iv32 = e$iv$iv;
                    throw e$iv$iv;
                }
                break;
            case 1:
                ChannelIterator channelIterator2 = (ChannelIterator) c00931.L$4;
                $this$consume$iv$iv = (ReceiveChannel) c00931.L$3;
                Ref.IntRef index4 = (Ref.IntRef) c00931.L$2;
                Ref.IntRef lastIndex5 = (Ref.IntRef) c00931.L$1;
                Object element5 = c00931.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    element2 = element5;
                    lastIndex = lastIndex5;
                    lastIndex2 = index4;
                    $this$consume$iv$iv2 = $this$consume$iv$iv;
                    cause$iv$iv = null;
                    channelIterator = channelIterator2;
                    intRef = null;
                    obj = null;
                    $i$f$consume = 0;
                    $result = $result2;
                    if (((Boolean) $result2).booleanValue()) {
                    }
                } catch (Throwable th3) {
                    e$iv$iv = th3;
                    Throwable cause$iv$iv322 = e$iv$iv;
                    throw e$iv$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #5 {all -> 0x00ca, blocks: (B:39:0x00ae, B:41:0x00b6), top: B:70:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00a5 -> B:70:0x00ae). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object lastOrNull(ReceiveChannel $this$consume$iv, Continuation continuation) throws Throwable {
        C00941 c00941;
        int $i$f$consume;
        Throwable cause$iv;
        ReceiveChannel $this$consume$iv2;
        Throwable e$iv;
        ChannelIterator iterator;
        Object objHasNext;
        ReceiveChannel receiveChannel;
        Object $result;
        ReceiveChannel $this$consume$iv3;
        ChannelIterator iterator2;
        Object obj;
        Throwable th;
        int $i$f$consume2;
        Object obj2;
        if (continuation instanceof C00941) {
            c00941 = (C00941) continuation;
            if ((c00941.label & Integer.MIN_VALUE) != 0) {
                c00941.label -= Integer.MIN_VALUE;
            } else {
                c00941 = new C00941(continuation);
            }
        }
        C00941 c009412 = c00941;
        Object last = c009412.result;
        Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c009412.label) {
            case 0:
                ResultKt.throwOnFailure(last);
                $i$f$consume = 0;
                cause$iv = null;
                try {
                    iterator = $this$consume$iv.iterator();
                    c009412.L$0 = $this$consume$iv;
                    c009412.L$1 = iterator;
                    c009412.label = 1;
                    objHasNext = iterator.hasNext(c009412);
                    if (objHasNext == $result2) {
                        return $result2;
                    }
                    receiveChannel = $this$consume$iv;
                    try {
                        if (((Boolean) objHasNext).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel, cause$iv);
                            return null;
                        }
                        ReceiveChannel $this$consume$iv4 = receiveChannel;
                        try {
                            ReceiveChannel $this$consume$iv5 = $this$consume$iv4;
                            Throwable cause$iv2 = cause$iv;
                            Object last2 = iterator.next();
                            try {
                                c009412.L$0 = $this$consume$iv5;
                                c009412.L$1 = iterator;
                                c009412.L$2 = last2;
                                c009412.label = 2;
                                Object objHasNext2 = iterator.hasNext(c009412);
                                if (objHasNext2 != $result2) {
                                    return $result2;
                                }
                                Object obj3 = $result2;
                                $result = last;
                                last = objHasNext2;
                                $this$consume$iv3 = $this$consume$iv5;
                                iterator2 = iterator;
                                obj = last2;
                                th = cause$iv2;
                                $i$f$consume2 = $i$f$consume;
                                obj2 = obj3;
                                try {
                                    if (((Boolean) last).booleanValue()) {
                                        ChannelsKt.cancelConsumed($this$consume$iv3, th);
                                        return obj;
                                    }
                                    Throwable th2 = th;
                                    last2 = iterator2.next();
                                    last = $result;
                                    $result2 = obj2;
                                    $i$f$consume = $i$f$consume2;
                                    cause$iv2 = th2;
                                    ChannelIterator channelIterator = iterator2;
                                    $this$consume$iv5 = $this$consume$iv3;
                                    iterator = channelIterator;
                                    c009412.L$0 = $this$consume$iv5;
                                    c009412.L$1 = iterator;
                                    c009412.L$2 = last2;
                                    c009412.label = 2;
                                    Object objHasNext22 = iterator.hasNext(c009412);
                                    if (objHasNext22 != $result2) {
                                    }
                                } catch (Throwable th3) {
                                    e$iv = th3;
                                    $this$consume$iv2 = $this$consume$iv3;
                                    Throwable cause$iv3 = e$iv;
                                    try {
                                        throw e$iv;
                                    } catch (Throwable e$iv2) {
                                        ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv3);
                                        throw e$iv2;
                                    }
                                }
                            } catch (Throwable th4) {
                                e$iv = th4;
                                $this$consume$iv2 = $this$consume$iv5;
                                Throwable cause$iv32 = e$iv;
                                throw e$iv;
                            }
                        } catch (Throwable th5) {
                            e$iv = th5;
                            $this$consume$iv2 = $this$consume$iv4;
                            Throwable cause$iv322 = e$iv;
                            throw e$iv;
                        }
                    } catch (Throwable th6) {
                        e$iv = th6;
                        $this$consume$iv2 = receiveChannel;
                    }
                } catch (Throwable th7) {
                    $this$consume$iv2 = $this$consume$iv;
                    e$iv = th7;
                    Throwable cause$iv3222 = e$iv;
                    throw e$iv;
                }
                break;
            case 1:
                $i$f$consume = 0;
                ChannelIterator iterator3 = (ChannelIterator) c009412.L$1;
                ReceiveChannel receiveChannel2 = (ReceiveChannel) c009412.L$0;
                try {
                    ResultKt.throwOnFailure(last);
                    objHasNext = last;
                    receiveChannel = receiveChannel2;
                    iterator = iterator3;
                    cause$iv = null;
                    if (((Boolean) objHasNext).booleanValue()) {
                    }
                } catch (Throwable th8) {
                    e$iv = th8;
                    $this$consume$iv2 = receiveChannel2;
                    Throwable cause$iv32222 = e$iv;
                    throw e$iv;
                }
                break;
            case 2:
                Object last3 = c009412.L$2;
                ChannelIterator iterator4 = (ChannelIterator) c009412.L$1;
                ReceiveChannel receiveChannel3 = (ReceiveChannel) c009412.L$0;
                try {
                    ResultKt.throwOnFailure(last);
                    $this$consume$iv3 = receiveChannel3;
                    iterator2 = iterator4;
                    obj = last3;
                    th = null;
                    $i$f$consume2 = 0;
                    obj2 = $result2;
                    $result = last;
                    if (((Boolean) last).booleanValue()) {
                    }
                } catch (Throwable th9) {
                    e$iv = th9;
                    $this$consume$iv2 = receiveChannel3;
                    Throwable cause$iv322222 = e$iv;
                    throw e$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0080 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #0 {all -> 0x0051, blocks: (B:18:0x004c, B:27:0x0078, B:29:0x0080, B:39:0x00aa, B:40:0x00b1), top: B:47:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a2 A[Catch: all -> 0x003c, TRY_ENTER, TryCatch #3 {all -> 0x003c, blocks: (B:13:0x0036, B:33:0x0095, B:37:0x00a2, B:38:0x00a9), top: B:52:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa A[Catch: all -> 0x0051, TRY_ENTER, TryCatch #0 {all -> 0x0051, blocks: (B:18:0x004c, B:27:0x0078, B:29:0x0080, B:39:0x00aa, B:40:0x00b1), top: B:47:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object single(ReceiveChannel $this$single, Continuation continuation) throws Throwable {
        C01011 c01011;
        ReceiveChannel $this$consume$iv;
        Object objHasNext;
        ReceiveChannel $this$consume$iv2;
        ReceiveChannel $this$consume$iv3;
        Throwable cause$iv;
        ChannelIterator iterator;
        Object objHasNext2;
        ReceiveChannel receiveChannel;
        Object obj;
        if (continuation instanceof C01011) {
            c01011 = (C01011) continuation;
            if ((c01011.label & Integer.MIN_VALUE) != 0) {
                c01011.label -= Integer.MIN_VALUE;
            } else {
                c01011 = new C01011(continuation);
            }
        }
        C01011 c010112 = c01011;
        Object $result = c010112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c010112.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$consume$iv = $this$single;
                try {
                    ChannelIterator iterator2 = $this$consume$iv.iterator();
                    c010112.L$0 = $this$consume$iv;
                    c010112.L$1 = iterator2;
                    c010112.label = 1;
                    objHasNext = iterator2.hasNext(c010112);
                    if (objHasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$consume$iv2 = $this$consume$iv;
                    $this$consume$iv3 = null;
                    cause$iv = null;
                    iterator = iterator2;
                    if (((Boolean) objHasNext).booleanValue()) {
                        throw new NoSuchElementException("ReceiveChannel is empty.");
                    }
                    Object single = iterator.next();
                    c010112.L$0 = $this$consume$iv2;
                    c010112.L$1 = single;
                    c010112.label = 2;
                    objHasNext2 = iterator.hasNext(c010112);
                    if (objHasNext2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    receiveChannel = $this$consume$iv2;
                    obj = single;
                    if (!((Boolean) objHasNext2).booleanValue()) {
                        throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                    }
                    ChannelsKt.cancelConsumed(receiveChannel, cause$iv);
                    return obj;
                } catch (Throwable th) {
                    e$iv = th;
                    Throwable cause$iv2 = e$iv;
                    try {
                        throw e$iv;
                    } catch (Throwable e$iv) {
                        ChannelsKt.cancelConsumed($this$consume$iv, cause$iv2);
                        throw e$iv;
                    }
                }
            case 1:
                $this$consume$iv3 = null;
                iterator = (ChannelIterator) c010112.L$1;
                cause$iv = null;
                $this$consume$iv2 = (ReceiveChannel) c010112.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objHasNext = $result;
                    if (((Boolean) objHasNext).booleanValue()) {
                    }
                } catch (Throwable th2) {
                    e$iv = th2;
                    $this$consume$iv = $this$consume$iv2;
                    Throwable cause$iv22 = e$iv;
                    throw e$iv;
                }
                break;
            case 2:
                obj = c010112.L$1;
                receiveChannel = (ReceiveChannel) c010112.L$0;
                cause$iv = null;
                try {
                    ResultKt.throwOnFailure($result);
                    objHasNext2 = $result;
                    if (!((Boolean) objHasNext2).booleanValue()) {
                    }
                } catch (Throwable th3) {
                    e$iv = th3;
                    $this$consume$iv = receiveChannel;
                    Throwable cause$iv222 = e$iv;
                    throw e$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object singleOrNull(ReceiveChannel $this$singleOrNull, Continuation continuation) throws Throwable {
        C01021 c01021;
        ReceiveChannel $this$consume$iv;
        Throwable cause$iv;
        Throwable e$iv;
        ChannelIterator iterator;
        Object objHasNext;
        ReceiveChannel $this$consume$iv2;
        ReceiveChannel $this$consume$iv3;
        Object objHasNext2;
        Throwable th;
        ReceiveChannel receiveChannel;
        Object obj;
        if (continuation instanceof C01021) {
            c01021 = (C01021) continuation;
            if ((c01021.label & Integer.MIN_VALUE) != 0) {
                c01021.label -= Integer.MIN_VALUE;
            } else {
                c01021 = new C01021(continuation);
            }
        }
        C01021 c010212 = c01021;
        Object $result = c010212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c010212.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$consume$iv = $this$singleOrNull;
                cause$iv = null;
                try {
                    iterator = $this$consume$iv.iterator();
                    c010212.L$0 = $this$consume$iv;
                    c010212.L$1 = iterator;
                    c010212.label = 1;
                    objHasNext = iterator.hasNext(c010212);
                    if (objHasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this$consume$iv2 = null;
                    $this$consume$iv3 = $this$consume$iv;
                    try {
                        if (((Boolean) objHasNext).booleanValue()) {
                            ChannelsKt.cancelConsumed($this$consume$iv3, cause$iv);
                            return null;
                        }
                        try {
                            Object single = iterator.next();
                            c010212.L$0 = $this$consume$iv3;
                            c010212.L$1 = single;
                            c010212.label = 2;
                            objHasNext2 = iterator.hasNext(c010212);
                            if (objHasNext2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            th = cause$iv;
                            receiveChannel = $this$consume$iv3;
                            obj = single;
                            try {
                                if (((Boolean) objHasNext2).booleanValue()) {
                                    ChannelsKt.cancelConsumed(receiveChannel, th);
                                    return obj;
                                }
                                ChannelsKt.cancelConsumed(receiveChannel, th);
                                return null;
                            } catch (Throwable th2) {
                                e$iv = th2;
                                $this$consume$iv = receiveChannel;
                                Throwable cause$iv2 = e$iv;
                                try {
                                    throw e$iv;
                                } catch (Throwable e$iv2) {
                                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv2);
                                    throw e$iv2;
                                }
                            }
                        } catch (Throwable th3) {
                            e$iv = th3;
                            $this$consume$iv = $this$consume$iv3;
                            Throwable cause$iv22 = e$iv;
                            throw e$iv;
                        }
                    } catch (Throwable th4) {
                        e$iv = th4;
                        $this$consume$iv = $this$consume$iv3;
                    }
                } catch (Throwable th5) {
                    e$iv = th5;
                    Throwable cause$iv222 = e$iv;
                    throw e$iv;
                }
                break;
            case 1:
                ChannelIterator iterator2 = (ChannelIterator) c010212.L$1;
                ReceiveChannel receiveChannel2 = (ReceiveChannel) c010212.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objHasNext = $result;
                    $this$consume$iv3 = receiveChannel2;
                    iterator = iterator2;
                    cause$iv = null;
                    $this$consume$iv2 = null;
                    if (((Boolean) objHasNext).booleanValue()) {
                    }
                } catch (Throwable th6) {
                    $this$consume$iv = receiveChannel2;
                    e$iv = th6;
                    Throwable cause$iv2222 = e$iv;
                    throw e$iv;
                }
                break;
            case 2:
                obj = c010212.L$1;
                receiveChannel = (ReceiveChannel) c010212.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objHasNext2 = $result;
                    th = null;
                    if (((Boolean) objHasNext2).booleanValue()) {
                    }
                } catch (Throwable th7) {
                    e$iv = th7;
                    $this$consume$iv = receiveChannel;
                    Throwable cause$iv22222 = e$iv;
                    throw e$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {164, 169, 170}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
    static final class C00791<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $n;
        final /* synthetic */ ReceiveChannel<E> $this_drop;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00791(int i, ReceiveChannel<? extends E> receiveChannel, Continuation<? super C00791> continuation) {
            super(2, continuation);
            this.$n = i;
            this.$this_drop = receiveChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00791 c00791 = new C00791(this.$n, this.$this_drop, continuation);
            c00791.L$0 = obj;
            return c00791;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C00791) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x007a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00b5 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00e0  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x007b -> B:22:0x0083). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00da -> B:30:0x00a5). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) throws Throwable {
            C00791<E> c00791;
            ProducerScope $this$produce;
            ChannelIterator<E> it;
            Object $result2;
            ProducerScope $this$produce2;
            ChannelIterator<E> channelIterator;
            int remaining;
            C00791<E> c007912;
            Object obj;
            ProducerScope $this$produce3;
            ChannelIterator<E> channelIterator2;
            C00791<E> c007913;
            Object obj2;
            Object $result3;
            Object objHasNext;
            Object $result4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c00791 = this;
                    $this$produce = (ProducerScope) c00791.L$0;
                    boolean z = c00791.$n >= 0;
                    int i = c00791.$n;
                    if (!z) {
                        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
                    }
                    int remaining2 = c00791.$n;
                    if (remaining2 > 0) {
                        ProducerScope $this$produce4 = $this$produce;
                        int remaining3 = remaining2;
                        ChannelIterator<E> it2 = c00791.$this_drop.iterator();
                        c00791.L$0 = $this$produce4;
                        c00791.L$1 = it2;
                        c00791.I$0 = remaining3;
                        c00791.label = 1;
                        Object objHasNext2 = it2.hasNext(c00791);
                        if (objHasNext2 != $result4) {
                            return $result4;
                        }
                        Object obj3 = $result4;
                        $result2 = $result;
                        $result = objHasNext2;
                        $this$produce2 = $this$produce4;
                        channelIterator = it2;
                        remaining = remaining3;
                        c007912 = c00791;
                        obj = obj3;
                        if (((Boolean) $result).booleanValue()) {
                            channelIterator.next();
                            int remaining4 = remaining - 1;
                            if (remaining4 != 0) {
                                it2 = channelIterator;
                                $this$produce4 = $this$produce2;
                                C00791<E> c007914 = c007912;
                                remaining3 = remaining4;
                                $result = $result2;
                                $result4 = obj;
                                c00791 = c007914;
                                c00791.L$0 = $this$produce4;
                                c00791.L$1 = it2;
                                c00791.I$0 = remaining3;
                                c00791.label = 1;
                                Object objHasNext22 = it2.hasNext(c00791);
                                if (objHasNext22 != $result4) {
                                }
                            }
                        }
                        $result = $result2;
                        $result4 = obj;
                        c00791 = c007912;
                        $this$produce = $this$produce2;
                    }
                    it = c00791.$this_drop.iterator();
                    c00791.L$0 = $this$produce;
                    c00791.L$1 = it;
                    c00791.label = 2;
                    objHasNext = it.hasNext(c00791);
                    if (objHasNext != $result4) {
                        return $result4;
                    }
                    Object obj4 = $result4;
                    $result3 = $result;
                    $result = objHasNext;
                    $this$produce3 = $this$produce;
                    channelIterator2 = it;
                    c007913 = c00791;
                    obj2 = obj4;
                    if (((Boolean) $result).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    c007913.L$0 = $this$produce3;
                    c007913.L$1 = channelIterator2;
                    c007913.label = 3;
                    Object e = $this$produce3.send(channelIterator2.next(), c007913);
                    if (e == obj2) {
                        return obj2;
                    }
                    $result = $result3;
                    $result4 = obj2;
                    c00791 = c007913;
                    it = channelIterator2;
                    $this$produce = $this$produce3;
                    c00791.L$0 = $this$produce;
                    c00791.L$1 = it;
                    c00791.label = 2;
                    objHasNext = it.hasNext(c00791);
                    if (objHasNext != $result4) {
                    }
                    break;
                case 1:
                    int remaining5 = this.I$0;
                    ChannelIterator<E> channelIterator3 = (ChannelIterator) this.L$1;
                    ProducerScope $this$produce5 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$produce2 = $this$produce5;
                    channelIterator = channelIterator3;
                    remaining = remaining5;
                    c007912 = this;
                    obj = $result4;
                    $result2 = $result;
                    if (((Boolean) $result).booleanValue()) {
                    }
                    $result = $result2;
                    $result4 = obj;
                    c00791 = c007912;
                    $this$produce = $this$produce2;
                    it = c00791.$this_drop.iterator();
                    c00791.L$0 = $this$produce;
                    c00791.L$1 = it;
                    c00791.label = 2;
                    objHasNext = it.hasNext(c00791);
                    if (objHasNext != $result4) {
                    }
                    break;
                case 2:
                    ChannelIterator<E> channelIterator4 = (ChannelIterator) this.L$1;
                    ProducerScope $this$produce6 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$produce3 = $this$produce6;
                    channelIterator2 = channelIterator4;
                    c007913 = this;
                    obj2 = $result4;
                    $result3 = $result;
                    if (((Boolean) $result).booleanValue()) {
                    }
                    break;
                case 3:
                    c00791 = this;
                    it = (ChannelIterator) c00791.L$1;
                    $this$produce = (ProducerScope) c00791.L$0;
                    ResultKt.throwOnFailure($result);
                    c00791.L$0 = $this$produce;
                    c00791.L$1 = it;
                    c00791.label = 2;
                    objHasNext = it.hasNext(c00791);
                    if (objHasNext != $result4) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return drop(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel drop(ReceiveChannel $this$drop, int n, CoroutineContext context) {
        return ProduceKt.produce(GlobalScope.INSTANCE, (6 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? CoroutineStart.DEFAULT : null, (6 & 8) != 0 ? null : ChannelsKt.consumes($this$drop), new C00791(n, $this$drop, null));
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return dropWhile(receiveChannel, coroutineContext, function2);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {181, 182, 183, 187, 188}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
    static final class C00801<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_dropWhile;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00801(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C00801> continuation) {
            super(2, continuation);
            this.$this_dropWhile = receiveChannel;
            this.$predicate = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00801 c00801 = new C00801(this.$this_dropWhile, this.$predicate, continuation);
            c00801.L$0 = obj;
            return c00801;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C00801) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0088 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00f1 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00f2  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00fd  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0114  */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r3v22 */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v9 */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v10 */
        /* JADX WARN: Type inference failed for: r5v11 */
        /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r5v13, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v14 */
        /* JADX WARN: Type inference failed for: r5v15 */
        /* JADX WARN: Type inference failed for: r5v16 */
        /* JADX WARN: Type inference failed for: r5v17 */
        /* JADX WARN: Type inference failed for: r5v18 */
        /* JADX WARN: Type inference failed for: r5v19 */
        /* JADX WARN: Type inference failed for: r5v20 */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r5v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00ad -> B:22:0x00b1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0112 -> B:31:0x00e1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            ChannelIterator<E> it;
            ?? r5;
            C00801<E> c00801;
            Object obj2;
            Object obj3;
            Object obj4;
            ChannelIterator<E> channelIterator;
            ?? r52;
            C00801<E> c008012;
            ?? r2;
            ?? r53;
            ChannelIterator<E> it2;
            ChannelIterator<E> channelIterator2;
            ?? r54;
            ?? r55;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    C00801<E> c008013 = this;
                    ProducerScope producerScope = (ProducerScope) c008013.L$0;
                    it = c008013.$this_dropWhile.iterator();
                    ?? r3 = producerScope;
                    c008013.L$0 = r3;
                    c008013.L$1 = it;
                    c008013.L$2 = null;
                    c008013.label = 1;
                    Object objHasNext2 = it.hasNext(c008013);
                    if (objHasNext2 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj5 = coroutine_suspended;
                    obj3 = obj;
                    obj = objHasNext2;
                    r5 = r3;
                    c00801 = c008013;
                    obj2 = obj5;
                    r53 = r5;
                    if (((Boolean) obj).booleanValue()) {
                        E next = it.next();
                        Function2<E, Continuation<? super Boolean>, Object> function2 = c00801.$predicate;
                        c00801.L$0 = r5;
                        c00801.L$1 = it;
                        c00801.L$2 = next;
                        c00801.label = 2;
                        Object objInvoke = function2.invoke(next, c00801);
                        if (objInvoke == obj2) {
                            return obj2;
                        }
                        ChannelIterator<E> channelIterator3 = it;
                        obj4 = next;
                        obj = objInvoke;
                        channelIterator = channelIterator3;
                        r52 = r5;
                        if (((Boolean) obj).booleanValue()) {
                            c00801.L$0 = r52;
                            c00801.L$1 = null;
                            c00801.L$2 = null;
                            c00801.label = 3;
                            if (r52.send(obj4, c00801) == obj2) {
                                return obj2;
                            }
                            obj = obj3;
                            coroutine_suspended = obj2;
                            c008012 = c00801;
                            r2 = r52;
                            c00801 = c008012;
                            r53 = r2;
                            obj2 = coroutine_suspended;
                        } else {
                            obj = obj3;
                            coroutine_suspended = obj2;
                            c008013 = c00801;
                            r3 = r52;
                            it = channelIterator;
                            c008013.L$0 = r3;
                            c008013.L$1 = it;
                            c008013.L$2 = null;
                            c008013.label = 1;
                            Object objHasNext22 = it.hasNext(c008013);
                            if (objHasNext22 != coroutine_suspended) {
                            }
                        }
                    }
                    it2 = c00801.$this_dropWhile.iterator();
                    r55 = r53;
                    c00801.L$0 = r55;
                    c00801.L$1 = it2;
                    c00801.label = 4;
                    objHasNext = it2.hasNext(c00801);
                    if (objHasNext == obj2) {
                        return obj2;
                    }
                    channelIterator2 = it2;
                    obj = objHasNext;
                    r54 = r55;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    c00801.L$0 = r54;
                    c00801.L$1 = channelIterator2;
                    c00801.label = 5;
                    if (r54.send(channelIterator2.next(), c00801) == obj2) {
                        return obj2;
                    }
                    it2 = channelIterator2;
                    r55 = r54;
                    c00801.L$0 = r55;
                    c00801.L$1 = it2;
                    c00801.label = 4;
                    objHasNext = it2.hasNext(c00801);
                    if (objHasNext == obj2) {
                    }
                    break;
                case 1:
                    ChannelIterator<E> channelIterator4 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r5 = producerScope2;
                    it = channelIterator4;
                    c00801 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    r53 = r5;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    it2 = c00801.$this_dropWhile.iterator();
                    r55 = r53;
                    c00801.L$0 = r55;
                    c00801.L$1 = it2;
                    c00801.label = 4;
                    objHasNext = it2.hasNext(c00801);
                    if (objHasNext == obj2) {
                    }
                    break;
                case 2:
                    Object obj6 = this.L$2;
                    ChannelIterator<E> channelIterator5 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    channelIterator = channelIterator5;
                    obj4 = obj6;
                    c00801 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    r52 = producerScope3;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    break;
                case 3:
                    c008012 = this;
                    ProducerScope producerScope4 = (ProducerScope) c008012.L$0;
                    ResultKt.throwOnFailure(obj);
                    r2 = producerScope4;
                    c00801 = c008012;
                    r53 = r2;
                    obj2 = coroutine_suspended;
                    it2 = c00801.$this_dropWhile.iterator();
                    r55 = r53;
                    c00801.L$0 = r55;
                    c00801.L$1 = it2;
                    c00801.label = 4;
                    objHasNext = it2.hasNext(c00801);
                    if (objHasNext == obj2) {
                    }
                    break;
                case 4:
                    channelIterator2 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope5 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r54 = producerScope5;
                    c00801 = this;
                    obj2 = coroutine_suspended;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    break;
                case 5:
                    ChannelIterator<E> channelIterator6 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope6 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r55 = producerScope6;
                    c00801 = this;
                    obj2 = coroutine_suspended;
                    it2 = channelIterator6;
                    c00801.L$0 = r55;
                    c00801.L$1 = it2;
                    c00801.label = 4;
                    objHasNext = it2.hasNext(c00801);
                    if (objHasNext == obj2) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel dropWhile(ReceiveChannel $this$dropWhile, CoroutineContext context, Function2 predicate) {
        return ProduceKt.produce(GlobalScope.INSTANCE, (6 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? CoroutineStart.DEFAULT : null, (6 & 8) != 0 ? null : ChannelsKt.consumes($this$dropWhile), new C00801($this$dropWhile, predicate, null));
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filter(receiveChannel, coroutineContext, function2);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {198, 199, 199}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
    static final class C00831<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_filter;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00831(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C00831> continuation) {
            super(2, continuation);
            this.$this_filter = receiveChannel;
            this.$predicate = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00831 c00831 = new C00831(this.$this_filter, this.$predicate, continuation);
            c00831.L$0 = obj;
            return c00831;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C00831) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x006b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00bd  */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v18 */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v10 */
        /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b1 -> B:10:0x0059). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00b7 -> B:10:0x0059). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            C00831<E> c00831;
            ?? r4;
            ChannelIterator<E> it;
            ?? r5;
            ChannelIterator<E> channelIterator;
            C00831<E> c008312;
            Object obj2;
            Object obj3;
            ?? r6;
            ChannelIterator<E> channelIterator2;
            Object obj4;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c00831 = this;
                    ProducerScope producerScope = (ProducerScope) c00831.L$0;
                    r4 = producerScope;
                    it = c00831.$this_filter.iterator();
                    c00831.L$0 = r4;
                    c00831.L$1 = it;
                    c00831.L$2 = null;
                    c00831.label = 1;
                    objHasNext = it.hasNext(c00831);
                    if (objHasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj5 = coroutine_suspended;
                    obj3 = obj;
                    obj = objHasNext;
                    r5 = r4;
                    channelIterator = it;
                    c008312 = c00831;
                    obj2 = obj5;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    E next = channelIterator.next();
                    Function2<E, Continuation<? super Boolean>, Object> function2 = c008312.$predicate;
                    c008312.L$0 = r5;
                    c008312.L$1 = channelIterator;
                    c008312.L$2 = next;
                    c008312.label = 2;
                    Object objInvoke = function2.invoke(next, c008312);
                    if (objInvoke == obj2) {
                        return obj2;
                    }
                    ChannelIterator<E> channelIterator3 = channelIterator;
                    obj4 = next;
                    obj = objInvoke;
                    r6 = r5;
                    channelIterator2 = channelIterator3;
                    if (((Boolean) obj).booleanValue()) {
                        obj = obj3;
                        coroutine_suspended = obj2;
                        c00831 = c008312;
                        it = channelIterator2;
                        r4 = r6;
                    } else {
                        c008312.L$0 = r6;
                        c008312.L$1 = channelIterator2;
                        c008312.L$2 = null;
                        c008312.label = 3;
                        if (r6.send(obj4, c008312) == obj2) {
                            return obj2;
                        }
                        obj = obj3;
                        coroutine_suspended = obj2;
                        c00831 = c008312;
                        it = channelIterator2;
                        r4 = r6;
                    }
                    c00831.L$0 = r4;
                    c00831.L$1 = it;
                    c00831.L$2 = null;
                    c00831.label = 1;
                    objHasNext = it.hasNext(c00831);
                    if (objHasNext != coroutine_suspended) {
                    }
                    break;
                case 1:
                    ChannelIterator<E> channelIterator4 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r5 = producerScope2;
                    channelIterator = channelIterator4;
                    c008312 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    break;
                case 2:
                    Object obj6 = this.L$2;
                    ChannelIterator<E> channelIterator5 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r6 = producerScope3;
                    channelIterator2 = channelIterator5;
                    obj4 = obj6;
                    c008312 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    c00831.L$0 = r4;
                    c00831.L$1 = it;
                    c00831.L$2 = null;
                    c00831.label = 1;
                    objHasNext = it.hasNext(c00831);
                    if (objHasNext != coroutine_suspended) {
                    }
                    break;
                case 3:
                    c00831 = this;
                    it = (ChannelIterator) c00831.L$1;
                    ProducerScope producerScope4 = (ProducerScope) c00831.L$0;
                    ResultKt.throwOnFailure(obj);
                    r4 = producerScope4;
                    c00831.L$0 = r4;
                    c00831.L$1 = it;
                    c00831.L$2 = null;
                    c00831.label = 1;
                    objHasNext = it.hasNext(c00831);
                    if (objHasNext != coroutine_suspended) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext context, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ProduceKt.produce(GlobalScope.INSTANCE, (6 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? CoroutineStart.DEFAULT : null, (6 & 8) != 0 ? null : ChannelsKt.consumes(receiveChannel), new C00831(receiveChannel, function2, null));
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return filterIndexed(receiveChannel, coroutineContext, function3);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {211, 212, 212}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
    static final class C00841<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<Integer, E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_filterIndexed;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00841(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> function3, Continuation<? super C00841> continuation) {
            super(2, continuation);
            this.$this_filterIndexed = receiveChannel;
            this.$predicate = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00841 c00841 = new C00841(this.$this_filterIndexed, this.$predicate, continuation);
            c00841.L$0 = obj;
            return c00841;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C00841) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0074 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00ae  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00d1  */
        /* JADX WARN: Type inference failed for: r5v10 */
        /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v16 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v9 */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r6v9 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00c3 -> B:10:0x0060). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ca -> B:10:0x0060). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            C00841<E> c00841;
            ?? r5;
            int i;
            ChannelIterator<E> it;
            ?? r6;
            ChannelIterator<E> channelIterator;
            int i2;
            C00841<E> c008412;
            Object obj2;
            Object obj3;
            Object obj4;
            int i3;
            ?? r62;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c00841 = this;
                    r5 = (ProducerScope) c00841.L$0;
                    i = 0;
                    it = c00841.$this_filterIndexed.iterator();
                    c00841.L$0 = r5;
                    c00841.L$1 = it;
                    c00841.L$2 = null;
                    c00841.I$0 = i;
                    c00841.label = 1;
                    objHasNext = it.hasNext(c00841);
                    if (objHasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj5 = coroutine_suspended;
                    obj3 = obj;
                    obj = objHasNext;
                    r6 = r5;
                    channelIterator = it;
                    i2 = i;
                    c008412 = c00841;
                    obj2 = obj5;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    E next = channelIterator.next();
                    Function3<Integer, E, Continuation<? super Boolean>, Object> function3 = c008412.$predicate;
                    i3 = i2 + 1;
                    Integer numBoxInt = Boxing.boxInt(i2);
                    c008412.L$0 = r6;
                    c008412.L$1 = channelIterator;
                    c008412.L$2 = next;
                    c008412.I$0 = i3;
                    c008412.label = 2;
                    Object objInvoke = function3.invoke(numBoxInt, next, c008412);
                    if (objInvoke == obj2) {
                        return obj2;
                    }
                    obj4 = next;
                    obj = objInvoke;
                    r62 = r6;
                    if (((Boolean) obj).booleanValue()) {
                        obj = obj3;
                        coroutine_suspended = obj2;
                        c00841 = c008412;
                        it = channelIterator;
                        r5 = r62;
                        i = i3;
                    } else {
                        c008412.L$0 = r62;
                        c008412.L$1 = channelIterator;
                        c008412.L$2 = null;
                        c008412.I$0 = i3;
                        c008412.label = 3;
                        if (r62.send(obj4, c008412) == obj2) {
                            return obj2;
                        }
                        obj = obj3;
                        coroutine_suspended = obj2;
                        c00841 = c008412;
                        it = channelIterator;
                        r5 = r62;
                        i = i3;
                    }
                    c00841.L$0 = r5;
                    c00841.L$1 = it;
                    c00841.L$2 = null;
                    c00841.I$0 = i;
                    c00841.label = 1;
                    objHasNext = it.hasNext(c00841);
                    if (objHasNext != coroutine_suspended) {
                    }
                    break;
                case 1:
                    int i4 = this.I$0;
                    ChannelIterator<E> channelIterator2 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r6 = producerScope;
                    channelIterator = channelIterator2;
                    i2 = i4;
                    c008412 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    break;
                case 2:
                    int i5 = this.I$0;
                    obj4 = this.L$2;
                    channelIterator = (ChannelIterator) this.L$1;
                    ProducerScope producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    i3 = i5;
                    c008412 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    r62 = producerScope2;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    c00841.L$0 = r5;
                    c00841.L$1 = it;
                    c00841.L$2 = null;
                    c00841.I$0 = i;
                    c00841.label = 1;
                    objHasNext = it.hasNext(c00841);
                    if (objHasNext != coroutine_suspended) {
                    }
                    break;
                case 3:
                    c00841 = this;
                    i = c00841.I$0;
                    it = (ChannelIterator) c00841.L$1;
                    ProducerScope producerScope3 = (ProducerScope) c00841.L$0;
                    ResultKt.throwOnFailure(obj);
                    r5 = producerScope3;
                    c00841.L$0 = r5;
                    c00841.L$1 = it;
                    c00841.L$2 = null;
                    c00841.I$0 = i;
                    c00841.label = 1;
                    objHasNext = it.hasNext(c00841);
                    if (objHasNext != coroutine_suspended) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterIndexed(ReceiveChannel $this$filterIndexed, CoroutineContext context, Function3 predicate) {
        return ProduceKt.produce(GlobalScope.INSTANCE, (6 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? CoroutineStart.DEFAULT : null, (6 & 8) != 0 ? null : ChannelsKt.consumes($this$filterIndexed), new C00841($this$filterIndexed, predicate, null));
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return filterNot(receiveChannel, coroutineContext, function2);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", "E", "it"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1", f = "Deprecated.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    static final class C00851<E> extends SuspendLambda implements Function2<E, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00851(Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C00851> continuation) {
            super(2, continuation);
            this.$predicate = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00851 c00851 = new C00851(this.$predicate, continuation);
            c00851.L$0 = obj;
            return c00851;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(E e, Continuation<? super Boolean> continuation) {
            return ((C00851) create(e, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNot$1<E> for r5v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 1
                switch(r1) {
                    case 0: goto L19;
                    case 1: goto L12;
                    default: goto La;
                }
            La:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L12:
                r0 = r5
                kotlin.ResultKt.throwOnFailure(r6)
                r1 = r0
                r0 = r6
                goto L2c
            L19:
                kotlin.ResultKt.throwOnFailure(r6)
                r1 = r5
                java.lang.Object r3 = r1.L$0
                kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r4 = r1.$predicate
                r1.label = r2
                java.lang.Object r3 = r4.invoke(r3, r1)
                if (r3 != r0) goto L2a
                return r0
            L2a:
                r0 = r6
                r6 = r3
            L2c:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                r6 = r6 ^ r2
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.C00851.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel filterNot(ReceiveChannel $this$filterNot, CoroutineContext context, Function2 predicate) {
        return ChannelsKt.filter($this$filterNot, context, new C00851(predicate, null));
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H\u008a@"}, d2 = {"<anonymous>", "", "E", "", "it"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterNotNull$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00861<E> extends SuspendLambda implements Function2<E, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C00861(Continuation<? super C00861> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00861 c00861 = new C00861(continuation);
            c00861.L$0 = obj;
            return c00861;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(E e, Continuation<? super Boolean> continuation) {
            return ((C00861) create(e, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Object it = this.L$0;
                    return Boxing.boxBoolean(it != null);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        return filter$default(receiveChannel, null, new C00861(null), 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082 A[Catch: all -> 0x009d, TryCatch #3 {all -> 0x009d, blocks: (B:24:0x007a, B:26:0x0082, B:28:0x0089, B:30:0x0094), top: B:48:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094 A[Catch: all -> 0x009d, TRY_LEAVE, TryCatch #3 {all -> 0x009d, blocks: (B:24:0x007a, B:26:0x0082, B:28:0x0089, B:30:0x0094), top: B:48:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0071 -> B:48:0x007a). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel $this$consumeEach$iv, Collection destination, Continuation continuation) throws Throwable {
        C00871 c00871;
        ReceiveChannel $this$consume$iv$iv;
        Throwable cause$iv$iv;
        Object $result;
        Collection destination2;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv2;
        ChannelIterator channelIterator;
        int i;
        Object obj;
        if (continuation instanceof C00871) {
            c00871 = (C00871) continuation;
            if ((c00871.label & Integer.MIN_VALUE) != 0) {
                c00871.label -= Integer.MIN_VALUE;
            } else {
                c00871 = new C00871(continuation);
            }
        }
        C00871 c008712 = c00871;
        Object it = c008712.result;
        Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c008712.label) {
            case 0:
                ResultKt.throwOnFailure(it);
                $this$consume$iv$iv = $this$consumeEach$iv;
                Throwable cause$iv$iv3 = null;
                try {
                    ChannelIterator it2 = $this$consume$iv$iv.iterator();
                    int $i$f$consumeEach = 0;
                    Collection destination3 = destination;
                    c008712.L$0 = destination3;
                    c008712.L$1 = $this$consume$iv$iv;
                    c008712.L$2 = it2;
                    c008712.label = 1;
                    Object objHasNext = it2.hasNext(c008712);
                    if (objHasNext != $result2) {
                        return $result2;
                    }
                    Object obj2 = $result2;
                    $result = it;
                    it = objHasNext;
                    destination2 = destination3;
                    $this$consume$iv$iv2 = $this$consume$iv$iv;
                    cause$iv$iv2 = cause$iv$iv3;
                    channelIterator = it2;
                    i = $i$f$consumeEach;
                    obj = obj2;
                    try {
                        if (!((Boolean) it).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            return destination2;
                        }
                        Object it3 = channelIterator.next();
                        if (it3 != null) {
                            destination2.add(it3);
                        }
                        it = $result;
                        $result2 = obj;
                        $i$f$consumeEach = i;
                        it2 = channelIterator;
                        cause$iv$iv3 = cause$iv$iv;
                        $this$consume$iv$iv = $this$consume$iv$iv;
                        destination3 = destination2;
                        c008712.L$0 = destination3;
                        c008712.L$1 = $this$consume$iv$iv;
                        c008712.L$2 = it2;
                        c008712.label = 1;
                        Object objHasNext2 = it2.hasNext(c008712);
                        if (objHasNext2 != $result2) {
                        }
                    } catch (Throwable th) {
                        $this$consume$iv$iv = $this$consume$iv$iv;
                        e$iv$iv = th;
                        cause$iv$iv = e$iv$iv;
                        try {
                            throw e$iv$iv;
                        } finally {
                            ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv);
                        }
                    }
                } catch (Throwable th2) {
                    e$iv$iv = th2;
                    cause$iv$iv = e$iv$iv;
                    throw e$iv$iv;
                }
                break;
            case 1:
                ChannelIterator channelIterator2 = (ChannelIterator) c008712.L$2;
                $this$consume$iv$iv = (ReceiveChannel) c008712.L$1;
                Collection destination4 = (Collection) c008712.L$0;
                try {
                    ResultKt.throwOnFailure(it);
                    destination2 = destination4;
                    $this$consume$iv$iv2 = $this$consume$iv$iv;
                    cause$iv$iv2 = null;
                    channelIterator = channelIterator2;
                    i = 0;
                    obj = $result2;
                    $result = it;
                    if (!((Boolean) it).booleanValue()) {
                    }
                } catch (Throwable th3) {
                    e$iv$iv = th3;
                    cause$iv$iv = e$iv$iv;
                    throw e$iv$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d A[Catch: all -> 0x00c6, TryCatch #1 {all -> 0x00c6, blocks: (B:27:0x0095, B:29:0x009d, B:31:0x00a4, B:37:0x00bd), top: B:53:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bd A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #1 {all -> 0x00c6, blocks: (B:27:0x0095, B:29:0x009d, B:31:0x00a4, B:37:0x00bd), top: B:53:0x0095 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b4 -> B:35:0x00b8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b9 -> B:58:0x0080). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object filterNotNullTo(ReceiveChannel $this$consumeEach$iv, SendChannel destination, Continuation continuation) throws Throwable {
        AnonymousClass3 anonymousClass3;
        ReceiveChannel $this$consume$iv$iv;
        Throwable cause$iv$iv;
        ChannelIterator it;
        Continuation $continuation;
        Object $result;
        Object $result2;
        AnonymousClass3 anonymousClass32;
        Object obj;
        AnonymousClass3 anonymousClass33;
        Object $result3;
        Object objHasNext;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            if ((anonymousClass3.label & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        }
        AnonymousClass3 anonymousClass34 = anonymousClass3;
        Object $result4 = anonymousClass34.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th) {
            e$iv$iv = th;
        }
        switch (anonymousClass34.label) {
            case 0:
                ResultKt.throwOnFailure($result4);
                $this$consume$iv$iv = $this$consumeEach$iv;
                cause$iv$iv = null;
                try {
                    it = $this$consume$iv$iv.iterator();
                    $continuation = null;
                    $result = coroutine_suspended;
                    $result2 = $result4;
                    anonymousClass32 = anonymousClass34;
                    try {
                        anonymousClass32.L$0 = destination;
                        anonymousClass32.L$1 = $this$consume$iv$iv;
                        anonymousClass32.L$2 = it;
                        anonymousClass32.label = 1;
                        objHasNext = it.hasNext(anonymousClass32);
                    } catch (Throwable th2) {
                        e$iv$iv = th2;
                    }
                } catch (Throwable th3) {
                    e$iv$iv = th3;
                }
                if (objHasNext != $result) {
                    return $result;
                }
                Object obj2 = $result2;
                anonymousClass33 = anonymousClass32;
                $result4 = objHasNext;
                obj = $result;
                $result3 = obj2;
                try {
                    if (!((Boolean) $result4).booleanValue()) {
                        Unit unit = Unit.INSTANCE;
                        return destination;
                    }
                    Object it2 = it.next();
                    if (it2 != null) {
                        anonymousClass33.L$0 = destination;
                        anonymousClass33.L$1 = $this$consume$iv$iv;
                        anonymousClass33.L$2 = it;
                        anonymousClass33.label = 2;
                        if (destination.send(it2, anonymousClass33) == obj) {
                            return obj;
                        }
                        anonymousClass32 = anonymousClass33;
                        $result2 = $result3;
                        $result = obj;
                        anonymousClass32.L$0 = destination;
                        anonymousClass32.L$1 = $this$consume$iv$iv;
                        anonymousClass32.L$2 = it;
                        anonymousClass32.label = 1;
                        objHasNext = it.hasNext(anonymousClass32);
                        if (objHasNext != $result) {
                        }
                    } else {
                        anonymousClass32 = anonymousClass33;
                        $result2 = $result3;
                        $result = obj;
                        anonymousClass32.L$0 = destination;
                        anonymousClass32.L$1 = $this$consume$iv$iv;
                        anonymousClass32.L$2 = it;
                        anonymousClass32.label = 1;
                        objHasNext = it.hasNext(anonymousClass32);
                        if (objHasNext != $result) {
                        }
                    }
                } catch (Throwable th4) {
                    e$iv$iv = th4;
                }
                Throwable cause$iv$iv2 = e$iv$iv;
                try {
                    throw e$iv$iv;
                } finally {
                    ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv2);
                }
                break;
            case 1:
                ChannelIterator channelIterator = (ChannelIterator) anonymousClass34.L$2;
                cause$iv$iv = null;
                ReceiveChannel $this$consume$iv$iv2 = (ReceiveChannel) anonymousClass34.L$1;
                $this$consume$iv$iv = $this$consume$iv$iv2;
                SendChannel destination2 = (SendChannel) anonymousClass34.L$0;
                ResultKt.throwOnFailure($result4);
                it = channelIterator;
                obj = coroutine_suspended;
                anonymousClass33 = anonymousClass34;
                $continuation = null;
                destination = destination2;
                $result3 = $result4;
                if (!((Boolean) $result4).booleanValue()) {
                }
                Throwable cause$iv$iv22 = e$iv$iv;
                throw e$iv$iv;
            case 2:
                ChannelIterator channelIterator2 = (ChannelIterator) anonymousClass34.L$2;
                cause$iv$iv = null;
                $this$consume$iv$iv = (ReceiveChannel) anonymousClass34.L$1;
                SendChannel destination3 = (SendChannel) anonymousClass34.L$0;
                ResultKt.throwOnFailure($result4);
                $continuation = null;
                destination = destination3;
                it = channelIterator2;
                $result = coroutine_suspended;
                $result2 = $result4;
                anonymousClass32 = anonymousClass34;
                anonymousClass32.L$0 = destination;
                anonymousClass32.L$1 = $this$consume$iv$iv;
                anonymousClass32.L$2 = it;
                anonymousClass32.label = 1;
                objHasNext = it.hasNext(anonymousClass32);
                if (objHasNext != $result) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {254, 255}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
    static final class C01031<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $n;
        final /* synthetic */ ReceiveChannel<E> $this_take;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01031(int i, ReceiveChannel<? extends E> receiveChannel, Continuation<? super C01031> continuation) {
            super(2, continuation);
            this.$n = i;
            this.$this_take = receiveChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01031 c01031 = new C01031(this.$n, this.$this_take, continuation);
            c01031.L$0 = obj;
            return c01031;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C01031) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0090 -> B:29:0x0096). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) throws Throwable {
            C01031<E> c01031;
            int remaining;
            ChannelIterator<E> it;
            ProducerScope $this$produce;
            C01031<E> c010312;
            Object obj;
            Object $result2;
            int remaining2;
            ChannelIterator<E> channelIterator;
            ProducerScope $this$produce2;
            int remaining3;
            Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c01031 = this;
                    ProducerScope $this$produce3 = (ProducerScope) c01031.L$0;
                    if (c01031.$n == 0) {
                        return Unit.INSTANCE;
                    }
                    boolean z = c01031.$n >= 0;
                    int i = c01031.$n;
                    if (!z) {
                        throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
                    }
                    remaining = c01031.$n;
                    it = c01031.$this_take.iterator();
                    c01031.L$0 = $this$produce3;
                    c01031.L$1 = it;
                    c01031.I$0 = remaining;
                    c01031.label = 1;
                    Object objHasNext = it.hasNext(c01031);
                    if (objHasNext != $result3) {
                        return $result3;
                    }
                    Object obj2 = $result3;
                    $result2 = $result;
                    $result = objHasNext;
                    $this$produce = $this$produce3;
                    c010312 = c01031;
                    obj = obj2;
                    if (((Boolean) $result).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    c010312.L$0 = $this$produce;
                    c010312.L$1 = it;
                    c010312.I$0 = remaining;
                    c010312.label = 2;
                    Object e = $this$produce.send(it.next(), c010312);
                    if (e == obj) {
                        return obj;
                    }
                    $result = $result2;
                    $result3 = obj;
                    c01031 = c010312;
                    remaining2 = remaining;
                    channelIterator = it;
                    $this$produce2 = $this$produce;
                    remaining3 = remaining2 - 1;
                    if (remaining3 != 0) {
                        return Unit.INSTANCE;
                    }
                    ChannelIterator<E> channelIterator2 = channelIterator;
                    remaining = remaining3;
                    $this$produce3 = $this$produce2;
                    it = channelIterator2;
                    c01031.L$0 = $this$produce3;
                    c01031.L$1 = it;
                    c01031.I$0 = remaining;
                    c01031.label = 1;
                    Object objHasNext2 = it.hasNext(c01031);
                    if (objHasNext2 != $result3) {
                    }
                    break;
                case 1:
                    int remaining4 = this.I$0;
                    ChannelIterator<E> channelIterator3 = (ChannelIterator) this.L$1;
                    ProducerScope $this$produce4 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$produce = $this$produce4;
                    it = channelIterator3;
                    remaining = remaining4;
                    c010312 = this;
                    obj = $result3;
                    $result2 = $result;
                    if (((Boolean) $result).booleanValue()) {
                    }
                    break;
                case 2:
                    c01031 = this;
                    remaining2 = c01031.I$0;
                    channelIterator = (ChannelIterator) c01031.L$1;
                    $this$produce2 = (ProducerScope) c01031.L$0;
                    ResultKt.throwOnFailure($result);
                    remaining3 = remaining2 - 1;
                    if (remaining3 != 0) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return take(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel take(ReceiveChannel $this$take, int n, CoroutineContext context) {
        return ProduceKt.produce(GlobalScope.INSTANCE, (6 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? CoroutineStart.DEFAULT : null, (6 & 8) != 0 ? null : ChannelsKt.consumes($this$take), new C01031(n, $this$take, null));
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return takeWhile(receiveChannel, coroutineContext, function2);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {269, 270, 271}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
    static final class C01041<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
        final /* synthetic */ ReceiveChannel<E> $this_takeWhile;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01041(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C01041> continuation) {
            super(2, continuation);
            this.$this_takeWhile = receiveChannel;
            this.$predicate = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01041 c01041 = new C01041(this.$this_takeWhile, this.$predicate, continuation);
            c01041.L$0 = obj;
            return c01041;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C01041) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0068 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
        /* JADX WARN: Type inference failed for: r3v10 */
        /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00b2 -> B:10:0x0058). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            C01041<E> c01041;
            ?? r3;
            ChannelIterator<E> it;
            ?? r4;
            ChannelIterator<E> channelIterator;
            C01041<E> c010412;
            Object obj2;
            Object obj3;
            ?? r5;
            ChannelIterator<E> channelIterator2;
            Object obj4;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c01041 = this;
                    ProducerScope producerScope = (ProducerScope) c01041.L$0;
                    r3 = producerScope;
                    it = c01041.$this_takeWhile.iterator();
                    c01041.L$0 = r3;
                    c01041.L$1 = it;
                    c01041.label = 1;
                    objHasNext = it.hasNext(c01041);
                    if (objHasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj5 = coroutine_suspended;
                    obj3 = obj;
                    obj = objHasNext;
                    r4 = r3;
                    channelIterator = it;
                    c010412 = c01041;
                    obj2 = obj5;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    E next = channelIterator.next();
                    Function2<E, Continuation<? super Boolean>, Object> function2 = c010412.$predicate;
                    c010412.L$0 = r4;
                    c010412.L$1 = channelIterator;
                    c010412.L$2 = next;
                    c010412.label = 2;
                    Object objInvoke = function2.invoke(next, c010412);
                    if (objInvoke == obj2) {
                        return obj2;
                    }
                    ChannelIterator<E> channelIterator3 = channelIterator;
                    obj4 = next;
                    obj = objInvoke;
                    r5 = r4;
                    channelIterator2 = channelIterator3;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    c010412.L$0 = r5;
                    c010412.L$1 = channelIterator2;
                    c010412.L$2 = null;
                    c010412.label = 3;
                    if (r5.send(obj4, c010412) == obj2) {
                        return obj2;
                    }
                    obj = obj3;
                    coroutine_suspended = obj2;
                    c01041 = c010412;
                    it = channelIterator2;
                    r3 = r5;
                    c01041.L$0 = r3;
                    c01041.L$1 = it;
                    c01041.label = 1;
                    objHasNext = it.hasNext(c01041);
                    if (objHasNext == coroutine_suspended) {
                    }
                    break;
                case 1:
                    ChannelIterator<E> channelIterator4 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r4 = producerScope2;
                    channelIterator = channelIterator4;
                    c010412 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    break;
                case 2:
                    Object obj6 = this.L$2;
                    ChannelIterator<E> channelIterator5 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r5 = producerScope3;
                    channelIterator2 = channelIterator5;
                    obj4 = obj6;
                    c010412 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    break;
                case 3:
                    c01041 = this;
                    it = (ChannelIterator) c01041.L$1;
                    ProducerScope producerScope4 = (ProducerScope) c01041.L$0;
                    ResultKt.throwOnFailure(obj);
                    r3 = producerScope4;
                    c01041.L$0 = r3;
                    c01041.L$1 = it;
                    c01041.label = 1;
                    objHasNext = it.hasNext(c01041);
                    if (objHasNext == coroutine_suspended) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel takeWhile(ReceiveChannel $this$takeWhile, CoroutineContext context, Function2 predicate) {
        return ProduceKt.produce(GlobalScope.INSTANCE, (6 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? CoroutineStart.DEFAULT : null, (6 & 8) != 0 ? null : ChannelsKt.consumes($this$takeWhile), new C01041($this$takeWhile, predicate, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009b A[Catch: all -> 0x00bf, TryCatch #4 {all -> 0x00bf, blocks: (B:27:0x0093, B:29:0x009b, B:34:0x00b6), top: B:55:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6 A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #4 {all -> 0x00bf, blocks: (B:27:0x0093, B:29:0x009b, B:34:0x00b6), top: B:55:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00b0 -> B:33:0x00b5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) throws Throwable {
        C01051 c01051;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ChannelIterator<? extends E> it;
        Continuation continuation2;
        Object obj;
        Object obj2;
        C01051 c010512;
        Continuation continuation3;
        ChannelIterator<? extends E> channelIterator;
        SendChannel sendChannel;
        SendChannel sendChannel2;
        SendChannel sendChannel3;
        Object objHasNext;
        if (continuation instanceof C01051) {
            c01051 = (C01051) continuation;
            if ((c01051.label & Integer.MIN_VALUE) != 0) {
                c01051.label -= Integer.MIN_VALUE;
            } else {
                c01051 = new C01051(continuation);
            }
        }
        C01051 c010513 = c01051;
        Object obj3 = c010513.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        switch (c010513.label) {
            case 0:
                ResultKt.throwOnFailure(obj3);
                receiveChannel2 = receiveChannel;
                th = null;
                try {
                    it = receiveChannel2.iterator();
                    continuation2 = null;
                    obj = coroutine_suspended;
                    obj2 = obj3;
                    c010512 = c010513;
                    sendChannel3 = c;
                    try {
                        c010512.L$0 = sendChannel3;
                        c010512.L$1 = receiveChannel2;
                        c010512.L$2 = it;
                        c010512.label = 1;
                        objHasNext = it.hasNext(c010512);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
                if (objHasNext == obj) {
                    return obj;
                }
                ChannelIterator<? extends E> channelIterator2 = it;
                sendChannel = sendChannel3;
                continuation3 = continuation2;
                c010513 = c010512;
                obj3 = objHasNext;
                channelIterator = channelIterator2;
                try {
                    if (((Boolean) obj3).booleanValue()) {
                        Unit unit = Unit.INSTANCE;
                        return sendChannel;
                    }
                    E next = channelIterator.next();
                    c010513.L$0 = sendChannel;
                    c010513.L$1 = receiveChannel2;
                    c010513.L$2 = channelIterator;
                    c010513.label = 2;
                    if (sendChannel.send(next, c010513) == obj) {
                        return obj;
                    }
                    c010512 = c010513;
                    continuation2 = continuation3;
                    sendChannel2 = sendChannel;
                    it = channelIterator;
                    sendChannel3 = sendChannel2;
                    c010512.L$0 = sendChannel3;
                    c010512.L$1 = receiveChannel2;
                    c010512.L$2 = it;
                    c010512.label = 1;
                    objHasNext = it.hasNext(c010512);
                    if (objHasNext == obj) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
                Throwable th6 = th;
                try {
                    throw th;
                } finally {
                    ChannelsKt.cancelConsumed(receiveChannel2, th6);
                }
                break;
            case 1:
                continuation3 = null;
                channelIterator = (ChannelIterator) c010513.L$2;
                th = null;
                receiveChannel2 = (ReceiveChannel) c010513.L$1;
                SendChannel sendChannel4 = (SendChannel) c010513.L$0;
                ResultKt.throwOnFailure(obj3);
                sendChannel = sendChannel4;
                obj = coroutine_suspended;
                obj2 = obj3;
                if (((Boolean) obj3).booleanValue()) {
                }
                Throwable th62 = th;
                throw th;
            case 2:
                ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) c010513.L$2;
                th = null;
                receiveChannel2 = (ReceiveChannel) c010513.L$1;
                SendChannel sendChannel5 = (SendChannel) c010513.L$0;
                ResultKt.throwOnFailure(obj3);
                continuation2 = null;
                SendChannel sendChannel6 = (C) sendChannel5;
                it = channelIterator3;
                obj = coroutine_suspended;
                obj2 = obj3;
                c010512 = c010513;
                sendChannel2 = sendChannel6;
                sendChannel3 = sendChannel2;
                c010512.L$0 = sendChannel3;
                c010512.L$1 = receiveChannel2;
                c010512.L$2 = it;
                c010512.label = 1;
                objHasNext = it.hasNext(c010512);
                if (objHasNext == obj) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082 A[Catch: all -> 0x009c, TryCatch #3 {all -> 0x009c, blocks: (B:24:0x007a, B:26:0x0082, B:27:0x0093), top: B:45:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093 A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #3 {all -> 0x009c, blocks: (B:24:0x007a, B:26:0x0082, B:27:0x0093), top: B:45:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0071 -> B:45:0x007a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) throws Throwable {
        C01061 c01061;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable cause$iv$iv;
        Object $result;
        ?? r7;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable cause$iv$iv2;
        ChannelIterator channelIterator;
        int i;
        Object obj;
        if (continuation instanceof C01061) {
            c01061 = (C01061) continuation;
            if ((c01061.label & Integer.MIN_VALUE) != 0) {
                c01061.label -= Integer.MIN_VALUE;
            } else {
                c01061 = new C01061(continuation);
            }
        }
        C01061 c010612 = c01061;
        Object e$iv = c010612.result;
        Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c010612.label) {
            case 0:
                ResultKt.throwOnFailure(e$iv);
                receiveChannel2 = receiveChannel;
                Throwable cause$iv$iv3 = null;
                try {
                    ChannelIterator it = receiveChannel2.iterator();
                    int $i$f$consumeEach = 0;
                    ?? r6 = c;
                    c010612.L$0 = r6;
                    c010612.L$1 = receiveChannel2;
                    c010612.L$2 = it;
                    c010612.label = 1;
                    Object objHasNext = it.hasNext(c010612);
                    if (objHasNext != $result2) {
                        return $result2;
                    }
                    Object obj2 = $result2;
                    $result = e$iv;
                    e$iv = objHasNext;
                    r7 = r6;
                    receiveChannel3 = receiveChannel2;
                    cause$iv$iv2 = cause$iv$iv3;
                    channelIterator = it;
                    i = $i$f$consumeEach;
                    obj = obj2;
                    try {
                        if (((Boolean) e$iv).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            return r7;
                        }
                        r7.add(channelIterator.next());
                        e$iv = $result;
                        $result2 = obj;
                        $i$f$consumeEach = i;
                        it = channelIterator;
                        cause$iv$iv3 = cause$iv$iv;
                        receiveChannel2 = receiveChannel2;
                        r6 = r7;
                        c010612.L$0 = r6;
                        c010612.L$1 = receiveChannel2;
                        c010612.L$2 = it;
                        c010612.label = 1;
                        Object objHasNext2 = it.hasNext(c010612);
                        if (objHasNext2 != $result2) {
                        }
                    } catch (Throwable th) {
                        receiveChannel2 = receiveChannel2;
                        e$iv$iv = th;
                        cause$iv$iv = e$iv$iv;
                        try {
                            throw e$iv$iv;
                        } finally {
                            ChannelsKt.cancelConsumed(receiveChannel2, cause$iv$iv);
                        }
                    }
                } catch (Throwable th2) {
                    e$iv$iv = th2;
                    cause$iv$iv = e$iv$iv;
                    throw e$iv$iv;
                }
                break;
            case 1:
                ChannelIterator channelIterator2 = (ChannelIterator) c010612.L$2;
                receiveChannel2 = (ReceiveChannel) c010612.L$1;
                Collection destination = (Collection) c010612.L$0;
                try {
                    ResultKt.throwOnFailure(e$iv);
                    r7 = destination;
                    receiveChannel3 = receiveChannel2;
                    cause$iv$iv2 = null;
                    channelIterator = channelIterator2;
                    i = 0;
                    obj = $result2;
                    $result = e$iv;
                    if (((Boolean) e$iv).booleanValue()) {
                    }
                } catch (Throwable th3) {
                    e$iv$iv = th3;
                    cause$iv$iv = e$iv$iv;
                    throw e$iv$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082 A[Catch: all -> 0x00a6, TryCatch #1 {all -> 0x00a6, blocks: (B:24:0x007a, B:26:0x0082, B:27:0x009d), top: B:41:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d A[Catch: all -> 0x00a6, TRY_LEAVE, TryCatch #1 {all -> 0x00a6, blocks: (B:24:0x007a, B:26:0x0082, B:27:0x009d), top: B:41:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0071 -> B:41:0x007a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) throws Throwable {
        AnonymousClass2 anonymousClass2;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel2;
        Throwable cause$iv$iv;
        Object $result;
        ?? r7;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel3;
        Throwable cause$iv$iv2;
        ChannelIterator channelIterator;
        int i;
        Object obj;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        }
        AnonymousClass2 anonymousClass22 = anonymousClass2;
        Object e$iv = anonymousClass22.result;
        Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass22.label) {
            case 0:
                ResultKt.throwOnFailure(e$iv);
                receiveChannel2 = receiveChannel;
                Throwable cause$iv$iv3 = null;
                try {
                    ChannelIterator it = receiveChannel2.iterator();
                    int $i$f$consumeEach = 0;
                    ?? r6 = m;
                    anonymousClass22.L$0 = r6;
                    anonymousClass22.L$1 = receiveChannel2;
                    anonymousClass22.L$2 = it;
                    anonymousClass22.label = 1;
                    Object objHasNext = it.hasNext(anonymousClass22);
                    if (objHasNext != $result2) {
                        return $result2;
                    }
                    Object obj2 = $result2;
                    $result = e$iv;
                    e$iv = objHasNext;
                    r7 = r6;
                    receiveChannel3 = receiveChannel2;
                    cause$iv$iv2 = cause$iv$iv3;
                    channelIterator = it;
                    i = $i$f$consumeEach;
                    obj = obj2;
                    try {
                        if (((Boolean) e$iv).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            return r7;
                        }
                        Pair it2 = (Pair) channelIterator.next();
                        r7.put(it2.getFirst(), it2.getSecond());
                        e$iv = $result;
                        $result2 = obj;
                        $i$f$consumeEach = i;
                        it = channelIterator;
                        cause$iv$iv3 = cause$iv$iv;
                        receiveChannel2 = receiveChannel2;
                        r6 = r7;
                        anonymousClass22.L$0 = r6;
                        anonymousClass22.L$1 = receiveChannel2;
                        anonymousClass22.L$2 = it;
                        anonymousClass22.label = 1;
                        Object objHasNext2 = it.hasNext(anonymousClass22);
                        if (objHasNext2 != $result2) {
                        }
                    } catch (Throwable th) {
                        receiveChannel2 = receiveChannel2;
                        e$iv$iv = th;
                        cause$iv$iv = e$iv$iv;
                        try {
                            throw e$iv$iv;
                        } finally {
                            ChannelsKt.cancelConsumed(receiveChannel2, cause$iv$iv);
                        }
                    }
                } catch (Throwable th2) {
                    e$iv$iv = th2;
                    cause$iv$iv = e$iv$iv;
                    throw e$iv$iv;
                }
                break;
            case 1:
                ChannelIterator channelIterator2 = (ChannelIterator) anonymousClass22.L$2;
                receiveChannel2 = (ReceiveChannel) anonymousClass22.L$1;
                Map destination = (Map) anonymousClass22.L$0;
                try {
                    ResultKt.throwOnFailure(e$iv);
                    r7 = destination;
                    receiveChannel3 = receiveChannel2;
                    cause$iv$iv2 = null;
                    channelIterator = channelIterator2;
                    i = 0;
                    obj = $result2;
                    $result = e$iv;
                    if (((Boolean) e$iv).booleanValue()) {
                    }
                } catch (Throwable th3) {
                    e$iv$iv = th3;
                    cause$iv$iv = e$iv$iv;
                    throw e$iv$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return flatMap(receiveChannel, coroutineContext, function2);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {321, 322, 322}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
    static final class C00901<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_flatMap;
        final /* synthetic */ Function2<E, Continuation<? super ReceiveChannel<? extends R>>, Object> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00901(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> function2, Continuation<? super C00901> continuation) {
            super(2, continuation);
            this.$this_flatMap = receiveChannel;
            this.$transform = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00901 c00901 = new C00901(this.$this_flatMap, this.$transform, continuation);
            c00901.L$0 = obj;
            return c00901;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
            return ((C00901) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0065 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x009e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00a5  */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009f -> B:10:0x0055). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            C00901<R> c00901;
            ProducerScope producerScope;
            ChannelIterator it;
            ProducerScope producerScope2;
            ChannelIterator channelIterator;
            C00901<R> c009012;
            Object obj2;
            Object obj3;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c00901 = this;
                    ProducerScope producerScope3 = (ProducerScope) c00901.L$0;
                    producerScope = producerScope3;
                    it = c00901.$this_flatMap.iterator();
                    c00901.L$0 = producerScope;
                    c00901.L$1 = it;
                    c00901.label = 1;
                    objHasNext = it.hasNext(c00901);
                    if (objHasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj4 = coroutine_suspended;
                    obj3 = obj;
                    obj = objHasNext;
                    producerScope2 = producerScope;
                    channelIterator = it;
                    c009012 = c00901;
                    obj2 = obj4;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    Object next = channelIterator.next();
                    Function2<E, Continuation<? super ReceiveChannel<? extends R>>, Object> function2 = c009012.$transform;
                    c009012.L$0 = producerScope2;
                    c009012.L$1 = channelIterator;
                    c009012.label = 2;
                    obj = function2.invoke((E) next, c009012);
                    if (obj == obj2) {
                        return obj2;
                    }
                    c009012.L$0 = producerScope2;
                    c009012.L$1 = channelIterator;
                    c009012.label = 3;
                    if (ChannelsKt.toChannel((ReceiveChannel) obj, producerScope2, c009012) != obj2) {
                        return obj2;
                    }
                    obj = obj3;
                    coroutine_suspended = obj2;
                    c00901 = c009012;
                    it = channelIterator;
                    producerScope = producerScope2;
                    c00901.L$0 = producerScope;
                    c00901.L$1 = it;
                    c00901.label = 1;
                    objHasNext = it.hasNext(c00901);
                    if (objHasNext == coroutine_suspended) {
                    }
                    break;
                case 1:
                    ChannelIterator channelIterator2 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope4 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    producerScope2 = producerScope4;
                    channelIterator = channelIterator2;
                    c009012 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    break;
                case 2:
                    ChannelIterator channelIterator3 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope5 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    producerScope2 = producerScope5;
                    channelIterator = channelIterator3;
                    c009012 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    c009012.L$0 = producerScope2;
                    c009012.L$1 = channelIterator;
                    c009012.label = 3;
                    if (ChannelsKt.toChannel((ReceiveChannel) obj, producerScope2, c009012) != obj2) {
                    }
                    break;
                case 3:
                    c00901 = this;
                    it = (ChannelIterator) c00901.L$1;
                    producerScope = (ProducerScope) c00901.L$0;
                    ResultKt.throwOnFailure(obj);
                    c00901.L$0 = producerScope;
                    c00901.L$1 = it;
                    c00901.label = 1;
                    objHasNext = it.hasNext(c00901);
                    if (objHasNext == coroutine_suspended) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel flatMap(ReceiveChannel $this$flatMap, CoroutineContext context, Function2 transform) {
        return ProduceKt.produce(GlobalScope.INSTANCE, (6 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? CoroutineStart.DEFAULT : null, (6 & 8) != 0 ? null : ChannelsKt.consumes($this$flatMap), new C00901($this$flatMap, transform, null));
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.map(receiveChannel, coroutineContext, function2);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {487, 333, 333}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
    static final class C00951<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_map;
        final /* synthetic */ Function2<E, Continuation<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00951(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super C00951> continuation) {
            super(2, continuation);
            this.$this_map = receiveChannel;
            this.$transform = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00951 c00951 = new C00951(this.$this_map, this.$transform, continuation);
            c00951.L$0 = obj;
            return c00951;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
            return ((C00951) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00ba A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00cc A[Catch: all -> 0x011a, TryCatch #3 {all -> 0x011a, blocks: (B:25:0x00c4, B:27:0x00cc, B:31:0x00ec, B:36:0x010f), top: B:53:0x00c4 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0100 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0101  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x010f A[Catch: all -> 0x011a, TRY_LEAVE, TryCatch #3 {all -> 0x011a, blocks: (B:25:0x00c4, B:27:0x00cc, B:31:0x00ec, B:36:0x010f), top: B:53:0x00c4 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0101 -> B:35:0x010c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            ReceiveChannel $this$consume$iv$iv;
            C00951<R> c00951;
            Object $result;
            ProducerScope $this$produce;
            int $i$f$consumeEach;
            Throwable cause$iv$iv;
            ChannelIterator it;
            Function2 function2;
            Object $result2;
            Object $result3;
            Function2 function22;
            ProducerScope $this$produce2;
            ReceiveChannel $this$consume$iv$iv2;
            Throwable cause$iv$iv2;
            Object $result4;
            ChannelIterator channelIterator;
            Function2 function23;
            ProducerScope $this$produce3;
            ProducerScope $this$produce4;
            int $i$f$consumeEach2;
            Function2 function24;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        c00951 = this;
                        $result = obj;
                        $this$produce = (ProducerScope) c00951.L$0;
                        ReceiveChannel $this$consumeEach$iv = c00951.$this_map;
                        Function2 function25 = c00951.$transform;
                        $i$f$consumeEach = 0;
                        $this$consume$iv$iv = $this$consumeEach$iv;
                        cause$iv$iv = null;
                        try {
                            it = $this$consume$iv$iv.iterator();
                            function2 = function25;
                            c00951.L$0 = $this$produce;
                            c00951.L$1 = function2;
                            c00951.L$2 = $this$consume$iv$iv;
                            c00951.L$3 = it;
                            c00951.label = 1;
                            objHasNext = it.hasNext(c00951);
                            if (objHasNext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ProducerScope producerScope = $this$produce;
                            $result3 = $result;
                            $result2 = objHasNext;
                            $this$consume$iv$iv2 = $this$consume$iv$iv;
                            cause$iv$iv2 = cause$iv$iv;
                            function22 = function2;
                            $this$produce2 = producerScope;
                            try {
                                if (((Boolean) $result2).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv2);
                                    return Unit.INSTANCE;
                                }
                                Object it2 = it.next();
                                $this$produce4 = null;
                                c00951.L$0 = $this$produce2;
                                c00951.L$1 = function22;
                                c00951.L$2 = $this$consume$iv$iv2;
                                c00951.L$3 = it;
                                c00951.L$4 = $this$produce2;
                                c00951.label = 2;
                                Object objInvoke = function22.invoke(it2, c00951);
                                if (objInvoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result4 = objInvoke;
                                $this$produce3 = $this$produce2;
                                ChannelIterator channelIterator2 = it;
                                function23 = function22;
                                channelIterator = channelIterator2;
                                c00951.L$0 = $this$produce3;
                                c00951.L$1 = function23;
                                c00951.L$2 = $this$consume$iv$iv2;
                                c00951.L$3 = channelIterator;
                                c00951.L$4 = null;
                                c00951.label = 3;
                                if ($this$produce2.send($result4, c00951) != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result = $result3;
                                $i$f$consumeEach2 = $i$f$consumeEach;
                                $this$produce = $this$produce3;
                                Function2 function26 = function23;
                                it = channelIterator;
                                cause$iv$iv = cause$iv$iv2;
                                $this$consume$iv$iv = $this$consume$iv$iv2;
                                function24 = function26;
                                $i$f$consumeEach = $i$f$consumeEach2;
                                function2 = function24;
                                c00951.L$0 = $this$produce;
                                c00951.L$1 = function2;
                                c00951.L$2 = $this$consume$iv$iv;
                                c00951.L$3 = it;
                                c00951.label = 1;
                                objHasNext = it.hasNext(c00951);
                                if (objHasNext == coroutine_suspended) {
                                }
                            } catch (Throwable th) {
                                e$iv$iv = th;
                                $this$consume$iv$iv = $this$consume$iv$iv2;
                                Throwable cause$iv$iv3 = e$iv$iv;
                                try {
                                    throw e$iv$iv;
                                } catch (Throwable e$iv$iv) {
                                    ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv3);
                                    throw e$iv$iv;
                                }
                            }
                        } catch (Throwable th2) {
                            e$iv$iv = th2;
                            Throwable cause$iv$iv32 = e$iv$iv;
                            throw e$iv$iv;
                        }
                        break;
                    case 1:
                        c00951 = this;
                        $result2 = obj;
                        ChannelIterator channelIterator3 = (ChannelIterator) c00951.L$3;
                        ReceiveChannel $this$consume$iv$iv3 = (ReceiveChannel) c00951.L$2;
                        Function2 function27 = (Function2) c00951.L$1;
                        ProducerScope $this$produce5 = (ProducerScope) c00951.L$0;
                        ResultKt.throwOnFailure($result2);
                        it = channelIterator3;
                        $i$f$consumeEach = 0;
                        $result3 = $result2;
                        function22 = function27;
                        $this$produce2 = $this$produce5;
                        $this$consume$iv$iv2 = $this$consume$iv$iv3;
                        cause$iv$iv2 = null;
                        if (((Boolean) $result2).booleanValue()) {
                        }
                        break;
                    case 2:
                        c00951 = this;
                        $result4 = obj;
                        $this$produce2 = (ProducerScope) c00951.L$4;
                        channelIterator = (ChannelIterator) c00951.L$3;
                        cause$iv$iv2 = null;
                        $this$consume$iv$iv2 = (ReceiveChannel) c00951.L$2;
                        function23 = (Function2) c00951.L$1;
                        ProducerScope $this$produce6 = (ProducerScope) c00951.L$0;
                        try {
                            ResultKt.throwOnFailure($result4);
                            $this$produce3 = $this$produce6;
                            $this$produce4 = null;
                            $i$f$consumeEach = 0;
                            $result3 = $result4;
                            c00951.L$0 = $this$produce3;
                            c00951.L$1 = function23;
                            c00951.L$2 = $this$consume$iv$iv2;
                            c00951.L$3 = channelIterator;
                            c00951.L$4 = null;
                            c00951.label = 3;
                            if ($this$produce2.send($result4, c00951) != coroutine_suspended) {
                            }
                        } catch (Throwable th3) {
                            e$iv$iv = th3;
                            $this$consume$iv$iv = $this$consume$iv$iv2;
                            Throwable cause$iv$iv322 = e$iv$iv;
                            throw e$iv$iv;
                        }
                        break;
                    case 3:
                        c00951 = this;
                        $result = obj;
                        ChannelIterator channelIterator4 = (ChannelIterator) c00951.L$3;
                        cause$iv$iv = null;
                        $this$consume$iv$iv = (ReceiveChannel) c00951.L$2;
                        function24 = (Function2) c00951.L$1;
                        ProducerScope $this$produce7 = (ProducerScope) c00951.L$0;
                        ResultKt.throwOnFailure($result);
                        $i$f$consumeEach2 = 0;
                        $this$produce = $this$produce7;
                        it = channelIterator4;
                        $i$f$consumeEach = $i$f$consumeEach2;
                        function2 = function24;
                        c00951.L$0 = $this$produce;
                        c00951.L$1 = function2;
                        c00951.L$2 = $this$consume$iv$iv;
                        c00951.L$3 = it;
                        c00951.label = 1;
                        objHasNext = it.hasNext(c00951);
                        if (objHasNext == coroutine_suspended) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Throwable th4) {
                e$iv$iv = th4;
            }
        }
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext context, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ProduceKt.produce(GlobalScope.INSTANCE, (6 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? CoroutineStart.DEFAULT : null, (6 & 8) != 0 ? null : ChannelsKt.consumes(receiveChannel), new C00951(receiveChannel, function2, null));
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {344, 345, 345}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    static final class C00961<R> extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_mapIndexed;
        final /* synthetic */ Function3<Integer, E, Continuation<? super R>, Object> $transform;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00961(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super C00961> continuation) {
            super(2, continuation);
            this.$this_mapIndexed = receiveChannel;
            this.$transform = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00961 c00961 = new C00961(this.$this_mapIndexed, this.$transform, continuation);
            c00961.L$0 = obj;
            return c00961;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super R> producerScope, Continuation<? super Unit> continuation) {
            return ((C00961) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0072 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00b8 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00bf  */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00b9 -> B:10:0x0060). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            C00961<R> c00961;
            ProducerScope producerScope;
            int i;
            ChannelIterator it;
            ProducerScope producerScope2;
            ChannelIterator channelIterator;
            C00961<R> c009612;
            Object obj2;
            Object obj3;
            ProducerScope producerScope3;
            ProducerScope producerScope4;
            int i2;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c00961 = this;
                    producerScope = (ProducerScope) c00961.L$0;
                    i = 0;
                    it = c00961.$this_mapIndexed.iterator();
                    c00961.L$0 = producerScope;
                    c00961.L$1 = it;
                    c00961.I$0 = i;
                    c00961.label = 1;
                    objHasNext = it.hasNext(c00961);
                    if (objHasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj4 = coroutine_suspended;
                    obj3 = obj;
                    obj = objHasNext;
                    channelIterator = it;
                    producerScope2 = producerScope;
                    c009612 = c00961;
                    obj2 = obj4;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    Object next = channelIterator.next();
                    Function3<Integer, E, Continuation<? super R>, Object> function3 = c009612.$transform;
                    i2 = i + 1;
                    Integer numBoxInt = Boxing.boxInt(i);
                    c009612.L$0 = producerScope2;
                    c009612.L$1 = channelIterator;
                    c009612.L$2 = producerScope2;
                    c009612.I$0 = i2;
                    c009612.label = 2;
                    obj = function3.invoke(numBoxInt, (E) next, c009612);
                    if (obj == obj2) {
                        return obj2;
                    }
                    producerScope3 = producerScope2;
                    it = channelIterator;
                    producerScope4 = producerScope3;
                    c009612.L$0 = producerScope4;
                    c009612.L$1 = it;
                    c009612.L$2 = null;
                    c009612.I$0 = i2;
                    c009612.label = 3;
                    if (producerScope3.send(obj, c009612) != obj2) {
                        return obj2;
                    }
                    obj = obj3;
                    coroutine_suspended = obj2;
                    c00961 = c009612;
                    producerScope = producerScope4;
                    i = i2;
                    c00961.L$0 = producerScope;
                    c00961.L$1 = it;
                    c00961.I$0 = i;
                    c00961.label = 1;
                    objHasNext = it.hasNext(c00961);
                    if (objHasNext == coroutine_suspended) {
                    }
                    break;
                case 1:
                    int i3 = this.I$0;
                    ChannelIterator channelIterator2 = (ChannelIterator) this.L$1;
                    producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    channelIterator = channelIterator2;
                    i = i3;
                    c009612 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    break;
                case 2:
                    int i4 = this.I$0;
                    producerScope3 = (ProducerScope) this.L$2;
                    it = (ChannelIterator) this.L$1;
                    producerScope4 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    i2 = i4;
                    c009612 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    c009612.L$0 = producerScope4;
                    c009612.L$1 = it;
                    c009612.L$2 = null;
                    c009612.I$0 = i2;
                    c009612.label = 3;
                    if (producerScope3.send(obj, c009612) != obj2) {
                    }
                    break;
                case 3:
                    c00961 = this;
                    int i5 = c00961.I$0;
                    ChannelIterator channelIterator3 = (ChannelIterator) c00961.L$1;
                    ProducerScope producerScope5 = (ProducerScope) c00961.L$0;
                    ResultKt.throwOnFailure(obj);
                    i = i5;
                    producerScope = producerScope5;
                    it = channelIterator3;
                    c00961.L$0 = producerScope;
                    c00961.L$1 = it;
                    c00961.I$0 = i;
                    c00961.label = 1;
                    objHasNext = it.hasNext(c00961);
                    if (objHasNext == coroutine_suspended) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext context, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ProduceKt.produce(GlobalScope.INSTANCE, (6 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? CoroutineStart.DEFAULT : null, (6 & 8) != 0 ? null : ChannelsKt.consumes(receiveChannel), new C00961(receiveChannel, function3, null));
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapIndexedNotNull(ReceiveChannel $this$mapIndexedNotNull, CoroutineContext context, Function3 transform) {
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed($this$mapIndexedNotNull, context, transform));
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return mapNotNull(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel mapNotNull(ReceiveChannel $this$mapNotNull, CoroutineContext context, Function2 transform) {
        return ChannelsKt.filterNotNull(ChannelsKt.map($this$mapNotNull, context, transform));
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {370, 371}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0"})
    static final class C01071<E> extends SuspendLambda implements Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_withIndex;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01071(ReceiveChannel<? extends E> receiveChannel, Continuation<? super C01071> continuation) {
            super(2, continuation);
            this.$this_withIndex = receiveChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01071 c01071 = new C01071(this.$this_withIndex, continuation);
            c01071.L$0 = obj;
            return c01071;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super IndexedValue<? extends E>> producerScope, Continuation<? super Unit> continuation) {
            return ((C01071) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x005b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x008e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0088 -> B:9:0x0049). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) throws Throwable {
            C01071<E> c01071;
            ProducerScope $this$produce;
            int index;
            ChannelIterator<E> it;
            ProducerScope $this$produce2;
            C01071<E> c010712;
            Object obj;
            Object $result2;
            Object objHasNext;
            Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c01071 = this;
                    $this$produce = (ProducerScope) c01071.L$0;
                    index = 0;
                    it = c01071.$this_withIndex.iterator();
                    c01071.L$0 = $this$produce;
                    c01071.L$1 = it;
                    c01071.I$0 = index;
                    c01071.label = 1;
                    objHasNext = it.hasNext(c01071);
                    if (objHasNext == $result3) {
                        return $result3;
                    }
                    Object obj2 = $result3;
                    $result2 = $result;
                    $result = objHasNext;
                    $this$produce2 = $this$produce;
                    c010712 = c01071;
                    obj = obj2;
                    if (((Boolean) $result).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    Object e = it.next();
                    int index2 = index + 1;
                    c010712.L$0 = $this$produce2;
                    c010712.L$1 = it;
                    c010712.I$0 = index2;
                    c010712.label = 2;
                    if ($this$produce2.send(new IndexedValue(index, e), c010712) == obj) {
                        return obj;
                    }
                    $result = $result2;
                    $result3 = obj;
                    c01071 = c010712;
                    $this$produce = $this$produce2;
                    index = index2;
                    c01071.L$0 = $this$produce;
                    c01071.L$1 = it;
                    c01071.I$0 = index;
                    c01071.label = 1;
                    objHasNext = it.hasNext(c01071);
                    if (objHasNext == $result3) {
                    }
                    break;
                case 1:
                    int index3 = this.I$0;
                    ChannelIterator<E> channelIterator = (ChannelIterator) this.L$1;
                    ProducerScope $this$produce3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    $this$produce2 = $this$produce3;
                    it = channelIterator;
                    index = index3;
                    c010712 = this;
                    obj = $result3;
                    $result2 = $result;
                    if (((Boolean) $result).booleanValue()) {
                    }
                    break;
                case 2:
                    c01071 = this;
                    int index4 = c01071.I$0;
                    ChannelIterator<E> channelIterator2 = (ChannelIterator) c01071.L$1;
                    ProducerScope $this$produce4 = (ProducerScope) c01071.L$0;
                    ResultKt.throwOnFailure($result);
                    index = index4;
                    $this$produce = $this$produce4;
                    it = channelIterator2;
                    c01071.L$0 = $this$produce;
                    c01071.L$1 = it;
                    c01071.I$0 = index;
                    c01071.label = 1;
                    objHasNext = it.hasNext(c01071);
                    if (objHasNext == $result3) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return withIndex(receiveChannel, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ ReceiveChannel withIndex(ReceiveChannel $this$withIndex, CoroutineContext context) {
        return ProduceKt.produce(GlobalScope.INSTANCE, (6 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? CoroutineStart.DEFAULT : null, (6 & 8) != 0 ? null : ChannelsKt.consumes($this$withIndex), new C01071($this$withIndex, null));
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u0002H\u0001H\u008a@"}, d2 = {"<anonymous>", "E", "it"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinct$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C00771<E> extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {
        /* synthetic */ Object L$0;
        int label;

        C00771(Continuation<? super C00771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00771 c00771 = new C00771(continuation);
            c00771.L$0 = obj;
            return c00771;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(E e, Continuation<? super E> continuation) {
            return ((C00771) create(e, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Object it = this.L$0;
                    return it;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "E", "K", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {387, 388, 390}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
    static final class C00781<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<E, Continuation<? super K>, Object> $selector;
        final /* synthetic */ ReceiveChannel<E> $this_distinctBy;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C00781(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super C00781> continuation) {
            super(2, continuation);
            this.$this_distinctBy = receiveChannel;
            this.$selector = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00781 c00781 = new C00781(this.$this_distinctBy, this.$selector, continuation);
            c00781.L$0 = obj;
            return c00781;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super E> producerScope, Continuation<? super Unit> continuation) {
            return ((C00781) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0082 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0083  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e7  */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v17 */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v11 */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v15 */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object, kotlinx.coroutines.channels.ProducerScope] */
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Type inference failed for: r6v8, types: [java.util.Collection] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00cd -> B:26:0x00d5). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00e0 -> B:10:0x006d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            C00781<E> c00781;
            HashSet hashSet;
            ?? r4;
            ChannelIterator<E> it;
            ?? r5;
            HashSet hashSet2;
            ChannelIterator<E> channelIterator;
            C00781<E> c007812;
            Object obj2;
            Object obj3;
            ?? r6;
            HashSet hashSet3;
            ChannelIterator<E> channelIterator2;
            Object obj4;
            ChannelIterator<E> channelIterator3;
            HashSet hashSet4;
            ?? r52;
            Object obj5;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c00781 = this;
                    ProducerScope producerScope = (ProducerScope) c00781.L$0;
                    hashSet = new HashSet();
                    r4 = producerScope;
                    it = c00781.$this_distinctBy.iterator();
                    c00781.L$0 = r4;
                    c00781.L$1 = hashSet;
                    c00781.L$2 = it;
                    c00781.L$3 = null;
                    c00781.label = 1;
                    objHasNext = it.hasNext(c00781);
                    if (objHasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj6 = coroutine_suspended;
                    obj3 = obj;
                    obj = objHasNext;
                    r5 = r4;
                    hashSet2 = hashSet;
                    channelIterator = it;
                    c007812 = c00781;
                    obj2 = obj6;
                    if (((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    E next = channelIterator.next();
                    Function2 function2 = c007812.$selector;
                    c007812.L$0 = r5;
                    c007812.L$1 = hashSet2;
                    c007812.L$2 = channelIterator;
                    c007812.L$3 = next;
                    c007812.label = 2;
                    Object objInvoke = function2.invoke(next, c007812);
                    if (objInvoke == obj2) {
                        return obj2;
                    }
                    ChannelIterator<E> channelIterator4 = channelIterator;
                    obj4 = next;
                    obj = objInvoke;
                    r6 = r5;
                    hashSet3 = hashSet2;
                    channelIterator2 = channelIterator4;
                    if (hashSet3.contains(obj)) {
                        c007812.L$0 = r6;
                        c007812.L$1 = hashSet3;
                        c007812.L$2 = channelIterator2;
                        c007812.L$3 = obj;
                        c007812.label = 3;
                        if (r6.send(obj4, c007812) == obj2) {
                            return obj2;
                        }
                        channelIterator3 = channelIterator2;
                        hashSet4 = hashSet3;
                        r52 = r6;
                        C00781<E> c007813 = c007812;
                        obj5 = obj;
                        obj = obj3;
                        coroutine_suspended = obj2;
                        c00781 = c007813;
                        hashSet4.add(obj5);
                        it = channelIterator3;
                        hashSet = hashSet4;
                        r4 = r52;
                        c00781.L$0 = r4;
                        c00781.L$1 = hashSet;
                        c00781.L$2 = it;
                        c00781.L$3 = null;
                        c00781.label = 1;
                        objHasNext = it.hasNext(c00781);
                        if (objHasNext != coroutine_suspended) {
                        }
                    } else {
                        obj = obj3;
                        coroutine_suspended = obj2;
                        c00781 = c007812;
                        it = channelIterator2;
                        hashSet = hashSet3;
                        r4 = r6;
                        c00781.L$0 = r4;
                        c00781.L$1 = hashSet;
                        c00781.L$2 = it;
                        c00781.L$3 = null;
                        c00781.label = 1;
                        objHasNext = it.hasNext(c00781);
                        if (objHasNext != coroutine_suspended) {
                        }
                    }
                    break;
                case 1:
                    ChannelIterator<E> channelIterator5 = (ChannelIterator) this.L$2;
                    HashSet hashSet5 = (HashSet) this.L$1;
                    ProducerScope producerScope2 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r5 = producerScope2;
                    hashSet2 = hashSet5;
                    channelIterator = channelIterator5;
                    c007812 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    if (((Boolean) obj).booleanValue()) {
                    }
                    break;
                case 2:
                    Object obj7 = this.L$3;
                    ChannelIterator<E> channelIterator6 = (ChannelIterator) this.L$2;
                    HashSet hashSet6 = (HashSet) this.L$1;
                    ProducerScope producerScope3 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    r6 = producerScope3;
                    hashSet3 = hashSet6;
                    channelIterator2 = channelIterator6;
                    obj4 = obj7;
                    c007812 = this;
                    obj2 = coroutine_suspended;
                    obj3 = obj;
                    if (hashSet3.contains(obj)) {
                    }
                    break;
                case 3:
                    c00781 = this;
                    obj5 = c00781.L$3;
                    channelIterator3 = (ChannelIterator) c00781.L$2;
                    hashSet4 = (HashSet) c00781.L$1;
                    ProducerScope producerScope4 = (ProducerScope) c00781.L$0;
                    ResultKt.throwOnFailure(obj);
                    r52 = producerScope4;
                    hashSet4.add(obj5);
                    it = channelIterator3;
                    hashSet = hashSet4;
                    r4 = r52;
                    c00781.L$0 = r4;
                    c00781.L$1 = hashSet;
                    c00781.L$2 = it;
                    c00781.L$3 = null;
                    c00781.label = 1;
                    objHasNext = it.hasNext(c00781);
                    if (objHasNext != coroutine_suspended) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext context, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ProduceKt.produce(GlobalScope.INSTANCE, (6 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? CoroutineStart.DEFAULT : null, (6 & 8) != 0 ? null : ChannelsKt.consumes(receiveChannel), new C00781(receiveChannel, function2, null));
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, new LinkedHashSet(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object any(ReceiveChannel $this$any, Continuation continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        ReceiveChannel $this$consume$iv;
        Throwable cause$iv;
        Object objHasNext;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        AnonymousClass1 anonymousClass12 = anonymousClass1;
        Object $result = anonymousClass12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass12.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$consume$iv = $this$any;
                cause$iv = null;
                try {
                    ChannelIterator it = $this$consume$iv.iterator();
                    anonymousClass12.L$0 = $this$consume$iv;
                    anonymousClass12.label = 1;
                    objHasNext = it.hasNext(anonymousClass12);
                    if (objHasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return objHasNext;
                } catch (Throwable th) {
                    e$iv = th;
                    Throwable cause$iv2 = e$iv;
                    try {
                        throw e$iv;
                    } finally {
                        ChannelsKt.cancelConsumed($this$consume$iv, cause$iv2);
                    }
                }
            case 1:
                $this$consume$iv = (ReceiveChannel) anonymousClass12.L$0;
                cause$iv = null;
                try {
                    ResultKt.throwOnFailure($result);
                    objHasNext = $result;
                    return objHasNext;
                } catch (Throwable th2) {
                    e$iv = th2;
                    Throwable cause$iv22 = e$iv;
                    throw e$iv;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0089 A[Catch: all -> 0x00ab, TryCatch #3 {all -> 0x00ab, blocks: (B:24:0x0081, B:26:0x0089, B:27:0x009c), top: B:45:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c A[Catch: all -> 0x00ab, TRY_LEAVE, TryCatch #3 {all -> 0x00ab, blocks: (B:24:0x0081, B:26:0x0089, B:27:0x009c), top: B:45:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0077 -> B:45:0x0081). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object count(ReceiveChannel $this$consumeEach$iv, Continuation continuation) throws Throwable {
        C00761 c00761;
        ReceiveChannel $this$consume$iv$iv;
        Object $result;
        Ref.IntRef count;
        ReceiveChannel $this$consume$iv$iv2;
        Throwable cause$iv$iv;
        ChannelIterator channelIterator;
        int i;
        Ref.IntRef intRef;
        Object obj;
        if (continuation instanceof C00761) {
            c00761 = (C00761) continuation;
            if ((c00761.label & Integer.MIN_VALUE) != 0) {
                c00761.label -= Integer.MIN_VALUE;
            } else {
                c00761 = new C00761(continuation);
            }
        }
        C00761 c007612 = c00761;
        Object e$iv = c007612.result;
        Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c007612.label) {
            case 0:
                ResultKt.throwOnFailure(e$iv);
                Ref.IntRef count2 = new Ref.IntRef();
                $this$consume$iv$iv = $this$consumeEach$iv;
                Throwable cause$iv$iv2 = null;
                try {
                    ChannelIterator it = $this$consume$iv$iv.iterator();
                    Ref.IntRef count3 = null;
                    int $i$f$consume = 0;
                    Ref.IntRef count4 = count2;
                    c007612.L$0 = count4;
                    c007612.L$1 = $this$consume$iv$iv;
                    c007612.L$2 = it;
                    c007612.label = 1;
                    Object objHasNext = it.hasNext(c007612);
                    if (objHasNext != $result2) {
                        return $result2;
                    }
                    Object obj2 = $result2;
                    $result = e$iv;
                    e$iv = objHasNext;
                    count = count4;
                    $this$consume$iv$iv2 = $this$consume$iv$iv;
                    cause$iv$iv = cause$iv$iv2;
                    channelIterator = it;
                    i = $i$f$consume;
                    intRef = count3;
                    obj = obj2;
                    try {
                        if (((Boolean) e$iv).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv);
                            int $i$f$consumeEach = count.element;
                            return Boxing.boxInt($i$f$consumeEach);
                        }
                        channelIterator.next();
                        count.element++;
                        e$iv = $result;
                        $result2 = obj;
                        count3 = intRef;
                        $i$f$consume = i;
                        it = channelIterator;
                        cause$iv$iv2 = cause$iv$iv;
                        $this$consume$iv$iv = $this$consume$iv$iv2;
                        count4 = count;
                        c007612.L$0 = count4;
                        c007612.L$1 = $this$consume$iv$iv;
                        c007612.L$2 = it;
                        c007612.label = 1;
                        Object objHasNext2 = it.hasNext(c007612);
                        if (objHasNext2 != $result2) {
                        }
                    } catch (Throwable th) {
                        $this$consume$iv$iv = $this$consume$iv$iv2;
                        e$iv$iv = th;
                        Throwable cause$iv$iv3 = e$iv$iv;
                        try {
                            throw e$iv$iv;
                        } catch (Throwable e$iv$iv) {
                            ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv3);
                            throw e$iv$iv;
                        }
                    }
                } catch (Throwable th2) {
                    e$iv$iv = th2;
                    Throwable cause$iv$iv32 = e$iv$iv;
                    throw e$iv$iv;
                }
                break;
            case 1:
                ChannelIterator channelIterator2 = (ChannelIterator) c007612.L$2;
                $this$consume$iv$iv = (ReceiveChannel) c007612.L$1;
                Ref.IntRef count5 = (Ref.IntRef) c007612.L$0;
                try {
                    ResultKt.throwOnFailure(e$iv);
                    count = count5;
                    $this$consume$iv$iv2 = $this$consume$iv$iv;
                    cause$iv$iv = null;
                    channelIterator = channelIterator2;
                    i = 0;
                    intRef = null;
                    obj = $result2;
                    $result = e$iv;
                    if (((Boolean) e$iv).booleanValue()) {
                    }
                } catch (Throwable th3) {
                    e$iv$iv = th3;
                    Throwable cause$iv$iv322 = e$iv$iv;
                    throw e$iv$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7 A[Catch: all -> 0x00eb, TRY_LEAVE, TryCatch #6 {all -> 0x00eb, blocks: (B:38:0x00bf, B:40:0x00c7), top: B:73:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b6 -> B:73:0x00bf). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object maxWith(ReceiveChannel $this$consume$iv, Comparator comparator, Continuation continuation) throws Throwable {
        C00971 c00971;
        Throwable cause$iv;
        ReceiveChannel $this$consume$iv2;
        Throwable e$iv;
        ChannelIterator iterator;
        Object objHasNext;
        ReceiveChannel receiveChannel;
        Comparator comparator2;
        Object $result;
        Comparator comparator3;
        ReceiveChannel $this$consume$iv3;
        ChannelIterator iterator2;
        Throwable th;
        Object max;
        Object max2;
        if (continuation instanceof C00971) {
            c00971 = (C00971) continuation;
            if ((c00971.label & Integer.MIN_VALUE) != 0) {
                c00971.label -= Integer.MIN_VALUE;
            } else {
                c00971 = new C00971(continuation);
            }
        }
        C00971 c009712 = c00971;
        Object max3 = c009712.result;
        Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c009712.label) {
            case 0:
                ResultKt.throwOnFailure(max3);
                cause$iv = null;
                try {
                    iterator = $this$consume$iv.iterator();
                    c009712.L$0 = comparator;
                    c009712.L$1 = $this$consume$iv;
                    c009712.L$2 = iterator;
                    c009712.label = 1;
                    objHasNext = iterator.hasNext(c009712);
                    if (objHasNext == $result2) {
                        return $result2;
                    }
                    receiveChannel = $this$consume$iv;
                    comparator2 = comparator;
                    try {
                        if (((Boolean) objHasNext).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel, cause$iv);
                            return null;
                        }
                        ReceiveChannel $this$consume$iv4 = receiveChannel;
                        try {
                            Throwable cause$iv2 = cause$iv;
                            Object max4 = iterator.next();
                            ReceiveChannel $this$consume$iv5 = $this$consume$iv4;
                            try {
                                c009712.L$0 = comparator2;
                                c009712.L$1 = $this$consume$iv5;
                                c009712.L$2 = iterator;
                                c009712.L$3 = max4;
                                c009712.label = 2;
                                Object objHasNext2 = iterator.hasNext(c009712);
                                if (objHasNext2 != $result2) {
                                    return $result2;
                                }
                                Object obj = $result2;
                                $result = max3;
                                max3 = objHasNext2;
                                comparator3 = comparator2;
                                $this$consume$iv3 = $this$consume$iv5;
                                iterator2 = iterator;
                                th = cause$iv2;
                                max = max4;
                                max2 = obj;
                                try {
                                    if (((Boolean) max3).booleanValue()) {
                                        ChannelsKt.cancelConsumed($this$consume$iv3, th);
                                        return max;
                                    }
                                    Object e = iterator2.next();
                                    if (comparator3.compare(max, e) < 0) {
                                        ReceiveChannel $this$consume$iv6 = $this$consume$iv3;
                                        comparator2 = comparator3;
                                        Object obj2 = max2;
                                        max4 = e;
                                        max3 = $result;
                                        $result2 = obj2;
                                        ChannelIterator channelIterator = iterator2;
                                        $this$consume$iv5 = $this$consume$iv6;
                                        cause$iv2 = th;
                                        iterator = channelIterator;
                                    } else {
                                        ReceiveChannel $this$consume$iv7 = $this$consume$iv3;
                                        comparator2 = comparator3;
                                        ChannelIterator channelIterator2 = iterator2;
                                        $this$consume$iv5 = $this$consume$iv7;
                                        max3 = $result;
                                        $result2 = max2;
                                        max4 = max;
                                        cause$iv2 = th;
                                        iterator = channelIterator2;
                                    }
                                    c009712.L$0 = comparator2;
                                    c009712.L$1 = $this$consume$iv5;
                                    c009712.L$2 = iterator;
                                    c009712.L$3 = max4;
                                    c009712.label = 2;
                                    Object objHasNext22 = iterator.hasNext(c009712);
                                    if (objHasNext22 != $result2) {
                                    }
                                } catch (Throwable th2) {
                                    e$iv = th2;
                                    $this$consume$iv2 = $this$consume$iv3;
                                    Throwable cause$iv3 = e$iv;
                                    try {
                                        throw e$iv;
                                    } catch (Throwable e$iv2) {
                                        ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv3);
                                        throw e$iv2;
                                    }
                                }
                            } catch (Throwable th3) {
                                e$iv = th3;
                                $this$consume$iv2 = $this$consume$iv5;
                                Throwable cause$iv32 = e$iv;
                                throw e$iv;
                            }
                        } catch (Throwable th4) {
                            e$iv = th4;
                            $this$consume$iv2 = $this$consume$iv4;
                            Throwable cause$iv322 = e$iv;
                            throw e$iv;
                        }
                    } catch (Throwable th5) {
                        e$iv = th5;
                        $this$consume$iv2 = receiveChannel;
                    }
                } catch (Throwable th6) {
                    $this$consume$iv2 = $this$consume$iv;
                    e$iv = th6;
                    Throwable cause$iv3222 = e$iv;
                    throw e$iv;
                }
                break;
            case 1:
                ChannelIterator iterator3 = (ChannelIterator) c009712.L$2;
                ReceiveChannel receiveChannel2 = (ReceiveChannel) c009712.L$1;
                Comparator comparator4 = (Comparator) c009712.L$0;
                try {
                    ResultKt.throwOnFailure(max3);
                    objHasNext = max3;
                    comparator2 = comparator4;
                    receiveChannel = receiveChannel2;
                    iterator = iterator3;
                    cause$iv = null;
                    if (((Boolean) objHasNext).booleanValue()) {
                    }
                } catch (Throwable th7) {
                    e$iv = th7;
                    $this$consume$iv2 = receiveChannel2;
                    Throwable cause$iv32222 = e$iv;
                    throw e$iv;
                }
                break;
            case 2:
                Object max5 = c009712.L$3;
                ChannelIterator iterator4 = (ChannelIterator) c009712.L$2;
                ReceiveChannel receiveChannel3 = (ReceiveChannel) c009712.L$1;
                Comparator comparator5 = (Comparator) c009712.L$0;
                try {
                    ResultKt.throwOnFailure(max3);
                    comparator3 = comparator5;
                    $this$consume$iv3 = receiveChannel3;
                    iterator2 = iterator4;
                    th = null;
                    max = max5;
                    max2 = $result2;
                    $result = max3;
                    if (((Boolean) max3).booleanValue()) {
                    }
                } catch (Throwable th8) {
                    e$iv = th8;
                    $this$consume$iv2 = receiveChannel3;
                    Throwable cause$iv322222 = e$iv;
                    throw e$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7 A[Catch: all -> 0x00eb, TRY_LEAVE, TryCatch #6 {all -> 0x00eb, blocks: (B:38:0x00bf, B:40:0x00c7), top: B:73:0x00bf }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00b6 -> B:73:0x00bf). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object minWith(ReceiveChannel $this$consume$iv, Comparator comparator, Continuation continuation) throws Throwable {
        C00981 c00981;
        Throwable cause$iv;
        ReceiveChannel $this$consume$iv2;
        Throwable e$iv;
        ChannelIterator iterator;
        Object objHasNext;
        ReceiveChannel receiveChannel;
        Comparator comparator2;
        Object $result;
        Comparator comparator3;
        ReceiveChannel $this$consume$iv3;
        ChannelIterator iterator2;
        Throwable th;
        Object min;
        Object min2;
        if (continuation instanceof C00981) {
            c00981 = (C00981) continuation;
            if ((c00981.label & Integer.MIN_VALUE) != 0) {
                c00981.label -= Integer.MIN_VALUE;
            } else {
                c00981 = new C00981(continuation);
            }
        }
        C00981 c009812 = c00981;
        Object min3 = c009812.result;
        Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c009812.label) {
            case 0:
                ResultKt.throwOnFailure(min3);
                cause$iv = null;
                try {
                    iterator = $this$consume$iv.iterator();
                    c009812.L$0 = comparator;
                    c009812.L$1 = $this$consume$iv;
                    c009812.L$2 = iterator;
                    c009812.label = 1;
                    objHasNext = iterator.hasNext(c009812);
                    if (objHasNext == $result2) {
                        return $result2;
                    }
                    receiveChannel = $this$consume$iv;
                    comparator2 = comparator;
                    try {
                        if (((Boolean) objHasNext).booleanValue()) {
                            ChannelsKt.cancelConsumed(receiveChannel, cause$iv);
                            return null;
                        }
                        ReceiveChannel $this$consume$iv4 = receiveChannel;
                        try {
                            Throwable cause$iv2 = cause$iv;
                            Object min4 = iterator.next();
                            ReceiveChannel $this$consume$iv5 = $this$consume$iv4;
                            try {
                                c009812.L$0 = comparator2;
                                c009812.L$1 = $this$consume$iv5;
                                c009812.L$2 = iterator;
                                c009812.L$3 = min4;
                                c009812.label = 2;
                                Object objHasNext2 = iterator.hasNext(c009812);
                                if (objHasNext2 != $result2) {
                                    return $result2;
                                }
                                Object obj = $result2;
                                $result = min3;
                                min3 = objHasNext2;
                                comparator3 = comparator2;
                                $this$consume$iv3 = $this$consume$iv5;
                                iterator2 = iterator;
                                th = cause$iv2;
                                min = min4;
                                min2 = obj;
                                try {
                                    if (((Boolean) min3).booleanValue()) {
                                        ChannelsKt.cancelConsumed($this$consume$iv3, th);
                                        return min;
                                    }
                                    Object e = iterator2.next();
                                    if (comparator3.compare(min, e) > 0) {
                                        ReceiveChannel $this$consume$iv6 = $this$consume$iv3;
                                        comparator2 = comparator3;
                                        Object obj2 = min2;
                                        min4 = e;
                                        min3 = $result;
                                        $result2 = obj2;
                                        ChannelIterator channelIterator = iterator2;
                                        $this$consume$iv5 = $this$consume$iv6;
                                        cause$iv2 = th;
                                        iterator = channelIterator;
                                    } else {
                                        ReceiveChannel $this$consume$iv7 = $this$consume$iv3;
                                        comparator2 = comparator3;
                                        ChannelIterator channelIterator2 = iterator2;
                                        $this$consume$iv5 = $this$consume$iv7;
                                        min3 = $result;
                                        $result2 = min2;
                                        min4 = min;
                                        cause$iv2 = th;
                                        iterator = channelIterator2;
                                    }
                                    c009812.L$0 = comparator2;
                                    c009812.L$1 = $this$consume$iv5;
                                    c009812.L$2 = iterator;
                                    c009812.L$3 = min4;
                                    c009812.label = 2;
                                    Object objHasNext22 = iterator.hasNext(c009812);
                                    if (objHasNext22 != $result2) {
                                    }
                                } catch (Throwable th2) {
                                    e$iv = th2;
                                    $this$consume$iv2 = $this$consume$iv3;
                                    Throwable cause$iv3 = e$iv;
                                    try {
                                        throw e$iv;
                                    } catch (Throwable e$iv2) {
                                        ChannelsKt.cancelConsumed($this$consume$iv2, cause$iv3);
                                        throw e$iv2;
                                    }
                                }
                            } catch (Throwable th3) {
                                e$iv = th3;
                                $this$consume$iv2 = $this$consume$iv5;
                                Throwable cause$iv32 = e$iv;
                                throw e$iv;
                            }
                        } catch (Throwable th4) {
                            e$iv = th4;
                            $this$consume$iv2 = $this$consume$iv4;
                            Throwable cause$iv322 = e$iv;
                            throw e$iv;
                        }
                    } catch (Throwable th5) {
                        e$iv = th5;
                        $this$consume$iv2 = receiveChannel;
                    }
                } catch (Throwable th6) {
                    $this$consume$iv2 = $this$consume$iv;
                    e$iv = th6;
                    Throwable cause$iv3222 = e$iv;
                    throw e$iv;
                }
                break;
            case 1:
                ChannelIterator iterator3 = (ChannelIterator) c009812.L$2;
                ReceiveChannel receiveChannel2 = (ReceiveChannel) c009812.L$1;
                Comparator comparator4 = (Comparator) c009812.L$0;
                try {
                    ResultKt.throwOnFailure(min3);
                    objHasNext = min3;
                    comparator2 = comparator4;
                    receiveChannel = receiveChannel2;
                    iterator = iterator3;
                    cause$iv = null;
                    if (((Boolean) objHasNext).booleanValue()) {
                    }
                } catch (Throwable th7) {
                    e$iv = th7;
                    $this$consume$iv2 = receiveChannel2;
                    Throwable cause$iv32222 = e$iv;
                    throw e$iv;
                }
                break;
            case 2:
                Object min5 = c009812.L$3;
                ChannelIterator iterator4 = (ChannelIterator) c009812.L$2;
                ReceiveChannel receiveChannel3 = (ReceiveChannel) c009812.L$1;
                Comparator comparator5 = (Comparator) c009812.L$0;
                try {
                    ResultKt.throwOnFailure(min3);
                    comparator3 = comparator5;
                    $this$consume$iv3 = receiveChannel3;
                    iterator2 = iterator4;
                    th = null;
                    min = min5;
                    min2 = $result2;
                    $result = min3;
                    if (((Boolean) min3).booleanValue()) {
                    }
                } catch (Throwable th8) {
                    e$iv = th8;
                    $this$consume$iv2 = receiveChannel3;
                    Throwable cause$iv322222 = e$iv;
                    throw e$iv;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object none(ReceiveChannel $this$none, Continuation continuation) throws Throwable {
        C00991 c00991;
        ReceiveChannel $this$consume$iv;
        Throwable cause$iv;
        Object objHasNext;
        if (continuation instanceof C00991) {
            c00991 = (C00991) continuation;
            if ((c00991.label & Integer.MIN_VALUE) != 0) {
                c00991.label -= Integer.MIN_VALUE;
            } else {
                c00991 = new C00991(continuation);
            }
        }
        C00991 c009912 = c00991;
        Object $result = c009912.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (c009912.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$consume$iv = $this$none;
                cause$iv = null;
                try {
                    ChannelIterator it = $this$consume$iv.iterator();
                    c009912.L$0 = $this$consume$iv;
                    c009912.label = 1;
                    objHasNext = it.hasNext(c009912);
                    if (objHasNext == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) objHasNext).booleanValue()) {
                        z = false;
                    }
                    Boolean boolBoxBoolean = Boxing.boxBoolean(z);
                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                    return boolBoxBoolean;
                } catch (Throwable th) {
                    e$iv = th;
                    Throwable cause$iv2 = e$iv;
                    try {
                        throw e$iv;
                    } catch (Throwable e$iv) {
                        ChannelsKt.cancelConsumed($this$consume$iv, cause$iv2);
                        throw e$iv;
                    }
                }
            case 1:
                $this$consume$iv = (ReceiveChannel) c009912.L$0;
                cause$iv = null;
                try {
                    ResultKt.throwOnFailure($result);
                    objHasNext = $result;
                    if (!((Boolean) objHasNext).booleanValue()) {
                    }
                    Boolean boolBoxBoolean2 = Boxing.boxBoolean(z);
                    ChannelsKt.cancelConsumed($this$consume$iv, cause$iv);
                    return boolBoxBoolean2;
                } catch (Throwable th2) {
                    e$iv = th2;
                    Throwable cause$iv22 = e$iv;
                    throw e$iv;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0001H\u008a@"}, d2 = {"<anonymous>", "E", "", "it"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01001<E> extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {
        final /* synthetic */ ReceiveChannel<E> $this_requireNoNulls;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01001(ReceiveChannel<? extends E> receiveChannel, Continuation<? super C01001> continuation) {
            super(2, continuation);
            this.$this_requireNoNulls = receiveChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01001 c01001 = new C01001(this.$this_requireNoNulls, continuation);
            c01001.L$0 = obj;
            return c01001;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(E e, Continuation<? super E> continuation) {
            return ((C01001) create(e, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Object it = this.L$0;
                    if (it != null) {
                        return it;
                    }
                    throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Deprecated.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@"}, d2 = {"<anonymous>", "", "E", "R", "V", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {487, 469, 471}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
    static final class C01092<V> extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<R> $other;
        final /* synthetic */ ReceiveChannel<E> $this_zip;
        final /* synthetic */ Function2<E, R, V> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C01092(ReceiveChannel<? extends R> receiveChannel, ReceiveChannel<? extends E> receiveChannel2, Function2<? super E, ? super R, ? extends V> function2, Continuation<? super C01092> continuation) {
            super(2, continuation);
            this.$other = receiveChannel;
            this.$this_zip = receiveChannel2;
            this.$transform = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C01092 c01092 = new C01092(this.$other, this.$this_zip, this.$transform, continuation);
            c01092.L$0 = obj;
            return c01092;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super V> producerScope, Continuation<? super Unit> continuation) {
            return ((C01092) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00d9 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00f0 A[Catch: all -> 0x0176, TRY_LEAVE, TryCatch #2 {all -> 0x0176, blocks: (B:26:0x00e8, B:28:0x00f0, B:46:0x016c), top: B:62:0x00e8 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0152  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x016c A[Catch: all -> 0x0176, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0176, blocks: (B:26:0x00e8, B:28:0x00f0, B:46:0x016c), top: B:62:0x00e8 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x013a -> B:39:0x0143). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0152 -> B:22:0x00c4). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            ReceiveChannel $this$consume$iv$iv;
            C01092<V> c01092;
            Object $result;
            Throwable cause$iv$iv;
            ChannelIterator otherIterator;
            ChannelIterator otherIterator2;
            int $i$f$consume;
            ProducerScope $this$produce;
            Object $result2;
            Function2 function2;
            ChannelIterator it;
            Object $result3;
            ProducerScope $this$produce2;
            ChannelIterator otherIterator3;
            ReceiveChannel $this$consume$iv$iv2;
            Throwable cause$iv$iv2;
            Function2 function22;
            ChannelIterator channelIterator;
            int i;
            ChannelIterator channelIterator2;
            Object obj2;
            Object $result4;
            Object element1;
            int i2;
            Object element12;
            Throwable cause$iv$iv3;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            Object obj3 = null;
            try {
            } catch (Throwable th) {
                e$iv$iv = th;
            }
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    c01092 = this;
                    $result = obj;
                    ProducerScope $this$produce3 = (ProducerScope) c01092.L$0;
                    ChannelIterator otherIterator4 = c01092.$other.iterator();
                    ReceiveChannel $this$consumeEach$iv = c01092.$this_zip;
                    $this$consume$iv$iv = $this$consumeEach$iv;
                    cause$iv$iv = null;
                    try {
                        otherIterator = otherIterator4;
                        otherIterator2 = null;
                        $i$f$consume = 0;
                        $this$produce = $this$produce3;
                        $result2 = null;
                        function2 = c01092.$transform;
                        it = $this$consume$iv$iv.iterator();
                        c01092.L$0 = $this$produce;
                        c01092.L$1 = otherIterator;
                        c01092.L$2 = function2;
                        c01092.L$3 = $this$consume$iv$iv;
                        c01092.L$4 = it;
                        c01092.L$5 = obj3;
                        c01092.label = 1;
                        objHasNext = it.hasNext(c01092);
                    } catch (Throwable th2) {
                        e$iv$iv = th2;
                    }
                    if (objHasNext != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj4 = $result2;
                    $result4 = $result;
                    $result3 = objHasNext;
                    $this$produce2 = $this$produce;
                    otherIterator3 = otherIterator;
                    $this$consume$iv$iv2 = $this$consume$iv$iv;
                    cause$iv$iv2 = cause$iv$iv;
                    function22 = function2;
                    channelIterator = it;
                    i = $i$f$consume;
                    channelIterator2 = otherIterator2;
                    obj2 = obj4;
                    try {
                        if (((Boolean) $result3).booleanValue()) {
                            Unit unit = Unit.INSTANCE;
                            ChannelsKt.cancelConsumed($this$consume$iv$iv2, cause$iv$iv2);
                            return Unit.INSTANCE;
                        }
                        Object element13 = channelIterator.next();
                        i2 = 0;
                        c01092.L$0 = $this$produce2;
                        c01092.L$1 = otherIterator3;
                        c01092.L$2 = function22;
                        c01092.L$3 = $this$consume$iv$iv2;
                        c01092.L$4 = channelIterator;
                        c01092.L$5 = element13;
                        c01092.label = 2;
                        Object objHasNext2 = otherIterator3.hasNext(c01092);
                        if (objHasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        element1 = objHasNext2;
                        element12 = element13;
                        try {
                            if (((Boolean) element1).booleanValue()) {
                                Throwable th3 = cause$iv$iv2;
                                $result = $result4;
                                $result2 = obj2;
                                otherIterator2 = channelIterator2;
                                $i$f$consume = i;
                                it = channelIterator;
                                function2 = function22;
                                $this$consume$iv$iv = $this$consume$iv$iv2;
                                otherIterator = otherIterator3;
                                $this$produce = $this$produce2;
                                obj3 = null;
                                cause$iv$iv = th3;
                                c01092.L$0 = $this$produce;
                                c01092.L$1 = otherIterator;
                                c01092.L$2 = function2;
                                c01092.L$3 = $this$consume$iv$iv;
                                c01092.L$4 = it;
                                c01092.L$5 = obj3;
                                c01092.label = 1;
                                objHasNext = it.hasNext(c01092);
                                if (objHasNext != coroutine_suspended) {
                                }
                            } else {
                                Throwable cause$iv$iv4 = cause$iv$iv2;
                                try {
                                    Object element2 = otherIterator3.next();
                                    Object objInvoke = function22.invoke(element12, element2);
                                    c01092.L$0 = $this$produce2;
                                    c01092.L$1 = otherIterator3;
                                    c01092.L$2 = function22;
                                    c01092.L$3 = $this$consume$iv$iv2;
                                    c01092.L$4 = channelIterator;
                                    c01092.L$5 = null;
                                    c01092.label = 3;
                                    if ($this$produce2.send(objInvoke, c01092) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    cause$iv$iv3 = cause$iv$iv4;
                                    $result = $result4;
                                    $result2 = obj2;
                                    otherIterator2 = channelIterator2;
                                    $i$f$consume = i;
                                    $this$consume$iv$iv = $this$consume$iv$iv2;
                                    otherIterator = otherIterator3;
                                    $this$produce = $this$produce2;
                                    it = channelIterator;
                                    function2 = function22;
                                    obj3 = null;
                                    cause$iv$iv = cause$iv$iv3;
                                    c01092.L$0 = $this$produce;
                                    c01092.L$1 = otherIterator;
                                    c01092.L$2 = function2;
                                    c01092.L$3 = $this$consume$iv$iv;
                                    c01092.L$4 = it;
                                    c01092.L$5 = obj3;
                                    c01092.label = 1;
                                    objHasNext = it.hasNext(c01092);
                                    if (objHasNext != coroutine_suspended) {
                                    }
                                } catch (Throwable th4) {
                                    e$iv$iv = th4;
                                    $this$consume$iv$iv = $this$consume$iv$iv2;
                                }
                            }
                        } catch (Throwable th5) {
                            e$iv$iv = th5;
                            $this$consume$iv$iv = $this$consume$iv$iv2;
                        }
                    } catch (Throwable th6) {
                        e$iv$iv = th6;
                        $this$consume$iv$iv = $this$consume$iv$iv2;
                    }
                    Throwable cause$iv$iv5 = e$iv$iv;
                    try {
                        throw e$iv$iv;
                    } catch (Throwable e$iv$iv) {
                        ChannelsKt.cancelConsumed($this$consume$iv$iv, cause$iv$iv5);
                        throw e$iv$iv;
                    }
                    break;
                case 1:
                    c01092 = this;
                    $result3 = obj;
                    ChannelIterator channelIterator3 = (ChannelIterator) c01092.L$4;
                    ReceiveChannel $this$consume$iv$iv3 = (ReceiveChannel) c01092.L$3;
                    Function2 function23 = (Function2) c01092.L$2;
                    ChannelIterator otherIterator5 = (ChannelIterator) c01092.L$1;
                    ProducerScope $this$produce4 = (ProducerScope) c01092.L$0;
                    ResultKt.throwOnFailure($result3);
                    $this$produce2 = $this$produce4;
                    otherIterator3 = otherIterator5;
                    $this$consume$iv$iv2 = $this$consume$iv$iv3;
                    cause$iv$iv2 = null;
                    function22 = function23;
                    channelIterator = channelIterator3;
                    i = 0;
                    channelIterator2 = null;
                    obj2 = null;
                    $result4 = $result3;
                    if (((Boolean) $result3).booleanValue()) {
                    }
                    Throwable cause$iv$iv52 = e$iv$iv;
                    throw e$iv$iv;
                case 2:
                    c01092 = this;
                    element1 = obj;
                    Object element14 = c01092.L$5;
                    ChannelIterator channelIterator4 = (ChannelIterator) c01092.L$4;
                    $this$consume$iv$iv = (ReceiveChannel) c01092.L$3;
                    Function2 function24 = (Function2) c01092.L$2;
                    otherIterator3 = (ChannelIterator) c01092.L$1;
                    $this$produce2 = (ProducerScope) c01092.L$0;
                    try {
                        ResultKt.throwOnFailure(element1);
                        i2 = 0;
                        i = 0;
                        channelIterator2 = null;
                        obj2 = null;
                        $result4 = element1;
                        cause$iv$iv2 = null;
                        element12 = element14;
                        channelIterator = channelIterator4;
                        function22 = function24;
                        $this$consume$iv$iv2 = $this$consume$iv$iv;
                        if (((Boolean) element1).booleanValue()) {
                        }
                    } catch (Throwable th7) {
                        e$iv$iv = th7;
                        break;
                    }
                    break;
                case 3:
                    c01092 = this;
                    $result = obj;
                    $result2 = null;
                    otherIterator2 = null;
                    $i$f$consume = 0;
                    channelIterator = (ChannelIterator) c01092.L$4;
                    $this$consume$iv$iv = (ReceiveChannel) c01092.L$3;
                    Function2 function25 = (Function2) c01092.L$2;
                    ChannelIterator otherIterator6 = (ChannelIterator) c01092.L$1;
                    ProducerScope $this$produce5 = (ProducerScope) c01092.L$0;
                    ResultKt.throwOnFailure($result);
                    cause$iv$iv3 = null;
                    function22 = function25;
                    otherIterator = otherIterator6;
                    $this$produce = $this$produce5;
                    it = channelIterator;
                    function2 = function22;
                    obj3 = null;
                    cause$iv$iv = cause$iv$iv3;
                    c01092.L$0 = $this$produce;
                    c01092.L$1 = otherIterator;
                    c01092.L$2 = function2;
                    c01092.L$3 = $this$consume$iv$iv;
                    c01092.L$4 = it;
                    c01092.L$5 = obj3;
                    c01092.label = 1;
                    objHasNext = it.hasNext(c01092);
                    if (objHasNext != coroutine_suspended) {
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext context, Function2<? super E, ? super R, ? extends V> function2) {
        return ProduceKt.produce(GlobalScope.INSTANCE, (6 & 1) != 0 ? EmptyCoroutineContext.INSTANCE : context, (6 & 2) != 0 ? 0 : 0, (6 & 4) != 0 ? CoroutineStart.DEFAULT : null, (6 & 8) != 0 ? null : ChannelsKt.consumesAll(receiveChannel, receiveChannel2), new C01092(receiveChannel2, receiveChannel, function2, null));
    }

    public static final Function1<Throwable, Unit> consumes(final ReceiveChannel<?> receiveChannel) {
        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.consumes.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable cause) {
                ChannelsKt.cancelConsumed(receiveChannel, cause);
            }
        };
    }
}
