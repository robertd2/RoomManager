package com.android.robnet.myfirstapplication;

import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    private static final int UNKNOWN_STATE = 0;

    private WebSocketClient mWebSocketClient;
    private String roomName;
    private int roomState = UNKNOWN_STATE;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Here we expect to connect to server to get important startup information
         */
        //connectWebSocket();

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Produce data
                connectWebsocketDummy();
                //Room Name
                RoomNameFragment newNameFragment = new RoomNameFragment();
                Bundle args1 = new Bundle();
                args1.putString(RoomNameFragment.ROOM_NAME, roomName);
                newNameFragment.setArguments(args1);
                //Room State
                RoomStateFragment newStateFragment = new RoomStateFragment();
                Bundle args2 = new Bundle();
                args2.putInt(RoomStateFragment.ROOM_STATE, roomState);
                newStateFragment.setArguments(args2);

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.room_name_fragment, newNameFragment);
                transaction.replace(R.id.room_state_fragment, newStateFragment);

                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    private void connectWebsocketDummy() {
        //1. connection to the server -- DONE
        //2. waiting for message -- CONTINUOUSLY
        //3. receiving message
        roomName = ConnectionUtils.getRoomNameFromResponse("message");
        roomState = ConnectionUtils.getRoomStateFromResponse("message");
    }

    private void connectWebSocket() {
        URI uri;
        try {
            uri = new URI("ws://websockethost:8080");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        mWebSocketClient = new WebSocketClient(uri) {

            @Override
            public void onOpen(ServerHandshake handshakedata) {
                Log.i("Websocket", "Opened");
                mWebSocketClient.send("Hello from " + Build.SERIAL);
            }

            @Override
            public void onMessage(String s) {
                final String message = s;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //TextView textView = (TextView)findViewById(R.id.messages);
                        //textView.setText(textView.getText() + "\n" + message);
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
