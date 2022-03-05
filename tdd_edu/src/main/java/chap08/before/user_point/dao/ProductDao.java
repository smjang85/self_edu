package chap08.before.user_point.dao;

import chap08.before.user_point.model.Product;

public interface ProductDao {
	Product selectById(String productId);

}
