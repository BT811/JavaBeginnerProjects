public class ToolStore extends NormalLocation{
    ToolStore(Player player){
        super(player,"Tool Store");
    }
    @Override
    public boolean onLocation(){
        getPlayer().player_stat();
        System.out.println("Welcome the Tool Store");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit");
            int sel = input.nextInt();
            while (sel>3 || sel<1){
                System.out.println("Select again!!!");
                sel = input.nextInt();
            }
            switch (sel){
                case 1:
                    buyWeapon();
                    break;
                case 2:
                    buyArmor();
                    break;
                case 3:
                    System.out.println("See you again.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void buyWeapon(){
        System.out.println("-----Weapons-----");
        System.out.println("Choose a weapon.");
        printWeapons();
        System.out.println("0-   Exit");

        int selectWeapon = input.nextInt();
        while (selectWeapon<0 || selectWeapon>Weapon.weapons().length){
            System.out.println("There's no weapon there, take a look again");
            selectWeapon = input.nextInt();
        }

        if(selectWeapon != 0){
            if(getWeaponById(selectWeapon) != null ){
                if(getWeaponById(selectWeapon).getPrice() <= getPlayer().getMoney()){
                    System.out.println("Your new item: "+getWeaponById(selectWeapon).getName());
                    System.out.println(this.getPlayer().getInv().getWeapon().getName()+" replaced with "+getWeaponById(selectWeapon).getName());
                    int balance = this.getPlayer().getMoney() - getWeaponById(selectWeapon).getPrice();
                    getPlayer().setMoney(balance);
                    System.out.println("Money: "+getPlayer().getMoney());
                    this.getPlayer().setDamage(this.getPlayer().getDamage()-this.getPlayer().getInv().getWeapon().getDamage()+getWeaponById(selectWeapon).getDamage());
                    this.getPlayer().getInv().setWeapon(getWeaponById(selectWeapon));

                }else{
                    System.out.println("You don't have enough money.");
                }
            }
        }

    }
    public void buyArmor(){
        System.out.println("-----Armor-----");
        System.out.println("Choose a armor.");
        printArmors();
        System.out.println("0-   Exit");

        int selectArmor = input.nextInt();
        while (selectArmor<0 || selectArmor>Armor.armors().length){
            System.out.println("There's no armor there, take a look again");
            selectArmor = input.nextInt();
        }

        if(selectArmor != 0){
            if(getArmorById(selectArmor) != null ){
                if(getArmorById(selectArmor).getPrice() <= getPlayer().getMoney()){
                    System.out.println("Your new item: "+getArmorById(selectArmor).getName());
                    System.out.println(this.getPlayer().getInv().getArmor().getName()+" replaced with "+getArmorById(selectArmor).getName());
                    int balance = this.getPlayer().getMoney() - getArmorById(selectArmor).getPrice();
                    getPlayer().setMoney(balance);
                    System.out.println("Money: "+getPlayer().getMoney());
                    this.getPlayer().getInv().setArmor(getArmorById(selectArmor));
                }else{
                    System.out.println("You don't have enough money.");
                }
            }
        }
    }

    public void printArmors(){
        for(Armor w : Armor.armors()){
            System.out.println(w.getId()+"-\t "+w.getName()+"\tBlock: "+w.getBlock()+"\tPrice: "+w.getPrice());
        }
    }
    public static Armor getArmorById(int id){
        for(Armor w: Armor.armors()){
            if(w.getId() == id) return w;
        }
        return null;
    }

    public void printWeapons(){
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId()+"-\t "+w.getName()+"\tDamage: "+w.getDamage()+"\tPrice: "+w.getPrice());
        }
    }
    public static Weapon getWeaponById(int id){
        for(Weapon w: Weapon.weapons()){
            if(w.getId() == id) return w;
        }
        return null;
    }

}
