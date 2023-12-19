package com.nothing.OfflineOTAUpgradeApp.util;

import android.content.Context;
import com.nothing.OfflineOTAUpgradeApp.C1640R;
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
import kotlin.jvm.functions.Function2;
import kotlin.p008io.Closeable;
import kotlin.p008io.TextStreamsKt;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.codec.binary.Base64;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EncryptUtil.kt */
@Metadata(m41d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\u008a@"}, m40d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, m39k = 3, m38mv = {1, 9, 0}, m36xi = 48)
@DebugMetadata(m31c = "com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getPublicKeySuspend$2", m30f = "EncryptUtil.kt", m29i = {}, m28l = {}, m27m = "invokeSuspend", m26n = {}, m25s = {})
/* loaded from: classes2.dex */
public final class EncryptUtil$getPublicKeySuspend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
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
            InputStream openRawResource = this.$context.getResources().openRawResource(C1640R.raw.beta_ota_public_key);
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
                Closeable.closeFinally(bufferedReader, null);
                Closeable.closeFinally(openRawResource, null);
                return decodeBase64;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    Closeable.closeFinally(bufferedReader, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
