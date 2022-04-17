package pizzashop.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PaymentRepositoryTest {
    @Mock
    final PaymentRepository paymentRepository = new PaymentRepository();

    @Test
    public void testGetAllPayments() {
        when(paymentRepository.getAll()).thenReturn(Arrays.asList(new Payment(1, PaymentType.Card, 12.),
                new Payment(2, PaymentType.Cash, 200.), new Payment(3, PaymentType.Card, 40.)));

        assertEquals(3, paymentRepository.getAll().size());
    }

    @Test
    public void testAddPayment() {
        final Payment payment = new Payment(1, PaymentType.Card, 100.);

        doAnswer(invocationOnMock -> {
            final Payment actualPayment = invocationOnMock.getArgument(0);

            final long tableNumber = actualPayment.getTableNumber();
            final PaymentType paymentType = actualPayment.getType();
            final Double amount = actualPayment.getAmount();

            assertEquals(1, tableNumber);
            assertEquals(paymentType, PaymentType.Card);
            assertEquals(100., amount);

            return null;
        }).when(paymentRepository).add(payment);

        paymentRepository.add(payment);

        verify(paymentRepository, times(1))
                .add(payment);
    }
}
