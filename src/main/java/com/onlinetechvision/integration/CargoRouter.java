package com.onlinetechvision.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import com.onlinetechvision.model.Cargo;
import com.onlinetechvision.model.Cargo.ShippingType;

/**
 * Router determines what channel(s) should receive the Message next if it is available.
 * 
 * @author Eren Avsarogullari
 * @since 10 Dec 2014
 * @version 1.0.0
 */
@MessageEndpoint
public class CargoRouter {
	
	/**
     * Determines cargo request' s channel in the light of shipping type.
     *
     * @param Cargo message
     * @return channel name
     */
	@Router(inputChannel="cargoFilterOutputChannel")
	public String route(Cargo cargo) {
		if(cargo.getShippingType() == ShippingType.DOMESTIC) {
			return "cargoRouterDomesticOutputChannel";
		} else if(cargo.getShippingType() == ShippingType.INTERNATIONAL) {
			return "cargoRouterInternationalOutputChannel";
		} 
		
		return "nullChannel"; 
	}
	
}
