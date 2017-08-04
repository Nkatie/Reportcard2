package com.example.mikatekonkatie.reportcard;

/**
 * Created by Mikateko (Nkatie) on 2017/07/25.
 */


import android.content.Context;
import android.widget.Toast;

public class Message {
    public static void message(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
