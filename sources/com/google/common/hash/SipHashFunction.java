package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    private final int f244c;

    /* renamed from: d */
    private final int f245d;

    /* renamed from: k0 */
    private final long f246k0;

    /* renamed from: k1 */
    private final long f247k1;

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SipHashFunction(int i, int i2, long j, long j2) {
        Preconditions.checkArgument(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        Preconditions.checkArgument(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.f244c = i;
        this.f245d = i2;
        this.f246k0 = j;
        this.f247k1 = j2;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f244c, this.f245d, this.f246k0, this.f247k1);
    }

    public String toString() {
        int i = this.f244c;
        int i2 = this.f245d;
        long j = this.f246k0;
        return new StringBuilder(81).append("Hashing.sipHash").append(i).append(i2).append("(").append(j).append(", ").append(this.f247k1).append(")").toString();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) obj;
            return this.f244c == sipHashFunction.f244c && this.f245d == sipHashFunction.f245d && this.f246k0 == sipHashFunction.f246k0 && this.f247k1 == sipHashFunction.f247k1;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((getClass().hashCode() ^ this.f244c) ^ this.f245d) ^ this.f246k0) ^ this.f247k1);
    }

    /* loaded from: classes2.dex */
    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b */
        private long f248b;

        /* renamed from: c */
        private final int f249c;

        /* renamed from: d */
        private final int f250d;
        private long finalM;

        /* renamed from: v0 */
        private long f251v0;

        /* renamed from: v1 */
        private long f252v1;

        /* renamed from: v2 */
        private long f253v2;

        /* renamed from: v3 */
        private long f254v3;

        SipHasher(int i, int i2, long j, long j2) {
            super(8);
            this.f248b = 0L;
            this.finalM = 0L;
            this.f249c = i;
            this.f250d = i2;
            this.f251v0 = 8317987319222330741L ^ j;
            this.f252v1 = 7237128888997146477L ^ j2;
            this.f253v2 = 7816392313619706465L ^ j;
            this.f254v3 = 8387220255154660723L ^ j2;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer byteBuffer) {
            this.f248b += 8;
            processM(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer byteBuffer) {
            this.f248b += byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.finalM ^= (byteBuffer.get() & 255) << i;
                i += 8;
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected HashCode makeHash() {
            long j = this.finalM ^ (this.f248b << 56);
            this.finalM = j;
            processM(j);
            this.f253v2 ^= 255;
            sipRound(this.f250d);
            return HashCode.fromLong(((this.f251v0 ^ this.f252v1) ^ this.f253v2) ^ this.f254v3);
        }

        private void processM(long j) {
            this.f254v3 ^= j;
            sipRound(this.f249c);
            this.f251v0 = j ^ this.f251v0;
        }

        private void sipRound(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f251v0;
                long j2 = this.f252v1;
                this.f251v0 = j + j2;
                this.f253v2 += this.f254v3;
                this.f252v1 = Long.rotateLeft(j2, 13);
                long rotateLeft = Long.rotateLeft(this.f254v3, 16);
                long j3 = this.f252v1;
                long j4 = this.f251v0;
                this.f252v1 = j3 ^ j4;
                this.f254v3 = rotateLeft ^ this.f253v2;
                long rotateLeft2 = Long.rotateLeft(j4, 32);
                long j5 = this.f253v2;
                long j6 = this.f252v1;
                this.f253v2 = j5 + j6;
                this.f251v0 = rotateLeft2 + this.f254v3;
                this.f252v1 = Long.rotateLeft(j6, 17);
                long rotateLeft3 = Long.rotateLeft(this.f254v3, 21);
                long j7 = this.f252v1;
                long j8 = this.f253v2;
                this.f252v1 = j7 ^ j8;
                this.f254v3 = rotateLeft3 ^ this.f251v0;
                this.f253v2 = Long.rotateLeft(j8, 32);
            }
        }
    }
}
