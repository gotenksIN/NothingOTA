package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.runtime.State;
import kotlin.Metadata;

/* compiled from: TextFieldImpl.kt */
@Metadata(m41d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JÊ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2z\u0010\u000f\u001av\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, m40d2 = {"Landroidx/compose/material3/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material3/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "prefixSuffixOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material3/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function7;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    /* compiled from: TextFieldImpl.kt */
    @Metadata(m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextFieldImpl.values().length];
            try {
                iArr[TextFieldImpl.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextFieldImpl.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextFieldImpl.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01fa, code lost:
        if (r32 != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0240, code lost:
        if (r32 != false) goto L107;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ec  */
    /* renamed from: Transition-DTcfvLk  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1783TransitionDTcfvLk(final androidx.compose.material3.TextFieldImpl r26, final long r27, final long r29, final kotlin.jvm.functions.Function3<? super androidx.compose.material3.TextFieldImpl, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.p002ui.graphics.Color> r31, final boolean r32, final kotlin.jvm.functions.Function7<? super java.lang.Float, ? super androidx.compose.p002ui.graphics.Color, ? super androidx.compose.p002ui.graphics.Color, ? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35) {
        /*
            Method dump skipped, instructions count: 1407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldTransitionScope.m1783TransitionDTcfvLk(androidx.compose.material3.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function7, androidx.compose.runtime.Composer, int):void");
    }

    private static final float Transition_DTcfvLk$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$7(State<Color> state) {
        return state.getValue().m2867unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$8(State<Color> state) {
        return state.getValue().m2867unboximpl();
    }
}
