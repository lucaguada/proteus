package io.trydent.proteus.mod.repo.base;

import io.trydent.proteus.mod.dom.base.StrongEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * Created by guada on 04/09/14.
 */
public interface StrongEntityRepository<E extends StrongEntity> extends WeakEntityRepository<E> {
	public Optional<List<E>> findByIdIn(@RequestParam List<Long> ids);
}
