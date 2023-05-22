package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    /**
     *
     * @param str  Ä¿µÄÂ·¾¶
     */
    public static void writeFile(String str, String destination){
        File file = null;
        FileWriter fw = null;
        file = new File(destination);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file);
            fw.write(str);
            System.out.println("Ð´Êý¾Ý³É¹¦£¡");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        String str = "G:/test.txt";
        writeFile("hahaha", str);


    }
}