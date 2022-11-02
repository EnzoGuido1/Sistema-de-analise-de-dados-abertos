package br.uel.bd1.dadosparlamentares.business;

public class CombinedKey<T, K>{
    private final T first;
    private final K second;

    public CombinedKey(T first, K second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public K getSecond() {
        return second;
    }
}
