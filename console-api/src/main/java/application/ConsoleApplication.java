package application;

import user.User;
import user.UserService;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleApplication {

    public static void main(String[] args) {

        UserService userService = new UserService();

        int option;
        do {
            mainMenu();
            option = getMenuOption();
            switch (option) {
                case 1 -> showAllUsers(userService);
                case 2 -> createNewUser(userService);
                case 3 -> updateUserId(userService);
                case 4 -> getUserById(userService);
                case 5 -> deleteUserById(userService);
                case 6 -> exit();
            }
        } while (option != 6);

    }


    public static void mainMenu() {
        System.out.println("Choose your option:" + "\n" + "1. Get all users");
        System.out.println("2. Add new user");
        System.out.println("3. Update existing user");
        System.out.println("4. Get specific user");
        System.out.println("5. Remove specific user");
        System.out.println("6. Exit the program");
    }

    public static int getMenuOption() {
        int option;
        System.out.println("Enter your option:");
        option = scanner.nextInt();
        return option;
    }

    public static final Scanner scanner = new Scanner(System.in);


    private static void exit() {
        System.out.println("You've exited the program");
    }

    private static void showAllUsers(UserService userService) {
        System.out.println("Show all users: ");
        Map<Integer, User> users = userService.getUsers();
        System.out.println(users);
    }

    private static void createNewUser(UserService userService) {
        System.out.println("Enter your user id: ");
        int userId = scanner.nextInt();
        System.out.println("Enter your user name: ");
        scanner.nextLine();
        String userName = scanner.nextLine();
        System.out.println("Enter your user email: ");
        String userEmail = scanner.nextLine();
        System.out.println("Enter your user age: ");
        int userAge = scanner.nextInt();
        userService.createNewUser(userId, userName, userEmail, userAge);
        System.out.println("Operation is finished");
    }

    private static void deleteUserById(UserService userService) {
        System.out.println("Set the userId for specific user removal: ");
        int userId = scanner.nextInt();
        userService.deleteUser(userId);
    }

    private static void getUserById(UserService userService) {
        System.out.println("Set the userId for specific user retrieval: ");
        int userId = scanner.nextInt();
        Optional<User> targetedUser = userService.retrieveUser(userId);
        System.out.println(targetedUser);
    }

    private static void updateUserId(UserService userService) {
        System.out.println("Set the userId for update: ");
        int userId = scanner.nextInt();
        System.out.println("Enter your new user id: ");
        int newUserId = scanner.nextInt();
        System.out.println("Enter your user name: ");
        scanner.nextLine();
        String userName = scanner.nextLine();
        System.out.println("Enter your user email: ");
        String userEmail = scanner.nextLine();
        System.out.println("Enter your user age: ");
        int userAge = scanner.nextInt();
        userService.updateUserId(userId, new User(newUserId, userName, userEmail, userAge));
        System.out.println();
    }
}
