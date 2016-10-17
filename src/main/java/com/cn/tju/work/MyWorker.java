package com.cn.tju.work;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by search on 2016/10/14.
 */
@Slf4j
public class MyWorker {
    public void running()
    {
        log.info("i am runing every 5 second");
        System.out.println("i am working");
    }
}
