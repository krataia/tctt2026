package kotlin.internal;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;

/* JADX INFO: compiled from: UProgressionUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class UProgressionUtilKt {
    /* JADX INFO: renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m1254differenceModuloWZ9TVnA(int a, int b, int c) {
        int ac = UnsignedKt.m390uintRemainderJ1ME1BU(a, c);
        int bc = UnsignedKt.m390uintRemainderJ1ME1BU(b, c);
        return UInt.m136constructorimpl(UnsignedKt.uintCompare(ac, bc) >= 0 ? ac - bc : UInt.m136constructorimpl(ac - bc) + c);
    }

    /* JADX INFO: renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m1255differenceModulosambcqE(long a, long b, long c) {
        long ac = UnsignedKt.m392ulongRemaindereb3DHEI(a, c);
        long bc = UnsignedKt.m392ulongRemaindereb3DHEI(b, c);
        return ULong.m214constructorimpl(UnsignedKt.ulongCompare(ac, bc) >= 0 ? ac - bc : ULong.m214constructorimpl(ac - bc) + c);
    }

    /* JADX INFO: renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m1257getProgressionLastElementNkh28Cs(int start, int end, int step) {
        if (step > 0) {
            if (UnsignedKt.uintCompare(start, end) < 0) {
                return UInt.m136constructorimpl(end - m1254differenceModuloWZ9TVnA(end, start, UInt.m136constructorimpl(step)));
            }
        } else {
            if (step >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (UnsignedKt.uintCompare(start, end) > 0) {
                return UInt.m136constructorimpl(m1254differenceModuloWZ9TVnA(start, end, UInt.m136constructorimpl(-step)) + end);
            }
        }
        return end;
    }

    /* JADX INFO: renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m1256getProgressionLastElement7ftBX0g(long start, long end, long step) {
        if (step > 0) {
            if (UnsignedKt.ulongCompare(start, end) < 0) {
                return ULong.m214constructorimpl(end - m1255differenceModulosambcqE(end, start, ULong.m214constructorimpl(step)));
            }
        } else {
            if (step >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (UnsignedKt.ulongCompare(start, end) > 0) {
                return ULong.m214constructorimpl(m1255differenceModulosambcqE(start, end, ULong.m214constructorimpl(-step)) + end);
            }
        }
        return end;
    }
}
