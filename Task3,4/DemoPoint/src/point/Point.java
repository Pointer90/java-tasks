package point;

public class Point 
{
    private double x;
    private double y;
    private double [] direction = new double[2];
    private double [] coeff = new double[3];
    

    public Point(double x, double y, double[] direction, double[] coefficients)
    {
        this.x = x;
        this.y = y;
        this.direction = normalizedVector(direction);
        this.coeff = coefficients;
    }


    private double[] normalizedVector(double[] vector)
    {
        double num = Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2));

        if (num != 1)
        {
            vector[0] /= num;
            vector[1] /= num;
        }

        return vector;
    }


    public double[] getDirection()
    {
        return direction;
    }


    public double getX()
    {
        return x;
    }


    public double getY()
    {
        return y;
    }


    public int getTime()
    {
        return t;
    }


    public double[] getCoefficients()
    {
        return coeff;
    }


    public void setDirection(double[] direction)
    {
        this.direction = direction;
    }


    public void setX(double x)
    {
        this.x = x;
    }


    public void setY(double y)
    {
        this.y = y;
    }


    public void setTime(int t)
    {
        this.t = t;
    }
    

    public void setCoefficients(double[] coeff)
    {
        this.coeff = coeff;
    }


    public double calcDistance(int t)
    {
        return coeff[0] * Math.pow(t, 2) + coeff[1] * t + coeff[2];
    }


    public double calcSpeed(int t)
    {
        return 2 * coeff[0] * t + coeff[1];
    }


    public double calcAcceleration()
    {
        return 2 * coeff[0];
    }


    public double calcDistanceBetweenPoints(Point p1, int t)
    {
        double dist0 = calcDistance(t);
        double dist1 = p1.calcDistance(t);
        double[] dir1 = p1.getDirection();

        double x0 = x + dist0 * direction[0];
        double y0 = y + dist0 * direction[1];
        double x1 = p1.getX() + dist1 * dir1[0];
        double y1 = p1.getY() + dist1 * dir1[1];

        return Math.sqrt(Math.pow((x1 - x0), 2) + Math.pow((y1 - y0), 2));
    }


    public boolean isCollinear(Point p1)
    {
        boolean isCollinear = true;

        if (p1.getDirection()[0] != 0 && p1.getDirection()[1] != 0)
            isCollinear = direction[0] / p1.getDirection()[0] == direction[1] / p1.getDirection()[1] ? false : true;

        return isCollinear;
    }


    @Override
    public String toString() {
        return String.format("coordinate: {x: %.6f , y: %.6f} | direction : <x: %.6f, y: %.6f>", x, y, direction[0], direction[1]);
    }
}
