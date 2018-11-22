package lab5;

import lab5.MathExp.Node;
import lab5.MathExp.Power;
import lab5.MathExp.Sum;
import lab5.MathExp.Variable;

import java.util.Locale;

public class Main {




    static void buildAndPrint(){
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(2.1,new Power(x,3))
                .add(new Power(x,2))
                .add(-2,x)
                .add(7);
        System.out.println(exp.toString());

    }


    static void buildAndEvaluate() {
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(2.1,new Power(x,3))
                .add(new Power(x,2))
                .add(-2,x)
                .add(7);
        for (double v = -5; v < 5; v += 0.1) {
            x.setValue(v);
            System.out.printf(Locale.US, "f(%f)=%f\n", v, exp.evaluate());
        }

    }



    static void buildAndEvaluate(double x_value) {
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(2.1,new Power(x,3))
                .add(new Power(x,2))
                .add(-2,x)
                .add(7);

            x.setValue(x_value);
            System.out.printf(Locale.US, "f(%f)=%f\n", x_value, exp.evaluate());
        }






    public static void main(String args[])
    {


//        buildAndPrint();
//
//        buildAndEvaluate(0);

        double x_value = 0;


        Variable x = new Variable("x");
        Node exp = new Sum()
//                .add(2.1,new Power(x,3))
//                .add(new Power(x,2))
                  .add(-2,x);
//                .add(7);

        x.setValue(x_value);
        System.out.println(exp.toString());
        System.out.printf(Locale.US, "f(%f)=%f\n", x_value, exp.evaluate());







    }


}
