package lsp2.model;

import lsp2.util.Orderable;

public class OrderBonus extends Orderable{

    public OrderBonus(int quantity, int price) {
        super(quantity, price);
    }

    @Override
    public double getAmount() {
        return 0;
    }
}
