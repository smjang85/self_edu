package chap08.after.pay.dao;

import java.util.List;

import chap08.after.pay.model.PayInfo;

public interface PayInfoDao {
	void insert(PayInfo payInfo);
	List<PayInfo> getAll();
}
