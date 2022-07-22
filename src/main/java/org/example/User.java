package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    public File users;

    public User(File users) {
        this.users = users;
    }

    ArrayList<String> consumers = new ArrayList<>();
    ArrayList<String> reference = new ArrayList<>();
    ArrayList<Integer> priceList = new ArrayList<>();
    int counterUsers= 0;

    public void print() throws FileNotFoundException {

        Scanner sc = new Scanner(this.users);
        sc.useDelimiter(",|\\r\\n");
        int counter = 0;
        while (sc.hasNext()) {

            String i = sc.next();
            counter++;

            if (counter == 1) {
                consumers.add(i);
                //System.out.println("consumer" + "----" + i);

            }
            if (counter == 2) {
                reference.add(i);
                //System.out.println("reference" + "----" + i);
            }
            if (counter == 3) {
                priceList.add(Integer.parseInt(i));
                //System.out.println("priceList" + "----" + i);
                counter = 0;

            }
            counterUsers++;
        }
    }

    public String getConsumer(int i) {
       return this.consumers.get(i);
    }
    public String getReference(int i) {
        return this.reference.get(i);
    }
    public Integer getPriceList(int i) {
        return this.priceList.get(i);
    }

    public Integer getCount(){
        return this.counterUsers/3;
    }
}
