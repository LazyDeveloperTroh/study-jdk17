package synchronize;

public class StaticSynchronizedMethodInOtherObject {
    /**
     * static synchronized method는 클래스 단위로 lock을 한다.
     * 객체가 2개 이더라도 클래스 단위로 lock을 했기 때문에 2개의 스레드가 동기화된 것을 볼 수 있다.
     * @param args
     */
    public static void main(String[] args) {
        SyncTestObject a = new SyncTestObject();
        SyncTestObject b = new SyncTestObject();

        Thread thread1 = new Thread(() -> {
            a.method1("thread1");
        });
        Thread thread2 = new Thread(() -> {
            b.method1("thread2");
        });
        thread1.start();
        thread2.start();
    }
    
    static class SyncTestObject {
        private static synchronized void method1(String name) {
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
