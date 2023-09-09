package com.threads.p32_callable;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         Callable is similar to Runnable, but it can return a value. Generic type is the return type.
         */

        Callable<String> callable = () -> {
            System.out.println("Inside callable");
            Thread.sleep(2000);
            return "CallableValue";
        };


        // SingleThreadExecutor will be enough for this example.
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // This line of code is a little tricky. If you receive a string from executorService directly, you have to wait for the value. It may calculate something behind the scene.
        // So the value may not be present at the time you executed the callable. Instead of giving the value directly, it gives Future<E> object. You can obtain the value from this object in future.
        // The important thing is that while callable is running behind the scene, you should do other stuff and obtain the value as late as possible.
        //        NOT WORKING CODE : String valueFromCallable = executorService.submit(callable);
        Future<String> future = executorService.submit(callable);
        /** DO OTHER STUFF HERE !!! BECAUSE WHEN YOU CALL future.get(), IT WILL WAIT FOR THE VALUE TO BE CALCULATED. RUN future.get() AS LATE AS POSSIBLE. IT IS A BLOCKING CALL. */
        // ....
        // ....
        System.out.println("Main thread is doing other stuff");
        String value = future.get();
        System.out.println(value);

    }
}
