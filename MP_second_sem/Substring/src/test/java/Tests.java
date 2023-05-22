
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.*;

public class Tests {


    @Test
    @DisplayName("Should be true")
    void Substring_test_0() {
    }

    @Test
    @DisplayName("BoyerMoore: (1)")
    public void test_BoyerMoor_1() {
        String string = "Simple string for basic test";
        String substring = "for";

        List<Integer> result = new ArrayList<>();
        result.add(14);
        assertEquals(result, SubstringSearch.boyerMoore(string, substring));
    }

    @Test
    @DisplayName("BoyerMoore: (2)")
    public void test_BoyerMoor_2() {
        String string = "Let's imagine ...You're watching TV. It's a hot evening: You feel thirsty. You see an advert for a refreshing drink. You see people looking cool and relaxed.";
        String substring = "You";

        List<Integer> result = new ArrayList<>();
        result.add(17);
        result.add(57);
        result.add(75);
        result.add(117);
        assertEquals(result, SubstringSearch.boyerMoore(string, substring));
    }

    @Test
    @DisplayName("BoyerMoore: (3)")
    public void test_BoyerMoor_3() {
        String string = "Advertisers study how people learn so that they can 'teach' them to respond to their advertising. They want us to be interested, to try something, and then to do it again. These are the elements of learning: interest, experience and repetition. If an advert can achieve this, it is successful. If an advert works well, the same technique can be used to advertise different things. So, for example, in winter if the weather is cold and you see a family having a warming cup of tea and feeling cosy, you may be interested and note the name of the tea ... Here the same technique is being used as with the cool, refreshing drink.";
        String substring = "can";

        List<Integer> result = new ArrayList<>();
        result.add(48);
        result.add(258);
        result.add(338);
        assertEquals(result, SubstringSearch.boyerMoore(string, substring));
    }


    @Test
    @DisplayName("KnuthMorrisPratt: (1)")
    public void test_KnuthMorrisPrat_1() {
        String string = "Simple string for basic test";
        String substring = "for";

        List<Integer> result = new ArrayList<>();
        result.add(14);
        assertEquals(result, SubstringSearch.knuthMorrisPratt(string, substring));
    }

    @Test
    @DisplayName("KnuthMorrisPratt: (2)")
    public void test_KnuthMorrisPrat_2() {
        String string = "Let's imagine ...You're watching TV. It's a hot evening: You feel thirsty. You see an advert for a refreshing drink. You see people looking cool and relaxed.";
        String substring = "You";

        List<Integer> result = new ArrayList<>();
        result.add(17);
        result.add(57);
        result.add(75);
        result.add(117);
        assertEquals(result, SubstringSearch.knuthMorrisPratt(string, substring));
    }

    @Test
    @DisplayName("KnuthMorrisPratt: (3)")
    public void test_KnuthMorrisPrat_3() {
        String string = "Advertisers study how people learn so that they can 'teach' them to respond to their advertising. They want us to be interested, to try something, and then to do it again. These are the elements of learning: interest, experience and repetition. If an advert can achieve this, it is successful. If an advert works well, the same technique can be used to advertise different things. So, for example, in winter if the weather is cold and you see a family having a warming cup of tea and feeling cosy, you may be interested and note the name of the tea ... Here the same technique is being used as with the cool, refreshing drink.";
        String substring = "can";

        List<Integer> result = new ArrayList<>();
        result.add(48);
        result.add(258);
        result.add(338);
        assertEquals(result, SubstringSearch.knuthMorrisPratt(string, substring));
    }

    @Test
    @DisplayName("FiniteAutomata:(1)")
    public void test_FSM_1() {
        String string = "Simple string for basic test";
        String substring = "for";

        List<Integer> result = new ArrayList<>();
        result.add(14);
        assertEquals(result, SubstringSearch.finiteAutomata(string, substring));
    }

    @Test
    @DisplayName("FiniteAutomata:(2)")
    public void test_FSM_2() {
        String string = "Let's imagine ...You're watching TV. It's a hot evening: You feel thirsty. You see an advert for a refreshing drink. You see people looking cool and relaxed.";
        String substring = "You";

        List<Integer> result = new ArrayList<>();
        result.add(17);
        result.add(57);
        result.add(75);
        result.add(117);
        assertEquals(result, SubstringSearch.finiteAutomata(string, substring));
    }

    @Test
    @DisplayName("FiniteAutomata:(3)")
    public void test_FSM_3() {
        String string = "Advertisers study how people learn so that they can 'teach' them to respond to their advertising. They want us to be interested, to try something, and then to do it again. These are the elements of learning: interest, experience and repetition. If an advert can achieve this, it is successful. If an advert works well, the same technique can be used to advertise different things. So, for example, in winter if the weather is cold and you see a family having a warming cup of tea and feeling cosy, you may be interested and note the name of the tea ... Here the same technique is being used as with the cool, refreshing drink.";
        String substring = "can";

        List<Integer> result = new ArrayList<>();
        result.add(48);
        result.add(258);
        result.add(338);
        assertEquals(result, SubstringSearch.finiteAutomata(string, substring));
    }
}
