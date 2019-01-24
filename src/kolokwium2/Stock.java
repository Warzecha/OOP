package kolokwium2;

import lab6.csv.CSVReader;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Stock {


    private List<StockItem> stockList = new ArrayList<>(1000);

    public Stock(String filepath) {


        CSVReader reader = new CSVReader(filepath,";",true);
        while(reader.next()){


            String productCode = reader.get("product_code");
            boolean active = true;
            String name = reader.get("name");
            double price = reader.getDouble("price");
            double vat = reader.getDouble("vat");
            String unit = reader.get("unit");
            String category = reader.get("category");
            String producer = reader.get("producer");
            double weight = reader.getDouble("weight", -1);
            int stock = reader.getInt("stock", 0);
//            double ean = Double.parseDouble(null);
            String delivery = reader.get("delivery");



            StockItem newItem = new StockItem(productCode, active, name, price, vat, unit, category, producer, weight, stock, delivery);

            stockList.add(newItem);
        }
    }




    public StockItem heaviesInCategory(String targetCategory) {
        StockItem toReturn = null;
        double heaviestWeight = 0;

        for (StockItem item : stockList) {
            if(item.getWeight() > heaviestWeight && item.getCategory().equals(targetCategory)) {
                toReturn = item;
                heaviestWeight = item.getWeight();
            }
        }
        return toReturn;
    }


    public List<StockItem> getAllWithNameLike(String word) {
        return stockList.stream().filter(i -> i.getName().toLowerCase().contains(word.toLowerCase())).collect(Collectors.toList());
    }


    public OptionalDouble averageWeightInCategory(String category) {
        return stockList.stream().filter(i -> i.getCategory().contains(category)).map(StockItem::getWeight).mapToDouble(Double::doubleValue).average();

    }


    public double totalNetValue() {
        return stockList.stream().map(i -> (i.getPrice() * i.getStock())).mapToDouble(Double::doubleValue).sum();
    }


    public static void main(String[] args) {
        Stock stock = new Stock("/home/damian/IdeaProjects/OOP/src/kolokwium2/super-toys.csv");


        System.out.println(stock.heaviesInCategory("Wózki dla lalek").getWeight());


        List<StockItem> mercedeses = stock.getAllWithNameLike("mercedes");

        for(StockItem item : mercedeses) {
            System.out.println(item.getName());
        }


        System.out.println(stock.averageWeightInCategory("Samochody na akumulator").getAsDouble());

        System.out.println(stock.totalNetValue());


    }






}
