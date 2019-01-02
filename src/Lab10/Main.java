package Lab10;

import Lab10.ChristmasTree.Bubble;
import Lab10.ChristmasTree.DrawPanel;
import Lab10.ChristmasTree.Tree;

import javax.swing.*;
import java.awt.*;

public class Main {



    public static void main(String[] args) {
        // write your code here
        JFrame frame = new JFrame("Choinka");

        DrawPanel panel = new DrawPanel();
//        panel.addShape(new Bubble(100, 100, 1, Color.red));
//        panel.addShape(new Bubble(300, 100, 1, Color.red));
//        panel.addShape(new Bubble(500, 100, 1, Color.red));

        Tree xmasTree = new Tree(100000,500, 800, 3, 25);
        panel.addShape(xmasTree);

        frame.setContentPane(panel);
        frame.setSize(1000, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }


}
