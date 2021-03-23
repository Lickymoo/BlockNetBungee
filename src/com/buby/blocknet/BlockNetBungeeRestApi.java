package com.buby.blocknet;

import java.net.InetSocketAddress;

import com.buby.blocknet.util.RestApi;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;

public class BlockNetBungeeRestApi extends RestApi{

	@Override
	public void body() {
        
		app.post("/master_to_bungee/register_server", 
			ctx -> {
				String id = ctx.req.getHeader("id");
				String ip = ctx.req.getHeader("ip");
				String port = ctx.req.getHeader("port");
				
				ServerInfo serverInfo = ProxyServer.getInstance().constructServerInfo(id, new InetSocketAddress(ip, Integer.parseInt(port)), "", false);
	            ProxyServer.getInstance().getServers().put(id, serverInfo);
				System.out.println("Successfully added server: " + ip +":" + port + " " + id);
			});
		
	}

}
