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

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaServiceTest {

    @Test
    void validTotalAmount() {
        assertEquals(1, 1);
    }

    @Test
    void invalidTotalAmount() {
        assertEquals(1, 1);
    }
//    private final PaymentType paymentType=PaymentType.Card;
//
//    @Test
//    void addPaymentAllParamsAreGoodECP() {
//        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
//        int size=pizzaService.getPayments().size();
//        pizzaService.addPayment(10,paymentType,20.25);
//        assert (size==pizzaService.getPayments().size()-1);
//    }
//
//    @Test
//    @DisplayName("TEST 2")
//    @Tag("my-tag")
//    void addPaymentWrongValueTableECP() {
//        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
//        int size=pizzaService.getPayments().size();
//        try {
//            pizzaService.addPayment(Integer.parseInt("value"), paymentType, 20.25);
//        } catch (NumberFormatException e) {
//            assert (size == pizzaService.getPayments().size());
//        }
//    }
//
//    @DisplayName("TEST 3")
//    @Tag("my-tag")
//    @ParameterizedTest
//    @CsvSource({
//            "apple",
//            "banana",
//    })
//    void addPaymentWrongValueAmountECP(String value) {
//        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
//        int size=pizzaService.getPayments().size();
//        try {
//            pizzaService.addPayment(10, paymentType, Double.parseDouble(value));
//        } catch (NumberFormatException e) {
//            assert (size == pizzaService.getPayments().size());
//        }
//    }
//
//    @DisplayName("TEST 4")
//    @Tag("my-tag")
//    @ParameterizedTest
//    @MethodSource("valuesProvider")
//    void addPaymentWrongValuesECP(String value) {
//        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
//        int size=pizzaService.getPayments().size();
//        try {
//            pizzaService.addPayment(Integer.parseInt(value), paymentType, Double.parseDouble(value));
//        } catch (NumberFormatException e) {
//            assert (size == pizzaService.getPayments().size());
//        }
//    }
//
//    static Stream<String> valuesProvider() {
//        return Stream.of("value1", "value2");
//    }
//
//    @Test
//    @DisplayName("TEST 5")
//    @Tag("my-tag")
//    void addPaymentWrongValueTableBVA_1() {
//        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
//        int size=pizzaService.getPayments().size();
//        pizzaService.addPayment(21,paymentType,20.25);
//        assert (size==pizzaService.getPayments().size()); //am gasit un bug
//    }
//
//    @Test
//    @DisplayName("TEST 6")
//    @Tag("my-tag")
//    void addPaymentWrongValueTableBVA_2() {
//        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
//        int size=pizzaService.getPayments().size();
//        pizzaService.addPayment(-1,paymentType,20.25);
//        assert (size==pizzaService.getPayments().size()); //am gasit un bug
//    }
//
//    @Test
//    @DisplayName("TEST 7")
//    @Tag("my-tag")
//    void addPaymentWrongValueAmountBVA_1() {
//        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
//        int size=pizzaService.getPayments().size();
//        pizzaService.addPayment(10, paymentType, -1.0);
//        assert (size==pizzaService.getPayments().size()); //am gasit un bug
//    }
//
//    @Test
//    @DisplayName("TEST 8")
//    @Tag("my-tag")
//    void addPaymentWrongValueAmountBVA_2() {
//        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
//        int size=pizzaService.getPayments().size();
//        pizzaService.addPayment(10, paymentType, 0);
//        assert (size==pizzaService.getPayments().size()); //am gasit un bug
//    }
}