package com.android.robnet.myfirstapplication.logic.layout;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;

import com.android.robnet.myfirstapplication.R;

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
        layout.getLayoutTop().setBackgroundColor(Color.WHITE);
        layout.getLayoutBottom().setBackground(ContextCompat.getDrawable(layout.getContext(), R.drawable.white_gradient));
    }

    @Override
    public void setHintText1(Layout layout) {
        layout.getScreenHint1().setText("CONNECTING");
    }

    @Override
    public void setHintText2(Layout layout) {
        layout.getScreenHint2().setText("TO SERVER...");
    }

    @Override
    public void setRoomStatus(Layout layout) {
        layout.getRoomStatus().setText(STATUS);
    }
}
