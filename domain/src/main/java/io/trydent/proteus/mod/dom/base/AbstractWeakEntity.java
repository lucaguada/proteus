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
@MappedSuperclass
public abstract class AbstractWeakEntity implements WeakEntity {
/*
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
*/
	@NaturalId(mutable = false)
	@Column(unique = true, updatable = false)
	private String uuid;
}
