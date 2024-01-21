/**
 * Lab2 - Part 1
 * @author Peter Palacios, Emily Kan, Tanmay Gupta
 */
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

    public NewtonsMethod(int _a, int _b, int _c, int _d, int _e, int _f, int _g)
    {
        a=_a;
        b=_b;
        c=_c;
        d=_d;
        e=_e;
        f=_f;
        g=_g;

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
        NewtonsMethod newtons = printUser();

        newtons.findRoots();

        newtons.printRoots();

    }

    public static NewtonsMethod printUser() throws IOException
    {
        boolean correctInput = false;

        System.out.println("type 7 digit user Id for newtons method example, or press Enter for default values");


        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );


        do {

            String userInput = reader.readLine();


            if (userInput.isEmpty()) {
                return new NewtonsMethod(1, 2, 3, 4, 5, 6, 7);

            }

            try {
                int[] inputValue = new int[7];
                if (userInput.length() == 7) {
                    for (int i = 0; i < 7; i++) {
                        inputValue[i] = Character.getNumericValue(userInput.charAt(i));
                    }
                    correctInput = true;
                    return new NewtonsMethod(inputValue[0], inputValue[1], inputValue[2], inputValue[3], inputValue[4], inputValue[5], inputValue[6]);
                }

                System.out.println("Please enter exactly 7 digits, or press 'Enter for default values");

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        }while (!correctInput);

        return new NewtonsMethod(1,2,3,4,5,6,7);


    }
}

