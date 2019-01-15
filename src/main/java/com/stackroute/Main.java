package com.stackroute;

import com.stackroute.domain.Actor;
import com.stackroute.domain.Movie;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.beans.beancontext.BeanContext;

public class Main {
    public static void main(String[] args) {

        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));

        Movie movie = (Movie) factory.getBean("movie");
        System.out.println(movie.getActor().toString());

        BeanDefinitionRegistry registry = new DefaultListableBeanFactory();
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        Movie movie1 = (Movie) ((DefaultListableBeanFactory) registry).getBean("movie");
        System.out.println(movie1.getActor().toString());

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie2 = context.getBean(Movie.class);
        System.out.println(movie2.getActor());
    }
}
