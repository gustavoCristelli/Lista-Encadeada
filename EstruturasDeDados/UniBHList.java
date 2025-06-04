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
        if (this.totalElements == 0) {
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

    /**
     * Pesquisa um item na lista.
     *
     * @param value O valor a ser pesquisado.
     * @return O nó que contém o valor.
     * @throws IllegalArgumentException Se o item não for encontrado na lista.
     */
    public Node<T> search(T value) {
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        throw new IllegalArgumentException("Item " + value + " não encontrado na lista.");
    }

    /**
     * Remove um item da lista pelo seu valor.
     *
     * @param value O valor do item a ser removido.
     * @return O nó que foi removido.
     * @throws IllegalArgumentException Se o valor não estiver presente na lista.
     */
    public Node<T> removeByValue(T value) {
        if (this.totalElements == 0) {
            throw new IllegalArgumentException("A lista está vazia, não há itens para remover.");
        }

        if (firstNode.getValue().equals(value)) {
            return removeAtBeginning();
        }

        Node<T> previousNode = firstNode;
        Node<T> currentNode = firstNode.getNext();

        while (currentNode != null && !currentNode.getValue().equals(value)) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode != null) {
            previousNode.setNext(currentNode.getNext());
            totalElements--;
            return currentNode;
        } else {
            throw new IllegalArgumentException("Item " + value + " não encontrado na lista para remoção.");
        }
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return true se a lista estiver vazia, false caso contrário.
     */
    public boolean isEmpty() {
        return totalElements == 0;
    }

    /**
     * Insere um elemento após o i-ésimo item da lista.
     *
     * @param index O índice após o qual o elemento será inserido (0-based).
     * @param value O valor a ser inserido.
     * @throws IndexOutOfBoundsException Se o índice for inválido.
     */
    public void insertAfterIndex(int index, T value) {
        if (index < 0 || index >= totalElements) {
            throw new IndexOutOfBoundsException("Posição " + index + " inválida para inserção. A lista tem " + totalElements + " elementos.");
        }

        Node<T> newNode = new Node<>(value);
        Node<T> currentNode = firstNode;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        totalElements++;
    }

    /**
     * Retira o i-ésimo item da lista.
     *
     * @param index O índice do item a ser removido (0-based).
     * @return O nó que foi removido.
     * @throws IndexOutOfBoundsException Se o índice for inválido.
     */
    public Node<T> removeAtIndex(int index) {
        if (index < 0 || index >= totalElements) {
            throw new IndexOutOfBoundsException("Posição " + index + " inválida para remoção. A lista tem " + totalElements + " elementos.");
        }

        if (index == 0) {
            return removeAtBeginning();
        }

        Node<T> previousNode = firstNode;
        for (int i = 0; i < index - 1; i++) {
            previousNode = previousNode.getNext();
        }

        Node<T> removedNode = previousNode.getNext();
        previousNode.setNext(removedNode.getNext());
        totalElements--;
        return removedNode;
    }

    /**
     * Modifica o valor de um elemento presente na lista.
     *
     * @param oldValue O valor atual do elemento a ser modificado.
     * @param newValue O novo valor para o elemento.
     * @throws IllegalArgumentException Se o valor antigo não for encontrado na lista.
     */
    public void modifyElement(T oldValue, T newValue) {
        Node<T> nodeToModify = search(oldValue); // Reutiliza o método search
        nodeToModify.setValue(newValue);
    }
}