package br.df.edsonramon.rest.core;

import io.restassured.http.ContentType;

public interface Constantes {
	
	String APP_BASE_URL = "https://reqres.in/api/";
	Integer APP_PORT = 443;
	String APP_BASE_PATH = "";
	
	ContentType APP_CONTEXT_TYPE = ContentType.JSON;
	
	Long MAX_TIMEOUT = 5000L;
}
