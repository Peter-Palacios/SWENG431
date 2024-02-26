import javax.sound.midi.SysexMessage;

public class Main
{
    public static void main(String[] args)
    {
        String triangleType = null;
        int a = (int) (1 + Math.random() * 100); // 1 ≤ a ≤ 100
        int b = (int) (50 + Math.random() * 101); // 50 ≤ b ≤ 150
        int c = (int) (100 + Math.random() * 101); //100 ≤ c ≤ 200


        triangleType = foo(a,b,c);
        System.out.println(triangleType);

    }

    private static String foo(int a, int b, int c)
    {
        if((a >= b+c) || (b >= a+c) || (c >= a+b) )
        {
            return "Not a triangle";
        }

        if(b == c && a == c)
        {
            return "Equilateral";
        }
        else if(a==b || a==c|| b==c)
        {
            return "Isosceles";
        }
        else
        {
            return "Scalene";
        }

    }


}
