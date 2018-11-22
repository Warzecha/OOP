package lab5.MathExp;

import java.util.ArrayList;
import java.util.List;

public class Prod extends Node {
    List<Node> args = new ArrayList<>();

    Prod(){}

    Prod(Node n1){
        args.add(n1);
    }
    Prod(double c){
//        wywołaj konstruktor jednoargumentowy przekazując new Constant(c)
        this(new Constant(c));

    }

    Prod(Node n1, Node n2){
        args.add(n1);
        args.add(n2);
    }
    Prod(double c, Node n){

        this(new Constant(c), n);
    }



    Prod mul(Node n){
        args.add(n);
        return this;
    }

    Prod mul(double c){
        args.add(new Constant(c));
        return this;
    }


    @Override
    public double evaluate() {
        double result =1;
        for(Node arg : args) {
            result *= arg.evaluate();
        }
        // oblicz iloczyn czynników wołąjąc ich metodę evaluate
        return sign*result;
    }
    int getArgumentsCount(){return args.size();}


    public String toString(){
        StringBuilder b =  new StringBuilder();
        if(sign<0)b.append("-");
        // ...
//        zaimplementuj



        b.append('(');



        String prefix = "";

        for(Node x : args) {

            b.append(prefix);
            prefix = "*";

            b.append(x.toString());

        }



        b.append(')');


        return b.toString();
    }


}
