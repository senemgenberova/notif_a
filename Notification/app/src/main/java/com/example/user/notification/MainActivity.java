package com.example.user.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.renderscript.RenderScript;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity extends AppCompatActivity {

    private static final String MY_EXTRA = "myExtra";
    private TextView txtMessage;
    String extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        extra = intent.getStringExtra(MY_EXTRA);
        if(extra!=null){
            txtMessage = (TextView) findViewById(R.id.txtMessage);
            txtMessage.setText(extra);
        }
        extra = "";
    }

    public void getNotification(View view) {
        Random random = new Random();
        String message = "Your new number: "+ String.valueOf(random.nextInt(20));
        Log.e("msg",message);

        Intent notificationIntent = new Intent(this,MainActivity.class);
        notificationIntent.putExtra(MY_EXTRA,message);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Number generator")
                .setContentText(message)
                .setDefaults(NotificationCompat.DEFAULT_SOUND);

        PendingIntent pi = PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1,builder.build());
    }
}
