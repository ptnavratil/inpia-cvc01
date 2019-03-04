package cz.ptnavratil.upce.inpia.cvc03springboot;

import cz.ptnavratil.upce.inpia.cvc03springboot.controller.HelloWorldController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Cvc03SpringbootApplication.class})
public class Cvc03SpringbootApplicationTests {

	@Autowired
	HelloWorldController helloWorldController;

	@Test
	public void contextLoads() {

		Assert.assertNotNull(helloWorldController);
	}

}
