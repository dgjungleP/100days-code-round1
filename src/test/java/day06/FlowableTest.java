package day06;


import io.reactivex.rxjava3.core.Flowable;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import subscribe.ConsoleSubscribe;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FlowableTest {


    @Test
    public void generateFlowable() {
        List<Publisher<Integer>> publisherList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            publisherList.add(Flowable.just(i).map(data -> {
                TimeUnit.MILLISECONDS.sleep(1000);
                return data;
            }));
        }
        Flowable<Integer> mergeFlowable = Flowable.merge(publisherList, 2,10);
        mergeFlowable.subscribe(new ConsoleSubscribe());

    }
}
