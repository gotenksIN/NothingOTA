package androidx.compose.animation;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedContent.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f21\u0010\r\u001a-\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0012¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0013\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u001521\u0010\r\u001a-\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0012¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0016\u001aU\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2>\b\u0002\u0010\u001b\u001a8\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001f0\u000eH\u0007ø\u0001\u0000\u001a¬\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020 2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001f\b\u0002\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010!\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\"0\u000721\u0010\r\u001a-\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0012¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010#\u001a\u0015\u0010$\u001a\u00020\t*\u00020%2\u0006\u0010&\u001a\u00020'H\u0087\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"AnimatedContent", "", "S", "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/AnimatedContentScope;", "Landroidx/compose/animation/ContentTransform;", "Lkotlin/ExtensionFunctionType;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "content", "Lkotlin/Function2;", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Ljava/lang/String;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "SizeTransform", "Landroidx/compose/animation/SizeTransform;", "clip", "", "sizeAnimationSpec", "Landroidx/compose/ui/unit/IntSize;", "initialSize", "targetSize", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/animation/core/Transition;", "contentKey", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "with", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatedContentKt {
    /* JADX WARN: Removed duplicated region for block: B:123:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <S> void AnimatedContent(final S r18, androidx.compose.ui.Modifier r19, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r20, androidx.compose.ui.Alignment r21, java.lang.String r22, final kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedVisibilityScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(java.lang.Object, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, java.lang.String, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "AnimatedContent API now has a new label parameter added.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void AnimatedContent(final java.lang.Object r16, androidx.compose.ui.Modifier r17, kotlin.jvm.functions.Function1 r18, androidx.compose.ui.Alignment r19, final kotlin.jvm.functions.Function4 r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(java.lang.Object, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    public static /* synthetic */ SizeTransform SizeTransform$default(boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function2 = new Function2<IntSize, IntSize, SpringSpec<IntSize>>() { // from class: androidx.compose.animation.AnimatedContentKt$SizeTransform$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ SpringSpec<IntSize> invoke(IntSize intSize, IntSize intSize2) {
                    return m11invokeTemP2vQ(intSize.m5214unboximpl(), intSize2.m5214unboximpl());
                }

                /* renamed from: invoke-TemP2vQ  reason: not valid java name */
                public final SpringSpec<IntSize> m11invokeTemP2vQ(long j, long j2) {
                    return AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m5202boximpl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 3, null);
                }
            };
        }
        return SizeTransform(z, function2);
    }

    public static final SizeTransform SizeTransform(boolean z, Function2<? super IntSize, ? super IntSize, ? extends FiniteAnimationSpec<IntSize>> sizeAnimationSpec) {
        Intrinsics.checkNotNullParameter(sizeAnimationSpec, "sizeAnimationSpec");
        return new SizeTransformImpl(z, sizeAnimationSpec);
    }

    public static final ContentTransform with(EnterTransition enterTransition, ExitTransition exit) {
        Intrinsics.checkNotNullParameter(enterTransition, "<this>");
        Intrinsics.checkNotNullParameter(exit, "exit");
        return new ContentTransform(enterTransition, exit, 0.0f, null, 12, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:209:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0286 A[LOOP:2: B:323:0x0284->B:324:0x0286, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:365:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <S> void AnimatedContent(final androidx.compose.animation.core.Transition<S> r25, androidx.compose.ui.Modifier r26, kotlin.jvm.functions.Function1<? super androidx.compose.animation.AnimatedContentScope<S>, androidx.compose.animation.ContentTransform> r27, androidx.compose.ui.Alignment r28, kotlin.jvm.functions.Function1<? super S, ? extends java.lang.Object> r29, final kotlin.jvm.functions.Function4<? super androidx.compose.animation.AnimatedVisibilityScope, ? super S, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 1127
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedContentKt.AnimatedContent(androidx.compose.animation.core.Transition, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}
