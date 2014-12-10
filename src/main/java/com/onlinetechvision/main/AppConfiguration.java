package com.onlinetechvision.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

/**
 * Configuration provider class for Spring Container.
 * 
 * @author Eren Avsarogullari
 * @since 10 Dec 2014
 * @version 1.0.0
 */
@Configuration
@ComponentScan("com.onlinetechvision.integration")
@EnableIntegration
@IntegrationComponentScan("com.onlinetechvision.integration")
public class AppConfiguration {

	/**
     * Creates a new cargoGWDefaultRequest Channel and registers to BeanFactory.
     *
     * @return direct channel
     */
	@Bean
	public MessageChannel cargoGWDefaultRequestChannel() {
		return new DirectChannel();
	}

	/**
     * Creates a new cargoSplitterOutput Channel and registers to BeanFactory.
     *
     * @return direct channel
     */
	@Bean
	public MessageChannel cargoSplitterOutputChannel() {
		return new DirectChannel();
	}

	/**
     * Creates a new cargoFilterOutput Channel and registers to BeanFactory.
     *
     * @return direct channel
     */
	@Bean
	public MessageChannel cargoFilterOutputChannel() {
		return new DirectChannel();
	}

	/**
     * Creates a new cargoFilterDiscard Channel and registers to BeanFactory.
     *
     * @return direct channel
     */
	@Bean
	public MessageChannel cargoFilterDiscardChannel() {
		return new DirectChannel();
	}
	
	/**
     * Creates a new cargoRouterDomesticOutput Channel and registers to BeanFactory.
     *
     * @return direct channel
     */
	@Bean
	public MessageChannel cargoRouterDomesticOutputChannel() {
		return new DirectChannel();
	}

	/**
     * Creates a new cargoRouterInternationalOutput Channel and registers to BeanFactory.
     *
     * @return direct channel
     */
	@Bean
	public MessageChannel cargoRouterInternationalOutputChannel() {
		return new DirectChannel();
	}

	/**
     * Creates a new cargoTransformerOutput Channel and registers to BeanFactory.
     *
     * @return direct channel
     */
	@Bean
	public MessageChannel cargoTransformerOutputChannel() {
		return new DirectChannel();
	}

}
