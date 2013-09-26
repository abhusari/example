package test.pring.anupam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import test.pring.anupam.Circle;
@Component
public class TestDao {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	 
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Circle getCircle(int i) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver).newInstance();
		Circle circle = new Circle();
		circle.setId(i);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?" +
					"user=root&password=root");
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("Select * from circle where id =?");
			ps.setInt(1, i);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				circle.setName(rs.getString("name"));
				System.out.println(rs.getString("name"));
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return circle;
	}
	
	public Circle getSpringCircle(int i){
		Circle circle = new Circle();
		circle.setId(i);
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("Select * from circle where id =?");
			ps.setInt(1, i);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				circle.setName(rs.getString("name"));
				System.out.println(rs.getString("name"));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return circle;
	}
	
	public Circle getJDBCTemplateCircle(int i){
		Circle circle = new Circle();
		circle.setId(i);
		try {
			Connection conn = dataSource.getConnection();
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); 
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("Select * from circle where id =?");
			ps.setInt(1, i);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				circle.setName(rs.getString("name"));
				System.out.println(rs.getString("name"));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return circle;
	}
	
	public int getCircleCount(){
		String query = "select count(*) from circle";
	//	jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForInt(query);
	}
	
	public Circle getcircle(int id){
		String sql = "Select * from circle where id =?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CircleMapper());
	}
	
	public static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rs, int arg1) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			return circle;
		}
	} 
}
