public class MinMax
{
    private double x;
    private double y;

    public MinMax()
    {
        x= Math.random() *6;
        y = Math.random()*5;
    }

    public void findMinMax()
    {
        if( x>6 || y >5)
        {
            throw new RuntimeException("Values are out of range");
        }

        //calls impossible if out of range
        for(int i =0;i<=10000;i++)
        {
            double nextX;
            try
            {
                nextX = x - (getPrimeOfX(x,y)/getDoublePrimeOfX(x));
            }
            catch (ArithmeticException e)
            {
                System.out.println(e.getMessage());
                break;
            }

            if(Math.abs(nextX-x) < 0.00001)
            {
                double MinMax = ValueOfFunction(x,y);

                System.out.println("Number of Iterations = " +i+ "\nLocal Min/Max = " + MinMax);
                return;
            }
            x= nextX;
        }


        System.out.println("Infinity");



    }


    private double ValueOfFunction(double x, double y)
    {
        //z = x4+2y6 – xy – x + 2.
        return (Math.pow(x,4) + (2* Math.pow(y,6) - (x*y) - (x) +2));
    }
    private double getPrimeOfX(double x, double y)
    {
        return(4*Math.pow(x,3) - y - 1);
    }

    private double getDoublePrimeOfX(double x)
    {
        return(12*Math.pow(x,2));
    }

}
