public class TryCatchExam {


    /*
    실행 순서 :
    1. Try 블록: try 블록이 예외로 인해 종료되고 catch 블록으로 이동.
    2. Catch 블록: 예외가 발생하여 catch 블록이 종료되고 finally 블록으로 이동.
    3. Finally 블록: finally 블록은 예외 발생 여부와 관계없이 항상 실행.
    4. 프로그램 종료: catch 블록에서 발생한 예외가 상위로 전달되며 프로그램이 종료됨.

   => try에서 예외 발생 시, 해당 예외는 catch로 넘어가며 catch에서 예외가 발생할 경우, 이후의 코드는 실행되지 않고 바로 finally로 이동한 후 예외를 상위로 전달


    알 수 있는 점:

    1. catch 블록 내에서 새로운 예외를 발생시키더라도, finally 블록이 먼저 실행된 후 예외가 처리된다.
    2. 예외가 발생해도 finally는 항상 실행된다는 점에서 finally를 사용해 자원 해제나 정리 작업을 수행해도 안전하다는 것을 확인할 수 있다.

    => finally는 예외의 발생 여부와 관계없이 항상 실행된다. 따라서 finally를 사용해 자원 해제나 정리 작업을 수행해도 안전하다. (예외 발생해도 자원 해제 가능)
     */
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("==============try==============");

            throw new Exception("==============tryException==============");

        } catch (Exception ex) {

            System.out.println("==============catch==============");

            throw new Exception("==============catchException==============");

        } finally {
            System.out.println("==============finally==============");
        }

    }
    /* 실행 결과 :
    ==============try==============
    ==============catch==============
    ==============finally==============
    Exception in thread "main" java.lang.Exception: ==============catchException==============
        at TryCatchExam.main(TryCatchExam.java:13)
     */
}
