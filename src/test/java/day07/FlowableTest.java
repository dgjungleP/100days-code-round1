package day07;


import io.reactivex.rxjava3.core.Flowable;
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
        List<Publisher<Integer>> publisherList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            publisherList.add(getDelayFlowable(i, 1000));
        }
        Flowable<Integer> zipFlowable = Flowable
                .zip(publisherList, (dataList) -> Arrays.stream(dataList).mapToInt(data -> {
                    if (data instanceof Number) {
                        return ((Number) data).intValue();
                    } else {
                        return 0;
                    }
                }).sum());
        zipFlowable.subscribe(new ConsoleSubscribe());
    }

    private Flowable<Integer> getDelayFlowable(int i, Integer time) {
        return Flowable.just(i).map(data -> {
            TimeUnit.MILLISECONDS.sleep(time);
            return data;
        });
    }
}
