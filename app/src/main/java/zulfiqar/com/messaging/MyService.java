package zulfiqar.com.messaging;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyService extends FirebaseMessagingService {

    private static final String TAG = "FirebaseMsgService";

    public MyService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Notification Title: " +
                    remoteMessage.getNotification().getTitle());

            Log.d(TAG, "Notification Message: " +
                    remoteMessage.getNotification().getBody());
        }

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " +
                    remoteMessage.getData().get("MyKey1"));
        }
    }
}
