package probleme2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many questions are in the quiz? ");
        int n = scanner.nextInt();

        int[] key = new int[n];
        System.out.println("Enter the key for the quiz:");
        for (int i = 0; i < n; i++) {
            key[i] = scanner.nextInt();
        }

        char choice;
        do {
            System.out.println("Enter the answers for the quiz to be graded:");
            int correct = 0;

            for (int i = 0; i < n; i++) {
                int answer = scanner.nextInt();
                if (answer == key[i]) {
                    correct++;
                }
            }

            double percent = (double) correct / n * 100;
            System.out.println("Number correct: " + correct);
            System.out.println("Percent correct: " + percent + "%");

            System.out.print("Grade another quiz? (y/n) ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        scanner.close();
    }
}
