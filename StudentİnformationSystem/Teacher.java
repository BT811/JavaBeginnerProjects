public class Teacher {
    String name;
    String mpno;
    String branch;

    Teacher (String name,String branch,String mpno){
        this.name = name;
        this.branch = branch;
        this. mpno = mpno;
    }


    void print(){
        System.out.println("Name: "+this.name);
        System.out.println("Teacher's branch: "+this.branch);
        System.out.println("Teachers's number: "+this.mpno);
    }


}
