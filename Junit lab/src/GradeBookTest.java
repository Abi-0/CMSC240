package src;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeBookTest extends GradeBook {
    GradeBook book1,book2;
    /**
     * Constructs a gradebook with no scores and a given capacity.
     *
     * @param capacity
     * @capacity the maximum number of scores in this gradebook
     */
    public GradeBookTest(int capacity) {
        super(capacity);
    }

    @BeforeEach
    void setUp() {
         book1 = new GradeBook(5);
         book2 = new GradeBook(5);
        book1.addScore(10);
        book1.addScore(7);
        book2.addScore(2.5);
        book2.addScore(5.5);
    }

    @AfterEach
    void tearDown() {
        book1 = null;
        book2 = null;
    }

    @Test
    void testAddScore() {
        assertTrue(book1.toString().equals("10.0 7.0 "));
    }

    @Test
    void testSum() {
        assertEquals(17.0,book1.sum(),.0001);
    }

    @Test
    void testMinimum() {
        assertEquals(7.0,book1.minimum(),.001);
    }

    @Test
    void testFinalScore() {
        assertEquals(10.0,book1.finalScore(),.001);
    }

    @Test
    void testGetScoresSize() {

    }

    @Test
    void testToString() {

    }
}