package com.yan.pagination;

/**db2分页
 * @author Administrator
 *
 */
public class DB2Dialect extends Dialect {

	@Override
	public String getLimitString(String sql, int pageIndex, int pageSize) {
	    sql = sql.trim();
	    StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
	    pagingSelect.append("SELECT * FROM (SELECT PAGE_B.*, ROWNUMBER() OVER() AS RN FROM ( ");
	    pagingSelect.append(sql);
	    pagingSelect.append(" ) AS PAGE_B )AS PAGE_A WHERE PAGE_A.RN BETWEEN ").append(pageIndex).append(" AND ").append(pageIndex + pageSize - 1);

	    return pagingSelect.toString();
	}

}
