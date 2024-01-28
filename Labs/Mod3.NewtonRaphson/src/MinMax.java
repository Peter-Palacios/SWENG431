public class MinMax
{
    private double x;
    private double y;
    private final double differenceChecker = 0.00001;

    public MinMax()
    {
        x= Math.random() *6;
        y = Math.random()*5;
    }

    public void findMinMax() throws RuntimeException
    {
        if( x>6 || y >5)
        {
            throw new RuntimeException("Values are out of range");
        }

        //calls impossible if out of range
        for(int i =0;i<=10000;i++)
        {
            double nextX;
            double nextY;
            try
            {
                //get NextX
                nextX = x - (getPrimeOfX(x,y)/getDoublePrimeOfX(x));
                //use nextX to get next y
                nextY = y - (getPrimeOfY(nextX, y)/getDoublePrimeOfY(y));

            }
            catch (ArithmeticException e)
            {
                System.out.println(e.getMessage());
                break;
            }

            if(Math.abs(nextX-x) < differenceChecker && Math.abs(nextY-y) < differenceChecker)
            {
                double MinMax = ValueOfFunction(x,y);

                System.out.println("Number of Iterations = " +i+ "\nLocal Min/Max = " + MinMax);
                return;
            }
            x= nextX;
            y= nextY;
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


    private double getPrimeOfY(double x, double y) {return ((12*Math.pow(y,5) - x));}

    private double getDoublePrimeOfY(double y) {return (60*Math.pow(y,4));}


}








