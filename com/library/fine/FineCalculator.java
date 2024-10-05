package com.library.fine;

import com.library.loan.Loan;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FineCalculator implements FineCalculation {

    @Override
    public double calculateFine(Loan loan) {
        long daysOverdue = ChronoUnit.DAYS.between(loan.getDueDate(), LocalDate.now());
        return daysOverdue > 0 ? daysOverdue * 0.50 : 0.0;
    }
}
