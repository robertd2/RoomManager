package com.android.robnet.myfirstapplication.logic.layout;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;

import com.android.robnet.myfirstapplication.R;

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
        layout.getLayoutTop().setBackgroundColor(Color.parseColor("#009999"));
        layout.getLayoutBottom().setBackground(ContextCompat.getDrawable(layout.getContext(), R.drawable.blue_gradient));
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
        layout.getRoomStatus().setText(STATUS);
    }
}
