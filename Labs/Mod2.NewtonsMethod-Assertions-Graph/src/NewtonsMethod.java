import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewtonsMethod
{

    private int userIdValue;
    private int a,b,c,d,e,f,g;

    private double[] roots;
    private int[] numberOfIterations;
    private double[] guessedXValue;
    private double[] valueOfPolynomial;

    public NewtonsMethod()
    {
        a=8;
        b=7;
        c=6;
        d=5;
        e=4;
        f=3;
        g=2;

    }

    private void findRoots()
    {
        int rootNumber=0;
        boolean continueFindingRoots=true;
        double tempX;

        double xPlusOne;


        do {
            double fOfX;
            double fPrimeOfX;
            double x = Math.random();

            for (int i = 0; i <= 2000; i++)
            {
                fOfX = getFofX(x);
                //System.out.println(fOfX);
                fPrimeOfX = getFPrimeOfX(x);

                try
                {
                    xPlusOne = x - (fOfX / fPrimeOfX);
                }
                catch (ArithmeticException e)
                {
                    System.out.println(e.getMessage());
                    break;
                }


                tempX = Math.abs(xPlusOne - x);


                if (tempX <= .00001) {
                    guessedXValue[rootNumber] = x;
                    roots[rootNumber] = xPlusOne;
                    numberOfIterations[rootNumber]=i;
                    valueOfPolynomial[rootNumber] = getFofX(xPlusOne);

                    rootNumber++;
                    break;

                }

                if (i == 2000) {
                    continueFindingRoots =false;
                }

                x = xPlusOne;
            }


        }while (continueFindingRoots);


        return;


    }

    private void printRoots()
    {
        //List out each guessed x0 value, the derived root, the number of iteration for finding the root, and the value of the polynomial function by plugging in the root.

        if( roots == null || roots.length==0)
        {
            System.out.println("No results found");
            return;
        }
        for(int i=0; i< roots.length; i++)
        {
            System.out.println( roots.length + " roots found");
            System.out.println("Guessed X Value: " + guessedXValue[i]+  "\n Derived Root: " + roots[i] +
                    "\n Number of iterations: " + numberOfIterations[i] +
                    "\n Values of polynomial function with root: " + valueOfPolynomial[i]);
            System.out.print("\n \n");

        }
    }

    private double getFofX(double x)
    {

        return ((a * Math.pow(x,6)) - (b * Math.pow(x,5)) + (c * Math.pow(x,4)) - (d * Math.pow(x,3)) + (e * Math.pow(x,2)) - (f*x) + g);


    }

    private double getFPrimeOfX(double x)
    {
        return (((6*a) * Math.pow(x,5)) -((5*b) * Math.pow(x,4)) + ((4*c) * Math.pow(x,3)) - ((3*d) * Math.pow(x,2)) + ((2*e) * x) - f);

    }




    public static void main(String[] args) throws IOException
    {
        NewtonsMethod newtons = new NewtonsMethod();

        newtons.findRoots();

        newtons.printRoots();





        System.out.println("type 7 digit user Id for newtons method example, or press Enter for default values");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String userInput = reader.readLine();

        try
        {
            int inputValue = Integer.parseInt(userInput);

        }
        catch (NumberFormatException e)
        {
            //default values
            //System.out.println();
        }

    }
}

