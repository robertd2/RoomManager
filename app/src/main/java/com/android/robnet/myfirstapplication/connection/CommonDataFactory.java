package com.android.robnet.myfirstapplication.connection;

import com.android.robnet.myfirstapplication.common.CommonData;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class CommonDataFactory {

    private static Gson GSON = new Gson();

    public static CommonData getRandomCommonData() {

        CommonData commonData = new CommonData();

        commonData.setRoomId(2137);
        commonData.setNfcSerial("G6h0S3fbhU");
        commonData.setState(5);

        return commonData;
    }

    public static String toJSON(CommonData commonData) {
        return GSON.toJson(commonData);
    }

    public static CommonData fromJSON(String response) {
        return GSON.fromJson(response, CommonData.class);
    }

}
