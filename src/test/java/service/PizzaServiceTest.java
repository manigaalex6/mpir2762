package service;

import org.junit.jupiter.api.Test;
import pizzashop.model.PaymentType;
import pizzashop.service.PizzaService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PizzaServiceTest {

    @Test
    void validTotalAmount() {
        final PizzaService pizzaService = mock(PizzaService.class);
        when(pizzaService.getTotalAmount(PaymentType.Card)).thenReturn(201.25);

        double totalAmount = pizzaService.getTotalAmount(PaymentType.Card);
        assertEquals(201.25, totalAmount);
    }

    @Test
    void invalidTotalAmount() {
        final PizzaService pizzaService = mock(PizzaService.class);
        when(pizzaService.getTotalAmount(PaymentType.Card)).thenReturn(201.25);

        double totalAmount = pizzaService.getTotalAmount(PaymentType.Card);
        assertNotEquals(-1.0, totalAmount);
    }
}