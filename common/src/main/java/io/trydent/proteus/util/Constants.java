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
			ORALCE = "oracle",
			POSGRESQL = "posgresql",
			SCHEMA = App.NAME,
			CALENDARS = "calendars",
			PEOPLE = "people";
	}

	public interface Profile {
		public static final String
			PRESET = "preset",
			DEV = "dev",
			TEST = "test",
			OPENSHIFT = "openshift",
			PROD = "prod",
			BUILD = "build",
			HEAVY = "heavy",
			OPENSHIFT_MYSQL = OPENSHIFT + "." + Database.MYSQL,
			DEV_MYSQL = DEV + "." + Database.MYSQL,
			BUILD_HSQLDB = BUILD + "." + Database.HSQLDB,
			PRESET_MYSQL = PRESET + "." + Database.MYSQL,
			HEAVY_ORACLE = HEAVY + "." + Database.ORALCE;
	}

	public interface RestApi {
		public static final String
			API = "rest",
			CALENDARS = API + Database.CALENDARS,
			PEOPLE = API + Database.PEOPLE;
	}
}
