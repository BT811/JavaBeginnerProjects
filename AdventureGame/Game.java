import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void Start() {

        System.out.println("---Welcome The Game---");
        System.out.println("Enter your charachter's name:");
        String name = input.nextLine();
        Player player = new Player(name);
        System.out.println(player.getName()+" is created.");
        player.select_Class();
        player.player_stat();
        while(true){
            Location loc = null;
            System.out.println("-------Locations-------");
            System.out.println("1 - Safe House (Restore health,show stats and items)");
            System.out.println("2 - Tool Store");
            System.out.println("3 - Cave");
            System.out.println("4 - Forest");
            System.out.println("5 - River");
            System.out.println("6 - Win check");
            System.out.println("0 - Exit");
            int goLoc = input.nextInt();
            switch (goLoc){
                case 0:
                    loc = null;
                    break;
                case 1:
                    loc = new SafeLocation(player);

                    break;
                case 2:
                    loc = new ToolStore(player);
                    break;
                case 3:
                    loc = new Cave(player);
                    break;
                case 4:
                    loc = new Forest(player);
                    break;
                case 5:
                    loc = new River(player);
                    break;
                default:
                    loc = new SafeLocation(player);
            }

            if(loc == null){
                System.out.println("Good By Courageous Hero");
                break;
            }

            if(!loc.onLocation()){
                System.out.println("------GAME OVER-----");
                break;
            }


        }


    }
}
