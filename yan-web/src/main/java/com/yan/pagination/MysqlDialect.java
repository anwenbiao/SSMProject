package com.yan.pagination;

public class MysqlDialect extends Dialect {

	@Override
	public String getLimitString(String sql, int pageIndex, int pageSize) {
		   sql = sql.trim();
		   StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		   pagingSelect.append(sql);
		   pagingSelect.append(" limit ").append((pageIndex - 1)*pageSize).append(" , ").append(pageSize);

		   return pagingSelect.toString();
	}

}
