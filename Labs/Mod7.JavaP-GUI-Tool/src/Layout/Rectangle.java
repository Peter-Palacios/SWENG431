package Layout;

public class Rectangle
{
    int w, h;
    public Rectangle()
    {

    }
    public Rectangle(int w, int h)
    {
        this.w = w;
        this.h=h;

    }
    public int getArea() throws Exception
    {
        return w* h;
    }

}
