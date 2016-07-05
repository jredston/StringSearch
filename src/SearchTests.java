import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 * KMP tests
 * 
 * @author Marc Marone
 */
public class SearchTests {
    @Test(timeout = 200)
    public void kmpPalindrome() {
        test("bob", "xXbobobXx", new int[]{2,4}, 8);
    }
    @Test(timeout = 200)
    public void kmpExampleFromSlides() {
        test("abacab", "abacaabaccabacabaabb", new int[]{10}, 21);
    }
    @Test(timeout = 200)
    public void kmpSingleChar() {
        test("a", "aaa", new int[]{0,1,2}, 3);
    }
    @Test(timeout = 200)
    public void kmpSimple() {
        test("abc", "abcabc", new int[]{0,3}, 6);
    }
    @Test(timeout = 200)
    public void kmpNestedMatches() {
        test("aaa", "aaaaa", new int[]{0,1,2}, 5);
    }
    @Test(timeout = 200)
    public void kmpNested2() {
        test("aba", "ababaxxxbababa", new int[]{0,2,9,11}, 15);
    }
    @Test(timeout = 200)
    public void kmpSingleCharHarder() {
        test("a", "aaxaxaaxaxaa", new int[]{0,1,3,5,6,8,10,11}, 12);
    }
    @Test(timeout = 200)
    public void kmpTheMotionTest() {
        test("abc", "abcccabc", new int[]{0,5}, 8);
    }
    @Test(timeout = 200)
    public void kmpTest2JudgementDay() {
        test("abc", "abcccabc", new int[]{0,5}, 8);
    }
    @Test(timeout = 200)
    public void kmpTest3RevengeOfTheTest() {
        test("aaa","aaaccaaccaaccaaa", new int[]{0,13}, 22);
    }
    @Test(timeout = 200)
    public void kmpPalindromeBobAndTheTestOfFire() {
        test("bob", "bobooobobobbbbob", new int[]{0,6,8,13}, 20);
    }

    public ArrayList<Integer> make(int [] ints) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int e: ints ) {
            ans.add(e);
        }
        return ans;
    }
    public void test(String pattern, String text, int[] matches, int comps) {
        SearchableString p = new SearchableString(pattern);
        SearchableString t = new SearchableString(text);
        assertEquals(make(matches), StringSearching.kmp(p, t));
        System.out.println("Yours: " + t.getCount() + " Mine: " + comps);
        //Uncomment this to check comparisons!
        //assertEquals(comps, t.getCount());
    }
}