package com.library.manager;

import com.library.book.Book;
import com.library.book.BookManagement;
import com.library.fine.FineCalculation;
import com.library.loan.Loan;
import com.library.member.Member;
import com.library.member.MemberManagement;

public class Library {
    private final BookManagement bookManager;
    private final MemberManagement memberManager;
    private final FineCalculation fineCalculator;

    public Library(BookManagement bookManager, MemberManagement memberManager, FineCalculation fineCalculator) {
        this.bookManager = bookManager;
        this.memberManager = memberManager;
        this.fineCalculator = fineCalculator;
    }

    public void addBook(Book book) {
        bookManager.addBook(book);
    }

    public void removeBook(Book book) {
        bookManager.removeBook(book);
    }

    public Book searchBookByTitle(String title) {
        return bookManager.searchBookByTitle(title);
    }

    public void registerMember(Member member) {
        memberManager.registerMember(member);
    }

    public void loanBook(Book book, Member member) {
        memberManager.loanBook(book, member);
    }

    public void returnBook(Book book, Member member) {
        Loan loanDetails = memberManager.getLoanDetails(book, member);
        double fine = fineCalculator.calculateFine(loanDetails);
        if (fine > 0.0) {
            System.out.println("com.library.book.Book return got delayed and fine is :" + fine);
        } else {
            System.out.println("com.library.book.Book returned on time, no fee required");
        }
        memberManager.returnBook(book, member);
    }


}
