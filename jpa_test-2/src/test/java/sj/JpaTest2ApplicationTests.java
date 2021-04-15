package sj;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import sj.entity.Member;

@SpringBootTest
class JpaTest2ApplicationTests {

	@Test
	void contextLoads() {
		Member.builder().username("lsj").build();
	}

}
