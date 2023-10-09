package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = List.of(new Human("KENTA", "JAPAN", "MALE", 35), new Human("LILY", "ITALY", "FEMALE", 18),
                new Human("LIAM", "USA", "FEMALE", 31), new Human("EMMA", "GERMANY", "FEMALE", 25),
                new Human("MIGUEL", "SPAIN", "MALE", 21));
        Scanner scanner = new Scanner(System.in);
        humans.stream().map(Human::getName).filter(name -> name.contains("A")).forEach(System.out::println);
        humans.stream().map(Human::getSex).filter(sex -> sex.contains("F")).map(String::toLowerCase).forEach(System.out::println);
        humans.stream().map(Human::getCountry).map(String::toLowerCase).forEach(System.out::println);
        humans.stream().map(Human::getAge).forEach(System.out::println);

        while (true) {
            System.out.println("1. 名前を入力して検索");
            System.out.println("2. 国名を入力して検索");
            System.out.println("3. 年齢を入力して検索");
            System.out.println("4. 終了");
            System.out.print("選択肢を入力してください: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("名前を入力してください: ");
                    String nameInput = scanner.nextLine();
                    searchByName(humans, nameInput);
                    break;
                case 2:
                    System.out.print("国名を入力してください: ");
                    String countryInput = scanner.nextLine();
                    searchByCountry(humans, countryInput);
                    break;
                case 3:
                    System.out.print("年齢を入力してください: ");
                    int ageInput = scanner.nextInt();
                    scanner.nextLine();
                    searchByAge(humans, ageInput);
                    break;
                case 4:
                    System.out.println("プログラムを終了します。");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("無効な選択肢です。再試行してください。");
            }
        }
    }

    private static void searchByName(List<Human> humans, String name) {
        for (Human human : humans) {
            if (human.getName().equalsIgnoreCase(name)) {
                System.out.println("名前: " + human.getName() + ", 国名: " + human.getCountry() + ", 年齢: " + human.getAge() + "歳");
            } else {
                System.out.println("申し訳ありません。" + name + "さんの情報はありません。");
            }
            break;
        }
    }


    private static void searchByCountry(List<Human> humans, String country) {
        for (Human human : humans) {
            if (human.getCountry().equalsIgnoreCase(country)) {
                System.out.println("名前: " + human.getName() + ", 国名: " + human.getCountry() + ", 年齢: " + human.getAge() + "歳");
            } else {
                System.out.println("申し訳ありません。" + country + "歳の方の情報はありません。");
            }
            break;
        }
    }


    private static void searchByAge(List<Human> humans, int age) {
        for (Human human : humans) {
            if (human.getAge() == age) {
                System.out.println("名前: " + human.getName() + ", 国名: " + human.getCountry() + ", 年齢: " + human.getAge() + "歳");
            } else {
                System.out.println("申し訳ありません。" + age + "歳の方の情報はありません。");
            }
            break;
        }
    }
}

