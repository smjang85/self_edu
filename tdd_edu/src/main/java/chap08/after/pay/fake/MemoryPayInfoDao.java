package chap08.after.pay.fake;

import java.util.ArrayList;
import java.util.List;

import chap08.after.pay.dao.PayInfoDao;
import chap08.after.pay.model.PayInfo;

public class MemoryPayInfoDao implements PayInfoDao {
	private List<PayInfo> infos = new ArrayList<>();

	@Override
	public void insert(PayInfo payInfo) {
		infos.add(payInfo);
	}

	@Override
	public List<PayInfo> getAll() {
		return infos;
	}

}
