package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String [][]  excelRead(String eFileName) throws IOException {
		
		XSSFWorkbook  wrkBk = new XSSFWorkbook("./data/"+ eFileName +".xlsx");
		XSSFSheet wrkSht = wrkBk.getSheet("Sheet1");
		int rowCount = wrkSht.getLastRowNum();
		int cellCount = wrkSht.getRow(1).getLastCellNum();
		
		String [] [] data = new String[rowCount][cellCount];
		// i=1 since 1st row is header info which we don't need to extract
		
			for (int i = 1; i <= rowCount; i++) {
			
				for (int j = 0; j < cellCount; j++) {
				
					String values = wrkSht.getRow(i).getCell(j).getStringCellValue();
					System.out.println("values: " +values);
					data[i-1][j] = values;  // to get 1st row value data[0][0]				
				}
			}

		
		wrkBk.close();
		return data;	
		
	}

}
