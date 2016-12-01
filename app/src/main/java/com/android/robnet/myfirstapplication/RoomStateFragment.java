package com.android.robnet.myfirstapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rober on 30.11.2016.
 */

public class RoomStateFragment extends Fragment {

    public static final String ROOM_STATE = "ROOM_STATE";

    private static final String UNKNOWN_STATE = "UNKNOWN";
    private static final String AVAILABLE_STATE = "AVAILABLE";
    private static final String RESERVED_STATE = "RESERVED";
    private static final String OCCUPIED_STATE = "OCCUPIED";

    private static final String UNKNOWN_STATE_COLOR = "#000000";
    private static final String AVAILABLE_STATE_COLOR = "#54C73A";
    private static final String RESERVED_STATE_COLOR = "#F28B0B";
    private static final String OCCUPIED_STATE_COLOR = "#DF1308";

    private TextView mRoomStateField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.room_state_fragment, container, false);
        if (v != null) {
            mRoomStateField = (TextView) v.findViewById(R.id.room_state_field);

            Integer roomState = null;
            if (this.getArguments() != null) {
                roomState = (Integer) getArguments().get(ROOM_STATE);
            }
            if (roomState != null) {
                mRoomStateField.setText(getRoomState(roomState));
                mRoomStateField.setTextColor(Color.parseColor(getStringColor(roomState)));
            } else {
                mRoomStateField.setText(UNKNOWN_STATE);
                mRoomStateField.setTextColor(Color.parseColor("#000000"));
            }
        }

        return v;
    }

    private String getRoomState(Integer state) {
        String result = "";
        switch (state) {
            case 0:
                result = UNKNOWN_STATE;
                break;
            case 1:
                result = AVAILABLE_STATE;
                break;
            case 2:
                result = RESERVED_STATE;
                break;
            case 3:
                result = OCCUPIED_STATE;
                break;
            default:
                result = UNKNOWN_STATE;
        }
        return result;
    }

    private String getStringColor(Integer state) {
        String result = "";
        switch (state) {
            case 0:
                result = UNKNOWN_STATE_COLOR;
                break;
            case 1:
                result = AVAILABLE_STATE_COLOR;
                break;
            case 2:
                result = RESERVED_STATE_COLOR;
                break;
            case 3:
                result = OCCUPIED_STATE_COLOR;
                break;
            default:
                result = UNKNOWN_STATE_COLOR;
        }
        return result;
    }
}
