package chap07.card.fake;

import java.util.HashMap;
import java.util.Map;

import chap07.card.model.AutoDebitInfo;
import chap07.card.repository.AutoDebitInfoRepository;

public class MemoryAutoDebitInfoRepository implements AutoDebitInfoRepository {
	private Map<String, AutoDebitInfo> infos = new HashMap<>();

	@Override
	public void save(AutoDebitInfo info) {
		infos.put(info.getUserId(), info);
	}

	@Override
	public AutoDebitInfo findOne(String userId) {
		return infos.get(userId);
	}

}
