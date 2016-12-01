package com.android.robnet.myfirstapplication.common;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class CommonData {

    public static int STATE_UNKNOWN = 0;
    public static int STATE_AVAILABLE = 1;
    public static int STATE_RESERVED = 2;
    public static int STATE_OCCUPIED = 3;

    private long roomId;
    private String nfcSerial;
    private String roomName;
    private long state;
    private String time;
    private String theNearestEmptyRoom;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getNfcSerial() {
        return nfcSerial;
    }

    public void setNfcSerial(String nfcSerial) {
        this.nfcSerial = nfcSerial;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getTheNearestEmptyRoom() {
        return theNearestEmptyRoom;
    }

    public void setTheNearestEmptyRoom(String theNearestEmptyRoom) {
        this.theNearestEmptyRoom = theNearestEmptyRoom;
    }
}
