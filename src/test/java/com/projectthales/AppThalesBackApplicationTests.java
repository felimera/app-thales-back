package com.projectthales;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppThalesBackApplicationTests {

	@Test
	void contextLoads() {
		AppThalesBackApplication myClass = new AppThalesBackApplication();
		assertThat(myClass).isNotNull();
	}

}
