package io.github.vertanzil;
import java.io.*;
public class Main {
    public static void Stats(enumTypes Type) throws IOException {
        Dashboard name1 = new Dashboard(Type);
        name1.runData();
        System.out.print(name1.getType() + " " + "total spent" + " " +  name1.getTotalValue() +  "" + " " + name1.getTotalEntries());
        System.out.print(System.lineSeparator());
    }
    public static void main(String[] args) {
        try {
            Stats(enumTypes.BILLS);
            Stats(enumTypes.CLOTHING);
            Stats(enumTypes.FAST_FOOD);
            Stats(enumTypes.GAMBLING);
            Stats(enumTypes.OTHER);
            Stats(enumTypes.PHONE_TOPUP);
            Stats(enumTypes.SHOPPING);
            Stats(enumTypes.TRAVEL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}