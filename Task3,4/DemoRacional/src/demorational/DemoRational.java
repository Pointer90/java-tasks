package demorational;

import rational.Rational;
import rational.RationalActions;
import complex.Complex;
import complex.ComplexActions;

import polynomial.Polynomial;
import polynomial.PolynomialActions;

public class DemoRational 
{
    public static void main(String[] args)
    {
        Rational rational = new Rational(16, -20);
        Rational a = new Rational(2, 1);
        Rational b = new Rational(4, 1);
        Rational c = new Rational(10, 1);
        System.out.println(RationalActions.divide(a, b));
        
        Complex c1 = new Complex(a, a);
        Complex c2 = new Complex(a, b);
        Complex c3 = new Complex(c, c);
        System.out.println(ComplexActions.multiply(c1, c2));

        Polynomial p1 = new Polynomial(c2, c1);
        Polynomial p2 = new Polynomial(c3, c3);
        System.out.println(PolynomialActions.subtract(p1, p2));
    }
}
