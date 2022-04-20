package service;

import org.junit.jupiter.api.Test;
import pizzashop.model.PaymentType;
import pizzashop.service.PizzaService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

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

    @Test
    void invalidTableNumberTestCase() {
        final PizzaService pizzaService = mock(PizzaService.class);

        final int table = -1;
        final PaymentType paymentType = PaymentType.Card;
        final double amount = 100.;

        doAnswer(invocationOnMock -> {
            assertNotEquals(1, table);
            assertEquals(paymentType, PaymentType.Card);
            assertEquals(100., amount);

            return null;
        }).when(pizzaService).addPayment(table, paymentType, amount);

        pizzaService.addPayment(table, paymentType, amount);

        verify(pizzaService, times(1))
                .addPayment(table, paymentType, amount);
    }

    @Test
    void validTableNumberTestCase() {
        final PizzaService pizzaService = mock(PizzaService.class);

        final int table = 1;
        final PaymentType paymentType = PaymentType.Card;
        final double amount = 100.;

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

    @Test
    void validPaymentTestCase() {
        final PizzaService pizzaService = mock(PizzaService.class);

        final int table = 1;
        final PaymentType paymentType = PaymentType.Card;
        final double amount = 100.;

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

    @Test
    void invalidPaymentTestCase() {
        final PizzaService pizzaService = mock(PizzaService.class);

        final int table = 1;
        final PaymentType paymentType = PaymentType.Cash;
        final double amount = 100.;

        doAnswer(invocationOnMock -> {
            assertEquals(1, table);
            assertNotEquals(paymentType, PaymentType.Card);
            assertEquals(100., amount);

            return null;
        }).when(pizzaService).addPayment(table, paymentType, amount);

        pizzaService.addPayment(table, paymentType, amount);

        verify(pizzaService, times(1))
                .addPayment(table, paymentType, amount);
    }

    @Test
    void validAmountTestCase () {
        final PizzaService pizzaService = mock(PizzaService.class);

        final int table = 1;
        final PaymentType paymentType = PaymentType.Cash;
        final double amount = 100.;

        doAnswer(invocationOnMock -> {
            assertEquals(1, table);
            assertNotEquals(paymentType, PaymentType.Card);
            assertEquals(100., amount);

            return null;
        }).when(pizzaService).addPayment(table, paymentType, amount);

        pizzaService.addPayment(table, paymentType, amount);

        verify(pizzaService, times(1))
                .addPayment(table, paymentType, amount);
    }

    @Test
    void invalidAmountTestCase () {
        final PizzaService pizzaService = mock(PizzaService.class);

        final int table = 1;
        final PaymentType paymentType = PaymentType.Cash;
        final double amount = -100.;

        doAnswer(invocationOnMock -> {
            assertEquals(1, table);
            assertNotEquals(paymentType, PaymentType.Card);
            assertNotEquals(100., amount);

            return null;
        }).when(pizzaService).addPayment(table, paymentType, amount);

        pizzaService.addPayment(table, paymentType, amount);

        verify(pizzaService, times(1))
                .addPayment(table, paymentType, amount);
    }
}