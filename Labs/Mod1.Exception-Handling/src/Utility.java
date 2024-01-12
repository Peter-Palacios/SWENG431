import javax.naming.InvalidNameException;
import javax.naming.NamingException;

public class Utility extends Exception{ //todo needs the extends exception? probably not

    //name cannot be zero or longer than '15' charactrs
    //a character can be space, "-", alphabet or ","
    // or exception thrown

//    public InvalidNameException NameException(String s)
//    {
//        if(s.length() == 0 || s.length() > 15)
//        {
//            throw new Exception("NameException: 0 <= (30) characters <= 15 is invalid. Note that the number 30 depends on the actual user input");
//        }
//    }


    public void validateName(String s) throws NamingException
    {
        if(s.length() == 0 || s.length() > 15)
        {
            throw new NamingException("NameException: 0 <= (30) characters <= 15 is invalid. Note that the number 30 depends on the actual user input");
        }
        String stringLowerCase = s.toLowerCase();

        char[] ascii = stringLowerCase.toCharArray();

        for (char c : ascii)
        {

            if ((int)c >=48 && (int)c <= 57)
            {
               throw new NamingException("NameException: a digit exists.");
            }
            else if ((int)c > 122 || ((int) c < 97 && ((int)c != 44 || (int)c !=32 || (int)c != 45)))
            {
                throw new NamingException("NameException: a special character exists.");
            }

        }


    }
}
