package io.trydent.proteus.conf.base;

import lombok.Data;

/**
 * Created by guada on 07/09/14.
 */
@Data
public abstract class AbstractDataStoreProperties implements DataStoreProperties {
	private String host;
	private Integer port;
	private String username;
	private String password;
}
