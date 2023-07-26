import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TextToWork extends JFrame implements design{
    Trie trie;
    private final int topSpace = 5;
    private final int leftSpace = 5;
    private final int bottomSpace = 5;
    private final int rightSpace = 5;

    private final EmptyBorder border = new EmptyBorder(topSpace, leftSpace, bottomSpace, rightSpace);

    private final JPanel inputPanel = new JPanel(new BorderLayout());
    private final JPanel contentPanel = new JPanel(new BorderLayout());
    private final JPanel outputPanel = new JPanel(new BorderLayout());
    private final JPanel buttonPanel = new JPanel();
    
    private final JLabel indication = new JLabel("Ingrese palabras:");
    private final JLabel indication2 = new JLabel("Contenido:");
    private final JLabel indication3 = new JLabel("Output:");

    private final JTextField inputField = new JTextField(40);

    private final JTextArea consoleTextArea = new JTextArea(10,10);
    private final JTextArea contentTextArea = new JTextArea(10,10);

    private final JScrollPane scrollConsole = new JScrollPane(consoleTextArea);
    private final JScrollPane scrollContent = new JScrollPane(contentTextArea);

    private final JButton showOptions = new JButton("Buscar y Reemplazar");
    private final JButton insertToFinal = new JButton("Insertar");
    private final JButton insertReplace = new JButton("Limpiar");

    private final FindAndReplace operations = new FindAndReplace();

    public TextToWork() {
        trie = new Trie();

        /*las siguientes 5 lineas se usan para crear espacios alrededor de los objetos especificados*/
        this.indication.setBorder(border);
        this.inputField.setBorder(border);
        this.indication2.setBorder(border);
        this.scrollConsole.setBorder(border);
        this.scrollContent.setBorder(border);
        this.buttonPanel.setBorder(border);
        
        consoleTextArea.setFont(buttonFont);
        contentTextArea.setFont(buttonFont);
        showOptions.setFont(buttonFont);
        insertToFinal.setFont(buttonFont);
        insertReplace.setFont(buttonFont);
        indication.setFont(buttonFont);
        indication2.setFont(buttonFont);
        indication3.setFont(buttonFont);

        showOptions.setBackground(buttonColor);
        insertToFinal.setBackground(buttonColor);
        insertReplace.setBackground(buttonColor);

        build();
        setVisible(true);
    }

    private void build() {
        buildListeners();

        buttonPanel.add(insertToFinal);
        buttonPanel.add(insertReplace);
        buttonPanel.add(showOptions);

        inputPanel.add(indication, BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);
        
        outputPanel.add(indication3, BorderLayout.NORTH);
        outputPanel.add(scrollConsole, BorderLayout.CENTER);

        contentPanel.add(indication2, BorderLayout.NORTH);
        contentPanel.add(scrollContent, BorderLayout.CENTER);

        JPanel global = new JPanel(new BorderLayout());
        global.add(inputPanel, BorderLayout.NORTH);
        global.add(outputPanel, BorderLayout.CENTER);
        global.add(contentPanel, BorderLayout.SOUTH);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(global, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        
        this.setTitle("Laboratorio 06");
        pack();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void buildListeners() {

        this.operations.getExecute().addActionListener((ActionEvent e) -> {
            String wordToFind = operations.wordToFind();
            if (operations.getExecute().getText().equals("Buscar")) {
                searchWordInTrie(wordToFind);
            } else if (operations.getExecute().getText().equals("Reemplazar")) {
                String wordForReplace = operations.wordForReplace();
                replaceWordInTrie(wordToFind, wordForReplace);
            }
            operations.cleanTextBoxes();
        });
        
        this.insertToFinal.addActionListener((ActionEvent e) -> {
            String input = inputField.getText();
                String[] wordsToInsert = input.split("\\s+"); // Divide la cadena en palabras individuales

                try {
                    trie.insertList(wordsToInsert);
                    logToConsole("Inserted: " + Arrays.toString(wordsToInsert));
                    logToContent();
                } catch (IllegalArgumentException ex) {
                    logToConsole("Invalid input");
                }
                inputField.setText("");
        });
        
        this.insertReplace.addActionListener((ActionEvent e) -> {
            consoleTextArea.setText(this.inputField.getText());
            contentTextArea.setText(this.inputField.getText());
            trie.clear();
            this.inputField.setText("");
        });
        
        this.showOptions.addActionListener((ActionEvent e) -> {
            if (consoleTextArea.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "No se ha insertado texto o solo hay espacios", "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            } else {
                operations.setVisible(true);
                setEnabled(false);
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
        });

        this.operations.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setEnabled(true);
            }
        });
    }
    
    private void searchWordInTrie(String word) {
        boolean found = trie.search(word);
        logToConsole("Search: " + word + " -> " + found);
    }
    
    private void replaceWordInTrie(String wordToReplace, String replacementWord) {
        try {
            trie.replace(wordToReplace, replacementWord);
            logToConsole("Replaced: " + wordToReplace + " with " + replacementWord);
            logToContent();
        } catch (IllegalArgumentException | NoSuchElementException ex) {
            logToConsole(ex.getMessage());
        }
    }
    
    private void logToConsole(String message) {
        consoleTextArea.append(message + "\n");
        consoleTextArea.setCaretPosition(consoleTextArea.getDocument().getLength());
    }
    
    private void logToContent() {
        contentTextArea.setText(trie.getContent());
    }
    

    private void close() {
        int confirmation = JOptionPane.showConfirmDialog(this, "¿Está seguro de querer cerrar la aplicación?", "Advertencia",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirmation == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new TextToWork();
    }
}
