package com.epam.izh.rd.online.repository;
import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;
public class SimpleSchoolBookRepository implements BookRepository<SchoolBook>{
    @Override
    public boolean save(SchoolBook book) {
        SchoolBook[] schoolBooks2 = new SchoolBook[schoolBooks.length + 1];
        java.lang.System.arraycopy(schoolBooks, 0, schoolBooks2, 0, schoolBooks.length);
        schoolBooks2[schoolBooks2.length - 1] = (SchoolBook) book;
        this.schoolBooks = schoolBooks2;
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] books = new SchoolBook[0];
        for (int i = 0; i < schoolBooks.length; i++) {
            if (name.equals(schoolBooks[i].getName())) {
                SchoolBook[] book2 = new SchoolBook[books.length + 1];
                java.lang.System.arraycopy(books, 0, book2, 0, books.length);
                book2[books.length] = schoolBooks[i];
                books = book2;
            }
        }
        return books;
    }

    @Override
    public boolean removeByName(String name) {
        boolean flag = false;
        for (int i = schoolBooks.length -1; i >= 0; i--) {
            if (name.equals(schoolBooks[i].getName())) {
                SchoolBook[] books = new SchoolBook[schoolBooks.length - 1];
                java.lang.System.arraycopy(schoolBooks, 0, books, 0, schoolBooks.length - 1);
                if (i != schoolBooks.length - 1) {
                    java.lang.System.arraycopy(schoolBooks, i + 1, books, i, schoolBooks.length - (schoolBooks.length - (i + 1)));
                }
                this.schoolBooks = books;
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }

    private SchoolBook[] schoolBooks = new SchoolBook[0];
}
