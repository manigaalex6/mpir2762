package service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;
import pizzashop.service.PizzaService;

import java.util.stream.Stream;

class PizzaServiceTest {
    private int table;
    private double amount;
    private final PaymentType paymentType=PaymentType.Card;
    private PizzaService pizzaService;
    @BeforeEach
    void setUp() {
        pizzaService=new PizzaService(new MenuRepository(), new PaymentRepository());
        table=10;
        amount=20.25;
    }

    @Test
    @DisplayName("TEST 1")
    @Tag("my-tag")
    void addPaymentAllParamsAreGoodECP() {
        int size=pizzaService.getPayments().size();
        pizzaService.addPayment(table,paymentType,amount);
        assert (size==pizzaService.getPayments().size()-1);
    }

    @Test
    @DisplayName("TEST 2")
    @Tag("my-tag")
    void addPaymentWrongValueTableECP() {
        int size=pizzaService.getPayments().size();
        try {
            pizzaService.addPayment(Integer.parseInt("value"), paymentType, amount);
        } catch (NumberFormatException e) {
            assert (size == pizzaService.getPayments().size());
        }
    }

    @DisplayName("TEST 3")
    @Tag("my-tag")
    @ParameterizedTest
    @CsvSource({
            "apple",
            "banana",
    })
    void addPaymentWrongValueAmountECP(String value) {
        int size=pizzaService.getPayments().size();
        try {
            pizzaService.addPayment(table, paymentType, Double.parseDouble(value));
        } catch (NumberFormatException e) {
            assert (size == pizzaService.getPayments().size());
        }
    }

    @DisplayName("TEST 4")
    @Tag("my-tag")
    @ParameterizedTest
    @MethodSource("valuesProvider")
    void addPaymentWrongValuesECP(String value) {
        int size=pizzaService.getPayments().size();
        try {
            pizzaService.addPayment(Integer.parseInt(value), paymentType, Double.parseDouble(value));
        } catch (NumberFormatException e) {
            assert (size == pizzaService.getPayments().size());
        }
    }

    static Stream<String> valuesProvider() {
        return Stream.of("value1", "value2");
    }

    @Test
    @DisplayName("TEST 5")
    @Tag("my-tag")
    void addPaymentWrongValueTableBVA_1() {
        int size=pizzaService.getPayments().size();
        pizzaService.addPayment(21,paymentType,amount);
        assert (size==pizzaService.getPayments().size()); //am gasit un bug
    }

    @Test
    @DisplayName("TEST 6")
    @Tag("my-tag")
    void addPaymentWrongValueTableBVA_2() {
        int size=pizzaService.getPayments().size();
        pizzaService.addPayment(-1,paymentType,amount);
        assert (size==pizzaService.getPayments().size()); //am gasit un bug
    }

    @Test
    @DisplayName("TEST 7")
    @Tag("my-tag")
    void addPaymentWrongValueAmountBVA_1() {
        int size=pizzaService.getPayments().size();
        pizzaService.addPayment(table, paymentType, -1.0);
        assert (size==pizzaService.getPayments().size()); //am gasit un bug
    }

    @Test
    @DisplayName("TEST 8")
    @Tag("my-tag")
    void addPaymentWrongValueAmountBVA_2() {
        int size=pizzaService.getPayments().size();
        pizzaService.addPayment(table, paymentType, 0);
        assert (size==pizzaService.getPayments().size()); //am gasit un bug
    }
}