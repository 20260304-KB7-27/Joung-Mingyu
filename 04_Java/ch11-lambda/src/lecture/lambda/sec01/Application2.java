package lecture.lambda.sec01;

public class Application2 {
    public static void main(String[] args) {
        OuterCalculator.Sum sum = (x, y) -> x + y;
        OuterCalculator.Minus minus = (x, y) -> x - y;
        OuterCalculator.Divide divide = (x, y) -> x / y;
    }
}
