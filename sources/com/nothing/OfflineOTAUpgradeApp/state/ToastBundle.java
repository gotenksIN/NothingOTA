package com.nothing.OfflineOTAUpgradeApp.state;

import android.content.Context;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToastBundle.kt */
@Metadata(m41d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/ToastBundle;", "", "messageRes", "", "message", "", "messageParams", "", "(ILjava/lang/String;[Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getMessageParams", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getMessageRes", "()I", "component1", "component2", "component3", "copy", "(ILjava/lang/String;[Ljava/lang/String;)Lcom/nothing/OfflineOTAUpgradeApp/state/ToastBundle;", "equals", "", "other", "context", "Landroid/content/Context;", "hashCode", "toString", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public final class ToastBundle {
    public static final int $stable = 8;
    private final String message;
    private final String[] messageParams;
    private final int messageRes;

    public ToastBundle() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ ToastBundle copy$default(ToastBundle toastBundle, int i, String str, String[] strArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = toastBundle.messageRes;
        }
        if ((i2 & 2) != 0) {
            str = toastBundle.message;
        }
        if ((i2 & 4) != 0) {
            strArr = toastBundle.messageParams;
        }
        return toastBundle.copy(i, str, strArr);
    }

    public final int component1() {
        return this.messageRes;
    }

    public final String component2() {
        return this.message;
    }

    public final String[] component3() {
        return this.messageParams;
    }

    public final ToastBundle copy(int i, String message, String[] messageParams) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(messageParams, "messageParams");
        return new ToastBundle(i, message, messageParams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToastBundle) {
            ToastBundle toastBundle = (ToastBundle) obj;
            return this.messageRes == toastBundle.messageRes && Intrinsics.areEqual(this.message, toastBundle.message) && Intrinsics.areEqual(this.messageParams, toastBundle.messageParams);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.messageRes) * 31) + this.message.hashCode()) * 31) + Arrays.hashCode(this.messageParams);
    }

    public String toString() {
        return "ToastBundle(messageRes=" + this.messageRes + ", message=" + this.message + ", messageParams=" + Arrays.toString(this.messageParams) + ')';
    }

    public ToastBundle(int i, String message, String[] messageParams) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(messageParams, "messageParams");
        this.messageRes = i;
        this.message = message;
        this.messageParams = messageParams;
    }

    public /* synthetic */ ToastBundle(int i, String str, String[] strArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? new String[0] : strArr);
    }

    public final int getMessageRes() {
        return this.messageRes;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String[] getMessageParams() {
        return this.messageParams;
    }

    public final String getMessage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = this.messageRes;
        if (i != 0) {
            String string = context.getString(i, this.messageParams);
            Intrinsics.checkNotNull(string);
            return string;
        }
        return this.message;
    }
}
