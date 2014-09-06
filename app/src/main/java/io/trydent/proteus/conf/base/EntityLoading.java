package io.trydent.proteus.conf.base;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by guada on 23/05/14.
 */
public interface EntityLoading {
	@Transactional
	public void load();
}
