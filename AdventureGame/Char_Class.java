public  class Char_Class {
    private int id;


    private String class_Name;
    private int damage;
    private int health;
    private int money;

    Char_Class(int id ,String class_Name, int damage, int health, int money){
        this.id = id;
        this.class_Name = class_Name;
        this.damage = damage;
        this.health = health;
        this.money = money;

    }

    public String getClass_Name() {
        return class_Name;
    }

    public void setClass_Name(String class_Name) {
        this.class_Name = class_Name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
