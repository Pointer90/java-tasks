package complex;

import rational.Rational;

public class Complex 
{
    private Rational re;
    private Rational im;
    

    public Complex(Rational re, Rational im)
    {
        this.re = new Rational(re.getNumerator(), re.getDenominator());
        this.im = new Rational(im.getNumerator(), im.getDenominator());
    }
    
    public Rational getReal()
    {
        return new Rational(re.getNumerator(), re.getDenominator());
    }


    public Rational getIm()
    {
        return new Rational(im.getNumerator(), im.getDenominator());
    }


    @Override
    public String toString()
    {
        if(im.getNumerator() >= 0)
            return re + "+" + im + "i";
        else
            return  re + " - " + new Rational(-im.getNumerator(), im.getDenominator()) + "i";
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        Complex checkedComplex = (Complex)obj;

        if (re == null)
        {
            if(checkedComplex.re != null) return false;
        }
        else 
            if (!re.equals(checkedComplex.re)) return false;
        if (im == null)
        {
            if(checkedComplex.im != null) return false;
        }
        else 
            if (!im.equals(checkedComplex.im)) return false;
            
        return true;
    }
}
