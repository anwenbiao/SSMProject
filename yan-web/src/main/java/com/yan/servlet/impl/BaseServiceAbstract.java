package com.yan.servlet.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.yan.dao.BaseDao;

public abstract class BaseServiceAbstract<T> {

	public abstract BaseDao<T> getDao();
	
	public List<T> selectList(Object obj){
		return getDao().selectList(obj);
	}
	
	public T select(String...strings){
		return getDao().select(strings);
	}
	
	public void insert(T t){
		getDao().insert(t);
	}
	
	public void updata(T t){
		getDao().updata(t);
	}
	
	public List<T> queryAll(){
		return  getDao().queryAll();
	}
	
	public int queryByCount(Object t){
		return getDao().queryByCount(t);
	}
	
	public List<T> queryByPage(RowBounds row){
		return getDao().queryByPage(row);
	}
}
