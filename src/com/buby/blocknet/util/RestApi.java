package com.buby.blocknet.util;

import org.apache.http.client.methods.CloseableHttpResponse;

import com.buby.blocknet.BlockNetBungee;
import com.buby.blocknet.Servlet;
import com.buby.blocknet.util.model.HeaderModel;

import io.javalin.Javalin;

public abstract class RestApi {
	protected Javalin app = null;
	
	public RestApi() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
		app = Javalin.create().start(BlockNetBungee.getInstance().getConfigProfile().getApiPort());
		body();

        Thread.currentThread().setContextClassLoader(classLoader);
	}
	
	public abstract void body();
	
	public void disable() {
		
		app.stop();
	}
	
	public int post(Servlet servlet, String page, HeaderModel... headers) {
		return servlet.post(page, headers);
	}
	
	public CloseableHttpResponse postComplex(Servlet servlet, String page, HeaderModel... headers) {
		return servlet.postComplex(page, headers);	
	}
}
