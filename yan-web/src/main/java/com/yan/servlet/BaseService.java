package com.yan.servlet;

import java.util.List;

public interface BaseService<T> {

	public List<T> selectList(Object obj);
	
	public T select(String...strings);
	
	public void insert(T t);
	
	public void updata(T t);
	
	public List<T> queryAll();
	
	public int queryByCount(Object t);
	
}