package com.nothing.OfflineOTAUpgradeApp.util;

import android.content.Context;
import com.nothing.OfflineOTAUpgradeApp.R;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.codec.binary.Base64;

/* compiled from: EncryptUtil.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getPublicKeySuspend$2", f = "EncryptUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class EncryptUtil$getPublicKeySuspend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncryptUtil$getPublicKeySuspend$2(Context context, Continuation<? super EncryptUtil$getPublicKeySuspend$2> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EncryptUtil$getPublicKeySuspend$2(this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return ((EncryptUtil$getPublicKeySuspend$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            InputStream openRawResource = this.$context.getResources().openRawResource(R.raw.beta_ota_public_key);
            InputStreamReader inputStreamReader = new InputStreamReader(openRawResource);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                Sequence<String> lineSequence = TextStreamsKt.lineSequence(bufferedReader);
                StringBuilder sb = new StringBuilder();
                for (String str : lineSequence) {
                    if (StringsKt.first(str) != '-') {
                        sb.append(str);
                    }
                }
                byte[] decodeBase64 = Base64.decodeBase64(sb.toString());
                CloseableKt.closeFinally(bufferedReader, null);
                CloseableKt.closeFinally(openRawResource, null);
                return decodeBase64;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
