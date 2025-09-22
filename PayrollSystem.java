import java.util.*;
class SalaryException extends Exception {
    public SalaryException(String message) {
        super(message);
    }
}
class Employee {
    String name;
    int id;
    double basic, allowance, deduction, netSalary;

    public Employee(String name, int id, double basic, double allowance, double deduction) throws SalaryException {
        if (basic < 0 || allowance < 0 || deduction < 0) {
            throw new SalaryException("Salary components must not be negative.");
        }
        this.name = name;
        this.id = id;
        this.basic = basic;
        this.allowance = allowance;
        this.deduction = deduction;
        this.netSalary = calculateNetSalary();
    }
    public double calculateNetSalary() throws SalaryException {
        double net = basic + allowance - deduction;
        if (net < 0) {
            throw new SalaryException("Net salary cannot be negative.");
        }
        return net;
    }
    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Net Salary: ₹" + netSalary;
    }
}
interface Stack<T> extends Iterable<T> {
    void push(T item);
    T pop();
    boolean isEmpty();
    int size();
}
class ArrayStack<T> implements Stack<T> {
    private T[] stack;
    private int top = -1;
    private int capacity;
    @SuppressWarnings("unchecked")
    public ArrayStack(int size) {
        capacity = size;
        stack = (T[]) new Object[size];
    }
    public void push(T item) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow! Cannot push item.");
            return;
        }
        stack[++top] = item;
    }
    public T pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! No item to pop.");
            return null;
        }
        return stack[top--];
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public int size() {
        return top + 1;
    }
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = top;

            public boolean hasNext() {
                return current >= 0;
            }

            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return stack[current--];
            }
        };
    }
}
public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Employee> payrollHistory = new ArrayStack<>(100);  // Initialize with size 100

        while (true) {
            System.out.println("\n1. Add Employee Payroll");
            System.out.println("2. Undo Last Entry");
            System.out.println("3. View Payroll History");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Employee ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Employee Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Basic Salary: ");
                        double basic = Double.parseDouble(sc.nextLine());

                        System.out.print("Enter Allowance: ");
                        double allowance = Double.parseDouble(sc.nextLine());

                        System.out.print("Enter Deduction: ");
                        double deduction = Double.parseDouble(sc.nextLine());

                        Employee emp = new Employee(name, id, basic, allowance, deduction);
                        payrollHistory.push(emp);
                        System.out.println("Payroll added successfully: " + emp);

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format. Please enter numeric values for salary.");
                    } catch (SalaryException e) {
                        System.out.println("Error in salary calculation: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Unexpected error: " + e.getMessage());
                    }
                    break;

                case 2:
                    if (!payrollHistory.isEmpty()) {
                        Employee removed = payrollHistory.pop();
                        System.out.println("Last payroll entry removed: " + removed);
                    } else {
                        System.out.println("No payroll entries to undo.");
                    }
                    break;

                case 3:
                    if (payrollHistory.isEmpty()) {
                        System.out.println("No payroll entries found.");
                    } else {
                        System.out.println("Payroll History:");
                        for (Employee e : payrollHistory) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting Payroll System.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose from 1-4.");
            }
        }
    }
}

