import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Teacher t1 = new Teacher("Mahmut Hoca","TRH","555");
        Teacher t2 = new Teacher("Mert Hoca","Math","111");
        Teacher t3 = new Teacher("Mehmet Hoca","BİO","333");

        Course tarih = new Course("Tarih","101","TRH",t1);
        Course mat = new Course("MATHEMATİK","102","MATH",t2);
        Course bio = new Course("BİOLOJİ","103","BİO",t3);

        Student s1 = new Student("Şaban","111","4",tarih,mat,bio);
        s1.addBulkExamNote(46,78,59);
        s1.isPass();


        
    }
}
