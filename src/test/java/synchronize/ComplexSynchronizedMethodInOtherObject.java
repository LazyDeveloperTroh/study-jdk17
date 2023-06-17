package synchronize;

public class ComplexSynchronizedMethodInOtherObject {
    /**
     * synchronize method와 static synchronize method를 함께 사용하는 경우다.
     * 결과를 살펴보면 static synchronize method를 사용하는 thread1과 thread2는 잘 동기화지만
     * 그냥 synchronized method를 사용하는 thread3은 동기화되지 않는 것을 볼 수 있다.
     *
     * 즉 두 범위는 lock을 공유하지 않기 때문에 혼용해서 사용한다면 원하는 결과를 얻을 수 없다.
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
        Thread thread3 = new Thread(() -> {
            b.method2("thread3");
        });
        thread1.start();
        thread2.start();
        thread3.start();
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

        private synchronized void method2(String name) {
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
