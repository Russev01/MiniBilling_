package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Readings {
    public File readings;
    public Readings(File readings){
        this.readings = readings;
    }

    ArrayList<Integer> number = new ArrayList<>();
    ArrayList<String> product = new ArrayList<>();
    ArrayList<String> data = new ArrayList<>();
    ArrayList<Double> price = new ArrayList<>();
    int counterReadings = 0;

    public void printRead() throws FileNotFoundException {

        Scanner sc = new Scanner(this.readings);
        sc.useDelimiter(",|\\r\\n");
        int counter = 0;
        while (sc.hasNext()) {

            String i = sc.next();
            counter++;

            if (counter == 1) {
                number.add(Integer.parseInt(i));
                //System.out.println("number" + "----" + i);
            }
            if (counter == 2) {
                product.add(i);
                //System.out.println("product" + "----" + i);
            }
            if (counter == 3) {
                data.add(i);
                //System.out.println("data" + "----" + i);
            }
            if (counter == 4) {
                price.add(Double.parseDouble(i));
                //System.out.println("price" + "----" + i);
                counter = 0;
            }
            counterReadings++;
        }
    }
    public Integer getNumber(int i) {
        return this.number.get(i);
    }
    public String getProduct(int i) {
        return this.product.get(i);
    }
    public String getData(int i) {
        return this.data.get(i);
    }
    public Double getPrice(int i) {
        return this.price.get(i);
    }
    public Integer getCount(){
        return this.counterReadings/4;
    }
}


