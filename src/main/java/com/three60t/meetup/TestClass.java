package com.three60t.meetup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestClass {
	public static void main(String[] args) {
		trySpring();
		tryGuice();
		tryGuiceProvides();
	}

	private static void tryGuice() {
		Injector injector = Guice.createInjector(new MyModule());

		SpaceShip spaceShip = injector.getInstance(SpaceShip.class);

		spaceShip.flyToMars();
	}

	private static void tryGuiceProvides() {
		Injector injector = Guice.createInjector(new MyModuleProvides());

		SpaceShip spaceShip = injector.getInstance(SpaceShip.class);

		spaceShip.flyToMars();
	}

	private static void trySpring() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfBean.class);

		SpaceShip spaceShip = ctx.getBean(SpaceShip.class);

		spaceShip.flyToMars();
	}
}