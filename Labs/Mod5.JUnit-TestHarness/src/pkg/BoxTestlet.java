package pkg;
public class BoxTestlet implements TestletIF
{
    private TestHarness _testHarness;

    Box b = new Box();
    public BoxTestlet(TestHarness testHarness)
    {
        _testHarness = testHarness;
    }
    @Override
    public void runTest()
    {
        boolean tests[] = new boolean[13];
      tests[0] = _testHarness.checkEqual(b.getVolume(1,5,5), 25);
      tests[1] = _testHarness.checkEqual(b.getVolume(2,5,5), 50);
      tests[2] = _testHarness.checkEqual(b.getVolume(5,5,5), 125);
      tests[3] = _testHarness.checkEqual(b.getVolume(9,5,5), 225);
      tests[4] = _testHarness.checkEqual(b.getVolume(10,5,5), 250);
      tests[5] = _testHarness.checkEqual(b.getVolume(5,1,5), 25);
      tests[6] = _testHarness.checkEqual(b.getVolume(5,2,5), 50);
      tests[7] = _testHarness.checkEqual(b.getVolume(5,9,5), 225);
      tests[8] = _testHarness.checkEqual(b.getVolume(5,10,5), 250);
      tests[9] = _testHarness.checkEqual(b.getVolume(5,5,1), 25);
      tests[10] = _testHarness.checkEqual(b.getVolume(5,5,2), 50);
      tests[11] = _testHarness.checkEqual(b.getVolume(5,5,9), 225);
      tests[12] = _testHarness.checkEqual(b.getVolume(5,5,10), 250);


        for(int x=0; x <13;x++)
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
