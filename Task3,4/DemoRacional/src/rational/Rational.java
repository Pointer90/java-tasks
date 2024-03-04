package rational;

public class Rational {
    private int numerator;
    private int denominator;
    
    
    public Rational(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
        normalize();
    }
    

    static int gcd(int a, int b)
    {
        while(b != 0)
        {
            int t = b;
            b = a % b;
            a = t;
        }
        
        return Math.abs(a);
    }
    

    void normalize()
    {
        int tmp = gcd(numerator, denominator);
        if (tmp > 1)
        {
            numerator /= tmp;
            denominator /= tmp;
        }
        
        if (denominator < 0)
        {
            numerator *= -1;
            denominator *= -1;
        }   
    }
    

    public int getNumerator()
    {
        return this.numerator;
    }
    

    public int getDenominator()
    {
        return this.denominator;
    }
    

    @Override
    public String toString()
    {
        return this.numerator + "//" + this.denominator;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Rational checkedRational = (Rational)obj;

        if (this.getNumerator() != checkedRational.getNumerator()) return false;
        if (this.getDenominator() != checkedRational.getDenominator()) return false;

        return true;
    }
}
