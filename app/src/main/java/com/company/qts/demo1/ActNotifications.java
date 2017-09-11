package com.company.qts.demo1;

import android.accessibilityservice.AccessibilityService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActNotifications extends AppCompatActivity{
    private static final int ID = 10;
    Button bt_bt1,bt_bt2,bt_bt3,bt_bt4;
    private int mId=0;
    private CharSequence currentText;
    int numMessages = 0;
    private AccessibilityService context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_notifications);
        bt_bt1 = (Button) findViewById(R.id.bt_bt1);
        bt_bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(ActNotifications.this)
                                .setSmallIcon(R.drawable.ic_logo1)
                                .setContentTitle("My notification")
                                .setSound(soundUri)
                                .setContentText("Hello World!");
// Creates an explicit intent for an Activity in your app
                Intent resultIntent = new Intent(ActNotifications.this, ActProduct.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(ActNotifications.this);
// Adds the back stack for the Intent (but not the Intent itself)
                stackBuilder.addParentStack(ActProduct.class);
// Adds the Intent that starts the Activity to the top of the stack
                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );
                mBuilder.setContentIntent(resultPendingIntent);
                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
                mNotificationManager.notify(mId, mBuilder.build());

            }
        });
//-----------------------------------------------------------------------------------------------------
    bt_bt2 = (Button) findViewById(R.id.bt_bt2);
        bt_bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// Sets an ID for the notification, so it can be updated
                int notifyID = 0;
                NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(ActNotifications.this)
                        .setContentTitle("New Message")
                        .setContentText("You've received new messages.")
                        .setSmallIcon(R.drawable.ic_logo1);
// Start of a loop that processes data and then notifies the user
                //...
                
                mNotifyBuilder.setContentText(currentText)
                        .setNumber(++numMessages);
                // Because the ID remains unchanged, the existing notification is
                // updated.
                mNotificationManager.notify(
                        notifyID,
                        mNotifyBuilder.build());
                //...
            }
        });
//--------------------------------------------------------------------------------------------------
        bt_bt3 = (Button) findViewById(R.id.bt_bt3);
        bt_bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final NotificationManager mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(ActNotifications.this);
                mBuilder.setContentTitle("Picture Download")
                        .setContentText("Download in progress")
                        .setSmallIcon(R.drawable.ic_logo1);
// Start a lengthy operation in a background thread
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                int incr;
                                // Do the "lengthy" operation 20 times
                                for (incr = 0; incr <= 100; incr+=5) {
                                    // Sets the progress indicator to a max value, the
                                    // current completion percentage, and "determinate"
                                    // state
                                    mBuilder.setProgress(100, incr, false);
                                    // Displays the progress bar for the first time.
                                    mNotifyManager.notify(0, mBuilder.build());
                                    // Sleeps the thread, simulating an operation
                                    // that takes time
                                    try {
                                        // Sleep for 5 seconds
                                        Thread.sleep(1*1000);
                                    } catch (InterruptedException e) {
                                        Log.d("Error", "sleep failure");
                                    }
                                }
                                // When the loop is finished, updates the notification
                                mBuilder.setContentText("Download complete")
                                        // Removes the progress bar
                                        .setProgress(0,0,false);
                                mNotifyManager.notify(ID, mBuilder.build());
                            }
                        }
// Starts the thread by calling the run() method in its Runnable
                ).start();
            }
        });
//--------------------------------------------------------------------------------------------------
//        bt_bt4 = (Button) findViewById(R.id.bt_bt4);
//        bt_bt4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//
////Define sound URI
//
//
//                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext())
//                        .setSmallIcon(R.drawable.ic_logo1)
//                        .setContentTitle("title")
//                        .setContentText("message")
//                         //This sets the sound to play
//
////Display notification
//                notificationManager.notify(10, mBuilder.build());
//            }
//        });
    }
}
