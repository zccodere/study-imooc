package org.demo.guicedemo.server;

import java.util.Set;

public interface PriceService {

	long getPrice(long orderId);

	Set<String> getSupportedCurrencies();

}
