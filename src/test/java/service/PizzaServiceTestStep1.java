package service;

import org.junit.jupiter.api.Test;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.service.PizzaService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PizzaServiceTestStep1 {

    @Test
    public void step_1testGetPayments() {
        final PizzaService pizzaService = mock(PizzaService.class);

        when(pizzaService.getPayments()).thenReturn(Arrays.asList(new Payment(1, PaymentType.Card, 12.),
                new Payment(2, PaymentType.Cash, 200.), new Payment(3, PaymentType.Card, 40.)));

        assertEquals(3, pizzaService.getPayments().size());
    }

    @Test
    public void step_1_addValidPayment() {
        final int table = 1;
        final PaymentType paymentType = PaymentType.Card;
        final double amount = 100.;

        final PizzaService pizzaService = mock(PizzaService.class);

        doAnswer(invocationOnMock -> {
            assertEquals(1, table);
            assertEquals(paymentType, PaymentType.Card);
            assertEquals(100., amount);

            return null;
        }).when(pizzaService).addPayment(table, paymentType, amount);

        pizzaService.addPayment(table, paymentType, amount);

        verify(pizzaService, times(1))
                .addPayment(table, paymentType, amount);
    }
}
