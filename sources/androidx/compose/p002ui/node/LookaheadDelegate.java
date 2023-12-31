package androidx.compose.p002ui.node;

import androidx.compose.p002ui.graphics.GraphicsLayerScope;
import androidx.compose.p002ui.layout.AlignmentLine;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.p002ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.p002ui.layout.LookaheadScope;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.p002ui.unit.IntOffset;
import androidx.compose.p002ui.unit.IntOffsetKt;
import androidx.compose.p002ui.unit.IntSize;
import androidx.compose.p002ui.unit.IntSizeKt;
import androidx.compose.p002ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LookaheadDelegate.kt */
@Metadata(m41d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u0013H\u0000¢\u0006\u0002\bKJ\u0010\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u0014H\u0016J\u0010\u0010N\u001a\u00020\u00142\u0006\u0010O\u001a\u00020\u0014H\u0016J\u0010\u0010P\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u0014H\u0016J\u0010\u0010Q\u001a\u00020\u00142\u0006\u0010O\u001a\u00020\u0014H\u0016J/\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\t0WH\u0086\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ@\u0010Z\u001a\u00020[2\u0006\u0010B\u001a\u00020C2\u0006\u0010\\\u001a\u00020!2\u0019\u0010]\u001a\u0015\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020[\u0018\u00010^¢\u0006\u0002\b`H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010bJ\b\u0010c\u001a\u00020[H\u0014J \u0010d\u001a\u00020C2\u0006\u0010e\u001a\u00020\u0000H\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bf\u0010gJ\r\u0010h\u001a\u00020[H\u0010¢\u0006\u0002\biR\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u0014\u0010&\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0011\u00102\u001a\u000203¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u00020\t8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001c\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010<\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0019R\u0016\u0010>\u001a\u0004\u0018\u00010?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR%\u0010B\u001a\u00020CX\u0096\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010H\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G\u0082\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006j"}, m40d2 = {"Landroidx/compose/ui/node/LookaheadDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "(Landroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/layout/LookaheadScope;)V", "result", "Landroidx/compose/ui/layout/MeasureResult;", "_measureResult", "set_measureResult", "(Landroidx/compose/ui/layout/MeasureResult;)V", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "cachedAlignmentLinesMap", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getCachedAlignmentLinesMap", "()Ljava/util/Map;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "lookaheadLayoutCoordinates", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "getLookaheadLayoutCoordinates", "()Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "getLookaheadScope", "()Landroidx/compose/ui/layout/LookaheadScope;", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "oldAlignmentLines", "parent", "getParent", "parentData", "", "getParentData", "()Ljava/lang/Object;", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "setPosition--gyyYBs", "(J)V", "J", "getCachedAlignmentLine", "alignmentLine", "getCachedAlignmentLine$ui_release", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "block", "Lkotlin/Function0;", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "", "zIndex", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeChildren", "positionIn", "ancestor", "positionIn-Bjo55l4$ui_release", "(Landroidx/compose/ui/node/LookaheadDelegate;)J", "replace", "replace$ui_release", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.node.LookaheadDelegate */
/* loaded from: classes.dex */
public abstract class LookaheadDelegate extends LookaheadCapablePlaceable implements Measurable {
    private MeasureResult _measureResult;
    private final Map<AlignmentLine, Integer> cachedAlignmentLinesMap;
    private final NodeCoordinator coordinator;
    private final LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates;
    private final LookaheadScope lookaheadScope;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position;

    /* renamed from: access$setMeasurementConstraints-BRTryo0 */
    public static final /* synthetic */ void m4528access$setMeasurementConstraintsBRTryo0(LookaheadDelegate lookaheadDelegate, long j) {
        lookaheadDelegate.m4423setMeasurementConstraintsBRTryo0(j);
    }

    public static final /* synthetic */ void access$set_measureResult(LookaheadDelegate lookaheadDelegate, MeasureResult measureResult) {
        lookaheadDelegate.set_measureResult(measureResult);
    }

    public final NodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    public final LookaheadScope getLookaheadScope() {
        return this.lookaheadScope;
    }

    public LookaheadDelegate(NodeCoordinator coordinator, LookaheadScope lookaheadScope) {
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        Intrinsics.checkNotNullParameter(lookaheadScope, "lookaheadScope");
        this.coordinator = coordinator;
        this.lookaheadScope = lookaheadScope;
        this.position = IntOffset.Companion.m5479getZeronOccac();
        this.lookaheadLayoutCoordinates = new LookaheadLayoutCoordinatesImpl(this);
        this.cachedAlignmentLinesMap = new LinkedHashMap();
    }

    @Override // androidx.compose.p002ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        return wrapped$ui_release != null ? wrapped$ui_release.getLookaheadDelegate$ui_release() : null;
    }

    @Override // androidx.compose.p002ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.p002ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac */
    public long mo4527getPositionnOccac() {
        return this.position;
    }

    /* renamed from: setPosition--gyyYBs */
    public void m4531setPositiongyyYBs(long j) {
        this.position = j;
    }

    @Override // androidx.compose.p002ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("LookaheadDelegate has not been measured yet when measureResult is requested.".toString());
    }

    @Override // androidx.compose.p002ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    @Override // androidx.compose.p002ui.unit.Density
    public float getDensity() {
        return this.coordinator.getDensity();
    }

    @Override // androidx.compose.p002ui.unit.Density
    public float getFontScale() {
        return this.coordinator.getFontScale();
    }

    @Override // androidx.compose.p002ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        NodeCoordinator wrappedBy$ui_release = this.coordinator.getWrappedBy$ui_release();
        return wrappedBy$ui_release != null ? wrappedBy$ui_release.getLookaheadDelegate$ui_release() : null;
    }

    @Override // androidx.compose.p002ui.node.LookaheadCapablePlaceable, androidx.compose.p002ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.coordinator.getLayoutNode();
    }

    @Override // androidx.compose.p002ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    public final LookaheadLayoutCoordinatesImpl getLookaheadLayoutCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    @Override // androidx.compose.p002ui.node.LookaheadCapablePlaceable
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = this.coordinator.getLayoutNode().getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
        Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
        return lookaheadAlignmentLinesOwner$ui_release;
    }

    public final void set_measureResult(MeasureResult measureResult) {
        Unit unit;
        if (measureResult != null) {
            m4422setMeasuredSizeozmzZPI(IntSizeKt.IntSize(measureResult.getWidth(), measureResult.getHeight()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            m4422setMeasuredSizeozmzZPI(IntSize.Companion.m5516getZeroYbymL2g());
        }
        if (!Intrinsics.areEqual(this._measureResult, measureResult) && measureResult != null) {
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || (!measureResult.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual(measureResult.getAlignmentLines(), this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                LinkedHashMap linkedHashMap = this.oldAlignmentLines;
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap();
                    this.oldAlignmentLines = linkedHashMap;
                }
                linkedHashMap.clear();
                linkedHashMap.putAll(measureResult.getAlignmentLines());
            }
        }
        this._measureResult = measureResult;
    }

    public final Map<AlignmentLine, Integer> getCachedAlignmentLinesMap() {
        return this.cachedAlignmentLinesMap;
    }

    public final int getCachedAlignmentLine$ui_release(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        Integer num = this.cachedAlignmentLinesMap.get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.p002ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        mo4377placeAtf8xVGno(mo4527getPositionnOccac(), 0.0f, null);
    }

    @Override // androidx.compose.p002ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public final void mo4377placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        if (!IntOffset.m5468equalsimpl0(mo4527getPositionnOccac(), j)) {
            m4531setPositiongyyYBs(j);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
            if (lookaheadPassDelegate$ui_release != null) {
                lookaheadPassDelegate$ui_release.notifyChildrenUsingCoordinatesWhilePlacing();
            }
            invalidateAlignmentLinesFromPositionChange(this.coordinator);
        }
        if (isShallowPlacing$ui_release()) {
            return;
        }
        placeChildren();
    }

    protected void placeChildren() {
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        int width = getMeasureResult$ui_release().getWidth();
        LayoutDirection layoutDirection = this.coordinator.getLayoutDirection();
        LayoutCoordinates layoutCoordinates = Placeable.PlacementScope._coordinates;
        int parentWidth = Placeable.PlacementScope.Companion.getParentWidth();
        LayoutDirection parentLayoutDirection = Placeable.PlacementScope.Companion.getParentLayoutDirection();
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = Placeable.PlacementScope.layoutDelegate;
        Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = width;
        Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
        LookaheadDelegate lookaheadDelegate = this;
        boolean configureForPlacingForAlignment = companion.configureForPlacingForAlignment(lookaheadDelegate);
        getMeasureResult$ui_release().placeChildren();
        lookaheadDelegate.setPlacingForAlignment$ui_release(configureForPlacingForAlignment);
        Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentWidth = parentWidth;
        Placeable.PlacementScope.Companion companion5 = Placeable.PlacementScope.Companion;
        Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection;
        Placeable.PlacementScope._coordinates = layoutCoordinates;
        Placeable.PlacementScope.layoutDelegate = layoutNodeLayoutDelegate;
    }

    /* renamed from: performingMeasure-K40F9xA */
    public final Placeable m4529performingMeasureK40F9xA(long j, Functions<? extends MeasureResult> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        m4423setMeasurementConstraintsBRTryo0(j);
        set_measureResult(block.invoke());
        return this;
    }

    @Override // androidx.compose.p002ui.layout.Measured, androidx.compose.p002ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        return this.coordinator.getParentData();
    }

    public int minIntrinsicWidth(int i) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.minIntrinsicWidth(i);
    }

    public int maxIntrinsicWidth(int i) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.maxIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(int i) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.minIntrinsicHeight(i);
    }

    public int maxIntrinsicHeight(int i) {
        NodeCoordinator wrapped$ui_release = this.coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        LookaheadDelegate lookaheadDelegate$ui_release = wrapped$ui_release.getLookaheadDelegate$ui_release();
        Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
        return lookaheadDelegate$ui_release.maxIntrinsicHeight(i);
    }

    /* renamed from: positionIn-Bjo55l4$ui_release */
    public final long m4530positionInBjo55l4$ui_release(LookaheadDelegate ancestor) {
        Intrinsics.checkNotNullParameter(ancestor, "ancestor");
        long m5479getZeronOccac = IntOffset.Companion.m5479getZeronOccac();
        LookaheadDelegate lookaheadDelegate = this;
        while (!Intrinsics.areEqual(lookaheadDelegate, ancestor)) {
            long mo4527getPositionnOccac = lookaheadDelegate.mo4527getPositionnOccac();
            m5479getZeronOccac = IntOffsetKt.IntOffset(IntOffset.m5469getXimpl(m5479getZeronOccac) + IntOffset.m5469getXimpl(mo4527getPositionnOccac), IntOffset.m5470getYimpl(m5479getZeronOccac) + IntOffset.m5470getYimpl(mo4527getPositionnOccac));
            NodeCoordinator wrappedBy$ui_release = lookaheadDelegate.coordinator.getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            lookaheadDelegate = wrappedBy$ui_release.getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate);
        }
        return m5479getZeronOccac;
    }
}
