package com.myimooc.guice.demo.bind;

import com.google.common.base.Joiner;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.multibindings.MapBinder;

import java.util.Map;

/**
 * 提供注册Applet功能
 *
 * @author zc 2017-10-15
 */
public class Applets {

    public static class AppletsRegister {
        private final Binder binder;

        private AppletsRegister(Binder binder) {
            super();
            this.binder = binder;
        }

        public LinkedBindingBuilder<MyApplet> named(String name) {
            return MapBinder
                    .newMapBinder(binder, String.class, MyApplet.class)
                    .addBinding(name);
        }
    }

    public static AppletsRegister register(Binder binder) {
        return new AppletsRegister(binder);
    }

    public static MyApplet get(Injector injector, String name) {
        Map<String, MyApplet> applets = injector
                .getInstance(Key.get(new TypeLiteral<Map<String, MyApplet>>() {
                }));

        if (!applets.containsKey(name)) {
            throw new IllegalArgumentException("Unable to find applet. "
                    + "Valid applets are "
                    + Joiner.on(", ").join(applets.keySet()));
        }

        return applets.get(name);
    }
}
