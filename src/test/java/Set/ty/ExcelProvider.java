package Set.ty;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelProvider {
    XSSFWorkbook wb;

    public ExcelProvider() throws IOException {
        File src = new File("./Test/data.xlsx");
        FileInputStream file = new FileInputStream(src);
        wb = new XSSFWorkbook(file);
    }

    public String getStringData(String shName, int row, int col) {
        // Get the row from the sheet
        XSSFRow xssfRow = wb.getSheet(shName).getRow(row);

        // Check if the row is null
        if (xssfRow == null) {
            return null; // Or throw an exception, depending on your requirement
        }

        // Get the cell at the specified column
        XSSFCell cell = xssfRow.getCell(col);

        // Check if the cell is null
        if (cell == null) {
            return null; // Or throw an exception, depending on your requirement
        }

        // Check if the cell contains a numeric value
        if (cell.getCellType() == CellType.NUMERIC) {
            // Convert the numeric value to a string
            return String.valueOf(cell.getNumericCellValue());
        } else {
            // If the cell contains a string, return the string value
            return cell.getStringCellValue();
        }
    }

    public double getNumericData(String shName, int row, int col) {
        // Return the numeric value directly
        return wb.getSheet(shName).getRow(row).getCell(col).getNumericCellValue();
    }
}
