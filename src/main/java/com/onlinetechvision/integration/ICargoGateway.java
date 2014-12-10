package com.onlinetechvision.integration;

import java.util.List;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

import com.onlinetechvision.model.Cargo;

/**
 * Cargo Gateway Interface exposes domain-specific method to the application. In
 * other words, it provides an application access to the messaging system.
 * 
 * @author Eren Avsarogullari
 * @since 10 Dec 2014
 * @version 1.0.0
 */
@MessagingGateway(name = "cargoGateway", 
					defaultRequestChannel = "cargoGWDefaultRequestChannel")
public interface ICargoGateway {

	/**
     * Processes Cargo Request
     *
     * @param message SI Message covering Cargo List payload and Batch Cargo Id header.
     * @return operation result
     */
	@Gateway
	void processCargoRequest(Message<List<Cargo>> message);
}
