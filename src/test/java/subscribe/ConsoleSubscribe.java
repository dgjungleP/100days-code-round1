package subscribe;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.Instant;

public class ConsoleSubscribe implements Subscriber<Object> {
    private Long requestLimit;

    public ConsoleSubscribe() {
        this(Long.MAX_VALUE);
    }

    public ConsoleSubscribe(Long requestLimit) {
        this.requestLimit = requestLimit;
    }

    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("Thread:【" + Thread.currentThread().getName() + "】 在 " + Instant
                .now() + " 开启注册消费！");
        s.request(requestLimit);
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {
        System.out.println("Thread:【" + Thread.currentThread().getName() + "】 在 " + Instant
                .now() + " 完成了消费");
    }

    @Override
    public void onNext(Object data) {
        System.out.println("Thread:【" + Thread.currentThread().getName() + "】 在 " + Instant
                .now() + " 消费了 data【" + data + "】");

    }
}
