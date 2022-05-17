package Netology.MSL.Lambda;

@FunctionalInterface
public interface OnTaskErrorListener<R, T,U> {
    public R onError(T a, U b);
}
