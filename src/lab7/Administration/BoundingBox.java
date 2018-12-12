package lab7.Administration;


public class BoundingBox {
    double xmin;
    double ymin;
    double xmax;
    double ymax;

    boolean isEmpty = true;


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

        isEmpty = false;

    }





    void addPoint(double x, double y)
    {
        if(!isEmpty)
        {
            xmin = Math.min(xmin, x);

            xmax = Math.max(xmax, x);

            ymin = Math.min(ymin, y);
            ymax = Math.max(ymax, y);
        } else
        {
            xmin = x;
            xmax = x;
            ymin = y;
            ymax = y;
            isEmpty = false;

        }
    }


    boolean contains(double x, double y)
    {

        return (xmin <= x && x <= xmax) && (ymin <= y && y <= ymax);

    }


    boolean contains(BoundingBox bb)
    {


        return contains(xmin, ymin) && contains(xmax, ymax);

    }


    boolean intersects(BoundingBox bb)
    {
        return contains(xmin, ymin) ^ contains(xmax, ymax) || (((xmin < bb.xmax && bb.xmax < bb.xmax) || (xmin < bb.xmin && bb.xmin < bb.xmax)) && ((ymin < bb.ymax && bb.ymax < bb.ymax) || (ymin < bb.ymin && bb.ymin < bb.ymax)) );

    }




    BoundingBox add(BoundingBox bb)
    {

        addPoint(bb.xmin, bb.ymin);
        addPoint(bb.xmax, bb.ymax);
        return this;
    }


    boolean isEmpty() {return isEmpty; }


    double getCenterX(){
        if(!isEmpty)
        {
            return (xmin + xmax)/2;
        }
        else throw new RuntimeException("BoundingBox is empty");
    }

    double getCenterY(){
        if(!isEmpty)
        {
            return (ymin + ymax)/2;
        }
        else throw new RuntimeException("BoundingBox is empty");
    }


    double distanceTo(BoundingBox bbx){
        if(this.isEmpty || bbx.isEmpty())
        {
            throw new RuntimeException("Not implemented");
        }
        else
        {
            return Math.sqrt(Math.pow(this.getCenterX() - bbx.getCenterX(),2) + Math.pow(this.getCenterY() - bbx.getCenterY(),2));
        }
    }


}