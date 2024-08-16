package Session1.Service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import Session1.database.MyDbConnection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private String nameCollection = "news";

    public Service() {
        this.database = MyDbConnection.getDatabase();
        this.collection = database.getCollection(nameCollection);
    }

    public List<Document> getAll(){
        List<Document> news = new ArrayList<>();
        //tìm all tài liệu và trả về 1 iterator
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                news.add(cursor.next());
            }
        }
        return news;
    }

    public void addDocument(Document doc) {
        try {
            collection.insertOne(doc);
            System.out.println("Inserted " + doc.toJson());
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error inserting document");
        }
    }

}
