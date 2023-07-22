package srp2;

import srp2.model.Order;

public class Main {
    public static void main(String[] args) {
        ConsoleViewer consoleViewer = new ConsoleViewer();
        Order order = consoleViewer.inputFromConsole();
        Saver jsonPersister = new JsonPersister(order);
        jsonPersister.save();
        Saver txtPersister = new TxtSaver();
        txtPersister.save();

        
    }
}
