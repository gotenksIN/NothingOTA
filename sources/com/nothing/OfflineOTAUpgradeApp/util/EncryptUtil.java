package com.nothing.OfflineOTAUpgradeApp.util;

import java.io.File;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p008io.Closeable;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.codec.digest.DigestUtils;

/* compiled from: EncryptUtil.kt */
@Metadata(m41d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\bJ&\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012J\u0019\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J!\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/util/EncryptUtil;", "", "()V", "KEY_PAIR_ID", "", "encryptData", "raw", "secretKey", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateSign", "version", "", "cipher", "data", "timestamp", "", "getCheckSum", "file", "Ljava/io/File;", "getCheckSumSuspend", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEncryptCipher", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPublicKeySuspend", "", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "random128BitsString", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public final class EncryptUtil {
    public static final int $stable = 0;
    public static final EncryptUtil INSTANCE = new EncryptUtil();
    public static final String KEY_PAIR_ID = "sONmqM3m";

    private EncryptUtil() {
    }

    public final String generateSign(int i, String cipher, String data, long j) {
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        Intrinsics.checkNotNullParameter(data, "data");
        StringBuilder sb = new StringBuilder();
        sb.append("version:" + i);
        if (!StringsKt.isBlank(cipher)) {
            sb.append("&cipher:" + cipher);
        }
        if (!StringsKt.isBlank(data)) {
            sb.append("&data:" + data);
        }
        if (j > 0) {
            sb.append("&timestamp:" + j);
        }
        String md5Hex = DigestUtils.md5Hex(sb.toString());
        Intrinsics.checkNotNull(md5Hex);
        return md5Hex;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getEncryptCipher(android.content.Context r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getEncryptCipher$1
            if (r0 == 0) goto L14
            r0 = r7
            com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getEncryptCipher$1 r0 = (com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getEncryptCipher$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getEncryptCipher$1 r0 = new com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getEncryptCipher$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r4.getPublicKeySuspend(r5, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            byte[] r7 = (byte[]) r7
            int r5 = r7.length
            if (r5 != 0) goto L4b
            goto L4c
        L4b:
            r3 = 0
        L4c:
            if (r3 == 0) goto L51
            java.lang.String r5 = ""
            return r5
        L51:
            com.nothing.OfflineOTAUpgradeApp.util.RSAUtil r5 = com.nothing.OfflineOTAUpgradeApp.util.RSAUtil.INSTANCE
            java.lang.String r5 = r5.encryptionByPublicKey(r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil.getEncryptCipher(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getPublicKeySuspend(android.content.Context r6, kotlin.coroutines.Continuation<? super byte[]> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getPublicKeySuspend$1
            if (r0 == 0) goto L14
            r0 = r7
            com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getPublicKeySuspend$1 r0 = (com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getPublicKeySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getPublicKeySuspend$1 r0 = new com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getPublicKeySuspend$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4c
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getPublicKeySuspend$2 r2 = new com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$getPublicKeySuspend$2
            r4 = 0
            r2.<init>(r6, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L4c
            return r1
        L4c:
            java.lang.String r6 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil.getPublicKeySuspend(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object encryptData(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super java.lang.String> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$encryptData$1
            if (r0 == 0) goto L14
            r0 = r8
            com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$encryptData$1 r0 = (com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$encryptData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$encryptData$1 r0 = new com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$encryptData$1
            r0.<init>(r5, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4c
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getDefault()
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$encryptData$2 r2 = new com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil$encryptData$2
            r4 = 0
            r2.<init>(r6, r7, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L4c
            return r1
        L4c:
            java.lang.String r6 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.OfflineOTAUpgradeApp.util.EncryptUtil.encryptData(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String random128BitsString() {
        return RandomUtil.generateRandomString(16);
    }

    public final Object getCheckSumSuspend(File file, Continuation<? super String> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EncryptUtil$getCheckSumSuspend$2(file, null), continuation);
    }

    public final String getCheckSum(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            String md5Hex = DigestUtils.md5Hex(fileInputStream);
            Closeable.closeFinally(fileInputStream, null);
            Intrinsics.checkNotNullExpressionValue(md5Hex, "use(...)");
            return md5Hex;
        } finally {
        }
    }
}
