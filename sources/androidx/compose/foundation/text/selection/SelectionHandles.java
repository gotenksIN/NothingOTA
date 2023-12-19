package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.p002ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\r\u001a\u00020\u0005HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\nJ*\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, m40d2 = {"Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "", "handle", "Landroidx/compose/foundation/text/Handle;", "position", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/foundation/text/Handle;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHandle", "()Landroidx/compose/foundation/text/Handle;", "getPosition-F1C5BW0", "()J", "J", "component1", "component2", "component2-F1C5BW0", "copy", "copy-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.foundation.text.selection.SelectionHandleInfo */
/* loaded from: classes.dex */
public final class SelectionHandles {
    private final Handle handle;
    private final long position;

    public /* synthetic */ SelectionHandles(Handle handle, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(handle, j);
    }

    /* renamed from: copy-Uv8p0NA$default  reason: not valid java name */
    public static /* synthetic */ SelectionHandles m1123copyUv8p0NA$default(SelectionHandles selectionHandles, Handle handle, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            handle = selectionHandles.handle;
        }
        if ((i & 2) != 0) {
            j = selectionHandles.position;
        }
        return selectionHandles.m1125copyUv8p0NA(handle, j);
    }

    public final Handle component1() {
        return this.handle;
    }

    /* renamed from: component2-F1C5BW0  reason: not valid java name */
    public final long m1124component2F1C5BW0() {
        return this.position;
    }

    /* renamed from: copy-Uv8p0NA  reason: not valid java name */
    public final SelectionHandles m1125copyUv8p0NA(Handle handle, long j) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        return new SelectionHandles(handle, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelectionHandles) {
            SelectionHandles selectionHandles = (SelectionHandles) obj;
            return this.handle == selectionHandles.handle && Offset.m2616equalsimpl0(this.position, selectionHandles.position);
        }
        return false;
    }

    public int hashCode() {
        return (this.handle.hashCode() * 31) + Offset.m2621hashCodeimpl(this.position);
    }

    public String toString() {
        return "SelectionHandleInfo(handle=" + this.handle + ", position=" + ((Object) Offset.m2627toStringimpl(this.position)) + ')';
    }

    private SelectionHandles(Handle handle, long j) {
        this.handle = handle;
        this.position = j;
    }

    public final Handle getHandle() {
        return this.handle;
    }

    /* renamed from: getPosition-F1C5BW0  reason: not valid java name */
    public final long m1126getPositionF1C5BW0() {
        return this.position;
    }
}
