package ru.homework.helper.service;

import ru.homework.helper.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileService {

    private final List<File> files = new ArrayList<>();

    private final static String CORRECT_FILE_EXTENSION = "txt";


    /**
     * The method finds all files in a folder, including files in nested folders, by moving along the folder tree.
     *
     * @param dir - the root directory against which all files are searched.
     * @return - all found files are in ".txt" format only(ignore other types).
     * @throws IOException - error when working with files in the Files.lines() method(the error is not handled anywhere).
     */
    public List<File> findAllCorrectFilesInFolder(String dir) throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            stream.forEach(x -> {
                if (!Files.isDirectory(x)) {
                    if (FileUtils.getFileExtension(x.toFile()).equals(CORRECT_FILE_EXTENSION)) {
                        files.add(x.toFile());
                    }
                } else {
                    try {
                        findAllCorrectFilesInFolder(x.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return files;
    }
}