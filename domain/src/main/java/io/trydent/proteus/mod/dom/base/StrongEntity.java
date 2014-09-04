package io.trydent.proteus.mod.dom.base;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by guada on 04/09/14.
 */
@Data
public abstract class StrongEntity extends WeakEntity implements Strongable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
}
