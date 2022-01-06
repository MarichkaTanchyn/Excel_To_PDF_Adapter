package handler;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import sklep.Money;
import sklep.Produkt;

import java.io.FileOutputStream;
import java.util.List;

public class FormatHandler extends Handler {
    List<Produkt> list;
    @Override
    public void process(Object objectList) {
        try {
            list = (List<Produkt>) objectList;

            Document document = new Document();
            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, BaseColor.BLACK);

            PdfWriter.getInstance(document, new FileOutputStream("./data/generated/Table.pdf"));

            document.open();

            Paragraph title = new Paragraph("Invoice", font);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100f);
            addTableHeader(table);
            addRows(table);
            document.add(table);

            Paragraph overallCost = new Paragraph("Overall Cost: " + calculateOverallCost(), font);
            overallCost.setAlignment(Element.ALIGN_RIGHT);

            document.add(overallCost);

            document.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void addTableHeader(PdfPTable table) {
        addCellTableHeader("Id", table);
        addCellTableHeader("Nazwa", table);
        addCellTableHeader("Cena", table);
        addCellTableHeader("Quantity", table);
    }

    private void addCellTableHeader(String columnTitle,PdfPTable table) {
        PdfPCell header = new PdfPCell();
        header.setPadding(2.5f);
        header.setBorderWidth(1);
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        header.setPhrase(new Phrase(columnTitle));
        table.addCell(header);
    }

    private void addRows(PdfPTable table) {
        for (Produkt produkt : list) {
            table.addCell(String.valueOf(produkt.getId()));
            table.addCell(produkt.getNazwa());
            table.addCell(produkt.getCena().toString());
            table.addCell(String.valueOf(produkt.getQuantity()));
        }
    }

    private Money calculateOverallCost() {
        Money overallCost = new Money(0, 0);
        for (Produkt produkt : list) {
             overallCost = overallCost.add(produkt.getCena().multiply(produkt.getQuantity()));
        }

        return overallCost;
    }
}
