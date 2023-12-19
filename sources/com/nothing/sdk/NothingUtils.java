package com.nothing.sdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes2.dex */
public class NothingUtils {
    private static ArrayList<String> mNdotSupportList = new ArrayList<>(Arrays.asList(Locale.ENGLISH.getLanguage(), Locale.FRANCE.getLanguage(), Locale.GERMAN.getLanguage(), Locale.ITALIAN.getLanguage(), "af", "da", "es", "et", "fi", "tl", "nb", "sv", "nl", "ru", "uk", "bg", "sr", "be", "mk", "pt"));

    public static boolean isSupportNdot(String str) {
        return mNdotSupportList.contains(new Locale(str).getLanguage());
    }
}
