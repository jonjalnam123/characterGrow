public class Npc {
    
    private int npcNo;
    private String name;
    private String Job;

    public Npc() {

    }

    public void selectNpc(int npcNo) {

        if( npcNo == 1 ) {
            this.name = "Dungeon Guardian";
            this.Job = "던전지킴이";
        } else if( npcNo == 2 ) {
            this.name = "Guardian";
            this.Job = "던전지킴이";
        }

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return this.Job;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }

    public int getNpcNo() {
        return this.npcNo;
    }

    public void setNpcNo(int npcNo) {
        this.npcNo = npcNo;
    }

}
