package lsp1.view;

import lsp1.shape.Quadraliteral;

public class ShapeView {
    private final Quadraliteral quadraliteral;

    public ShapeView(Quadraliteral quadraliteral) {
        this.quadraliteral = quadraliteral;
    }

    public void showArea() {
        System.out.print("Area of rectangle equal:");
        System.out.println(quadraliteral.getArea());
    }
}
