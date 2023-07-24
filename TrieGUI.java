import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrieGUI extends JFrame {
    private Trie trie;
    private JTextArea outputTextArea;
    private JTextField inputTextField;

    public TrieGUI() {
        trie = new Trie();

        setTitle("Trie GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        outputTextArea = new JTextArea(10, 40);
        outputTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        add(scrollPane, BorderLayout.CENTER);

        inputTextField = new JTextField(20);
        JButton insertButton = new JButton("Insert");
        JButton searchButton = new JButton("Search");
        JButton deleteButton = new JButton("Delete");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(inputTextField);
        buttonPanel.add(insertButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = inputTextField.getText().trim();
                trie.insert(word);
                inputTextField.setText("");
                outputTextArea.append("Inserted: " + word + "\n");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = inputTextField.getText().trim();
                boolean found = trie.search(word);
                outputTextArea.append("Search '" + word + "': " + found + "\n");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = inputTextField.getText().trim();
                trie.delete(word);
                inputTextField.setText("");
                outputTextArea.append("Deleted: " + word + "\n");
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the window on the screen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TrieGUI().setVisible(true);
            }
        });
    }
}
