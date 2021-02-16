package src;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GradeBookTester {
    GradeBook book1,book2;
    @Before
    public void setUp() throws Exception {
        book1 = new GradeBook(5);
        book2 = new GradeBook(5);
        book1.addScore(10);
        book1.addScore(7);
        book2.addScore(2.5);
        book2.addScore(5.5);
    }

    @After
    public void tearDown() throws Exception {
        book1 = null;
        book2 = null;
    }

    @Test
    public void addScore() {
        assertEquals("10.0 7.0 ", book1.toString());
    }

    @Test
    public void sum() {
        assertEquals(17.0,book1.sum(),.0001);
    }

    @Test
    public void minimum() {
        assertEquals(7.0,book1.minimum(),.001);
    }

    @Test
    public void finalScore() {
        assertEquals(10.0,book1.finalScore(),.001);
    }

    @Test
    public void getScoresSize() {
        assertEquals(2,book1.getScoresSize(),0.001);
    }

    @Test
    public void testToString() {
        assertTrue(book1.toString().equals("10.0 7.0 "));
    }
}