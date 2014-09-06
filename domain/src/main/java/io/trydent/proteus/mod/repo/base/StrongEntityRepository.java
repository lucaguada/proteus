package io.trydent.proteus.mod.repo.base;

import io.trydent.proteus.mod.dom.base.Strongable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by guada on 04/09/14.
 */
public interface StrongEntityRepository<E extends Strongable> {
	public Optional<List<E>> findByIdIn(@RequestParam List<Long> ids);

	public Optional<E> findByUuid(@Param("uuid") UUID uuid);
	public Optional<List<E>> findByUuidIn(@RequestParam List<UUID> uuids);
}
