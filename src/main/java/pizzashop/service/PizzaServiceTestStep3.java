package pizzashop.service;

import org.junit.jupiter.api.Test;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.PaymentRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doAnswer;

public class PizzaServiceTestStep3 {
    @Test
    public void step3_mockGetAll() {
        final PaymentRepository paymentRepository = mock(PaymentRepository.class);
        final PizzaService pizzaService = mock(PizzaService.class);

        when(paymentRepository.getAll()).thenReturn(Arrays.asList(new Payment(1, PaymentType.Card, 12.),
                new Payment(2, PaymentType.Cash, 200.), new Payment(3, PaymentType.Card, 40.)));

        when(pizzaService.getPayments()).thenAnswer(answer -> paymentRepository.getAll());

        final List<Payment> paymentList = pizzaService.getPayments();

        assertEquals(3, paymentList.size());

        assertEquals(1, paymentList.get(0).getTableNumber());
        assertEquals(PaymentType.Card, paymentList.get(0).getType());
        assertEquals(12., paymentList.get(0).getAmount());

        assertEquals(2, paymentList.get(1).getTableNumber());
        assertEquals(PaymentType.Cash, paymentList.get(1).getType());
        assertEquals(200., paymentList.get(1).getAmount());

        assertEquals(3, paymentList.get(2).getTableNumber());
        assertEquals(PaymentType.Card, paymentList.get(2).getType());
        assertEquals(40., paymentList.get(2).getAmount());
    }

    @Test
    public void step3_clearList() {
        final PaymentRepository paymentRepository = mock(PaymentRepository.class);
        final PizzaService pizzaService = mock(PizzaService.class);

        doNothing().when(paymentRepository).clear();

        doAnswer(invocationOnMock -> {
            paymentRepository.clear();
            return null;
        }).when(pizzaService).clear();

        final List<Payment> paymentList = pizzaService.getPayments();

        assertEquals(0, paymentList.size());
    }
}
