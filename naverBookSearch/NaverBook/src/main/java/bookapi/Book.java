package bookapi;
public class Book {
    private String title;
    private String link;
    private String image;
    private String author;
    private String price;
    private String publisher;
    private String pubdate;
    private String description;

    // getter와 setter 메소드들
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // 다른 필드들에 대해서도 같은 방식으로 getter와 setter
}
