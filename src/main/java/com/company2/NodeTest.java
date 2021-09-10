package main.java.com.company2;
import java.util.*;
class NodeTest<T extends Comparable<?>> {
    NodeTest<T> left, right;
    T data;

    public NodeTest(T data) {
        this.data = data;
    }
}
