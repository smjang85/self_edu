package mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

public class GameGenMockTest {
	
	// Mockito.mock 메소드를 이용하면 특정타입의 모의 객체를 생성할 수 있다.
	@Test
	void mockTest() {
		GameNumGen genMock = mock(GameNumGen.class);
	}
	
	// 모의 객체를 생성한 뒤에는 BDDMockito 클래스를 이용해서 모의 객체에 스텁을 구성할 수 있다.
	@Test
	void mock_Stub_Test() {
		// (1) 모의 객체 생성
		GameNumGen genMock = mock(GameNumGen.class);
		
		// (2) 스텁 설정
		BDDMockito.given(genMock.generate(GameLevel.EASY)).willReturn("123");
		
		// (3) 스텁 설정에 매칭되는 메서드 실행
		String num = genMock.generate(GameLevel.EASY);
		assertEquals("123", num);
	}
	
	// 특정 타입의 익셉션을 발생하도록 스텁 설정
	@Test
	void mockThrowTest() {
		GameNumGen genMock = mock(GameNumGen.class);
		
		BDDMockito.given(genMock.generate(null)).willThrow(IllegalArgumentException.class);
		
		//BDDMockito.given(genMock.generate(null)).willThrow(new IllegalArgumentException());
		
		assertThrows(IllegalArgumentException.class, () -> genMock.generate(null));
	}
	
	@Test
	void voidMethodWillThrowTest() {
		List<String> mockList = mock(List.class);
		BDDMockito.willThrow(UnsupportedOperationException.class)
		.given(mockList)
		.clear();
		
		assertThrows(UnsupportedOperationException.class, () -> mockList.clear());
	}
}
