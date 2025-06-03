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
    }
}