package kotlin.io.path;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: PathTreeWalk.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0002J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0096\u0002JB\u0010\u0018\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0!\u0012\u0004\u0012\u00020\u00190 H\u0082H¢\u0006\u0002\u0010\"R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "options", "", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "followLinks", "", "getFollowLinks", "()Z", "includeDirectories", "getIncludeDirectories", "isBFS", "linkOptions", "Ljava/nio/file/LinkOption;", "getLinkOptions", "()[Ljava/nio/file/LinkOption;", "[Lkotlin/io/path/PathWalkOption;", "bfsIterator", "", "dfsIterator", "iterator", "yieldIfNeeded", "", "Lkotlin/sequences/SequenceScope;", "node", "Lkotlin/io/path/PathNode;", "entriesReader", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesAction", "Lkotlin/Function1;", "", "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PathTreeWalk implements Sequence<Path> {
    private final PathWalkOption[] options;
    private final Path start;

    public PathTreeWalk(Path start, PathWalkOption[] options) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(options, "options");
        this.start = start;
        this.options = options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getFollowLinks() {
        return ArraysKt.contains(this.options, PathWalkOption.FOLLOW_LINKS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinkOption[] getLinkOptions() {
        return LinkFollowing.INSTANCE.toLinkOptions(getFollowLinks());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getIncludeDirectories() {
        return ArraysKt.contains(this.options, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    private final boolean isBFS() {
        return ArraysKt.contains(this.options, PathWalkOption.BREADTH_FIRST);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Path> iterator() {
        return isBFS() ? bfsIterator() : dfsIterator();
    }

    private final Object yieldIfNeeded(SequenceScope<? super Path> sequenceScope, PathNode node, DirectoryEntriesReader entriesReader, Function1<? super List<PathNode>, Unit> function1, Continuation<? super Unit> continuation) throws FileSystemLoopException {
        Path path = node.getPath();
        LinkOption[] linkOptions = getLinkOptions();
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            if (!PathTreeWalkKt.createsCycle(node)) {
                if (getIncludeDirectories()) {
                    InlineMarker.mark(0);
                    sequenceScope.yield(path, continuation);
                    InlineMarker.mark(1);
                }
                LinkOption[] linkOptions2 = getLinkOptions();
                LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                    function1.invoke(entriesReader.readEntries(node));
                }
            } else {
                throw new FileSystemLoopException(path.toString());
            }
        } else if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            InlineMarker.mark(0);
            sequenceScope.yield(path, continuation);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$dfsIterator$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PathTreeWalk.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {184, 190, 199, 205}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "$this$iterator", "stack", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    static final class C00371 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        C00371(Continuation<? super C00371> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00371 c00371 = PathTreeWalk.this.new C00371(continuation);
            c00371.L$0 = obj;
            return c00371;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C00371) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x017d  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0209  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0207 -> B:33:0x0173). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0209 -> B:33:0x0173). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) throws Throwable {
            C00371 c00371;
            SequenceScope $this$iterator;
            ArrayDeque stack;
            DirectoryEntriesReader entriesReader;
            PathNode startNode;
            PathTreeWalk this_$iv;
            Path path$iv;
            ArrayDeque stack2;
            PathTreeWalk this_$iv2;
            DirectoryEntriesReader entriesReader2;
            Path path$iv2;
            PathNode startNode2;
            PathNode startNode3;
            SequenceScope $this$iterator2;
            LinkOption[] linkOptionArr;
            PathTreeWalk this_$iv3;
            Path path$iv3;
            PathTreeWalk this_$iv4;
            PathNode pathNode;
            DirectoryEntriesReader entriesReader3;
            ArrayDeque stack3;
            SequenceScope $this$iterator3;
            Path path$iv4;
            PathTreeWalk this_$iv5;
            PathNode pathNode2;
            LinkOption[] linkOptionArr2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c00371 = this;
                    $this$iterator = (SequenceScope) c00371.L$0;
                    stack = new ArrayDeque();
                    entriesReader = new DirectoryEntriesReader(PathTreeWalk.this.getFollowLinks());
                    startNode = new PathNode(PathTreeWalk.this.start, PathTreeWalkKt.keyOf(PathTreeWalk.this.start, PathTreeWalk.this.getLinkOptions()), null);
                    this_$iv = PathTreeWalk.this;
                    path$iv = startNode.getPath();
                    LinkOption[] linkOptions = this_$iv.getLinkOptions();
                    LinkOption[] linkOptionArr3 = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                    if (!Files.isDirectory(path$iv, (LinkOption[]) Arrays.copyOf(linkOptionArr3, linkOptionArr3.length))) {
                        if (Files.exists(path$iv, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                            c00371.L$0 = $this$iterator;
                            c00371.L$1 = stack;
                            c00371.L$2 = entriesReader;
                            c00371.label = 2;
                            if ($this$iterator.yield(path$iv, c00371) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        while (!stack.isEmpty()) {
                        }
                        return Unit.INSTANCE;
                    }
                    if (PathTreeWalkKt.createsCycle(startNode)) {
                        throw new FileSystemLoopException(path$iv.toString());
                    }
                    if (this_$iv.getIncludeDirectories()) {
                        c00371.L$0 = $this$iterator;
                        c00371.L$1 = stack;
                        c00371.L$2 = entriesReader;
                        c00371.L$3 = startNode;
                        c00371.L$4 = this_$iv;
                        c00371.L$5 = path$iv;
                        c00371.label = 1;
                        if ($this$iterator.yield(path$iv, c00371) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        stack2 = stack;
                        this_$iv2 = this_$iv;
                        entriesReader2 = entriesReader;
                        path$iv2 = path$iv;
                        startNode2 = startNode;
                        startNode3 = null;
                        $this$iterator2 = $this$iterator;
                        path$iv = path$iv2;
                        entriesReader = entriesReader2;
                        this_$iv = this_$iv2;
                        stack = stack2;
                        startNode = startNode2;
                        $this$iterator = $this$iterator2;
                    }
                    LinkOption[] linkOptions2 = this_$iv.getLinkOptions();
                    linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                    if (Files.isDirectory(path$iv, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                        startNode.setContentIterator(entriesReader.readEntries(startNode).iterator());
                        stack.addLast(startNode);
                    }
                    while (!stack.isEmpty()) {
                        PathNode topNode = (PathNode) stack.last();
                        Iterator<PathNode> contentIterator = topNode.getContentIterator();
                        Intrinsics.checkNotNull(contentIterator);
                        if (contentIterator.hasNext()) {
                            pathNode2 = contentIterator.next();
                            this_$iv5 = PathTreeWalk.this;
                            SequenceScope $this$yieldIfNeeded$iv = $this$iterator;
                            path$iv4 = pathNode2.getPath();
                            LinkOption[] linkOptions3 = this_$iv5.getLinkOptions();
                            LinkOption[] linkOptionArr4 = (LinkOption[]) Arrays.copyOf(linkOptions3, linkOptions3.length);
                            if (Files.isDirectory(path$iv4, (LinkOption[]) Arrays.copyOf(linkOptionArr4, linkOptionArr4.length))) {
                                if (PathTreeWalkKt.createsCycle(pathNode2)) {
                                    throw new FileSystemLoopException(path$iv4.toString());
                                }
                                if (this_$iv5.getIncludeDirectories()) {
                                    c00371.L$0 = $this$iterator;
                                    c00371.L$1 = stack;
                                    c00371.L$2 = entriesReader;
                                    c00371.L$3 = pathNode2;
                                    c00371.L$4 = this_$iv5;
                                    c00371.L$5 = path$iv4;
                                    c00371.label = 3;
                                    if ($this$yieldIfNeeded$iv.yield(path$iv4, c00371) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    entriesReader3 = entriesReader;
                                    path$iv3 = path$iv4;
                                    $this$iterator3 = $this$iterator;
                                    pathNode = pathNode2;
                                    ArrayDeque arrayDeque = stack;
                                    this_$iv4 = this_$iv5;
                                    this_$iv3 = null;
                                    stack3 = arrayDeque;
                                    pathNode2 = pathNode;
                                    $this$iterator = $this$iterator3;
                                    path$iv4 = path$iv3;
                                    entriesReader = entriesReader3;
                                    this_$iv5 = this_$iv4;
                                    stack = stack3;
                                }
                                LinkOption[] linkOptions4 = this_$iv5.getLinkOptions();
                                linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions4, linkOptions4.length);
                                if (Files.isDirectory(path$iv4, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                                    pathNode2.setContentIterator(entriesReader.readEntries(pathNode2).iterator());
                                    stack.addLast(pathNode2);
                                }
                                while (!stack.isEmpty()) {
                                }
                            } else if (Files.exists(path$iv4, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                                c00371.L$0 = $this$iterator;
                                c00371.L$1 = stack;
                                c00371.L$2 = entriesReader;
                                c00371.L$3 = null;
                                c00371.L$4 = null;
                                c00371.L$5 = null;
                                c00371.label = 4;
                                if ($this$yieldIfNeeded$iv.yield(path$iv4, c00371) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            stack.removeLast();
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    c00371 = this;
                    startNode3 = null;
                    path$iv2 = (Path) c00371.L$5;
                    this_$iv2 = (PathTreeWalk) c00371.L$4;
                    startNode2 = (PathNode) c00371.L$3;
                    entriesReader2 = (DirectoryEntriesReader) c00371.L$2;
                    stack2 = (ArrayDeque) c00371.L$1;
                    $this$iterator2 = (SequenceScope) c00371.L$0;
                    ResultKt.throwOnFailure($result);
                    path$iv = path$iv2;
                    entriesReader = entriesReader2;
                    this_$iv = this_$iv2;
                    stack = stack2;
                    startNode = startNode2;
                    $this$iterator = $this$iterator2;
                    LinkOption[] linkOptions22 = this_$iv.getLinkOptions();
                    linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions22, linkOptions22.length);
                    if (Files.isDirectory(path$iv, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                    }
                    while (!stack.isEmpty()) {
                    }
                    return Unit.INSTANCE;
                case 2:
                    c00371 = this;
                    entriesReader = (DirectoryEntriesReader) c00371.L$2;
                    stack = (ArrayDeque) c00371.L$1;
                    $this$iterator = (SequenceScope) c00371.L$0;
                    ResultKt.throwOnFailure($result);
                    while (!stack.isEmpty()) {
                    }
                    return Unit.INSTANCE;
                case 3:
                    c00371 = this;
                    this_$iv3 = null;
                    path$iv3 = (Path) c00371.L$5;
                    this_$iv4 = (PathTreeWalk) c00371.L$4;
                    pathNode = (PathNode) c00371.L$3;
                    entriesReader3 = (DirectoryEntriesReader) c00371.L$2;
                    stack3 = (ArrayDeque) c00371.L$1;
                    $this$iterator3 = (SequenceScope) c00371.L$0;
                    ResultKt.throwOnFailure($result);
                    pathNode2 = pathNode;
                    $this$iterator = $this$iterator3;
                    path$iv4 = path$iv3;
                    entriesReader = entriesReader3;
                    this_$iv5 = this_$iv4;
                    stack = stack3;
                    LinkOption[] linkOptions42 = this_$iv5.getLinkOptions();
                    linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions42, linkOptions42.length);
                    if (Files.isDirectory(path$iv4, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                    }
                    while (!stack.isEmpty()) {
                    }
                    return Unit.INSTANCE;
                case 4:
                    c00371 = this;
                    entriesReader = (DirectoryEntriesReader) c00371.L$2;
                    stack = (ArrayDeque) c00371.L$1;
                    $this$iterator = (SequenceScope) c00371.L$0;
                    ResultKt.throwOnFailure($result);
                    while (!stack.isEmpty()) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final Iterator<Path> dfsIterator() {
        return SequencesKt.iterator(new C00371(null));
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathTreeWalk$bfsIterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: PathTreeWalk.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {184, 190}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "queue", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = PathTreeWalk.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x010c  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x010a -> B:9:0x008b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x010c -> B:9:0x008b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) throws Throwable {
            AnonymousClass1 anonymousClass1;
            SequenceScope $this$iterator;
            ArrayDeque queue;
            DirectoryEntriesReader entriesReader;
            PathNode pathNode;
            Path path$iv;
            PathTreeWalk this_$iv;
            PathNode pathNode2;
            DirectoryEntriesReader entriesReader2;
            ArrayDeque queue2;
            SequenceScope $this$iterator2;
            Path path$iv2;
            PathTreeWalk this_$iv2;
            PathNode pathNode3;
            LinkOption[] linkOptionArr;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    SequenceScope $this$iterator3 = (SequenceScope) anonymousClass1.L$0;
                    ArrayDeque queue3 = new ArrayDeque();
                    DirectoryEntriesReader entriesReader3 = new DirectoryEntriesReader(PathTreeWalk.this.getFollowLinks());
                    queue3.addLast(new PathNode(PathTreeWalk.this.start, PathTreeWalkKt.keyOf(PathTreeWalk.this.start, PathTreeWalk.this.getLinkOptions()), null));
                    $this$iterator = $this$iterator3;
                    queue = queue3;
                    entriesReader = entriesReader3;
                    while (!queue.isEmpty()) {
                        pathNode3 = (PathNode) queue.removeFirst();
                        this_$iv2 = PathTreeWalk.this;
                        SequenceScope $this$yieldIfNeeded$iv = $this$iterator;
                        path$iv2 = pathNode3.getPath();
                        LinkOption[] linkOptions = this_$iv2.getLinkOptions();
                        LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
                        if (Files.isDirectory(path$iv2, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                            if (!PathTreeWalkKt.createsCycle(pathNode3)) {
                                if (this_$iv2.getIncludeDirectories()) {
                                    anonymousClass1.L$0 = $this$iterator;
                                    anonymousClass1.L$1 = queue;
                                    anonymousClass1.L$2 = entriesReader;
                                    anonymousClass1.L$3 = pathNode3;
                                    anonymousClass1.L$4 = this_$iv2;
                                    anonymousClass1.L$5 = path$iv2;
                                    anonymousClass1.label = 1;
                                    if ($this$yieldIfNeeded$iv.yield(path$iv2, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    entriesReader2 = entriesReader;
                                    $this$iterator2 = $this$iterator;
                                    path$iv = path$iv2;
                                    pathNode2 = pathNode3;
                                    pathNode = null;
                                    queue2 = queue;
                                    this_$iv = this_$iv2;
                                    path$iv2 = path$iv;
                                    pathNode3 = pathNode2;
                                    entriesReader = entriesReader2;
                                    $this$iterator = $this$iterator2;
                                    ArrayDeque arrayDeque = queue2;
                                    this_$iv2 = this_$iv;
                                    queue = arrayDeque;
                                }
                                LinkOption[] linkOptions2 = this_$iv2.getLinkOptions();
                                linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions2, linkOptions2.length);
                                if (Files.isDirectory(path$iv2, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                                    queue.addAll(entriesReader.readEntries(pathNode3));
                                }
                                while (!queue.isEmpty()) {
                                }
                            } else {
                                throw new FileSystemLoopException(path$iv2.toString());
                            }
                        } else if (Files.exists(path$iv2, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                            anonymousClass1.L$0 = $this$iterator;
                            anonymousClass1.L$1 = queue;
                            anonymousClass1.L$2 = entriesReader;
                            anonymousClass1.L$3 = null;
                            anonymousClass1.L$4 = null;
                            anonymousClass1.L$5 = null;
                            anonymousClass1.label = 2;
                            if ($this$yieldIfNeeded$iv.yield(path$iv2, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    anonymousClass1 = this;
                    pathNode = null;
                    path$iv = (Path) anonymousClass1.L$5;
                    this_$iv = (PathTreeWalk) anonymousClass1.L$4;
                    pathNode2 = (PathNode) anonymousClass1.L$3;
                    entriesReader2 = (DirectoryEntriesReader) anonymousClass1.L$2;
                    queue2 = (ArrayDeque) anonymousClass1.L$1;
                    $this$iterator2 = (SequenceScope) anonymousClass1.L$0;
                    ResultKt.throwOnFailure($result);
                    path$iv2 = path$iv;
                    pathNode3 = pathNode2;
                    entriesReader = entriesReader2;
                    $this$iterator = $this$iterator2;
                    ArrayDeque arrayDeque2 = queue2;
                    this_$iv2 = this_$iv;
                    queue = arrayDeque2;
                    LinkOption[] linkOptions22 = this_$iv2.getLinkOptions();
                    linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions22, linkOptions22.length);
                    if (Files.isDirectory(path$iv2, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                    }
                    while (!queue.isEmpty()) {
                    }
                    return Unit.INSTANCE;
                case 2:
                    anonymousClass1 = this;
                    entriesReader = (DirectoryEntriesReader) anonymousClass1.L$2;
                    queue = (ArrayDeque) anonymousClass1.L$1;
                    $this$iterator = (SequenceScope) anonymousClass1.L$0;
                    ResultKt.throwOnFailure($result);
                    while (!queue.isEmpty()) {
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final Iterator<Path> bfsIterator() {
        return SequencesKt.iterator(new AnonymousClass1(null));
    }
}
