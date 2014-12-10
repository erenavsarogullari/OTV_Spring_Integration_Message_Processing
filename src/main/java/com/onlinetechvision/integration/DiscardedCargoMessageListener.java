package com.onlinetechvision.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;

import com.onlinetechvision.model.Cargo;

/**
 * Discarded Cargo Message Listener listens the discarded Cargo messages by CargoFilter.
 * 
 * @author Eren Avsarogullari
 * @since 10 Dec 2014
 * @version 1.0.0
 */
@MessageEndpoint
public class DiscardedCargoMessageListener {

	private final Logger logger = LoggerFactory.getLogger(DiscardedCargoMessageListener.class);
	
	/**
     * Handles discarded domestic and international cargo request(s) and logs.
     *
     * @param cargo domestic/international cargo message
     * @param batchId message header shows cargo batch id
     */
	@ServiceActivator(inputChannel = "cargoFilterDiscardChannel")
	public void handleDiscardedCargo(Cargo cargo, @Header("CARGO_BATCH_ID") long batchId) {
		logger.debug("Message in Batch[" + batchId + "] is received with Discarded payload : " + cargo);
	}

}
