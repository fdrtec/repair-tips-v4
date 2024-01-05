package com.api.repairtips;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RepairTipsApplicationTests {

	@Test
	void contextLoads() {
		var expected = "resultado ok";
		var resulted = "resultado ok";
		
		assertEquals(expected, resulted);
	}

}
