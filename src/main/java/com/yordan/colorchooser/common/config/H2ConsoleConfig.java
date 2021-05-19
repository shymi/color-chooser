package com.yordan.colorchooser.common.config;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


import java.sql.SQLException;

import static org.h2.tools.Server.createWebServer;


@Component
public class H2ConsoleConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(H2ConsoleConfig.class);
	private Server webServer;

	@Value("${h2-console.port}")
	Integer h2ConsolePort;

	@EventListener(ContextRefreshedEvent.class)
	public void start() throws SQLException {
		LOGGER.info("Starting H2 console at port " + h2ConsolePort);
		this.webServer = createWebServer("-webPort", h2ConsolePort.toString(), "-tcpAllowOthers").start();
	}

	@EventListener(ContextClosedEvent.class)
	public void stop() {
		LOGGER.info("Stopping H2 console at port "+h2ConsolePort);
		this.webServer.stop();
	}
}
