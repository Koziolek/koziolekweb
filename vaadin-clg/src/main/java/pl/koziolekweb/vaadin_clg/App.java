package pl.koziolekweb.vaadin_clg;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		Options clo = new Options();
		Option force = new Option("f", "Generate java from html even it exist");
		force.setRequired(false);
		clo.addOption(force);
		Option help = new Option("h", "Show this help");
		clo.addOption(help);
		CommandLineParser clp = new GnuParser();
		try {
			CommandLine cla = clp.parse(clo, args);
			if(cla.hasOption("h")){
				System.out.printf(clo+"");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
