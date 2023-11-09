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

                if (itemObject.has("title")) {
                    book.setTitle(itemObject.get("title").getAsString());
                }

                // 다른 필드들에 대해서도 동일하게 체크

                bookList.add(book);
            } catch (Exception e) {
                System.out.println("Error while parsing JSON: " + e.getMessage());
            }
        }
        return bookList;
    }
}
