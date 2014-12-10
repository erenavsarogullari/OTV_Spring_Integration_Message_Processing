package com.onlinetechvision.integration;

import java.util.List;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.Message;

import com.onlinetechvision.model.Cargo;

/**
 * Cargo Splitter breaks incoming Cargo List into Cargo message(s) and send them
 * to the output channel.
 * 
 * @author Eren Avsarogullari
 * @since 10 Dec 2014
 * @version 1.0.0
 */
@MessageEndpoint
public class CargoSplitter {

	/**
     * Splits Cargo List to Cargo message(s)
     *
     * @param message SI Message covering Cargo List payload and Batch Cargo Id header.
     * @return cargo list
     */
	@Splitter(inputChannel = "cargoGWDefaultRequestChannel", 
				outputChannel = "cargoSplitterOutputChannel")
	public List<Cargo> splitCargoList(Message<List<Cargo>> message) {
		return message.getPayload();
	}
}
