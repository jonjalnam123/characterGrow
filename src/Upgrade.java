import Loding.ItemUpgradeTimer;

public class Upgrade {

    public String UpgradeItem(int itemUpgrade) throws InterruptedException {

        ItemUpgradeTimer itemUpgradeTimer = new ItemUpgradeTimer();

        String result = "";

        // 업그레이드 빗나갈 확률 설정 (20%)
        double missChance = 0.2;

        ItemUpgradeTimer.Time(3);
        Thread.sleep(4000);    

        if ( Math.random() < missChance) { 
                    
            System.out.println("");
            System.out.println("업그레이드 실패!!!");
            result = "1";

        } else {
                  
            System.out.println("");
            System.out.println("업그레이드 성공!!!");
            result = "2";
        }

        return result;
    }
    
}
