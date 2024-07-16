package Npc;

/**
 * dungeonGatekeeper
 */
public class DungeonGatekeeper {

    private String npcName;
    private String npcContent;

    public DungeonGatekeeper() {
        this.npcName = "[ 던전지킴이 ]";
        this.npcContent = " 님 여기까지 오시다니 대단합니다... 던전에서 어디 한번 잘 버텨보십쇼...";
    }

    public String getNpcName() {
        return this.npcName;
    }

    public void setNpcName(String npcName) {
        this.npcName = npcName;
    }

    public String getNpcContent() {
        return this.npcContent;
    }

    public void setNpcContent(String npcContent) {
        this.npcContent = npcContent;
    }
    
}