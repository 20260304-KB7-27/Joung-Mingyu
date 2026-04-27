package basic.ch14.lecture.deadlock;

public class DeadlockExample {
    /// 데드락
    /// - 두 개 이상의 스레드가 서로 가진 락을 기다리면서 무한정 대기하는 상태
    ///
    /// 데드락 발생 조건
    /// - 상호 배제 -> 한번에 하나의 공유 자원만 사용 가능하다
    /// - 점유 대기 -> 하나를 가지고 다른 공유 자원을 기다리는
    /// - 비선점 -> 강제로 다른 스레드가 점유한 공유 자원을 뺏을 수 없음
    /// - 순환 대기 -> 서로 물려있는 상태
    ///
    /// 일반적인 락 해제 방법
    /// -> 락 획득 순서를 통일 (모든 스레드가 티셔츠 -> 바지 순으로 접근 가능하게 설계)

    // 공유 자원
    static final Object shirt = new Object();
    static final Object pants = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (shirt) {
                    System.out.println("형: 티셔츠를 입었다. 바지를 입자.");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("형: 바지 찾으러 가는 중...");
                }

                synchronized (pants) {
                    System.out.println("형: 옷 다 입었다!");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (pants) {
                    System.out.println("동생: 바지를 입었다. 티셔츠를 입자.");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("동생: 티셔츠 찾으러 가는 중...");
                }

                synchronized (shirt) {
                    System.out.println("동생: 옷 다 입었다!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
