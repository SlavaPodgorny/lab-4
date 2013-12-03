public class Filter {
    private volatile int[] level;
    private volatile int[] victim;

    public Filter(int n) {
        level = new int[n];
        victim = new int[n - 1];
    }

    public void lock(int me) {
        for (int j = 1; j < level.length; j++) {
            level[me] = j;
            victim[j - 1] = me;
            boolean flag = true;
            while (flag){
            	for (int k = 0; k < level.length; k++)
            		if (!(k != me &&
                		level[k] >= j &&
                		victim[j - 1] == me))
            		{
                			flag = false;
            				break;
            		}
            }
        }
    }

    public void unlock(int me) {
        level[me] = 0;
    }
}