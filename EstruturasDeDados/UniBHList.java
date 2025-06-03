class UniBHList<T> {
    private Node<T> firstNode;
    private int totalElements;

    public void insertAtBeginning(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(firstNode);
        firstNode = newNode;
        totalElements++;
    }

    public Node<T> removeAtBeginning() {
        if (this.totalElements == 0) {
            return null; // Retorna null se a lista estiver vazia
        }
        Node<T> aux = firstNode;
        firstNode = firstNode.getNext();
        totalElements--;
        return aux;
    }

    public void insertAtEnd(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.totalElements == 0) { // Se a lista estiver vazia
            firstNode = newNode;
        } else {
            Node<T> currentNode = firstNode;
            while (currentNode.getNext() != null) { // Percorre até o último nó
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode); // O último nó aponta para o novo nó
        }
        totalElements++;
    }

    public Node<T> removeAtEnd() {
        if (this.totalElements == 0) {
            return null; // Não há elementos para remover
        }

        Node<T> removedNode;
        if (this.totalElements == 1) { // Se há apenas um elemento
            removedNode = firstNode;
            firstNode = null;
        } else {
            Node<T> currentNode = firstNode;
            // Percorre até o penúltimo nó
            while (currentNode.getNext().getNext() != null) {
                currentNode = currentNode.getNext();
            }
            removedNode = currentNode.getNext(); // O último nó a ser removido
            currentNode.setNext(null); // O penúltimo nó agora é o último
        }
        totalElements--;
        return removedNode;
    }

    @Override
    public String toString() {
        if(this.totalElements == 0) {
            return "[ ]";
        }

        Node<T> currentNode = firstNode;
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalElements; i++) {
            builder.append(currentNode.getValue());
            if (i < totalElements - 1) { // Adiciona vírgula se não for o último elemento
                builder.append(", ");
            }
            currentNode = currentNode.getNext();
        }

        builder.append("]");

        return builder.toString();
    }

    public int size() {
        return totalElements;
    }
}