package StockService;

import org.json.simple.JSONArray;

public interface StockServiceInterface {
    void writeToFile(String filePath);

    JSONArray readFromFile(String filePath);

    void writeToJsonFile(JSONArray jsonArray, String filePath);

    double totalStockValue(JSONArray jsonArray);

    double getParticularValue(JSONArray jsonArray, String name);

    JSONArray buyShares(String name, int numberOfShares, JSONArray jsonArray);

    JSONArray sellShares(String name, int numberOfShares, JSONArray jsonArray);

    void printReport(JSONArray jsonArray);

    void display(JSONArray jsonArray);
}
