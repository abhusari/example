package test.pring.anupam.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DaoSupport extends JdbcDaoSupport{
	
	public int getCircleCount(){
		String query = "select count(*) from circle";
		
		query = "select nt_zone_id from nt_zone where zone ='samar.com' and deleted = 0";
	//	jdbcTemplate = new JdbcTemplate(dataSource);
		return getJdbcTemplate().queryForInt(query);
	}

}
