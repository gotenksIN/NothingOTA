package com.nothing.OfflineOTAUpgradeApp.util;

import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.binary.Base64;

/* compiled from: RSAUtil.kt */
@Metadata(m41d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/util/RSAUtil;", "", "()V", "ALGORITHM_RSA", "", "CIPHER_TRANSFORMATION", "UTF8", "encryptionByPublicKey", "source", "key", "", "getPublicKey", "Ljava/security/PublicKey;", "publicKey", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public final class RSAUtil {
    public static final int $stable = 0;
    private static final String ALGORITHM_RSA = "RSA";
    private static final String CIPHER_TRANSFORMATION = "RSA/ECB/PKCS1Padding";
    public static final RSAUtil INSTANCE = new RSAUtil();
    private static final String UTF8 = "UTF-8";

    private RSAUtil() {
    }

    public final String encryptionByPublicKey(String source, byte[] key) throws Exception {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(key, "key");
        PublicKey publicKey = getPublicKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
        cipher.init(1, publicKey);
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
        byte[] bytes = source.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        cipher.update(bytes);
        Intrinsics.checkNotNullExpressionValue(cipher, "apply(...)");
        byte[] doFinal = cipher.doFinal();
        Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
        String encodeBase64String = Base64.encodeBase64String(doFinal);
        Intrinsics.checkNotNullExpressionValue(encodeBase64String, "encodeBase64String(...)");
        return encodeBase64String;
    }

    public final PublicKey getPublicKey(byte[] publicKey) throws Exception {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
        Intrinsics.checkNotNullExpressionValue(keyFactory, "getInstance(...)");
        PublicKey generatePublic = keyFactory.generatePublic(x509EncodedKeySpec);
        Intrinsics.checkNotNullExpressionValue(generatePublic, "generatePublic(...)");
        return generatePublic;
    }
}
