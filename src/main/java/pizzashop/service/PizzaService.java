package pizzashop.service;

import org.junit.jupiter.api.Test;
import pizzashop.model.MenuDataModel;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import java.util.List;

public class PizzaService {

    private MenuRepository menuRepo;
    private PaymentRepository payRepo;

    public PizzaService(MenuRepository menuRepo, PaymentRepository payRepo){
        this.menuRepo=menuRepo;
        this.payRepo=payRepo;
    }

    public List<MenuDataModel> getMenuData(){return menuRepo.getMenu();}

    public List<Payment> getPayments(){return payRepo.getAll(); }


    public void addPayment(int table, PaymentType type, double amount){
        if(amount>0.0 && (table>0 && table<21))
        {
            Payment payment= new Payment(table, type, amount);
            payRepo.add(payment);
        }

    }

    public void clear() {
        payRepo.clear();
    }

    public double getTotalAmount(PaymentType type) {
        double totalAmount = 0.0f;
        List<Payment> payments = getPayments();

        if (payments == null) {
            return totalAmount;
        }

        if (payments.size() == 0) {
            return totalAmount;
        }

        int index = 0;
        while(index < payments.size()) {
            if (payments.get(index).getType().equals(type)) {
                totalAmount += payments.get(index).getAmount();
            }
            ++index;
        }
        return totalAmount;
    }
}