package com.android.robnet.myfirstapplication.logic.layout;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class UnknownLayout implements StateLayout {

    public static int STATE_UNKNOWN = 0;
    private static UnknownLayout INSTANCE = null;

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
    public void setName(Layout layout) {
    }

    @Override
    public void setTime(Layout layout) {

    }

    @Override
    public void setHintText1(Layout layout) {
        layout.getScreenHint1().setText("unknown");
    }

    @Override
    public void setHintText2(Layout layout) {

    }
}
