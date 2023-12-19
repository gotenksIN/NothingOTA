package androidx.compose.runtime;

import androidx.appcompat.C0032R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Recomposer.kt */
@Metadata(m41d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, m40d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
@DebugMetadata(m31c = "androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2", m30f = "Recomposer.kt", m29i = {0}, m28l = {C0032R.styleable.AppCompatTheme_editTextBackground, C0032R.styleable.AppCompatTheme_editTextStyle}, m27m = "invokeSuspend", m26n = {"recomposer"}, m25s = {"L$0"})
/* loaded from: classes.dex */
final class RecomposerKt$withRunningRecomposer$2<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function3<CoroutineScope, Recomposer, Continuation<? super R>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RecomposerKt$withRunningRecomposer$2(Function3<? super CoroutineScope, ? super Recomposer, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super RecomposerKt$withRunningRecomposer$2> continuation) {
        super(2, continuation);
        this.$block = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RecomposerKt$withRunningRecomposer$2 recomposerKt$withRunningRecomposer$2 = new RecomposerKt$withRunningRecomposer$2(this.$block, continuation);
        recomposerKt$withRunningRecomposer$2.L$0 = obj;
        return recomposerKt$withRunningRecomposer$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object obj) {
        return invoke(coroutineScope, (Continuation) ((Continuation) obj));
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((RecomposerKt$withRunningRecomposer$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Recomposer recomposer;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            recomposer = new Recomposer(coroutineScope.getCoroutineContext());
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C06751(recomposer, null), 3, null);
            Function3<CoroutineScope, Recomposer, Continuation<? super R>, Object> function3 = this.$block;
            this.L$0 = recomposer;
            this.label = 1;
            obj = function3.invoke(coroutineScope, recomposer, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                Object obj2 = this.L$0;
                ResultKt.throwOnFailure(obj);
                return obj2;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            recomposer = (Recomposer) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        recomposer.close();
        this.L$0 = obj;
        this.label = 2;
        return recomposer.join(this) == coroutine_suspended ? coroutine_suspended : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Recomposer.kt */
    @Metadata(m41d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, m40d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 8, 0}, m36xi = 48)
    @DebugMetadata(m31c = "androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2$1", m30f = "Recomposer.kt", m29i = {}, m28l = {C0032R.styleable.AppCompatTheme_dropdownListPreferredItemHeight}, m27m = "invokeSuspend", m26n = {}, m25s = {})
    /* renamed from: androidx.compose.runtime.RecomposerKt$withRunningRecomposer$2$1 */
    /* loaded from: classes.dex */
    public static final class C06751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Recomposer $recomposer;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06751(Recomposer recomposer, Continuation<? super C06751> continuation) {
            super(2, continuation);
            this.$recomposer = recomposer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06751(this.$recomposer, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$recomposer.runRecomposeAndApplyChanges(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
