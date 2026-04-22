package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        try {
            int result = data.length(); // data가 null일 경우 NullPointerException 발생
            // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "data" is null
            System.out.println("문자 수: " + result);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null); // <- 여기서 null 대입됨
        System.out.println("[프로그램 종료]");
    }
}