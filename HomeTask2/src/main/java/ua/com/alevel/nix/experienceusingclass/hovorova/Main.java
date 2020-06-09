package ua.com.alevel.nix.experienceusingclass.hovorova;

import ua.com.alevel.nix.experienceusingclass.hovorova.builder.DataBuilder;
import ua.com.alevel.nix.experienceusingclass.hovorova.config.ApplicationEnvironment;

public class Main {
	public static void main(String[] args) {
		runDataBuilder(args);
	}

	private static void runDataBuilder(String[] args) {
		DataBuilder dataBuilder = new DataBuilder();
		if (args.length != 0) {
			ApplicationEnvironment.setPropertyLang(args[0]);
		} else {
			ApplicationEnvironment.setPropertyLang("en");
		}
		dataBuilder.buildDataList();
	}

}
