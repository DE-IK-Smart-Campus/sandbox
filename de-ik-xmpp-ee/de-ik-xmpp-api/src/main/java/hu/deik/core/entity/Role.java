package hu.deik.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@Data
@AllArgsConstructor
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Role() {

	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

}
