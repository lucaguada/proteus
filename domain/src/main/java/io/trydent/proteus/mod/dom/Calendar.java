package io.trydent.proteus.mod.dom;

import io.trydent.proteus.mod.dom.base.AbstractStrongEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "calendars")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Calendar extends AbstractStrongEntity {
	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private Date start;

	@Column
	private Date end;

	@Column
	private Date startTimezone;

	@Column
	private Date endTimezone;

	@Column
	private String description;

	@Column
	private Long recurrence;

	@Column
	private String rule;

	@Column
	private String exception;

	@Column
	private Boolean allDay;
}