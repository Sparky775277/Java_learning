package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            int size, HamCodeSize, errorPlace;
            int array[];
            int HamCode[];
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите размер данных в битах:");
            size = sc.nextInt();
            array = new int[size];
            for(int j = 0 ; j < size ; j++) {
                System.out.println("Введите " + (size - j) + "-бит сообщения/данных:");
                array[size - j - 1] = sc.nextInt();
            }


            System.out.println("Введенная последовательность:");
            for(int k = 0 ; k < size ; k++) {
                System.out.print(array[size - k - 1]);
            }
            System.out.println();


            HamCode = HammingCode.getHamCode(array);
            HamCodeSize = HamCode.length;

            System.out.println("Код Хэмминга сгенерированный по полученному сообщению:");
            for(int i = 0 ; i < HamCodeSize; i++) {
                System.out.print(HamCode[HamCodeSize - (i) - 1]);
            }
            System.out.println();

            System.out.println("Для создания помех (ошибки), которые повлияли на передачу сообщения,"
                    + " вам неоходимо указать позицию бита, который должен будет отличаться от исходного сообщения "
                    + " (Выберите '0' в ином случае):");
            errorPlace = sc.nextInt();

            sc.close();

            if(errorPlace != 0) {
                HamCode[errorPlace - 1] = (HamCode[errorPlace - 1] + 1) % 2;
            }


            System.out.println("Отправленное сообщение:");
            for(int k = 0; k < HamCodeSize; k++) {
                System.out.print(HamCode[HamCodeSize - k - 1]);
            }
            System.out.println();
            HammingCode.checkData(HamCode, HamCodeSize - array.length);
        }
    }

