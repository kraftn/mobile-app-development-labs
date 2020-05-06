package com.company;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    private int x = 10, y = 10, w = 30, h = 30;
    private int step = 30;
    private LinkedList<Rectangle> list = new LinkedList<>();
    private int direction = RIGHT;

    Snake() {
        for (int i = 4; i > 0; i--) {
            list.add(new Rectangle(x + i * w, y, w, h));
        }
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public void up() {
        list.removeLast();
        Rectangle r = new Rectangle(list.getFirst());
        r.y -= step;
        list.addFirst(r);
    }

    public void right() {
        list.removeLast();
        Rectangle r = new Rectangle(list.getFirst());
        r.x += step;
        list.addFirst(r);
    }

    public void down() {
        list.removeLast();
        Rectangle r = new Rectangle(list.getFirst());
        r.y += step;
        list.addFirst(r);
    }

    public void left() {
        list.removeLast();
        Rectangle r = new Rectangle(list.getFirst());
        r.x -= step;
        list.addFirst(r);
    }


    public void draw(Graphics g) {
        for (Rectangle r : list) {
            g.drawRect(r.x, r.y, r.width, r.height);
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

    public void eat(LinkedList<Apple> apples){
        for (int i = 0; i < apples.size(); i++){
            if (list.getFirst().equals(apples.get(i).getImage())){
                list.add(new Rectangle(list.getLast().x, list.getLast().y, w, h));
                apples.remove(i);
                i -= 1;
            }
        }
    }
}
