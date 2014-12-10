package com.onlinetechvision.model;

/**
 * Parent class of Domestic or International Cargo Messages.
 * 
 * @author Eren Avsarogullari
 * @since 10 Dec 2014
 * @version 1.0.0
 */
public class CargoMessage {

	private final Cargo cargo;

	public CargoMessage(Cargo cargo) {
		this.cargo = cargo;
	}

	public Cargo getCargo() {
		return cargo;
	}

	@Override
	public String toString() {
		return cargo.toString();
	}
}
