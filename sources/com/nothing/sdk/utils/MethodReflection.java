package com.nothing.sdk.utils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public class MethodReflection {
    private static final Map<String, Method> DECLARED_METHOD_CACHE = new ConcurrentReferenceHashMap(32);

    public static Method findMethod(Class<?> cls, String str) {
        return findMethod(cls, str, new Class[0]);
    }

    public static Method findMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method[] methods;
        Assert.notNull(cls, "Class must not be null");
        Assert.notNull(str, "Method name must not be null");
        Method method = DECLARED_METHOD_CACHE.get(cls.getName() + str + Arrays.toString(clsArr));
        if (method != null) {
            return method;
        }
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            for (Method method2 : cls2.isInterface() ? cls2.getMethods() : cls2.getDeclaredMethods()) {
                if (str.equals(method2.getName()) && (clsArr == null || Arrays.equals(clsArr, method2.getParameterTypes()))) {
                    DECLARED_METHOD_CACHE.put(cls.getName() + str + Arrays.toString(clsArr), method2);
                    return method2;
                }
            }
        }
        return null;
    }

    public static Object invokeMethod(Method method, Object obj) {
        return invokeMethod(method, obj, new Object[0]);
    }

    public static Object invokeMethod(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (ReflectiveOperationException e) {
            ExceptionUtil.handleReflectionException(e);
            return null;
        }
    }
}
