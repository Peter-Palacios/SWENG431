import CustomExceptions.*;

public class Utility {

    //name cannot be zero or longer than '15' charactrs
    //a character can be space, "-", alphabet or ","
    // or exception thrown


    public boolean checkName(String s) throws InvalidNameFormatException
    {
        int inputLength = s.length();

        if(inputLength== 0 || inputLength > 15)
        {
            throw new InvalidNameFormatException("NameException: 0 <= " + inputLength + " characters <= 15 is invalid.");
        }
        String stringLowerCase = s.toLowerCase();

        char[] ascii = stringLowerCase.toCharArray();

        for (char c : ascii)
        {

            if ((int)c >=48 && (int)c <= 57)
            {
               throw new InvalidNameFormatException("NameException: a digit exists.");
            }
            else if ((int)c > 122 || ((int) c < 97 && ((int)c != 44 && (int)c !=32 && (int)c != 45)))
            {
                throw new InvalidNameFormatException("NameException: a special character exists.");
            }

        }


        return true;


    }

    public boolean checkAge(int age) throws InvalidAgeException
    {
        if(age >= 100)
        {
            throw new InvalidAgeException("AgeException: 0<= " +age+" <= 100 is invalid");
        }

        return true;
    }
}


























