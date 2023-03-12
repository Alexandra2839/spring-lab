package com.learn;

import com.learn.account.Current;
import com.learn.account.Saving;
import com.learn.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(Config.class);

        Saving saving = container.getBean(Saving.class);
        Current current = container.getBean(Current.class);

        saving.initialize();
        current.initialize();
    }
}
