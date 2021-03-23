package com.buby.blocknet;

import com.buby.blocknet.util.ConfigurationProfile;

import lombok.Getter;

public class BungeeConfigurationProfile extends ConfigurationProfile{

	@Getter private int masterApiPort;
	@Getter private String masterIp;
	@Getter private int apiPort;
}
