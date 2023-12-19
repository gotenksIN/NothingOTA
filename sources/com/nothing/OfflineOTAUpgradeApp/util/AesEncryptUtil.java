package com.nothing.OfflineOTAUpgradeApp.util;

import androidx.autofill.HintConstants;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AesEncryptUtil.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0004J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/util/AesEncryptUtil;", "", "()V", AesEncryptUtil.AES, "", "AES_CBC_NO_PADDING", "AES_CBC_PKCS5_PADDING", "BYTE20", "", "BYTE3", "BYTE30", "BYTE4", "BYTE41", "BYTE5", "BYTE5A", "BYTE6", "BYTE63", "UTF8", "bKey", "", "bVector", "aesCbcNoPaddingEncrypt", "sSrc", "aesKey", "aesIV", "aesCbcPkcs5PaddingEncrypt", "srcContent", "keySpec", "Ljavax/crypto/spec/SecretKeySpec;", HintConstants.AUTOFILL_HINT_PASSWORD, "create128BitsIV", "Ljavax/crypto/spec/IvParameterSpec;", "iv", "create128BitsKey", "key", "NothingOfflineOtaUpdate_nothingRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AesEncryptUtil {
    private static final String AES = "AES";
    private static final String AES_CBC_NO_PADDING = "AES/CBC/NoPadding";
    private static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";
    private static final byte BYTE20 = 32;
    private static final byte BYTE3 = 3;
    private static final byte BYTE4 = 4;
    private static final byte BYTE5 = 5;
    private static final byte BYTE6 = 6;
    private static final String UTF8 = "UTF-8";
    public static final AesEncryptUtil INSTANCE = new AesEncryptUtil();
    private static final byte BYTE30 = 48;
    private static final byte BYTE5A = 90;
    private static final byte BYTE41 = 65;
    private static final byte[] bKey = {BYTE30, 49, 49, 50, 103, BYTE5A, 104, 71, 71, 71, BYTE41, 53, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte BYTE63 = 99;
    private static final byte[] bVector = {49, BYTE30, BYTE30, 51, BYTE63, 101, 32, 32, 32, 33, 33, 32, 32, 32, 32, 32};
    public static final int $stable = 8;

    private AesEncryptUtil() {
    }

    private final SecretKeySpec create128BitsKey(String str) {
        byte[] bArr;
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            bArr = stringBuffer2.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        return new SecretKeySpec(bArr, AES);
    }

    private final IvParameterSpec create128BitsIV(String str) {
        byte[] bArr;
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            bArr = stringBuffer2.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        return new IvParameterSpec(bArr);
    }

    public final byte[] aesCbcPkcs5PaddingEncrypt(byte[] srcContent, String password) throws Exception {
        Intrinsics.checkNotNullParameter(srcContent, "srcContent");
        Intrinsics.checkNotNullParameter(password, "password");
        return aesCbcPkcs5PaddingEncrypt(srcContent, create128BitsKey(password));
    }

    public final byte[] aesCbcPkcs5PaddingEncrypt(byte[] srcContent, SecretKeySpec keySpec) throws Exception {
        Intrinsics.checkNotNullParameter(srcContent, "srcContent");
        Intrinsics.checkNotNullParameter(keySpec, "keySpec");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bVector);
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
        cipher.init(1, keySpec, ivParameterSpec);
        Intrinsics.checkNotNullExpressionValue(cipher, "apply(...)");
        byte[] doFinal = cipher.doFinal(srcContent);
        Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
        return doFinal;
    }

    public final byte[] aesCbcNoPaddingEncrypt(byte[] sSrc, String aesKey, String aesIV) {
        Cipher cipher;
        Intrinsics.checkNotNullParameter(sSrc, "sSrc");
        Intrinsics.checkNotNullParameter(aesKey, "aesKey");
        Intrinsics.checkNotNullParameter(aesIV, "aesIV");
        int length = sSrc.length;
        while (length % 16 != 0) {
            length++;
        }
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            if (i < sSrc.length) {
                bArr[i] = sSrc[i];
            } else {
                bArr[i] = 0;
            }
        }
        SecretKeySpec create128BitsKey = create128BitsKey(aesKey);
        IvParameterSpec create128BitsIV = create128BitsIV(aesIV);
        try {
            cipher = Cipher.getInstance(AES_CBC_NO_PADDING);
            cipher.init(1, create128BitsKey, create128BitsIV);
        } catch (Exception e) {
            e.printStackTrace();
            cipher = null;
        }
        if (cipher != null) {
            try {
                return cipher.doFinal(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
