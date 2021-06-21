package StockService;

import DOA.StockDOA;
import org.json.simple.JSONArray;

public class StockService  implements StockServiceInterface{
    StockDOA stockDOA = new StockDOA();

    @Override
    public void writeToFile(String filePath) {
        stockDOA.writeToFile(filePath);
    }

    @Override
    public JSONArray readFromFile(String filePath) {
        return stockDOA.readFromFile(filePath);
    }

    @Override
    public void writeToJsonFile(JSONArray jsonArray, String filePath) {
        stockDOA.writeToJsonFile(jsonArray, filePath);
    }

    @Override
    public double totalStockValue(JSONArray jsonArray) {
        return stockDOA.totalStockValue(jsonArray);
    }

    @Override
    public double getParticularValue(JSONArray jsonArray, String name) {
        return stockDOA.getParticularValue(jsonArray, name);
    }

    @Override
    public JSONArray buyShares(String name, int numberOfShares, JSONArray jsonArray) {
        return stockDOA.buyShares(name, numberOfShares, jsonArray);
    }

    @Override
    public JSONArray sellShares(String name, int numberOfShares, JSONArray jsonArray) {
        return stockDOA.sellShares(name, numberOfShares, jsonArray);
    }

    @Override
    public void printReport(JSONArray jsonArray) {
        stockDOA.printReport(jsonArray);
    }

    @Override
    public void display(JSONArray jsonArray) {
        stockDOA.display(jsonArray);
    }
}
