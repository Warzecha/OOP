package lab5.MathExp;

import java.util.ArrayList;
import java.util.List;

public class Sum extends Node {

    List<Node> args = new ArrayList<>();

    public Sum(){}

    Sum(Node n1, Node n2){

        args.add(n1);
        args.add(n2);


    }


    public Sum add(Node n){
        args.add(n);
        return this;
    }

    public Sum add(double c){
        args.add(new Constant(c));
        return this;
    }

    public Sum add(double c, Node n) {
        Node mul = new Prod(c,n);
        args.add(mul);
        return this;
    }

    @Override
    public double evaluate() {
        double result =0;

        for( Node x : args) {
            result += x.evaluate();
        }
//        oblicz sumę wartości zwróconych przez wywołanie evaluate skłądników sumy
        return sign*result;
    }

    int getArgumentsCount(){return args.size();}

    public String toString(){
        StringBuilder b =  new StringBuilder();
        if(sign<0)b.append("-(");

        //zaimplementuj
        String prefix = "";

        for(Node x : args) {

            b.append(prefix);
            b.append(x.toString());

            prefix = "+";

        }




        if(sign<0)b.append(")");
        return b.toString();
    }


}
