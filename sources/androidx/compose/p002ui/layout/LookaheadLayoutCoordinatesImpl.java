package androidx.compose.p002ui.layout;

import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.OffsetKt;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.node.LookaheadDelegate;
import androidx.compose.p002ui.node.NodeCoordinator;
import androidx.compose.p002ui.unit.IntOffset;
import androidx.compose.p002ui.unit.IntOffsetKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: LookaheadLayoutCoordinates.kt */
@Metadata(m41d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0096\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\nH\u0016J%\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J%\u0010)\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001d\u00100\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010/J%\u00102\u001a\u0002032\u0006\u0010\"\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001d\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010/R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, m40d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isAttached", "", "()Z", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "relativeToSource", "localLookaheadPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;J)J", "localPositionOf", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToWindow", "localToWindow-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl */
/* loaded from: classes.dex */
public final class LookaheadLayoutCoordinatesImpl implements LookaheadLayoutCoordinates {
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinatesImpl(LookaheadDelegate lookaheadDelegate) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate;
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    @Override // androidx.compose.p002ui.layout.LookaheadLayoutCoordinates
    /* renamed from: localLookaheadPositionOf-R5De75A */
    public long mo4391localLookaheadPositionOfR5De75A(LookaheadLayoutCoordinates sourceCoordinates, long j) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        LookaheadDelegate lookaheadDelegate = ((LookaheadLayoutCoordinatesImpl) sourceCoordinates).lookaheadDelegate;
        LookaheadDelegate lookaheadDelegate$ui_release = getCoordinator().findCommonAncestor$ui_release(lookaheadDelegate.getCoordinator()).getLookaheadDelegate$ui_release();
        if (lookaheadDelegate$ui_release != null) {
            long m4530positionInBjo55l4$ui_release = lookaheadDelegate.m4530positionInBjo55l4$ui_release(lookaheadDelegate$ui_release);
            long IntOffset = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m2619getXimpl(j)), MathKt.roundToInt(Offset.m2620getYimpl(j)));
            long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m4530positionInBjo55l4$ui_release) + IntOffset.m5469getXimpl(IntOffset), IntOffset.m5470getYimpl(m4530positionInBjo55l4$ui_release) + IntOffset.m5470getYimpl(IntOffset));
            long m4530positionInBjo55l4$ui_release2 = this.lookaheadDelegate.m4530positionInBjo55l4$ui_release(lookaheadDelegate$ui_release);
            long IntOffset3 = IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(IntOffset2) - IntOffset.m5469getXimpl(m4530positionInBjo55l4$ui_release2), IntOffset.m5470getYimpl(IntOffset2) - IntOffset.m5470getYimpl(m4530positionInBjo55l4$ui_release2));
            return OffsetKt.Offset(IntOffset.m5469getXimpl(IntOffset3), IntOffset.m5470getYimpl(IntOffset3));
        }
        LookaheadDelegate access$getRootLookaheadDelegate = LookaheadLayoutCoordinatesKt.access$getRootLookaheadDelegate(lookaheadDelegate);
        long m4530positionInBjo55l4$ui_release3 = lookaheadDelegate.m4530positionInBjo55l4$ui_release(access$getRootLookaheadDelegate);
        long mo4527getPositionnOccac = access$getRootLookaheadDelegate.mo4527getPositionnOccac();
        long IntOffset4 = IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m4530positionInBjo55l4$ui_release3) + IntOffset.m5469getXimpl(mo4527getPositionnOccac), IntOffset.m5470getYimpl(m4530positionInBjo55l4$ui_release3) + IntOffset.m5470getYimpl(mo4527getPositionnOccac));
        long IntOffset5 = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m2619getXimpl(j)), MathKt.roundToInt(Offset.m2620getYimpl(j)));
        long IntOffset6 = IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(IntOffset4) + IntOffset.m5469getXimpl(IntOffset5), IntOffset.m5470getYimpl(IntOffset4) + IntOffset.m5470getYimpl(IntOffset5));
        LookaheadDelegate lookaheadDelegate2 = this.lookaheadDelegate;
        long m4530positionInBjo55l4$ui_release4 = lookaheadDelegate2.m4530positionInBjo55l4$ui_release(LookaheadLayoutCoordinatesKt.access$getRootLookaheadDelegate(lookaheadDelegate2));
        long mo4527getPositionnOccac2 = LookaheadLayoutCoordinatesKt.access$getRootLookaheadDelegate(lookaheadDelegate2).mo4527getPositionnOccac();
        long IntOffset7 = IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m4530positionInBjo55l4$ui_release4) + IntOffset.m5469getXimpl(mo4527getPositionnOccac2), IntOffset.m5470getYimpl(m4530positionInBjo55l4$ui_release4) + IntOffset.m5470getYimpl(mo4527getPositionnOccac2));
        long IntOffset8 = IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(IntOffset6) - IntOffset.m5469getXimpl(IntOffset7), IntOffset.m5470getYimpl(IntOffset6) - IntOffset.m5470getYimpl(IntOffset7));
        NodeCoordinator wrappedBy$ui_release = LookaheadLayoutCoordinatesKt.access$getRootLookaheadDelegate(this.lookaheadDelegate).getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release);
        NodeCoordinator wrappedBy$ui_release2 = access$getRootLookaheadDelegate.getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release2);
        return wrappedBy$ui_release.mo4382localPositionOfR5De75A(wrappedBy$ui_release2, OffsetKt.Offset(IntOffset.m5469getXimpl(IntOffset8), IntOffset.m5470getYimpl(IntOffset8)));
    }

    @Override // androidx.compose.p002ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public long mo4381getSizeYbymL2g() {
        return getCoordinator().mo4381getSizeYbymL2g();
    }

    @Override // androidx.compose.p002ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    @Override // androidx.compose.p002ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentLayoutCoordinates() {
        return getCoordinator().getParentLayoutCoordinates();
    }

    @Override // androidx.compose.p002ui.layout.LayoutCoordinates
    public LayoutCoordinates getParentCoordinates() {
        return getCoordinator().getParentCoordinates();
    }

    @Override // androidx.compose.p002ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    @Override // androidx.compose.p002ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo4386windowToLocalMKHz9U(long j) {
        return getCoordinator().mo4386windowToLocalMKHz9U(j);
    }

    @Override // androidx.compose.p002ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo4384localToWindowMKHz9U(long j) {
        return getCoordinator().mo4384localToWindowMKHz9U(j);
    }

    @Override // androidx.compose.p002ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo4383localToRootMKHz9U(long j) {
        return getCoordinator().mo4383localToRootMKHz9U(j);
    }

    @Override // androidx.compose.p002ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo4382localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long j) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        return getCoordinator().mo4382localPositionOfR5De75A(sourceCoordinates, j);
    }

    @Override // androidx.compose.p002ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean z) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        return getCoordinator().localBoundingBoxOf(sourceCoordinates, z);
    }

    @Override // androidx.compose.p002ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo4385transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        getCoordinator().mo4385transformFromEL8BTi8(sourceCoordinates, matrix);
    }

    @Override // androidx.compose.p002ui.layout.LayoutCoordinates
    public int get(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return getCoordinator().get(alignmentLine);
    }
}
