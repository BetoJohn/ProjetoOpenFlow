package net.floodlightcontroller.core.testes;

import org.projectfloodlight.openflow.protocol.OFQueueGetConfigRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.floodlightcontroller.core.Main;
import net.floodlightcontroller.core.internal.CmdLineSettings;
import net.floodlightcontroller.core.module.FloodlightModuleConfigFileNotFoundException;
import net.floodlightcontroller.core.module.FloodlightModuleContext;
import net.floodlightcontroller.core.module.FloodlightModuleLoader;
import net.floodlightcontroller.core.module.IFloodlightModuleContext;
import net.floodlightcontroller.testmodule.TestModule;

public class Teste {
	private static final Logger logger = LoggerFactory.getLogger(Teste.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			// ------------------------------------------------------------------------
			/*
			 * StatisticsCollector sc = new StatisticsCollector();
			 * Map<NodePortTuple, SwitchPortBandwidth> re = sc
			 * .getBandwidthConsumption(); if (!re.isEmpty()) { for
			 * (Map.Entry<NodePortTuple, SwitchPortBandwidth> spb : re
			 * .entrySet()) { System.out.println("TEstes: " + spb.getKey() + "/"
			 * + spb.getValue()); } }
			 */

			// FloodlightModuleContext context = new FloodlightModuleContext();

			// Load modules
			FloodlightModuleLoader fml = new FloodlightModuleLoader();
			CmdLineSettings settings = new CmdLineSettings();
			try {
				IFloodlightModuleContext moduleContext = fml
						.loadModulesFromConfig(settings.getModuleFile());

				TestModule test = new TestModule();// settings.getModuleFile()
				test.init((FloodlightModuleContext) moduleContext);

			} catch (FloodlightModuleConfigFileNotFoundException e) {
				// we really want to log the message, not the stack trace
				logger.error("Could not read config file: {}", e.getMessage());
				System.exit(1);
			}

			// ------------------------------------------------------------------------
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
