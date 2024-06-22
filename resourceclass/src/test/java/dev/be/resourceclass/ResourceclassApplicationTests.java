package dev.be.resourceclass;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootTest
class ResourceclassApplicationTests {

	@Test
	void contextLoads() throws IOException {

		ClassPathResource resource = new ClassPathResource("/data/sample.json");

		StringBuilder sb = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		String s;
		while((s = bufferedReader.readLine()) != null) {
			sb.append(s);
		}
		ObjectMapper objectMapper = new ObjectMapper();
		sample sample = objectMapper.readValue(sb.toString(), sample.class);
		System.out.println("sample = " + sample);
	}

}
