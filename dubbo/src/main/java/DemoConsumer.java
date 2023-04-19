import com.jungle.dubbo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

public class DemoConsumer {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/dubbo-consumer.xml");

        context.start();
        DemoService service = (DemoService) context.getBean("demoService");
        String hello = service.sayHello("Jungle");
        System.out.println("hello = " + hello);
    }
}