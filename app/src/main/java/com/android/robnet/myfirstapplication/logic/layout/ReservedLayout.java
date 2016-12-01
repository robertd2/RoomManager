package com.android.robnet.myfirstapplication.logic.layout;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class ReservedLayout extends StateLayout {

    public static int STATE_RESERVED = 2;
    private static ReservedLayout INSTANCE = null;

    private static String STATUS = "RESERVED";

    private ReservedLayout() {}

    public static ReservedLayout getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ReservedLayout();
        }

        return INSTANCE;
    }

    @Override
    public void setBackground(Layout layout) {

    }

    @Override
    public void setTime(Layout layout) {

    }

    @Override
    public void setHintText1(Layout layout) {
        layout.getScreenHint1().setText(STATUS);
    }

    @Override
    public void setHintText2(Layout layout) {

    }
}
