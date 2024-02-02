public class Main
{
    public static void main(String[] args)
    {
        String triangleType = null;
        int a = (int) (1 + Math.random() * 100); // 1 ≤ a ≤ 100
        int b = (int) (50 + Math.random() * 101); // 50 ≤ b ≤ 150
        int c = (int) (100 + Math.random() * 101); //100 ≤ c ≤ 200

        if(CheckIfSidesAreTriangle(a,b,c)) {

            Triangle newTriangle = foo(a,b,c);
            triangleType = newTriangle.toString();
        }
        else
        {
            System.out.println("Sides: " + a+ "," +b + "," +c+" do not form a triangle");
        }
        if(triangleType!=null)
        {
            System.out.println("Triangle with sides: " + a+ "," +b + "," +c+" \n is a " + triangleType + " triangle");
        }


    }

    private static Triangle foo(int a, int b, int c)
    {

        if(b == c && a == c)
        {
            return Triangle.Equilateral;
        }
        else if(a==b || a==c|| b==c)
        {
            return Triangle.Isosceles;
        }
        else
        {
            return Triangle.Scalene;
        }

    }

    private static boolean CheckIfSidesAreTriangle(int a, int b, int c)
    {
        if(a > b+c)
        {
            return false;
        }
        if(b>a+c)
        {
            return false;
        }
        if(c>a+b)
        {
            return false;
        }
        return true;
    }

}
