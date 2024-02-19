package pkg;


public class RectangleTestlet implements TestletIF
{
    private TestHarness _testHarness;
    public RectangleTestlet(TestHarness testHarness)
    {
        _testHarness=testHarness;
    }
    Rectangle r = new Rectangle();
    @Override
    public void runTest()
    {
        boolean tests[] = new boolean[9];

        tests[0] = _testHarness.checkEqual(r.getArea(1,5), 5);
        tests[1] = _testHarness.checkEqual(r.getArea(2,5), 10);
        tests[2] = _testHarness.checkEqual(r.getArea(5,5), 25);
        tests[3] = _testHarness.checkEqual(r.getArea(9,5), 45);
        tests[4]=  _testHarness.checkEqual(r.getArea(10,5), 50);
        tests[5] = _testHarness.checkEqual(r.getArea(5,1), 5);
        tests[6] = _testHarness.checkEqual(r.getArea(5,2), 10);
        tests[7] = _testHarness.checkEqual(r.getArea(5,9), 45);
        tests[8] = _testHarness.checkEqual(r.getArea(5,10), 50);


        for(int x=0; x <9;x++)
        {
            if(tests[x])
            {
                System.out.println("test " + (x+1) +": passed");
            }

            if(!tests[x])
            {
                System.out.println("test " + (x+1) +": failed");
            }
        }


    }

}
