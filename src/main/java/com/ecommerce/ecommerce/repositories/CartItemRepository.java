package com.ecommerce.ecommerce.repositories;

import com.ecommerce.ecommerce.entities.Cart;
import com.ecommerce.ecommerce.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query("SELECT SUM(ci.product.productPrice * ci.quantity) FROM CartItem ci WHERE ci.cart.cartId = ?1")
    Long getTotalAmountByCart(Long cartId);


//    CartItem findByCartAndProduct(Long cartId, Long productId);
CartItem findByCart_CartIdAndProduct_ProductId(Long cartId, Long productId);

    List<CartItem> findByCart(Cart cart);
}
