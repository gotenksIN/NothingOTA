package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p002ui.layout.LayoutModifier;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.text.input.TransformedText;
import androidx.compose.p002ui.unit.Constraints;
import androidx.compose.p002ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(m41d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J)\u0010 \u001a\u00020!*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, m40d2 = {"Landroidx/compose/foundation/text/HorizontalScrollLayoutModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "scrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "cursorOffset", "", "transformedText", "Landroidx/compose/ui/text/input/TransformedText;", "textLayoutResultProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/text/TextLayoutResultProxy;", "(Landroidx/compose/foundation/text/TextFieldScrollerPosition;ILandroidx/compose/ui/text/input/TransformedText;Lkotlin/jvm/functions/Function0;)V", "getCursorOffset", "()I", "getScrollerPosition", "()Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "getTextLayoutResultProvider", "()Lkotlin/jvm/functions/Function0;", "getTransformedText", "()Landroidx/compose/ui/text/input/TransformedText;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* renamed from: androidx.compose.foundation.text.HorizontalScrollLayoutModifier */
/* loaded from: classes.dex */
final class TextFieldScroll implements LayoutModifier {
    private final int cursorOffset;
    private final TextFieldScrollerPosition scrollerPosition;
    private final Functions<TextLayoutResultProxy> textLayoutResultProvider;
    private final TransformedText transformedText;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextFieldScroll copy$default(TextFieldScroll textFieldScroll, TextFieldScrollerPosition textFieldScrollerPosition, int i, TransformedText transformedText, Functions functions, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            textFieldScrollerPosition = textFieldScroll.scrollerPosition;
        }
        if ((i2 & 2) != 0) {
            i = textFieldScroll.cursorOffset;
        }
        if ((i2 & 4) != 0) {
            transformedText = textFieldScroll.transformedText;
        }
        if ((i2 & 8) != 0) {
            functions = textFieldScroll.textLayoutResultProvider;
        }
        return textFieldScroll.copy(textFieldScrollerPosition, i, transformedText, functions);
    }

    public final TextFieldScrollerPosition component1() {
        return this.scrollerPosition;
    }

    public final int component2() {
        return this.cursorOffset;
    }

    public final TransformedText component3() {
        return this.transformedText;
    }

    public final Functions<TextLayoutResultProxy> component4() {
        return this.textLayoutResultProvider;
    }

    public final TextFieldScroll copy(TextFieldScrollerPosition scrollerPosition, int i, TransformedText transformedText, Functions<TextLayoutResultProxy> textLayoutResultProvider) {
        Intrinsics.checkNotNullParameter(scrollerPosition, "scrollerPosition");
        Intrinsics.checkNotNullParameter(transformedText, "transformedText");
        Intrinsics.checkNotNullParameter(textLayoutResultProvider, "textLayoutResultProvider");
        return new TextFieldScroll(scrollerPosition, i, transformedText, textLayoutResultProvider);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextFieldScroll) {
            TextFieldScroll textFieldScroll = (TextFieldScroll) obj;
            return Intrinsics.areEqual(this.scrollerPosition, textFieldScroll.scrollerPosition) && this.cursorOffset == textFieldScroll.cursorOffset && Intrinsics.areEqual(this.transformedText, textFieldScroll.transformedText) && Intrinsics.areEqual(this.textLayoutResultProvider, textFieldScroll.textLayoutResultProvider);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.scrollerPosition.hashCode() * 31) + Integer.hashCode(this.cursorOffset)) * 31) + this.transformedText.hashCode()) * 31) + this.textLayoutResultProvider.hashCode();
    }

    public String toString() {
        return "HorizontalScrollLayoutModifier(scrollerPosition=" + this.scrollerPosition + ", cursorOffset=" + this.cursorOffset + ", transformedText=" + this.transformedText + ", textLayoutResultProvider=" + this.textLayoutResultProvider + ')';
    }

    public TextFieldScroll(TextFieldScrollerPosition scrollerPosition, int i, TransformedText transformedText, Functions<TextLayoutResultProxy> textLayoutResultProvider) {
        Intrinsics.checkNotNullParameter(scrollerPosition, "scrollerPosition");
        Intrinsics.checkNotNullParameter(transformedText, "transformedText");
        Intrinsics.checkNotNullParameter(textLayoutResultProvider, "textLayoutResultProvider");
        this.scrollerPosition = scrollerPosition;
        this.cursorOffset = i;
        this.transformedText = transformedText;
        this.textLayoutResultProvider = textLayoutResultProvider;
    }

    public final TextFieldScrollerPosition getScrollerPosition() {
        return this.scrollerPosition;
    }

    public final int getCursorOffset() {
        return this.cursorOffset;
    }

    public final TransformedText getTransformedText() {
        return this.transformedText;
    }

    public final Functions<TextLayoutResultProxy> getTextLayoutResultProvider() {
        return this.textLayoutResultProvider;
    }

    @Override // androidx.compose.p002ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo326measure3p2s80s(final MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable mo4376measureBRTryo0 = measurable.mo4376measureBRTryo0(measurable.maxIntrinsicWidth(Constraints.m5306getMaxHeightimpl(j)) < Constraints.m5307getMaxWidthimpl(j) ? j : Constraints.m5298copyZbe2FdA$default(j, 0, Integer.MAX_VALUE, 0, 0, 13, null));
        final int min = Math.min(mo4376measureBRTryo0.getWidth(), Constraints.m5307getMaxWidthimpl(j));
        return MeasureScope.layout$default(measure, min, mo4376measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.HorizontalScrollLayoutModifier$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                MeasureScope measureScope = MeasureScope.this;
                int cursorOffset = this.getCursorOffset();
                TransformedText transformedText = this.getTransformedText();
                TextLayoutResultProxy invoke = this.getTextLayoutResultProvider().invoke();
                this.getScrollerPosition().update(Orientation.Horizontal, TextFieldScrollKt.access$getCursorRectInScroller(measureScope, cursorOffset, transformedText, invoke != null ? invoke.getValue() : null, MeasureScope.this.getLayoutDirection() == LayoutDirection.Rtl, mo4376measureBRTryo0.getWidth()), min, mo4376measureBRTryo0.getWidth());
                Placeable.PlacementScope.placeRelative$default(layout, mo4376measureBRTryo0, MathKt.roundToInt(-this.getScrollerPosition().getOffset()), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
