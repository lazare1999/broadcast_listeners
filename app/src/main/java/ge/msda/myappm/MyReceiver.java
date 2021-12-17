package ge.msda.myappm;

import static ge.msda.myappm.MainActivity.TAG;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    public static ConnectivityListener connectivityListener;

    public MyReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {



        if(intent.getAction().equals("ge.msda.myappm.SOME_ACTION")) {
            String value = intent.getExtras().getString("key");
        }

        Log.d(TAG, intent.getAction());

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();

        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            if(connectivityListener != null) {
                connectivityListener.onConnectionChanged(true);
            }
        } else {
            if(connectivityListener != null) {
                connectivityListener.onConnectionChanged(false);
            }
        }











    }

}