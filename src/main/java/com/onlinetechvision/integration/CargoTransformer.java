package com.onlinetechvision.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

import com.onlinetechvision.model.Cargo;
import com.onlinetechvision.model.DomesticCargoMessage;
import com.onlinetechvision.model.DomesticCargoMessage.Region;
import com.onlinetechvision.model.InternationalCargoMessage;
import com.onlinetechvision.model.InternationalCargoMessage.DeliveryOption;

/**
 * Cargo Transformer converts Cargo request to Domestic and International Cargo
 * requests and returns them
 * 
 * @author Eren Avsarogullari
 * @since 10 Dec 2014
 * @version 1.0.0
 *
 */
@MessageEndpoint
public class CargoTransformer {

	/**
	 * Transforms Cargo request to Domestic Cargo obj.
	 *
	 * @param cargo
	 *            request
	 * @return Domestic Cargo obj
	 */
	@Transformer(inputChannel = "cargoRouterDomesticOutputChannel", 
					outputChannel = "cargoTransformerOutputChannel")
	public DomesticCargoMessage transformDomesticCargo(Cargo cargo) {
		return new DomesticCargoMessage(cargo, Region.fromValue(cargo.getRegion()));
	}

	/**
	 * Transforms Cargo request to International Cargo obj.
	 *
	 * @param cargo
	 *            request
	 * @return International Cargo obj
	 */
	@Transformer(inputChannel = "cargoRouterInternationalOutputChannel", 
					outputChannel = "cargoTransformerOutputChannel")
	public InternationalCargoMessage transformInternationalCargo(Cargo cargo) {
		return new InternationalCargoMessage(cargo, getDeliveryOption(cargo.getDeliveryDayCommitment()));
	}

	/**
	 * Get delivery option by delivery day commitment.
	 *
	 * @param deliveryDayCommitment delivery day commitment
	 * @return delivery option
	 */
	private DeliveryOption getDeliveryOption(int deliveryDayCommitment) {
		if (deliveryDayCommitment == 1) {
			return DeliveryOption.NEXT_FLIGHT;
		} else if (deliveryDayCommitment == 2) {
			return DeliveryOption.PRIORITY;
		} else if (deliveryDayCommitment > 2 && deliveryDayCommitment < 5) {
			return DeliveryOption.ECONOMY;
		} else {
			return DeliveryOption.STANDART;
		}
	}

}
