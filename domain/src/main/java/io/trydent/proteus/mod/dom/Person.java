package io.trydent.proteus.mod.dom;

import io.trydent.proteus.mod.dom.base.AbstractStrongEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "people")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Person extends AbstractStrongEntity {
	@Column(nullable = false)
	private String firstName;

	@Column
	private String middleName;

	@Column(nullable = false)
	private String lastName;

	@Column
	private Date birth;

	@Column(unique = true, length = 16)
	private String ssn;
}