class Parent {
    int x = 100; // Parent 클래스의 인스턴스 변수 x

    Parent() {
        this(500); // Parent(int x) 생성자 호출
    }

    Parent(int x) {
        this.x = x; // Parent 클래스의 x 변수 초기화
    }

    int getX() {
        return x; // Parent 클래스의 x 변수 반환
    }
}

class Child extends Parent {
    int y = 2000; // Child 클래스의 인스턴스 변수 y

    Child() {
        this(5000); // Child(int y) 생성자 호출
    }

    Child(int y) {
        this.y = y; // Child 클래스의 y 변수 초기화
    }

    void printValues() {
        System.out.println("x = " + super.x); // Parent 클래스의 x 변수 접근
        System.out.println("y = " + this.y);  // Child 클래스의 y 변수 접근
    }

    public static void main(String[] args) {
        Child obj = new Child(); // Child 클래스의 기본 생성자 호출
        obj.printValues(); // x와 y 값 출력
    }
}