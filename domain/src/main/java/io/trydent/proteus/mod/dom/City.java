package io.trydent.proteus.mod.dom;

import io.trydent.proteus.mod.dom.base.AbstractStrongEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by guada on 17/09/14.
 */
@Data
@Entity
@Table(name = "cities")
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class City extends AbstractStrongEntity {
	@NonNull
	@Column(nullable = false)
	private String name;

	@NonNull
	@Column(nullable = false)
	private String state;

	@NonNull
	@Column(nullable = false)
	private String country;

	@NonNull
	@Column(nullable = false)
	private String map;
}
