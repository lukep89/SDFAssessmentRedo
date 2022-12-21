import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadCSV {

    private String csvFileName;

    // constructor

    public ReadCSV(String csvFileName) {
        this.csvFileName = csvFileName;
    }

    public List<Map<String, String>> read() {

        // to return List of Map Strings
        List<Map<String, String>> peopleInfoList = new ArrayList<>();

        Map<String, String> personInfoMap = new HashMap<>();

        // bring in file and read file
        File f = Paths.get(csvFileName).toFile();

        try {
            BufferedReader br = new BufferedReader(new FileReader(f));

            // read 1st line to get header
            String[] headers = br.readLine().trim().split(",");

            String line = "";
            // read balance line to get data. then put header(key) and data(value) into Map.
            while ((line = br.readLine()) != null) {

                // for every person create new Map to store info
                personInfoMap = new HashMap<>();

                String[] data = line.trim().split(",");

                // loop header and data put into Map
                for (Integer i = 0; i < headers.length; i++) {
                    personInfoMap.put(headers[i], data[i]);
                }

                // add csvDataMap into a List
                peopleInfoList.add(personInfoMap);

            } // while
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("> error 1 on read csv = " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("> error 2 on read csv = " + e.getMessage());
            e.printStackTrace();
        } // try-catch

        // for (Map<String, String> personInfo : peopleInfoList) {
        // System.out.println(personInfo);
        // }

        return peopleInfoList;
    } // read method

}
