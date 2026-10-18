package myClass;

/**
 * 추상 클래스 DB_Element를 상속받는 User클래스
 *
 * @author (2024320014_박동해)
 * @version (2026.10.14)
 */
public class User extends DB_Element
{
    private String name;
    private Integer stID;

    /**
     * User 객체를 생성하고 속성을 초기화하는 생성자
     * 
     * @param stID - 이용자 번호
     * @param name - 이용자의 이름
     */
    public User(int stID, String name)
    {
        this.stID = stID;
        this.name = name;
    }

    /**
     * getID 메소드 - stID를 문자열 형태로 반환함
     * @return - 문자열로 변환된 stID
     */
    public String getID()
    {
        return String.valueOf(stID);
    }

    /**
     * toString 메소드 - 객체의 주요 정보를 문자열로 반환
     * @return - "[stID] name" 형식의 문자열
     */
    public String toString()
    {
        return "[" + stID + "] " + name; 
    }
}