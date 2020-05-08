package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class GameField extends View {
    Snake snake = new Snake();
    GameTimer gameTimer = new GameTimer();

    class GameTimer extends CountDownTimer {

        public GameTimer() {
            super(Integer.MAX_VALUE, 500);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            snake.move();
            invalidate();
        }

        @Override
        public void onFinish() {

        }
    }

    public GameField(Context context) {
        super(context);
    }

    public GameField(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        snake.draw(canvas);
    }

    public void buttonPress(int press) {
        switch (press) {
            case R.id.btnLeft:
                snake.setDirection(Snake.LEFT);
                break;
            case R.id.btnRight:
                snake.setDirection(Snake.RIGHT);
                break;
            case R.id.btnUp:
                snake.setDirection(Snake.UP);
                break;
            case R.id.btnDown:
                snake.setDirection(Snake.DOWN);
                break;
        }
    }

    public void Continue() {
        gameTimer.start();
    }

    public void Pause() {
        gameTimer.cancel();
    }
}
