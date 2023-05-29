public class SafeLocation extends NormalLocation{
    SafeLocation(Player player){
        super(player,"Safe House");

    }

    @Override
    public boolean onLocation(){
        System.out.println("You are in the Safe House");
        System.out.println("Your health full now.");
        this.getPlayer().setHealth(this.getPlayer().getMaxHealth());
        this.getPlayer().player_stat();
        return true;

    }
}
