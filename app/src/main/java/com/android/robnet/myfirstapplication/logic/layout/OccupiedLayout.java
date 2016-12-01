package com.android.robnet.myfirstapplication.logic.layout;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class OccupiedLayout extends StateLayout {

    public static int STATE_OCCUPIED = 3;
    private static OccupiedLayout INSTANCE = null;
    private static String STATUS = "OCCUPIED";

    private OccupiedLayout() {}

    public static OccupiedLayout getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new OccupiedLayout();
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
