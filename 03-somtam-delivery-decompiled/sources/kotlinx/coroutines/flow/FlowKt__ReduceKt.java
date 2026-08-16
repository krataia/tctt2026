package kotlinx.coroutines.flow;

import androidx.core.view.MotionEventCompat;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: compiled from: Reduce.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a!\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001aE\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a#\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001aG\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001ay\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\r\u001a\u0002H\f2H\b\u0004\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a!\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a#\u0010\u0016\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001as\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u0018\"\b\b\u0001\u0010\u0001*\u0002H\u0018*\b\u0012\u0004\u0012\u0002H\u00010\u00022F\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a!\u0010\u001b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a#\u0010\u001c\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"first", "T", "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "acc", "value", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastOrNull", "reduce", "S", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "single", "singleOrNull", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ReduceKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1, reason: invalid class name */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "first", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.first(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3, reason: invalid class name */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0}, l = {183}, m = "first", n = {"predicate", "result", "collector$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass3<T> extends ContinuationImpl {
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
            return FlowKt.first(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "firstOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class C01091<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01091(Continuation<? super C01091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.firstOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "firstOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class C01103<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01103(Continuation<? super C01103> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.firstOrNull(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {MotionEventCompat.AXIS_GENERIC_13}, m = "fold", n = {"accumulator"}, s = {"L$0"})
    static final class C01111<T, R> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01111(Continuation<? super C01111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt.fold(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {155}, m = "last", n = {"result"}, s = {"L$0"})
    static final class C01121<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01121(Continuation<? super C01121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.last(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {167}, m = "lastOrNull", n = {"result"}, s = {"L$0"})
    static final class C01141<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01141(Continuation<? super C01141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.lastOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {22}, m = "reduce", n = {"accumulator"}, s = {"L$0"})
    static final class C01161<S, T extends S> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01161(Continuation<? super C01161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.reduce(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {57}, m = "single", n = {"result"}, s = {"L$0"})
    static final class C01181<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C01181(Continuation<? super C01181> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.single(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "singleOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class C01201<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01201(Continuation<? super C01201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.singleOrNull(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, kotlinx.coroutines.internal.Symbol] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S, T extends S> Object reduce(Flow<? extends T> flow, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, Continuation<? super S> continuation) throws Throwable {
        C01161 c01161;
        Ref.ObjectRef accumulator;
        if (continuation instanceof C01161) {
            c01161 = (C01161) continuation;
            if ((c01161.label & Integer.MIN_VALUE) != 0) {
                c01161.label -= Integer.MIN_VALUE;
            } else {
                c01161 = new C01161(continuation);
            }
        }
        C01161 c011612 = c01161;
        Object $result = c011612.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c011612.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.ObjectRef accumulator2 = new Ref.ObjectRef();
                accumulator2.element = NullSurrogateKt.NULL;
                FlowCollector<? super Object> c01172 = new C01172<>(accumulator2, function3);
                c011612.L$0 = accumulator2;
                c011612.label = 1;
                if (flow.collect(c01172, c011612) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                accumulator = accumulator2;
                break;
                break;
            case 1:
                accumulator = (Ref.ObjectRef) c011612.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (accumulator.element == NullSurrogateKt.NULL) {
            throw new NoSuchElementException("Empty flow can't be reduced");
        }
        return accumulator.element;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "S", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C01172<T> implements FlowCollector, SuspendFunction {
        final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
        final /* synthetic */ Function3<S, T, Continuation<? super S>, Object> $operation;

        /* JADX WARN: Multi-variable type inference failed */
        C01172(Ref.ObjectRef<Object> objectRef, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3) {
            this.$accumulator = objectRef;
            this.$operation = function3;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) throws Throwable {
            FlowKt__ReduceKt$reduce$2$emit$1 flowKt__ReduceKt$reduce$2$emit$1;
            Ref.ObjectRef<Object> objectRef;
            if (continuation instanceof FlowKt__ReduceKt$reduce$2$emit$1) {
                flowKt__ReduceKt$reduce$2$emit$1 = (FlowKt__ReduceKt$reduce$2$emit$1) continuation;
                if ((flowKt__ReduceKt$reduce$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    flowKt__ReduceKt$reduce$2$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    flowKt__ReduceKt$reduce$2$emit$1 = new FlowKt__ReduceKt$reduce$2$emit$1(this, continuation);
                }
            }
            FlowKt__ReduceKt$reduce$2$emit$1 flowKt__ReduceKt$reduce$2$emit$12 = flowKt__ReduceKt$reduce$2$emit$1;
            Object obj = flowKt__ReduceKt$reduce$2$emit$12.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (flowKt__ReduceKt$reduce$2$emit$12.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    objectRef = this.$accumulator;
                    if (this.$accumulator.element != NullSurrogateKt.NULL) {
                        Function3<S, T, Continuation<? super S>, Object> function3 = this.$operation;
                        Object obj2 = this.$accumulator.element;
                        flowKt__ReduceKt$reduce$2$emit$12.L$0 = objectRef;
                        flowKt__ReduceKt$reduce$2$emit$12.label = 1;
                        Object objInvoke = function3.invoke((S) obj2, t, flowKt__ReduceKt$reduce$2$emit$12);
                        if (objInvoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        t = (T) objInvoke;
                    }
                    break;
                case 1:
                    Ref.ObjectRef<Object> objectRef2 = (Ref.ObjectRef) flowKt__ReduceKt$reduce$2$emit$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef = objectRef2;
                    t = (T) obj;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef.element = t;
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, R> Object fold(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) throws Throwable {
        C01111 c01111;
        Ref.ObjectRef accumulator;
        if (continuation instanceof C01111) {
            c01111 = (C01111) continuation;
            if ((c01111.label & Integer.MIN_VALUE) != 0) {
                c01111.label -= Integer.MIN_VALUE;
            } else {
                c01111 = new C01111(continuation);
            }
        }
        C01111 c011112 = c01111;
        Object $result = c011112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c011112.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.ObjectRef accumulator2 = new Ref.ObjectRef();
                accumulator2.element = r;
                FlowCollector<? super Object> anonymousClass2 = new AnonymousClass2<>(accumulator2, function3);
                c011112.L$0 = accumulator2;
                c011112.label = 1;
                if (flow.collect(anonymousClass2, c011112) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                accumulator = accumulator2;
                break;
            case 1:
                accumulator = (Ref.ObjectRef) c011112.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return accumulator.element;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2, reason: invalid class name */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass2<T> implements FlowCollector, SuspendFunction {
        final /* synthetic */ Ref.ObjectRef<R> $accumulator;
        final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Ref.ObjectRef<R> objectRef, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
            this.$accumulator = objectRef;
            this.$operation = function3;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t, Continuation<? super Unit> continuation) throws Throwable {
            FlowKt__ReduceKt$fold$2$emit$1 flowKt__ReduceKt$fold$2$emit$1;
            T t2;
            Ref.ObjectRef objectRef;
            if (continuation instanceof FlowKt__ReduceKt$fold$2$emit$1) {
                flowKt__ReduceKt$fold$2$emit$1 = (FlowKt__ReduceKt$fold$2$emit$1) continuation;
                if ((flowKt__ReduceKt$fold$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    flowKt__ReduceKt$fold$2$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    flowKt__ReduceKt$fold$2$emit$1 = new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
                }
            }
            FlowKt__ReduceKt$fold$2$emit$1 flowKt__ReduceKt$fold$2$emit$12 = flowKt__ReduceKt$fold$2$emit$1;
            Object obj = flowKt__ReduceKt$fold$2$emit$12.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (flowKt__ReduceKt$fold$2$emit$12.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = this.$accumulator;
                    Function3<R, T, Continuation<? super R>, Object> function3 = this.$operation;
                    T t3 = this.$accumulator.element;
                    flowKt__ReduceKt$fold$2$emit$12.L$0 = objectRef2;
                    flowKt__ReduceKt$fold$2$emit$12.label = 1;
                    Object objInvoke = function3.invoke((R) t3, t, flowKt__ReduceKt$fold$2$emit$12);
                    if (objInvoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    t2 = (T) objInvoke;
                    objectRef = objectRef2;
                    break;
                case 1:
                    objectRef = (Ref.ObjectRef) flowKt__ReduceKt$fold$2$emit$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    t2 = (T) obj;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef.element = t2;
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object emit$$forInline(T t, Continuation<? super Unit> continuation) {
            InlineMarker.mark(4);
            new FlowKt__ReduceKt$fold$2$emit$1(this, continuation);
            InlineMarker.mark(5);
            this.$accumulator.element = (T) this.$operation.invoke((R) this.$accumulator.element, t, (Continuation<? super R>) continuation);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, R> Object fold$$forInline(Flow<? extends T> flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        Ref.ObjectRef accumulator = new Ref.ObjectRef();
        accumulator.element = r;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(accumulator, function3);
        InlineMarker.mark(0);
        flow.collect(anonymousClass2, continuation);
        InlineMarker.mark(1);
        return accumulator.element;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object single(Flow<? extends T> flow, Continuation<? super T> continuation) throws Throwable {
        C01181 c01181;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C01181) {
            c01181 = (C01181) continuation;
            if ((c01181.label & Integer.MIN_VALUE) != 0) {
                c01181.label -= Integer.MIN_VALUE;
            } else {
                c01181 = new C01181(continuation);
            }
        }
        C01181 c011812 = c01181;
        Object obj = c011812.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c011812.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = (T) NullSurrogateKt.NULL;
                FlowCollector<? super Object> c01192 = new C01192<>(objectRef2);
                c011812.L$0 = objectRef2;
                c011812.label = 1;
                if (flow.collect(c01192, c011812) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                break;
                break;
            case 1:
                objectRef = (Ref.ObjectRef) c011812.L$0;
                ResultKt.throwOnFailure(obj);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (objectRef.element == NullSurrogateKt.NULL) {
            throw new NoSuchElementException("Flow is empty");
        }
        return objectRef.element;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$single$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C01192<T> implements FlowCollector, SuspendFunction {
        final /* synthetic */ Ref.ObjectRef<Object> $result;

        C01192(Ref.ObjectRef<Object> objectRef) {
            this.$result = objectRef;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            if (!(this.$result.element == NullSurrogateKt.NULL)) {
                throw new IllegalArgumentException("Flow has more than one element".toString());
            }
            this.$result.element = t;
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0076 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object singleOrNull(Flow<? extends T> flow, Continuation<? super T> continuation) throws Throwable {
        C01201 c01201;
        final Ref.ObjectRef objectRef;
        FlowCollector<T> flowCollector;
        AbortFlowException e;
        if (continuation instanceof C01201) {
            c01201 = (C01201) continuation;
            if ((c01201.label & Integer.MIN_VALUE) != 0) {
                c01201.label -= Integer.MIN_VALUE;
            } else {
                c01201 = new C01201(continuation);
            }
        }
        C01201 c012012 = c01201;
        Object obj = c012012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c012012.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                objectRef.element = (T) NullSurrogateKt.NULL;
                FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(T t, Continuation<? super Unit> continuation2) {
                        boolean z;
                        if (objectRef.element == NullSurrogateKt.NULL) {
                            objectRef.element = t;
                            z = true;
                        } else {
                            objectRef.element = (T) NullSurrogateKt.NULL;
                            z = false;
                        }
                        if (!z) {
                            throw new AbortFlowException(this);
                        }
                        return Unit.INSTANCE;
                    }
                };
                try {
                    c012012.L$0 = objectRef;
                    c012012.L$1 = flowCollector2;
                    c012012.label = 1;
                    break;
                } catch (AbortFlowException e2) {
                    flowCollector = flowCollector2;
                    e = e2;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                }
                if (flow.collect(flowCollector2, c012012) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (objectRef.element != NullSurrogateKt.NULL) {
                    return null;
                }
                return objectRef.element;
            case 1:
                flowCollector = (FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1) c012012.L$1;
                objectRef = (Ref.ObjectRef) c012012.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (AbortFlowException e3) {
                    e = e3;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                }
                if (objectRef.element != NullSurrogateKt.NULL) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object first(Flow<? extends T> flow, Continuation<? super T> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        final Ref.ObjectRef objectRef;
        FlowCollector<T> flowCollector;
        AbortFlowException e;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        AnonymousClass1 anonymousClass12 = anonymousClass1;
        Object obj = anonymousClass12.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass12.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                objectRef = new Ref.ObjectRef();
                objectRef.element = (T) NullSurrogateKt.NULL;
                FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(T t, Continuation<? super Unit> continuation2) {
                        objectRef.element = t;
                        throw new AbortFlowException(this);
                    }
                };
                try {
                    anonymousClass12.L$0 = objectRef;
                    anonymousClass12.L$1 = flowCollector2;
                    anonymousClass12.label = 1;
                    break;
                } catch (AbortFlowException e2) {
                    flowCollector = flowCollector2;
                    e = e2;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                }
                if (flow.collect(flowCollector2, anonymousClass12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (objectRef.element == NullSurrogateKt.NULL) {
                    return objectRef.element;
                }
                throw new NoSuchElementException("Expected at least one element");
            case 1:
                flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$1) anonymousClass12.L$1;
                objectRef = (Ref.ObjectRef) anonymousClass12.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (AbortFlowException e3) {
                    e = e3;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                }
                if (objectRef.element == NullSurrogateKt.NULL) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object first(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        AnonymousClass3 anonymousClass3;
        Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function22;
        Ref.ObjectRef objectRef;
        FlowCollector<? super Object> flowCollector;
        AbortFlowException e;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            if ((anonymousClass3.label & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        }
        AnonymousClass3 anonymousClass32 = anonymousClass3;
        Object obj = anonymousClass32.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass32.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                function22 = function2;
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = (T) NullSurrogateKt.NULL;
                FlowCollector<? super Object> flowKt__ReduceKt$first$$inlined$collectWhile$2 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2<>(function22, objectRef2);
                try {
                    anonymousClass32.L$0 = function22;
                    anonymousClass32.L$1 = objectRef2;
                    anonymousClass32.L$2 = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                    anonymousClass32.label = 1;
                    break;
                } catch (AbortFlowException e2) {
                    objectRef = objectRef2;
                    flowCollector = flowKt__ReduceKt$first$$inlined$collectWhile$2;
                    e = e2;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                }
                if (flow.collect(flowKt__ReduceKt$first$$inlined$collectWhile$2, anonymousClass32) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                if (objectRef.element == NullSurrogateKt.NULL) {
                    return objectRef.element;
                }
                throw new NoSuchElementException(Intrinsics.stringPlus("Expected at least one element matching the predicate ", function22));
            case 1:
                flowCollector = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) anonymousClass32.L$2;
                objectRef = (Ref.ObjectRef) anonymousClass32.L$1;
                function22 = (Function2) anonymousClass32.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (AbortFlowException e3) {
                    e = e3;
                    FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                }
                if (objectRef.element == NullSurrogateKt.NULL) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object firstOrNull(Flow<? extends T> flow, Continuation<? super T> continuation) throws Throwable {
        C01091 c01091;
        final Ref.ObjectRef result;
        FlowCollector<T> flowCollector;
        AbortFlowException e$iv;
        if (continuation instanceof C01091) {
            c01091 = (C01091) continuation;
            if ((c01091.label & Integer.MIN_VALUE) != 0) {
                c01091.label -= Integer.MIN_VALUE;
            } else {
                c01091 = new C01091(continuation);
            }
        }
        C01091 c010912 = c01091;
        Object $result = c010912.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c010912.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                result = new Ref.ObjectRef();
                FlowCollector<T> flowCollector2 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(T t, Continuation<? super Unit> continuation2) {
                        result.element = t;
                        throw new AbortFlowException(this);
                    }
                };
                try {
                    c010912.L$0 = result;
                    c010912.L$1 = flowCollector2;
                    c010912.label = 1;
                    break;
                } catch (AbortFlowException e) {
                    flowCollector = flowCollector2;
                    e$iv = e;
                    FlowExceptions_commonKt.checkOwnership(e$iv, flowCollector);
                }
                return flow.collect(flowCollector2, c010912) == coroutine_suspended ? coroutine_suspended : result.element;
            case 1:
                flowCollector = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1) c010912.L$1;
                result = (Ref.ObjectRef) c010912.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                } catch (AbortFlowException e2) {
                    e$iv = e2;
                    FlowExceptions_commonKt.checkOwnership(e$iv, flowCollector);
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object firstOrNull(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        C01103 c01103;
        Ref.ObjectRef result;
        FlowCollector<? super Object> collector$iv;
        AbortFlowException e$iv;
        if (continuation instanceof C01103) {
            c01103 = (C01103) continuation;
            if ((c01103.label & Integer.MIN_VALUE) != 0) {
                c01103.label -= Integer.MIN_VALUE;
            } else {
                c01103 = new C01103(continuation);
            }
        }
        C01103 c011032 = c01103;
        Object $result = c011032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c011032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.ObjectRef result2 = new Ref.ObjectRef();
                FlowCollector<? super Object> collector$iv2 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2<>(function2, result2);
                try {
                    c011032.L$0 = result2;
                    c011032.L$1 = collector$iv2;
                    c011032.label = 1;
                    break;
                } catch (AbortFlowException e) {
                    result = result2;
                    collector$iv = collector$iv2;
                    e$iv = e;
                    FlowExceptions_commonKt.checkOwnership(e$iv, collector$iv);
                }
                if (flow.collect(collector$iv2, c011032) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = result2;
                return result.element;
            case 1:
                collector$iv = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) c011032.L$1;
                result = (Ref.ObjectRef) c011032.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    break;
                } catch (AbortFlowException e2) {
                    e$iv = e2;
                    FlowExceptions_commonKt.checkOwnership(e$iv, collector$iv);
                }
                return result.element;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object last(Flow<? extends T> flow, Continuation<? super T> continuation) throws Throwable {
        C01121 c01121;
        Ref.ObjectRef objectRef;
        if (continuation instanceof C01121) {
            c01121 = (C01121) continuation;
            if ((c01121.label & Integer.MIN_VALUE) != 0) {
                c01121.label -= Integer.MIN_VALUE;
            } else {
                c01121 = new C01121(continuation);
            }
        }
        C01121 c011212 = c01121;
        Object obj = c011212.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c011212.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = (T) NullSurrogateKt.NULL;
                FlowCollector<? super Object> c01132 = new C01132<>(objectRef2);
                c011212.L$0 = objectRef2;
                c011212.label = 1;
                if (flow.collect(c01132, c011212) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                break;
                break;
            case 1:
                objectRef = (Ref.ObjectRef) c011212.L$0;
                ResultKt.throwOnFailure(obj);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (objectRef.element == NullSurrogateKt.NULL) {
            throw new NoSuchElementException("Expected at least one element");
        }
        return objectRef.element;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$last$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C01132<T> implements FlowCollector, SuspendFunction {
        final /* synthetic */ Ref.ObjectRef<Object> $result;

        C01132(Ref.ObjectRef<Object> objectRef) {
            this.$result = objectRef;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            this.$result.element = t;
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object lastOrNull(Flow<? extends T> flow, Continuation<? super T> continuation) throws Throwable {
        C01141 c01141;
        Ref.ObjectRef result;
        if (continuation instanceof C01141) {
            c01141 = (C01141) continuation;
            if ((c01141.label & Integer.MIN_VALUE) != 0) {
                c01141.label -= Integer.MIN_VALUE;
            } else {
                c01141 = new C01141(continuation);
            }
        }
        C01141 c011412 = c01141;
        Object $result = c011412.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c011412.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.ObjectRef result2 = new Ref.ObjectRef();
                FlowCollector<? super Object> c01152 = new C01152<>(result2);
                c011412.L$0 = result2;
                c011412.label = 1;
                if (flow.collect(c01152, c011412) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = result2;
                break;
                break;
            case 1:
                result = (Ref.ObjectRef) c011412.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return result.element;
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class C01152<T> implements FlowCollector, SuspendFunction {
        final /* synthetic */ Ref.ObjectRef<T> $result;

        C01152(Ref.ObjectRef<T> objectRef) {
            this.$result = objectRef;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            this.$result.element = t;
            return Unit.INSTANCE;
        }
    }
}
