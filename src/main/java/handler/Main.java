package handler;

public class Main {
    public static void main(String[] args) {
        ExcelPdfAdapter adapter = new ExcelPdfAdapter("./data/order.xlsx");
        adapter.start();
    }
}
