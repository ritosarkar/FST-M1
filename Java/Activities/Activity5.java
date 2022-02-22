package activities;

abstract class Book{
    String title;

    abstract void setTitle(String bookName);

    String getTitle() {
        return title;
    }
}

class MyBook extends Book{
    public void setTitle(String bookName) {
        title = bookName;
    }
}

public class Activity5 {
    public static void main(String []args)
    {
        String title = "Ramayana";
        Book myBook= new MyBook();
        myBook.setTitle(title);
        System.out.println("The tile is "+ myBook.getTitle());
    }

}