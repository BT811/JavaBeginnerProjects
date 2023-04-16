public class Employee {
    String name;
    int salary;
    int workHours;
    int hireYear;
    int tax,bonus,raiseSalary = salary;
    Employee(String name, int salary, int workHours , int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    int tax(){
        int tax;

        if(salary >= 1000){
            tax = salary * 3 / 100;
            System.out.println("TAX = "+tax);
            return this.tax = tax ;
        }else{
            System.out.println("TAX = 0");
            return this.tax = 0;
        }
    }


    int bonus() {
        if (workHours > 40) {
            int bonus;
            bonus = workHours - 40;
            bonus *= 30;
            System.out.println("Bonus = "+bonus);
            return  this.bonus = bonus;
        }else{
            System.out.println("Bonus = 0");
            return this.bonus = 0;
        }
    }

    int raiseSalary() {
        int currentYear = 2021;

        if (currentYear - hireYear < 10) {
            int increase2;
            increase2 = salary * 5 / 100;
            System.out.println("Salary increase = "+increase2);
            return this.salary += increase2;
        } else if (currentYear - hireYear > 9 && currentYear - hireYear < 20) {
            int increase2;
            increase2 = salary * 10 / 100;
            System.out.println("Salary increase = "+increase2);
            return this.salary += increase2;
        } else {
            int increase2;
            increase2 = salary * 15 / 100;
            System.out.println("Salary increase = "+increase2);
            return this.salary+= increase2;
        }
    }

    public void toStringPrint(){
        System.out.println("Name: "+this.name);
        System.out.println("Salary: "+this.salary+" Salary with bonus and tax added: "+(this.salary+this.bonus-this.tax));
        System.out.println("Work hours: "+this.workHours);
        System.out.println("Recruitment date: "+this.hireYear);

   }





}
