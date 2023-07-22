package dip1.model.util;

import java.util.List;

import dip1.model.ReportItem;
import dip1.model.Reportable;

public class ReportPrinter implements Reportable{
    public void output(List<ReportItem> items) {
        System.out.println("Output to printer");
        for (ReportItem item : items) {
            System.out.format("printer %s - %f \n\r", item.getDescription(), item.getAmount());
        }
    }
}
