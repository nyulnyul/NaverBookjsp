package bookapi;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BookJsonParser {
    public List<Book> parseJson(String json) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObj = (JsonObject) parser.parse(json);
        JsonArray itemsArray = (JsonArray) jsonObj.get("items");
        List<Book> bookList = new ArrayList<Book>();

        for (int i = 0; i < itemsArray.size(); i++) {
            try {
                JsonObject itemObject = (JsonObject) itemsArray.get(i);
                Book book = new Book();

                // 파싱 로직 수정
                book.setTitle(itemObject.get("title").getAsString());
                book.setAuthor(itemObject.get("author").getAsString());
                book.setPublisher(itemObject.get("publisher").getAsString());
                book.setIsbn(itemObject.get("isbn").getAsString());
                book.setDescription(itemObject.get("description").getAsString());
                book.setPrice(itemObject.get("price").getAsString());

                bookList.add(book);
            } catch (Exception e) {
                System.out.println("Error while parsing JSON: " + e.getMessage());
            }
        }
        return bookList;
    }
}