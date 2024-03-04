package vector;

public class Vector {
    private double[] vector;


    public Vector(double... values)
    {
        vector = values;
    }


    public Vector(float... values)
    {
        vector = new double[values.length];

        for (int i = 0; i < values.length; i++)
            vector[i] = (double)values[i];
    }


    public Vector(int... values)
    {
        vector = new double[values.length];

        for (int i = 0; i < values.length; i++)
            vector[i] = (double)values[i];
    }
    

    public double[] getVector()
    {
        return vector;
    }

    
    public double getModule()
    {
        double sum = 0.;
        
        for (double elem : vector)
            sum += Math.pow(elem, 2);

        return Math.sqrt(sum);
    }


    public double scalarMultiply(Vector vector2)
    {
        double sum = 0.;
        double[] v2 = vector2.getVector();

        for (int i = 0; i < vector.length; i++)
            sum += vector[i] * v2[i];

        return sum;
    }


    public Vector add(Vector vector2)
    {
        double[] v2 = vector2.getVector();
        double[] v = new double[vector.length];

        for (int i = 0; i < vector.length; i++)
            v[i] = vector[i] + v2[i];

        return new Vector(v);
    }


    public Vector subtract(Vector vector2)
    {
        double[] v2 = vector2.getVector();
        double[] v = new double[vector.length];

        for (int i = 0; i < vector.length; i++)
            v[i] = vector[i] - v2[i];

        return new Vector(v);
    }


    public void multiplyConstant(double constant)
    {
        for (int i = 0; i < vector.length; i++)
            vector[i] *= constant;
    }


    public String isCollinearOrOrthogonal(Vector vector2)
    {
        boolean isCollinear = true;
        double[] v2 = vector2.getVector();

        
                
        if (v2[0] != 0)
        {
            for (int i = 1; i < vector.length; i++)
                if (v2[i] == 0 || vector[i] / v2[i] !=  vector[i - 1] / v2[i - 1])
                {
                    isCollinear = false;
                    break;
                }
        }
        else
            isCollinear = false;

        boolean isOrthogonal = scalarMultiply(vector2) == 0 ? true : false;

        if (isCollinear)
            return "Коллинеарны";

        if (isOrthogonal)
            return "Ортогональны";

        return "Не коллинеарны и не ортогональны";
    }


    @Override
    public String toString() 
    {
        String result = "( ";

        for (double elem : vector)
            result += elem + "; ";

        return result + ")";
    }
}
