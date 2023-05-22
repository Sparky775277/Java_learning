package com.company;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class Main {

    private static final BigInteger ONE = BigInteger.ONE;

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        // Прочитать сообщение m из файла
        File file = new File("G:\\java projects\\ELGML\\src\\com\\company\\2.txt");

        String m = ReadFile.txt2String(file);
        System.out.println("сообщение m = " + m);

        int length = m.length();

        // Случайное большое простое число p
        BigInteger p = ElGamal.getPrime(60);
        System.out.println("p = " + p.toString());

        // Используется в приведенном ниже расчете p-1
        BigInteger p_MinusOne = p.subtract(ONE);
        System.out.println("p-1 = " + p_MinusOne.toString());

        // Обходы перечисления для создания элементов g
        BigInteger g = null;
        while(g == null) {
            g = ElGamal.getG(p, p_MinusOne);
        }
        System.out.println("g = " + g.toString());

        // Случайное число x, удовлетворяющее интервалу [2,p-1]
        BigInteger x = new BigInteger(length,new Random());
        System.out.println("x = " + x.toString());

        // y ≡ g^x（ mod p ）
        BigInteger y = g.modPow(x,p);
        System.out.println("y = " + y.toString());

        // Случайное большое простое число k, удовлетворяющее интервалу [2,p-1)
        BigInteger k = ElGamal.getPrime(length);
        System.out.println("k = " + k.toString());

        // Обратная величина k
        BigInteger k_Reverse = k.modInverse(p_MinusOne);
        System.out.println("k для p-1 Обратный элемент = " + k_Reverse.toString());

        // a ≡ g^k ( mod p )
        BigInteger a = g.modPow(k,p);
        System.out.println("a = " + a.toString());

        //  Подсчет хэша h(m)
        int hm = Math.abs(m.hashCode());
        String temp = String.valueOf(hm);
        BigInteger h_m = new BigInteger(temp);
        System.out.println("h(m) = " + h_m.toString());

        //ТУт ХЕРНЯ//Проверка подлинности y который a Мощность b * a равна мощности h(m) по модулю p g(m) по модулю p g(m) по модулю p g(m) по модулю p g(m) по модулю p g
        BigInteger tmp1 = h_m.subtract(x.multiply(a));
        System.out.println("tmp1 = " + tmp1.toString());

        BigInteger tmp2 = tmp1.multiply(k_Reverse);
        System.out.println("tmp2 = " + tmp2.toString());

        BigInteger b = tmp2.mod(p_MinusOne);
        System.out.println("b = " + b.toString());

        System.out.println("Цифровая подпись сообщения m - это : " + a.toString() + "," + b.toString());// это подпись, два числа, они являются подписью
        //
        BigInteger left = y.modPow(a, p).multiply(a.modPow(b, p)).mod(p);//Это число А которое высчитывает уже получатель
        System.out.println("left = " + left.toString());

        int unsignedH_m = h_m.intValue();
        if(unsignedH_m < 0) {
            unsignedH_m = -unsignedH_m;
        }
        BigInteger right = g.modPow(h_m, p);// Это то же число А, но по другой формуле, ибо мы должны получить две части равные друг другу но по разным формулам.
        //https://studopedia.su/19_47275_algoritm-tsifrovoy-podpisi-el-gamalya-EGSA.html

        System.out.println("right = " + right.toString());

        if(left.toString().equals(right.toString())) {
            System.out.println("Действительная подпись！");
        } else {
            System.out.println("Неверная подпись！");
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Время выполнения программы：" + (endTime - startTime) + "ms");    //输出程序运行时间
    }

}