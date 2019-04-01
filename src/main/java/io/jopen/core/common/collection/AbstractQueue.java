package io.jopen.core.common.collection;

/**
 * @author maxuefeng
 */
public abstract class AbstractQueue<T> implements Queue<T> {


    Node<T> root;


    public AbstractQueue(Node<T> root) {
        this.root = root;
    }

    public AbstractQueue() {
    }
}
