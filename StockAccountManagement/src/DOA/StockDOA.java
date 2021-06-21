package DOA;

import StockModel.StockAccount;
import StockService.StockServiceInterface;
import Util.UserInputOutput;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StockDOA implements StockServiceInterface {
    static StockAccount stockAccount = new StockAccount();

    // adding data to the json file
    @Override
    public void writeToFile(String filePath) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        // it can add upto 6 stock data in file
        for (int i = 0; i < 6; i++) {
            String name = UserInputOutput.getStockName();
            stockAccount.setName(name);

            int price = UserInputOutput.getStockPrice();
            stockAccount.setPrice(price);

            int numberOfShares = UserInputOutput.getNumberOfShares();
            stockAccount.setNumberOfShares(numberOfShares);

            jsonObject.put("Name", stockAccount.getName());
            jsonObject.put("Price", stockAccount.getPrice());
            jsonObject.put("NumberOfShares", stockAccount.getNumberOfShares());
            jsonArray.add(jsonObject);

            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter(filePath);
                fileWriter.write(String.valueOf(jsonArray));
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // reading data from json file
    @Override
    public JSONArray readFromFile(String filePath) {
        JSONArray jsonArray = new JSONArray();
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader fileReader = new FileReader(filePath);
            jsonArray = (JSONArray) jsonParser.parse(fileReader);
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    // writing data in json file
    @Override
    public void writeToJsonFile(JSONArray jsonArray, String filePath) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write(String.valueOf(jsonArray));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // returns total value of user portfolio
    @Override
    public double totalStockValue(JSONArray jsonArray) {
        long numberOfShares;
        long price;
        double totalValue = 0, particularValue;
        JSONObject jsonObject;

        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            price = (long) jsonObject.get("Price");
            numberOfShares = (long) jsonObject.get("NumberOfShares");
            particularValue = price * numberOfShares;
            totalValue += particularValue;
        }
        return totalValue;
    }

    // returns total value of particular stock that user wants
    @Override
    public double getParticularValue(JSONArray jsonArray, String name) {
        JSONObject jsonObject;
        long particularValue = 0, price;
        long numberOfShares;

        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            if (jsonObject.get("Name").equals(name)) {
                price = (long) jsonObject.get("Price");
                numberOfShares = (long) jsonObject.get("NumberOfShares");
                particularValue = price * numberOfShares;
            }
        }
        return particularValue;
    }

    // returns array by updating share value by adding new shares
    @Override
    public JSONArray buyShares(String name, int numberOfShares, JSONArray jsonArray) {
        JSONObject jsonObject;
        long shares;
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            if (jsonObject.get("Name").equals(name)) {
                shares = (long) jsonObject.get("NumberOfShares");
                shares += numberOfShares;
                jsonObject.replace("NumberOfShares", shares);
            }
        }
        return jsonArray;
    }

    // returns array by updating share value by removing number of shares user want to sell
    @Override
    public JSONArray sellShares(String name, int numberOfShares, JSONArray jsonArray) {
        JSONObject jsonObject;
        long shares;
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            if (jsonObject.get("Name").equals(name)) {
                shares = (long) jsonObject.get("NumberOfShares");
                shares -= numberOfShares;
                jsonObject.replace("NumberOfShares", shares);
            }
        }
        return jsonArray;
    }

    // prints detail report of portfolio
    @Override
    public void printReport(JSONArray jsonArray) {
        JSONObject jsonObject;
        long numberOfShares;
        long sharePrice;
        double totalValue = 0, particularValue;
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            numberOfShares = (long) jsonObject.get("NumberOfShares");
            sharePrice = (long) jsonObject.get("Price");
            System.out.println(jsonObject.get("Name"));
            System.out.println(jsonObject.get("Price"));
            System.out.println(jsonObject.get("NumberOfShares"));
            particularValue = sharePrice * numberOfShares;
            totalValue += particularValue;
            System.out.println("The value of share " + jsonObject.get("Name") + " is " + particularValue);
        }
        System.out.println("The total value of the stock currently is : " + totalValue);
    }

    //use to display array
    @Override
    public void display(JSONArray jsonArray) {
        JSONObject jsonObject;
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = (JSONObject) jsonArray.get(i);
            System.out.println(jsonObject);
        }
    }
}
