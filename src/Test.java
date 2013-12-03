public class Test implements Runnable {
    public static volatile int number = 0;
    private Filter lock;
    private int threadID;

    public Test(Filter lock, int threadID){
        this.lock = lock;
        this.threadID = threadID;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            lock.lock(threadID);
            number++;
            lock.unlock(threadID);
        }
    }
}
