package com.gyy.sm.service;

import com.gyy.sm.entity.Clazz;
import com.gyy.sm.factory.ServiceFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClazzServiceTest {

    @Test
    public void getClazzByDepId() {
        List<Clazz> list = ServiceFactory.getClazzServiceInstance().getClazzByDepId(5);
        list.forEach(System.out::println);

    }
}