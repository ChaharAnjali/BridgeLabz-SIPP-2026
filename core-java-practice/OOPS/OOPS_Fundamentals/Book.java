class Book {
    String title;
    String author;
    double price;

    // default constructor
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;

    }
    //paramerterized constructor 

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    void display () {
          System.out.println("Title:" + title);
          System.out.println("Author:" + author);
          System.out.println("Price:" + price);
    }
    public static void main (String[]args) {
        Book b1 =  new Book();
        Book b2 = new Book("Java Programming", "James gosling", 599.99);
        System.out.println("Book 1 Details:");
        b1.display();
        System.out.println();
        System.out.println("Book 2 Details:");
        b2.display();
    }
}