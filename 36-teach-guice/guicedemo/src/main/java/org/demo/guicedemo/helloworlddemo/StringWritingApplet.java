package org.demo.guicedemo.helloworlddemo;

import javax.inject.Inject;

import org.demo.guicedemo.MyApplet;

import com.google.inject.Provider;

public class StringWritingApplet implements MyApplet {

	private MyDestination destination;
	private Provider<String> stringProvider;

	@Inject
	public StringWritingApplet(MyDestination destination,
			@Output Provider<String> stringProvider) {
		super();
		this.destination = destination;
		this.stringProvider = stringProvider;
	}

	private void writeString() {
		destination.write(stringProvider.get());
	}

	public void run() {
		writeString();
	}
}
