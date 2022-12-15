package lt.kvk.i17.chursin_jevgenij.singleton;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Config { //SINGLETON
	public final static String CONFIG_PATH = "ConfigFiles/server.properties";
	public final static int HOST_PORT = 9999;
	public final static String CLIENT_NAME = "User";
	public final static int AMOUNT = 7;

	private static Config instance = null;

	private String  clientName, configPath;
	private int hostPort, amount;
	
	public static Config getInstance() {
		if (Config.instance == null) {
			Config.instance = new Config();
		}

		return Config.instance;
	}

	private Config() {

		this.configPath = CONFIG_PATH;

		boolean result = this.loadConfig(configPath);

		if (!result) {
			if (!this.createConfig(configPath)) {
				System.exit(0);
			}
		}
	}

	private boolean loadConfig(String configPath) {

		File fileName = new File(configPath);
		Properties serverConfigs = new Properties();

		if (!fileName.exists())
			new File(fileName.getParent()).mkdir();
		
		try (FileReader configFile = new FileReader(fileName)) {

			if (configFile.read() == -1)
				throw new IOException("Properties file is empty");

			serverConfigs.load(configFile);
			this.hostPort = Integer.parseInt(serverConfigs.getProperty("host_port"));
			this.clientName = serverConfigs.getProperty("client_name");
			this.amount = Integer.parseInt(serverConfigs.getProperty("amount"));

		} catch (IOException e) {
			System.out.println(e.toString());
			return false;
		}

		System.out.println("Config loaded.");
		return true;
	}

	private boolean createConfig(String configPath) {
		this.hostPort = HOST_PORT;
		this.clientName = CLIENT_NAME;
		this.amount = AMOUNT;

		System.out.println("Config created.");
		return this.saveConfig(configPath);
	}

	private boolean saveConfig(String configPath) {

		Properties serverConfigs = new Properties();

		try (FileWriter configFile = new FileWriter(configPath)) {

			serverConfigs.setProperty("host_port", String.valueOf(this.hostPort));
			serverConfigs.setProperty("client_name", this.clientName);
			serverConfigs.setProperty("amount", String.valueOf(this.amount));
			serverConfigs.store(configFile, "ChatAppProperties");

		} catch (IOException e) {
			System.out.println(e.toString());
			return false;
		}

		System.out.println("Config saved.");
		return true;
	}

	public void setPort(int hostPort) {
		this.hostPort = hostPort;
		this.saveConfig(this.configPath);
	}
	
	public void setName(String clientName) {
		this.clientName = clientName;
		this.saveConfig(this.configPath);
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
		this.saveConfig(this.configPath);
	}
	
	public String getUserName() {
		return clientName;
	}
	
	public int getPort() {
		return hostPort;
	}
	
	public int getAmount() {
		return amount;
	}
}
