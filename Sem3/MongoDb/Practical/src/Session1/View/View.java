package Session1.View;

import Session1.Controllers.Controller;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class View {
   Controller controller = new Controller();
    private final BufferedReader reader;

    public View () {

        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    private void addNewDoc() throws IOException {
        Document newDoc = new Document();
//        System.out.println("Enter fields for the new document(type 'done' when finished): ");
        while (true){
            System.out.println("Enter field name (or type 'done' to finish): ");
            String fieldName = reader.readLine();
            //ktra fieldName có trùng với done ko, kể cả viết hoa viết thường
            if ("done".equalsIgnoreCase(fieldName)){
                break;
            }
            System.out.println("Enter value of field '"+fieldName+"': ");
            System.out.println("If the field has multiple values, follow the example: [apple, banana, orange]");
            System.out.println("Enter value: ");
            String fieldValue = reader.readLine();

            //ktra giá trị nhâập phải mảng ko, nếu cs, ptich thành phâần tử
            Object value = fieldValue;
            if(fieldValue.startsWith("[") && fieldValue.endsWith("]")){
                //fieldValue.substring(1, fieldValue.length() - 1): loại bỏ ngoặc đầu và cuối
                // \\s*: 0 hoặc nhiều kí tự khoảng trắng
                value = Arrays.asList(fieldValue.substring(1, fieldValue.length()-1). split(",\\\\s*"));

            }
            newDoc.append(fieldName, value);

        }
        controller.addDocument(newDoc);
    }

    private int menu() throws IOException {
        System.out.println("=======MENU ORDER==============");
        System.out.println("1. Add new document");
        System.out.println("2. View All News Json");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(reader.readLine());
    }

    private void getAll(){
        controller.getAll();
    }

    public void start() throws IOException {
        boolean running = true;
        while (running) {
            int choice = menu();
            switch (choice) {
                case 1:
                    addNewDoc();
                    break;
                case 2:
                    getAll();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}
