import java.util.Scanner;

class Employee {
String empName, empId, address, mailId, mobileNo, designation;
double basicPay, da, hra, pf, staffClub, grossSalary, netSalary;

Employee(String empName, String empId, String address, String mailId, String mobileNo, double basicPay, String designation) {
this.empName = empName;
this.empId = empId;
this.address = address;
this.mailId = mailId;
this.mobileNo = mobileNo;
this.basicPay = basicPay;
this.designation = designation;
}

void calculateSalary(double daPercent, double hraPercent, double pfPercent, double staffClubPercent) {
da = (daPercent / 100) * basicPay;
hra = (hraPercent / 100) * basicPay;
pf = (pfPercent / 100) * basicPay;
staffClub = (staffClubPercent / 100) * basicPay;

grossSalary = basicPay + da + hra;
netSalary = grossSalary - pf - staffClub;
}

void displayPaySlip() {
System.out.println("\n----- PAY SLIP -----");
System.out.println("Name : " + empName);
System.out.println("ID : " + empId);
System.out.println("Address : " + address);
System.out.println("Mail ID : " + mailId);
System.out.println("Mobile No : " + mobileNo);
System.out.println("Designation : " + designation);
System.out.println("Basic Pay : " + basicPay);
System.out.println("DA : " + da);
System.out.println("HRA : " + hra);
System.out.println("PF : " + pf);
System.out.println("Staff Club : " + staffClub);
System.out.println("Gross Pay : " + grossSalary);
System.out.println("Net Pay : " + netSalary);
}
}

class Programmer extends Employee {
Programmer(String n, String id, String addr, String mail, String mob, double bp) {
super(n, id, addr, mail, mob, bp, "Programmer");
calculateSalary(97, 10, 12, 1);
}
}

class AssistantProfessor extends Employee {
AssistantProfessor(String n, String id, String addr, String mail, String mob, double bp) {
super(n, id, addr, mail, mob, bp, "Assistant Professor");
calculateSalary(110, 20, 12, 5);
}
}

class AssociateProfessor extends Employee {
AssociateProfessor(String n, String id, String addr, String mail, String mob, double bp) {
super(n, id, addr, mail, mob, bp, "Associate Professor");
calculateSalary(130, 30, 12, 10);
}
}

class Professor extends Employee {
Professor(String n, String id, String addr, String mail, String mob, double bp) {
super(n, id, addr, mail, mob, bp, "Professor");
calculateSalary(140, 40, 12, 15);
}
}

public class EmployeeSalary {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter Name:");
String name = sc.nextLine();
System.out.print("Enter ID:");
String id = sc.nextLine();
System.out.print("Enter Address:");
String address = sc.nextLine();
System.out.print("Enter Mail ID:");
String mail = sc.nextLine();
System.out.print("Enter Mobile No:");
String mobile = sc.nextLine();
System.out.print("Enter Basic Pay:");
double bp = sc.nextDouble();
if(bp >= 15000 && bp <= 20000) {
new Programmer(name, id, address, mail, mobile, bp).displayPaySlip();
} else if (bp >= 20001 && bp <= 30000) {
new AssistantProfessor(name, id, address, mail, mobile, bp).displayPaySlip();
} else if (bp >= 30001 && bp <= 40000) {
new AssociateProfessor(name, id, address, mail, mobile, bp).displayPaySlip();
}
else if(bp>40000){
new Professor(name, id, address, mail, mobile, bp).displayPaySlip();
} 
else {
System.out.println("Invalid Basic Pay range!");
}
sc.close();
}
}
