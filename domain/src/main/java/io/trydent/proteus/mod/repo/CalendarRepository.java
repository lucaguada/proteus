package io.trydent.proteus.mod.repo;

import io.trydent.proteus.mod.dom.Calendar;
import io.trydent.proteus.mod.repo.base.EntityRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import static io.trydent.proteus.util.Constants.*;

/**
 * Created by guada on 04/09/14.
 */
@RepositoryRestResource(collectionResourceRel = Database.CALENDARS, path = RestApi.CALENDARS)
public interface CalendarRepository extends EntityRepository<Calendar> { }
