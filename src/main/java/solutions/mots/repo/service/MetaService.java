package solutions.mots.repo.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.text.CaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import solutions.mots.repo.pojo.ColumnData;
import solutions.mots.repo.pojo.MetaData;
import solutions.mots.repo.pojo.TableData;
import solutions.mots.repo.repository.ConnectionRepository;

@Service
public class MetaService {

	@Autowired
	ConnectionRepository repository;

	public MetaData getData() throws Exception {
		MetaData data = new MetaData();
		Connection con = repository.getConnection();
		DatabaseMetaData metaData = con.getMetaData();
		List<TableData> tableList = getTables(metaData);
		data.setTableList(tableList);
		return data;
	}
	
	private List<TableData> getTables(DatabaseMetaData metaData) throws Exception {
		String[] types = { "TABLE" };
		ResultSet rs = metaData.getTables(null, null, "%", types);
		List<TableData> tables = new ArrayList<TableData>();
		String db = "";
		while (rs.next()) {
			String tableName = rs.getString("TABLE_NAME");
			List<ColumnData> columnList = getColumns(metaData, tableName);
			TableData table = new TableData();
			table.setEntity(tableName);
			table.setLabel(CaseUtils.toCamelCase(tableName, true, null));
			table.setDescription(tableName.toLowerCase());
			table.setGroup("default");
			table.setColumns(columnList);
			tables.add(table);
			
		}
		Collections.reverse(tables);
		return tables;
	}

	private List<ColumnData> getColumns(DatabaseMetaData metaData, String tableName) throws Exception {
		ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, tableName);
		String primaryKey = null;
		while (primaryKeys.next()) {
			primaryKey = primaryKeys.getString("COLUMN_NAME");
		}
		ResultSet rs = metaData.getColumns(null, null, tableName, null);
		List<ColumnData> columns = new ArrayList<ColumnData>();
		while (rs.next()) {
			ColumnData column = new ColumnData();
			column.setName(rs.getString("COLUMN_NAME"));
			column.setType(rs.getString("DATA_TYPE"));
			columns.add(column);
		}
		return columns;
	}

}
