package com.nothing.sdk.onlineconfig;

import android.content.Context;
import android.os.Handler;
import com.nothing.sdk.utils.ClassReflection;
import com.nothing.sdk.utils.MethodReflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class ConfigObserver {
    private static final String CONFIG_OBSERVER = "com.nothing.onlineconfig.ConfigObserver";
    private static final String TAG = "ConfigObserver";
    private Class<?> mConfigObserverClass;
    private Object mConfigObserverInst;

    /* loaded from: classes2.dex */
    public interface ConfigUpdater {
        void updateConfig(JSONArray jSONArray);
    }

    public ConfigObserver(Context context, Handler handler, final ConfigUpdater configUpdater, String str) {
        try {
            Class<?> findClass = ClassReflection.findClass(CONFIG_OBSERVER);
            this.mConfigObserverClass = findClass;
            Class<?> findInnerClass = ClassReflection.findInnerClass(findClass, "ConfigUpdater");
            Constructor<?> constructor = this.mConfigObserverClass.getConstructor(Context.class, Handler.class, findInnerClass, String.class);
            constructor.setAccessible(true);
            this.mConfigObserverInst = constructor.newInstance(context, handler, Proxy.newProxyInstance(findInnerClass.getClassLoader(), new Class[]{findInnerClass}, new InvocationHandler() { // from class: com.nothing.sdk.onlineconfig.ConfigObserver.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    if ("updateConfig".equals(method.getName())) {
                        configUpdater.updateConfig((JSONArray) objArr[0]);
                        return null;
                    }
                    return null;
                }
            }), str);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e.toString());
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2.toString());
        } catch (RuntimeException e3) {
            throw new RuntimeException(e3.toString());
        } catch (Exception e4) {
            throw new RuntimeException(e4.toString());
        }
    }

    public void register() {
        MethodReflection.invokeMethod(MethodReflection.findMethod(this.mConfigObserverClass, "register"), this.mConfigObserverInst);
    }

    public void unregister() {
        MethodReflection.invokeMethod(MethodReflection.findMethod(this.mConfigObserverClass, "unregister"), this.mConfigObserverInst);
    }

    public void onChange(boolean z) {
        MethodReflection.invokeMethod(MethodReflection.findMethod(this.mConfigObserverClass, "onChange"), this.mConfigObserverInst);
    }
}
