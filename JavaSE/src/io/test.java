package io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        File file = null;
        FileReader fileReader = null;
        try{
            file = new File("D:\\desktop\\1.docx");
            fileReader = new FileReader(file);
            int len;
            char[] cbuf = new char[3];
            while ((len = fileReader.read(cbuf)) != -1){
                System.out.println(len);
            }
            System.out.println(len);
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
