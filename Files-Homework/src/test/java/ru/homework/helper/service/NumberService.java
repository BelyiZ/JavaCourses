package ru.homework.helper.service;

import ru.homework.helper.util.ContactUtils;
import ru.homework.helper.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberService {

    public static List<String> findAllActualPhoneNumbers() throws IOException {
        Path path = FileUtils.findFolderWithFiles();

        FileService fileService = new FileService();
        List<File> fileList = fileService.findAllCorrectFilesInFolder(path.toString());

        getAllActualPhoneNumbers(fileList);
        List<String> actualPhoneNumbersList = getAllActualPhoneNumbers(fileList);
        Collections.sort(actualPhoneNumbersList);
        return actualPhoneNumbersList;
    }

    /**
     * The method reads all phone numbers from the file list.
     * If, while reading, there are letters or other characters, it deletes them and checks the number for correctness.
     *
     * @param fileList - list of files where numbers are stored.
     * @return - phone numbers from files in "dirty" form.
     */
    private static List<String> getAllNumbersFromFileList(List<File> fileList) {
        List<String> actualPhoneNumbers = new ArrayList<>();
        fileList.forEach(x -> {
            List<String> line = null;
            try {
                line = Files.lines(x.toPath()).collect(Collectors.toList()).stream()
                        .filter(s -> s.replaceAll("[^0-9]", "").length() >= 7)
                        .collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (line != null) {
                actualPhoneNumbers.addAll(line);
            }
        });
        return actualPhoneNumbers;
    }

    /**
     * The method, getting a list of files with numbers, finds the numbers and returns them in formatted form.
     *
     * @param fileList - list of files where numbers are stored.
     * @return - formatted phone numbers from files.
     */
    public static List<String> getAllActualPhoneNumbers(List<File> fileList) {
        List<String> dirtyPhoneNumbers = getAllNumbersFromFileList(fileList);
        return new ArrayList<>(ContactUtils.getCorrectPhoneNumber(dirtyPhoneNumbers));
    }
}