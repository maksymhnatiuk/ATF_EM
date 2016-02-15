package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

public class YamlParser {
	
	private static final String CONFIG_FILES_ROOT_PATH = "config/";
	private final String FILE_NAME;
	
	public YamlParser (String fileName){
		this.FILE_NAME = fileName;
	}
	
	public <T> T parseAs(Class <T> type){
		T object;
		try {
			InputStream input = new FileInputStream(new File(CONFIG_FILES_ROOT_PATH + FILE_NAME));
			Yaml yaml = new Yaml();
			object = yaml.loadAs(input, type);
			input.close();
		} catch (IOException e) {
			throw new RuntimeException("Could not load: " + CONFIG_FILES_ROOT_PATH + FILE_NAME + " file.");
		}
		return object;
	}
}