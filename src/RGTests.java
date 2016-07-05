import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;

/**
 * Search edge cases
 *
 *
 * @author Rania Glass
 * @version 1.0
 */
public class RGTests {
    private SearchableString kittycat;
    private SearchableString kittyText;
    private List<Integer> kittyAnswer;

    private SearchableString puppydog;
    private SearchableString puppyText;
    private List<Integer> puppyAnswer;

    private SearchableString parrotbird;
    private SearchableString parrotText;
    private List<Integer> parrotAnswer;

    private SearchableString meow;
    private SearchableString meowText;
    private List<Integer> meowAnswer;


    private SearchableString woof;
    private SearchableString woofText;
    private List<Integer> woofAnswer;

    private SearchableString chirp;
    private SearchableString chirpText;
    private List<Integer> chirpAnswer;

    private CharSequence fish;
    private CharSequence fishText;
    private List<Integer> fishAnswer;

    private CharSequence snek;
    private CharSequence snekText;
    private List<Integer> snekAnswer;



    private CharSequence scabbers;
    private CharSequence ratText;
    private List<Integer> ratAnswer;


    public static final int TIMEOUT = 200;

    @Before
    public void setUp() {

        /**Boyer Moore*/
        kittycat = new SearchableString("itt");
        kittyText = new SearchableString("She's a pretty kitty kitty cat!");
        kittyAnswer = new ArrayList<>();
        kittyAnswer.add(16);
        kittyAnswer.add(22);

        parrotbird = new SearchableString(" ");
        parrotText = new SearchableString("Parrot bird can say words!");
        parrotAnswer = new ArrayList<>();
        parrotAnswer.add(6);
        parrotAnswer.add(11);
        parrotAnswer.add(15);
        parrotAnswer.add(19);

        puppydog = new SearchableString("puppydog");
        puppyText = new SearchableString("puppydog");
        puppyAnswer = new ArrayList<>();
        puppyAnswer.add(0);

        /**KMP**/

        meow = new SearchableString("meow");
        meowText = new SearchableString("The cat says meow! " +
                "Not merow, not me-ow. meow says the cat.");
        meowAnswer = new ArrayList<>();
        meowAnswer.add(13);
        meowAnswer.add(41);


        woof = new SearchableString("o");
        woofText = new SearchableString("woofwoofwoof");
        woofAnswer = new ArrayList<>();
        woofAnswer.add(1);
        woofAnswer.add(2);
        woofAnswer.add(5);
        woofAnswer.add(6);
        woofAnswer.add(9);
        woofAnswer.add(10);


        chirp = new SearchableString("chirp");
        chirpText = new SearchableString("chirp");
        chirpAnswer = new ArrayList<>();
        chirpAnswer.add(0);

        /**Rabin Karp**/

        fish = new SearchableString("bub");
        fishText = new SearchableString
                ("bubblubblubbubbleblubub");
        fishAnswer = new ArrayList<>();
        fishAnswer.add(0);
        fishAnswer.add(11);
        fishAnswer.add(20);


        snek = new SearchableString("hissss");
        snekText = new SearchableString("s");
        snekAnswer = new ArrayList<>();
        snekAnswer.add(2);
        snekAnswer.add(3);
        snekAnswer.add(4);
        snekAnswer.add(5);


        scabbers = new SearchableString("Scabbers is Ron's rat");
        ratText = new SearchableString("Scabbers is Ron's rat");
        ratAnswer = new ArrayList<>();
        ratAnswer.add(0);

    }

    /**Boyer Moore**/
    @Test(timeout = TIMEOUT)
    public void testBoyerMooreRepeatedPattern() {
        assertEquals(kittyAnswer, StringSearching.boyerMoore(kittycat,
                kittyText));
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreSingleCharacter() {
        assertEquals(parrotAnswer, StringSearching.boyerMoore(parrotbird,
                parrotText));
    }

    @Test(timeout = TIMEOUT)
    public void testBoyerMooreWholeText() {
        assertEquals(puppyAnswer, StringSearching.boyerMoore(puppydog,
                puppyText));
    }

    /**Knuth Morris Pratt **/
    @Test(timeout = TIMEOUT)
    public void testKMPRepeatedPattern() {
        assertEquals(meowAnswer, StringSearching.kmp(meow,
                meowText));
    }
    
     @Test (timeout = TIMEOUT)
    public void testRepeatsInPattern() {
        SearchableString fiveAs = new SearchableString("aaaaa");
        SearchableString tripAs = new SearchableString("aaa");
        List<Integer> tripAsAns = new ArrayList<>();
        tripAsAns.add(0);
        tripAsAns.add(1);
        tripAsAns.add(2);
       assertEquals(tripAsAns, StringSearching.kmp(tripAs, fiveAs));
    }

    @Test(timeout = TIMEOUT)
    public void testKMPSingleCharacter() {
        assertEquals(woofAnswer, StringSearching.kmp(woof,
                woofText));
    }

    @Test(timeout = TIMEOUT)
    public void testKMPWholeText() {
        assertEquals(chirpAnswer, StringSearching.kmp(chirp,
                chirpText));
    }

    /**Rabin Karp**/
    @Test(timeout = TIMEOUT)
    public void testRabinKarpRepeatedPattern() {
        System.out.println(fishAnswer);
        assertEquals(fishAnswer, StringSearching.rabinKarp(fish,
                fishText));
    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpSingleCharacter() {
        assertEquals(snekAnswer, StringSearching.rabinKarp(snekText,
                snek));

    }

    @Test(timeout = TIMEOUT)
    public void testRabinKarpWholeText() {
        System.out.println(ratAnswer);
        System.out.println(scabbers);
        System.out.println(ratText);
        assertEquals(ratAnswer, StringSearching.rabinKarp(scabbers,
                ratText));
    }

}