package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class GamePanel extends JPanel {

    private Snake snake = new Snake();
    private LinkedList<Apple> apples = new LinkedList<>();

    class GameTimer extends Timer {

        public GameTimer() {

            super(250, new ActionListener() {
                private int  c = 0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    snake.eat(apples);
                    snake.move();
                    c += 250;
                    if(c > 2000) {
                        c = 0;
                        apples.add(new Apple());
                    }
                    repaint();
                }
            });
        }
    }

    class GameKey implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case 38:
                    snake.setDirection(Snake.UP);
                    break;
                case 39:
                    snake.setDirection(Snake.RIGHT);
                    break;
                case 40:
                    snake.setDirection(Snake.DOWN);
                    break;
                case 37:
                    snake.setDirection(Snake.LEFT);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    public GamePanel() {
        setFocusable(true);
        addKeyListener(new GameKey());
        new GameTimer().start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
        for (Apple apple: apples){
            apple.draw(g);
        }
    }
}
