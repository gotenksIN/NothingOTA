package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.unit.IntSize;
import com.nothing.OfflineOTAUpgradeApp.services.PrepareUpdateService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsNode.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010D\u001a\u00020E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00000GH\u0002J6\u0010H\u001a\u00020\u00002\b\u0010I\u001a\u0004\u0018\u00010J2\u0017\u0010K\u001a\u0013\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020E0L¢\u0006\u0002\bNH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\bOJ\u000f\u0010P\u001a\u0004\u0018\u00010QH\u0000¢\u0006\u0002\bRJ\u001e\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u000e\b\u0002\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00000GH\u0002J\u000e\u0010U\u001a\u00020\u00192\u0006\u0010V\u001a\u00020WJ\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u0006\u0010X\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0010\u0010Z\u001a\u00020E2\u0006\u0010[\u001a\u00020\u0014H\u0002J\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\b\b\u0002\u0010Y\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\\R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001eR\u0011\u0010\"\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0014\u0010#\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001eR\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u00101\u001a\u0002028Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u0002028Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b6\u00104R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00000\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0012R\u0013\u00109\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b?\u00104R\u0011\u0010@\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\bA\u0010\fR\u0014\u0010B\u001a\u00020\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006]"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "", "outerSemanticsNode", "Landroidx/compose/ui/node/SemanticsModifierNode;", "mergingEnabled", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/SemanticsModifierNode;ZLandroidx/compose/ui/node/LayoutNode;)V", "boundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "getBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "boundsInWindow", "getBoundsInWindow", "children", "", "getChildren", "()Ljava/util/List;", PrepareUpdateService.EXTRA_PARAM_CONFIG, "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "fakeNodeParent", "id", "", "getId", "()I", "isFake", "isFake$ui_release", "()Z", "setFake$ui_release", "(Z)V", "isMergingSemanticsOfDescendants", "isRoot", "isTransparent", "isTransparent$ui_release", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "getMergingEnabled", "getOuterSemanticsNode$ui_release", "()Landroidx/compose/ui/node/SemanticsModifierNode;", "parent", "getParent", "()Landroidx/compose/ui/semantics/SemanticsNode;", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "()J", "positionInWindow", "getPositionInWindow-F1C5BW0", "replacedChildren", "getReplacedChildren$ui_release", "root", "Landroidx/compose/ui/node/RootForTest;", "getRoot", "()Landroidx/compose/ui/node/RootForTest;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "touchBoundsInRoot", "getTouchBoundsInRoot", "unmergedConfig", "getUnmergedConfig$ui_release", "emitFakeNodes", "", "unmergedChildren", "", "fakeSemanticsNode", "role", "Landroidx/compose/ui/semantics/Role;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "fakeSemanticsNode-ypyhhiA", "findCoordinatorToGetBounds", "Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds$ui_release", "findOneLayerOfMergingSemanticsNodes", "list", "getAlignmentLinePosition", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "includeReplacedSemantics", "includeFakeNodes", "mergeConfig", "mergedConfig", "unmergedChildren$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsNode {
    public static final int $stable = 8;
    private SemanticsNode fakeNodeParent;
    private final int id;
    private boolean isFake;
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;
    private final SemanticsModifierNode outerSemanticsNode;
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(SemanticsModifierNode outerSemanticsNode, boolean z, LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(outerSemanticsNode, "outerSemanticsNode");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.outerSemanticsNode = outerSemanticsNode;
        this.mergingEnabled = z;
        this.layoutNode = layoutNode;
        this.unmergedConfig = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemanticsNode);
        this.id = layoutNode.getSemanticsId();
    }

    public final SemanticsModifierNode getOuterSemanticsNode$ui_release() {
        return this.outerSemanticsNode;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    public /* synthetic */ SemanticsNode(SemanticsModifierNode semanticsModifierNode, boolean z, LayoutNode layoutNode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(semanticsModifierNode, z, (i & 4) != 0 ? DelegatableNodeKt.requireLayoutNode(semanticsModifierNode) : layoutNode);
    }

    public final LayoutNode getLayoutNode$ui_release() {
        return this.layoutNode;
    }

    public final boolean isFake$ui_release() {
        return this.isFake;
    }

    public final void setFake$ui_release(boolean z) {
        this.isFake = z;
    }

    public final SemanticsConfiguration getUnmergedConfig$ui_release() {
        return this.unmergedConfig;
    }

    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    public final RootForTest getRoot() {
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release.getRootForTest();
        }
        return null;
    }

    public final int getId() {
        return this.id;
    }

    public final Rect getTouchBoundsInRoot() {
        SemanticsModifierNode semanticsModifierNode;
        if (this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            semanticsModifierNode = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
            if (semanticsModifierNode == null) {
                semanticsModifierNode = this.outerSemanticsNode;
            }
        } else {
            semanticsModifierNode = this.outerSemanticsNode;
        }
        return SemanticsModifierNodeKt.touchBoundsInRoot(semanticsModifierNode);
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m4441getSizeYbymL2g() {
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        return findCoordinatorToGetBounds$ui_release != null ? findCoordinatorToGetBounds$ui_release.mo4080getSizeYbymL2g() : IntSize.Companion.m5215getZeroYbymL2g();
    }

    public final Rect getBoundsInRoot() {
        Rect boundsInRoot;
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            if (!findCoordinatorToGetBounds$ui_release.isAttached()) {
                findCoordinatorToGetBounds$ui_release = null;
            }
            if (findCoordinatorToGetBounds$ui_release != null && (boundsInRoot = LayoutCoordinatesKt.boundsInRoot(findCoordinatorToGetBounds$ui_release)) != null) {
                return boundsInRoot;
            }
        }
        return Rect.Companion.getZero();
    }

    /* renamed from: getPositionInRoot-F1C5BW0  reason: not valid java name */
    public final long m4439getPositionInRootF1C5BW0() {
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            if (!findCoordinatorToGetBounds$ui_release.isAttached()) {
                findCoordinatorToGetBounds$ui_release = null;
            }
            if (findCoordinatorToGetBounds$ui_release != null) {
                return LayoutCoordinatesKt.positionInRoot(findCoordinatorToGetBounds$ui_release);
            }
        }
        return Offset.Companion.m2334getZeroF1C5BW0();
    }

    public final Rect getBoundsInWindow() {
        Rect boundsInWindow;
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            if (!findCoordinatorToGetBounds$ui_release.isAttached()) {
                findCoordinatorToGetBounds$ui_release = null;
            }
            if (findCoordinatorToGetBounds$ui_release != null && (boundsInWindow = LayoutCoordinatesKt.boundsInWindow(findCoordinatorToGetBounds$ui_release)) != null) {
                return boundsInWindow;
            }
        }
        return Rect.Companion.getZero();
    }

    /* renamed from: getPositionInWindow-F1C5BW0  reason: not valid java name */
    public final long m4440getPositionInWindowF1C5BW0() {
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            if (!findCoordinatorToGetBounds$ui_release.isAttached()) {
                findCoordinatorToGetBounds$ui_release = null;
            }
            if (findCoordinatorToGetBounds$ui_release != null) {
                return LayoutCoordinatesKt.positionInWindow(findCoordinatorToGetBounds$ui_release);
            }
        }
        return Offset.Companion.m2334getZeroF1C5BW0();
    }

    public final boolean isTransparent$ui_release() {
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            return findCoordinatorToGetBounds$ui_release.isTransparent();
        }
        return false;
    }

    public final int getAlignmentLinePosition(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            return findCoordinatorToGetBounds$ui_release.get(alignmentLine);
        }
        return Integer.MIN_VALUE;
    }

    public final SemanticsConfiguration getConfig() {
        if (isMergingSemanticsOfDescendants()) {
            SemanticsConfiguration copy = this.unmergedConfig.copy();
            mergeConfig(copy);
            return copy;
        }
        return this.unmergedConfig;
    }

    private final void mergeConfig(SemanticsConfiguration semanticsConfiguration) {
        if (this.unmergedConfig.isClearingSemantics()) {
            return;
        }
        List unmergedChildren$ui_release$default = unmergedChildren$ui_release$default(this, false, 1, null);
        int size = unmergedChildren$ui_release$default.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode = (SemanticsNode) unmergedChildren$ui_release$default.get(i);
            if (!semanticsNode.isMergingSemanticsOfDescendants()) {
                semanticsConfiguration.mergeChild$ui_release(semanticsNode.unmergedConfig);
                semanticsNode.mergeConfig(semanticsConfiguration);
            }
        }
    }

    private final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.isMergingSemanticsOfDescendants();
    }

    public static /* synthetic */ List unmergedChildren$ui_release$default(SemanticsNode semanticsNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return semanticsNode.unmergedChildren$ui_release(z);
    }

    public final List<SemanticsNode> unmergedChildren$ui_release(boolean z) {
        if (this.isFake) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        List findOneLayerOfSemanticsWrappers$default = SemanticsNodeKt.findOneLayerOfSemanticsWrappers$default(this.layoutNode, null, 1, null);
        int size = findOneLayerOfSemanticsWrappers$default.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new SemanticsNode((SemanticsModifierNode) findOneLayerOfSemanticsWrappers$default.get(i), this.mergingEnabled, null, 4, null));
        }
        if (z) {
            emitFakeNodes(arrayList);
        }
        return arrayList;
    }

    public final List<SemanticsNode> getChildren() {
        return getChildren(!this.mergingEnabled, false);
    }

    public final List<SemanticsNode> getReplacedChildren$ui_release() {
        return getChildren(false, true);
    }

    private final List<SemanticsNode> getChildren(boolean z, boolean z2) {
        if (!z && this.unmergedConfig.isClearingSemantics()) {
            return CollectionsKt.emptyList();
        }
        if (isMergingSemanticsOfDescendants()) {
            return findOneLayerOfMergingSemanticsNodes$default(this, null, 1, null);
        }
        return unmergedChildren$ui_release(z2);
    }

    public final boolean isRoot() {
        return getParent() == null;
    }

    public final SemanticsNode getParent() {
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        LayoutNode findClosestParentNode = this.mergingEnabled ? SemanticsNodeKt.findClosestParentNode(this.layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$parent$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode it) {
                SemanticsConfiguration collapsedSemanticsConfiguration;
                Intrinsics.checkNotNullParameter(it, "it");
                SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(it);
                boolean z = false;
                if (outerSemantics != null && (collapsedSemanticsConfiguration = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemantics)) != null && collapsedSemanticsConfiguration.isMergingSemanticsOfDescendants()) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }) : null;
        if (findClosestParentNode == null) {
            findClosestParentNode = SemanticsNodeKt.findClosestParentNode(this.layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$parent$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(SemanticsNodeKt.getOuterSemantics(it) != null);
                }
            });
        }
        SemanticsModifierNode outerSemantics = findClosestParentNode != null ? SemanticsNodeKt.getOuterSemantics(findClosestParentNode) : null;
        if (outerSemantics == null) {
            return null;
        }
        return new SemanticsNode(outerSemantics, this.mergingEnabled, null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List findOneLayerOfMergingSemanticsNodes$default(SemanticsNode semanticsNode, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return semanticsNode.findOneLayerOfMergingSemanticsNodes(list);
    }

    private final List<SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<SemanticsNode> list) {
        List unmergedChildren$ui_release$default = unmergedChildren$ui_release$default(this, false, 1, null);
        int size = unmergedChildren$ui_release$default.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode = (SemanticsNode) unmergedChildren$ui_release$default.get(i);
            if (semanticsNode.isMergingSemanticsOfDescendants()) {
                list.add(semanticsNode);
            } else if (!semanticsNode.unmergedConfig.isClearingSemantics()) {
                semanticsNode.findOneLayerOfMergingSemanticsNodes(list);
            }
        }
        return list;
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui_release() {
        if (this.isFake) {
            SemanticsNode parent = getParent();
            if (parent != null) {
                return parent.findCoordinatorToGetBounds$ui_release();
            }
            return null;
        }
        SemanticsModifierNode outerMergingSemantics = this.unmergedConfig.isMergingSemanticsOfDescendants() ? SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode) : null;
        if (outerMergingSemantics == null) {
            outerMergingSemantics = this.outerSemanticsNode;
        }
        return DelegatableNodeKt.m4181requireCoordinator64DMado(outerMergingSemantics, NodeKind.m4277constructorimpl(8));
    }

    private final void emitFakeNodes(List<SemanticsNode> list) {
        final Role role;
        role = SemanticsNodeKt.getRole(this);
        if (role != null && this.unmergedConfig.isMergingSemanticsOfDescendants() && (!list.isEmpty())) {
            list.add(m4438fakeSemanticsNodeypyhhiA(role, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver fakeSemanticsNode) {
                    Intrinsics.checkNotNullParameter(fakeSemanticsNode, "$this$fakeSemanticsNode");
                    SemanticsPropertiesKt.m4445setRolekuIjeqM(fakeSemanticsNode, Role.this.m4430unboximpl());
                }
            }));
        }
        if (this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getContentDescription()) && (!list.isEmpty()) && this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            List list2 = (List) SemanticsConfigurationKt.getOrNull(this.unmergedConfig, SemanticsProperties.INSTANCE.getContentDescription());
            final String str = list2 != null ? (String) CollectionsKt.firstOrNull((List<? extends Object>) list2) : null;
            if (str != null) {
                list.add(0, m4438fakeSemanticsNodeypyhhiA(null, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver fakeSemanticsNode) {
                        Intrinsics.checkNotNullParameter(fakeSemanticsNode, "$this$fakeSemanticsNode");
                        SemanticsPropertiesKt.setContentDescription(fakeSemanticsNode, str);
                    }
                }));
            }
        }
    }

    /* renamed from: fakeSemanticsNode-ypyhhiA  reason: not valid java name */
    private final SemanticsNode m4438fakeSemanticsNodeypyhhiA(Role role, Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        SemanticsNode semanticsNode = new SemanticsNode(new SemanticsNode$fakeSemanticsNode$fakeNode$1(function1), false, new LayoutNode(true, role != null ? SemanticsNodeKt.roleFakeNodeId(this) : SemanticsNodeKt.contentDescriptionFakeNodeId(this)));
        semanticsNode.isFake = true;
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }
}
