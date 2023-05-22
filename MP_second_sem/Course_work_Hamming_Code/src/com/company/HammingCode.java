package com.company;

public class HammingCode {

    static int[] getHamCode(int data[]) {
        int returnData[];
        int size;
        int i = 0, parityBits = 0, j = 0, k = 0;
        size = data.length;
        while (i < size) {
            if (Math.pow(2, parityBits) == (i + parityBits + 1)) {
                parityBits++;
            } else {
                i++;
            }
        }
        returnData = new int[size + parityBits];
        for (i = 1; i <= returnData.length; i++) {
            if (Math.pow(2, j) == i) {
                returnData[(i - 1)] = 2;
                j++;
            } else {
                returnData[(k + j)] = data[k++];
            }
        }
        for (i = 0; i < parityBits; i++) {

            returnData[((int) Math.pow(2, i)) - 1] = getParity(returnData, i);
        }

        return returnData;
    }


    static int getParity(int returnData[], int pow) {
        int parityBit = 0;
        int size = returnData.length;

        for (int i = 0; i < size; i++) {
            if (returnData[i] != 2) {
                int k = (i + 1);
                String str = Integer.toBinaryString(k);
                int temp = ((Integer.parseInt(str)) / ((int) Math.pow(10, pow))) % 10;
                if (temp == 1) {
                    if (returnData[i] == 1) {
                        parityBit = (parityBit + 1) % 2;
                    }
                }
            }
        }
        return parityBit;
    }


    static void checkData(int data[], int parityBits) {
        int pow;
        int size = data.length;
        int parityArray[] = new int[parityBits];
        String errorLoc = new String();
        for (pow = 0; pow < parityBits; pow++) {
            for (int i = 0; i < size; i++) {
                int j = i + 1;
                String str = Integer.toBinaryString(j);
                int bit = ((Integer.parseInt(str)) / ((int) Math.pow(10, pow))) % 10;
                if (bit == 1) {
                    if (data[i] == 1) {
                        parityArray[pow] = (parityArray[pow] + 1) % 2;
                    }
                }
            }
            errorLoc = parityArray[pow] + errorLoc;
        }
        int finalLoc = Integer.parseInt(errorLoc, 2);
        if (finalLoc != 0) {
            System.out.println("Позиция найденной ошибки " + finalLoc + ".");
            data[finalLoc - 1] = (data[finalLoc - 1] + 1) % 2;
            System.out.println("Исправленный код:");
            for (int i = 0; i < size; i++) {
                System.out.print(data[size - i - 1]);
            }
            System.out.println();
        } else {
            System.out.println("Нет ошибок в полученном сообщении.");
        }
        System.out.println("Сообщение высланное отправителем:");
        pow = parityBits - 1;
        for (int k = size; k > 0; k--) {
            if (Math.pow(2, pow) != k) {
                System.out.print(data[k - 1]);
            } else {
                pow--;
            }
        }
        System.out.println();
    }
}
