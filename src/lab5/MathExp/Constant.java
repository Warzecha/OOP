package lab5.MathExp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Constant extends Node {
    double value;


    Constant(double value){
        this.sign = value<0?-1:1;
        this.value = value<0?-value:value;
    }


    @Override
    public double evaluate() {
        return sign*value;
    }

    @Override
    public String toString() {

        String sgn=sign<0?"-":"";
        return sgn+Double.toString(value);
//        DecimalFormat format = new DecimalFormat("0.#####",new DecimalFormatSymbols(Locale.US));
//        return sgn+format.format(this.value);


    }

}