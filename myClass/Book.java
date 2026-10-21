package myClass;

/**
 * 추상 클래스 DB_Element를 상속받는 Book 클래스
 *
 * @author (2024320014_박동해)
 * @version (2026.10.14)
 */
public class Book extends DB_Element
{
    private String author; 
    private String bookID; 
    private String publisher;
    private String title;
    private int year;

    /**
     * Book 객체를 생성하고 속성을 초기화하는 생성자
     * 
     * @param author - 책의 저자
     * @param bookID - 책의 고유 식별 번호(도서ID)
     * @param publisher - 출판사
     * @param title - 책 제목
     * @param year - 출판년도
     */
    public Book(String author, String bookID, 
    String publisher, String title, int year)
    {
        this.author = author;
        this.bookID = bookID;
        this.publisher = publisher;
        this.title = title;
        this.year = year;
    }

    /**
     * getID 메소드 - 책의 고유 식별자(도서ID)를 반환
     * @return - bookID 문자열
     */
    public String getID()
    {
        return bookID;
    }

    /**
     * toString 메소드 - 객체의 전체 도서 정보를 문자열 형태로 반환
     *
     * @return - "(bookID) title, author, publisher, year" 형식의 문자열
     */
    public String toString()
    {
        return "(" + bookID + ") " + title + ", " + 
        author + ", " + publisher + ", " + year;
    }

}