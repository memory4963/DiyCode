package com.bolo4963gmail.mygankio.ThreadPoolProviderClasses;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by 10733 on 2017/2/12.
 */

public class ThreadPoolProvider {

    private static ThreadPoolExecutor threadPool;

    /**
     * 非线程安全
     * @return 线程池
     */
    public static ThreadPoolExecutor getThreadPool() {
        if (threadPool == null) {
            threadPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                                                Runtime.getRuntime().availableProcessors() * 2 + 1,
                                                0L, TimeUnit.MILLISECONDS,
                                                new LinkedBlockingQueue<Runnable>());
        }
        return threadPool;
    }
    
}
