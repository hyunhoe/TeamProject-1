import myClass.Book;
import myClass.User;
import myClass.DB_Element;
import DataBase.LibDB;
import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * LibraryManagementSystem : 도서관 이용자와 책의 정보를 관리하는 클래스
 *
 * @author (2023320023 이현회, 2022320029 이상민)
 * @version (2026.10.19)
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
     * borrowBook - 이용자의 ID와 책의 ID를 검색하고 대출 정보를 등록하는 메소드
     *
     * @param  userID : 이용자의 번호
     * @param  bookID : 책의 등록번호
     */
    public void borrowBook(String userID, String bookID)
    {
        User user = userDB.findElement(userID);
        Book book = bookDB.findElement(bookID);
        if(user != null && book != null){
            loanDB.put(user, book);
        }
    }

    /**
     * printDB - 데이터베이스에 저장된 모든 요소를 출력하는 메소드
     *
     * @param  db  출력할 데이터베이스
     */
    public <T extends DB_Element> void printDB(LibDB<T> db)
    {
        db.printAllElements();
    }

    /**
     * printLoanList - 대출 DB에 저장된 대출 현황을 출력하는 메소드
     */
    public void printLoanList()
    {
        System.out.println("----- 대출현황 -----");
        Set<User> userSet = loanDB.keySet();

        Iterator<User> it = userSet.iterator();
        while(it.hasNext()){
            User user = it.next();
            Book book = loanDB.get(user);

            System.out.println(user + " ===> " + book);
        }
    }

    /**
     * setBookDB - 책 데이터 파일을 읽어 책 객체 생성 후 DB에 저장하는 메소드
     * 
     * @param  bookFile  입력받을 책 데이터 파일의 경로
     * @return    책 정보를 저장한 DB
     */
    public LibDB<Book> setBookDB(String bookFile)
    {
        try{
            File bookfile = new File(bookFile);
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
            fr.close();
            scan.close();
        }
        catch(IOException e){
            System.out.println("파일 입력 오류가 발생!");
        }
        return bookDB;
    }

    /**
     * setUserDB - 이용자 데이터 파일을 읽어 이용자 객체 생성 후 DB에 저장하는 메소드
     *
     * @param  userFile  입력받을 이용자 데이터 파일의 경로
     * @return    이용자 정보를 저장한 DB
     */
    public LibDB<User> setUserDB(String userFile)
    {
        try{
            File userfile = new File(userFile);
            FileReader fr = new FileReader(userfile);
            Scanner scan = new Scanner(fr);
            while(scan.hasNext()){
                String word = scan.nextLine();
                StringTokenizer st = new StringTokenizer(word, "/");

                int userID = Integer.parseInt(st.nextToken());
                String name = st.nextToken();

                User user = new User(userID, name);
                userDB.addElement(user);
            }
            fr.close();
            scan.close();
        }
        catch(IOException e){
            System.out.println("파일 입력 오류가 발생!");
        }
        return userDB;
    }
}