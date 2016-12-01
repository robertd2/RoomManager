package com.android.robnet.myfirstapplication;

/**
 * Created by rober on 29.11.2016.
 */

public class ConnectionUtils {

    private static Integer state = 0;

    /**
     * Temporary mock return
     * @param message
     * @return
     */
    public static String getRoomNameFromResponse(String message) {
        //implementation waits for known message format
        return "MT4 10.9 CUMMIN";
    }

    public static int getRoomStateFromResponse(String message) {
        //implementation waits for known message format

        if (state == null) {
            state = 0;
        } else {
            switch (state) {
                case 0:
                    state = 1;
                    break;
                case 1:
                    state = 2;
                    break;
                case 2:
                    state = 3;
                    break;
                case 3:
                    state = 1;
                    break;
                default:
                    state = 0;
            }
        }

        return state;
    }
}
