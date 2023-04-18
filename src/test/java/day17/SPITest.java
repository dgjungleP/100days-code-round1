package day17;

import com.jungle.challenge.spi.core.PeopleFactory;
import org.junit.jupiter.api.Test;

public class SPITest {

    @Test
    public void test1() {
        new PeopleFactory().invoker();
    }
}
