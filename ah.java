// This is to search inside the txt file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordSearchInFile {

    public static void main(String[] args) {
        // TODO: Change this to your file path
        String filePath = "input.txt";

        // Array of words you want to search for
        String[] wordsToSearch = {"error", "exception", "failed"};

        try {
            searchWordsInFile(filePath, wordsToSearch);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Reads the file line by line and searches for the given words.
     * Prints the line numbers where the words are found and a summary count.
     */
    public static void searchWordsInFile(String filePath, String[] wordsToSearch) throws IOException {
        // Map to store how many lines each word appeared in
        Map<String, Integer> wordCountMap = new HashMap<>();
        Arrays.stream(wordsToSearch).forEach(word -> wordCountMap.put(word, 0));

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                // Convert line to lowercase once for case-insensitive search
                String lowerCaseLine = line.toLowerCase();

                for (String word : wordsToSearch) {
                    String lowerCaseWord = word.toLowerCase();

                    // --- OPTION 1: substring match (simple) ---
                    if (lowerCaseLine.contains(lowerCaseWord)) {
                        System.out.println("Found \"" + word + "\" at line " + lineNumber + ": " + line);
                        wordCountMap.put(word, wordCountMap.get(word) + 1);
                    }

                    // --- OPTION 2: exact word match (uncomment if you want exact words only) ---
                    /*
                    String[] tokens = lowerCaseLine.split("\\W+");
                    for (String token : tokens) {
                        if (token.equals(lowerCaseWord)) {
                            System.out.println("Found \"" + word + "\" at line " + lineNumber + ": " + line);
                            wordCountMap.put(word, wordCountMap.get(word) + 1);
                            break; // already counted this word for this line
                        }
                    }
                    */
                }
            }
        }

        // Print summary
        System.out.println("\nSummary:");
        for (String word : wordsToSearch) {
            System.out.println("Word \"" + word + "\" occurred in " + wordCountMap.get(word) + " line(s).");
        }
    }
}
// This is inside csv file 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CsvWordSearchByColumns {

    public static void main(String[] args) {
        // Path to your CSV file
        String csvFilePath = "data.csv";

        // Array of words you want to search for
        String[] wordsToSearch = {"error", "exception", "failed"};

        // Column names you want to search in (must exist in header row)
        String[] columnsToSearch = {"status", "message"};

        try {
            searchWordsInCsv(csvFilePath, wordsToSearch, columnsToSearch);
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Reads a CSV file and searches for the given words in the specified columns.
     * Assumes the first row is a header with column names.
     */
    public static void searchWordsInCsv(String csvFilePath,
                                        String[] wordsToSearch,
                                        String[] columnsToSearch) throws IOException {

        // Map to store how many rows each word appeared in
        Map<String, Integer> wordCountMap = new HashMap<>();
        Arrays.stream(wordsToSearch).forEach(word -> wordCountMap.put(word, 0));

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String row;
            int rowNumber = 0;

            // ---- Read header row to determine column indices ----
            row = br.readLine();
            if (row == null) {
                System.out.println("CSV file is empty.");
                return;
            }

            rowNumber++;
            String[] headerCells = row.split(",", -1); // keep empty cells
            Map<String, Integer> columnIndexMap = new HashMap<>();

            for (int i = 0; i < headerCells.length; i++) {
                String colName = headerCells[i].trim().toLowerCase();
                columnIndexMap.put(colName, i);
            }

            // Resolve column indices to search
            int[] columnIndicesToSearch = new int[columnsToSearch.length];
            for (int i = 0; i < columnsToSearch.length; i++) {
                String colName = columnsToSearch[i].trim().toLowerCase();
                Integer idx = columnIndexMap.get(colName);
                if (idx == null) {
                    throw new IllegalArgumentException(
                            "Column \"" + columnsToSearch[i] + "\" not found in CSV header.");
                }
                columnIndicesToSearch[i] = idx;
            }

            System.out.println("Searching in columns: " + String.join(", ", columnsToSearch));
            System.out.println("----------------------------------------------------------");

            // ---- Process data rows ----
            while ((row = br.readLine()) != null) {
                rowNumber++;
                String[] cells = row.split(",", -1); // keep empty cells

                for (String word : wordsToSearch) {
                    String lowerCaseWord = word.toLowerCase();
                    boolean foundInThisRowForThisWord = false;

                    for (int colIndex : columnIndicesToSearch) {
                        if (colIndex >= cells.length) {
                            continue; // column not present in this row
                        }

                        String cellValue = cells[colIndex];
                        String lowerCaseCell = cellValue.toLowerCase();

                        // Simple substring match in the cell
                        if (lowerCaseCell.contains(lowerCaseWord)) {
                            String columnName = headerCells[colIndex].trim();
                            System.out.println(
                                    "Found \"" + word + "\" in row " + rowNumber +
                                            ", column \"" + columnName + "\": " + cellValue
                            );

                            // Count each row only once per word
                            if (!foundInThisRowForThisWord) {
                                wordCountMap.put(word, wordCountMap.get(word) + 1);
                                foundInThisRowForThisWord = true;
                            }
                        }
                    }
                }
            }
        }

        // ---- Print summary ----
        System.out.println("\nSummary:");
        for (String word : wordsToSearch) {
            System.out.println("Word \"" + word + "\" occurred in " + wordCountMap.get(word) + " row(s).");
        }
    }
}
