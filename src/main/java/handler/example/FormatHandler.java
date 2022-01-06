package handler.example;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Stream;

public class FormatHandler extends Handler {
    List<List<String>> list;
    @Override
    public void process(Object objectList) {
        try {
            list = (List<List<String>>) objectList;

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("./data/generated/Table.pdf"));

            document.open();

            PdfPTable table = new PdfPTable(list.get(0).size());
            addTableHeader(table);
            addRows(table);
            document.add(table);
            document.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void addTableHeader(PdfPTable table) {
        Stream.of(list.get(0).get(0),list.get(0).get(1),list.get(0).get(2),list.get(0).get(3))
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setPadding(2.5f);
                    header.setBorderWidth(1);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
        list.remove(0);
    }
    private void addRows(PdfPTable table) {
        for (List<String> list : list) {
            for (String item: list) {
                table.addCell(item);
            }
        }
    }
}
