package synchronize;

public class SynchronizedMethodInOtherObject {
    /**
     * 2개의 인스턴스 각각에서 synchronize method를 서로 다른 스레드가 실행한 경우이다.
     * synchronized method의 경우 instance에 lock을 걸기때문에 서로 다른 객체에서
     * 해당 메소드를 실행하는 경우 동기화를 보장할 수 없다.
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
        private synchronized void method1(String name) {
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
