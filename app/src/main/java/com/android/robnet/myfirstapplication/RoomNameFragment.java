package com.android.robnet.myfirstapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rober on 28.11.2016.
 */

public class RoomNameFragment extends Fragment {

    public static final String ROOM_NAME = "ROOM_NAME";
    private static final String UNKNOWN_NAME = "UNKNOWN NAME";

    private TextView mRoomNameField;

    public RoomNameFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.room_name_fragment, container, false);
        if (v != null) {
            mRoomNameField = (TextView) v.findViewById(R.id.room_name_field);
            String roomName = null;
            if (this.getArguments() != null) {
                roomName = (String) getArguments().get(ROOM_NAME);
            }
            if (roomName != null) {
                mRoomNameField.setText(roomName);
            } else {
                mRoomNameField.setText(UNKNOWN_NAME);
            }

        }

        return v;
    }
}
