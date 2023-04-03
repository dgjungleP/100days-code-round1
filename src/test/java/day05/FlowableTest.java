package day05;


import io.reactivex.rxjava3.core.Flowable;
import org.junit.jupiter.api.Test;
import subscribe.ConsoleSubscribe;

import java.util.concurrent.TimeUnit;

public class FlowableTest {


    @Test
    public void generateFlowable() {
        Flowable<Long> flowable = Flowable.timer(10, TimeUnit.SECONDS);
        flowable.subscribe(new ConsoleSubscribe());
        while (true) {

        }
    }
}
