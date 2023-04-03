package day04;


import io.reactivex.rxjava3.core.Flowable;
import org.junit.jupiter.api.Test;
import subscribe.ConsoleSubscribe;

import java.util.concurrent.TimeUnit;

public class FlowableTest {


    @Test
    public void generateFlowable() {
        Flowable<Long> intervalFlowable = Flowable.interval(1, TimeUnit.SECONDS);

        intervalFlowable.subscribe(new ConsoleSubscribe());
        while (true) {

        }
    }
}
