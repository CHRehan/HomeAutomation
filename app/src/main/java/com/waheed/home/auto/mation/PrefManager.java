package com.waheed.home.auto.mation;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PrefManager {
    public static final String IP = "IP";
    public static final String PIN_10 = "PIN_10";
    public static final String PIN_11 = "PIN_11";
    public static final String PIN_12 = "PIN_12";
    public static final String PIN_13 = "PIN_13";
    public static final String PIN_14 = "PIN_14";
    public static final String PREF_NAME = "APP_PREF";
    public static PrefManager prefManager;

    private SharedPreferences pref;
    private Editor editor;

    public static PrefManager getInstance(Context context) {
        if (prefManager == null) {
            prefManager = new PrefManager(context);
        }
        return prefManager;
    }

    private PrefManager(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, 0);
        editor = pref.edit();
        editor.apply();
    }

    public void setIP(String str) {
        this.editor.putString(IP, str);
        this.editor.commit();
    }

    public String getIP() {
        return this.pref.getString(IP, null);
    }

    public void setPin10(Boolean bool) {
        this.editor.putBoolean(PIN_10, bool);
        this.editor.commit();
    }

    public Boolean getPin10() {
        return this.pref.getBoolean(PIN_10, false);
    }

    public void setPin11(Boolean bool) {
        this.editor.putBoolean(PIN_11, bool);
        this.editor.commit();
    }

    public Boolean getPin11() {
        return this.pref.getBoolean(PIN_11, false);
    }

    public void setPin12(Boolean bool) {
        this.editor.putBoolean(PIN_12, bool);
        this.editor.commit();
    }

    public Boolean getPin12() {
        return this.pref.getBoolean(PIN_12, false);
    }

    public void setPin13(Boolean bool) {
        this.editor.putBoolean(PIN_13, bool);
        this.editor.commit();
    }

    public Boolean getPin13() {
        return this.pref.getBoolean(PIN_13, false);
    }

    public void setPin14(Boolean bool) {
        this.editor.putBoolean(PIN_14, bool);
        this.editor.commit();
    }

    public Boolean getPin14() {
        return this.pref.getBoolean(PIN_14, false);
    }

    public void deletAllPref() {
        this.editor.clear();
        this.editor.commit();
        this.editor.apply();
    }
}
