package com.android.robnet.myfirstapplication.logic.layout;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;

import com.android.robnet.myfirstapplication.R;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class AvailableLayout extends StateLayout {

    public static int STATE_AVAILABLE = 1;
    private static AvailableLayout INSTANCE = null;

    private static String STATUS = "AVAILABLE";

    private AvailableLayout() {}

    public static AvailableLayout getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new AvailableLayout();
        }

        return INSTANCE;
    }

    @Override
    public void setBackground(Layout layout) {
        layout.getLayoutTop().setBackgroundColor(Color.GREEN);
        layout.getLayoutBottom().setBackground(ContextCompat.getDrawable(layout.getContext(), R.drawable.green_gradient
        ));
    }

    @Override
    public void setRoomStatus(Layout layout) {
        layout.getRoomStatus().setText(STATUS);
    }

    @Override
    public void setHintText1(Layout layout) {
        layout.getScreenHint1().setText(layout.getCommonData().getTime());
    }

    @Override
    public void setHintText2(Layout layout) {
        layout.getScreenHint2().setText("NEXT MEETING");
    }

    @Override
    void setTime(Layout layout) {
        layout.getTime().setText("");
    }
}
