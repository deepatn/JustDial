package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class BaseData 
{
	public static String fetchData(String sheet, int row, int cell1) throws EncryptedDocumentException, IOException
	{
		FileInputStream fin = new FileInputStream("./Excel/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fin);
		String cell = book.getSheet(sheet).getRow(row).getCell(cell1).toString();
		return cell;
	}
}
