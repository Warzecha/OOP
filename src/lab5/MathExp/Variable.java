package lab5.MathExp;

public class Variable extends Node {
    String name;
    Double value;
    public Variable(String name){
        this.name = name;
    }
    public void setValue(double d){
        value = d;
    }


    @Override
    public double evaluate() {
        return value;
    }


    @Override
    public String toString() {
        String sgn=sign<0?"-":"";
        return sgn+name;
    }

}