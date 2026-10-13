package DataBase;
import myClass.DB_Element;
import java.util.*;

/**
 * LibDB : User와 Book의 정보를 저장, 추가, 검색, 출력하는 데이터베이스 클래스
 *
 * @author (2023320023 이현회)
 * @version (2026.10.13)
 */
public class LibDB<T extends DB_Element>
{
    private ArrayList<T> db;

    /**
     * LibDB 클래스의 객체 생성자
     */
    public LibDB()
    {
        this.db = new ArrayList<T>();
    }

    /**
     * addElement - 데이터베이스에 요소를 추가하는 메소드
     *
     * @param  element  추가할 요소
     */
    public void addElement(T element)
    {
        db.add(element);
    }

    /**
     * findElement - 학번 또는 책 이름과 동일한 요소를 데이터베이스에서 찾는 메소드
     *
     * @param  ID  학번 또는 책 이름
     * @return    동일한 요소를 찾은 경우 element를 반환, 찾지 못한 경우 null을 반환
     */
    public T findElement(String ID)
    {
        Iterator<T> it = db.iterator();
        while(it.hasNext()){
            T element = it.next();
            if(ID.equals(element.getID())){
                return element;
            }
        }
        return null;
    }

    /**
     * printAllElements - 데이터베이스의 모든 요소들을 출력하는 메소드
     */
    public void printAllElements()
    {
        for(T element : db){
            System.out.println(element);
        }
    }

}