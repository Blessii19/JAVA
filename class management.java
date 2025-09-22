import java.util.*;

public class management {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> phones = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter phone: ");
                String phone = sc.nextLine();
                names.add(name);
                phones.add(phone);
                System.out.println("Contact added!");

            } else if (choice == 2) {
                for (int i = 0; i < names.size(); i++) {
                    System.out.println((i + 1) + ". " + names.get(i) + " - " + phones.get(i));
                }

            } else if (choice == 3) {
                System.out.print("Enter name to search: ");
                String search = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).equalsIgnoreCase(search)) {
                        System.out.println("Found: " + names.get(i) + " - " + phones.get(i));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Contact not found.");
                }

            } else if (choice == 4) {
                System.out.print("Enter name to update: ");
                String update = sc.nextLine();
                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).equalsIgnoreCase(update)) {
                        System.out.print("Enter new phone: ");
                        phones.set(i, sc.nextLine());
                        System.out.println("Updated successfully.");
                    }
                }

            } else if (choice == 5) {
                System.out.print("Enter name to delete: ");
                String delete = sc.nextLine();
                for (int i = 0; i < names.size(); i++) {
                    if (names.get(i).equalsIgnoreCase(delete)) {
                        names.remove(i);
                        phones.remove(i);
                        System.out.println("Deleted successfully.");
                        break;
                    }
                }

            } else if (choice == 6) {
                System.out.println("Exiting...");

            } else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 6);
        }
}

    }
}

