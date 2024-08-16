package Session1.Controllers;

import Session1.Service.Service;
import org.bson.Document;

import java.util.List;

public class Controller {
    Service service = new Service();

    public Controller() {
    }

    public void getAll(){
        List<Document> news = service.getAll();
        for(Document doc : news){
            System.out.println(doc.toJson());
        }
    }

    public void addDocument(Document doc){
        service.addDocument(doc);
    }

}
