import java.util.Random;

public abstract class BattleLocation extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;
    BattleLocation(Player player,String name,Monster monster,String award, int maxMonster){
        super(player,name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }
    public boolean onLocation(){
        int numMonster = randomMonster();
        System.out.println(this.getMonster().getName());
        System.out.println("This place doesn't look very safe.");
        System.out.println("there may be "+numMonster+" monster around.");
        monsterStat();
        System.out.println("Your Health: "+getPlayer().getHealth());
        System.out.println("1 - Fight");
        System.out.println("2 - Flee");
        int sel = input.nextInt();
        if(sel == 1){
            if(combat(numMonster) == false) return false;
        }
        if(this.award.equals("Food")) getPlayer().getInv().setCaveAward("Food");
        if(this.award.equals("Firewood")) getPlayer().getInv().setForestAward("Firewood");
        if(this.award.equals("Water")) getPlayer().getInv().setRiverAward("Water");
            return true;
    }

    public boolean combat(int numMonster){
        for(int i = 0; i < numMonster; i++){
            this.monster.setHealth(this.getMonster().getOrjinalHealth());

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0){
                System.out.println("Number of Monsters remaining :"+(numMonster-i));
                System.out.println("1 - Hit");
                System.out.println("2 - Flee");
                int sel = input.nextInt();
                if(sel == 1 ){
                    Random random = new Random();
                    int firstHit = random.nextInt(2);
                    if(firstHit == 1){
                        System.out.println("You hit the first");
                        this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getDamage());
                        if(this.getMonster().getHealth() <= 0){
                            System.out.println("Moster dead.");
                            break;
                        }else{
                            int monsterHit = this.getMonster().getDamage() -this.getPlayer().getInv().getArmor().getBlock();
                            if(monsterHit < 0){
                                monsterHit = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth()-monsterHit);
                        }
                        if(this.getPlayer().getHealth() <= 0){
                            System.out.println("You died");
                            return false;
                        }
                    } else if (firstHit == 0){
                        System.out.println("Monster hit the first");
                        int monsterHit = this.getMonster().getDamage() -this.getPlayer().getInv().getArmor().getBlock();
                        if(monsterHit < 0){
                            monsterHit = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth()-monsterHit);
                        if(this.getPlayer().getHealth() <= 0){
                            System.out.println("You died");
                            return false;
                        }else{
                            this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getDamage());
                            if(this.getMonster().getHealth() <= 0){
                                System.out.println("Moster dead.");
                                break;
                            }
                        }
                    }
                    System.out.println("Your Health: "+getPlayer().getHealth()+"\t\t Your Damage: "+this.getPlayer().getDamage());
                    System.out.println("Monster Health: "+this.getMonster().getHealth()+"\tMonster Damage: "+this.getMonster().getDamage());
                } else if (sel == 2) {
                    return true;
                }
            }
        }

        int gold = 0;

        for(int j = 0 ; j < numMonster ; j++){
            gold += this.getMonster().getAward();
            this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getMonster().getAward());
        }

        System.out.println("Money: +"+gold);

        return true;
    }

    public void monsterStat(){
        System.out.println(getMonster().getName());
        System.out.println("Monster Damage:"+getMonster().getDamage());
        System.out.println("Monster Health:"+getMonster().getHealth());
        System.out.println("-----------------");
    }

    public int randomMonster(){
        Random r = new Random();
        return  r.nextInt(this.maxMonster) + 1 ;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
