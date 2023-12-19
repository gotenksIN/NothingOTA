package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m41d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0014\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0016\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, m40d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-oBK06Vg", "sortArray--nroSd4", "sortArray-Aa5vz7o", "kotlin-stdlib"}, m39k = 2, m38mv = {1, 9, 0}, m36xi = 48)
/* renamed from: kotlin.collections.UArraySortingKt */
/* loaded from: classes2.dex */
public final class UArraySorting {
    /* renamed from: partition-4UcCI2c  reason: not valid java name */
    private static final int m6105partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m5725getw2LRezQ = UByteArray.m5725getw2LRezQ(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = m5725getw2LRezQ & 255;
                if (Intrinsics.compare(UByteArray.m5725getw2LRezQ(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m5725getw2LRezQ(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m5725getw2LRezQ2 = UByteArray.m5725getw2LRezQ(bArr, i);
                UByteArray.m5730setVurrAj0(bArr, i, UByteArray.m5725getw2LRezQ(bArr, i2));
                UByteArray.m5730setVurrAj0(bArr, i2, m5725getw2LRezQ2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-4UcCI2c  reason: not valid java name */
    private static final void m6109quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m6105partition4UcCI2c = m6105partition4UcCI2c(bArr, i, i2);
        int i3 = m6105partition4UcCI2c - 1;
        if (i < i3) {
            m6109quickSort4UcCI2c(bArr, i, i3);
        }
        if (m6105partition4UcCI2c < i2) {
            m6109quickSort4UcCI2c(bArr, m6105partition4UcCI2c, i2);
        }
    }

    /* renamed from: partition-Aa5vz7o  reason: not valid java name */
    private static final int m6106partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m5988getMh2AYeg = UShortArray.m5988getMh2AYeg(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m5988getMh2AYeg2 = UShortArray.m5988getMh2AYeg(sArr, i) & UShort.MAX_VALUE;
                i3 = m5988getMh2AYeg & UShort.MAX_VALUE;
                if (Intrinsics.compare(m5988getMh2AYeg2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m5988getMh2AYeg(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m5988getMh2AYeg3 = UShortArray.m5988getMh2AYeg(sArr, i);
                UShortArray.m5993set01HTLdE(sArr, i, UShortArray.m5988getMh2AYeg(sArr, i2));
                UShortArray.m5993set01HTLdE(sArr, i2, m5988getMh2AYeg3);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-Aa5vz7o  reason: not valid java name */
    private static final void m6110quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m6106partitionAa5vz7o = m6106partitionAa5vz7o(sArr, i, i2);
        int i3 = m6106partitionAa5vz7o - 1;
        if (i < i3) {
            m6110quickSortAa5vz7o(sArr, i, i3);
        }
        if (m6106partitionAa5vz7o < i2) {
            m6110quickSortAa5vz7o(sArr, m6106partitionAa5vz7o, i2);
        }
    }

    /* renamed from: partition-oBK06Vg  reason: not valid java name */
    private static final int m6107partitionoBK06Vg(int[] iArr, int i, int i2) {
        int m5804getpVg5ArA = UIntArray.m5804getpVg5ArA(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (Integer.compareUnsigned(UIntArray.m5804getpVg5ArA(iArr, i), m5804getpVg5ArA) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m5804getpVg5ArA(iArr, i2), m5804getpVg5ArA) > 0) {
                i2--;
            }
            if (i <= i2) {
                int m5804getpVg5ArA2 = UIntArray.m5804getpVg5ArA(iArr, i);
                UIntArray.m5809setVXSXFK8(iArr, i, UIntArray.m5804getpVg5ArA(iArr, i2));
                UIntArray.m5809setVXSXFK8(iArr, i2, m5804getpVg5ArA2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort-oBK06Vg  reason: not valid java name */
    private static final void m6111quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m6107partitionoBK06Vg = m6107partitionoBK06Vg(iArr, i, i2);
        int i3 = m6107partitionoBK06Vg - 1;
        if (i < i3) {
            m6111quickSortoBK06Vg(iArr, i, i3);
        }
        if (m6107partitionoBK06Vg < i2) {
            m6111quickSortoBK06Vg(iArr, m6107partitionoBK06Vg, i2);
        }
    }

    /* renamed from: partition--nroSd4  reason: not valid java name */
    private static final int m6104partitionnroSd4(long[] jArr, int i, int i2) {
        long m5883getsVKNKU = ULongArray.m5883getsVKNKU(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (Long.compareUnsigned(ULongArray.m5883getsVKNKU(jArr, i), m5883getsVKNKU) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m5883getsVKNKU(jArr, i2), m5883getsVKNKU) > 0) {
                i2--;
            }
            if (i <= i2) {
                long m5883getsVKNKU2 = ULongArray.m5883getsVKNKU(jArr, i);
                ULongArray.m5888setk8EXiF4(jArr, i, ULongArray.m5883getsVKNKU(jArr, i2));
                ULongArray.m5888setk8EXiF4(jArr, i2, m5883getsVKNKU2);
                i++;
                i2--;
            }
        }
        return i;
    }

    /* renamed from: quickSort--nroSd4  reason: not valid java name */
    private static final void m6108quickSortnroSd4(long[] jArr, int i, int i2) {
        int m6104partitionnroSd4 = m6104partitionnroSd4(jArr, i, i2);
        int i3 = m6104partitionnroSd4 - 1;
        if (i < i3) {
            m6108quickSortnroSd4(jArr, i, i3);
        }
        if (m6104partitionnroSd4 < i2) {
            m6108quickSortnroSd4(jArr, m6104partitionnroSd4, i2);
        }
    }

    /* renamed from: sortArray-4UcCI2c  reason: not valid java name */
    public static final void m6113sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m6109quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o  reason: not valid java name */
    public static final void m6114sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m6110quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg  reason: not valid java name */
    public static final void m6115sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m6111quickSortoBK06Vg(array, i, i2 - 1);
    }

    /* renamed from: sortArray--nroSd4  reason: not valid java name */
    public static final void m6112sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m6108quickSortnroSd4(array, i, i2 - 1);
    }
}
