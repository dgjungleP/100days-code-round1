package day03;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.Test;

public class ScheduleTest {

    @Test
    public void testSchedule() {
        Flowable<Integer> flowable = Flowable.range(0, 10);

        Disposable subscribe = flowable
                .subscribe(data -> System.out
                        .println("Thread:【" + Thread.currentThread().getName() + "】 消费了 data【" + data + "】"));

    }

    @Test
    public void testScheduleIo() {
        Flowable<Integer> flowable = Flowable.range(0, 10);
        flowable = flowable
                .subscribeOn(Schedulers.io());
        Disposable subscribe = flowable
                .subscribe(data -> System.out
                        .println("Thread:【" + Thread.currentThread().getName() + "】 消费了 data【" + data + "】"));
    }

    @Test
    public void testScheduleComputation() {
        Flowable<Integer> flowable = Flowable.range(0, 10);
        flowable = flowable
                .subscribeOn(Schedulers.computation());
        Disposable subscribe = flowable
                .subscribe(data -> System.out
                        .println("Thread:【" + Thread.currentThread().getName() + "】 消费了 data【" + data + "】"));
    }

    @Test
    public void testScheduleSingle() {
        Flowable<Integer> flowable = Flowable.range(0, 10);
        flowable = flowable
                .subscribeOn(Schedulers.single());
        Disposable subscribe = flowable
                .subscribe(data -> System.out
                        .println("Thread:【" + Thread.currentThread().getName() + "】 消费了 data【" + data + "】"));
    }

    @Test
    public void testScheduleTrampoline() {
        Flowable<Integer> flowable = Flowable.range(0, 10);
        flowable = flowable
                .subscribeOn(Schedulers.trampoline());
        Disposable subscribe = flowable
                .subscribe(data -> System.out
                        .println("Thread:【" + Thread.currentThread().getName() + "】 消费了 data【" + data + "】"));
    }

    @Test
    public void testScheduleNewThread() {
        Flowable<Integer> flowable = Flowable.range(0, 10);
        flowable = flowable
                .subscribeOn(Schedulers.newThread());
        Disposable subscribe = flowable
                .subscribe(data -> System.out
                        .println("Thread:【" + Thread.currentThread().getName() + "】 消费了 data【" + data + "】"));
    }
}
