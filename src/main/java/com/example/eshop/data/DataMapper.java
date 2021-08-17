package com.example.eshop.data;

import com.example.eshop.data.dto.*;
import com.example.eshop.data.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DataMapper {

    @Mapping(target = "user.id", source = "userId")
    Cart cartDtoToCart(CartDTO cartDTO);
    CartDTO cartToCardDto(Cart cart);

    @Mapping(target = "cart.id", source = "cartId")
    @Mapping(target = "product.id", source = "productId")
    CartItem cartItemDtoToCartItem(CartItemDTO cartItemDTO);
    CartItemDTO cartItemToCartItemDto(CartItem cartItem);

    @Mapping(target = "user.id", source = "userId")
    Product productDtoToProduct(ProductDTO productDTO);
    ProductDTO productToProductDto(Product product);

    @Mapping(target = "user.id", source = "userId")
    Order orderDtoToOrder(OrderDTO orderDTO);
    OrderDTO orderToOrderDTO(Order order);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "order.id", source = "orderId")
    Transaction transactionDtoToTransaction(TransactionDTO transactionDTO);
    TransactionDTO transactionToTransactionDto(Transaction transaction);

    User userDtoToUser(UserDTO userDTO);
    UserDTO userToUserDto(User user);


}
