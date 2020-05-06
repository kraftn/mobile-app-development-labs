package com.company;

import java.awt.*;
import java.util.Random;

public class Apple {
    private static Random generator = new Random(System.currentTimeMillis());
    private static int size = 30;
    private static int indent = 10;

    private Rectangle image = null;

    public Apple() {
        int numberApplesX = (GameFrame.WIDTH - indent) / size;
        int numberApplesY = (GameFrame.HEIGHT - indent) / size;
        int x = generator.nextInt(numberApplesX);
        int y = generator.nextInt(numberApplesY);

        image = new Rectangle(indent + x * size, indent + y * size, size, size);
    }

    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(image.x, image.y, size, size);
        g.setColor(Color.BLACK);
    }

    public Rectangle getImage(){
        return image;
    }
}
