import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Employee2 implements Comparator<Employee2> {
   String firstName;
   String lastName;
   Date joinDate;

   public Employee2(String firstName, String lastName, Date joinDate) {
           this.firstName = firstName;
           this.lastName = lastName;
           this.joinDate = joinDate;
   }
   public Employee2() {
   }

   public String toString() {
     DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
     return firstName + " " + lastName + " " + dateFormat.format(joinDate);
   }
   
   public Date getJoinDate(){
      return joinDate; 
   }
   
   public int compare(Employee2 emp1, Employee2 emp2) {
       return emp1.getJoinDate().compareTo(emp2.getJoinDate());
   }
   
   public static void main(String[] args) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        List<Employee2> listEmployees = new ArrayList<>();
        Employee2 employee1 = new Employee2("Tom", "Eagar", dateFormat.parse("2007-12-03"));
        Employee2 employee2 = new Employee2("Tom", "Smith", dateFormat.parse("2005-06-20"));
        Employee2 employee3 = new Employee2("Bill", "Joy", dateFormat.parse("2009-01-31"));
        Employee2 employee4 = new Employee2("Bill", "Gates", dateFormat.parse("2005-05-12"));
        Employee2 employee5 = new Employee2("Alice", "Wooden", dateFormat.parse("2009-01-22"));
        listEmployees.add(employee1);
        listEmployees.add(employee2);
        listEmployees.add(employee3);
        listEmployees.add(employee4);
        listEmployees.add(employee5);
        System.out.println("Antes del sorting: \n");
        System.out.println(listEmployees);
        Collections.sort(listEmployees, new Employee2());
        System.out.println("Despues del sorting: \n");
        System.out.println(listEmployees);
    } 
}
