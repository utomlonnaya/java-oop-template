package com.epam.izh.rd.online.repository;
import com.epam.izh.rd.online.entity.Author;
public class SimpleAuthorRepository implements AuthorRepository {
    @Override
    public boolean save(Author author) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].equals(author)) return false;
        }
        Author[] authors1 = new Author[authors.length + 1];
        java.lang.System.arraycopy(authors, 0, authors1, 0, authors.length);
        authors1[authors1.length - 1] = author;
        this.authors = authors1;
        return true;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (int i = 0; i < authors.length; i++) {
            if (name.equals(authors[i].getName()) & lastname.equals(authors[i].getLastName()))
                return authors[i];
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        for (int i = authors.length - 1; i >= 0; i--) {
            if (author.equals(authors[i])) {
                Author[] author2 = new Author[authors.length - 1];
                java.lang.System.arraycopy(authors, 0, author2, 0, authors.length - 1);
                if (i != authors.length - 1)
                    java.lang.System.arraycopy(authors, i + 1, author2, i, authors.length - (authors.length - (i + 1)));
                this.authors = author2;
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        int counter = 0;
        for (Author author : authors) {
            if (author != null)
                counter++;
        }
        return counter;
    }

    private Author[] authors = new Author[0];
}
