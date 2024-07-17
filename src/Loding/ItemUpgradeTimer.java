package Loding;

import static java.util.concurrent.TimeUnit.SECONDS;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ItemUpgradeTimer {
     public static void Time(int countdownStarter) {
        
    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable runnable = new Runnable() {
            int countDownTime = countdownStarter;

            public void run() {
                System.out.println("");
                System.out.println(countDownTime + " 번 쾅..!!");
                countDownTime--;

                if (countDownTime < 1) {
                    System.out.println("");
                    System.out.println("** 강화 끝 **");
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }
    
}
