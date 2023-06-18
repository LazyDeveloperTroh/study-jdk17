package synchronize;

public class SynchronizedBlockObj {
    private static final Object obj1 = new Object();
    private static final Object obj2 = new Object();

    /**
     * synchronize block마다 다른 lock을 생성하기 때문에
     * thread1과 thread2의 동기화가 지켜지지 않는 것을 볼 수 있다.
     * @param args
     */
    public static void main(String[] args) {
        SyncTestObject a = new SyncTestObject();
        Thread thread1 = new Thread(() -> {
            a.method1("thread1", obj1);
        });
        Thread thread2 = new Thread(() -> {
            a.method1("thread2", obj2);
        });
        thread1.start();
        thread2.start();
    }
    
    static class SyncTestObject {
        private void method1(String name, Object obj) {
            synchronized(obj) {
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
