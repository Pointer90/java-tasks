package complex;

import rational.Rational;
import rational.RationalActions;

public class ComplexActions {
    public static Complex add(Complex a, Complex b)
    {
        return new Complex(RationalActions.add(a.getReal(), b.getReal()),
                           RationalActions.add(a.getIm(), b.getIm()));
    }
    

    public static Complex subtract(Complex a, Complex b)
    {
        return new Complex(RationalActions.subtract(a.getReal(), b.getReal()),
                           RationalActions.subtract(a.getIm(), b.getIm()));
    }
    

    public static Complex multiply(Complex a, Complex b)
    {
        
        Rational re = RationalActions.subtract(
                           RationalActions.multiply(a.getReal(),b.getReal()),
                           RationalActions.multiply(a.getIm(), b.getIm()));
                           
        Rational im = RationalActions.add(
                           RationalActions.multiply(a.getReal(), b.getIm()),
                           RationalActions.multiply(a.getIm(), b.getReal()));
        return new Complex(re, im);
    }

    
    public static Complex divide(Complex a, Complex b){

        Rational a1 = a.getReal();
        Rational a2 = b.getReal();
        Rational b1 = a.getIm();
        Rational b2 = b.getIm();


        Rational reNumerator = RationalActions.add(
                RationalActions.multiply(a1, a2),
                RationalActions.multiply(b1, b2));

        Rational reDenominator = RationalActions.add(
                RationalActions.multiply(a2, a2),
                RationalActions.multiply(b2, b2));

        Rational re = RationalActions.divide(reNumerator, reDenominator);

        Rational imNumerator = RationalActions.subtract(
                RationalActions.multiply(a2, b1),
                RationalActions.multiply(a1, b2));

        Rational imDenominator = RationalActions.add(
                RationalActions.multiply(a2, a2),
                RationalActions.multiply(b2, b2));

        Rational im = RationalActions.divide(imNumerator, imDenominator);

        return new Complex(re, im);
    }
}
