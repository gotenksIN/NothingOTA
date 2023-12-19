package com.google.common.p006io;

import java.io.IOException;

@ElementTypesAreNonnullByDefault
/* renamed from: com.google.common.io.LineProcessor */
/* loaded from: classes2.dex */
public interface LineProcessor<T> {
    @ParametricNullness
    T getResult();

    boolean processLine(String str) throws IOException;
}
