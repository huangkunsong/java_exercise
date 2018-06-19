package com.hks.exercise.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join采用“工作窃取模式”
 * 当执行新的任务时他可以将其拆分成更小的任务执行，
 * 并将小任务加到线程队列中，然后再从一个随即线程中偷一个并把它加入自己的队列中。
 * 就比如两个CPU上有不同的任务,
 * 这时候A已经执行完，B还有任务等待执行,
 * 这时候A就会将B队尾的任务偷过来，加入自己的队列中,
 * 对于传统的线程,ForkJoin更有效的利用的CPU资源！
 * ForkJoinTask:
 *  我们要使用ForkJoin框架,必须首先创建一个ForkJoin任务。
 *  它提供在任务中执行fork()和join()操作的机制,
 *  通常情况下我们不需要直接继承ForkJoinTask类,
 *  而只需要继承它的子类，Fork/Join框架提供了以下两个子类：
 *      RecursiveAction：用于没有返回结果的任务。
 *      RecursiveTask ：用于有返回结果的任务。
 * ForkJoinPool：
*   ForkJoinTask需要通过ForkJoinPool来执行,
 *  任务分割出的子任务会添加到当前工作线程所维护的双端队列中,进入队列的头部。
 *  当一个工作线程的队列里暂时没有任务时,
 *  它会随机从其他工作线程的队列的尾部获取一个任务。
 */
public class ForkJoin {

    private static class CountTask extends RecursiveTask<Integer> {

        private static final int THRESHOLD = 10;

        private int start;

        private int end;

        CountTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            boolean canCompute = (end - start) <= THRESHOLD;
            int sum = 0;
            if (canCompute) {
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                /**
                 * 将任务拆分成2个子任务执行
                 */
                int middle = (start + end) / 2;
                CountTask leftTask = new CountTask(start, middle);
                CountTask rightTask = new CountTask(middle + 1, end);

                /**
                 * 执行子任务,异步
                 */
                rightTask.fork();
                int leftResult = leftTask.invoke();

                /**
                 * 执行所有任务,同步
                 */
                //invokeAll(leftTask,rightTask);

                /**
                 * 获取子任务执行结果
                 */
                int rightResult = rightTask.join();

                sum = leftResult + rightResult;
            }

            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 10000);
        countTask.fork();
        System.out.println(countTask.join());

        Future<Integer> future = forkJoinPool.submit(countTask);
        /**
         * 异步执行抛出异常,主线程无法获取到异常
         * 通过该方法判断是否存在异常
         * getException方法获取异常
         */
        if (countTask.isCompletedAbnormally()) {
            Throwable throwable = countTask.getException();
        }

        System.out.println(future.get());

        forkJoinPool.shutdown();
    }
}
