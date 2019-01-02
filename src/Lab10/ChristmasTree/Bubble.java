package Lab10.ChristmasTree;

import java.awt.*;

public class Bubble implements XmasShape {
    int x;
    int y;
    double scale;
    Color lineColor;
    Color fillColor;

    public Bubble(int x, int y, double scale, Color fillColor) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.lineColor = lineColor;
        this.fillColor = fillColor;
    }

    @Override
    public void render(Graphics2D g2d) {
        // ustaw kolor wypełnienia
        g2d.setColor(fillColor);
        g2d.fillOval(0,0,10,10);

        g2d.setColor(Color.black);
//        g2d.drawOval(0,0,10,10);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }
}