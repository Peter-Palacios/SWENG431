public class MinMax
{
    private double x;
    private double y;

    public MinMax()
    {
        x= Math.random() *6;
        y = Math.random()*5;
    }

//   Apply the Newton-Raphson's method  to develop a function double findMinMax(…) that returns a solution that is either a minimum value or a maximum value for z. The program finds a local minimum or a local maximum when the difference between the new solution and the previous one is smaller than 0.00001 within 10000 iterations. Otherwise, it shows Infinity as output.
//
//    Let function z = x4+2y6 – xy – x + 2. Show the post-conditions for z.
//    The preconditions for x and y are shown as below. Feel free to choose an arbitrary initial guess values x0 and y0 that meet the following precondition.
//


    //previous one is smaller than 0.00001 within 10000 iterations.
//|x| ≤ 6 and |y| ≤ 5
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



        //xn+1 = xn – f '(xn) / f ''(xn)

        //next = x - ((getPrimeOfX(x,y)/getDoublePrimeOfX(x))


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