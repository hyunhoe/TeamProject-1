import myClass.User;
import myClass.Book;
import DataBase.LibDB;

/**
 * App - 프로그램 메인 진입점.
 *
 * @author (2022320029 이상민)
 * @version (2026.10.19)
 */
public class App
{
    public static void main(String[] args)
    {
        LibraryManagementSystem lms = new LibraryManagementSystem();

        LibDB<User> userDB = lms.setUserDB("C:\\Temp\\UserData2025.txt");

        System.out.println("----- 이용자 목록 출력 -----");
        lms.printDB(userDB);

        LibDB<Book> bookDB = lms.setBookDB("C:\\Temp\\BookData2025.txt");

        System.out.println("\n----- 책 목록 출력 -----");
        lms.printDB(bookDB);

        lms.borrowBook("2025320001", "B02");
        lms.borrowBook("2024320002", "B03");
        lms.borrowBook("2023320003", "B04");

        System.out.println();
        lms.printLoanList();
    }
}