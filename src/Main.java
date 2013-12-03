public abstract class Main {

    private static final int tc = 50;

    public static void main(String[] arg) {
        Filter lock = new Filter(tc);
        Thread[] threads = new Thread[tc];
        int newThreadID = 0;
        for (int i = 0; i < tc; i++) {
            threads[i] = new Thread(new Test(lock, newThreadID));
            threads[i].start();
            newThreadID++;
        }
        try {
            for (int i = 0; i < tc; i++) {
                threads[i].join();
            }
        } catch (Exception ex) {
        }
        System.out.println(Test.number);
    }
}
