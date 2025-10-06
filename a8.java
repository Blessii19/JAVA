import java.util.Scanner;

class a8 {
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];
        for (T element : arr) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter number of totals: ");
        int nTotals = scanner.nextInt();
        Integer[] totals = new Integer[nTotals];
        System.out.println("Enter totals:");
        for (int i = 0; i < nTotals; i++) {
            totals[i] = scanner.nextInt();
        }

        System.out.print("Enter number of CGPAs: ");
        int nCgpas = scanner.nextInt();
        Float[] cgpas = new Float[nCgpas];
        System.out.println("Enter CGPAs:");
        for (int i = 0; i < nCgpas; i++) {
            cgpas[i] = scanner.nextFloat();
        }

        scanner.nextLine();  

     
        System.out.print("Enter number of names: ");
        int nNames = scanner.nextInt();
        scanner.nextLine(); 
        String[] names = new String[nNames];
        System.out.println("Enter names:");
        for (int i = 0; i < nNames; i++) {
            names[i] = scanner.nextLine();
        }

        System.out.println("Highest Total: " + findMax(totals));
        System.out.println("Highest CGPA: " + findMax(cgpas));
        System.out.println("Name comes last alphabetically: " + findMax(names));

        scanner.close();
    }
}

