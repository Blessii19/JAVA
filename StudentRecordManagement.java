import java.io.*;
import java.util.*;

class StudentRecordManagement {
    static Scanner sc = new Scanner(System.in);
    static File file = new File("students.txt");
    public static void createRecord() throws IOException {
        FileWriter fw = new FileWriter(file, false);
        BufferedWriter bw = new BufferedWriter(fw);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Student ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Student Dept: ");
            String dept = sc.nextLine();

            bw.write(id + "," + name + "," + dept);
            bw.newLine();
        }
        bw.close();
        System.out.println("Records created successfully!");
    }
    public static void readRecords() throws IOException {
        if (!file.exists()) {
            System.out.println("No records found!");
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        System.out.println("\n--- Student Records ---");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
    public static void appendRecord() throws IOException {
        FileWriter fw = new FileWriter(file, true); // append mode
        BufferedWriter bw = new BufferedWriter(fw);

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student Dept: ");
        String dept = sc.nextLine();

        bw.write(id + "," + name + "," + dept);
        bw.newLine();

        bw.close();
        System.out.println("Record appended successfully!");
    }
    public static void updateRecord() throws IOException {
        if (!file.exists()) {
            System.out.println("No records found!");
            return;
        }
        System.out.print("Enter Student ID to update: ");
        String targetId = sc.nextLine();

        File tempFile = new File("temp.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

        String line;
        boolean updated = false;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[0].equals(targetId)) {
                System.out.print("Enter new Name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new Dept: ");
                String newDept = sc.nextLine();
                bw.write(targetId + "," + newName + "," + newDept);
                updated = true;
            } else {
                bw.write(line);
            }
            bw.newLine();
        }
        br.close();
        bw.close();

        file.delete();
        tempFile.renameTo(file);

        if (updated)
            System.out.println("Record updated successfully!");
        else
            System.out.println("Student ID not found!");
    }
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Create Records");
            System.out.println("2. Read Records");
            System.out.println("3. Append Record");
            System.out.println("4. Update Record");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1: createRecord(); break;
                case 2: readRecords(); break;
                case 3: appendRecord(); break;
                case 4: updateRecord(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }
}

