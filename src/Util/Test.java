package Util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//select_all();
		//select_name("oo");
		//select_count();
		addthing("wu", 1);
	}
	
	public static void trans(String name1,String name2,int thing){
		
	}
	
	
	public static void addthing(String name,int thing) {
		Connection con = null;
		try {
			con = new DBUtil().getCon();
			con.setAutoCommit(false);
			CallableStatement call = con.prepareCall("call addthing(?,?)");
			call.setString(1, name);
			call.setInt(2, thing);
			call.execute();
			con.commit();
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		
		
	}
	
	
	public static void subthing(String name,int thing){
		Connection con = null;
		try {
			con = new DBUtil().getCon();
			con.setAutoCommit(false);
			CallableStatement call = con.prepareCall("call subthing(?,?)");
			call.setString(1, name);
			call.setInt(2, thing);
			call.execute();
			con.commit();
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		
	}

	public static void addmoney(){
	
	}


	public static void submoney(){
		
	}
	
	
	
	
	
	public static void select_all()throws ClassNotFoundException, SQLException {
		Connection con =  new DBUtil().getCon();
		CallableStatement call = con.prepareCall("call sp_select_all");
		call.execute();
		ResultSet rs = call.getResultSet();
		List<Command> commandList = new ArrayList<Command>();
		while(rs.next()){
			Command command = new Command();
			command.setId(rs.getString("ID"));
			command.setDescription(rs.getString("description"));
			command.setName(rs.getString("name"));
			commandList.add(command);
		}
		System.out.println(commandList);
	}
	public static void select_name(String name)throws ClassNotFoundException, SQLException {
		Connection con =  new DBUtil().getCon();
		CallableStatement call = con.prepareCall("call sp_select_name(?)");
		call.setString(1, name);
		call.execute();
		ResultSet rs = call.getResultSet();
		List<Command> commandList = new ArrayList<Command>();
		while(rs.next()){
			Command command = new Command();
			command.setId(rs.getString("ID"));
			command.setDescription(rs.getString("description"));
			command.setName(rs.getString("name"));
			commandList.add(command);
		}
		System.out.println(commandList);
	}
	public static void select_count()throws ClassNotFoundException, SQLException {
		Connection con =  new DBUtil().getCon();
		CallableStatement call = con.prepareCall("call sp_count(?)");
		call.registerOutParameter(1, Types.INTEGER);
		call.execute();
		Integer count=call.getInt(1);
		System.out.println(count);
	}
}
