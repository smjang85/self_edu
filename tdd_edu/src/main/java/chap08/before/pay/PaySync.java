package chap08.before.pay;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import chap08.before.pay.dao.PayInfoDao;
import chap08.before.pay.dao.PayInfoDaoImpl;
import chap08.before.pay.model.PayInfo;

public class PaySync {
	// 1. 의존 대상을 직접 생성 (테스트를 위한 모든 환경을 구성해야 한다.)
	private PayInfoDao payInfoDao = new PayInfoDaoImpl();
	
	/**
	 * @throws IOException
	 * 2. 하드 코딩 된 경로, IP, 주소 포트는 테스트를 어렵게 한다.
	 */
	public void sync() throws IOException {
		Path path = Paths.get("D:\\data\\pay\\cp0001.csv");
		List<PayInfo> payInfos = Files.lines(path)
									.map(line -> {
										String[] data = line.split(",");
										PayInfo payInfo = new PayInfo(data[0], data[1], Integer.parseInt(data[2]));
										return payInfo;
									})
									.collect(Collectors.toList());
		payInfos.forEach(pi -> payInfoDao.insert(pi));
	}
	
}
