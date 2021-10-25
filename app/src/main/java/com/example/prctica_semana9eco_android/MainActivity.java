package com.example.prctica_semana9eco_android;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import model.Instruct;

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
        bananoBtn.setOnClickListener(
                (v) ->{
                    Instruct instruct = new Instruct("BANANO");
                    Gson gson = new Gson();
                    String json = gson.toJson(instruct);
                    UDP.sendMessage(json);
                });

        bananoBtn2.setOnClickListener(
                (v) ->{
                    Instruct instruct = new Instruct("BANANOP");
                    Gson gson = new Gson();
                    String json = gson.toJson(instruct);
                    UDP.sendMessage(json);
                });

        fresaBtn.setOnClickListener(
                (v) ->{
                    Instruct instruct = new Instruct("FRESA");
                    Gson gson = new Gson();
                    String json = gson.toJson(instruct);
                    UDP.sendMessage(json);
                });

        aguacateBtn.setOnClickListener(
                (v) ->{
                    Instruct instruct = new Instruct("AGUACATE");
                    Gson gson = new Gson();
                    String json = gson.toJson(instruct);
                    UDP.sendMessage(json);
                });
    }

    @Override
    public void onReceivedMessage(String msg) {
        runOnUiThread(
                ()->{
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

                });
    }

}