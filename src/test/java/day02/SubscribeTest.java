package day02;

import io.reactivex.rxjava3.core.Flowable;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class SubscribeTest {


    @Test
    public void testSubscribe() {
        Flowable<Integer> flowable = Flowable.just(1, 2, 3, 4, 5, 6);
        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(1);
            }

            @Override
            public void onNext(Integer o) {
                System.out.println(o);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
        flowable.subscribe(subscriber);
    }
}
