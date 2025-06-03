class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T valor) {
        this.value = valor;
        this.next = null;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}