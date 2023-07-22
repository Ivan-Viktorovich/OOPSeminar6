package dip1.model.util;

import java.util.List;

import dip1.model.ReportItem;
import dip1.model.Reportable;

public class ConsolePrinter implements Reportable{
    public void output(List<ReportItem> items) {
        System.out.println("Output to console");
        for (ReportItem item : items) {
            System.err.format("console print %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }
}
