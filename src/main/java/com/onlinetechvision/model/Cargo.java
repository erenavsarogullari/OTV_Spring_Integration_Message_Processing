package com.onlinetechvision.model;

/**
 * Models incoming Cargo Request(s)
 * 
 * @author Eren Avsarogullari
 * @since 10 Dec 2014
 * @version 1.0.0
 */
public class Cargo {

	public enum ShippingType {
		DOMESTIC, INTERNATIONAL
	}

	private final long trackingId;
	private final String receiverName;
	private final String deliveryAddress;
	private final double weight;
	private final String description;
	private final ShippingType shippingType;
	private final int deliveryDayCommitment;
	private final int region;

	private Cargo(CargoBuilder cargoBuilder) {
		this.trackingId = cargoBuilder.trackingId;
		this.receiverName = cargoBuilder.receiverName;
		this.deliveryAddress = cargoBuilder.deliveryAddress;
		this.weight = cargoBuilder.weight;
		this.description = cargoBuilder.description;
		this.shippingType = cargoBuilder.shippingType;
		this.deliveryDayCommitment = cargoBuilder.deliveryDayCommitment;
		this.region = cargoBuilder.region;
	}

	public long getTrackingId() {
		return trackingId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public double getWeight() {
		return weight;
	}

	public String getDescription() {
		return description;
	}

	public ShippingType getShippingType() {
		return shippingType;
	}

	public int getDeliveryDayCommitment() {
		return deliveryDayCommitment;
	}
	
	public int getRegion() {
		return region;
	}
	
	@Override
	public String toString() {
		return "Cargo [trackingId=" + trackingId + ", receiverName="
				+ receiverName + ", deliveryAddress=" + deliveryAddress
				+ ", weight=" + weight + ", description=" + description
				+ ", shippingType=" + shippingType + ", deliveryDayCommitment="
				+ deliveryDayCommitment + ", region=" + region + "]";
	}

	/**
	 * Builds incoming Cargo Request(s)
	 * 
	 */
	public static class CargoBuilder {
		
		private final long trackingId;
		private final String receiverName;
		private final String deliveryAddress;
		private final double weight;
		private final ShippingType shippingType;
		private int deliveryDayCommitment;
		private int region;
		private String description;
		
		public CargoBuilder(long trackingId, String receiverName,
							String deliveryAddress, double weight, 
							ShippingType shippingType) {
			this.trackingId = trackingId;
			this.receiverName = receiverName;
			this.deliveryAddress = deliveryAddress;
			this.weight = weight;
			this.shippingType = shippingType;
		}

		public CargoBuilder setDeliveryDayCommitment(int deliveryDayCommitment) {
			this.deliveryDayCommitment = deliveryDayCommitment;
			return this;
		}

		public CargoBuilder setDescription(String description) {
			this.description = description;
			return this;
		}
		
		public CargoBuilder setRegion(int region) {
			this.region = region;
			return this;
		}

		public Cargo build() {
			Cargo cargo = new Cargo(this);
			if ((ShippingType.DOMESTIC == cargo.getShippingType()) 
					&& (cargo.getRegion() <= 0 || cargo.getRegion() > 4)) {
		        throw new IllegalStateException("Region is invalid! Cargo Tracking Id : " + cargo.getTrackingId());
		    }
			
			return cargo;
		}
		
	}

}
