package basic.lecture.exam;

public class Database {
    /*
    싱글톤 패턴
    - 어플리케이션에서 하나의 객체만 생성되도록 보장하는 디자인 패턴
    - 동일한 인스턴스를 고융해서 사용
     */

    private String connection = "MYSQL";

    // 객체를 만들지 않아도 사용 가능
    private static Database database = new Database();

    // 기본 생성자를 private로 접근 못하게 막음
    public Database() {
    }

    // static 메소드로 인스턴스 반환
    public static Database getInstance() {
        return database;
    }
}
