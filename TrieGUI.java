import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TrieGUI extends JFrame implements design{

    private Trie trie;
    private JTextArea consoleTextArea;

    public TrieGUI() {
        trie = new Trie();

        // GUI components
        JLabel insertLabel = new JLabel("Insert a Word:");
        JLabel outputLabel = new JLabel("Output:");
        JButton insertButton = new JButton("Insert");
        JButton searchButton = new JButton("Search");
        JButton replaceButton = new JButton("Replace");
        JTextField inputField = new JTextField(20);

        // Console to show output
        consoleTextArea = new JTextArea(10, 40);
        consoleTextArea.setEditable(false);
        consoleTextArea.setFont(buttonFont);
        JScrollPane scrollPane = new JScrollPane(consoleTextArea);

        // Set custom colors for buttons
        insertButton.setBackground(buttonColor);
        searchButton.setBackground(buttonColor);
        replaceButton.setBackground(buttonColor);

        // Set custom font for buttons
        insertButton.setFont(buttonFont);
        searchButton.setFont(buttonFont);
        replaceButton.setFont(buttonFont);
        insertLabel.setFont(buttonFont);
        outputLabel.setFont(buttonFont);


        // Button listeners
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String word = inputField.getText();
                try {
                    trie.insert(word);
                    logToConsole("Inserted: " + word);
                } catch (IllegalArgumentException ex) {
                    logToConsole("Invalid input");
                }
                inputField.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String word = inputField.getText();
                boolean found = trie.search(word);
                logToConsole("Search: " + word + " -> " + found);
                inputField.setText("");
            }
        });

        replaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String wordToReplace = inputField.getText();
                String replacementWord = JOptionPane.showInputDialog(TrieGUI.this, "Enter replacement word:");
                try {
                    trie.replace(wordToReplace, replacementWord);
                    logToConsole("Replaced: " + wordToReplace + " with " + replacementWord);
                } catch (IllegalArgumentException | NoSuchElementException ex) {
                    logToConsole(ex.getMessage());
                }
                inputField.setText("");
            }
        });

        // Layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(insertButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(replaceButton);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(insertLabel, BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(outputLabel, BorderLayout.NORTH);
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("Insert, Find and Replace");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void logToConsole(String message) {
        consoleTextArea.append(message + "\n");
        consoleTextArea.setCaretPosition(consoleTextArea.getDocument().getLength());
    }

    public static void main(String[] args) {
        new TrieGUI();
    }
}
