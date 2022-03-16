package solutions.mots.repo.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TableData implements Serializable{

	private static final long serialVersionUID = 1L;

	private String entity;
	
	private String label;
	
	private String description;
	
	private String group;
	
	private List<ColumnData> columns = new ArrayList();
	
	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	public List<ColumnData> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnData> columns) {
		this.columns = columns;
	}
	
}
