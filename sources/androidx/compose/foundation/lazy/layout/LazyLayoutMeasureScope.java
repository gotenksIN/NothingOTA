package androidx.compose.foundation.lazy.layout;

import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.geometry.SizeKt;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.unit.C0780Dp;
import androidx.compose.p002ui.unit.DpKt;
import androidx.compose.p002ui.unit.DpSize;
import androidx.compose.p002ui.unit.TextUnit;
import androidx.compose.p002ui.unit.TextUnitKt;
import androidx.compose.p002ui.unit.TextUnitType;
import java.util.List;
import kotlin.Metadata;

/* compiled from: LazyLayoutMeasureScope.kt */
@Metadata(m41d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u000b\u001a\u00020\f*\u00020\u0006H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u001b\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001dJ\u001c\u0010\u001b\u001a\u00020\r*\u00020\u0006H\u0017ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u0082\u0001\u0001 ø\u0001\u0003\u0082\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, m40d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "measure", "", "Landroidx/compose/ui/layout/Placeable;", "index", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public interface LazyLayoutMeasureScope extends MeasureScope {
    /* renamed from: measure-0kLqBqw  reason: not valid java name */
    List<Placeable> mo919measure0kLqBqw(int i, long j);

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toDp-GaN1DYA */
    default float mo598toDpGaN1DYA(long j) {
        if (!TextUnitType.m5560equalsimpl0(TextUnit.m5531getTypeUIouoOA(j), TextUnitType.Companion.m5565getSpUIouoOA())) {
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }
        return C0780Dp.m5351constructorimpl(TextUnit.m5532getValueimpl(j) * getFontScale());
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    default float mo600toDpu2uoSUM(int i) {
        return C0780Dp.m5351constructorimpl(i / getDensity());
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    default float mo599toDpu2uoSUM(float f) {
        return C0780Dp.m5351constructorimpl(f / getDensity());
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    default long mo606toSpkPz2Gy4(float f) {
        return TextUnitKt.getSp(f / (getFontScale() * getDensity()));
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    default long mo607toSpkPz2Gy4(int i) {
        return TextUnitKt.getSp(i / (getFontScale() * getDensity()));
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toSp-0xMU5do */
    default long mo605toSp0xMU5do(float f) {
        return TextUnitKt.getSp(f / getFontScale());
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    default long mo604toSizeXkaWNTQ(long j) {
        if (j != DpSize.Companion.m5458getUnspecifiedMYxV2XQ()) {
            return SizeKt.Size(mo603toPx0680j_4(DpSize.m5449getWidthD9Ej5fM(j)), mo603toPx0680j_4(DpSize.m5447getHeightD9Ej5fM(j)));
        }
        return Size.Companion.m2696getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.p002ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    default long mo601toDpSizekrfVVM(long j) {
        if (j != Size.Companion.m2696getUnspecifiedNHjbRc()) {
            return DpKt.m5373DpSizeYgX7TsA(mo599toDpu2uoSUM(Size.m2688getWidthimpl(j)), mo599toDpu2uoSUM(Size.m2685getHeightimpl(j)));
        }
        return DpSize.Companion.m5458getUnspecifiedMYxV2XQ();
    }
}
