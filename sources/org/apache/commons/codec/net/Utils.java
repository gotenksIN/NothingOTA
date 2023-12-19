package org.apache.commons.codec.net;

import org.apache.commons.codec.DecoderException;

/* loaded from: classes2.dex */
class Utils {
    Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int digit16(byte b) throws DecoderException {
        int digit = Character.digit((char) b, 16);
        if (digit != -1) {
            return digit;
        }
        throw new DecoderException(new StringBuffer("Invalid URL encoding: not a valid digit (radix 16): ").append((int) b).toString());
    }
}
