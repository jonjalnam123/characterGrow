package Monster;

public class Monster1 {
    private String monName;
    private int monHp;
    private String monItem;

    public Monster1() {

        this.monName = "[ 던전 요괴 ]";
        this.monHp = 1000;
        this.monItem = "중간템";

    }

    public String getMonName() {
        return this.monName;
    }

    public void setMonName(String monName) {
        this.monName = monName;
    }

    public int getMonHp() {
        return this.monHp;
    }

    public void setMonHp(int monHp) {
        this.monHp = monHp;
    }

    public String getMonItem() {
        return this.monItem;
    }

    public void setMonItem(String monItem) {
        this.monItem = monItem;
    }
}
