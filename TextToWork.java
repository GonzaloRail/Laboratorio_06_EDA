import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class TextToWork extends JFrame {
    private final int ancho = 700;
    private final int largo = 400;
    
    private final FindAndReplace operations = new FindAndReplace();
    
    public TextToWork() {
        this.setSize(ancho, largo);
        this.setTitle("Find and Replace");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));
        build();
        setVisible(true);
    }
    
    private void build() {
        
        JPanel textPanel = new JPanel(new BorderLayout());
        JLabel indication = new JLabel("Inserte su texto aqui:");
        JTextArea text = new JTextArea();
        text.setLineWrap(true); 
        text.setWrapStyleWord(true);
        
        JScrollPane textArea = new JScrollPane(text);
        
        textPanel.add(indication, BorderLayout.NORTH);
        textPanel.add(textArea, BorderLayout.CENTER);
        
        textArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        int topSpace = 5;
        int leftSpace = 5;
        int bottomSpace = 5;
        int rightSpace = 5;
        EmptyBorder border = new EmptyBorder(topSpace, leftSpace, bottomSpace, rightSpace);
        
        indication.setBorder(border);
        textArea.setBorder(border);
        
        add(textPanel);
        
        JPanel textViewPanel = new JPanel(new BorderLayout());
        JLabel indication2 = new JLabel("Su texto:");
        JTextArea textView = new JTextArea();
        textView.setLineWrap(true); 
        textView.setWrapStyleWord(true);
        textView.setEditable(false);
        
        JScrollPane textViewArea = new JScrollPane(textView);
        
        textViewArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        textViewPanel.add(indication2, BorderLayout.NORTH);
        textViewPanel.add(textViewArea, BorderLayout.CENTER);
        
        indication2.setBorder(border);
        textViewArea.setBorder(border);
        
        add(textViewPanel);
        
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
