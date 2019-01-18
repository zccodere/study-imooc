package org.demo.guicedemo.server;

public interface PaymentService {

	void pay(long orderId, long price, Long sessionId);

}
