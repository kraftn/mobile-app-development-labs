package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private GameField game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        game = findViewById(R.id.GF);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLeft:
            case R.id.btnRight:
            case R.id.btnUp:
            case R.id.btnDown:
                game.buttonPress(v.getId());
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        game.Pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        game.Continue();
    }
}
