package basic.lecture.encapsulation;

public class Application {
    public static void main(String[] args) {
        Monster monster = new Monster();
//        monster.name = "드라큘라";
        monster.setName("드라큘라");
        System.out.println(monster.getName());
    }
}
