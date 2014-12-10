package com.onlinetechvision.integration;

import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;

import com.onlinetechvision.model.Cargo;

/**
 * Cargo Filter determines whether the message should be passed to the message channel.
 * 
 * @author Eren Avsarogullari
 * @since 10 Dec 2014
 * @version 1.0.0
 */
@MessageEndpoint
public class CargoFilter {

	private static final long CARGO_WEIGHT_LIMIT = 1_000;
	
	/**
     * Checks weight of cargo and filters if it exceeds limit.
     *
     * @param Cargo message
     * @return check result
     */
	@Filter(inputChannel="cargoSplitterOutputChannel", outputChannel="cargoFilterOutputChannel", discardChannel="cargoFilterDiscardChannel")
	public boolean filterIfCargoWeightExceedsLimit(Cargo cargo) {
		return cargo.getWeight() <= CARGO_WEIGHT_LIMIT;
	}
}
