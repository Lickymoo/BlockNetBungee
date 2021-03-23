package com.buby.blocknet;

import com.buby.blocknet.util.model.HeaderModel;

import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;

public class BlockNetBungee extends Plugin{
	
	@Getter private BungeeConfigurationProfile configProfile;
	@Getter private static BlockNetBungee instance;
	@Getter private static BlockNetBungeeRestApi restApi;
	
	@Override
	public void onEnable() {
		instance = this;
		
		configProfile = BungeeConfigurationProfile.getConfig("plugins/BlockNetBungee/blocknet-bungee-config.json", "blocknet-bungee-config.json", BungeeConfigurationProfile.class);
		Servlet master = new Servlet(configProfile.getMasterIp(), configProfile.getMasterApiPort());
		try {
			master.post("/ping");
		}catch(Exception e) {
			System.out.println("Could not connect to master");
			return;
		}
		restApi = new BlockNetBungeeRestApi();
		master.post("/bungee_to_master/register", new HeaderModel("port", configProfile.getApiPort() +""));
	}
}
