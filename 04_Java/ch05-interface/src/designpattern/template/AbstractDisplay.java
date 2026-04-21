package designpattern.template;

public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    // 템플릿 메소드
    public final void display() {
        // display의 흐름(알고리즘): open → print*5 → close
        open();

        for (int i = 0; i < 5; i++) {
            print();
        }

        close();
    }
}
