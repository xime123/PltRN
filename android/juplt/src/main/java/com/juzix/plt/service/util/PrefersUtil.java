package com.juzix.plt.service.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PrefersUtil {

    public static HashMap<String, String> getStrings(Context context, String prefersName, HashMap<String, String> prefers) {
        SharedPreferences              settings = context.getSharedPreferences(prefersName, 0);
        Set<Map.Entry<String, String>> entries  = prefers.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            entry.setValue(settings.getString(entry.getKey(), entry.getValue()));
        }

        return prefers;
    }

    public static String getString(Context context, String prefersName, String name, String defaultValue) {
        SharedPreferences settings = context.getSharedPreferences(prefersName, 0);
        return settings.getString(name, defaultValue);
    }

    public static long getLong(Context context, String prefersName, String name, long defalutValue) {
        SharedPreferences settings = context.getSharedPreferences(prefersName, 0);
        return settings.getLong(name, defalutValue);
    }

    public static int getInt(Context context, String prefersName, String name, int defalutValue) {
        SharedPreferences settings = context.getSharedPreferences(prefersName, 0);
        return settings.getInt(name, defalutValue);
    }

    public static boolean getBoolean(Context context, String prefersName, String name, boolean defalutValue) {
        SharedPreferences settings = context.getSharedPreferences(prefersName, 0);

        return settings.getBoolean(name, defalutValue);
    }

    public static boolean setStrings(Context context, String prefersName, HashMap<String, String> prefers) {
        SharedPreferences              settings = context.getSharedPreferences(prefersName, 0);
        SharedPreferences.Editor       editor   = settings.edit();
        Set<Map.Entry<String, String>> entries  = prefers.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            editor.putString(entry.getKey(), entry.getValue());
        }

        return editor.commit();
    }

    public static boolean setString(Context context, String prefersName, String name, String value) {
        SharedPreferences        settings = context.getSharedPreferences(prefersName, 0);
        SharedPreferences.Editor editor   = settings.edit();
        editor.putString(name, value);

        return editor.commit();
    }

    public static boolean setLong(Context context, String prefersName, String name, long value) {
        SharedPreferences        settings = context.getSharedPreferences(prefersName, 0);
        SharedPreferences.Editor editor   = settings.edit();
        editor.putLong(name, value);

        return editor.commit();
    }

    public static boolean setInt(Context context, String prefersName, String name, int value) {
        SharedPreferences        settings = context.getSharedPreferences(prefersName, 0);
        SharedPreferences.Editor editor   = settings.edit();
        editor.putInt(name, value);

        return editor.commit();
    }

    public static boolean setBoolean(Context context, String prefersName, String name, boolean value) {
        SharedPreferences        settings = context.getSharedPreferences(prefersName, 0);
        SharedPreferences.Editor editor   = settings.edit();
        editor.putBoolean(name, value);

        return editor.commit();
    }
}
