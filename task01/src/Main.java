import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String csvFileName = args[0];
        String templateFileName = args[1];
        // System.out.println(csvFileName);
        // System.out.println(templateFileName);

        List<Map<String, String>> peopleInfoList = new ArrayList<>();

        // get List of Map
        ReadCSV csvReader = new ReadCSV(csvFileName);
        peopleInfoList = csvReader.read();

        // pass in List of Map into template reader
        ReadTemplate templateReader = new ReadTemplate();
        templateReader.read(templateFileName, peopleInfoList);

    } // main

} // class

/*
 * complier
 * javac -sourcepath task01 -d task01/classes task01/src/*.java
 * 
 * run
 * java -cp task01/classes Main thankyou.csv thankyou.txt
 */