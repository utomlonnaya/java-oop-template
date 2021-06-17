package com.epam.izh.rd.online.service;
import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.repository.AuthorRepository;
import com.epam.izh.rd.online.service.AuthorService;
public class SimpleAuthorService implements AuthorService {
    @Override
    public boolean save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        return authorRepository.findByFullName(name, lastname);
    }

    @Override
    public boolean remove(Author author) {
        return authorRepository.remove(author);
    }

    @Override
    public int count() {
        return authorRepository.count();
    }

    private AuthorRepository authorRepository;

    public SimpleAuthorService() {
    }

    public SimpleAuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
