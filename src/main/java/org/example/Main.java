package org.example;

//import org.json.JSONObject;

import com.google.gson.Gson;
import org.json.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        User user = new User(new File("C:\\Users\\user\\Desktop\\MiniBilling\\user.csv"));
        user.print();

        Readings readings = new Readings(new File("C:\\Users\\user\\Desktop\\MiniBilling\\readings.csv"));
        readings.printRead();

        Prices prices = new Prices(new File("C:\\Users\\user\\Desktop\\MiniBilling\\prices.csv"));
        prices.print();

        int countUsers = Math.min(user.getCount(), Math.min(readings.getCount(), prices.getCount()));
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < countUsers; i++) {

            jsonObject.put("totalAmount", user.getPriceList(i));
            jsonObject.put("documentDate", readings.getData(i));
            jsonObject.put("documentNumber", readings.getNumber(i));
            jsonObject.put("consumer", user.getConsumer(i));

            JSONArray courses = new JSONArray(
                    new String[]{"index: " + user.getReference(i), "quantity: " + readings.getPrice(i),
                            "lineStart: " + prices.getDataBegin(i), "lineEnd: " + prices.getDataEnd(i),
                            "product: " + readings.getProduct(i), "price: " + prices.getPrice(i),
                            "priceList: " + user.getPriceList(i), "amount: " + readings.getPrice(i)});

            jsonObject.put("lines", courses);
            System.out.println(jsonObject.toString(4));
        }
        File dir = new File("C:\\Users\\user\\Desktop\\tasks\\MiniBilling\\src\\test\\" + user.getConsumer(0)+ "-" + readings.getNumber(0));
        dir.mkdir();

        try
        {
                   //object of Scanner class

            String name="aaa";          //variable name to store the file name
            FileOutputStream fos=new FileOutputStream("C:\\Users\\user\\Desktop\\tasks\\MiniBilling\\src\\test\\");  // true for append mode
                //str stores the string which we have entered
            byte[] b= jsonObject.toString(4).getBytes();       //converts string into bytes
            fos.write(b);           //writes bytes into file
            fos.close();            //close the file
            //System.out.println("file saved.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
