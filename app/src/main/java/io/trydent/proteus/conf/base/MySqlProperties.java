package io.trydent.proteus.conf.base;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import lombok.Data;

/**
 * Created by guada on 04/09/14.
 */
@Data
public abstract class MySqlProperties implements DbmsProperties {
	public static final String URL_FORMAT = "jdbc:mysql://%s:%d/%s";

	private String host;
	private Integer port;
	private String schema;
	private String username;
	private String password;

	@Override
	public String getDriver() { return MysqlDataSource.class.getCanonicalName(); }

	@Override
	public String getUrl() { return String.format(URL_FORMAT, getHost(), getPort(), getSchema()); }
}
