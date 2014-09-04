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
			SCHEMA = App.NAME,
			CALENDARS = "calendars";
	}

	public interface RestApi {
		public static final String
			API = "rest",
			CALENDARS = API + Database.CALENDARS;
	}
}
