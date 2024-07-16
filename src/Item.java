public class Item {

    private String itemName; // 아이템 이름
    private int itemPower; // 아이템 파워
    private String itemSkill; // 아이템 능력
    private String itemUpGrade;

    public Item () {

        this.itemName = "쪼렙템";
        this.itemPower = 100;
        this.itemSkill = "무능력";
        this.itemUpGrade = "1성";

    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPower() {
        return this.itemPower;
    }

    public void setItemPower(int itemPower) {
        this.itemPower = itemPower;
    }

    public String getItemSkill() {
        return this.itemSkill;
    }

    public void setItemSkill(String itemSkill) {
        this.itemSkill = itemSkill;
    }

    public String getItemUpGrade() {
        return this.itemUpGrade;
    }

    public void setItemUpGrade(String itemUpGrade) {
        this.itemUpGrade = itemUpGrade;
    }
    
}
