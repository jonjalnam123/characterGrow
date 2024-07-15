import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import Loding.LodingTimer;

public class App {

    //메인 카테고리 List
    static HashMap<Integer, String> categoryList = new HashMap<>(); 

    //게임시작 카테고리 List
    static HashMap<Integer, String> gameStartList = new HashMap<>(); 

    // 입력 받을 Scanner 클래스
    static Scanner sc = new Scanner(System.in); 
    
    // Sacnner로 입력받은 캐릭터 내용을 userList에 저장
    static ArrayList<User> userList = new ArrayList<User>();

    // userList에 저장된 갑을 userMapList로 Map에 저장 ( key : 캐릭터번호 , Value : 이하 캐릭터 정보)
    static HashMap<Integer, User> userMapList = new HashMap<>(); 

    // while 문에 들어갈 구분변수
    static boolean trueOrFalse = true; 

    // 캐릭터 유무 ( 1: 없음, 2: 있음 )
    static String characterYn = "1"; 

    // user 객체 초기화
    static User user = new User();

    public static void main(String[] args) throws Exception {
        
        main(characterYn); //1
        
    }

    /**
     * ========================================
     * @Title : main()
     * @Content : 메인
     * @Param : String characterYn
     * @Since : 2024.07.09
     * @Write : 최정석
     * ========================================
     */
    public static void main(String characterYn) throws InterruptedException {

        int index = 1; //증가 값 변수

        categoryList.put(1, "캐릭터 생성");
        categoryList.put(2, "보유 캐릭터 전체 조회");
        categoryList.put(3, "캐릭터 선택");
        categoryList.put(4, "게임 시작");
        categoryList.put(5, "게임 종료");
        
        if(characterYn.equals("1")) {

            //Thread.sleep(1500);
            System.out.println("");
            System.out.println("========== 사람 키우기 GAME 에 오신것을 환영합니다. ==========");

        } else if (characterYn.equals("2")) {
            
            System.out.println("");
            System.out.println("========== " + user.getName() + " 님 Main 으로 오신걸 환영합니다. ==========");

        }

        //Thread.sleep(1500);
        System.out.println("");
        System.out.println("원하시는 카테고리 번호를 선택해 주세요.");

        //Thread.sleep(1500);
        System.out.println("");

        for(Map.Entry<Integer, String> category : categoryList.entrySet()) {
                System.out.println(index  + " : " + category.getValue());
                index++;
        }
        
        //Thread.sleep(1500);

        while (trueOrFalse) {

            int categoryNum = 0;

            try {   

            System.out.println("");
            System.out.print("카테고리 번호 (숫자만 입력) : ");
            categoryNum = sc.nextInt();

            switch (categoryNum) {
                case 1: createCharacter(characterYn);
                        break;

                case 2: selectAllCharacterList();
                        break;

                case 3: chooseCharacter(characterYn);
                        break;

                case 4: gameStart(characterYn, user);
                        break;
                
                case 5: gameExit(characterYn);
                        break;

                default: System.out.println("");
                         System.out.println("올바른 번호를 입력해주세요."); 
                         //Thread.sleep(1000);
                         break;
            }

            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("문자를 입력하셨습니다. 다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    /**
     * ========================================
     * @Title : createCharacter()
     * @Content : 캐릭터 생성
     * @Param : String characterYn
     * @Since : 2024.07.09
     * @Write : 최정석
     * ========================================
     */
    public static void createCharacter(String characterYn) throws InterruptedException {

        user = new User();

        //Thread.sleep(1500);

        System.out.println("");
        System.out.println("========== 캐릭터 생성 ==========");

        // 중복체크 카운트
        int cnt = 0; 

        while (trueOrFalse) {

            //Thread.sleep(1500);
            System.out.println("");
            System.out.println("** 캐릭터 번호는 자동 생성 됩니다. **");
            int userRandomNo = (int) (Math.random() * 1001);
            
            // 신규
            if ( characterYn == "1" ) { 

                user.setUserNo(userRandomNo);
                break;

            // 캐릭터 보유중인 상태
            } else if ( characterYn.equals("2") && !userList.isEmpty() ) {  
                
                //Thread.sleep(1500);
                System.out.println("");
                System.out.println("** 보유 캐릭터가 있어 캐릭터 번호를 중복확인 하겠습니다. 잠시만 기다려주세요. **");

                //Timer.Time(3);
                //Thread.sleep(4000);        
                
                for( int i = 0; i < userList.size(); i++ ) {
                    
                    // 중복 체크
                    if ( userList.get(i).getUserNo() == userRandomNo ) { 

                        cnt++;
                        System.out.println("");
                        System.out.println("** 확인 결과 자동완성된 캐릭터 번호가 중복된 번호 입니다. 캐릭터를 다시 생성하겠습니다. **");
                        continue;

                    } 

                }

                if ( cnt == 0 ) {

                    System.out.println("");
                    System.out.println("** 확인 결과 자동완성된 캐릭터 번호가 중복되지 않았습니다. 캐릭터를 생성하겠습니다. **");
                    
                    user.setUserNo(userRandomNo);
                    break;
                }

            } 

        }

        //Thread.sleep(1500);

        // 캐릭터 이름
        while ( trueOrFalse ) {
            
            System.out.println("");
            System.out.print("이름 : ");
            String name = sc.next();

            // 문자열이 숫자를 포함하지 않는지 정규 표현식으로 검사
            if ( !name.matches("^[가-힣a-zA-Z]*$") ) {

                System.out.println("");
                System.out.println("** 이름을 올바르게 입력해주세요. **");
                continue;

            } else {
                
                user.setName(name);
                break;
            }
        }
        
        // 캐릭터 나이
        while ( trueOrFalse ) {

            try {

                System.out.println("");
                System.out.print("나이 : ");
                int age = sc.nextInt();
                user.setAge(age);
                break;

            } catch (InputMismatchException e) {

                System.out.println("");
                System.out.println("** 숫자로만 나이를 다시 입력해주세요. **");
                sc.nextLine();

            }

        }

        // 캐릭터 성별
        while ( trueOrFalse ) {

            System.out.println("");
            System.out.print("성별 ( 남자 or 여자 ): ");
            String gender = sc.next();

            if ( !gender.matches("^[가-힣a-zA-Z]*$") ) {

                System.out.println("");
                System.out.println("** 성별을 올바르게 입력해주세요. **");
                continue;

            } else {

                if ( gender.equals("남자") || gender.equals("여자") ) {

                    user.setGender(gender);
                    break;

                } else {

                    System.out.println("");
                    System.out.println("** 남자 or 여자 로만 입력해주세요. **");
                    continue;

                }
            }
        }

        // 캐릭터 등급
        while ( trueOrFalse ) {

            System.out.println("");
            System.out.print("등급 ( 부자 or 거지 ) : ");
            String grade = sc.next();

            if ( !grade.matches("^[가-힣a-zA-Z]*$") ) {

                System.out.println("");
                System.out.println("** 등급을 올바르게 입력해주세요. **");
                continue;

            } else {
                
                if ( grade.equals("부자") || grade.equals("거지") ) {

                    if ( grade.equals("부자") ) {

                        user.setGrade(grade);
                        user.setMoney(100000000);
                        break;

                    } else if ( grade.equals("거지") ) {

                        user.setGrade(grade);
                        user.setMoney(1000);
                        break;

                    }

                } else {

                    System.out.println("");
                    System.out.println("** 부자 or 거지 로만 입력해주세요. **");
                    continue;

                }
            }
        }

        //Thread.sleep(1000);

        System.out.println("");
        System.out.println("========== 입력 사항 확인 ==========");

        //Thread.sleep(1500);

        System.out.println("");
        System.out.println("캐릭터 번호 ( 자동 생성 ) : " + user.getUserNo());
        System.out.println("");
        System.out.println("캐릭터 이름 : " + user.getName());
        System.out.println("");
        System.out.println("캐릭터 나이 : " + user.getAge());
        System.out.println("");
        System.out.println("캐릭터 성별 : " + user.getGender());
        System.out.println("");
        System.out.println("캐릭터 등급 : " + user.getGrade());

        // 돈 형식 지정
        double money = user.getMoney();
        DecimalFormat formatter = new DecimalFormat("#,###.##");
        String formattedMoney = formatter.format(money);

        System.out.println("");
        System.out.println("캐릭터 머니 : " + formattedMoney + " 원");

        System.out.println("");
        System.out.println("===================================");

        //Thread.sleep(1000);

        while ( trueOrFalse ) {
            
            System.out.println("");
            System.out.println("입력하신 정보가 맞습니까?");

            System.out.println("");
            System.out.print("Y (y) or N (n) : ");
            String yOrN = sc.next();

            if ( !yOrN.matches("^[a-zA-Z]*$") ) {

                System.out.println("");
                System.out.println("** 올바른 답변을 해주세요. **");
                continue;

            } else {
                
                if( yOrN.equals("Y") || yOrN.equalsIgnoreCase("y") ) {

                    userList.add(user);

                    for (User userContent : userList) {
                        userMapList.put(userContent.getUserNo(), userContent);
                    }
                    
                    System.out.println("");
                    System.out.println("** 생성하신 캐릭터로 접속하겠습니다. **");
                    //Thread.sleep(1500);

                    System.out.println("");
                    System.out.println(user.getName() + " 님 반갑습니다. 게임시작을 위해 메인으로 돌아가겠습니다. 잠시만 기다려 주세요.");

                    //Timer.Time(3);
                    //Thread.sleep(4000);        

                    characterYn = "2";
                    main(characterYn);
                    trueOrFalse = false;

                } else if ( yOrN.equals("N") || yOrN.equalsIgnoreCase("n") ) {
                    
                    System.out.println("");
                    System.out.println("캐릭터 정보를 다시 입력하시겠습니까?");

                    System.out.println("");
                    System.out.print("Y (y) or N (n) : ");
                    String reAnswer = sc.next();

                    if( reAnswer.equals("Y") || reAnswer.equalsIgnoreCase("y") ) {

                        System.out.println("");
                        System.out.println("캐릭터 정보 입력으로 돌아가겠습니다. 잠시만 기다려 주세요.");      

                        //Timer.Time(3);
                        //Thread.sleep(4000);        
                        
                        if (characterYn == "1") { 

                            createCharacter("1"); 

                        } else {

                            createCharacter("2"); 

                        }
                     

                    } else if ( reAnswer.equals("N") || reAnswer.equalsIgnoreCase("n") ) {
                        
                        System.out.println("");
                        System.out.println("** 생성하신 캐릭터로 접속하겠습니다. **");
                        //Thread.sleep(1500);

                        userList.add(user);

                        for (User userContent : userList) {
                            userMapList.put(userContent.getUserNo(), userContent);
                        }

                        System.out.println("");
                        System.out.println(user.getName() + " 님 반갑습니다. 게임시작을 위해 메인으로 돌아가겠습니다. 잠시만 기다려 주세요.");

                        //Timer.Time(3);
                        //Thread.sleep(4000);
                        
                        characterYn = "2";
                        main(characterYn);
                        trueOrFalse = false;
                       

                    } else {
                        System.out.println("");
                        System.out.println("** 캐릭터 정보를 다시 확인해주세요. **");
                        //Thread.sleep(1000);
                        continue;
                    }

                } else {

                    System.out.println("");
                    System.out.println("** 캐릭터 정보를 다시 확인해주세요. **");
                    //Thread.sleep(1000);
                    continue;

                }
            }
        }
    }


    /**
     * ========================================
     * @Title : selectAllCharacterList()
     * @Content : 캐릭터 전체 조회
     * @Param : User user
     * @Since : 2024.07.09
     * @Write : 최정석
     * ========================================
     */
    public static void selectAllCharacterList() throws InterruptedException{
        
        if ( userList.size() > 0 ) {

            System.out.println("");
            System.out.println("========== 현재 보유한 캐릭터 ==========");

            for(int i = 0 ;  i < userList.size() ; i++) {
                System.out.println("");
                System.out.println("캐릭터 번호 ( 자동 생성 ) : " +  userList.get(i).getUserNo());

                System.out.println("");
                System.out.println("캐릭터 이름 : " + userList.get(i).getName());

                System.out.println("");
                System.out.println("캐릭터 나이 : " + userList.get(i).getAge());

                System.out.println("");
                System.out.println("캐릭터 성별 : " + userList.get(i).getGender());

                System.out.println("");
                System.out.println("캐릭터 등급 : " + userList.get(i).getGrade());

                // 돈 형식 지정
                double money = userList.get(i).getMoney();
                DecimalFormat formatter = new DecimalFormat("#,###.##");
                String formattedMoney = formatter.format(money);

                System.out.println("");
                System.out.println("캐릭터 머니 : " + formattedMoney);

                System.out.println("");
                System.out.println("===================================");
            }

            //Thread.sleep(4000);

            while (trueOrFalse) {
    
                System.out.println("");
                System.out.println("메인으로 돌아가시겠습니까?");
    
                System.out.println("");
                System.out.print("Y (y) or N (n) : ");
                String answer = sc.next();
    
                if ( answer.equals("Y") || answer.equalsIgnoreCase("y") ) {
                    
                    System.out.println("");
                    System.out.println("메인으로 돌아가겠습니다. 잠시만 기다려주세요.");

                    //Timer.Time(3);
                    //Thread.sleep(4000);    

                    main("2"); // 2 캐릭터 보유 상태
    
                } else if ( answer.equals("N") || answer.equalsIgnoreCase("n") ) {
    
                    System.out.println("");
                    System.out.println("보유 캐릭터를 다시 보여드리겠습니다.");

                    //Thread.sleep(1500);                

                    selectAllCharacterList();
    
                } else {
    
                    System.out.println("");
                    System.out.println("** 잘못 입력하셨습니다. 다시 입력해 주세요. **");

                    //Thread.sleep(1000);

                    continue;
                }
            }
            
        } else {

            System.out.println("");
            System.out.println("========== 현재 보유한 캐릭터 ==========");

            //Thread.sleep(1500);
            System.out.println("");
            System.out.println("** 현재 보유한 캐릭터가 없습니다. 캐릭터 생성을 위해 메인으로 으로 돌아가겠습니다. **");

            //Timer.Time(3);  
            //Thread.sleep(4000);
            main("1");

        }
    }

    /**
     * ========================================
     * @Title : chooseCharacter()
     * @Content : 캐릭터 선택
     * @Param : String characterYn
     * @Since : 2024.07.09
     * @Write : 최정석
     * ========================================
     */
    public static void chooseCharacter(String characterYn) throws InterruptedException {
        
        while (trueOrFalse) {

            System.out.println("");
            System.out.println("========== 캐릭터 선택 ==========");

            // 신규접속
            if (characterYn.equals("1")) { 
                
                //Thread.sleep(1500);
                System.out.println("");
                System.out.println("** 현재 보유한 캐릭터가 없습니다. 캐릭터 생성을 위해 메인으로 으로 돌아가겠습니다. **");

                //Timer.Time(3);
                //Thread.sleep(4000);

                main("1");

                trueOrFalse = false;
            
            // 캐릭터 보유상태
            } else if (characterYn.equals("2")) { 

                System.out.println("");
                System.out.println(user.getName() + " 님 께서 접속 원하시는 캐릭터 번호를 입력해주세요.");

                System.out.println("");
                System.out.println("========== 현재 보유한 캐릭터 ==========");

                for(int i = 0 ;  i < userList.size() ; i++) {

                    System.out.println("");
                    System.out.println("캐릭터 번호 ( 자동 생성 ) : " +  userList.get(i).getUserNo());

                    System.out.println("");
                    System.out.println("캐릭터 이름 : " + userList.get(i).getName());

                    System.out.println("");
                    System.out.println("캐릭터 나이 : " + userList.get(i).getAge());

                    System.out.println("");
                    System.out.println("캐릭터 성별 : " + userList.get(i).getGender());

                    System.out.println("");
                    System.out.println("캐릭터 등급 : " + userList.get(i).getGrade());

                    // 돈 형식 지정
                    double money = userList.get(i).getMoney();
                    DecimalFormat formatter = new DecimalFormat("#,###.##");
                    String formattedMoney = formatter.format(money);

                    System.out.println("");
                    System.out.println("캐릭터 머니 : " + formattedMoney);

                    System.out.println("");
                    System.out.println("===================================");
                }

                System.out.println("");
                System.out.print("캐릭터 번호 : ");
                int userNumToFind = sc.nextInt(); 

                if ( userMapList.containsKey(userNumToFind) ) {

                    User user = userMapList.get(userNumToFind);
                    
                    System.out.println("");
                    System.out.println("========== 선택한 캐릭터 정보 ==========");

                    System.out.println("");
                    System.out.println("캐릭터 번호 ( 자동 생성 ) : " + user.getUserNo());
                    
                    System.out.println("");
                    System.out.println("캐릭터 이름 : " + user.getName());

                    System.out.println("");
                    System.out.println("캐릭터 나이 : " + user.getAge());

                    System.out.println("");
                    System.out.println("캐릭터 성별 : " + user.getGender());

                    System.out.println("");
                    System.out.println("캐릭터 등급 : " + user.getGrade());

                    // 돈 형식 지정
                    double money = user.getMoney();
                    DecimalFormat formatter = new DecimalFormat("#,###.##");
                    String formattedMoney = formatter.format(money);

                    System.out.println("");
                    System.out.println("캐릭터 머니 : " + formattedMoney);

                    System.out.println("");
                    System.out.println("================================");
                    
                    System.out.println("");
                    System.out.println("선택한 캐릭터로 GAME 진행하시겠습니까?");
                    
                    System.out.println("");
                    System.out.print("Y (y) or N (n) : ");
                    String answer = sc.next();
        
                    if ( answer.equals("Y") || answer.equalsIgnoreCase("y") ) {
                    
                        System.out.println("");
                        System.out.println(user.getName() + " 님 환영합니다.");
                        
                        System.out.println("");
                        System.out.println("GAME 을 시작하겠습니다. 잠시만 기다려주세요.");

                        //Timer.Time(3);
                        //Thread.sleep(4000);    
    
                        gameStart(characterYn, user);
                        break;
        
                    } else if ( answer.equals("N") || answer.equalsIgnoreCase("n") ) {
        
                        System.out.println("");
                        System.out.println("캐릭터를 다시 선택해주세요.");
    
                        //Thread.sleep(1500);                

                        continue;
        
                    } else {
        
                        System.out.println("");
                        System.out.println("** 잘못 입력하셨습니다. 다시 입력해 주세요. **");
    
                        //Thread.sleep(1000);

                        continue;
                    }

                } else {

                    System.out.println("** 해당 번호의 캐릭터가 없습니다. 다시 입력해주세요. **");
                    continue;

                }

            }
            
        }

    }

    /**
     * ========================================
     * @Title : gameStart()
     * @Content : 게임시작
     * @Param : User user
     * @Since : 2024.07.09
     * @Write : 최정석
     * ========================================
     */
    public static void gameStart(String characterYn, User user) throws InterruptedException{

        if( characterYn == "1" ) { 

            //Thread.sleep(1500);
            System.out.println("");
            System.out.println("** 현재 보유한 캐릭터가 없습니다. 캐릭터 생성을 위해 메인으로 으로 돌아가겠습니다. **");

            main("1");

        } else if ( characterYn == "2" ) { 

            System.out.println("");
            System.out.println("========== GAME 을 시작합니다. ==========");

            System.out.println("");
            System.out.println(user.getName() + " 님 환영합니다. 지금 부터 기본 아이템을 선사하겠습니다.");

            System.out.println("");
            System.out.println("==============================");

            Item item = new Item();

            System.out.println("");
            System.out.println("아이템명 : " + item.getItemName());

            System.out.println("");
            System.out.println("아이템파워 : " + item.getItemPower());

            System.out.println("");
            System.out.println("아이템스킬 : " + item.getItemSkill());

            System.out.println("");
            System.out.println("아이템등급 : " + item.getItemUpGrade());

            System.out.println("");
            System.out.println("==============================");

        }

        int index = 1; //증가 값 변수

        gameStartList.put(1, "던전 입장");
        gameStartList.put(2, "보유 아이템 조회");
        gameStartList.put(3, "보유 머니 조회");
        gameStartList.put(4, "메인으로 돌아가기");
    

        //Thread.sleep(1500);
        System.out.println("");
        System.out.println("");

        //Thread.sleep(1500);
        System.out.println("");

        for(Map.Entry<Integer, String> startList : gameStartList.entrySet()) {
                System.out.println(index  + " : " + startList.getValue());
                index++;
        }

         //Thread.sleep(1500);

         while (trueOrFalse) {

            int startNum = 0;

            try {   

                System.out.println("");
                System.out.print("카테고리 번호 (숫자만 입력) : ");
                startNum = sc.nextInt();

                switch (startNum) {
                    case 1: goToDungeon();
                            break;

                    case 2: 
                            break;

                    case 3: 
                            break;

                    default: System.out.println("");
                            System.out.println("올바른 번호를 입력해주세요."); 
                            //Thread.sleep(1000);
                            break;
                }

            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("문자를 입력하셨습니다. 다시 입력해주세요.");
                sc.nextLine();
            }
        }
        
    }


    public static void goToDungeon() {
        
        System.out.println("진행중");
        System.out.println("진행중222");
    }

    /**
     * ========================================
     * @Title : gameExit()
     * @Content : 게임종료
     * @Param : String characterYn
     * @Since : 2024.07.09
     * @Write : 최정석
     * ========================================
     */
    public static void gameExit(String characterYn) throws InterruptedException {

        while (trueOrFalse) {
    
            System.out.println("");
            System.out.println("** 정말로 게임을 종료하시겠습니까? **");

            System.out.println("");
            System.out.print("Y (y) or N (n) : ");
            String answer = sc.next();

            if ( answer.equals("Y") || answer.equalsIgnoreCase("y") ) {

                System.out.println("");
                System.out.println("** 게임은 종료되고 모든 정보는 사라지게됩니다. **");
                
                //LodingTimer.Time(3);
                //Thread.sleep(4000);

                System.exit(0); // 종료

            } else if ( answer.equals("N") || answer.equalsIgnoreCase("n") ) {

                if (characterYn == "1") { 

                    characterYn = "1";
                    main(characterYn);

                } else if ( characterYn == "2" ) {

                    characterYn = "2";
                    main(characterYn);

                }

                //Thread.sleep(1500);                

            } else {

                System.out.println("");
                System.out.println("** 잘못 입력하셨습니다. 다시 입력해 주세요. **");

                //Thread.sleep(1000);

                continue;
            }

        }

    }

}
