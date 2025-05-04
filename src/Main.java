import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // SwingUtilities.invokeLater(() -> {
        //     JFrame frame = new JFrame("Test");
        //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //     frame.setSize(400, 300);
        //
        //     JPanel panel = new JPanel() {
        //         @Override
        //         protected void paintComponent(Graphics g) {
        //             super.paintComponent(g);
        //             Graphics2D g2 = (Graphics2D) g;
        //             g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        //                                 RenderingHints.VALUE_ANTIALIAS_ON);
        //             g2.setColor(Color.BLUE);
        //             g2.fillOval(100, 50, 100, 100);
        //             g2.setColor(Color.BLACK);
        //             g2.setFont(new Font("SansSerif", Font.BOLD, 18));
        //             g2.drawString("ai que nao sei o que", 115, 180);
        //         }
        //     };
        //
        //     frame.add(panel);
        //     frame.setLocationRelativeTo(null);
        //     frame.setVisible(true);
        // });

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

        String text    = "HELLO WORLD";
        String encoded = tree.encode(text);
        System.out.println(text + " -> " + encoded);

        String decoded = tree.decode(encoded);
        System.out.println(encoded + " -> " + decoded);
    }
}