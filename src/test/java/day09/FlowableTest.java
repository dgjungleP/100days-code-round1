package day09;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.Test;
import subscribe.ConsoleSubscribe;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class FlowableTest {


    @Test
    public void generateFlowable() {
        Flowable<Integer> mapFlowable = Flowable.range(1, 10).map(data -> 2 * data);
        mapFlowable.subscribe(new ConsoleSubscribe());
    }

    @Test
    public void generateFlowable2() {
        Flowable<Integer> mapFlowable = Flowable.range(1, 4).flatMap(data -> Flowable.range(1, data));
        mapFlowable.subscribe(new ConsoleSubscribe());
    }


}
