package com.android.robnet.myfirstapplication.logic.layout;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class ReservedLayout implements StateLayout {

    public static int STATE_RESERVED = 2;
    private static ReservedLayout INSTANCE = null;

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
    public void setName(Layout layout) {
            }

    @Override
    public void setTime(Layout layout) {

    }

    @Override
    public void setHintText1(Layout layout) {
        layout.getScreenHint1().setText("RESERVED");
    }

    @Override
    public void setHintText2(Layout layout) {

    }
}
