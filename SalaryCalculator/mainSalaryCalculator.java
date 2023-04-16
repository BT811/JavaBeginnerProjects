public class mainSalaryCalculator {
    public static void main(String[] args) {
        Employee n1 = new Employee("Mert",2000,45,1985);
        n1.tax();
        n1.bonus();
        n1.raiseSalary();
        n1.toStringPrint();


    }
}
