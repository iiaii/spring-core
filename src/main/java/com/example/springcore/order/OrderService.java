package com.example.springcore.order;

public interface OrderService {

    Order createOrder(final Long memberId, final String itemName, final int itemPrice);

}
