package service;

import org.junit.jupiter.api.Test;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;
import pizzashop.service.PizzaService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaServiceTest {
    @Test
    void nullAmount() {
        PizzaService localPizzaService = new PizzaService(null, null);

        try {
            localPizzaService.getTotalAmount(PaymentType.Cash);
            assert false;
        } catch (NullPointerException e) {
            assert true;
        }
    }

    @Test
    void size0() {
        PizzaService localPizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
        localPizzaService.clear();

        assertEquals(0, localPizzaService.getTotalAmount(PaymentType.Cash));
    }

    @Test
    void size1() {
        PizzaService localPizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
        localPizzaService.clear();

        localPizzaService.addPayment(1, PaymentType.Cash, 10);

        assertEquals(10, localPizzaService.getTotalAmount(PaymentType.Cash));
    }

    @Test
    void size2() {
        PizzaService localPizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
        localPizzaService.clear();

        localPizzaService.addPayment(1, PaymentType.Card, 10);
        localPizzaService.addPayment(2, PaymentType.Cash, 10);

        assertEquals(10, localPizzaService.getTotalAmount(PaymentType.Card));
    }
}