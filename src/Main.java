import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.Scanner;

public class Main {
    private static final int OPTION_ENCODE = 1;
    private static final int OPTION_DECODE = 2;
    private static final int OPTION_EXIT   = 3;

    public static void main(String[] args) {
        Tree tree = buildTree();
        try (Scanner scanner = new Scanner(System.in)) {
            if (askYesNo(scanner, "Mostrar árvore do código morse? (y/n)")) {
                displayTree(tree);
            }
            int choice;
            do {
                choice = promptMenu(scanner);
                handleChoice(choice, scanner, tree);
            } while (choice != OPTION_EXIT);
        }
    }

    private static boolean askYesNo(Scanner scanner, String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y");
    }

    private static int promptMenu(Scanner scanner) {
        System.out.println("Selecione uma opção: 1 - Encode, 2 - Decode, 3 - Exit");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Input inválida. Digite 1, 2 ou 3.");
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private static void handleChoice(int choice, Scanner scanner, Tree tree) {
        switch (choice) {
            case OPTION_ENCODE:
                System.out.println("Digite o texto para encodar:");
                String text = scanner.nextLine();
                System.out.println("Encoded: " + tree.encode(text));
                break;
            case OPTION_DECODE:
                System.out.println("Digite o texto para descriptografar o código morse:");
                String morse = scanner.nextLine();
                System.out.println("Decoded: " + tree.decode(morse));
                break;
            case OPTION_EXIT:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida. Tente denovo.");
        }
    }

    private static void displayTree(Tree tree) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Árvore Morse");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new SwingTreeViewer(tree.getRoot()));
            frame.setSize(1000, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static Tree buildTree() {
        Tree tree = new Tree();
        tree.insert(".-",   'A');
        tree.insert("-...", 'B');
        tree.insert("-.-.", 'C');
        tree.insert("-..",  'D');
        tree.insert(".",    'E');
        tree.insert("..-.", 'F');
        tree.insert("--.",  'G');
        tree.insert("....", 'H');
        tree.insert("..",   'I');
        tree.insert(".---", 'J');
        tree.insert("-.-",  'K');
        tree.insert(".-..", 'L');
        tree.insert("--",   'M');
        tree.insert("-.",   'N');
        tree.insert("---",  'O');
        tree.insert(".--.", 'P');
        tree.insert("--.-", 'Q');
        tree.insert(".-.",  'R');
        tree.insert("...",  'S');
        tree.insert("-",    'T');
        tree.insert("..-",  'U');
        tree.insert("...-", 'V');
        tree.insert(".--",  'W');
        tree.insert("-..-", 'X');
        tree.insert("-.--", 'Y');
        tree.insert("--..", 'Z');
        return tree;
    }
}
