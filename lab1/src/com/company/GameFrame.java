package com.company;

import javax.swing.*;

public class GameFrame extends JFrame {
    public static final int WIDTH = 750;
    public static final int HEIGHT = 750;

    public GameFrame() {
        setBounds(10,10, WIDTH, HEIGHT);
        add(new GamePanel());
        setVisible(true);
    }
}
