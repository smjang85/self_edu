package chap08.after.pay;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import chap08.after.pay.fake.MemoryPayInfoDao;
import chap08.after.pay.model.PayInfo;

public class PaySyncTest {
	//대역 생성
	private MemoryPayInfoDao memoryDao = new MemoryPayInfoDao();
	
	@Test
	void allDataSaved() throws IOException{
		PaySync paySync = new PaySync();
		paySync.setPayInfoDao(memoryDao);
		paySync.setFilePath("src/test/resources/c0111.csv");
		
		paySync.sync();
		
		// 대역을 이용한 결과 검증
		List<PayInfo> savedInfos = memoryDao.getAll();
		assertEquals(2, savedInfos.size());
	}
}
