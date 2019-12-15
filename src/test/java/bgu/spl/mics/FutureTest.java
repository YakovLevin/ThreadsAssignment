package bgu.spl.mics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class FutureTest {
    private Future<Integer> futureInt;
    private Future<String> futureString;

    @BeforeEach
    public void setUp() throws Exception{
        this.futureInt = new Future<Integer>();
        this.futureString = new Future<String>();

    }

    @Test
    public void test(){
        futureString.resolve("Completed");
        assertEquals("Completed", futureString.get());

        assertFalse(futureString.isDone());
        futureString.resolve("Done");
        assertTrue(futureString.isDone());

    }

    @Test
    public void get() {
        assertNull("expected null", futureString.get());

        futureInt.resolve(5);
        assertEquals(5, futureInt.get());

        futureString.resolve("Completed");
        assertEquals("Completed", futureString.get());
    }

    @Test
    public void resolve() {
        futureInt.resolve(5);
        assertEquals(5, futureInt.get());
    }

    @Test
    public void isDone() {
        assertFalse(futureInt.isDone());
        futureInt.resolve(5);
        assertTrue(futureInt.isDone());
    }

    @Test
    public void get1() {
        TimeUnit time = TimeUnit.MILLISECONDS;
        Object o = null;
        o = futureInt.get(3000,time);
        assertNull(o);

        futureInt.resolve((5));
        assertEquals("expected 5", 5, futureString.get(4000, time));
    }
}
