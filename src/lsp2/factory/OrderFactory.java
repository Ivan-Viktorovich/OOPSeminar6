package lsp2.factory;

import lsp2.model.Order;
import lsp2.model.OrderBonus;
import lsp2.util.Orderable;

public class OrderFactory {
    public Orderable create(int quantity, int price, boolean isBonus) {
        if (isBonus) {
            return new OrderBonus(quantity, price);
        }
        return new Order(quantity, price);
    }
}
