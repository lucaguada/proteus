package io.trydent.proteus.conf.store.oracle;

import io.trydent.proteus.conf.base.AbstractDataStoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by guada on 04/09/14.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractOracleProperties extends AbstractDataStoreProperties implements OracleProperties {
	private String database;
}
