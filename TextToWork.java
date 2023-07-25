import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class TextToWork extends JFrame {
    private final int ancho = 700;
    private final int largo = 500;
    
    private final FindAndReplace operations = new FindAndReplace();
    
    public TextToWork() {
        this.setSize(ancho, largo);
        this.setTitle("Find and Replace");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5, 1));
        build();
        setVisible(true);
    }
    
    private void build() {
        
        JTextArea text = new JTextArea();
        text.setLineWrap(true); 
        text.setWrapStyleWord(true);
        
        JScrollPane textArea = new JScrollPane(text);
        
        textArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(textArea);
        
        JTextArea textView = new JTextArea();
        textView.setLineWrap(true); 
        textView.setWrapStyleWord(true);
        textView.setEditable(false);
        
        JScrollPane textViewArea = new JScrollPane(textView);
        
        textViewArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        add(textViewArea);
        
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton showOptions = new JButton("Buscar y Reemplazar");
        showOptions.setSize(200, 100);
        buttons.add(showOptions);
        add(buttons);
    }
    
    public static void main (String[] args) {
        new TextToWork();
    }
}
