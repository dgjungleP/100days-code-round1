package day19;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

@SpringBootTest
@SpringBootConfiguration
public class SpringSPITest {

    @Test
    @DisplayName("测试SpringFactoryLoader LoadName")
    public void contextLoadName() {
        List<String> strings = SpringFactoriesLoader.loadFactoryNames(ApplicationContextInitializer.class, Thread.currentThread()
                .getContextClassLoader());
        strings.forEach(System.out::println);
    }

    @Test
    @DisplayName("测试SpringFactoryLoader")
    public void contextLoad() {
        List<ApplicationContextInitializer> initializers = SpringFactoriesLoader.loadFactories(ApplicationContextInitializer.class, Thread.currentThread()
                .getContextClassLoader());
        initializers.forEach(System.out::println);
    }
}
