package ru.homework.helper.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static Path findFolderWithFiles() throws IOException {

        Resource resource = new ClassPathResource("files");

        InputStream input = resource.getInputStream();

        File file = resource.getFile();
        return Paths.get(file.getAbsolutePath());
    }

    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
}