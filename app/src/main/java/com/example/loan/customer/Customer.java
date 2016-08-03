package com.example.loan.customer;

/**
 * Created by LOAN on 8/1/2016.
 */
public class Customer
{
    private String name;
    private String noteBook;
    private String book;
    private String pen;

    public Customer()
    {

    }
    public Customer(String name, String book, String noteBook, String pen) {
        this.name = name;
        this.book = book;
        this.noteBook = noteBook;
        this.pen = pen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoteBook() {
        return noteBook;
    }

    public void setNoteBook(String noteBook) {
        this.noteBook = noteBook;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getPen() {
        return pen;
    }

    public void setPen(String pen) {
        this.pen = pen;
    }
    public double sum()
    {
      double sum=0;
        sum=Integer.parseInt(this.getBook())*23000+Integer.parseInt(this.getNoteBook())*8000+Integer.parseInt(this.getPen())*3000;
        return sum;
    }
}
