package com.onlinetechvision.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.messaging.support.MessageBuilder;

import com.onlinetechvision.integration.ICargoGateway;
import com.onlinetechvision.model.Cargo;
import com.onlinetechvision.model.Cargo.ShippingType;

/**
 * Starts the application by initializing Spring container.
 * 
 * @author Eren Avsarogullari
 * @since 10 Dec 2014
 * @version 1.0.0
 */
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		ICargoGateway orderGateway = ctx.getBean(ICargoGateway.class);
		
		getCargoBatchMap().forEach(
			(batchId, cargoList) -> orderGateway.processCargoRequest(MessageBuilder
																		.withPayload(cargoList)
																		.setHeader("CARGO_BATCH_ID", batchId)
																		.build()));
	}
	
	/**
     * Creates a sample cargo batch map covering multiple batches and returns.
     *
     * @return cargo batch map
     */
	private static Map<Integer, List<Cargo>> getCargoBatchMap() {
		Map<Integer, List<Cargo>> cargoBatchMap = new HashMap<>();
		
		cargoBatchMap.put(1, Arrays.asList(
				
				new Cargo.CargoBuilder(1, "Receiver_Name1", "Address1", 0.5, ShippingType.DOMESTIC)
							.setRegion(1).setDescription("Radio").build(),
				//Second cargo is filtered due to weight limit			
				new Cargo.CargoBuilder(2, "Receiver_Name2", "Address2", 2_000, ShippingType.INTERNATIONAL)
							.setDeliveryDayCommitment(3).setDescription("Furniture").build(),
				new Cargo.CargoBuilder(3, "Receiver_Name3", "Address3", 5, ShippingType.INTERNATIONAL)
							.setDeliveryDayCommitment(2).setDescription("TV").build(),
				//Fourth cargo is not processed due to no shipping type found			
				new Cargo.CargoBuilder(4, "Receiver_Name4", "Address4", 8, null)
							.setDeliveryDayCommitment(2).setDescription("Chair").build()));
										
		cargoBatchMap.put(2, Arrays.asList(
				//Fifth cargo is filtered due to weight limit
				new Cargo.CargoBuilder(5, "Receiver_Name5", "Address5", 1_200, ShippingType.DOMESTIC)
							.setRegion(2).setDescription("Refrigerator").build(),
				new Cargo.CargoBuilder(6, "Receiver_Name6", "Address6", 20, ShippingType.DOMESTIC)
							.setRegion(3).setDescription("Table").build(),
				//Seventh cargo is not processed due to no shipping type found
				new Cargo.CargoBuilder(7, "Receiver_Name7", "Address7", 5, null)
							.setDeliveryDayCommitment(1).setDescription("TV").build()));
				
		cargoBatchMap.put(3, Arrays.asList(
				new Cargo.CargoBuilder(8, "Receiver_Name8", "Address8", 200, ShippingType.DOMESTIC)
							.setRegion(2).setDescription("Washing Machine").build(),
				new Cargo.CargoBuilder(9, "Receiver_Name9", "Address9", 4.75, ShippingType.INTERNATIONAL)
							.setDeliveryDayCommitment(1).setDescription("Document").build()));
		
		return Collections.unmodifiableMap(cargoBatchMap);
	}
	
}
