package com.android.robnet.myfirstapplication.logic.layout;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class AvailableLayout implements StateLayout {

    public static int STATE_AVAILABLE = 1;
    private static AvailableLayout INSTANCE = null;

    private AvailableLayout() {}

    public static AvailableLayout getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new AvailableLayout();
        }

        return INSTANCE;
    }

    @Override
    public void setBackground(Layout layout) {

    }

    @Override
    public void setName(Layout layout) {
            }

    @Override
    public void setTime(Layout layout) {

    }

    @Override
    public void setHintText1(Layout layout) {
        layout.getScreenHint1().setText("AVAILABLE");
    }

    @Override
    public void setHintText2(Layout layout) {

    }
}
