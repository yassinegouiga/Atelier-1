package probleme4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        char choice;

        do {
            System.out.print("Enter the name of the item: ");
            String itemName = scanner.nextLine();

            System.out.print("Enter the price of the item: ");
            double price = scanner.nextDouble();

            System.out.print("Enter the quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            cart.addToCart(itemName, price, quantity);

            System.out.println(cart.toString());

            System.out.print("Continue shopping (y/n)? ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');

        System.out.println("Please pay " + cart.getTotalPrice());

        scanner.close();
    }
}
