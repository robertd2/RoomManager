package com.android.robnet.myfirstapplication.logic.layout;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class UnknownLayout extends StateLayout {

    public static int STATE_UNKNOWN = 0;
    private static UnknownLayout INSTANCE = null;

    private static String STATUS = "UNKNOWN";

    private UnknownLayout() {}

    public static UnknownLayout getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new UnknownLayout();
        }

        return INSTANCE;
    }

    @Override
    public void setBackground(Layout layout) {

    }

    @Override
    public void setHintText1(Layout layout) {
        layout.getScreenHint1().setText("THE NEAREST FREE ROOM");
    }

    @Override
    public void setHintText2(Layout layout) {
        layout.getScreenHint2().setText(layout.getCommonData().getTheNearestEmptyRoom());
    }

    @Override
    public void setRoomStatus(Layout layout) {
        layout.getScreenHint1().setText(STATUS);
    }
}
