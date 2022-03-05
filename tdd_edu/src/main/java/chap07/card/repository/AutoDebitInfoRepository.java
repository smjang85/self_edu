package chap07.card.repository;

import chap07.card.model.AutoDebitInfo;

public interface AutoDebitInfoRepository {
	void save(AutoDebitInfo info);
	AutoDebitInfo findOne(String userId);
}
