import myClass.Book;
import myClass.User;
import myClass.DB_Element;
import DataBase.LibDB;
import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * LibraryManagementSystem 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibraryManagementSystem
{
    LibDB<Book> bookDB;
    HashMap<User, Book> loanDB;
    LibDB<User> userDB;

    /**
     * LibraryManagementSystem 클래스의 객체 생성자
     */
    public LibraryManagementSystem()
    {
        userDB = new LibDB<User>();
        bookDB = new LibDB<Book>();
        loanDB = new HashMap<User,Book>();
    }

    /**
     * 예제 메소드 - 이 주석을 사용자에 맞게 바꾸십시오
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 더하기 y의 결과값을 반환
     */
    public void borrowBook(String userID, String bookID)
    {
        // 여기에 코드를 작성하세요.
        return x + y;
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public <T extends DB_Element> void printDB(LibDB<T> db)
    {
        db.printAllElements();
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public void printLoanList()
    {
        System.out.println("----- 대출현황 -----");
        Set<User> userSet = loanDB.keySet();
        
        Iterator<User> it = loanDB.keySet().iterator();
        while(it.hasNext()){
            User user = it.next();
            Book book = loanDB.get(user);
            
            System.out.println(user + "===>" + book);
        }
    }
     
    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     * 
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibDB<Book> setBookDB(String bookFile)
    {
        File bookfile = new File("C:/Windows/Temp/BookData2025.txt");
        FileReader fr = new FileReader(bookfile);
        Scanner scan = new Scanner(fr);
        while(scan.hasNext()){
            String word = scan.nextLine();
            StringTokenizer st = new StringTokenizer(word, "/");
            
            String bookID = st.nextToken();
            String title = st.nextToken();
            String author = st.nextToken();
            String publisher = st.nextToken();
            int year = Integer.parseInt(st.nextToken());
            
            Book book = new Book(author, bookID, publisher, title, year);
            bookDB.addElement(book);
        }
    }

    /**
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
     */
    public LibDB<User> setUserDB(String userile)
    {
        File userfile = new File("C:/Windows/Temp/UserData2025.txt");
        FileReader fr = new FileReader(userfile);
        Scanner scan = new Scanner(fr);
        while(scan.hasNext()){
            String word = scan.nextLine();
            StringTokenizer st = new StringTokenizer(word, "/");
            
            int stID = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            User user = new User(stID, name);
            userDB.addElement(user);
        }
    }
}