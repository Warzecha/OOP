package Lab10.ChristmasTree;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tree implements XmasShape{



    int x;
    int y;
    int scale;
    int spread;

    List<Double> leavesX = new ArrayList<>(1);
    List<Double> leavesY = new ArrayList<>(1);




    public Tree(int n, int x, int y, int scale, int spread) {

        leavesX.add((double) 0);
        leavesY.add((double) 0);


        this.x = x;
        this.y = y;
        this.scale = scale;
        this.spread = spread;
//        System.out.print(leavesX);

        Random rng = new Random();

        for(int i = 1; i < n; i++) {

            double r = rng.nextDouble();

            if(r <= 0.01) {
                leavesX.add((double) 0);
                leavesY.add(0.16 * leavesY.get(i-1));
            }
            else if (r <= 0.08) {
                leavesX.add(0.2 * leavesX.get(i-1) - 0.26 * leavesY.get(i-1));
                leavesY.add(0.23 * leavesX.get(i-1) + 0.22 * leavesY.get(i-1) + 1.6);
            }
            else if (r <= 0.15) {
                leavesX.add(-0.15 * leavesX.get(i-1) + 0.28 * leavesY.get(i-1));
                leavesY.add(0.26 * leavesX.get(i-1) + 0.24 * leavesY.get(i-1) + 0.44);
            }
            else {

                leavesX.add(0.85 * leavesX.get(i-1) + 0.04 * leavesY.get(i-1));
                leavesY.add( -0.04 * leavesX.get(i-1) + 0.85 * leavesY.get(i-1) + 1.6);
            }
        }
    }


    @Override
    public void transform(Graphics2D g2d) {

        g2d.translate(x,y);
        g2d.scale(scale,scale);

    }

    public void render(Graphics2D g2d) {

        for(int i = 0; i < leavesY.size(); i++) {

            // ustaw kolor wypełnienia
            Random rng = new Random();


            int size = 1;


            Color fillColor;

            double bubbleChance = rng.nextDouble();
            if(bubbleChance < 0.0001) {

                fillColor = Color.red;
                size = 10;


            } else
            {
                int red = (int) Math.floor(rng.nextInt(40));
                int green = (int) ( 155 + Math.floor(rng.nextInt(80)));
                int blue = (int) Math.floor(rng.nextInt(40));
                fillColor = new Color(red, green, blue);

            }


            g2d.setColor(fillColor);
            g2d.fillOval((int) Math.floor(leavesX.get(i)* spread) ,-(int) Math.floor(leavesY.get(i) * spread ),size,size);
            // ustaw kolor obramowania
//            g2d.drawOval(0,0,100,100);


        }

    }


}



