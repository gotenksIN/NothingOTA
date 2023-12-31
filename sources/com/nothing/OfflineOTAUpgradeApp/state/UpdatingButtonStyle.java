package com.nothing.OfflineOTAUpgradeApp.state;

import com.nothing.OfflineOTAUpgradeApp.C1640R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UpdatingButtonStyle.kt */
@Metadata(m41d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0015\u0016\u0017\u0018BM\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0003\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0004\u0019\u001a\u001b\u001c¨\u0006\u001d"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;", "", "borderColorRes", "", "borderColorDisableRes", "fillColorRes", "fillColorDisableRes", "textColorRes", "textColorDisableRes", "visible", "", "(IIIIIIZ)V", "getBorderColorDisableRes", "()I", "getBorderColorRes", "getFillColorDisableRes", "getFillColorRes", "getTextColorDisableRes", "getTextColorRes", "getVisible", "()Z", "Border", "Filled", "Hidden", "Transparent", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle$Border;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle$Filled;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle$Hidden;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle$Transparent;", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
/* loaded from: classes2.dex */
public abstract class UpdatingButtonStyle {
    public static final int $stable = 0;
    private final int borderColorDisableRes;
    private final int borderColorRes;
    private final int fillColorDisableRes;
    private final int fillColorRes;
    private final int textColorDisableRes;
    private final int textColorRes;
    private final boolean visible;

    public /* synthetic */ UpdatingButtonStyle(int i, int i2, int i3, int i4, int i5, int i6, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, i5, i6, z);
    }

    private UpdatingButtonStyle(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        this.borderColorRes = i;
        this.borderColorDisableRes = i2;
        this.fillColorRes = i3;
        this.fillColorDisableRes = i4;
        this.textColorRes = i5;
        this.textColorDisableRes = i6;
        this.visible = z;
    }

    public /* synthetic */ UpdatingButtonStyle(int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i7 & 2) != 0 ? 0 : i2, i3, (i7 & 8) != 0 ? 0 : i4, i5, (i7 & 32) != 0 ? 0 : i6, (i7 & 64) != 0 ? true : z, null);
    }

    public final int getBorderColorRes() {
        return this.borderColorRes;
    }

    public final int getBorderColorDisableRes() {
        return this.borderColorDisableRes;
    }

    public final int getFillColorRes() {
        return this.fillColorRes;
    }

    public final int getFillColorDisableRes() {
        return this.fillColorDisableRes;
    }

    public final int getTextColorRes() {
        return this.textColorRes;
    }

    public final int getTextColorDisableRes() {
        return this.textColorDisableRes;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    /* compiled from: UpdatingButtonStyle.kt */
    @Metadata(m41d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle$Border;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class Border extends UpdatingButtonStyle {
        public static final int $stable = 0;
        public static final Border INSTANCE = new Border();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Border) {
                Border border = (Border) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -598526912;
        }

        public String toString() {
            return "Border";
        }

        private Border() {
            super(C1640R.color.updating_button_border_border, C1640R.color.updating_button_border_border_disable, C1640R.color.updating_button_border_color, 0, C1640R.color.updating_button_border_text, C1640R.color.updating_button_border_text_disable, false, 72, null);
        }
    }

    /* compiled from: UpdatingButtonStyle.kt */
    @Metadata(m41d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle$Filled;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class Filled extends UpdatingButtonStyle {
        public static final int $stable = 0;
        public static final Filled INSTANCE = new Filled();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Filled) {
                Filled filled = (Filled) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -489722506;
        }

        public String toString() {
            return "Filled";
        }

        private Filled() {
            super(C1640R.color.updating_button_filled_border, C1640R.color.updating_button_filled_border_disable, C1640R.color.updating_button_filled_color, C1640R.color.updating_button_filled_color_disable, C1640R.color.updating_button_filled_text, C1640R.color.updating_button_filled_text_disable, false, 64, null);
        }
    }

    /* compiled from: UpdatingButtonStyle.kt */
    @Metadata(m41d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle$Transparent;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class Transparent extends UpdatingButtonStyle {
        public static final int $stable = 0;
        public static final Transparent INSTANCE = new Transparent();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Transparent) {
                Transparent transparent = (Transparent) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 2058258878;
        }

        public String toString() {
            return "Transparent";
        }

        private Transparent() {
            super(C1640R.color.updating_button_transparent_border, 0, C1640R.color.updating_button_transparent_color, 0, C1640R.color.updating_button_transparent_text, C1640R.color.updating_button_transparent_text_disable, false, 74, null);
        }
    }

    /* compiled from: UpdatingButtonStyle.kt */
    @Metadata(m41d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, m40d2 = {"Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle$Hidden;", "Lcom/nothing/OfflineOTAUpgradeApp/state/UpdatingButtonStyle;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "NothingOfflineOtaUpdate_nothingRelease"}, m39k = 1, m38mv = {1, 9, 0}, m36xi = 48)
    /* loaded from: classes2.dex */
    public static final class Hidden extends UpdatingButtonStyle {
        public static final int $stable = 0;
        public static final Hidden INSTANCE = new Hidden();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Hidden) {
                Hidden hidden = (Hidden) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -432710210;
        }

        public String toString() {
            return "Hidden";
        }

        private Hidden() {
            super(C1640R.color.updating_button_hidden_border, 0, C1640R.color.updating_button_hidden_color, 0, C1640R.color.updating_button_hidden_text, 0, false, 42, null);
        }
    }
}
