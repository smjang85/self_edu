package chap08.after.auth.repository;

import chap08.after.auth.model.Customer;

public interface CustomerRepository {
	Customer findOne(String id);
}
