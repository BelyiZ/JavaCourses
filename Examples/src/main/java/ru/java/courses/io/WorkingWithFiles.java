package ru.java.courses.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WorkingWithFiles {

    public static void main(String[] args) {
        copy();
    }


    public static void copy() {
        File inputFile = new File("files/input.txt");
        File outputFile = new File("files/output.txt");

        if (inputFile.isDirectory() || !inputFile.exists()) {
            throw new RuntimeException("File not found");
        }

        if (outputFile.isDirectory()) {
            throw new RuntimeException("Invalid path to file");
        }

        if (outputFile.exists()) {
            outputFile.delete();
        }

        try (
                FileInputStream fis = new FileInputStream(inputFile);
                BufferedInputStream bis = new BufferedInputStream(fis, 1024);

                FileOutputStream fos = new FileOutputStream(outputFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
        ) {

            byte[] buf = new byte[1024];
            int off = 0;

            while (bis.read(buf) != -1) {
                bos.write(buf, off, buf.length);
                off += buf.length;
            }

            bos.flush();

        } catch (IOException e) {
            // shit happens
        }


    }


}
