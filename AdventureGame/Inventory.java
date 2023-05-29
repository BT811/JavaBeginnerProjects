public class Inventory {
   private Weapon weapon;
   private Armor armor;
   private String caveAward;
   private String forestAward;
   private String riverAward;

    public Inventory() {
        this.weapon = new Weapon("Punch",-1,0,0);
        this.armor = new Armor("Nothing",-1,0,0);

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String getCaveAward() {
        return caveAward;
    }

    public void setCaveAward(String caveAward) {
        this.caveAward = caveAward;
    }

    public String getForestAward() {
        return forestAward;
    }

    public void setForestAward(String forestAward) {
        this.forestAward = forestAward;
    }

    public String getRiverAward() {
        return riverAward;
    }

    public void setRiverAward(String riverAward) {
        this.riverAward = riverAward;
    }
}
