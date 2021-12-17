package ge.msda.myappm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ConnectivityListener {

    public static final String TAG = "MainActivity.LOG";

    MyReceiver myReceiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyReceiver.connectivityListener = this;

        myReceiver = new MyReceiver();
        intentFilter = new IntentFilter();

        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("ge.msda.myappm.SOME_ACTION");
                intent.putExtra("key", "xksldkxel");
                sendBroadcast(intent);
            }
        });



    }

    @Override
    public void onConnectionChanged(boolean isConnected) {
        Log.d(TAG, "Connection - " + isConnected);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}