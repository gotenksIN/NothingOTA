package com.nothing.OfflineOTAUpgradeApp;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.provider.SearchIndexablesContract;
import android.provider.SearchIndexablesProvider;
import com.nothing.OfflineOTAUpgradeApp.p007ui.OTAUpdateActivity;

/* loaded from: classes2.dex */
public class FeedbackSettingsIndexablesProvider extends SearchIndexablesProvider {
    public boolean onCreate() {
        return true;
    }

    public Cursor queryXmlResources(String[] strArr) {
        return null;
    }

    public Cursor queryNonIndexableKeys(String[] strArr) {
        return new MatrixCursor(SearchIndexablesContract.NON_INDEXABLES_KEYS_COLUMNS);
    }

    public Cursor queryRawData(String[] strArr) {
        MatrixCursor matrixCursor = new MatrixCursor(SearchIndexablesContract.INDEXABLES_RAW_COLUMNS);
        Context context = getContext();
        Object[] objArr = new Object[SearchIndexablesContract.INDEXABLES_RAW_COLUMNS.length];
        objArr[12] = context.getString(C1640R.string.app_name);
        objArr[1] = context.getString(C1640R.string.app_name);
        objArr[6] = context.getString(C1640R.string.header_category_system);
        objArr[5] = context.getString(C1640R.string.app_name);
        objArr[9] = OTAUpdateActivity.SETTINGS_SEARCH_INTENT;
        objArr[10] = getContext().getApplicationInfo().packageName;
        objArr[11] = OTAUpdateActivity.class.getName();
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }
}
