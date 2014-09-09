package io.trydent.proteus.conf.store.mysql;

import io.trydent.proteus.conf.base.AbstractDataStoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by guada on 04/09/14.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractMySqlProperties extends AbstractDataStoreProperties implements MySqlProperties {
	private String schema;
}
