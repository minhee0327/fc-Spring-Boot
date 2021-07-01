import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DollarCaculatorTest {

    //Mock 처리할 것이라고 명시. (market api를 mocking 처리)
    @Mock
    public MarketApi marketApi;

    //test 가 실행되기 이전에.
    @BeforeEach
    public void init(){
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void testHello(){
        System.out.println("hello");
    }

    @Test
    public void dollarTest(){
        MarketApi marketApi = new MarketApi();
        DollarCaculator dollarCaculator = new DollarCaculator(marketApi);
        dollarCaculator.init();

        Calculator calculator = new Calculator(dollarCaculator);
        System.out.println(calculator.sum(10, 10));

        //system.out.println 대신에 Assertions.assertEquals 를 찍어본다.
        Assertions.assertEquals(22000, calculator.sum(10, 10));
        Assertions.assertEquals(0, calculator.minus(10, 10));
    }

    @Test
    public void mockTest(){
        DollarCaculator dollarCaculator = new DollarCaculator(marketApi);
        dollarCaculator.init();

        Calculator calculator = new Calculator(dollarCaculator);
        Assertions.assertEquals(60000, calculator.sum(10, 10));
        Assertions.assertEquals(0, calculator.minus(10, 10));
    }
}
