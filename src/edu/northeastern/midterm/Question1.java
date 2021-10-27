package edu.northeastern.midterm;

abstract class Book {
    private String title;
    private double price;
    private String publishYear;

    Book(String title, double price, String publishYear) {
        this.title = title;
        this.price = price;
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public abstract String description();
}

interface Borrowable {
    void setBorrowDate(int day);
    void setReturnDate(int day);
    boolean isAvailable(int day);
}

class Fiction extends Book implements Borrowable {
    private int borrowDate;
    private int returnDate;

    Fiction(String title, double price, String publishYear) {
        super(title, price, publishYear);
    }
    @Override
    public void setBorrowDate(int day) {
        this.borrowDate = day;
    }

    @Override
    public void setReturnDate(int day) {
        this.returnDate = day;
    }

    @Override
    public boolean isAvailable(int day) {
        return !(borrowDate <= day && day <= returnDate);
    }

    @Override
    public String description() {
        return getTitle() + " all events are imaginary and not based on real facts";
    }
}

class NonFiction extends Book implements Borrowable {
    private int borrowDate;
    private int returnDate;

    NonFiction(String title, double price, String publishYear) {
        super(title, price, publishYear);
    }
    @Override
    public void setBorrowDate(int day) {
        this.borrowDate = day;
    }

    @Override
    public void setReturnDate(int day) {
        this.returnDate = day;
    }

    @Override
    public boolean isAvailable(int day) {
        return !(borrowDate <= day && day <= returnDate);
    }

    @Override
    public String description() {
        return getTitle() + " all events are true and based on real facts.";
    }
}

class Reference extends Book {
    private String category;

    Reference(String title, double price, String publishYear, String category) {
        super(title, price, publishYear);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String description() {
        return getTitle() + " all information is real.";
    }
}
