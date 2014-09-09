package io.trydent.proteus.mod.dom.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by guada on 04/09/14.
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public abstract class AbstractStrongEntity extends AbstractWeakEntity implements StrongEntity {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
}
