package com.example.prctica_semana9eco_android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements OnMessage{
private ImageView bananoBtn,bananoBtn2,aguacateBtn,fresaBtn;
    private UDPConnection UDP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bananoBtn = findViewById(R.id.bananoBtn);
        bananoBtn2 = findViewById(R.id.bananoBtn2);
        aguacateBtn = findViewById(R.id.aguacateBtn);
        fresaBtn = findViewById(R.id.fresaBtn);

        UDP = new UDPConnection();
        UDP.start();
        UDP.setObserver(this);

    }

    @Override
    public void onReceivedMessage(String msg) {

    }
}