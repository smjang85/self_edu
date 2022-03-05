package chap08.after.user_point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

public class DailyBatchLoaderTest {
	private Times mockTimes = mock(Times.class);
	private final DailyBatchLoader loader = new DailyBatchLoader();
	
	@BeforeEach
	void setUp() {
		loader.setBasePath("src/test/resources");
		loader.setTimes(mockTimes);
	}
	
	@Test
	void loadCount() {
		BDDMockito.given(mockTimes.today()).willReturn(LocalDate.of(2019, 1, 1));
		int ret = loader.load();
		assertEquals(3, ret);
		
	}
}
