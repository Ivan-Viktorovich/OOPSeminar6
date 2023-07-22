package lsp1;

import lsp1.shape.Rectangle;
// import lsp1.shape.Quadraliteral;
// import lsp1.shape.Rectangle;
import lsp1.shape.Square;
import lsp1.view.ShapeView;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(5);
        System.out.printf("In a square side A = %d\n", square.getSide());
        ShapeView view = new ShapeView(square);
        view.showArea();
        Rectangle rectangle = new Rectangle(5, 3);
        System.out.printf("In a square side A = %d, B = %d\n", rectangle.getSideA(), rectangle.getSideB());
        ShapeView view2 = new ShapeView(rectangle);
        view2.showArea();
    }

}
