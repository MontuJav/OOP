import java.util.*;

public class Employee implements Comparable<Employee> {
   String firstName;
   String lastName;
   Date joinDate;
   public Employee(String firstName, String lastName) {
           this.firstName = firstName;
           this.lastName = lastName;
   }
   public String toString( ) {
          return firstName + " " + lastName;
   }
   public int compareTo(Employee another) {
       int compareValue =   this.firstName.compareTo(another.firstName); 
       if (compareValue == 0) {
          return this.lastName.compareTo(another.lastName);
       } 
       return compareValue;
   }
   public static void main(String [] args){
    List<Employee> listEmployees = new ArrayList<>();
    Employee employee1 = new Employee("George", "Benson");
    Employee employee2 = new Employee("George", "Shearing");
    Employee employee3 = new Employee("John", "Coltrane");
    Employee employee4 = new Employee("Diane", "Shure");
    Employee employee5 = new Employee("Diane", "Krall");
	Employee employee6 = new Employee("Miles", "Davis");
    listEmployees.add(employee1);
    listEmployees.add(employee2);
    listEmployees.add(employee3);
    listEmployees.add(employee4);
    listEmployees.add(employee5);
	listEmployees.add(employee6);
   
   System.out.println("Antes del sorting: \n" + listEmployees);
   Collections.sort(listEmployees);
   System.out.println("Despues del sorting: \n" + listEmployees);
  } // main
} // Clase Employee
 
