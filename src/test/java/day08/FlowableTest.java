package day08;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import subscribe.ConsoleSubscribe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlowableTest {


    @Test
    public void generateFlowable() {
        Flowable<Integer> rangeFlowable = Flowable.range(1, 10);
        Flowable<List<Integer>> bufferFlowable = rangeFlowable.buffer(5, 1);
        bufferFlowable.subscribe(new ConsoleSubscribe());
    }

    @Test
    public void generateFlowable2() {
        Flowable<Integer> rangeFlowable = Flowable.range(1, 10).map(data -> {
            TimeUnit.MILLISECONDS.sleep(200);
            return data;
        }).subscribeOn(Schedulers.io());
        Flowable<List<Integer>> bufferFlowable = rangeFlowable.buffer(500, TimeUnit.MILLISECONDS);
        bufferFlowable.subscribe(new ConsoleSubscribe());
        while (true) {
        }
    }


}
