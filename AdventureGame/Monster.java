public class Monster {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int orjinalHealth;
    private int award;
    Monster(String name, int id, int damage,int orjinalHealth, int health,int award){
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.orjinalHealth = orjinalHealth;
        this.health = health;
        this.award = award;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
}
