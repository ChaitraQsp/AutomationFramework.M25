package swagLabs.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to Excel file
 * @author Chaitra M
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel file by taking sheet name, row no and
	 * cell no from caller and return value
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName, int rowNo, int celNo) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNo);
		Cell cl = rw.getCell(celNo);
		String value = cl.getStringCellValue();
		return value;
	}

}
