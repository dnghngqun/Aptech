import com.github.javafaker.Faker;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MongoDbDataGenerator {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("sales_db");
        MongoCollection <Document> salesCollection = database.getCollection("sales_slot9");

        //tạo dữ liệu mẫu
        Faker faker = new Faker();

        Random random = new Random();

        //sản phẩm mẫu
        List<Document> productList = List.of(
                new Document("product_id","PROD001").append("price", 100),
                new Document("product_id","PROD002").append("price", 150),
                new Document("product_id","PROD003").append("price", 200),
                new Document("product_id","PROD004").append("price", 300),
                new Document("product_id","PROD005").append("price", 350),
                new Document("product_id","PROD006").append("price", 400),
                new Document("product_id","PROD007").append("price", 450),
                new Document("product_id","PROD008").append("price", 500),
                new Document("product_id","PROD009").append("price", 550),
                new Document("product_id","PROD0010").append("price", 600)
        );
        LocalDate startDate = LocalDate.of(2021, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        //tạo 10000 bản ghi
        List<Document> saleRecords = new ArrayList<>();
        for(int i = 0; i < 10000; i++){
           // String customerId = UUID.randomUUID().toString();
            String customerId = generateCustomId();//tạo ra ud có tỉ lệ trùng cao
            //tạo thông tin mua sản phẩm
            List<Document> items = new ArrayList<>();
            int numItems = random.nextInt(5) + 1; //bao nhiêu sản phâ trong 1 giao dịch
            for( int j = 0; j < numItems; j++){
              Document product = productList.get(random.nextInt(productList.size()));
              int quantity = random.nextInt(10) + 1;
              items.add(new Document("product_id", product.getString("product_id"))
                      .append("quantity", quantity)
                      .append("price", product.getInteger("price"))
              );

            }
//tính tổng tiền và giao dịch
            int totalAmount = items.stream()
                    .mapToInt(item -> item.getInteger("quantity") * item.getInteger("price"))
                    .sum();
            //ngày thực hiện giao dịch
           // String saleDate = faker.date().past(365, TimeUnit.DAYS).toString();
            // Chọn ngày ngẫu nhiên và chuyển đổi sang dạng `Date`
            LocalDate randomDate = startDate.plusDays(random.nextInt((int) daysBetween + 1));
            LocalDateTime randomDateTime = randomDate.atTime(random.nextInt(24), random.nextInt(60), random.nextInt(60));
            Date saleDate = Date.from(randomDateTime.atZone(ZoneId.systemDefault()).toInstant());

            // Định dạng ngày theo định dạng của `Faker`
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
            String formattedDate = dateFormat.format(saleDate);
            //tạo baản ghi mẫu
            Document saleRecord = new Document("date", formattedDate)
                    .append("customer_id", customerId)
                    .append("item", items)
                    .append("total_amount", totalAmount);
            saleRecords.add(saleRecord);

        }
        //Chèn dữ liệu vaò mongoDB
        salesCollection.insertMany(saleRecords);
        System.out.println("Đã chèn thành công 10000 bản ghi vào collection sales");
        mongoClient.close();
    }
    private static String generateCustomId() {
        Random random = new Random();
        // Tạo số ngẫu nhiên có độ dài cố định
        int number = random.nextInt(20000) + 900; // Tạo số ngẫu nhiên từ 100000 đến 999999
        return "CUS" + number; // Kết hợp tiền tố với số ngẫu nhiên
    }

}
