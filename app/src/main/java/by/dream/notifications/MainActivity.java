package by.dream.notifications;

import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    private static final int NOTIFY_ID = 101; //идентификатор уведомлений

    private static String CHANNEL_ID = "Cat channel";//идентификатор канала

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent notificationIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this,0,notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

                NotificationCompat.Builder builder =
                new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_pets_black_24dp)
                        .setContentTitle("Напоминание")
                        .setContentText("Пора покормить кота")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(contentIntent);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(MainActivity.this);
                notificationManagerCompat.notify(NOTIFY_ID, builder.build());
            }
        });
    }
}
