package com.callor.todo.service;

import java.util.List;
import com.callor.todo.model.TodoVO;

public interface TodoService {
	
	public List<TodoVO> selectAll();
	public TodoVO findById(Long td_seq);
	public List<TodoVO> findBywork(String td_work);
	public List<TodoVO> findBySpace(String td_space);
	
	public Integer insert(TodoVO todoVO);
	public Integer update(TodoVO todoVO);
	public Integer delete(Long td_seq);
	
	

}
