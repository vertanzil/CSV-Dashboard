package io.github.vertanzil;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
public class Dashboard {
    private final String enumType;
    private Double totalValue;
    private Double Daverage;
    private double totalEntries;
    public Dashboard(enumTypes enumtype) {
        enumType = String.valueOf(enumtype).toLowerCase();
    }
    public String getType() {
        return enumType;
    }

    public Double getTotalEntries() {
        return round(totalEntries,2);
    }
    public Double getTotalValue() {
        return round(totalValue,2);
    }
    public Double getAverage() {
        return round(Daverage,2);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void runData() throws IOException {
        String line;
        String splitBy = ",";
        double total = 0.0;
        int count = 0;
        double caverage = 0;
        BufferedReader br = new BufferedReader(new FileReader("src/main/History.csv"));
            while ((line = br.readLine()) != null) {
                String[] csvdata = line.split(splitBy);
                //String date = csvdata[0];
                String location = csvdata[1].replace(" )))", "");
                double value = Double.parseDouble(csvdata[2].replace("-", ""));
                File fileReader = new File("src/main/categories/" + enumType + ".txt");

                Scanner myReader = new Scanner(fileReader);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if (location.contains(data)) {
                        count++;
                        total += value;
                        value++;
                        caverage = total / count;
                    }
                }
                myReader.close();
            }
        totalEntries = count;
        totalValue = total;
        Daverage = caverage;
    }
}