package com.library.member;

import com.library.book.Book;
import com.library.loan.Loan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberManager implements MemberManagement {
    private final List<Member> members;
    private final List<Loan> loans;

    public MemberManager() {
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    @Override
    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Registered com.library.member.Member: " + member.getName());
    }

    @Override
    public void loanBook(Book book, Member member) {
        Loan bookLoan = new Loan(book, member, LocalDate.now(), LocalDate.now().plusDays(5));
        loans.add(bookLoan);
        System.out.println("com.library.book.Book loaned: " + book.getTitle() + " to: " + member.getName());
    }

    @Override
    public void returnBook(Book book, Member member) {
        loans.removeIf(loan -> loan.getBook().equals(book) && loan.getMember().equals(member));
        System.out.println("com.library.book.Book returned: " + book.getTitle() + " by: " + member.getName());
    }

    @Override
    public Loan getLoanDetails(Book book, Member member) {
        return loans.stream().filter(loan -> loan.getBook().equals(book) && loan.getMember().equals(member)).findFirst().orElse(null);
    }
}
