class Node<T> {
    private T value;
    private Node<T> next; // Tipo parametrizado para 'next'

    public Node(T valor) {
        this.value = valor;
        this.next = null;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) { // Tipo parametrizado para 'next'
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