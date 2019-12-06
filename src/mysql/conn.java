package mysql;

import java.sql.ResultSet;

public interface conn {
	void insertData(String sql);

	void delData();

	void updateData(String sql);

	ResultSet selectData(String sql);

	void close();
}
