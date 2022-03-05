package chap08.before.user_point.dao;

import chap08.before.user_point.model.Subscription;

public interface SubscriptionDao {
	Subscription selectByUser(String id);
}
