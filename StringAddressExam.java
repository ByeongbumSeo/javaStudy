public class StringAddressExam {

    public static void main(String[] args) {
        String_주소값();

        String_재정의_주소값_변경();

        String_생성자_주소값();
    }


    /*
    Java에서 객체의 주소값을 직접적으로 얻는 것은 불가능합니다.
    그러나 객체의 hashCode 값을 출력하여 간접적으로 객체를 구별할 수 있습니다.
    hashCode는 객체의 메모리 주소를 기반으로 생성되지만, 정확히 메모리 주소와 일치하지는 않습니다.

    : System.identityHashCode(Object x) 메서드를 사용하여 객체의 고유한 hashCode 값을 출력
     */
    private static void String_주소값() {
        System.out.println("\n\n==========String_주소값()==========");

        String str1 = "Hello";
        String str2 = new String("Hello");
        String str3 = "Hello";

        // hashCode 출력
        System.out.println("str1 hashCode: " + System.identityHashCode(str1));
        System.out.println("str2 hashCode: " + System.identityHashCode(str2));
        System.out.println("str3 hashCode: " + System.identityHashCode(str3));

        // equals 메서드를 사용하여 문자열 비교
        System.out.println("str1 equals str2: " + str1.equals(str2));
        System.out.println("str1 equals str3: " + str1.equals(str3));
    }
    /*
    str1 hashCode: 168423058
    str2 hashCode: 1325547227
    str3 hashCode: 168423058
    str1 equals str2: true
    str1 equals str3: true
     */


    private static void String_재정의_주소값_변경() {
        System.out.println("\n\n==========String_재정의_주소값_변경()==========");

        String str1 = "Hello";
        System.out.println("str1 hashCode: " + System.identityHashCode(str1));

        // 재정의
        str1 = "Hello!";
        System.out.println("str1 hashCode: " + System.identityHashCode(str1));

        // 다시 재정의(원복)
        str1 = "Hello";
        System.out.println("str1 hashCode: " + System.identityHashCode(str1));

    }
    /*
    str1 hashCode: 168423058
    str1 hashCode: 980546781
    str1 hashCode: 168423058
     */


    /*
    s1과 s2는 동일한 객체를 참조하므로 true가 출력
    하지만 s3와 s4는 각각 새로운 객체를 생성하기 때문에 false가 출력

    String Literal 방식은 메모리를 절약하고 성능을 향상시키기 때문에 일반적으로 권장됩니다.

    new 연산자는 특별한 이유가 없으면 피하는 것이 좋습니다. 동일한 문자열 리터럴이 String Pool에 이미 존재하더라도 새로운 객체를 생성하므로 메모리 낭비가 발생할 수 있습니다.
    (String 객체를 new 연산자로 생성하면, 같은 값이라 할지라도 Heap 영역에 매번 새로운 객체가 생성된다. 따라서 String이 갖는 불변성이라는 장점을 누리지 못한다.)

    ** 즉, String 객체의 생성 방식에 따라 메모리 효율성과 성능이 달라짐을 알 수 있다.
    (String literal(큰 따옴표)로 String을 생성하는 것이 메모리상 효율적이다.) **

    */
    private static void String_생성자_주소값() {
        System.out.println("\n\n==========String_생성자_주소값()==========");

        // String literal 방식
        String s1 = "Hello";
        String s2 = "Hello";

        /*
        s1과 s2는 동일한 객체를 참조하므로 true가 출력
         */
        System.out.println("s1 == s2 : " + (s1 == s2)); // true
        System.out.println("s1 hashCode: " + System.identityHashCode(s1));
        System.out.println("s2 hashCode: " + System.identityHashCode(s2));

        /*
        s3와 s4는 각각 새로운 객체를 생성하기 때문에 false가 출력
         */
        // new 연산자를 사용한 String 생성
        String s3 = new String("Hello");
        String s4 = new String("Hello");

        System.out.println("s3 == s4 : " + (s3 == s4)); // false
        System.out.println("s3 hashCode: " + System.identityHashCode(s3));
        System.out.println("s4 hashCode: " + System.identityHashCode(s4));

        /*
        만약 new를 사용하여 생성한 String 객체가 String Pool에 있는 문자열과 동일한 객체로 처리되길 원한다면,
        intern() 메서드를 사용하여 String Pool에 추가하고 재사용할 수 있습니다.
         */
        // intern() 메서드 사용 : 자세한 설명은 아래 메서드 참고
        String s5 = s3.intern();
        String s6 = s4.intern();
        System.out.println("s5 == s6 : " + (s5 == s6)); // true
        System.out.println("s5 hashCode: " + System.identityHashCode(s5));
        System.out.println("s3 hashCode: " + System.identityHashCode(s3));
        System.out.println("s6 hashCode: " + System.identityHashCode(s6));
        System.out.println("s4 hashCode: " + System.identityHashCode(s4));

    }



    /*
    .intern() 메서드는 Java의 String 클래스에서 제공하는 메서드로,
    String 객체를 String Constant Pool에 저장하거나 해당 객체가 이미 Pool에 있는 경우 그 객체를 반환하는 기능을 합니다.


    ** [ .intern() 메서드의 동작 원리 ] **

    1. String Pool 확인:

    intern() 메서드는 호출된 String 객체의 내용을 String Pool에서 검색합니다.
    만약 String Pool에 동일한 내용의 String 객체가 이미 존재하면, 그 객체의 참조(reference)를 반환합니다.
    이 경우, 호출된 String 객체는 String Pool에 있는 기존의 String 객체를 가리키게 됩니다.

    2. String Pool에 추가:

    만약 String Pool에 동일한 내용의 String 객체가 없다면, intern() 메서드는 현재 호출된 String 객체를 String Pool에 추가하고, 그 객체의 참조를 반환합니다.

    ** [ .intern() 메서드를 사용하는 이유 ] **

    메모리 절약:
    intern() 메서드를 사용하면 동일한 내용의 String 객체가 여러 개 존재하는 경우, 그 객체들이 String Pool에서 같은 참조를 공유하게 됩니다. 이는 메모리 사용을 최적화하고, 중복된 객체 생성을 방지합니다.

    성능 최적화:
    자주 사용되는 String 객체를 String Pool에 저장하여 여러 번 재사용할 수 있습니다. 이로 인해 객체 생성 비용이 줄어들고 성능이 향상될 수 있습니다.

    ** [ 주의해야할 점 ] **
    String.intern() 메서드는 자주 호출될 경우 오히려 성능이 저하될 수 있습니다.
    특히, JVM은 String Pool을 관리하는 데 비용이 들기 때문에, 너무 많은 문자열을 Pool에 넣으면 메모리와 성능에 부정적인 영향을 줄 수 있습니다.


    .intern() 메서드는 메모리 절약과 성능 최적화를 위해 사용될 수 있는 강력한 도구입니다.
    그러나 남용할 경우 성능 저하를 초래할 수 있으므로, 사용 시에는 문자열의 재사용 여부와 메모리 관리를 고려해야 합니다.
     */
    private static void String_intern(){
        String s1 = new String("Hello");
        String s2 = "Hello";

        // 기본적으로 s1과 s2는 다른 객체를 참조
        System.out.println(s1 == s2); // false

        // s1을 intern() 호출하여 String Pool에 추가
        String s3 = s1.intern();

        // s3은 이제 String Pool의 "Hello"를 참조, 따라서 s2와 동일
        System.out.println(s3 == s2); // true
    }

}