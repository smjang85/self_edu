package chap08.after.user_point.dao;

import chap08.after.user_point.model.Product;

public interface ProductDao {
	Product selectById(String productId);

}
