package Session1.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class MyDbConnection {
    public static MongoDatabase getDatabase() {
        String connectionString = "mongodb://localhost:27017"; // URL truy cập vào server MongoDB
        String dbName = "MyDb"; // Tên Session1.database

        // Tạo client MongoDB
        MongoClient mongoClient = MongoClients.create(connectionString);

        // Lấy Session1.database từ client
        MongoDatabase database = mongoClient.getDatabase(dbName);
        return database;
    }

    public static void main(String[] args) {
        // Gọi phương thức để kiểm tra kết nối
        MongoDatabase database = getDatabase();
        if (database != null) {
            System.out.println("Connect to MongoDB success!");
        }
    }
}
