package com.t2307m.group1;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<WebItem> webItems = new ArrayList<>();

        try {
            System.out.println("Start crawl!");
            for(int i = 1; i <= 500; i++) {
                String url = "https://batdongsan.com.vn/nha-dat-ban/p"+i;
                System.out.println("Crawl web url: " + url);
                List<WebItem> newWebItems = getWebItems(url);
                webItems.addAll(newWebItems);
            }


            // Chuyển list webItems thành JSON text
            Gson gson = new Gson();
            String json = gson.toJson(webItems);

            String urlFilePath = "data.json";
            // Tạo đối tượng File
            File file = new File(urlFilePath);

            // Ghi JSON vào tệp tin
            try (FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(json);
                System.out.println("File written to " + urlFilePath);
            } catch (Exception e) {
                System.err.println("Failed to save file: " + e.getMessage());
            }

            // Kiểm tra xem tệp tin đã tồn tại chưa
            if (file.exists()) {
                System.out.println("File written to: " + file.getAbsolutePath());
            } else {
                System.out.println("Failed to save file!");
            }
            try {
                MongoCollection<org.bson.Document> collection = MongoDbConnection();

                //chuyển đổi webItem thành document
                List<org.bson.Document> documents = webItems.stream()
                        .map(webItem -> new org.bson.Document("id", webItem.getId())
                                .append("title", webItem.getTitle())
                                .append("price", webItem.getPrice())
                                .append("area", webItem.getArea())
                                .append("pricePerM2", webItem.getPricePerM2())
                        ).toList();

                System.out.println("Save data to database...");
                int totalItems = documents.size();
                int lastProgress = 0;
                for (int i = 0; i < totalItems; i++) {
                    collection.insertOne(documents.get(i));
                    int progress = (i + 1) * 100 / totalItems;
                    if (progress > lastProgress) {
                        System.out.println("Progress: " + progress + "%");
                        lastProgress = progress;
                    }
                }
                System.out.println("Success!!!");
            }catch (Exception e){
                System.err.println("Failed to save data to database: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Failed to fetch data: " + e.getMessage());
        }

    }

    private static MongoCollection<org.bson.Document> MongoDbConnection(){
        String connString = "mongodb://localhost:27017/";
        String dbName = "CrawlJava";
        String collectionName = "batdongsan";

        //create client mongoDB
        MongoClient mongoClient = MongoClients.create(connString);

        //get database
        MongoDatabase db = mongoClient.getDatabase(dbName);
        System.out.println("Connected to database " + dbName);

        if (db == null){
            throw new RuntimeException("No database found");
        }
        //get collection
        MongoCollection<org.bson.Document> collection = db.getCollection(collectionName);
        return collection;
    }

    private static List<WebItem> getWebItems(String url) throws IOException {
        List<WebItem> webItemsList = new ArrayList<>();
        Document doc = Jsoup.connect(url)
                .timeout(30 * 1000)// đợi máy chủ phản hồi tối đa 30s
                .get();
        Elements elements = doc.select(".js__card.js__card-full-web.pr-container.re__card-full");

        for(Element e: elements){
            WebItem webItem = new WebItem();
            webItem.setTitle(e
                    .select("div.re__card-info-content > h3.re__card-title > span.pr-title.js__card-title").text());
            webItem.setArea(e
                    .select("div.re__card-info-content >div > div.re__card-config.js__card-config > span.re__card-config-area.js__card-config-item").text());
            webItem.setPrice(e
                    .select("div.re__card-info-content >div > div.re__card-config.js__card-config > span.re__card-config-price.js__card-config-item").text());
            webItem.setPricePerM2(e
                    .select("div.re__card-info-content >div > div.re__card-config.js__card-config > span.re__card-config-price_per_m2.js__card-config-item").text());

            webItemsList.add(webItem);
        }

        return webItemsList;
    }
}

