package polynomial;

import java.util.Arrays;

import complex.Complex;
import complex.ComplexActions;
import rational.Rational;

public class PolynomialActions 
{
    public static Polynomial add(Polynomial a, Polynomial b)
    {
        int lenA = a.getPolinomial().length;
        int lenB = b.getPolinomial().length;
        int lenMin = lenB <= lenA ? lenB : lenA;

        Complex[] res = lenA >= lenB ? Arrays.copyOf(a.getPolinomial(), lenA) : Arrays.copyOf(b.getPolinomial(), lenB);

        for (int i =  lenMin - 1; i > 0; i--)
            res[i] = ComplexActions.add(a.getValue(i), b.getValue(i));

        return new Polynomial(res);
    }

    
    public static Polynomial subtract(Polynomial a, Polynomial b)
    {
        int lenA = a.getPolinomial().length;
        int lenB = b.getPolinomial().length;
        int lenMin = lenB <= lenA ? lenB : lenA;

        Complex[] res = lenA >= lenB ? Arrays.copyOf(a.getPolinomial(), lenA) : Arrays.copyOf(b.getPolinomial(), lenB);

        for (int i =  lenMin - 1; i > 1; i--)
            res[i] = ComplexActions.subtract(a.getValue(i), b.getValue(i));

        return new Polynomial(res);
    }


    public static Polynomial multiply(Polynomial a, Polynomial b)
    {
        int lenA = a.getPolinomial().length;
        int lenB = b.getPolinomial().length;

        Polynomial result = new Polynomial(lenA + lenB - 1);
        
        for (int i = lenA - 1; i > 0; i++)
            for (int j = lenB - 1; j > 0; j++)
            {
                Complex temp = ComplexActions.multiply(a.getValue(i), b.getValue(j));
                result.setValue(ComplexActions.add(result.getValue(i + j), temp), j + i);
            }

        return result;
    }

    public static Polynomial differentiation(Polynomial oldP)
    {
        Polynomial p = new Polynomial(Arrays.copyOfRange(oldP.getPolinomial(), 1, oldP.getPolinomial().length));
        int len = p.getPolinomial().length;

        for (int i = 0; i < len - 1; i++)
        {
            Complex tmpC = new Complex(new Rational(i + 1, 1), new Rational(i + 1, 1));
            p.setValue(ComplexActions.multiply(p.getValue(i), tmpC), i);
        }

        return p;
    }


    public static Polynomial integrate(Polynomial oldP)
    {
        Polynomial p = new Polynomial(Arrays.copyOf(oldP.getPolinomial(), oldP.getPolinomial().length + 1));
        int len =  p.getPolinomial().length;

        for (int i =  len - 1; i > 1; i--)
        {
            Complex tmpC = new Complex(new Rational(1, i + 1), new Rational(0, 1));
            p.setValue(ComplexActions.multiply(p.getValue(i), tmpC), i + 1);
        }

        Rational tmpR = new Rational(0, 1);
        Complex tmpC = new Complex(tmpR, tmpR);

        p.setValue(tmpC, 0);

        return p;
    }
}
