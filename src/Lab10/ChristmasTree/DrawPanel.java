package Lab10.ChristmasTree;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawPanel extends JPanel {

    ArrayList<XmasShape> shapes = new ArrayList<XmasShape>();

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        for(XmasShape s:shapes){
            s.draw((Graphics2D)g);
        }
    }


    public void addShape(XmasShape shape) {
        shapes.add(shape);
    }

}
