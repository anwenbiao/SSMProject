package com.yan.pagination;

import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;



/**
 * Title:鍒嗛〉鎷︽埅鍣�
 */
@Intercepts({@org.apache.ibatis.plugin.Signature(type=StatementHandler.class, method="prepare", args={java.sql.Connection.class})})
public class PaginationInterceptor implements Interceptor {
	
	  private static final Logger logger = Logger.getLogger(PaginationInterceptor.class);
		private Log log = LogFactory.getLog(getClass());
	  

	public Object intercept(Invocation invocation)throws Throwable{
	    StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
	    MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,new DefaultObjectFactory(),new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
	    RowBounds rowBounds = (RowBounds)metaStatementHandler.getValue("delegate.rowBounds");
	    if ((rowBounds == null) || (rowBounds == RowBounds.DEFAULT)){
	      return invocation.proceed();
	    }

	    String originalSql = (String)metaStatementHandler.getValue("delegate.boundSql.sql");

	    ResourceBundle delegate = ResourceBundle.getBundle("commonutils");;

	    Dialect.Type databaseType = null;
	    try{
	      databaseType = Dialect.Type.valueOf(delegate.getString("dialect").toUpperCase());
	    }catch (Exception e){
	    	logger.debug(e);
	    }

	    if (databaseType == null){
	      throw new RuntimeException("the value of the dialect property in configuration.xml is not defined : " + delegate.getString("dialect"));
	    }
	    
	    Object dialect = null;
	    switch (databaseType)
	    {
	    case ORACLE:
	      dialect = new OracleDialect();
	      break;
	    case DB2:
	      dialect = new DB2Dialect();
	      break;
	    case MYSQL:
	      dialect = new MysqlDialect();
	      break;
	    case MSSQL58:
	      dialect = new Mssql58Dialect();
	      break;
	    case MSSQL12:
	      dialect = new Mssql12Dialect();
	    }

	    metaStatementHandler.setValue("delegate.boundSql.sql", ((Dialect)dialect).getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit()));
	    metaStatementHandler.setValue("delegate.rowBounds.offset",Integer.valueOf(0));
	    metaStatementHandler.setValue("delegate.rowBounds.limit", Integer.valueOf(2147483647));
	    BoundSql boundSql = statementHandler.getBoundSql();
	    log.debug("鐢熸垚鍒嗛〉SQL : " + boundSql.getSql());
	    return invocation.proceed();
	  }

	
	public Object plugin(Object target) {
		  return Plugin.wrap(target, this);
	  }

	
	public void setProperties(Properties arg0){
		  
	  }
}
