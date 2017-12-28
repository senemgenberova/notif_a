package com.example.user.swipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = (RelativeLayout) findViewById(R.id.myLayout);

        myLayout.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            public void onSwipeTop() {
                Toast.makeText(MainActivity.this, "To top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(MainActivity.this, "To right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                Toast.makeText(MainActivity.this, "To left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "To bottom", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
