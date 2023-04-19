import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

public class DemoProvider {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/dubbo-provider.xml");

        context.start();
        System.out.println("Provider service start");
        new CountDownLatch(1).await();
    }
}
