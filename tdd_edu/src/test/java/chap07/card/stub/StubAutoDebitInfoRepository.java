package chap07.card.stub;

import chap07.card.model.AutoDebitInfo;
import chap07.card.repository.AutoDebitInfoRepository;

public class StubAutoDebitInfoRepository implements AutoDebitInfoRepository {

	@Override
	public void save(AutoDebitInfo info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AutoDebitInfo findOne(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
