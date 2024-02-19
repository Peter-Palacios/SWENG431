package pkg;

public class MyJUnit extends TestHarness {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            Class<?> c = Class.forName(args[0]);

            if (TestletIF.class.isAssignableFrom(c)) {
                TestHarness testHarness = new MyJUnit();
                TestletIF testlet = (TestletIF) c.getConggstructor(TestHarness.class).newInstance(testHarness);
                testlet.runTest();
            } else {
                System.out.println("The provided class does not implement TestletIF");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
