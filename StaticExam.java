class MyClass {
    static int staticVariable = 10;
    int instanceVariable = 20;

    static void staticMethod() {
        System.out.println("Static Method");
    }

    void instanceMethod() {
        System.out.println("Instance Method");
    }
}

public class StaticExam {
    public static void main(String[] args) {
        // Static 변수와 메소드에 접근
        System.out.println(MyClass.staticVariable); // 10
        MyClass.staticMethod(); // Static Method

        // 인스턴스 변수와 메소드에 접근
        MyClass obj = new MyClass();
        System.out.println(obj.instanceVariable); // 20
        obj.instanceMethod(); // Instance Method
    }
}