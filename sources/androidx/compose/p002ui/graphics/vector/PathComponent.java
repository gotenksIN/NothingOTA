package androidx.compose.p002ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.p002ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.p002ui.graphics.AndroidPath_androidKt;
import androidx.compose.p002ui.graphics.Brush;
import androidx.compose.p002ui.graphics.Path;
import androidx.compose.p002ui.graphics.PathMeasure;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.graphics.drawscope.Stroke;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Vector.kt */
@Metadata(m41d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010R\u001a\u00020\u0014H\u0016J\b\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u00020TH\u0002J\f\u0010V\u001a\u00020T*\u00020WH\u0016R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010&\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020%@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u000e\u00102\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R(\u00103\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0007\"\u0004\b5\u0010\tR$\u00106\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR/\u0010:\u001a\u0002092\u0006\u0010\u0003\u001a\u000209@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R/\u0010>\u001a\u00020=2\u0006\u0010\u0003\u001a\u00020=@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b?\u0010(\"\u0004\b@\u0010*R$\u0010A\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR$\u0010D\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010I\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\r\"\u0004\bK\u0010\u000fR$\u0010L\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\r\"\u0004\bN\u0010\u000fR$\u0010O\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\r\"\u0004\bQ\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006X"}, m40d2 = {"Landroidx/compose/ui/graphics/vector/PathComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "value", "Landroidx/compose/ui/graphics/Brush;", "fill", "getFill", "()Landroidx/compose/ui/graphics/Brush;", "setFill", "(Landroidx/compose/ui/graphics/Brush;)V", "", "fillAlpha", "getFillAlpha", "()F", "setFillAlpha", "(F)V", "isPathDirty", "", "isStrokeDirty", "isTrimPathDirty", "", HintConstants.AUTOFILL_HINT_NAME, "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "parser", "Landroidx/compose/ui/graphics/vector/PathParser;", "path", "Landroidx/compose/ui/graphics/Path;", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "pathData", "getPathData", "()Ljava/util/List;", "setPathData", "(Ljava/util/List;)V", "Landroidx/compose/ui/graphics/PathFillType;", "pathFillType", "getPathFillType-Rg-k1Os", "()I", "setPathFillType-oQ8Xj4U", "(I)V", "I", "pathMeasure", "Landroidx/compose/ui/graphics/PathMeasure;", "getPathMeasure", "()Landroidx/compose/ui/graphics/PathMeasure;", "pathMeasure$delegate", "Lkotlin/Lazy;", "renderPath", "stroke", "getStroke", "setStroke", "strokeAlpha", "getStrokeAlpha", "setStrokeAlpha", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineCap", "getStrokeLineCap-KaPHkGw", "setStrokeLineCap-BeK7IIE", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineJoin", "getStrokeLineJoin-LxFBmk8", "setStrokeLineJoin-Ww9F2mQ", "strokeLineMiter", "getStrokeLineMiter", "setStrokeLineMiter", "strokeLineWidth", "getStrokeLineWidth", "setStrokeLineWidth", "strokeStyle", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trimPathEnd", "getTrimPathEnd", "setTrimPathEnd", "trimPathOffset", "getTrimPathOffset", "setTrimPathOffset", "trimPathStart", "getTrimPathStart", "setTrimPathStart", "toString", "updatePath", "", "updateRenderPath", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.graphics.vector.PathComponent */
/* loaded from: classes.dex */
public final class PathComponent extends VNode {
    private Brush fill;
    private float fillAlpha;
    private boolean isPathDirty;
    private boolean isStrokeDirty;
    private boolean isTrimPathDirty;
    private String name;
    private final PathParser parser;
    private final Path path;
    private List<? extends PathNode> pathData;
    private int pathFillType;
    private final Lazy pathMeasure$delegate;
    private final Path renderPath;
    private Brush stroke;
    private float strokeAlpha;
    private int strokeLineCap;
    private int strokeLineJoin;
    private float strokeLineMiter;
    private float strokeLineWidth;
    private Stroke strokeStyle;
    private float trimPathEnd;
    private float trimPathOffset;
    private float trimPathStart;

    public PathComponent() {
        super(null);
        this.name = "";
        this.fillAlpha = 1.0f;
        this.pathData = VectorKt.getEmptyPath();
        this.pathFillType = VectorKt.getDefaultFillType();
        this.strokeAlpha = 1.0f;
        this.strokeLineCap = VectorKt.getDefaultStrokeLineCap();
        this.strokeLineJoin = VectorKt.getDefaultStrokeLineJoin();
        this.strokeLineMiter = 4.0f;
        this.trimPathEnd = 1.0f;
        this.isPathDirty = true;
        this.isStrokeDirty = true;
        this.isTrimPathDirty = true;
        this.path = AndroidPath_androidKt.Path();
        this.renderPath = AndroidPath_androidKt.Path();
        this.pathMeasure$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Functions) new Functions<PathMeasure>() { // from class: androidx.compose.ui.graphics.vector.PathComponent$pathMeasure$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Functions
            public final PathMeasure invoke() {
                return AndroidPathMeasure_androidKt.PathMeasure();
            }
        });
        this.parser = new PathParser();
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = value;
        invalidate();
    }

    public final Brush getFill() {
        return this.fill;
    }

    public final void setFill(Brush brush) {
        this.fill = brush;
        invalidate();
    }

    public final float getFillAlpha() {
        return this.fillAlpha;
    }

    public final void setFillAlpha(float f) {
        this.fillAlpha = f;
        invalidate();
    }

    public final List<PathNode> getPathData() {
        return this.pathData;
    }

    public final void setPathData(List<? extends PathNode> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.pathData = value;
        this.isPathDirty = true;
        invalidate();
    }

    /* renamed from: getPathFillType-Rg-k1Os  reason: not valid java name */
    public final int m3482getPathFillTypeRgk1Os() {
        return this.pathFillType;
    }

    /* renamed from: setPathFillType-oQ8Xj4U  reason: not valid java name */
    public final void m3485setPathFillTypeoQ8Xj4U(int i) {
        this.pathFillType = i;
        this.renderPath.mo2753setFillTypeoQ8Xj4U(i);
        invalidate();
    }

    public final float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    public final void setStrokeAlpha(float f) {
        this.strokeAlpha = f;
        invalidate();
    }

    public final float getStrokeLineWidth() {
        return this.strokeLineWidth;
    }

    public final void setStrokeLineWidth(float f) {
        this.strokeLineWidth = f;
        invalidate();
    }

    public final Brush getStroke() {
        return this.stroke;
    }

    public final void setStroke(Brush brush) {
        this.stroke = brush;
        invalidate();
    }

    /* renamed from: getStrokeLineCap-KaPHkGw  reason: not valid java name */
    public final int m3483getStrokeLineCapKaPHkGw() {
        return this.strokeLineCap;
    }

    /* renamed from: setStrokeLineCap-BeK7IIE  reason: not valid java name */
    public final void m3486setStrokeLineCapBeK7IIE(int i) {
        this.strokeLineCap = i;
        this.isStrokeDirty = true;
        invalidate();
    }

    /* renamed from: getStrokeLineJoin-LxFBmk8  reason: not valid java name */
    public final int m3484getStrokeLineJoinLxFBmk8() {
        return this.strokeLineJoin;
    }

    /* renamed from: setStrokeLineJoin-Ww9F2mQ  reason: not valid java name */
    public final void m3487setStrokeLineJoinWw9F2mQ(int i) {
        this.strokeLineJoin = i;
        this.isStrokeDirty = true;
        invalidate();
    }

    public final float getStrokeLineMiter() {
        return this.strokeLineMiter;
    }

    public final void setStrokeLineMiter(float f) {
        this.strokeLineMiter = f;
        this.isStrokeDirty = true;
        invalidate();
    }

    public final float getTrimPathStart() {
        return this.trimPathStart;
    }

    public final void setTrimPathStart(float f) {
        if (this.trimPathStart == f) {
            return;
        }
        this.trimPathStart = f;
        this.isTrimPathDirty = true;
        invalidate();
    }

    public final float getTrimPathEnd() {
        return this.trimPathEnd;
    }

    public final void setTrimPathEnd(float f) {
        if (this.trimPathEnd == f) {
            return;
        }
        this.trimPathEnd = f;
        this.isTrimPathDirty = true;
        invalidate();
    }

    public final float getTrimPathOffset() {
        return this.trimPathOffset;
    }

    public final void setTrimPathOffset(float f) {
        if (this.trimPathOffset == f) {
            return;
        }
        this.trimPathOffset = f;
        this.isTrimPathDirty = true;
        invalidate();
    }

    private final PathMeasure getPathMeasure() {
        return (PathMeasure) this.pathMeasure$delegate.getValue();
    }

    private final void updatePath() {
        this.parser.clear();
        this.path.reset();
        this.parser.addPathNodes(this.pathData).toPath(this.path);
        updateRenderPath();
    }

    private final void updateRenderPath() {
        this.renderPath.reset();
        if (this.trimPathStart == 0.0f) {
            if (this.trimPathEnd == 1.0f) {
                Path.m3119addPathUv8p0NA$default(this.renderPath, this.path, 0L, 2, null);
                return;
            }
        }
        getPathMeasure().setPath(this.path, false);
        float length = getPathMeasure().getLength();
        float f = this.trimPathStart;
        float f2 = this.trimPathOffset;
        float f3 = ((f + f2) % 1.0f) * length;
        float f4 = ((this.trimPathEnd + f2) % 1.0f) * length;
        if (f3 > f4) {
            getPathMeasure().getSegment(f3, length, this.renderPath, true);
            getPathMeasure().getSegment(0.0f, f4, this.renderPath, true);
            return;
        }
        getPathMeasure().getSegment(f3, f4, this.renderPath, true);
    }

    @Override // androidx.compose.p002ui.graphics.vector.VNode
    public void draw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (this.isPathDirty) {
            updatePath();
        } else if (this.isTrimPathDirty) {
            updateRenderPath();
        }
        this.isPathDirty = false;
        this.isTrimPathDirty = false;
        Brush brush = this.fill;
        if (brush != null) {
            DrawScope.m3387drawPathGBMwjPU$default(drawScope, this.renderPath, brush, this.fillAlpha, null, null, 0, 56, null);
        }
        Brush brush2 = this.stroke;
        if (brush2 != null) {
            Stroke stroke = this.strokeStyle;
            if (this.isStrokeDirty || stroke == null) {
                stroke = new Stroke(this.strokeLineWidth, this.strokeLineMiter, this.strokeLineCap, this.strokeLineJoin, null, 16, null);
                this.strokeStyle = stroke;
                this.isStrokeDirty = false;
            }
            DrawScope.m3387drawPathGBMwjPU$default(drawScope, this.renderPath, brush2, this.strokeAlpha, stroke, null, 0, 48, null);
        }
    }

    public String toString() {
        return this.path.toString();
    }
}
