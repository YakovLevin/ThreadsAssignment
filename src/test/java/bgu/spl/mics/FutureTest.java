package bgu.spl.mics;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FutureTest {

    private Future<Integer> futureInt;
    private Future<String> futureString;


    @BeforeEach
    public void setUp() throws Exception{
        futureInt = new Future<Integer>();
        futureString = new Future<String>();
    }

    @Test
    public void test(){
        //TODO: change this test and add more tests :)
        fail("Not a good test");
    }

    @After
    public void tearDown() throws Exception {
        futureInt = null;
        futureString = null;
    }
}
