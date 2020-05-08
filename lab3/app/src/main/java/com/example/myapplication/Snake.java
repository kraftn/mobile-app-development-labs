package com.example.myapplication;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.LinkedList;

public class Snake {
    public static class Rectangle {
        public int x;
        public int y;
        public int width;
        public int height;

        public Rectangle(int x, int y, int width, int height){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public Rectangle(Rectangle obj){
            this.x = obj.x;
            this.y = obj.y;
            this.width = obj.width;
            this.height = obj.height;
        }
    }

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    private int step = 70;
    private LinkedList<Rectangle> list = new LinkedList<>();
    private int direction = RIGHT;

    Snake() {
        int x = 10, y = 10;
        for (int i = 5; i > 0; i--) {
            list.add(new Rectangle(x + i * step, y, step, step));
        }
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    private void up() {
        list.removeLast();
        Rectangle r = new Rectangle(list.getFirst());
        r.y -= step;
        list.addFirst(r);
    }

    private void right() {
        list.removeLast();
        Rectangle r = new Rectangle(list.getFirst());
        r.x += step;
        list.addFirst(r);
    }

    private void down() {
        list.removeLast();
        Rectangle r = new Rectangle(list.getFirst());
        r.y += step;
        list.addFirst(r);
    }

    private void left() {
        list.removeLast();
        Rectangle r = new Rectangle(list.getFirst());
        r.x -= step;
        list.addFirst(r);
    }

    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        for (Rectangle r : list) {
            canvas.drawRect(r.x, r.y, r.x + r.width, r.y + r.height, paint);
        }
    }

    public void move() {
        switch(direction){
            case UP:
                up();
                break;
            case DOWN:
                down();
                break;
            case RIGHT:
                right();
                break;
            case LEFT:
                left();
                break;
        }
    }
}
