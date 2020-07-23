package paan.hibernates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="level")
	private Level level;
	
	@Column(name="strength")
	private double strength;
	
	@Column(name="endurance")
	private int endurance;
	
	@Column(name="visible")
	private Boolean visible;

	public Item(String name, Level level, double strength, int endurance, Boolean visible) {
		super();
		this.name = name;
		this.level = level;
		this.strength = strength;
		this.endurance = endurance;
		this.visible = visible;
	}

	@Override
	public String toString() {
		return String.format("Item [id=%s, name=%s, level=%s, strength=%s, endurance=%s, visible=%s]", id, name, level,
				strength, endurance, visible);
	}
	
	
}
