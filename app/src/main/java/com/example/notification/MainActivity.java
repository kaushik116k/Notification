package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] data = {"bike","boat","bus","car","railway","run"};
    int[] images = {R.drawable.ic_bike,
            R.drawable.ic_boat,
            R.drawable.ic_bus,
            R.drawable.ic_car,
            R.drawable.ic_train,
            R.drawable.ic_run};
    ListView l;
    NotificationManagerCompat notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = NotificationManagerCompat.from(this);
        l = findViewById(R.id.listView);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,data,images);
        l.setAdapter(myAdapter);


        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                Notification notification = new NotificationCompat.Builder(getApplicationContext(),App.CHANNEL_1_ID)
                        .setSmallIcon(images[position])
                        .setContentTitle(data[position])
                        .setContentText("Time to travel 6hrs")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();

                notificationManager.notify(1,notification);
            }
        });


    }
}