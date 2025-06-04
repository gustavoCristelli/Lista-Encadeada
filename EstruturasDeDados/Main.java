public class Main {
    public static void main(String[] args) {
        UniBHList<Integer> myList = new UniBHList<>();

        System.out.println("--- Inserindo no início ---");
        for (int i = 0; i < 5; i++) {
            myList.insertAtBeginning(i + 1);
            System.out.println("Adicionado no início: " + (i + 1) + " -> " + myList);
        }

        System.out.println("\n--- Inserindo no final ---");
        for (int i = 10; i < 15; i++) {
            myList.insertAtEnd(i + 1);
            System.out.println("Adicionado no final: " + (i + 1) + " -> " + myList);
        }

        System.out.println("\nLista final após inserções: " + myList);

        System.out.println("\n--- Removendo do início ---");
        myList.removeAtBeginning();
        System.out.println("Removido do início. Lista: " + myList);

        System.out.println("\n--- Removendo do final ---");
        myList.removeAtEnd();
        System.out.println("Removido do final. Lista: " + myList);

        System.out.println("\nLista após remoções: " + myList);

        System.out.println("\n--- Pesquisando item ---");
        try {
            Node<Integer> foundNode = myList.search(3);
            System.out.println("Item 3 encontrado: " + foundNode.getValue());
            Node<Integer> foundNode2 = myList.search(11);
            System.out.println("Item 11 encontrado: " + foundNode2.getValue());
            // Este deve lançar um erro
            // myList.search(99);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Removendo item pelo valor ---");
        try {
            System.out.println("Lista antes da remoção: " + myList);
            Node<Integer> removedNodeByValue = myList.removeByValue(11);
            System.out.println("Removido pelo valor 11: " + removedNodeByValue.getValue() + ". Lista: " + myList);
            // Este deve lançar um erro
            // myList.removeByValue(99);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Verificando se a lista está vazia ---");
        System.out.println("Lista está vazia? " + myList.isEmpty());
        UniBHList<String> emptyList = new UniBHList<>();
        System.out.println("Lista vazia está vazia? " + emptyList.isEmpty());

        System.out.println("\n--- Inserindo elemento após o i-ésimo item ---");
        System.out.println("Lista antes da inserção: " + myList);
        try {
            myList.insertAfterIndex(2, 20); // Insere 20 após o 3º elemento (índice 2)
            System.out.println("Inserido 20 após o índice 2. Lista: " + myList);
            myList.insertAfterIndex(0, 100); // Insere 100 após o 1º elemento (índice 0)
            System.out.println("Inserido 100 após o índice 0. Lista: " + myList);
            // Este deve lançar um erro
            // myList.insertAfterIndex(myList.size(), 30);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Retirando o i-ésimo item da lista ---");
        System.out.println("Lista antes da remoção: " + myList);
        try {
            Node<Integer> removedAtIndex = myList.removeAtIndex(0); // Remove o primeiro elemento
            System.out.println("Removido do índice 0: " + removedAtIndex.getValue() + ". Lista: " + myList);
            removedAtIndex = myList.removeAtIndex(4); // Remove o elemento no índice 4
            System.out.println("Removido do índice 4: " + removedAtIndex.getValue() + ". Lista: " + myList);
            // Este deve lançar um erro
            // myList.removeAtIndex(myList.size());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Retornando o tamanho da lista ---");
        System.out.println("Tamanho da lista: " + myList.size());

        System.out.println("\n--- Modificando um elemento na lista ---");
        System.out.println("Lista antes da modificação: " + myList);
        try {
            myList.modifyElement(4, 400);
            System.out.println("Modificado 4 para 400. Lista: " + myList);
            myList.modifyElement(12, 1200);
            System.out.println("Modificado 12 para 1200. Lista: " + myList);
            // Este deve lançar um erro
            // myList.modifyElement(999, 1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}