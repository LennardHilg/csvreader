import java.util.Scanner;
import java.util.ArrayList;

public class bookinfo {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Which file do you want to work with? Please enter file path:");
        String path = String.valueOf(sc.nextLine());
        // csv file to read
        ArrayList<book> list = csvreader.read(path);
        boolean run = true;

        while (run) {
            System.out.println("Search for title, author, genre, height or publisher?");
            String search = String.valueOf(sc.nextLine());
            
            // prints book with the paramater given by user
            switch (search) {
                case "title":
                    System.out.println("Give a title: ");
                    String title = String.valueOf(sc.nextLine());
                    for (book book : list) {
                        book.displayBookByTitle(title);
                    }
                    break;
                case "author":
                    System.out.println("Give an author: ");
                    String author = String.valueOf(sc.nextLine());
                    for (book book : list) {
                        book.displayBookByAuthor(author);
                    }
                    break;
                case "genre":
                    System.out.println("Give a genre:");
                    String genre = String.valueOf(sc.nextLine());
                    for (book book : list) {
                        book.displayBookByGenre(genre);
                    }
                    break;
                case "height":
                    System.out.println("What height has the book you are searching for?");
                    int height = Integer.valueOf(sc.nextLine());
                    for (book book : list) {
                        book.displayBookByHeight(height);
                    }
                    break;
                case "publisher":
                    System.out.println("Give a publisher: ");
                    String publisher = String.valueOf(sc.nextLine());
                    for (book book : list) {
                        book.displayBookByPublisher(publisher);
                    }
                    break;
                default:
                    System.out.println("Incorrect input!");
            }
            
            // boolean needed for while loop
            boolean continueSearching = true;
            
            // loop to ask whether user want to search for more
            while (continueSearching){
                System.out.println("Want to search for something else? yes or no?");
                String input = String.valueOf(sc.nextLine());
            
                switch (input) {
                    case "no":
                        // ends both while loops (at line 15 and 63)
                        run = false;
                        continueSearching = false;
                        break;
                    case "yes":
                        continueSearching = false;
                        break;
                    default:
                        System.out.println("Incorrect input!");
                }
            }
        }
        sc.close();
    }
}
// D:/lhilg/Documents/dogfile.csv
// D:/lhilg/Documents/books.csv
// D:/lhilg/Documents/booksHalf.csv
// D:/lhilg/Documents/booksQuarter.csv
// D:/lhilg/Documents/vapnir.csv
// D:/lhilg/Documents/bookseighth.csv
// D:/lhilg/Documents/missingData.csv