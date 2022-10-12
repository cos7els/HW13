package Documents;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Documents {
    private static final String VALID = "Valid";
    private static final String INVALID = "Invalid";
    private static final String INVALID_SYMBOLS = "number contains invalid characters";
    private static final String INVALID_LENGTH = "invalid number length";
    private static final String INVALID_START = "not starts with docnum or contract";


    public static void start() {
        readFilesList();
    }
    private static void readFilesList() {
        List<Path> paths = new ArrayList<>();
        try (Scanner in = new Scanner(System.in)) {
            String read;
            while (!(read = in.nextLine()).equals("0")) {
                paths.add(Paths.get(read));
            }
        }
        readFromFile(paths);
    }

    private static void readFromFile(List<Path> paths) {
        Set<String> data = new HashSet<>();
        try {
            for (Path p : paths) {
                data.addAll(Files.readAllLines(p));
            }
            analyzeNumbers(data);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static void analyzeNumbers(Set<String> data) {
        Map<String, String> result = new HashMap<>();
        for (String s : data) {
            String check = s.replaceAll("\\w|\\d", "");
            if ((check.length() > 0 || s.contains("_")) && (s.length() != 15) && !(s.startsWith("docnum") ||
                    s.startsWith("contract"))) {
                result.put(s, String.format("%s: %s, %s, %s", INVALID, INVALID_SYMBOLS, INVALID_LENGTH, INVALID_START));
            } else if ((check.length() > 0 || s.contains("_")) && (s.length() != 15)) {
                result.put(s, String.format("%s: %s, %s", INVALID, INVALID_SYMBOLS, INVALID_LENGTH));
            } else if ((check.length() > 0 || s.contains("_")) && !(s.startsWith("docnum") || s.startsWith("contract"))) {
                result.put(s, String.format("%s: %s, %s", INVALID, INVALID_SYMBOLS, INVALID_START));
            } else if ((s.length() != 15) && !(s.startsWith("docnum") || s.startsWith("contract"))) {
                result.put(s, String.format("%s: %s, %s", INVALID, INVALID_LENGTH, INVALID_START));
            } else if (check.length() > 0 || s.contains("_")) {
                result.put(s, String.format("%s: %s", INVALID, INVALID_SYMBOLS));
            } else if (s.length() != 15) {
                result.put(s, String.format("%s: %s", INVALID, INVALID_LENGTH));
            } else if (!(s.startsWith("docnum") || s.startsWith("contract"))) {
                result.put(s, String.format("%s: %s", INVALID, INVALID_START));
            } else {
                result.put(s, VALID);
            }

        }
        writeData(result);
    }

    private static void writeData(Map<String, String> data) {
        Path path = Paths.get("output.txt");
        for (Map.Entry<String, String> pair : data.entrySet()) {
            try {
                Files.write(path, String.format("%s - %s%n", pair.getKey(), pair.getValue()).getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
