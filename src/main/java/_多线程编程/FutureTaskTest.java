package _多线程编程;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author:boxiao
 * @Data: 2020/5/10 22:02
 */
public class FutureTaskTest {
    private  final ConcurrentHashMap<Object, Future<String>> taskCache = new ConcurrentHashMap<>();

    private String executionTask(final String taskName) {
        while (true) {
            Future<String> future = taskCache.get(taskName);  // 1.1 2.1
            if (future == null) {
                Callable<String> task = new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return taskName;
                    }
                };
                //1.2
                FutureTask<String> futureTask = new FutureTask<>(task);
                future = taskCache.putIfAbsent(taskName, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run(); //1.4
                }
            }
            try {
                return future.get(); //1.5, 2.2
            } catch (InterruptedException | ExecutionException e) {
                taskCache.remove(taskName, future);
            }
        }
    }
}
