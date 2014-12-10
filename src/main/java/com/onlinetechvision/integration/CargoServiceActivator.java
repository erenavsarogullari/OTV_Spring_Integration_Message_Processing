package com.onlinetechvision.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;

import com.onlinetechvision.model.CargoMessage;

/**
 * Cargo Service Activator is a generic endpoint for connecting service instance to the messaging system.
 * 
 * @author Eren Avsarogullari
 * @since 10 Dec 2014
 * @version 1.0.0
 */
@MessageEndpoint
public class CargoServiceActivator {

	private final Logger logger = LoggerFactory.getLogger(CargoServiceActivator.class);
	
	/**
     * Gets processed domestic and international cargo request(s) and logs.
     *
     * @param cargoMessage domestic/international cargo message
     * @param batchId message header shows cargo batch id
     */
	@ServiceActivator(inputChannel = "cargoTransformerOutputChannel")
	public void getCargo(CargoMessage cargoMessage, @Header("CARGO_BATCH_ID") long batchId) {
		logger.debug("Message in Batch[" + batchId + "] is received with payload : " + cargoMessage);
	}

}
