package fr.insa.server.config.ConfigClient.ressources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientConfigRessource {

	@Value("${server.port}")
	private String serverPort;
	@Value("${db.connection}")
	private String DBType;
	@Value("${db.host}")
	private String DBHost;
	@Value("${db.port}")
	private String DBport;
	
	public String getServerPort() {
		return serverPort;
	}
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	public String getTypeConnectionDeDB() {
		return DBType;
	}
	public void setTypeConnectionDeDB(String typeConnectionDeDB) {
		this.DBType = typeConnectionDeDB;
	}
	@GetMapping("/dbHost")
	public String getDBHost() {
		return DBHost;
	}
	public void setDBHost(String dBHost) {
		DBHost = dBHost;
	}
	public String getDBport() {
		return DBport;
	}
	public void setDBport(String dBport) {
		DBport = dBport;
	}
	
	
}
