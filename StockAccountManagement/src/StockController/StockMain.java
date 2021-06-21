package StockController;
/**
 * Created a program to read in Stock Names, Number of Share, Share Price.
 * Print a Stock Report with the total value of each Stock and the total value of
 * Stock and also user can buy and sell shares
 * I/P -> N number of Stocks, for Each Stock Read In the Share Name, Number of Share, and Share Price
 * Logic -> Calculate the value of each stock and the total value
 * O/P -> Print the Stock Report,Total Value of Portfolio,Particular Stock Value,also buy and sell shares
 *
 * @author Krunal Lad
 * @Since 21-06-2021
 */

import StockService.StockService;
import Util.UserInputOutput;
import org.json.simple.JSONArray;


public class StockMain {

    // main method
    public static void main(String[] args) {
        StockService stockService = new StockService();
        System.out.println("Welcome to Stock Account Management");

        // file path of json file which stores all data
        String filePath = "/C:/Users/Kunal/IdeaProjects/StockAccountManagement/Stock.json";
        JSONArray readArray, buyArray, sellArray;

        boolean flag = true;

        while (flag) {
            int choice = UserInputOutput.displayOptions();;
            int numberOfShares;
            switch (choice) {
                case 1:
                    // adds new stock data but will replace all previous data
                    System.out.println("Adding New Company to Stock Portfolio");
                    stockService.writeToFile(filePath);
                    break;
                case 2:
                    // gets total value of particular stock user wants
                    System.out.println("Particular Value : ");
                    readArray = stockService.readFromFile(filePath);
                    String stockName = UserInputOutput.getStockName();
                    double particularValue = stockService.getParticularValue(readArray, stockName);
                    System.out.println("Total Share Value of "+stockName+" is "+particularValue);
                    break;
                case 3:
                    // gives total value of user portfolio
                    System.out.println("Total Value : ");
                    readArray = stockService.readFromFile(filePath);
                    double totalStockValue = stockService.totalStockValue(readArray);
                    System.out.println("Total portfolio value is : "+totalStockValue);
                    break;
                case 4:
                    // user can buy share
                    System.out.println("Buy Shares : ");
                    readArray = stockService.readFromFile(filePath);
                    stockName = UserInputOutput.getStockName();
                    numberOfShares = UserInputOutput.getNumberOfShares();
                    buyArray = stockService.buyShares(stockName, numberOfShares, readArray);
                    stockService.writeToJsonFile(buyArray, filePath);
                    stockService.display(buyArray);
                    break;
                case 5:
                    // user can sell share
                    System.out.println("Sell Shares : ");
                    readArray = stockService.readFromFile(filePath);
                    stockName = UserInputOutput.getStockName();
                    numberOfShares= UserInputOutput.getNumberOfShares();
                    sellArray = stockService.sellShares(stockName, numberOfShares, readArray);
                    stockService.writeToJsonFile(sellArray, filePath);
                    stockService.display(sellArray);
                    break;
                case 6:
                    // printing detail info of all stocks
                    System.out.println("Print Report : ");
                    readArray = stockService.readFromFile(filePath);
                    stockService.printReport(readArray);
                    break;
                case 7:
                    //exiting the loop
                    System.out.println("Exited :)");
                    flag = false;
                    break;
            }
        }


    }
}
