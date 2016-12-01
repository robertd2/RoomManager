package com.android.robnet.myfirstapplication;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.robnet.myfirstapplication.common.CommonData;
import com.android.robnet.myfirstapplication.connection.WebSocketConnect;
import com.android.robnet.myfirstapplication.logic.layout.Layout;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends Activity {

    private Layout layout;
    private WebSocketConnect wsConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        layout = new Layout(getWindow().getDecorView().getRootView());
        layout.setContext(this);
        layout.setCommonData(new CommonData());
        layout.setLayout(0);
        Log.i("rooms", "connecting to server...");

        wsConnect = new WebSocketConnect(this, layout);
    }


}
