package juzix.com.pltmodule.modules;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class GsonUtil {
    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    /**
     * @param jsonStr
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String jsonStr, Type type) {
        T t = null;
        try {
            t = gson.fromJson(jsonStr, type);
        } catch (Exception e) {
            Log.e("GsonUtil error", "json 数据解析出错" + e);
        }
        return t;
    }

    /**
     * 用例:
     * TypeToken<ArrayList<MyItem>> typeToken = new TypeToken<ArrayList<MyItem>>(){};
     * ArrayList<MyItem> arrayList = getArray(typeToken);
     *
     * @param jsonStr
     * @param typeToken
     * @param <T>
     * @return
     */
    public static <T> ArrayList<T> jsonToListObject(String jsonStr, TypeToken typeToken) {
        if (jsonStr != null) {
            try {
                return (ArrayList<T>) gson.fromJson(jsonStr, typeToken.getType());
            } catch (Exception e) {
                Log.e("GsonUtil error", "json 数据解析出错" + e);
            }
        }
        return null;
    }

// Map<String, City> citys = gson.fromJson(jsonStr, new TypeToken<Map<String, City>>() {}.getType());

    /**
     * 用例:
     * TypeToken<Map<T, Object>> typeToken = new TypeToken<Map<T, Object>>() {}.getType()
     * ArrayList<MyItem> arrayList = getArray(typeToken);
     *
     * @param jsonStr
     * @param typeToken
     * @param <T>
     * @return
     */
    public static <T>Map<T,Object> jsonToMap(String jsonStr, TypeToken typeToken){
        if (jsonStr != null) {
            try {
                return (Map<T,Object>) gson.fromJson(jsonStr, typeToken.getType());
            } catch (Exception e) {
                Log.e("GsonUtil error", "json 数据解析出错" + e);
            }
        }
        return null;
    }

    /**
     * @param object
     * @param type
     * @return 将object转换成json格式的字符串，并将该字符串返回
     */
    public static String objectToJson(Object object, Type type) {
        String s = null;
        try {
            s = gson.toJson(object, type);
        } catch (Exception e) {
            Log.e("GsonUtil error", "转换成json数据异常");
        }
        return s;
    }

    /**
     * @param list
     * @return 将List数据转换成Json数据格式的字符串并返回
     */
    public static String listToJson(List<String> list) {
        String str = null;
        try {
            str = gson.toJson(list);
        } catch (Exception e) {
            Log.e("GsonUtil error", "List转换json数据异常");
        }
        return str;
    }

    public static String toJson(Map<String, String> params) {
        JSONObject jsonObject = new JSONObject();
        if (params == null || params.isEmpty()) {
            return jsonObject.toString();
        }

        for (Map.Entry<String, String> entry : params.entrySet()) {
            try {
                jsonObject.put(entry.getKey(), entry.getValue());
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }

        return jsonObject.toString();
    }

    public static <T> T toData(String json, Type type) {

        return new Gson().fromJson(json, type);
    }

    public static String geJson(String json, String key) {
        try {
            JSONObject jsonObj = new JSONObject(json);
            return jsonObj.getJSONObject(key).toString();
        } catch (Exception exp) {
            exp.printStackTrace();
            return null;
        }
    }


    public static String getRandomId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 11);
    }

    public static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static Gson  getGson(){
        return builder.create();
    }
}
