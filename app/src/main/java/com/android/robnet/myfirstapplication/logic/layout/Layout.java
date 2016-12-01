package com.android.robnet.myfirstapplication.logic.layout;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.robnet.myfirstapplication.R;
import com.android.robnet.myfirstapplication.common.CommonData;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class Layout {

    CommonData commonData;

    RelativeLayout layoutTop;
    RelativeLayout layoutBottom;

    TextView roomStatus;
    TextView roomName;
    TextView time;
    TextView screenHint1;
    TextView screenHint2;

    StateLayout currentLayout;

    Context context;

    public Layout(View rootView) {
        roomStatus = (TextView) rootView.findViewById(R.id.roomStatus);
        roomName = (TextView) rootView.findViewById(R.id.roomName);
        time = (TextView) rootView.findViewById(R.id.time);
        screenHint1 = (TextView) rootView.findViewById(R.id.screenHint1);
        screenHint2 = (TextView) rootView.findViewById(R.id.screenHint2);
        layoutTop = (RelativeLayout) rootView.findViewById(R.id.layoutTop);
        layoutBottom = (RelativeLayout) rootView.findViewById(R.id.layoutBottom);
    }

    public void setLayout(int state) {
        currentLayout = UnknownLayout.getInstance();

        if(state == UnknownLayout.STATE_UNKNOWN) {
            currentLayout = UnknownLayout.getInstance();
        }

        if(state == ReservedLayout.STATE_RESERVED) {
            currentLayout = ReservedLayout.getInstance();
        }

        if(state == OccupiedLayout.STATE_OCCUPIED) {
            currentLayout = OccupiedLayout.getInstance();
        }

        if(state == AvailableLayout.STATE_AVAILABLE) {
            currentLayout = AvailableLayout.getInstance();
        }

        setData();
    }

    private void setData() {
        currentLayout.setBackground(this);
        currentLayout.setHintText1(this);
        currentLayout.setHintText2(this);
        currentLayout.setName(this);
        currentLayout.setTime(this);
        currentLayout.setRoomStatus(this);
    }

    public RelativeLayout getLayoutTop() {
        return layoutTop;
    }

    public void setLayoutTop(RelativeLayout layoutTop) {
        this.layoutTop = layoutTop;
    }

    public RelativeLayout getLayoutBottom() {
        return layoutBottom;
    }

    public void setLayoutBottom(RelativeLayout layoutBottom) {
        this.layoutBottom = layoutBottom;
    }

    public TextView getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(TextView roomStatus) {
        this.roomStatus = roomStatus;
    }

    public TextView getRoomName() {
        return roomName;
    }

    public void setRoomName(TextView roomName) {
        this.roomName = roomName;
    }

    public TextView getTime() {
        return time;
    }

    public void setTime(TextView time) {
        this.time = time;
    }

    public TextView getScreenHint1() {
        return screenHint1;
    }

    public void setScreenHint1(TextView screenHint1) {
        this.screenHint1 = screenHint1;
    }

    public TextView getScreenHint2() {
        return screenHint2;
    }

    public void setScreenHint2(TextView screenHint2) {
        this.screenHint2 = screenHint2;
    }

    public CommonData getCommonData() {
        return commonData;
    }

    public void setCommonData(CommonData commonData) {
        this.commonData = commonData;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }
}
