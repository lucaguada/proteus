package io.trydent.proteus.conf.base;

import io.trydent.proteus.mod.dom.base.WeakEntity;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guada on 08/09/14.
 */
public interface EntityLoader<E extends WeakEntity> {
	@Transactional
	public void load();
}
