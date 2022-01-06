package handler;

public class ExcelPdfAdapter {

    private final String pathToExcel;

    public ExcelPdfAdapter(String pathToExcel) {
        this.pathToExcel = pathToExcel;
    }

    public void start() {
        Handler read = new ReadHandler();
        Handler format = new FormatHandler();
        read.setNext(format);
        read.process(pathToExcel);
    }
}
