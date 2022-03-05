package chap08.before.auth.repository;

import chap08.before.auth.model.Customer;

public interface CustomerRepository {
	Customer findOne(String id);
}
