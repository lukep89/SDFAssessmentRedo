import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class ReadTemplate {

    // pass the txt filename and List of Map (peopleInfoList) into read method
    public void read(String templateFileName, List<Map<String, String>> peopleInfoList) {

        // for each person, read template
        for (Map<String, String> personInfo : peopleInfoList) {

            File f = Paths.get(templateFileName).toFile();

            try {
                BufferedReader br = new BufferedReader(new FileReader(f));

                String line = "";

                // read line by line. replace word if header word is found.
                while ((line = br.readLine()) != null) {

                    // loop the Map to get Key (header). then compare Key with each word
                    for (String header : personInfo.keySet()) {
                        line = line.replaceAll("<<" + header + ">>", personInfo.get(header));
                    }

                    // after replace print each line
                    System.out.println(line);

                } // while

                br.close();

            } catch (FileNotFoundException e) {
                System.out.println("> error 1 on read template = " + e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("> error 2 on read template = " + e.getMessage());
                e.printStackTrace();
            } // try catch

            System.out.println("\n==============================\n");

        } // for each loop

    } // read method

}
