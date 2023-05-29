import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int maxHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inv;

    public Player(String name){
        this.name = name;
        this.inv = new Inventory();

    }



    public void select_Class(){
        Scanner input = new Scanner(System.in);


        Char_Class[] charList = {new Samurai(), new Knight(), new Archer()};

        System.out.println("---Select Charachter Class---");

        for (Char_Class charClass: charList){

            System.out.println(charClass.getId() +"- Class: "+charClass.getClass_Name()+
                    "\tDamage: "+charClass.getDamage()+
                    "\tHealth: "+charClass.getHealth()+
                    "\tMoney: "+charClass.getMoney());

        }
        int select = input.nextInt();

        switch (select){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Knight());
                break;
            case 3:
                initPlayer(new Archer());
                break;
        };

    }

    public void initPlayer(Char_Class charClass){
        this.charName = charClass.getClass_Name();
        this.damage = charClass.getDamage();
        this.health = charClass.getHealth();
        this.maxHealth = charClass.getHealth();
        this.money = charClass.getMoney();
    }

    public void select_Location(){
        Scanner input = new Scanner(System.in);

        Location loc = null;
        System.out.println("Locations:");
        System.out.println("1 - Safe House");
        System.out.println("2 - Tool Store");
        int goLoc = input.nextInt();
        switch (goLoc){
            case 1:
                loc = new SafeLocation(this);
                break;
            case 2:
                loc = new ToolStore(this);
                break;
            default:
                loc = new SafeLocation(this);
        }
        loc.onLocation();
    }

    public void player_stat(){
        System.out.println();
        System.out.println("Name: "+this.getName());
        System.out.println(
                "---Charachter's class: "+this.charName+
                "\t---\t Damage: "+this.damage+
                "\t---\t Health: "+this.health+
                "\t---\t Money: "+this.money);
        System.out.println(
                "---Weapon: "+getInv().getWeapon().getName()+
                "\t---\t Armor: "+getInv().getArmor().getName()+
                "\t---\t Block: "+getInv().getArmor().getBlock());
        System.out.println();
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}
