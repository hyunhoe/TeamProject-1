import myClass.User;
import myClass.Book;
import DataBase.LibDB;

/**
 * App - 
 *
 * @author (2022320029 이상민)
 * @version (2026.10.19)
 */
public class App
{
    public static void main(String[] args)
    {
        LibraryManagementSystem libMS = new LibraryManagementSystem();

        LibDB<User> userDB = libMS.setUserDB("C:\\Temp\\UserData2025.txt");

        System.out.println("----- 이용자 목록 출력 -----");
        libMS.printDB(userDB);

        LibDB<Book> bookDB = libMS.setBookDB("C:\\Temp\\BookData2025.txt");

        System.out.println("\n----- 책 목록 출력 -----");
        libMS.printDB(bookDB);

        libMS.borrowBook("2025320001", "B02");
        libMS.borrowBook("2024320002", "B03");
        libMS.borrowBook("2023320003", "B04");

        System.out.println();
        libMS.printLoanList();
    }
}