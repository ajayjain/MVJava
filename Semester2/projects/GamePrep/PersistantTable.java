// Ajay Jain
// 4 April 2013
// PersistantTable.java

import java.io.*;
import java.awt.*;
import javax.swing.*;

public abstract class PersistantTable extends JTable {
	private int maxSize = 50;
	private String columnFile = "data/PersistantTableColumns.ser";
	private String dataFile = "data/PersistantTableData.ser";

	private String[] columnNames = {"Key", "Value"};
	private Object[][] data;

	public PersistantTable() {
		super();
		setEditable(false);

		data = new Object[columnNames.length()][maxSize];
	}

	private void readData() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(columnFile));
			columnNames = (String[]) in.readObject();
			in.close();

			in = new ObjectInputStream(new FileInputStream(dataFile));
	        data = (Object[][]) in.readObject();
	        in.close();
		} catch (FileNotFoundException e) {
			System.out.println("[PersistantTable] Did not find file "+dataFile+" or "+columnFile+", creating file now.");
			
			initDataFiles();
		}
	}

	private void initDataFiles() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(columnFile));
			out.writeObject(columnNames);
	        out.flush();
	        out.close();

	        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(columnFile));
			out.writeObject(columnNames);
	        out.flush();
	        out.close();
		} catch (IOException e) {

		}
	}

	private void save() {

	}

	public void setColumnNames(String[] newNames) { columnNames = newNames; }
	public void setMaxSize(int newSize) { maxSize = newSize; }
}