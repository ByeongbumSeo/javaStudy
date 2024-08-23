import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExam {

    public static void main(String[] args) {
        // 테스트
        Set<String> hashSet = new HashSet<>();
        List<String> arrayList = new ArrayList<>();

        // 데이터 추가
        for (int i = 0; i < 1000000; i++) {
            String value = "Value" + i;
            hashSet.add(value);
            arrayList.add(value);
        }

        // 검색할 값
        String searchValue = "Value999999";

        // HashSet 검색
        long startTime = System.nanoTime();
        boolean foundInSet = hashSet.contains(searchValue);
        long endTime = System.nanoTime();
        System.out.println("HashSet 검색 시간: " + (endTime - startTime) + " ns");

        // ArrayList 검색
        startTime = System.nanoTime();
        boolean foundInList = arrayList.contains(searchValue);
        endTime = System.nanoTime();
        System.out.println("ArrayList 검색 시간: " + (endTime - startTime) + " ns");
    }
    /*
    HashSet 검색 시간: 29458 ns
    ArrayList 검색 시간: 8092042 ns
     */
}
