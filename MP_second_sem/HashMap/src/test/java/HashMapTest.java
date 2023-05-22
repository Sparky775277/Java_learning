import com.company.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HashMapTest {

    @Test
    @DisplayName("Should be true")
    void PriorityQueue_Success_0() {
    }

    @Test
    @DisplayName("Test of input #1")
    void HashMap_put_0() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(2, "2");
        hashMap.put(3, "3");
        hashMap.put(4, "4");
        hashMap.put(5, "5");
        hashMap.put(6, "6");
        hashMap.put(7, "7");
        hashMap.put(8, "8");
        hashMap.put(9, "9");

        Assertions.assertEquals(9, hashMap.size());
        Assertions.assertEquals("2", hashMap.get(2));
        Assertions.assertNull(hashMap.get(10));
    }

    @Test
    @DisplayName("Test of input #2")
    void HashMap_put_1() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "1");
        hashMap.put(1, "2");
        hashMap.put(1, "3");
        hashMap.put(1, "4");
        hashMap.put(1, "5");
        hashMap.put(1, "6");
        hashMap.put(1, "7");
        hashMap.put(1, "8");
        hashMap.put(1, "9");

        Assertions.assertEquals(1, hashMap.size());
        Assertions.assertEquals("9", hashMap.get(1));
    }


    @Test
    @DisplayName("Test of input #3")
    void HashMap_put_3() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            hashMap.put(i, Integer.toString(i));
        }

        Assertions.assertEquals("2022", hashMap.get(2022));
    }

    @Test
    @DisplayName("Test 'isEmpty' function")
    void PriorityQueue_isEmpty_0() {
        HashMap<String, Integer> map = new HashMap<>();
        Assertions.assertTrue(map.isEmpty());
        map.put("KING", 1);
        Assertions.assertFalse(map.isEmpty());
    }

    @Test
    @DisplayName("Test 'getSize' function")
    void PriorityQueue_getSize_0() {
        HashMap<String, Integer> map = new HashMap<>();
        Assertions.assertEquals(0, map.size());
        map.put("KING", 1);
        Assertions.assertEquals(1, map.size());
    }

    @Test
    @DisplayName("Test 'delete' function")
    void PriorityQueue_remove_0() {
        HashMap<String, Integer> map0 = new HashMap<>();
        map0.put("KING", 1);
        map0.put("Two", 2);
        map0.put("BLAKE", 2);

        map0.remove("KING");


        Assertions.assertEquals(2, map0.size());
    }

    @Test
    @DisplayName("Clear function")
    void PriorityQueue_Clear_0() {
        HashMap<String, Integer> map0 = new HashMap<>();
        map0.put("KING", 1);
        map0.put("Two", 2);
        map0.put("BLAKE", 2);
        map0.deleteAll();


        Assertions.assertEquals(0, map0.size());
    }

}