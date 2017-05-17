package com.yan.pagination;

public class Mssql12Dialect extends Dialect {


	@Override
	public String getLimitString(String sql, int pageIndex, int pageSize) {
	    sql = sql.trim();

	    StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
	    pagingSelect.append(sql);
	    pagingSelect.append(" OFFSET ").append(pageIndex).append(" ROW FETCH NEXT ").append(pageSize).append(" ROWS ONLY ");

	    return pagingSelect.toString();
	}

}
