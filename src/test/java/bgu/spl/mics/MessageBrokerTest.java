package bgu.spl.mics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageBrokerTest {

    MessageBroker msgB1;
    MessageBroker msgB2;

    @BeforeEach
    public void setUp(){
        msgB1 =  MessageBrokerImpl.getInstance();
        msgB2 =  MessageBrokerImpl.getInstance();
    }

    @Test
    public void test(){

    }

    @Test
    public  void subscribeEvent() {
        Subscriber s1 = new SimpleSubscriberTest();
        msgB1.subscribeEvent(IntEventTest.class , s1);
    }

    @Test
    public void subscribeBroadcast(Class<? extends Broadcast> type, Subscriber m) {

    }

    @Test
    public  void complete() {
        Event<Integer> e1 = new IntEventTest();
        msgB1.complete(e1 , 5);
        assertNotNull( msgB1);

        Event<Integer> e2 = new IntEventTest();
        msgB1.complete(e2 , 7);
        assertNotNull( msgB2);

    }

    @Test
    public void sendBroadcast() {
        Broadcast b1 = new SimpleBroadcastTest();
        msgB1.sendBroadcast(b1);
        assertNotNull(msgB1);

        Broadcast b2 = new SimpleBroadcastTest();
        msgB2.sendBroadcast(b2);
        assertNotNull(msgB2);
    }


    @Test
    public void sendEvent() {
        Future<Integer> futureInteger;
        msgB1.sendEvent(new IntEvent(5));
    }

    @Test
    public void register(Subscriber m) {
        Subscriber s1 = new SimpleSubscriberTest();
        msgB1.register(s1);
        assertNotNull(msgB1);

        Subscriber s2 = new SimpleSubscriberTest();
        msgB2.register(s2);
        assertNotNull(msgB2);
    }

    @Test
    public void unregister(Subscriber m) {
        Subscriber s = new SimpleSubscriberTest();
        msgB2 = msgB1;
        msgB1.register(s);
        msgB2.register(s);

        msgB1.unregister(s);
        assertNotNull(msgB1);
        assertNotEquals(msgB1 , msgB2);
    }

    @Test
    public void awaitMessage() throws InterruptedException {
        Subscriber s = new SimpleSubscriberTest();
        assertNotNull(msgB1.awaitMessage(s));

        Subscriber s1 = new SimpleSubscriberTest();
        assertNotNull(msgB2.awaitMessage(s1));
    }


}
