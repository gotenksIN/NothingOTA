package androidx.compose.p002ui.draw;

import androidx.compose.p002ui.graphics.drawscope.ContentDrawScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawModifier.kt */
@Metadata(m41d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B&\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001a\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007HÆ\u0003J.\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0019\b\u0002\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\f\u0010\u001c\u001a\u00020\u0017*\u00020\u001dH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, m40d2 = {"Landroidx/compose/ui/draw/DrawContentCacheModifier;", "Landroidx/compose/ui/draw/DrawCacheModifier;", "cacheDrawScope", "Landroidx/compose/ui/draw/CacheDrawScope;", "onBuildDrawCache", "Lkotlin/Function1;", "Landroidx/compose/ui/draw/DrawResult;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/draw/CacheDrawScope;Lkotlin/jvm/functions/Function1;)V", "getCacheDrawScope", "()Landroidx/compose/ui/draw/CacheDrawScope;", "getOnBuildDrawCache", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "onBuildCache", "", "params", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "toString", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.ui.draw.DrawContentCacheModifier */
/* loaded from: classes.dex */
final class DrawContentCacheModifier implements DrawCacheModifier {
    private final CacheDrawScope cacheDrawScope;
    private final Function1<CacheDrawScope, DrawResult> onBuildDrawCache;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DrawContentCacheModifier copy$default(DrawContentCacheModifier drawContentCacheModifier, CacheDrawScope cacheDrawScope, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            cacheDrawScope = drawContentCacheModifier.cacheDrawScope;
        }
        if ((i & 2) != 0) {
            function1 = drawContentCacheModifier.onBuildDrawCache;
        }
        return drawContentCacheModifier.copy(cacheDrawScope, function1);
    }

    public final CacheDrawScope component1() {
        return this.cacheDrawScope;
    }

    public final Function1<CacheDrawScope, DrawResult> component2() {
        return this.onBuildDrawCache;
    }

    public final DrawContentCacheModifier copy(CacheDrawScope cacheDrawScope, Function1<? super CacheDrawScope, DrawResult> onBuildDrawCache) {
        Intrinsics.checkNotNullParameter(cacheDrawScope, "cacheDrawScope");
        Intrinsics.checkNotNullParameter(onBuildDrawCache, "onBuildDrawCache");
        return new DrawContentCacheModifier(cacheDrawScope, onBuildDrawCache);
    }

    public String toString() {
        return "DrawContentCacheModifier(cacheDrawScope=" + this.cacheDrawScope + ", onBuildDrawCache=" + this.onBuildDrawCache + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DrawContentCacheModifier(CacheDrawScope cacheDrawScope, Function1<? super CacheDrawScope, DrawResult> onBuildDrawCache) {
        Intrinsics.checkNotNullParameter(cacheDrawScope, "cacheDrawScope");
        Intrinsics.checkNotNullParameter(onBuildDrawCache, "onBuildDrawCache");
        this.cacheDrawScope = cacheDrawScope;
        this.onBuildDrawCache = onBuildDrawCache;
    }

    public final CacheDrawScope getCacheDrawScope() {
        return this.cacheDrawScope;
    }

    public final Function1<CacheDrawScope, DrawResult> getOnBuildDrawCache() {
        return this.onBuildDrawCache;
    }

    @Override // androidx.compose.p002ui.draw.DrawCacheModifier
    public void onBuildCache(BuildDrawCacheParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        CacheDrawScope cacheDrawScope = this.cacheDrawScope;
        cacheDrawScope.setCacheParams$ui_release(params);
        cacheDrawScope.setDrawResult$ui_release(null);
        this.onBuildDrawCache.invoke(cacheDrawScope);
        if (cacheDrawScope.getDrawResult$ui_release() == null) {
            throw new IllegalStateException("DrawResult not defined, did you forget to call onDraw?".toString());
        }
    }

    @Override // androidx.compose.p002ui.draw.DrawModifier
    public void draw(ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        DrawResult drawResult$ui_release = this.cacheDrawScope.getDrawResult$ui_release();
        Intrinsics.checkNotNull(drawResult$ui_release);
        drawResult$ui_release.getBlock$ui_release().invoke(contentDrawScope);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrawContentCacheModifier) {
            DrawContentCacheModifier drawContentCacheModifier = (DrawContentCacheModifier) obj;
            return Intrinsics.areEqual(this.cacheDrawScope, drawContentCacheModifier.cacheDrawScope) && Intrinsics.areEqual(this.onBuildDrawCache, drawContentCacheModifier.onBuildDrawCache);
        }
        return false;
    }

    public int hashCode() {
        return (this.cacheDrawScope.hashCode() * 31) + this.onBuildDrawCache.hashCode();
    }
}
