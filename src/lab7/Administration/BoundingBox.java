package lab7.Administration;


public class BoundingBox {
    double xmin;
    double ymin;
    double xmax;
    double ymax;


    public BoundingBox(double [] xx, double [] yy) {

        xmin = xx[0];
        xmax = xx[0];

        for(double x : xx)
        {
            xmin = Math.min(xmin, x);
            xmax = Math.max(xmax, x);

        }



        ymin = yy[0];
        ymax = yy[0];

        for(double y : yy)
        {
            ymin = Math.min(ymin, y);
            ymax = Math.max(ymax, y);

        }


    }
}