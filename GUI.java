import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class GUI extends JFrame{
 
    private final int ancho = 500;   
    private final int largo = 300;

    public GUI(String what) {
        this.setSize(ancho, largo);
        this.setTitle("Find and Replace");
        this.setLocationRelativeTo(null);
        if (what.equals("f")) {
            buildFind();
        }
        else {
            buildReplace();
        }
    }

    private void buildFind() { 
        
        setLayout(new GridLayout(4,1));
        
        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel options = new JPanel(new GridLayout(1, 2));
        JButton findButton = new JButton("Buscar");
        JButton replaceButton = new JButton("Reemplazar");
        findButton.setEnabled(false);
        replaceButton.setEnabled(true);
        options.add(findButton);
        options.add(replaceButton);
        optionsPanel.add(options);
        
        JPanel findPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel findWhat = new JLabel("Buscar: ");
        JTextField findWord = new JTextField(10);
        findPanel.add(findWhat);
        findPanel.add(findWord);

        JPanel executePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton executeFind = new JButton("Buscar");
        executeFind.setSize(100, 100);
        executePanel.add(executeFind);
        
        add(optionsPanel);
        add(findPanel);
        add(executePanel);
        
        this.setVisible(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
    private void buildReplace() {
        
        setLayout(new GridLayout(4,1));
        
        JPanel optionsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel options = new JPanel(new GridLayout(1, 2));
        JButton findButton = new JButton("Buscar");
        JButton replaceButton = new JButton("Reemplazar");
        findButton.setEnabled(true);
        replaceButton.setEnabled(false);
        options.add(findButton);
        options.add(replaceButton);
        optionsPanel.add(options);
        
        JPanel findPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel findWhat = new JLabel("Buscar: ");
        JTextField findWord = new JTextField(10);
        findPanel.add(findWhat);
        findPanel.add(findWord);

        JPanel replacePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel replaceWhat = new JLabel("Reemplazar con: ");
        JTextField replaceWord = new JTextField(10);
        replacePanel.add(replaceWhat);
        replacePanel.add(replaceWord);

        JPanel executePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton executeReplace = new JButton("Reemplazar");
        executeReplace.setSize(100, 100);
        executePanel.add(executeReplace);
        
        add(optionsPanel);
        add(findPanel);
        add(replacePanel);
        add(executePanel);
        
        this.setVisible(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    public static void main(String[] args) {
        new GUI("f");
        new GUI("a");
    }

}
