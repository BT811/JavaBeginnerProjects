package CollectionAndMapİnterface;
import java.util.ArrayList;


public class TeamFixture {
    public static void main(String[] args) {
        ArrayList<String> teams = new ArrayList<>();
        ArrayList<String> thisWeekFiks = new ArrayList<>();
        ArrayList<String> stashFiks = new ArrayList<>();
        ArrayList<Integer> randCheck = new ArrayList<>();
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");
        teams.add("Benfica");

        if (teams.size()%2==1){
            teams.add("Bay");
        }


        int round = 1;

        while (round <= 2*(teams.size()-1)){
            System.out.println("Round " + round);
            for (int i=0;i< teams.size()/2;i++){

                RNG(teams,randCheck,stashFiks,thisWeekFiks);

            }
            for (Object i : thisWeekFiks){
                System.out.println(i);
            }
            randCheck.clear();
            thisWeekFiks.clear();
            System.out.println("------------------");
            round++;
        }


    }

    public static void RNG(ArrayList teams,ArrayList randCheck,ArrayList stashFiks,ArrayList thisWeekFiks){
        int home = (int)((Math.random() * teams.size()));
        while (randCheck.contains(home)){
            home = (int)((Math.random() * teams.size()));
        }

        int guest = (int)((Math.random() * teams.size()));
        while (guest==home || randCheck.contains(guest)){
            guest = (int)((Math.random() * teams.size()));
        }

        String fiksComb = home + "" + guest;

        while (stashFiks.contains(fiksComb)){
            home = (int)((Math.random() * teams.size()));
            while (randCheck.contains(home)){
                home = (int)((Math.random() * teams.size()));
            }

            guest = (int)((Math.random() * teams.size()));
            while (guest==home || randCheck.contains(guest)){
                guest = (int)((Math.random() * teams.size()));
            }
            fiksComb = home + "" + guest;
        }
        randCheck.add(home);
        randCheck.add(guest);
        stashFiks.add(fiksComb);
        String match = teams.get(home) + " vs " + teams.get(guest);
        thisWeekFiks.add(match);


    }
}