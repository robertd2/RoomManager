package com.android.robnet.myfirstapplication;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.robnet.myfirstapplication.common.CommonData;
import com.android.robnet.myfirstapplication.logic.layout.Layout;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends Activity {

    private Layout layout;
    private static final int UNKNOWN_STATE = 0;

    private String roomName;
    private int roomState = UNKNOWN_STATE;

    private Button button;

    private WebSocketClient mWebSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        View rommStatus = findViewById(R.id.roomStatus);
        rommStatus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.i("rooms", "connectWebsocketDummy");
                connectWebsocketDummy();
            }
        });


        layout = new Layout(getWindow().getDecorView().getRootView());
        layout.setCommonData(new CommonData());
        layout.setLayout(0);
        Log.i("rooms", "done");

        /*
        Here we expect to connect to server to get important startup information
         */
        connectWebSocket();
    }

    private void connectWebsocketDummy() {
        //1. connection to the server -- DONE
        //2. waiting for message -- CONTINUOUSLY
        //3. receiving message
        roomName = ConnectionUtils.getRoomNameFromResponse("message");


        roomState = ConnectionUtils.getRoomStateFromResponse("message");
        layout.setLayout(roomState);
    }

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
                mWebSocketClient.send("Outduda" + Build.SERIAL);
            }

            @Override
            public void onMessage(String s) {
                final String message = s;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("BACK MESSAGE", message);
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
