package chap08.after.user_point.dao;

import chap08.after.user_point.model.Subscription;

public interface SubscriptionDao {
	Subscription selectByUser(String id);
}
