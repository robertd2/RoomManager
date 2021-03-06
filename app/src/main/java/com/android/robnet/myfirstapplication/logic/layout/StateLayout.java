package com.android.robnet.myfirstapplication.logic.layout;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public abstract class StateLayout {

    abstract void setBackground(Layout layout);
    abstract void setHintText1(Layout layout);
    abstract void setHintText2(Layout layout);
    abstract void setRoomStatus(Layout layout);

    void setName(Layout layout) {
        String name = layout.getCommonData().getRoomName();
        if(name != null) {
            name = name.toUpperCase();
        }
        layout.getRoomName().setText(name); }

    void setTime(Layout layout) { layout.getTime().setText(layout.getCommonData().getTime()); }
}


