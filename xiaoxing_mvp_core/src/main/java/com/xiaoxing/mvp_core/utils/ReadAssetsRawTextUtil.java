package com.xiaoxing.mvp_core.utils;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 描述：读取Access、Raw text文件工具类
 * 作者：xiaoxing on 17/4/8 09:42
 * 邮箱：2235445233@qq.com
 */
public class ReadAssetsRawTextUtil {

    /**
     * 从assets中读取txt
     */
    public static String readFromAssets(Activity activity, String filename) {
        String text = null;
        try {
            InputStream is = activity.getAssets().open(filename);
            text = readTextFromSDcard(is);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * 从raw中读取txt
     */
    private String readFromRaw(Activity activity, int rawid) {
        String text = null;
        try {
            InputStream is = activity.getResources().openRawResource(rawid);
            text = readTextFromSDcard(is);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    /**
     * 按行读取txt
     *
     * @param is
     * @return
     * @throws Exception
     */
    private static String readTextFromSDcard(InputStream is) throws Exception {
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
            buffer.append("\n");
        }
        return buffer.toString();
    }

}
