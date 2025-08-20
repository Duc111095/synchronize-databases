package com.ducnh.synchronizedatabase.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="tag_generator")
	@SequenceGenerator(name="tag_generator", sequenceName="tag_id_seq", allocationSize=1)
	private Long id;
	
	@Column
	private String name;
}
