package Netology.MSL.Lambda;

public class Worker {
    int errorStep;
    private OnTaskDoneListener callback;
    private OnTaskErrorListener<Boolean, Integer, Integer> errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback, int errorStep) {
        this.callback = callback;
        this.errorCallback = errorCallback;
        this.errorStep = errorStep;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (errorCallback.onError(i, errorStep)) {
                callback.onDone("\033[4;31mTask " + i + " is Error\033[0m");
                continue;
            }
            callback.onDone("Task " + i + " is done");
        }
    }
}
