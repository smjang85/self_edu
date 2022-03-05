package mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JUnit5ExtensionTest {
	
	@Mock
	GameNumGen genMock;
	
	// 모의 객체를 생성한 뒤에는 BDDMockito 클래스를 이용해서 모의 객체에 스텁을 구성할 수 있다.
	@Test
	void mock_Stub_Test() {
		
		// (2) 스텁 설정
		BDDMockito.given(genMock.generate(GameLevel.EASY)).willReturn("123");
		
		// (3) 스텁 설정에 매칭되는 메서드 실행
		String num = genMock.generate(GameLevel.EASY);
		assertEquals("123", num);
	}
	
	// 특정 타입의 익셉션을 발생하도록 스텁 설정
	@Test
	void mockThrowTest() {
		
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
