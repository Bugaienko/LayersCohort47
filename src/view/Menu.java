package view;
/*
@date 24.06.2024
@author Sergey Bugaienko
*/

import service.CarService;

import java.util.Scanner;

public class Menu {
    private final CarService service;
    private final Scanner scanner = new Scanner(System.in);

    private final static String RED_COLOR = "\u001B[31m";
    private final static String BLACK_COLOR = "\u001B[0m";

    public static final String RESET_COLOR = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";

    public static final String COLOR_WHITE = "\u001B[37m";

    public Menu(CarService service) {
        this.service = service;
    }

    public void run() {
        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println(RED_COLOR + "Добро пожаловать в меню" + RESET_COLOR);
            System.out.println(COLOR_GREEN + "1. Меню автомобилей");
            System.out.println("2. Меню пользователей");
            System.out.println("3. Меню администратора");
            System.out.println("0. Выход" + RESET_COLOR);
            System.out.println("\nСделайте выбор:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("До свидания!");
                //Завершить работу приложения
                System.exit(0);
                break;
            }
            showSubMenu(choice);
        }
    }

    private void showSubMenu(int choice) {
        switch (choice) {
            case 1:
                //showCarMenu();
                break;
            case 2:
                showUserMenu();
                break;
            case 3:
                //showAdminMenu();
                break;
            default:
                System.out.println("Сделайте корректный выбор\n");
        }
    }

    private void showUserMenu() {
        while (true) {
            System.out.println("Меню пользователя");
            System.out.println("1 -> Авторизация");
            System.out.println("2 -> Регистрация нового пользователя");
            System.out.println("3 -> Logout");
            System.out.println("0 -> Возврат в предыдущее меню");

            System.out.println("\nСделайте выбор пункта:");

            int input = scanner.nextInt();
            scanner.nextLine();
            if (input == 0) break;

            handleUserMenuChoice(input);

        }
    }

    private void handleUserMenuChoice(int input) {
        switch (input) {
            case 1:
                //Авторизация
                System.out.println("Авторизация нового пользователя");
                System.out.println("Введите email:");
                String email = scanner.nextLine();
                System.out.println("Введите пароль:");
                String password = scanner.nextLine();

                boolean isLogged = service.login(email, password);

                if (isLogged) {
                    System.out.println("Вы успешно авторизовались в системе");
                } else {
                    System.out.println("Не верный email или password");
                }
                waitRead();
                break;

            case 2:
                //Регистрация
                //TODO
                break;
            case 3:
                service.logout();
                break;
            default:
                System.out.println("\nНе верный ввод");
        }
    }

    private void waitRead() {
        System.out.println("\nДля продолжения нажмите Enter ...");
        scanner.nextLine();
    }
}
