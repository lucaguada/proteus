package io.trydent.proteus.util;

/**
 * Created by guada on 03/09/14.
 */
public interface Constants {
	public interface App {
		public static final String
			NAME = "proteus",
			API = "api/";
	}

	public interface Database {
		public static final String
			MYSQL = "mysql",
			HSQLDB = "hsqldb",
			POSGRESQL = "posgresql",
			SCHEMA = App.NAME,
			CALENDARS = "calendars";
	}

	public interface Profile {
		public static final String
			PRESET = "preset",
			DEVELOPMENT = "development",
			TEST = "testing",
			OPENSHIFT = "openshift",
			PRODUCTION = "production",
			BUILD = "building",
			OPENSHIFT_MYSQL = OPENSHIFT + "." + Database.MYSQL,
			DEVELOPMENT_MYSQL = DEVELOPMENT + "." + Database.MYSQL,
			PRESET_MYSQL = PRESET + "." + Database.MYSQL;
	}

	public interface RestApi {
		public static final String
			API = "rest",
			CALENDARS = API + Database.CALENDARS;
	}
}
