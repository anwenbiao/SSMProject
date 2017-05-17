package com.yan.pagination;

public class OracleDialect extends Dialect {

	@Override
	public String getLimitString(String sql, int pageIndex, int pageSize) {
	    sql = sql.trim();
	    StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

	    int start=(pageIndex-1)*pageSize;//起始条数
	    int end=pageIndex*pageSize;//结束条数
	    pagingSelect.append("select * from ( select row_.*,rownum rownum_ from ( ");
	    pagingSelect.append(sql);
	    pagingSelect.append(" ) row_ ) where rownum_ > ").append(start).append(" and rownum_ <= ").append(end);

	    return pagingSelect.toString();
	}

}
