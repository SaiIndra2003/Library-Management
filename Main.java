import com.library.book.Book;
import com.library.book.BookManagement;
import com.library.book.BookManager;
import com.library.fine.FineCalculation;
import com.library.fine.FineCalculator;
import com.library.manager.Library;
import com.library.member.Member;
import com.library.member.MemberManagement;
import com.library.member.MemberManager;

public class Main {

    public static void main(String[] args){
        BookManagement bookManagement = new BookManager();
        MemberManagement memberManagement = new MemberManager();
        FineCalculation fineCalculation = new FineCalculator();

        Library library = new Library(bookManagement, memberManagement, fineCalculation);

        Book book1 = new Book("Think Like a Monk","Jay Shetty","12358");
        Book book2 = new Book("Think Like a Monk","Jay Shetty","12358");
        library.addBook(book1);
        library.addBook(book2);

        Member member1 = new Member("Surya",12);
        library.registerMember(member1);

        library.loanBook(book1,member1);
        library.removeBook(book2);

        library.returnBook(book1,member1);




    }

}
