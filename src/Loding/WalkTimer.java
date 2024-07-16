package Loding;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

public class WalkTimer {
    public static void Time(int countdownStarter) {
        
    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable runnable = new Runnable() {
            int countDownTime = countdownStarter;

            public void run() {
                System.out.println("");
                System.out.println(countDownTime + " 보 이동 중...");
                countDownTime--;

                if (countDownTime < 1) {
                    System.out.println("");
                    System.out.println("** 도착 **");
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }
}
