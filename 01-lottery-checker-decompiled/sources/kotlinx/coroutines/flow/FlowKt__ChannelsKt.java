package kotlinx.coroutines.flow;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a/\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a9\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "receiveAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super Unit> continuation) throws Throwable {
        Object objEmitAllImpl$FlowKt__ChannelsKt = emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, true, continuation);
        return objEmitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmitAllImpl$FlowKt__ChannelsKt : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0097 A[Catch: all -> 0x00c7, TRY_LEAVE, TryCatch #2 {all -> 0x00c7, blocks: (B:29:0x0091, B:31:0x0097, B:38:0x00a9, B:39:0x00aa), top: B:58:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa A[Catch: all -> 0x00c7, TRY_LEAVE, TryCatch #2 {all -> 0x00c7, blocks: (B:29:0x0091, B:31:0x0097, B:38:0x00a9, B:39:0x00aa), top: B:58:0x0091 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00be -> B:23:0x0072). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, boolean consume, Continuation<? super Unit> continuation) throws Throwable {
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1;
        ReceiveChannel channel;
        Throwable cause;
        Object obj;
        Object $result;
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$12;
        boolean consume2;
        ReceiveChannel channel2;
        FlowCollector<? super T> flowCollector2;
        Throwable th;
        boolean consume3;
        Object holder;
        Throwable cause2;
        Object result;
        if (continuation instanceof FlowKt__ChannelsKt$emitAllImpl$1) {
            flowKt__ChannelsKt$emitAllImpl$1 = (FlowKt__ChannelsKt$emitAllImpl$1) continuation;
            if ((flowKt__ChannelsKt$emitAllImpl$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__ChannelsKt$emitAllImpl$1.label -= Integer.MIN_VALUE;
            } else {
                flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
            }
        }
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$13 = flowKt__ChannelsKt$emitAllImpl$1;
        Object $result2 = flowKt__ChannelsKt$emitAllImpl$13.result;
        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (flowKt__ChannelsKt$emitAllImpl$13.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                FlowKt.ensureActive(flowCollector);
                channel = receiveChannel;
                cause = null;
                obj = $result3;
                $result = $result2;
                flowKt__ChannelsKt$emitAllImpl$12 = flowKt__ChannelsKt$emitAllImpl$13;
                try {
                    flowKt__ChannelsKt$emitAllImpl$12.L$0 = flowCollector;
                    flowKt__ChannelsKt$emitAllImpl$12.L$1 = channel;
                    flowKt__ChannelsKt$emitAllImpl$12.Z$0 = consume;
                    flowKt__ChannelsKt$emitAllImpl$12.label = 1;
                    holder = channel.mo1665receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$12);
                } catch (Throwable cause3) {
                    e = cause3;
                    consume3 = consume;
                    channel2 = channel;
                }
                if (holder == obj) {
                    return obj;
                }
                try {
                    Object obj2 = obj;
                    flowCollector2 = flowCollector;
                    th = cause;
                    consume2 = consume;
                    channel2 = channel;
                    flowKt__ChannelsKt$emitAllImpl$13 = flowKt__ChannelsKt$emitAllImpl$12;
                    $result2 = $result;
                    $result3 = obj2;
                    if (!ChannelResult.m1680isClosedimpl(result)) {
                        Throwable it = ChannelResult.m1676exceptionOrNullimpl(result);
                        if (it == null) {
                            return Unit.INSTANCE;
                        }
                        throw it;
                    }
                    Object objM1678getOrThrowimpl = ChannelResult.m1678getOrThrowimpl(result);
                    flowKt__ChannelsKt$emitAllImpl$13.L$0 = flowCollector2;
                    flowKt__ChannelsKt$emitAllImpl$13.L$1 = channel2;
                    flowKt__ChannelsKt$emitAllImpl$13.Z$0 = consume3;
                    flowKt__ChannelsKt$emitAllImpl$13.label = 2;
                    if (flowCollector2.emit(objM1678getOrThrowimpl, flowKt__ChannelsKt$emitAllImpl$13) == $result3) {
                        return $result3;
                    }
                    boolean z = consume3;
                    cause = cause2;
                    flowCollector = flowCollector2;
                    obj = $result3;
                    $result = $result2;
                    flowKt__ChannelsKt$emitAllImpl$12 = flowKt__ChannelsKt$emitAllImpl$13;
                    channel = channel2;
                    consume = z;
                    flowKt__ChannelsKt$emitAllImpl$12.L$0 = flowCollector;
                    flowKt__ChannelsKt$emitAllImpl$12.L$1 = channel;
                    flowKt__ChannelsKt$emitAllImpl$12.Z$0 = consume;
                    flowKt__ChannelsKt$emitAllImpl$12.label = 1;
                    holder = channel.mo1665receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$12);
                    if (holder == obj) {
                    }
                } catch (Throwable th2) {
                    e = th2;
                    consume3 = consume3;
                }
                cause2 = th;
                result = holder;
                cause2 = e;
                try {
                    throw e;
                } finally {
                    if (consume3) {
                        ChannelsKt.cancelConsumed(channel2, cause2);
                    }
                }
                break;
            case 1:
                consume2 = flowKt__ChannelsKt$emitAllImpl$13.Z$0;
                channel2 = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$13.L$1;
                flowCollector2 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$13.L$0;
                th = null;
                try {
                    ResultKt.throwOnFailure($result2);
                    holder = ((ChannelResult) $result2).getHolder();
                    cause2 = th;
                    result = holder;
                    if (!ChannelResult.m1680isClosedimpl(result)) {
                    }
                } catch (Throwable th3) {
                    e = th3;
                    consume3 = consume2;
                }
                cause2 = e;
                throw e;
            case 2:
                consume3 = flowKt__ChannelsKt$emitAllImpl$13.Z$0;
                cause = null;
                channel2 = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$13.L$1;
                FlowCollector<? super T> flowCollector3 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$13.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    consume = consume3;
                    flowCollector = flowCollector3;
                    obj = $result3;
                    $result = $result2;
                    flowKt__ChannelsKt$emitAllImpl$12 = flowKt__ChannelsKt$emitAllImpl$13;
                    channel = channel2;
                    flowKt__ChannelsKt$emitAllImpl$12.L$0 = flowCollector;
                    flowKt__ChannelsKt$emitAllImpl$12.L$1 = channel;
                    flowKt__ChannelsKt$emitAllImpl$12.Z$0 = consume;
                    flowKt__ChannelsKt$emitAllImpl$12.label = 1;
                    holder = channel.mo1665receiveCatchingJP2dKIU(flowKt__ChannelsKt$emitAllImpl$12);
                    if (holder == obj) {
                    }
                } catch (Throwable th4) {
                    e = th4;
                    break;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, false, null, 0, null, 28, null);
    }

    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, true, null, 0, null, 28, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> Flow<T> asFlow(final BroadcastChannel<T> broadcastChannel) {
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
                Object objEmitAll = FlowKt.emitAll(flowCollector, broadcastChannel.openSubscription(), continuation);
                return objEmitAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmitAll : Unit.INSTANCE;
            }
        };
    }

    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> flow, CoroutineScope scope) {
        return ChannelFlowKt.asChannelFlow(flow).produceImpl(scope);
    }
}
