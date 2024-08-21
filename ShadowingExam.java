public class ShadowingExam {
    int x = 10; // 외부 변수

    public void outerMethod() {
        int x = 20; // 내부 변수, 외부 변수를 가림
        System.out.println("Inner x: " + x); // 내부 x의 값을 출력
        System.out.println("Outer x using this: " + this.x); // 외부 x의 값을 출력
    }

    public static void main(String[] args) {
        ShadowingExam example = new ShadowingExam();
        System.out.println("Outer x: " + example.x); // 외부 x의 값을 출력
        example.outerMethod(); // outerMethod를 호출
    }

}
