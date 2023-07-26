import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FindAndReplace extends JFrame implements design{
    private final int ancho = 285;
    private final int largo = 200;

    private final JPanel options = new JPanel(new GridLayout(1, 2));
    private final JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel findPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel replacePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel executePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private final JButton findButton = new JButton("Buscar");
    private final JButton replaceButton = new JButton("Reemplazar");
    private final JButton executeButton = new JButton();

    private final JLabel findWhat = new JLabel("Buscar: ");
    private final JLabel replaceWhat = new JLabel("Reemplazar con: ");

    private final JTextField findWord = new JTextField(10);
    private final JTextField replaceWord = new JTextField(10);

    public FindAndReplace() {
        this.setSize(ancho, largo);
        this.setTitle("Find and Replace");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLayout(new GridLayout(4, 1));
        this.setResizable(false);

        findButton.setFont(buttonFont);
        replaceButton.setFont(buttonFont);
        executeButton.setFont(buttonFont);
        findWhat.setFont(buttonFont);
        replaceWhat.setFont(buttonFont);

        executeButton.setBackground(buttonColorClick);

        this.executeButton.setSize(100, 100);

        this.findButton.addActionListener(new move());
        this.replaceButton.addActionListener(new move());

        this.buildFind();
    }
    
    public JButton getExecute() {
        return this.executeButton;
    }

    public String wordToFind() {
        return this.findWord.getText();
    }
    
    public String wordForReplace() {
        return this.replaceWord.getText();
    }
    
    public void cleanTextBoxes() {
        this.findWord.setText("");
        this.replaceWord.setText("");
    }

    private void buildFind() {
        findButton.setEnabled(false);
        findButton.setBackground(buttonColorDeactivate);
        replaceButton.setEnabled(true);
        replaceButton.setBackground(buttonColor);

        options.add(findButton);
        options.add(replaceButton);
        optionsPanel.add(options);

        findPanel.add(findWhat);
        findPanel.add(findWord);

        executeButton.setText("Buscar");
        executePanel.add(executeButton);

        add(optionsPanel);
        add(findPanel);
        add(executePanel);

    }

    private void buildReplace() {
        findButton.setEnabled(true);
        replaceButton.setEnabled(false);
        replaceButton.setBackground(buttonColorDeactivate);
        findButton.setBackground(buttonColor);

        options.add(findButton);
        options.add(replaceButton);
        optionsPanel.add(options);

        findPanel.add(findWhat);
        findPanel.add(findWord);

        replacePanel.add(replaceWhat);
        replacePanel.add(replaceWord);

        executeButton.setText("Reemplazar");
        executePanel.add(executeButton);

        add(optionsPanel);
        add(findPanel);
        add(replacePanel);
        add(executePanel);
    }
    
    private void cleanAll() {
        getContentPane().removeAll();
        repaint();

        executePanel.removeAll();
        findPanel.removeAll();
        replacePanel.removeAll();
        optionsPanel.removeAll();
        options.removeAll();
    }

    private void revalidatePanels() {
        executePanel.revalidate();
        findPanel.revalidate();
        replacePanel.revalidate();
        optionsPanel.revalidate();
        options.revalidate();
    }

    private class move implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cleanAll();

            if (e.getSource().equals(findButton)) {
                buildFind();
            }
            if (e.getSource().equals(replaceButton)) {
                buildReplace();
            }

            revalidatePanels();
        }
    }

}
