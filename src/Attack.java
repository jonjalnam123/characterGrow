import java.util.Scanner;

import Monster.Monster1;

public class Attack {

    public String Hit(int itemPower) { 

        Scanner sc = new Scanner(System.in);

        Monster1 monster1 = new Monster1();

        String result = "";

        // 공격 빗나갈 확률 설정 (30%)
        double missChance = 0.3;

         // 게임 시작
         System.out.println("");
         System.out.println("몬스터와의 전투를 시작합니다. 'Q' 또는 'q' 를 입력하여 몬스터를 공격하세요!");

         while (monster1.getMonHp() > 0) {

            System.out.println("");
            System.out.print("입력 :  ");
            String input = sc.next();

            if (input.equals("Q") || input.equalsIgnoreCase("q")) {

                if ( Math.random() < missChance) { 
                    
                    System.out.println("");
                    System.out.println("공격이 빗나갔습니다! 몬스터에게 피해를 입히지 못했습니다.");

                } else {

                    int damage = itemPower;
                    monster1.setMonHp(monster1.getMonHp() - damage);
                    
                    System.out.println("");
                    System.out.println("몬스터에게 " + damage + "의 피해를 입혔습니다. 남은 체력: " + monster1.getMonHp());
                    
                    if (monster1.getMonHp() <= 0) {
                        
                        result = "1";

                    }

                }

            } else {

                System.out.println("");
                System.out.println("잘못된 입력입니다. 'Q' 또는 'q '를 입력하여 몬스터를 공격하세요.");
                continue;

            }
        }
        return result;
    }
}
