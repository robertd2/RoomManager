package com.android.robnet.myfirstapplication.common;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class CommonData {

    private long roomId;
    private String nfcSerial;
    private String roomName;
    private long state;
    private String reservedTimeFrom;
    private String reservedTimeTo;
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

    public String getReservedTimeFrom() {
        return reservedTimeFrom;
    }

    public void setReservedTimeFrom(String reservedTimeFrom) {
        this.reservedTimeFrom = reservedTimeFrom;
    }

    public String getReservedTimeTo() {
        return reservedTimeTo;
    }

    public void setReservedTimeTo(String reservedTimeTo) {
        this.reservedTimeTo = reservedTimeTo;
    }

    public String getTheNearestEmptyRoom() {
        return theNearestEmptyRoom;
    }

    public void setTheNearestEmptyRoom(String theNearestEmptyRoom) {
        this.theNearestEmptyRoom = theNearestEmptyRoom;
    }
}
