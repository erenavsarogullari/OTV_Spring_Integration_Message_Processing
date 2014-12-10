package com.onlinetechvision.model;

import java.util.Arrays;

/**
 * Models Domestic Cargo Message(s)
 * 
 * @author Eren Avsarogullari
 * @since 10 Dec 2014
 * @version 1.0.0
 */
public class DomesticCargoMessage extends CargoMessage {
	
	public enum Region {
		
		NORTH(1), SOUTH(2), EAST(3), WEST(4);
		
		private int value;

		private Region(int value) {
			this.value = value;
		}

		public static Region fromValue(int value) {
			return Arrays.stream(Region.values())
							.filter(region -> region.value == value)
							.findFirst()
							.get();
		}
	}
	
	private final Region region; 

	public DomesticCargoMessage(Cargo cargo, Region region) {
		super(cargo);
		this.region = region;
	}

	public Region getRegion() {
		return region;
	}

	@Override
	public String toString() {
		return "DomesticCargoMessage [cargo=" + super.toString() + ", region=" + region + "]";
	}

}
