class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
               ", Title: " + title +
               ", Author: " + author;
    }
}

public class LibraryManagementSystem {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary Search (Array must be sorted by title)
    public static Book binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {
                return books[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Books sorted alphabetically by title
        Book[] books = {
            new Book(101, "C Programming", "Dennis Ritchie"),
            new Book(102, "Data Structures", "Mark Allen"),
            new Book(103, "Java Programming", "James Gosling"),
            new Book(104, "Operating Systems", "Abraham Silberschatz"),
            new Book(105, "Python Basics", "Guido van Rossum")
        };

        String searchTitle = "Java Programming";

        System.out.println("Linear Search:");
        Book book1 = linearSearch(books, searchTitle);

        if (book1 != null)
            System.out.println(book1);
        else
            System.out.println("Book Not Found");

        System.out.println("\nBinary Search:");
        Book book2 = binarySearch(books, searchTitle);

        if (book2 != null)
            System.out.println(book2);
        else
            System.out.println("Book Not Found");
    }
}
