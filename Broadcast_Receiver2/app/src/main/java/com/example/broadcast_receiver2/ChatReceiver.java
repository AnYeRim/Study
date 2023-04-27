package com.example.broadcast_receiver2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ChatReceiver extends BroadcastReceiver {

    public static final String ACTION_CHAT = "com.example.action.SEND_MESSAGE";

    private final String CHANNEL_ID = "chatAPP";
    private final String GROUP_KEY_CHATTING = "CHATTING";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("----------TEST----------", "onReceive IN");

        if(intent.getAction().equals(ACTION_CHAT)) {
            String title = intent.getStringExtra("title");
            String message = intent.getStringExtra("message");

            createNotificationChannel(context);

            //호출
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
            notificationManager.notify(0, getMessageBuilder(context, title, message).build());
        }
    }

    private void createNotificationChannel(Context context) {
        // Android8.0 이상인지 확인
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // 채널에 필요한 정보 제공
            CharSequence name = context.getString(R.string.channel_name);
            String description = context.getString(R.string.channel_description);

            // 중요도 설정, Android7.1 이하는 다른 방식으로 지원한다.
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            // 채널 생성
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @NonNull
    private NotificationCompat.Builder getMessageBuilder(Context context, String title, String message) {
        return new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(getRoomIntent(context, title, message))
                .setStyle(new NotificationCompat.MessagingStyle(title)
                        .addMessage(message, System.currentTimeMillis(), title))
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setGroup(GROUP_KEY_CHATTING);
    }

    private PendingIntent getRoomIntent(Context context, String title, String message) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("message", message);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return pendingIntent;
    }

}