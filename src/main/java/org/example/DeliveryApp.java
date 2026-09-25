package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackableParcels = new ArrayList<>();
    private static final ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(5000);
    private static final ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(500);
    private static final ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(2000);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportTrackableDelivery();
                    break;
                case 5:
                    printAllParcelsInBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отследить посылку");
        System.out.println("5 — Показать отправления в коробке");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        String type = "";
        System.out.println("Выберите тип посылки: 1 - обычная, 2 - скоропортящаяся, 3 - хрупкая");
        while (!type.equals("1") && !type.equals("2") && !type.equals("3")) {
            type = scanner.nextLine();
            if (!type.equals("1") && !type.equals("2") && !type.equals("3"))
                System.out.println("Введено некорректное значение, повторите ввод.");
        }
        System.out.println("Введите описание посылки");
        String description = "";
        while (description.equals("")) {
            description = scanner.nextLine();
            if (description.equals("")) {
                System.out.println("Ошибка, введена пустая строка. Введите описание.");
            }
        }
        System.out.println("Введите вес посылки (в граммах).");
        int weight = 0;
        while (weight <= 0) {
            weight = scanner.nextInt();
            scanner.nextLine();
            if (weight <= 0) {
                System.out.println("Вес должен быть выше 0, повторите ввод.");
            }
        }
        System.out.println("Введите адрес доставки посылки.");
        String deliveryAddress = "";
        while (deliveryAddress.equals("")) {
            deliveryAddress = scanner.nextLine();
            if (deliveryAddress.equals("")) {
                System.out.println("Ошибка, введена пустая строка. Введите точный адрес.");
            }
        }

        System.out.println("Введите дату отправки");
        int sendDay = 0;
        while (sendDay <= 0 || sendDay > 31) {
            sendDay = scanner.nextInt();
            scanner.nextLine();
            if (sendDay <= 0 || sendDay > 31) {
                System.out.println("Дата должна быть от 1 до 31");
            }
        }
        switch (type) {
            case "1":
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                System.out.println("Ваша стандартная посылка добавлена в список");
                standardParcelBox.addParcel(standardParcel);
                break;
            case "2":
                System.out.println("Введите срок годности посылки");
                int timeToLive = 0;
                while (timeToLive <= 0) {
                    timeToLive = scanner.nextInt();
                    scanner.nextLine();
                    if (timeToLive <= 0) {
                        System.out.println("срок годности должен быть выше 0, повторите ввод.");
                    }
                }
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                System.out.println("Ваша скоропортящаяся посылка добавлена в список");
                perishableParcelBox.addParcel(perishableParcel);
                break;
            case "3":
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                System.out.println("Ваша хрупкая посылка добавлена в список");
                trackableParcels.add(fragileParcel);
                fragileParcelBox.addParcel(fragileParcel);
                break;
        }
    }

    private static void sendParcels() {
        System.out.println("Введите текущую дату");
        int currentDate = scanner.nextInt();
        scanner.nextLine();
        for (Parcel parcel : allParcels) {
            if (parcel instanceof PerishableParcel && ((PerishableParcel) parcel).isExpired(currentDate)) {
                System.out.println("Извините, срок годности посылки истек, отправка невозможна");
            } else {
                parcel.packageItem();
                parcel.deliver();
            }
        }
    }

    private static void calculateCosts() {
        double sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость посылок: " + sum);
    }

    private static void reportTrackableDelivery() {
        for (Trackable trackableDelivery : trackableParcels) {
            System.out.println("Введите промежуточный пункт отправления");
            String newLocation = scanner.nextLine();
            trackableDelivery.reportStatus(newLocation);
        }
    }

    private static void printAllParcelsInBox() {
        String boxType = "";
        System.out.println("Выберите коробку с посылками: 1 - обычная, 2 - скоропортящаяся, 3 - хрупкая");
        while (!boxType.equals("1") && !boxType.equals("2") && !boxType.equals("3")) {
            boxType = scanner.nextLine();
            if (!boxType.equals("1") && !boxType.equals("2") && !boxType.equals("3"))
                System.out.println("Введено некорректное значение, повторите ввод.");
        }
        switch (boxType) {
            case "1":
                for (StandardParcel standardParcel : standardParcelBox.getAllParcels()) {
                    System.out.println(standardParcel.getDescription());
                }
                break;
            case "2":
                for (PerishableParcel perishableParcel : perishableParcelBox.getAllParcels()) {
                    System.out.println(perishableParcel.getDescription());
                }
                break;
            case "3":
                for (FragileParcel fragileParcel : fragileParcelBox.getAllParcels()) {
                    System.out.println(fragileParcel.getDescription());
                }
                break;
        }
    }
}
