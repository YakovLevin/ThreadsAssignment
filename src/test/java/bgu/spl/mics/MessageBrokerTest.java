package bgu.spl.mics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

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
    public  void subscribeEvent(Class<? extends Event<T>> type, Subscriber m) {
    }

    @Test
    public void subscribeBroadcast(Class<? extends Broadcast> type, Subscriber m) {
        // TODO Auto-generated method stub

    }

    @Test
    public  void complete(Event<T> e, T result) {
        // TODO Auto-generated method stub

    }

    @Test
    public void sendBroadcast(Broadcast b) {
        // TODO Auto-generated method stub

    }


    @Test
    public void sendEvent() {
        Future<Integer> futureInteger;
        msgB1.sendEvent(new IntEvent(5));
    }

    @Test
    public void register(Subscriber m) {
        // TODO Auto-generated method stub

    }

    @Test
    public void unregister(Subscriber m) {
        // TODO Auto-generated method stub

    }

    @Test
    public void awaitMessage(Subscriber m) throws InterruptedException {
        // TODO Auto-generated method stub
    }


}
