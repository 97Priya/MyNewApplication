package application.example.mynewapplication.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

import application.example.mynewapplication.util.ConstantUtil;

public class SharedPrefUtil {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public SharedPrefUtil(Context context) {
        mSharedPreferences = context.getSharedPreferences(ConstantUtil.SHARED_PREF_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public String getSharedPrefUtil(String key) {
        Map<String, ?> allEntries = mSharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            if (entry.getKey().equals(key)) {
                return entry.getValue().toString();
            }
        }
        return null;
    }

    public void setSharedPrefUtil(String key, String value) {
        if (!(mSharedPreferences.contains(key))) {
            mEditor.putString(key, value);
            mEditor.commit();
        }
    }

    public void setSharedPrefUtil(String key, int value) {
        if (!(mSharedPreferences.contains(key))) {
            mEditor.putInt(key, value);
            mEditor.commit();
        }
    }

    public void setSharedPrefUtil(String key, Boolean value) {
        if (!(mSharedPreferences.contains(key))) {
            mEditor.putBoolean(key, value);
            mEditor.commit();
        }
    }

    public void setSharedPrefUtil(String key, Float value) {
        if (!(mSharedPreferences.contains(key))) {
            mEditor.putFloat(key, value);
            mEditor.commit();
        }
    }

    public void setSharedPrefUtil(String key, Long value) {
        if (!(mSharedPreferences.contains(key))) {
            mEditor.putLong(key, value);
            mEditor.commit();
        }
    }
}
