package io.trydent.proteus.conf.load;

import io.trydent.proteus.conf.base.EntityLoader;
import io.trydent.proteus.mod.dom.Calendar;
import io.trydent.proteus.mod.repo.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by guada on 22/05/14.
 */
@Component
public class CalendarLoader implements EntityLoader<Calendar> {
	private static final UUID CALENDAR_UUID = UUID.fromString("7EF3ECCC-9532-4D40-B005-B7A772BA4479");

	@Autowired
	private CalendarRepository repository;

	@Transactional
	public void load() {
		if (repository.findByIdIn(Arrays.asList(123L)) == null) {
			List<Calendar> calendars = Arrays.asList(
				Calendar.builder()
					.title("test")
					.description("description")
					.start(new Date())
				.build(),
				Calendar.builder()
					.title("test")
					.description("description")
					.start(new Date())
				.build());

			repository.save(calendars);
			repository.flush();
		}
	}
}
