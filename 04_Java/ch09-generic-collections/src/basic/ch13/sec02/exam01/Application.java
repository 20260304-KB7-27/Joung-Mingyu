package basic.ch13.sec02.exam01;

public class Application {
    public static void main(String[] args) {
        // product1 인스턴스에서 Kind의 타입은 TV
        Product<TV, String> product1 = new Product<>();

        // 컴파일 시점에 타입이 지정되기 때문에
        // Setter의 매개값은 타입에 맞춰 제공되어야 함.
        product1.setKind(new TV());
        product1.setModel("스마트 TV");

        TV tv = product1.getKind();
        String model = product1.getModel();

        Product<Car, String> product2 = new Product<>();
        product2.setKind(new Car());
        product2.setModel("자동차");

        Car car = product2.getKind();
        String model2 = product2.getModel();
    }
}
