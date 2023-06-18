package synchronize;

public class SynchronizedBlockThis {
    /**
     * synchronize this의 경우 모든 block이 같은 lock을 공유한다.
     * thread1이 lock을 잡았기 때문에 thread1이 끝날떄까지 thread2는
     * 대기하는 것을 확인할 수 있다.
     * @param args
     */
    public static void main(String[] args) {
        SyncTestObject a = new SyncTestObject();
        Thread thread1 = new Thread(() -> {
            a.method1("thread1");
        });
        Thread thread2 = new Thread(() -> {
            a.method1("thread2");
        });
        thread1.start();
        thread2.start();
    }
    
    static class SyncTestObject {
        private void method1(String name) {
            synchronized(this) {
                try {
                    for(int i=0; i<10; i++) {
                        System.out.println(name);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
