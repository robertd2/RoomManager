package com.android.robnet.myfirstapplication.connection;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.android.robnet.myfirstapplication.ConnectionUtils;
import com.android.robnet.myfirstapplication.MainActivity;
import com.android.robnet.myfirstapplication.common.CommonData;
import com.android.robnet.myfirstapplication.logic.layout.Layout;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by AMARCINI on 01.12.2016.
 */

public class WebSocketConnect {

    private WebSocketClient mWebSocketClient;
    private MainActivity activity;
    private Layout layout;

    public WebSocketConnect(MainActivity activity, Layout layout) {
        this.activity = activity;
        this.layout = layout;

        connectWebSocket();
    }

//    private void connectWebsocketDummy() {
//        //1. connection to the server -- DONE
//        //2. waiting for message -- CONTINUOUSLY
//        //3. receiving message
//        roomName = ConnectionUtils.getRoomNameFromResponse("message");
//
//
//        roomState = ConnectionUtils.getRoomStateFromResponse("message");
//        layout.setLayout(roomState);
//    }

    public void connectWebSocket() {
        URI uri;

        try {
            uri = new URI("ws://192.168.137.55:8080/ws");
            Log.i("URI:",uri.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        mWebSocketClient = new WebSocketClient(uri, new Draft_17()) {

            @Override
            public void onOpen(ServerHandshake handshakedata) {
                Log.i("Websocket", "Opened");
                CommonData cData = CommonDataFactory.getRandomCommonData();
                String request = CommonDataFactory.toJSON(cData);
                mWebSocketClient.send(request);
            }

            @Override
            public void onMessage(String s) {
                final String message = s;

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("BACK MESSAGE", message);
                        CommonData cData = CommonDataFactory.fromJSON(message);
                        layout.setCommonData(cData);
                        layout.setLayout();
                    }
                });
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                Log.i("Websocket", "Closed " + s);
            }

            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }
        };
        mWebSocketClient.connect();
    }

    public void sendMessage(String message) {
        mWebSocketClient.send(message);
    }
}
