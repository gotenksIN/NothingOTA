package com.nothing.OfflineOTAUpgradeApp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.nothing.OfflineOTAUpgradeApp.p007ui.OTAUpdateActivity;

/* loaded from: classes2.dex */
public class TelephonySecreteCodeReceiver extends BroadcastReceiver {
    private static final String ACTION_TELEPHONY_SECRET_CODE = "android.provider.Telephony.SECRET_CODE";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_TELEPHONY_SECRET_CODE)) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://com.nothing.OfflineOTAUpgradeApp?isUserMode=" + intent.getData().getHost().equals("682")), context, OTAUpdateActivity.class);
            intent2.setFlags(268435456);
            context.startActivity(intent2);
        }
    }
}
