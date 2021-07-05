// book class with title, author, genre, height, publisher
public class book{
    private String title;
    private String author;
    private String genre;
    private int height;
    private String publisher;

    // book class constructor
    public book (String title, String author, String genre, int height, String publisher){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.height = height;
        this.publisher = publisher;
    }
    // method to show dog information
    public void display(){
        System.out.println("title: " + title + ", author: " + author + ", genre: " + genre + ", height: " + height + ", publisher: " + publisher);
    }

    // methods to display books that fit user input
    public void displayBookByTitle(String title){
        if (this.title.contains(title)){
            this.display();
        }
    }

    public void displayBookByAuthor(String author){
        if (this.author.contains(author)){
            this.display();
        }
    }

    public void displayBookByGenre(String genre){
        if (genre.equals(this.genre)){
            this.display();
        }
    }

    public void displayBookByHeight(int height){
        if (height == this.height){
            this.display();
        }
    }

    public void displayBookByPublisher(String publisher){
        if (this.publisher.contains(publisher)){
            this.display();
        }
    }
}



