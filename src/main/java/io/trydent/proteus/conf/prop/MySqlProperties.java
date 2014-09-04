package io.trydent.proteus.conf.prop;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by guada on 04/09/14.
 */

@PropertySource("application.yml")
class DefaultMySql {
	@Getter
	@Value("${default.mysql.host}")
	private static String host;
	@Getter
	@Value("${default.mysql.port}")
	private static Integer port;
	@Getter
	@Value("${default.mysql.schema}")
	private static String schema;
	@Getter
	@Value("${default.mysql.username}")
	private static String username;
	@Getter
	@Value("${default.mysql.password}")
	private static String password;
}

@PropertySource("application.yml")
class OpenshiftMysql {
	@Getter
	@Value("${openshift.mysql.host}")
	private static String host;
	@Getter
	@Value("${openshift.mysql.port}")
	private static Integer port;
	@Getter
	@Value("${openshift.mysql.schema}")
	private static String schema;
	@Getter
	@Value("${openshift.mysql.username}")
	private static String username;
	@Getter
	@Value("${openshift.mysql.password}")
	private static String password;
}

public interface MySqlProperties {
	public static final Integer
		PORT = OpenshiftMysql.getPort() != null ? OpenshiftMysql.getPort() : DefaultMySql.getPort();

	public static final String
		DRIVER = MysqlDataSource.class.getCanonicalName(),

		HOST = OpenshiftMysql.getHost() != null ? OpenshiftMysql.getHost() : DefaultMySql.getHost(),
		SCHEMA = OpenshiftMysql.getSchema() != null ? OpenshiftMysql.getSchema() : DefaultMySql.getSchema(),
		USERNAME = OpenshiftMysql.getUsername() != null ? OpenshiftMysql.getUsername() : DefaultMySql.getUsername(),
		PASSWORD = OpenshiftMysql.getPassword() != null ? OpenshiftMysql.getPassword() : DefaultMySql.getPassword(),
		URL = String.format("jdbc:mysql://%s:%d/%s", HOST, PORT, SCHEMA);
}
