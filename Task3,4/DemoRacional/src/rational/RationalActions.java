package rational;

public class RationalActions {
    
    public static Rational add(Rational a, Rational b){
        return new Rational(a.getNumerator() * b.getDenominator() +
                            b.getNumerator() * a.getDenominator(),
                            a.getDenominator() * b.getDenominator());
    }
    
    public static Rational subtract(Rational a, Rational b){
        return new Rational(a.getNumerator() * b.getDenominator() -
                            b.getNumerator() * a.getDenominator(),
                            a.getDenominator() * b.getDenominator());
    }
    
    public static Rational multiply(Rational a, Rational b){
        return new Rational(a.getNumerator() * b.getNumerator(),
                            a.getDenominator() * b.getDenominator());
    }
    
    public static Rational divide(Rational a, Rational b){
        return new Rational(a.getNumerator() * b.getDenominator(),
                            a.getDenominator() * b.getNumerator());
    }
}