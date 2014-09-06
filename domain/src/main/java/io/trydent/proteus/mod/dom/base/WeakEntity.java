package io.trydent.proteus.mod.dom.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * Created by guada on 04/09/14.
 */
@Data
@ToString
@EqualsAndHashCode
@MappedSuperclass
public abstract class WeakEntity implements Weakable {
	private static final Long serialVersionUID = UUID.randomUUID().getMostSignificantBits();

	@NaturalId(mutable = false)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(unique = true, updatable = false)
	private UUID uuid;
}
