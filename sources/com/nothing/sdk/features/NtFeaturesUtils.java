package com.nothing.sdk.features;

import com.nothing.sdk.utils.ClassReflection;
import com.nothing.sdk.utils.FieldReflection;
import com.nothing.sdk.utils.MethodReflection;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class NtFeaturesUtils {
    public static boolean isSupport(String str) {
        Class findClass = ClassReflection.findClass("com.nothing.NtFeaturesUtils");
        Field findField = FieldReflection.findField(findClass, str, Integer.TYPE);
        if (findField != null) {
            int intValue = ((Integer) FieldReflection.getField(findField, null)).intValue();
            Method findMethod = MethodReflection.findMethod(findClass, "isSupport", int[].class);
            if (findMethod != null) {
                return ((Boolean) MethodReflection.invokeMethod(findMethod, null, new int[]{intValue})).booleanValue();
            }
        }
        return false;
    }
}
