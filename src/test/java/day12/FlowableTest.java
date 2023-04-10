package day12;


import io.reactivex.rxjava3.core.Flowable;
import org.junit.jupiter.api.Test;
import subscribe.ConsoleSubscribe;

import java.time.Instant;

public class FlowableTest {


    @Test
    public void generateFlowable() {
        Flowable<Integer> retryFlowable = Flowable.range(0, 10)
                .doOnEach(data -> System.out.println("Thread:【" + Thread.currentThread().getName() + "】 在 " + Instant
                        .now() + " 消费了 data【" + data.getValue() + "】"))
                .map(data -> 1000 / data).retry(3);
        retryFlowable.subscribe(new ConsoleSubscribe());
    }


}
