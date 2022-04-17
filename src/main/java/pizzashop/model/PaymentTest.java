package pizzashop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentTest {

    @Test
    public void testGetTableNumber() {
        final Payment payment = new Payment(23, PaymentType.Card, 122.);

        assertEquals(payment.getTableNumber(), 23);
    }

    @Test
    public void testSetAmount() {
        final Payment payment = new Payment(23, PaymentType.Card, 122.);

        payment.setAmount(125.22);

        assertEquals(payment.getAmount(), 125.22);
    }
}