package handler;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sklep.Money;
import sklep.Produkt;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadHandler extends Handler {

    @Override
    public void process(Object objectPath) {
        String path = (String)objectPath;

        List<Produkt> newData = new ArrayList<>();
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);

            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);

            for (Row row : sheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell = cellIterator.next();
                int id = (int)cell.getNumericCellValue();

                cell = cellIterator.next();
                String nazwa = cell.getStringCellValue();

                cell = cellIterator.next();
                String cenaString = String.valueOf(cell.getNumericCellValue());
                int intPart = Integer.parseInt(cenaString.split("\\.")[0]);
                int doublePart = Integer.parseInt(cenaString.split("\\.")[1]);
                Money cena = new Money(intPart, doublePart);
                cell = cellIterator.next();
                int quantity = (int)cell.getNumericCellValue();
                newData.add(new Produkt(id, nazwa, cena, quantity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        next(newData);
    }
}
