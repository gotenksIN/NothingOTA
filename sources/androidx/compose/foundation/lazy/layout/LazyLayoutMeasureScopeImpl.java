package androidx.compose.foundation.lazy.layout;

import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.layout.AlignmentLine;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.layout.SubcomposeMeasureScope;
import androidx.compose.p002ui.unit.DpRect;
import androidx.compose.p002ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutMeasureScope.kt */
@Metadata(m41d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007JH\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 ¢\u0006\u0002\b#H\u0096\u0001J+\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010*\u001a\u00020\u0014*\u00020+H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J\u001a\u0010*\u001a\u00020\u0014*\u00020.H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u00020+*\u00020.H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103J\u001c\u00101\u001a\u00020+*\u00020\tH\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J\u001c\u00101\u001a\u00020+*\u00020\u0014H\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00106J\u0019\u00107\u001a\u000208*\u000209H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010;J\u001a\u0010<\u001a\u00020\t*\u00020+H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u00105J\u001a\u0010<\u001a\u00020\t*\u00020.H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u00103J\r\u0010?\u001a\u00020@*\u00020AH\u0097\u0001J\u0019\u0010B\u001a\u000209*\u000208H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010;J\u0019\u0010D\u001a\u00020.*\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010FJ\u001c\u0010D\u001a\u00020.*\u00020\tH\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010FJ\u001c\u0010D\u001a\u00020.*\u00020\u0014H\u0016ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HR\u0014\u0010\b\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R6\u0010\u0012\u001a*\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0013j\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006I"}, m40d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeMeasureScope", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeMeasureScope;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "placeablesCache", "Ljava/util/HashMap;", "", "", "Landroidx/compose/ui/layout/Placeable;", "Lkotlin/collections/HashMap;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "measure", "index", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutMeasureScopeImpl implements LazyLayoutMeasureScope, MeasureScope {
    private final LazyLayoutItemContentFactory itemContentFactory;
    private final HashMap<Integer, List<Placeable>> placeablesCache;
    private final SubcomposeMeasureScope subcomposeMeasureScope;

    @Override // androidx.compose.p002ui.unit.Density
    public float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    @Override // androidx.compose.p002ui.unit.Density
    public float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    @Override // androidx.compose.p002ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    @Override // androidx.compose.p002ui.layout.MeasureScope
    public MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        Intrinsics.checkNotNullParameter(alignmentLines, "alignmentLines");
        Intrinsics.checkNotNullParameter(placementBlock, "placementBlock");
        return this.subcomposeMeasureScope.layout(i, i2, alignmentLines, placementBlock);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: roundToPx--R2X_6o */
    public int mo596roundToPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.mo596roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public int mo597roundToPx0680j_4(float f) {
        return this.subcomposeMeasureScope.mo597roundToPx0680j_4(f);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public float mo602toPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.mo602toPxR2X_6o(j);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public float mo603toPx0680j_4(float f) {
        return this.subcomposeMeasureScope.mo603toPx0680j_4(f);
    }

    @Override // androidx.compose.p002ui.unit.Density
    public Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.subcomposeMeasureScope.toRect(dpRect);
    }

    public LazyLayoutMeasureScopeImpl(LazyLayoutItemContentFactory itemContentFactory, SubcomposeMeasureScope subcomposeMeasureScope) {
        Intrinsics.checkNotNullParameter(itemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "subcomposeMeasureScope");
        this.itemContentFactory = itemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope;
        this.placeablesCache = new HashMap<>();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    /* renamed from: measure-0kLqBqw */
    public List<Placeable> mo919measure0kLqBqw(int i, long j) {
        List<Placeable> list = this.placeablesCache.get(Integer.valueOf(i));
        if (list != null) {
            return list;
        }
        Object key = this.itemContentFactory.getItemProvider().invoke().getKey(i);
        List<Measurable> subcompose = this.subcomposeMeasureScope.subcompose(key, this.itemContentFactory.getContent(i, key));
        int size = subcompose.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(subcompose.get(i2).mo4376measureBRTryo0(j));
        }
        ArrayList arrayList2 = arrayList;
        this.placeablesCache.put(Integer.valueOf(i), arrayList2);
        return arrayList2;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p002ui.unit.Density
    /* renamed from: toDp-GaN1DYA */
    public float mo598toDpGaN1DYA(long j) {
        return this.subcomposeMeasureScope.mo598toDpGaN1DYA(j);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p002ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo600toDpu2uoSUM(int i) {
        return this.subcomposeMeasureScope.mo600toDpu2uoSUM(i);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p002ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo599toDpu2uoSUM(float f) {
        return this.subcomposeMeasureScope.mo599toDpu2uoSUM(f);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p002ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo606toSpkPz2Gy4(float f) {
        return this.subcomposeMeasureScope.mo606toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p002ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo607toSpkPz2Gy4(int i) {
        return this.subcomposeMeasureScope.mo607toSpkPz2Gy4(i);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p002ui.unit.Density
    /* renamed from: toSp-0xMU5do */
    public long mo605toSp0xMU5do(float f) {
        return this.subcomposeMeasureScope.mo605toSp0xMU5do(f);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p002ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public long mo604toSizeXkaWNTQ(long j) {
        return this.subcomposeMeasureScope.mo604toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p002ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public long mo601toDpSizekrfVVM(long j) {
        return this.subcomposeMeasureScope.mo601toDpSizekrfVVM(j);
    }
}
