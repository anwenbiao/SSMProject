package com.yan.pagination;

public class Mssql58Dialect extends Dialect {

	@Override
	public String getLimitString(String sql, int pageIndex, int pageSize) {
	    sql = sql.trim();
	    String order = "";

	    StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
	    pagingSelect.append("select * from (select row_number()over(order by tempcolumn)temprownumber,* ").append(" from (select top ").append(pageIndex + pageSize - 1).append(" tempcolumn=0,* from ( ");

	    if (sql.toLowerCase().matches(".+order[^)]+$")){
	      order = sql.substring(sql.lastIndexOf("order"));
	      sql = sql.substring(0, sql.lastIndexOf("order"));
	    }

	    pagingSelect.append(sql);
	    pagingSelect.append(" ) d ").append(order).append(" ) t )tt where temprownumber>").append(pageIndex - 1);

	    return pagingSelect.toString();
	}

}
