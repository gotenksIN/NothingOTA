package androidx.compose.p002ui.layout;

import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.unit.Density;
import androidx.compose.p002ui.unit.DpRect;
import androidx.compose.p002ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Layout.kt */
@Metadata(m41d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u0013H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u0010*\u00020\u0013H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0016\u001a\u00020\u0010*\u00020\u0007H\u0097\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u0016\u001a\u00020\u0010*\u00020\u000fH\u0097\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u001d*\u00020\u001eH\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010!\u001a\u00020\u0007*\u00020\u0010H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\u001aJ\u001a\u0010!\u001a\u00020\u0007*\u00020\u0013H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0018J\r\u0010$\u001a\u00020%*\u00020&H\u0097\u0001J\u001a\u0010'\u001a\u00020\u001e*\u00020\u001dH\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010 J\u001a\u0010)\u001a\u00020\u0013*\u00020\u0010H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J\u001d\u0010)\u001a\u00020\u0013*\u00020\u0007H\u0097\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010+J\u001d\u0010)\u001a\u00020\u0013*\u00020\u000fH\u0097\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0003\u001a\u00020\u00078\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006."}, m40d2 = {"Landroidx/compose/ui/layout/IntrinsicsMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/unit/Density;", "density", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;)V", "", "getDensity", "()F", "fontScale", "getFontScale", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.layout.IntrinsicsMeasureScope */
/* loaded from: classes.dex */
public final class IntrinsicsMeasureScope implements MeasureScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    private final LayoutDirection layoutDirection;

    @Override // androidx.compose.p002ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.p002ui.unit.Density
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: roundToPx--R2X_6o */
    public int mo596roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo596roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public int mo597roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo597roundToPx0680j_4(f);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toDp-GaN1DYA */
    public float mo598toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo598toDpGaN1DYA(j);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo599toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo599toDpu2uoSUM(f);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo600toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo600toDpu2uoSUM(i);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public long mo601toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo601toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public float mo602toPxR2X_6o(long j) {
        return this.$$delegate_0.mo602toPxR2X_6o(j);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public float mo603toPx0680j_4(float f) {
        return this.$$delegate_0.mo603toPx0680j_4(f);
    }

    @Override // androidx.compose.p002ui.unit.Density
    public Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public long mo604toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo604toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toSp-0xMU5do */
    public long mo605toSp0xMU5do(float f) {
        return this.$$delegate_0.mo605toSp0xMU5do(f);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo606toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo606toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo607toSpkPz2Gy4(int i) {
        return this.$$delegate_0.mo607toSpkPz2Gy4(i);
    }

    public IntrinsicsMeasureScope(Density density, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.layoutDirection = layoutDirection;
        this.$$delegate_0 = density;
    }

    @Override // androidx.compose.p002ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }
}
