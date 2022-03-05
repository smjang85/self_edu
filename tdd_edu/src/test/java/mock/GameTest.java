package mock;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

public class GameTest {
	
	@Test
	void init() {
		GameNumGen genMock = mock(GameNumGen.class);
		Game game = new Game(genMock);
		game.init(GameLevel.EASY);
		
		BDDMockito.then(genMock).should().generate(GameLevel.EASY);
		// 한번만 호출 된 것을 검증 시
		BDDMockito.then(genMock).should(BDDMockito.only()).generate(BDDMockito.any());
		/*
		 * only() : 한번만 호출
		 * times(int) : 지정한 횟수만큼 호출
		 * never() : 호출하지 않음
		 * atLeast(int) : 적어도 지정한 횟수만큼 호출
		 * atLeastOnce() : atLeast(1)과 동일
		 * atMost(int) : 최대 지정한 횟수만큼 호출
		 * 
		 */
	}
}
