package pizzashop.repository;

import pizzashop.model.Payment;
import pizzashop.model.PaymentType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PaymentRepository {
    private static final String filename = "data/payments.txt";
    private final List<Payment> paymentList;

    public PaymentRepository() {
        this.paymentList = new ArrayList<>();
        readPayments();
    }

    private void readPayments() {
        ClassLoader classLoader = PaymentRepository.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                Payment payment = getPayment(line);
                paymentList.add(payment);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Payment getPayment(String line) {
        Payment payment = null;
        if (line == null || line.equals("")) return null;
        StringTokenizer st = new StringTokenizer(line, ",");
        int tableNumber = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        double amount = Double.parseDouble(st.nextToken());
        payment = new Payment(tableNumber, PaymentType.valueOf(type), amount);
        return payment;
    }

    public void add(Payment payment) {
        paymentList.add(payment);
        writeAll();
    }

    public void clear() {
        paymentList.clear();
        writeAll();
    }

    public List<Payment> getAll() {
        return paymentList;
    }

    public void writeAll() {
        ClassLoader classLoader = PaymentRepository.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            for (Payment p : paymentList) {
                bw.write(p.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}