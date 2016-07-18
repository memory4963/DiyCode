//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.task;

import java.util.Random;

public class Bug {
    private int status;
    private Random random = new Random();

    public Bug() {
        if(this.random.nextBoolean()) {
            throw new RuntimeException("No ~~~");
        } else {
            this.status = 0;
        }
    }

    public void start() throws Exception {
        ++this.status;
        throw new Exception("哈哈～");
    }

    public void see() throws Exception {
        ++this.status;
        if(this.random.nextBoolean()) {
            throw new Exception("I can\'t see anything");
        }
    }

    public void hear() {
        ++this.status;
        if(this.random.nextBoolean() || this.random.nextBoolean()) {
            throw new RuntimeException("Oh Fuck!!! I can not hear anything");
        }
    }

    public void say() throws Throwable {
        ++this.status;
        if(this.random.nextBoolean() || this.random.nextBoolean() || this.random.nextBoolean()) {
            throw new Throwable("WTF!!!");
        }
    }

    public void move() {
        ++this.status;
        if(this.random.nextBoolean() || this.random.nextBoolean() || this.random.nextBoolean() || this.random.nextBoolean()) {
            throw new Error("he he");
        }
    }

    public void end() throws Exception {
        if(this.status < 5) {
            throw new Exception("我已经狗带了");
        } else if(!this.random.nextBoolean() && !this.random.nextBoolean() && !this.random.nextBoolean() && !this.random.nextBoolean()) {
            System.out.println("--哦--");
        } else {
            throw new Exception("呵呵");
        }
    }
}