package com.library.member;

import com.library.book.Book;
import com.library.loan.Loan;

public interface MemberManagement {
    void registerMember(Member member);

    void loanBook(Book book, Member member);

    void returnBook(Book book, Member member);

    Loan getLoanDetails(Book book, Member member);
}
