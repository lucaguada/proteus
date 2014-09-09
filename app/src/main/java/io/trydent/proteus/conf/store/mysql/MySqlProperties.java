package io.trydent.proteus.conf.store.mysql;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import io.trydent.proteus.conf.base.DataStoreProperties;

/**
 * Created by guada on 08/09/14.
 */
public interface MySqlProperties extends DataStoreProperties {
	public static final String URL_FORMAT = "jdbc:mysql://%s:%d/%s";

	public void setSchema(String schema);
	public String getSchema();

	public default String getDriver() { return MysqlDataSource.class.getCanonicalName(); }

	public default String getUrl() { return String.format(URL_FORMAT, getHost(), getPort(), getSchema()); }
}
