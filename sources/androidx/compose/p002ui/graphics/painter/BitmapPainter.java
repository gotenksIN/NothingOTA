package androidx.compose.p002ui.graphics.painter;

import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.graphics.ColorFilter;
import androidx.compose.p002ui.graphics.FilterQuality;
import androidx.compose.p002ui.graphics.ImageBitmap;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.unit.IntOffset;
import androidx.compose.p002ui.unit.IntSize;
import androidx.compose.p002ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: BitmapPainter.kt */
@Metadata(m41d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B$\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0013\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J%\u0010$\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\f\u0010'\u001a\u00020(*\u00020)H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010\r\u001a\u00020\u000eX\u0080\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019R\u0019\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0019\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, m40d2 = {"Landroidx/compose/ui/graphics/painter/BitmapPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "(Landroidx/compose/ui/graphics/ImageBitmap;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I$ui_graphics_release", "()I", "setFilterQuality-vDHp3xo$ui_graphics_release", "(I)V", "I", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "size", "J", "applyAlpha", "", "applyColorFilter", "equals", "other", "", "hashCode", "", "toString", "", "validateSize", "validateSize-N5eqBDc", "(JJ)J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui-graphics_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.graphics.painter.BitmapPainter */
/* loaded from: classes.dex */
public final class BitmapPainter extends Painter {
    private float alpha;
    private ColorFilter colorFilter;
    private int filterQuality;
    private final ImageBitmap image;
    private final long size;
    private final long srcOffset;
    private final long srcSize;

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, j, j2);
    }

    public /* synthetic */ BitmapPainter(ImageBitmap imageBitmap, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageBitmap, (i & 2) != 0 ? IntOffset.Companion.m5479getZeronOccac() : j, (i & 4) != 0 ? IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()) : j2, null);
    }

    private BitmapPainter(ImageBitmap imageBitmap, long j, long j2) {
        this.image = imageBitmap;
        this.srcOffset = j;
        this.srcSize = j2;
        this.filterQuality = FilterQuality.Companion.m2952getLowfv9h1I();
        this.size = m3464validateSizeN5eqBDc(j, j2);
        this.alpha = 1.0f;
    }

    /* renamed from: getFilterQuality-f-v9h1I$ui_graphics_release  reason: not valid java name */
    public final int m3465getFilterQualityfv9h1I$ui_graphics_release() {
        return this.filterQuality;
    }

    /* renamed from: setFilterQuality-vDHp3xo$ui_graphics_release  reason: not valid java name */
    public final void m3467setFilterQualityvDHp3xo$ui_graphics_release(int i) {
        this.filterQuality = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.p002ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        DrawScope.m3381drawImageAZ2fEMs$default(drawScope, this.image, this.srcOffset, this.srcSize, 0L, IntSizeKt.IntSize(MathKt.roundToInt(Size.m2688getWidthimpl(drawScope.mo3397getSizeNHjbRc())), MathKt.roundToInt(Size.m2685getHeightimpl(drawScope.mo3397getSizeNHjbRc()))), this.alpha, null, this.colorFilter, 0, this.filterQuality, 328, null);
    }

    @Override // androidx.compose.p002ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long mo3466getIntrinsicSizeNHjbRc() {
        return IntSizeKt.m5521toSizeozmzZPI(this.size);
    }

    @Override // androidx.compose.p002ui.graphics.painter.Painter
    protected boolean applyAlpha(float f) {
        this.alpha = f;
        return true;
    }

    @Override // androidx.compose.p002ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    /* renamed from: validateSize-N5eqBDc  reason: not valid java name */
    private final long m3464validateSizeN5eqBDc(long j, long j2) {
        if (IntOffset.m5469getXimpl(j) >= 0 && IntOffset.m5470getYimpl(j) >= 0 && IntSize.m5511getWidthimpl(j2) >= 0 && IntSize.m5510getHeightimpl(j2) >= 0 && IntSize.m5511getWidthimpl(j2) <= this.image.getWidth() && IntSize.m5510getHeightimpl(j2) <= this.image.getHeight()) {
            return j2;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BitmapPainter) {
            BitmapPainter bitmapPainter = (BitmapPainter) obj;
            return Intrinsics.areEqual(this.image, bitmapPainter.image) && IntOffset.m5468equalsimpl0(this.srcOffset, bitmapPainter.srcOffset) && IntSize.m5509equalsimpl0(this.srcSize, bitmapPainter.srcSize) && FilterQuality.m2947equalsimpl0(this.filterQuality, bitmapPainter.filterQuality);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.image.hashCode() * 31) + IntOffset.m5471hashCodeimpl(this.srcOffset)) * 31) + IntSize.m5512hashCodeimpl(this.srcSize)) * 31) + FilterQuality.m2948hashCodeimpl(this.filterQuality);
    }

    public String toString() {
        return "BitmapPainter(image=" + this.image + ", srcOffset=" + ((Object) IntOffset.m5476toStringimpl(this.srcOffset)) + ", srcSize=" + ((Object) IntSize.m5514toStringimpl(this.srcSize)) + ", filterQuality=" + ((Object) FilterQuality.m2949toStringimpl(this.filterQuality)) + ')';
    }
}
