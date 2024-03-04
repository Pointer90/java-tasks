package polynomial;

import complex.Complex;
import complex.ComplexActions;
import rational.Rational;

public class Polynomial 
{
    private Complex[] arr;

    public Polynomial(Complex... numbers)
    {
        arr = numbers;
    }

    public Polynomial(int degree)
    {
        arr = new Complex[degree];

        for (int i = 0 ; i < arr.length; i++)
            arr[i] = new Complex(new Rational(0, 1), new Rational(0, 1));
    }

    public Complex Horner(Complex x)
    {
        int size = arr.length - 1;
        Complex res = arr[size];
        
        for (int i = size - 1; i >= 0; i--)
            res = ComplexActions.add(ComplexActions.multiply(res, x), arr[i]);

        return res;
    }


    public Complex getValue(int index)
    {
        return this.arr[index];
    }


    public void setValue(Complex num, int index)
    {
        this.arr[index] = num;
    }


    public Complex[] getPolinomial()
    {
        return arr;
    }


    @Override
    public String toString() 
    {
        String res = "";

        for (int i = arr.length - 1; i > 0; i--)
            res += String.format(" x^%d (%s) +", i, arr[i]);

        return res + String.format(" x^%d (%s)", 0, arr[0]);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Polynomial checkedPolynom = (Polynomial)obj;

        if (arr == null)
        {
            if(checkedPolynom.getPolinomial() != null)
                return false;
        }
        else if (arr.length != checkedPolynom.getPolinomial().length)
            return false;
        else
        {
            Complex[] res = checkedPolynom.getPolinomial();
            for(int i = 0; i < arr.length; i++)
                if(!arr[i].equals(res[i]))
                    return false;
        }
        return true;
    }
}
