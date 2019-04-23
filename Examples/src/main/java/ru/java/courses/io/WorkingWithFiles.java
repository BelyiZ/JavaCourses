package ru.java.courses.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkingWithFiles {

    public static void main(String[] args) {
        copy();
    }

    private static final Logger LOG = LoggerFactory.getLogger(WorkingWithFiles.class);

    public static void copy() {
        File inputFile = new File("files/iwnput.txt");
        File outputFile = new File("files/output.txt");
        final int buffSize = 1024;

        LOG.info(
                "Trying copy file. Source: {} and destination: {}, buf {}",
                inputFile.getAbsolutePath(),
                outputFile.getAbsolutePath(),
                buffSize
        );

        if (inputFile.isDirectory() || !inputFile.exists()) {
            IllegalStateException e = new IllegalStateException("File not found");
            LOG.error("File not found", e);
            throw e;
        }

        if (outputFile.isDirectory()) {
            throw new IllegalStateException("Invalid path to file");
        }

        if (outputFile.exists()) {
            LOG.warn("Destination file exists");
            boolean deleted = outputFile.delete();
            if (!deleted) {
                throw new RuntimeException("Can't remove file " + outputFile.getAbsolutePath());
            }
        }

        try (
                FileInputStream fis = new FileInputStream(inputFile);
                BufferedInputStream bis = new BufferedInputStream(fis, buffSize);

                FileOutputStream fos = new FileOutputStream(outputFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos, buffSize);
        ) {

            byte[] buf = new byte[buffSize];
            int off = 0;

            while (bis.read(buf) != -1) {
                bos.write(buf, off, buf.length);
                off += buf.length;
            }

            bos.flush();

        } catch (IOException e) {
            LOG.error("Error while crate copy of file", e);
            // shit happens
        }
    }
}
