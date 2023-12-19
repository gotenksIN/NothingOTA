package androidx.compose.material3;

import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.OffsetKt;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollModifier;
import kotlin.Metadata;

/* compiled from: AppBar.kt */
@Metadata(m41d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, m40d2 = {"androidx/compose/material3/ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "material3_release"}, m39k = 1, m38mv = {1, 8, 0}, m36xi = 48)
/* loaded from: classes.dex */
public final class ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 implements NestedScrollModifier {
    final /* synthetic */ ExitUntilCollapsedScrollBehavior this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1(ExitUntilCollapsedScrollBehavior exitUntilCollapsedScrollBehavior) {
        this.this$0 = exitUntilCollapsedScrollBehavior;
    }

    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollModifier
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo611onPreScrollOzD1aCk(long j, int i) {
        if (!this.this$0.getCanScroll().invoke().booleanValue() || Offset.m2620getYimpl(j) > 0.0f) {
            return Offset.Companion.m2635getZeroF1C5BW0();
        }
        float heightOffset = this.this$0.getState().getHeightOffset();
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m2620getYimpl(j));
        if (!(heightOffset == this.this$0.getState().getHeightOffset())) {
            return Offset.m2613copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
        }
        return Offset.Companion.m2635getZeroF1C5BW0();
    }

    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollModifier
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo610onPostScrollDzOQY0M(long j, long j2, int i) {
        if (this.this$0.getCanScroll().invoke().booleanValue()) {
            TopAppBarState state = this.this$0.getState();
            state.setContentOffset(state.getContentOffset() + Offset.m2620getYimpl(j));
            if (Offset.m2620getYimpl(j2) < 0.0f || Offset.m2620getYimpl(j) < 0.0f) {
                float heightOffset = this.this$0.getState().getHeightOffset();
                this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m2620getYimpl(j));
                return OffsetKt.Offset(0.0f, this.this$0.getState().getHeightOffset() - heightOffset);
            }
            if ((Offset.m2620getYimpl(j) == 0.0f) && Offset.m2620getYimpl(j2) > 0.0f) {
                this.this$0.getState().setContentOffset(0.0f);
            }
            if (Offset.m2620getYimpl(j2) > 0.0f) {
                float heightOffset2 = this.this$0.getState().getHeightOffset();
                this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m2620getYimpl(j2));
                return OffsetKt.Offset(0.0f, this.this$0.getState().getHeightOffset() - heightOffset2);
            }
            return Offset.Companion.m2635getZeroF1C5BW0();
        }
        return Offset.Companion.m2635getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollModifier
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo609onPostFlingRZ2iAVY(long r10, long r12, kotlin.coroutines.Continuation<? super androidx.compose.p002ui.unit.Velocity> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof androidx.compose.material3.C0531x78ae0263
            if (r0 == 0) goto L14
            r0 = r14
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = (androidx.compose.material3.C0531x78ae0263) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = new androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1
            r0.<init>(r9, r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L41
            if (r1 == r2) goto L37
            if (r1 != r8) goto L2f
            long r10 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L81
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            long r12 = r0.J$0
            java.lang.Object r10 = r0.L$0
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 r10 = (androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1) r10
            kotlin.ResultKt.throwOnFailure(r14)
            goto L56
        L41:
            kotlin.ResultKt.throwOnFailure(r14)
            r0.L$0 = r9
            r0.J$0 = r12
            r0.label = r2
            r1 = r9
            r2 = r10
            r4 = r12
            r6 = r0
            java.lang.Object r14 = super.mo609onPostFlingRZ2iAVY(r2, r4, r6)
            if (r14 != r7) goto L55
            return r7
        L55:
            r10 = r9
        L56:
            androidx.compose.ui.unit.Velocity r14 = (androidx.compose.p002ui.unit.Velocity) r14
            long r1 = r14.m5585unboximpl()
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior r11 = r10.this$0
            androidx.compose.material3.TopAppBarState r11 = r11.getState()
            float r12 = androidx.compose.p002ui.unit.Velocity.m5577getYimpl(r12)
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior r13 = r10.this$0
            androidx.compose.animation.core.DecayAnimationSpec r13 = r13.getFlingAnimationSpec()
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior r10 = r10.this$0
            androidx.compose.animation.core.AnimationSpec r10 = r10.getSnapAnimationSpec()
            r14 = 0
            r0.L$0 = r14
            r0.J$0 = r1
            r0.label = r8
            java.lang.Object r14 = androidx.compose.material3.AppBar.access$settleAppBar(r11, r12, r13, r10, r0)
            if (r14 != r7) goto L80
            return r7
        L80:
            r10 = r1
        L81:
            androidx.compose.ui.unit.Velocity r14 = (androidx.compose.p002ui.unit.Velocity) r14
            long r12 = r14.m5585unboximpl()
            long r10 = androidx.compose.p002ui.unit.Velocity.m5580plusAH228Gc(r10, r12)
            androidx.compose.ui.unit.Velocity r10 = androidx.compose.p002ui.unit.Velocity.m5567boximpl(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1.mo609onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
