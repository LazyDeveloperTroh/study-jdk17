package synchronize;

public class SynchronizedMethodInSameObject {
    /**
     * 1개의 인스턴스에서 synchronize method를 서로 다른 스레드가 실행한 경우이다.
     * 스레드1에서 해당 메소드를 사용하고 있기 때문에 10회를 마칠 때 까지
     * 스레드2에서 접근할 수 없다.
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
