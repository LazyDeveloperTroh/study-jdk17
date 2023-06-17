package synchronize;

public class SynchronizedMethodInOhterObject {
    /**
     * synchronized method를 포함하는 객체에 lock이 잡히는 것을 확인
     * @param args
     */
    public static void main(String[] args) {
        SyncTestObject a = new SyncTestObject();
        SyncTestObject b = new SyncTestObject();

        Thread thread1 = new Thread(() -> {
            a.run("thread1");
        });
        Thread thread2 = new Thread(() -> {
            b.run("thread2");
        });
        thread1.start();
        thread2.start();
    }
    
    static class SyncTestObject {
        private synchronized void run(String name) {
            try {
                System.out.println(name +" lock");
                Thread.sleep(1000);
                System.out.println(name +" unlock");
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
