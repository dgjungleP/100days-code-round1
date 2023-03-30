package day01;


import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import org.junit.jupiter.api.Test;

public class FlowableTest {


    @Test
    public void createFlowable() {
        Flowable<Integer> flowable = Flowable.just(1);
        Disposable subscribe = flowable.subscribe(System.out::println);
    }
}
