package com.github.hcsp.multithread;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer2 {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Container container = new Container(lock);
        Producer producer = new Producer(container, lock);
        Consumer consumer = new Consumer(container, lock);

        producer.start();
        consumer.start();

        producer.join();
        producer.join();
    }

    public static class Producer extends Thread {
        private Container container;
        private ReentrantLock lock;

        public Producer(Container container, ReentrantLock lock) {
            this.container = container;
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (container.getValue().isPresent()) {
                        try {
                            container.getNotProducerYet().await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int r = new Random().nextInt();
                    System.out.println("Producing " + r);
                    container.setValue(Optional.of(r));
                    container.getNotConsumerYet().signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class Consumer extends Thread {
        private Container container;
        private ReentrantLock lock;

        public Consumer(Container container, ReentrantLock lock) {
            this.container = container;
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (!container.getValue().isPresent()) {
                        try {
                            container.getNotConsumerYet().await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Integer integer = container.getValue().get();
                    System.out.println("Consuming " + integer);
                    container.setValue(Optional.empty());
                    container.getNotProducerYet().signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class Container {
        private Condition notConsumerYet;
        private Condition notProducerYet;
        private Optional<Integer> value = Optional.empty();

        public Container(ReentrantLock lock) {
            this.notConsumerYet = lock.newCondition();
            this.notProducerYet = lock.newCondition();
        }

        public Optional<Integer> getValue() {
            return value;
        }

        public void setValue(Optional<Integer> value) {
            this.value = value;
        }

        public Condition getNotConsumerYet() {
            return notConsumerYet;
        }

        public void setNotConsumerYet(Condition notConsumerYet) {
            this.notConsumerYet = notConsumerYet;
        }

        public Condition getNotProducerYet() {
            return notProducerYet;
        }

        public void setNotProducerYet(Condition notProducerYet) {
            this.notProducerYet = notProducerYet;
        }
    }
}
