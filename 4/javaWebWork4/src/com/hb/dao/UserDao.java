/**
 * 
 */
package com.hb.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hb.bean.User;
import com.hb.util.DBUtil;

/**
 * @author Administratord
 *
 */
public class UserDao {
	public List<User> queryAll() throws Exception {
		 Connection conn = DBUtil.connectDB();
		 String sql = "SELECT * FROM user_table";
		 List<User> userList = new ArrayList<User>();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		 while(rs.next()) {
			User user = new User();	 
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPwd(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setPhone(rs.getString("phone"));
			user.setAddress(rs.getString("address"));
		
			userList.add(user);
		 }
		
		return userList;
	}
	
	public List<User> queryByParams(List<Map<String, Object>> params)  {
		 Connection conn = DBUtil.connectDB();
		 StringBuilder sql = new StringBuilder("SELECT * FROM user_table WHERE 1=1");
		
		 for(Map<String, Object> param : params) {
		 sql.append(" and ");
		 sql.append(" " + param.get("col") + " ");
		 sql.append(" " + param.get("rel") + " ");
		 sql.append(" \"" + param.get("value") + "\"");
		 }
		 System.out.println(sql.toString());
		
		 List<User> userList = new ArrayList<User>();
		
		Statement stmt;
		try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());
				while(rs.next()) {
					User user = new User();	 
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setPwd(rs.getString("password"));
					user.setEmail(rs.getString("email"));
					user.setPhone(rs.getString("phone"));
					user.setAddress(rs.getString("address"));
				
					userList.add(user);
				 }
				
				return userList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return userList;
	}
	public void addUser(User user) throws Exception {
		 Connection conn = DBUtil.connectDB();
		 String sql = "INSERT INTO user_table(name,password,email,phone,address) "
		 + " VALUES(?, ?, ?, ?,?)";
		
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, user.getName());
		 pstmt.setString(2, user.getPwd());
		 pstmt.setString(3, user.getEmail());
		 pstmt.setString(4, user.getPhone());
		 pstmt.setString(5, user.getAddress());
		
		 pstmt.execute();
		 }
	public void deleteUser(int id) throws Exception {
		 Connection conn = DBUtil.connectDB();
		 String sql = "DELETE FROM user_table WHERE id = ?";
		
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		 pstmt.setInt(1, id);
		
		 pstmt.execute();
		 }
	public void updateUser(User user) throws Exception {
		 Connection conn = DBUtil.connectDB();
		 String sql = "UPDATE user_table SET name=?, password=?, email=?,phone=?,address=?"
		 + " WHERE id=?";
		
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1, user.getName());
		 pstmt.setString(2, user.getPwd());
		 pstmt.setString(3, user.getEmail());
		 pstmt.setString(4, user.getPhone());
		 pstmt.setString(5, user.getAddress());
		 pstmt.setInt(6, user.getId());
		
		 pstmt.executeUpdate();
		
	}
}
