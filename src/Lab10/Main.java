package Lab10;

import Lab10.ChristmasTree.Bubble;
import Lab10.ChristmasTree.DrawPanel;
import Lab10.ChristmasTree.Star;
import Lab10.ChristmasTree.Tree;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {



    public static void main(String[] args) {
        // write your code here
        JFrame frame = new JFrame("Choinka");

        DrawPanel panel = new DrawPanel();

        Random rng = new Random();
        for(int i = 0; i < 200; i++) {

            Star star = new Star( rng.nextInt(1000), rng.nextInt(900), 1, Color.yellow);
            panel.addShape(star);

        }

        Tree xmasTree = new Tree(100000,500, 800, 3, 25);
        panel.addShape(xmasTree);



        panel.setBackground(new Color(0, 5, 59));
        frame.setContentPane(panel);
        frame.setSize(1000, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setResizable(true);
        frame.setVisible(true);
    }


}
