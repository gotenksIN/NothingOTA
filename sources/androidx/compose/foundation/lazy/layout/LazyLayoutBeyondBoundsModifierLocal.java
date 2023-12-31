package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo;
import androidx.compose.p002ui.layout.BeyondBoundsLayout;
import androidx.compose.p002ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.p002ui.modifier.ModifierLocalProvider;
import androidx.compose.p002ui.modifier.ProvidableModifierLocal;
import androidx.compose.p002ui.unit.LayoutDirection;
import kotlin.ExceptionsH;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
@Metadata(m41d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 *2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0002:\u0001*B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ@\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0019\u0010\u001e\u001a\u0015\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u0001H\u001d0\u001f¢\u0006\u0002\b!H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\b*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\b*\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006+"}, m40d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "state", "Landroidx/compose/foundation/lazy/layout/BeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/lazy/layout/BeyondBoundsState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/gestures/Orientation;)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "addNextInterval", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "currentInterval", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "addNextInterval-FR3nfPY", "(Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;I)Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "layout", "T", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "hasMoreContent", "hasMoreContent-FR3nfPY", "(Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;I)Z", "isOppositeToOrientation", "isOppositeToOrientation-4vf7U8o", "(I)Z", "Companion", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {
    public static final Companion Companion = new Companion(null);
    private static final C0343x8f1df05a emptyBeyondBoundsScope = new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1
        private final boolean hasMoreContent;

        @Override // androidx.compose.p002ui.layout.BeyondBoundsLayout.BeyondBoundsScope
        public boolean getHasMoreContent() {
            return this.hasMoreContent;
        }
    };
    private final LazyListBeyondBoundsInfo beyondBoundsInfo;
    private final LayoutDirection layoutDirection;
    private final Orientation orientation;
    private final boolean reverseLayout;
    private final BeyondBoundsState state;

    /* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LazyLayoutBeyondBoundsModifierLocal(BeyondBoundsState state, LazyListBeyondBoundsInfo beyondBoundsInfo, boolean z, LayoutDirection layoutDirection, Orientation orientation) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(beyondBoundsInfo, "beyondBoundsInfo");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.state = state;
        this.beyondBoundsInfo = beyondBoundsInfo;
        this.reverseLayout = z;
        this.layoutDirection = layoutDirection;
        this.orientation = orientation;
    }

    @Override // androidx.compose.p002ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    /* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
    @Metadata(m41d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, m40d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$Companion;", "", "()V", "emptyBeyondBoundsScope", "androidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1;", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.p002ui.modifier.ModifierLocalProvider
    public BeyondBoundsLayout getValue() {
        return this;
    }

    @Override // androidx.compose.p002ui.layout.BeyondBoundsLayout
    /* renamed from: layout-o7g1Pn8  reason: not valid java name */
    public <T> T mo917layouto7g1Pn8(final int i, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.state.getItemCount() <= 0 || !this.state.getHasVisibleItems()) {
            return block.invoke(emptyBeyondBoundsScope);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) this.beyondBoundsInfo.addInterval(this.state.getFirstVisibleIndex(), this.state.getLastVisibleIndex());
        T t = null;
        while (t == null && m915hasMoreContentFR3nfPY((LazyListBeyondBoundsInfo.Interval) objectRef.element, i)) {
            this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) objectRef.element);
            objectRef.element = (T) m914addNextIntervalFR3nfPY((LazyListBeyondBoundsInfo.Interval) objectRef.element, i);
            this.state.remeasure();
            t = block.invoke(new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal$layout$2
                @Override // androidx.compose.p002ui.layout.BeyondBoundsLayout.BeyondBoundsScope
                public boolean getHasMoreContent() {
                    boolean m915hasMoreContentFR3nfPY;
                    m915hasMoreContentFR3nfPY = LazyLayoutBeyondBoundsModifierLocal.this.m915hasMoreContentFR3nfPY(objectRef.element, i);
                    return m915hasMoreContentFR3nfPY;
                }
            });
        }
        this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) objectRef.element);
        this.state.remeasure();
        return t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
        if (r4.reverseLayout != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        if (r4.reverseLayout != false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0069, code lost:
        if (r4.reverseLayout != false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
        if (r4.reverseLayout != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008e, code lost:
        if (r4.reverseLayout != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0093, code lost:
        if (r4.reverseLayout != false) goto L3;
     */
    /* renamed from: addNextInterval-FR3nfPY  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo.Interval m914addNextIntervalFR3nfPY(androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo.Interval r5, int r6) {
        /*
            r4 = this;
            int r0 = r5.getStart()
            int r5 = r5.getEnd()
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.p002ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r1 = r1.m4362getBeforehoxUOeE()
            boolean r1 = androidx.compose.p002ui.layout.BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(r6, r1)
            if (r1 == 0) goto L18
        L14:
            int r0 = r0 + (-1)
            goto L97
        L18:
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.p002ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r1 = r1.m4361getAfterhoxUOeE()
            boolean r1 = androidx.compose.p002ui.layout.BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(r6, r1)
            if (r1 == 0) goto L28
        L24:
            int r5 = r5 + 1
            goto L97
        L28:
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.p002ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r1 = r1.m4360getAbovehoxUOeE()
            boolean r1 = androidx.compose.p002ui.layout.BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(r6, r1)
            if (r1 == 0) goto L39
            boolean r6 = r4.reverseLayout
            if (r6 == 0) goto L14
            goto L24
        L39:
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.p002ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r1 = r1.m4363getBelowhoxUOeE()
            boolean r1 = androidx.compose.p002ui.layout.BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(r6, r1)
            if (r1 == 0) goto L4a
            boolean r6 = r4.reverseLayout
            if (r6 == 0) goto L24
            goto L14
        L4a:
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.p002ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r1 = r1.m4364getLefthoxUOeE()
            boolean r1 = androidx.compose.p002ui.layout.BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(r6, r1)
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L71
            androidx.compose.ui.unit.LayoutDirection r6 = r4.layoutDirection
            int[] r1 = androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r1[r6]
            if (r6 == r3) goto L6c
            if (r6 == r2) goto L67
            goto L97
        L67:
            boolean r6 = r4.reverseLayout
            if (r6 == 0) goto L24
            goto L14
        L6c:
            boolean r6 = r4.reverseLayout
            if (r6 == 0) goto L14
            goto L24
        L71:
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.p002ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r1 = r1.m4365getRighthoxUOeE()
            boolean r6 = androidx.compose.p002ui.layout.BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(r6, r1)
            if (r6 == 0) goto L9e
            androidx.compose.ui.unit.LayoutDirection r6 = r4.layoutDirection
            int[] r1 = androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r1[r6]
            if (r6 == r3) goto L91
            if (r6 == r2) goto L8c
            goto L97
        L8c:
            boolean r6 = r4.reverseLayout
            if (r6 == 0) goto L14
            goto L24
        L91:
            boolean r6 = r4.reverseLayout
            if (r6 == 0) goto L24
            goto L14
        L97:
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r6 = r4.beyondBoundsInfo
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval r5 = r6.addInterval(r0, r5)
            return r5
        L9e:
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt.access$unsupportedDirection()
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal.m914addNextIntervalFR3nfPY(androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval, int):androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval");
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsBefore(LazyListBeyondBoundsInfo.Interval interval) {
        return interval.getStart() > 0;
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsAfter(LazyListBeyondBoundsInfo.Interval interval, LazyLayoutBeyondBoundsModifierLocal lazyLayoutBeyondBoundsModifierLocal) {
        return interval.getEnd() < lazyLayoutBeyondBoundsModifierLocal.state.getItemCount() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hasMoreContent-FR3nfPY  reason: not valid java name */
    public final boolean m915hasMoreContentFR3nfPY(LazyListBeyondBoundsInfo.Interval interval, int i) {
        if (m916isOppositeToOrientation4vf7U8o(i)) {
            return false;
        }
        if (BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.Companion.m4362getBeforehoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        }
        if (BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.Companion.m4361getAfterhoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        }
        if (BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.Companion.m4360getAbovehoxUOeE())) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        } else if (BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.Companion.m4363getBelowhoxUOeE())) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval) : hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        } else if (BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.Companion.m4364getLefthoxUOeE())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
            if (i2 == 1) {
                return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
            } else if (i2 == 2) {
                return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval) : hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (!BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.Companion.m4365getRighthoxUOeE())) {
            LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
            throw new ExceptionsH();
        } else {
            int i3 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
            if (i3 == 1) {
                return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval) : hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
            } else if (i3 == 2) {
                return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* renamed from: isOppositeToOrientation-4vf7U8o  reason: not valid java name */
    private final boolean m916isOppositeToOrientation4vf7U8o(int i) {
        if (!(BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.Companion.m4360getAbovehoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.Companion.m4363getBelowhoxUOeE()))) {
            if (!(BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.Companion.m4364getLefthoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.Companion.m4365getRighthoxUOeE()))) {
                if (!(BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.Companion.m4362getBeforehoxUOeE()) ? true : BeyondBoundsLayout.LayoutDirection.m4356equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.Companion.m4361getAfterhoxUOeE()))) {
                    LazyLayoutBeyondBoundsModifierLocalKt.unsupportedDirection();
                    throw new ExceptionsH();
                }
            } else if (this.orientation == Orientation.Vertical) {
                return true;
            }
        } else if (this.orientation == Orientation.Horizontal) {
            return true;
        }
        return false;
    }
}
