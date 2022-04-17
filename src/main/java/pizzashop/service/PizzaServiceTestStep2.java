package pizzashop.service;

import org.junit.jupiter.api.Test;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class PizzaServiceTestStep2 {
    @Test
    public void step1_addPaymentWrongValues() {
        final int table = -1;
        final PaymentType paymentType = PaymentType.Cash;
        final double amount = -2.;

        final PizzaService pizzaService = mock(PizzaService.class);

        doNothing().when(pizzaService).addPayment(table, paymentType, amount);

        pizzaService.addPayment(table, paymentType, amount);

        verify(pizzaService, times(1))
                .addPayment(table, paymentType, amount);
    }

    @Test
    public void step_2mockPaymentAndUseGetTotalAmount() {
        final Payment payment = mock(Payment.class);
        when(payment.getTableNumber()).thenReturn(1);
        when(payment.getType()).thenReturn(PaymentType.Card);
        when(payment.getAmount()).thenReturn(100.);

        final PizzaService localPizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
        localPizzaService.clear();

        localPizzaService.addPayment(payment.getTableNumber(), payment.getType(), payment.getAmount());

        assertEquals(100., localPizzaService.getTotalAmount(PaymentType.Card));
    }

    @Test
    public void step2_mockPaymentAndTestGetPayments() {
        final Payment payment = mock(Payment.class);
        when(payment.getTableNumber()).thenReturn(1);
        when(payment.getType()).thenReturn(PaymentType.Card);
        when(payment.getAmount()).thenReturn(100.);

        final PizzaService localPizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());
        localPizzaService.clear();

        localPizzaService.addPayment(payment.getTableNumber(), payment.getType(), payment.getAmount());
        final List<Payment> paymentList = localPizzaService.getPayments();

        assertEquals(1, paymentList.size());

        assertEquals(1, paymentList.get(0).getTableNumber());
        assertEquals(PaymentType.Card, paymentList.get(0).getType());
        assertEquals(100., paymentList.get(0).getAmount());
    }
}
