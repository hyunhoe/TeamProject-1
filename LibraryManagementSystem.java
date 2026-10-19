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
 * @author (2023320023 이현회)
 * @version (2026.10.18)
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
        User user = userDB.findElement(userID);
        Book book = bookDB.findElement(bookID);
        if(user != null && book != null){
            loanDB.put(user, book);
        }
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
     * 메소드 예제 - 사용자에 맞게 주석을 바꾸십시오.
     *
     * @param  y  메소드의 샘플 파라미터
     * @return    x 와 y의 합
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