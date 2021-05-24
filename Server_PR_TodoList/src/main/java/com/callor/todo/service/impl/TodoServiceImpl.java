package com.callor.todo.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.todo.config.DBConnection;
import com.callor.todo.config.DBInfo;
import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

public class TodoServiceImpl implements TodoService{

	protected Connection dbConn;
	
	public TodoServiceImpl() {
		// TODO Auto-generated constructor stub
		dbConn = DBConnection.getDBConnection();
	}
	
	private List<TodoVO> select(PreparedStatement pStr) throws SQLException{
		
		List<TodoVO> tdList = new ArrayList<TodoVO>();
		
			ResultSet rSet = pStr.executeQuery();
			while(rSet.next()) {
				TodoVO tdVO = new TodoVO();
				tdVO.setTd_seq(rSet.getLong(DBInfo.td_seq));
				tdVO.setTd_work(rSet.getString(DBInfo.td_work));
				tdVO.setTd_date(rSet.getString(DBInfo.td_date));
				tdVO.setTd_space(rSet.getString(DBInfo.td_space));
				tdList.add(tdVO);
			}
			return tdList;
		
	}
	
	@Override
	public List<TodoVO> selectAll() {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM view_todo ";
		
		PreparedStatement pStr = null;
		
		List<TodoVO> tdList;
		try {
			pStr = dbConn.prepareStatement(sql);
			tdList = this.select(pStr);
			pStr.close();
			
			return tdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public TodoVO findById(Long td_seq) {
		// TODO Auto-generated method stub
		
		String sql = " SELECT * FROM tbl_list ";
		sql += " WHERE td_seq = ? ";
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, td_seq);
			
			List<TodoVO> tdList = this.select(pStr);
			pStr.close();
			if (tdList != null && tdList.size() > 0) {
				return tdList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<TodoVO> findBywork(String td_work) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TodoVO> findBySpace(String td_space) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(TodoVO todoVO) {
		// TODO Auto-generated method stub
		String sql = " INSERT INTO tbl_List ";
		sql += "(td_seq, td_work, td_date, td_space)";
		sql += "VALUES( SEQ_TODO.NEXTVAL, ?, ?, ?) ";
		
		PreparedStatement pStr = null;
		try {
			pStr.setString(1,todoVO.getTd_work());
			pStr.setString(2, todoVO.getTd_date());
			pStr.setString(3, todoVO.getTd_space());
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Integer update(TodoVO todoVO) {
		// TODO Auto-generated method stub
		String sql = " UPDATE tbl_List SET ";
		sql += "td_work = ? ";
		sql += "td_date = ? ";
		sql += "td_space = ? ";
		
		sql += " WHERE td_seq = ?";
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1,todoVO.getTd_work());
			pStr.setString(2, todoVO.getTd_date());
			pStr.setString(3, todoVO.getTd_space());
			pStr.setLong(4, todoVO.getTd_seq());
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer delete(Long td_seq) {
		// TODO Auto-generated method stub
		String sql = " DELETE FROM tbl_List ";
		sql += " WHERE td_seq = ? ";
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, td_seq);
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
	