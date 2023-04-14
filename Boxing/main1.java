public class main1 {
    public static void main(String[] args) {
        Fighter f1 = new Fighter("A",10,120,100,70);
        Fighter f2 = new Fighter("B",25,90,90,30);

        Match match1 = new Match(f1,f2,90,100);

        match1.run();
    }
}
