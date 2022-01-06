package handler.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadHandler extends Handler {

    @Override
    public void process(Object objectPath) {
        String path = (String)objectPath;

        List<List<String>> newData = new ArrayList<>();
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);

            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);

            for (Row row : sheet) {
                List<String> tempData = new ArrayList<>();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellTypeEnum()) {
                        case STRING:
                            tempData.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            tempData.add(cell.getNumericCellValue() + "");
                            break;
                        default:
                    }
                }
                newData.add(tempData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        next(newData);
    }
}
