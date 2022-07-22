package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prices {
    public File prices;

    public Prices(File prices) {
        this.prices = prices;
    }

    ArrayList<String> product = new ArrayList<>();
    ArrayList<String> dataBegin = new ArrayList<>();
    ArrayList<String> dataEnd = new ArrayList<>();
    ArrayList<Double> price = new ArrayList<>();
    int counterPrices = 0;

    public void print() throws FileNotFoundException {

        Scanner sc = new Scanner(this.prices);
        sc.useDelimiter(",|\\r\\n");
        int counter = 0;
        while (sc.hasNext()) {
            String i = sc.next();
            counter++;

            if (counter == 1) {
                product.add(i);
                //System.out.println("product" + "----" + i);
            }
            if (counter == 2) {
                dataBegin.add(i);
               //System.out.println("dataBegin" + "----" + i);
            }
            if (counter == 3) {
                dataEnd.add(i);
               //System.out.println("dateEnd" + "----" + i);
                //counter = 0;
            }
            if (counter == 4) {
                price.add(Double.parseDouble(i));
                //System.out.println("price" + "----" + i);
                counter = 0;
            }
            counterPrices++;
        }
    }
    public String getProduct(int i) {
        return this.product.get(i);
    }
    public String getDataBegin(int i) {
        return this.dataBegin.get(i);
    }
    public String getDataEnd(int i) {
        return this.dataEnd.get(i);
    }
    public Double getPrice(int i) {
        return this.price.get(i);
    }
    public Integer getCount(){
        return this.counterPrices / 4;
    }
}