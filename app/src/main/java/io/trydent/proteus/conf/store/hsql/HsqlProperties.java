package io.trydent.proteus.conf.store.hsql;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import io.trydent.proteus.conf.base.DataStoreProperties;

/**
 * Created by guada on 08/09/14.
 */
public interface HsqlProperties extends DataStoreProperties {
	public static final String
		HSQL_URL_FORMAT = "jdbc:hsqldb:hsql://%s:%d/%s",
		HSQLS_URL_FORMAT = "jdbc:hsqldb:hsqls://%s:%d/%s",
		FILE_URL_FORMAT = "jdbc:hsqldb:file://%s:%d/%s",
		RES_URL_FORMAT = "jdbc:hsqldb:res://%s:%d/%s";

	public void setDatabase(String database);
	public String getDatabase();

	public default String getDriver() { return MysqlDataSource.class.getCanonicalName(); }

	public default String getUrl() { return getHsqlUrl(); }
	public default String getHsqlUrl() { return String.format(HSQL_URL_FORMAT, getHost(), getPort(), getDatabase()); }
}
