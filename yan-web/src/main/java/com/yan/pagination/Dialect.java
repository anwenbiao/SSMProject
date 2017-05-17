package com.yan.pagination;
public abstract class Dialect {

	  public abstract String getLimitString(String sql, int pageIndex, int pageSize);

	  public static enum Type
	  {
	    MYSQL, ORACLE, DB2, MSSQL58, MSSQL12;
	  }
}
