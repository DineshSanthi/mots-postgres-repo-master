package solutions.mots.repo.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MetaData implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<TableData> tableList = new ArrayList();

	public List<TableData> getTableList() {
		return tableList;
	}

	public void setTableList(List<TableData> tableList) {
		this.tableList = tableList;
	}
	
}
