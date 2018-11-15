package lab5.MathExp;

public class Power extends Node {
    double p;
    Node arg;
    public Power(Node n, double p){
        arg = n;
        this.p = p;
    }

    @Override
    public double evaluate() {
        double argVal = arg.evaluate();
        return Math.pow(argVal,p);
    }


    int getArgumentsCount(){return 1;}


    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        if(sign<0)b.append("-");
        int argSign = arg.getSign();
        int cnt = arg.getArgumentsCount();
        boolean useBracket = false;
        if(argSign<0 ||cnt>1)useBracket = true;
        String argString = arg.toString();
        if(useBracket)b.append("(");
        b.append(argString);
        if(useBracket)b.append(")");
        b.append("^");
        b.append(p);
        return b.toString();
    }

}
