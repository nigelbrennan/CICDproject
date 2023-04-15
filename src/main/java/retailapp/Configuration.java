package retailapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("retail-app")
@Component
public class Configuration {
	private String dummyProperty1;
	private String dummyProperty2;
	
	public String getDummyProperty1() {
		return dummyProperty1;
	}
	public void setDummyProperty1(String dummyProperty1) {
		this.dummyProperty1 = dummyProperty1;
	}
	public String getDummyProperty2() {
		return dummyProperty2;
	}
	public void setDummyProperty2(String dummyProperty2) {
		this.dummyProperty2 = dummyProperty2;
	}

}
