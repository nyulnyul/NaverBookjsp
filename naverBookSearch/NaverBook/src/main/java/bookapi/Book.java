package bookapi;

public class Book {
	 private String title;
	    private String author;
	    private String price;
	    private String publisher;
	    private String pubdate;
	    private String description;
	    private String isbn; // 일련번호


    // 기존의 getter와 setter 메소드들...
	    public String getTitle() {
	        return this.title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }
	    public String getDescription() {
	        return this.description;
	    }
	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getIsbn() {
	        return this.isbn;
	    }
	    // 책의 ISBN을 설정하는 메소드
	    public void setIsbn(String isbn) {
	        this.isbn = isbn;
	    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }


    // ... 나머지 필드들에 대한 getter와 setter
}