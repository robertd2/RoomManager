package com.android.robnet.myfirstapplication.connection;

import com.android.robnet.myfirstapplication.common.CommonData;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class CommonDataFactory {

    private static Gson GSON = new Gson();
    private static long DEVICE_ID = -1;

    public static void setDeviceId(long id) {
        DEVICE_ID = id;
    }

    public static CommonData getRandomCommonData() {

        CommonData commonData = new CommonData();

        Random generator = new Random();
        int randomState = generator.nextInt(4);

        SecureRandom random = new SecureRandom();
        commonData.setNfcSerial(new BigInteger(130, random).toString(32));

        commonData.setRoomId(2137);
        commonData.setState(randomState);

        long ms = -946771200000L + (Math.abs(generator.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm");
        String time = localDateFormat.format(new Date(ms));

        commonData.setTime(time);

        return commonData;
    }

    public static CommonData getHelloCommonData() {

        CommonData commonData = new CommonData();

        commonData.setRoomId(DEVICE_ID);
        commonData.setState(0);

        return commonData;
    }

    public static String toJSON(CommonData commonData) {
        return GSON.toJson(commonData);
    }

    public static CommonData fromJSON(String response) {
        return GSON.fromJson(response, CommonData.class);
    }

    public static CommonData getNewCommonData() {
        CommonData commonData = new CommonData();

        commonData.setRoomId(DEVICE_ID);

        return commonData;
    }

}
