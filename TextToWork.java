import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextToWork extends JFrame {

    private final int ancho = 600;
    private final int largo = 600;

    private final int topSpace = 5;
    private final int leftSpace = 5;
    private final int bottomSpace = 5;
    private final int rightSpace = 5;

    private final JPanel textPanel = new JPanel(new BorderLayout());
    private final JPanel textViewPanel = new JPanel(new BorderLayout());
    private final JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));

    private final JLabel indication = new JLabel("Inserte su texto aqui:");
    private final JLabel indication2 = new JLabel("Su texto:");

    private final JTextArea text = new JTextArea();
    private final JTextArea textView = new JTextArea();

    private final JScrollPane textArea = new JScrollPane(text);
    private final JScrollPane textViewArea = new JScrollPane(textView);

    private final JButton showOptions = new JButton("Buscar y Reemplazar");

    private final EmptyBorder border = new EmptyBorder(topSpace, leftSpace, bottomSpace, rightSpace);

    private final FindAndReplace operations = new FindAndReplace();

    public TextToWork() {
        this.setSize(ancho, largo);
        this.setTitle("Find and Replace");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1));
        this.setResizable(false);

        this.showOptions.setSize(200, 100);

        //las siguientes 5 lineas se refieren a que las cajas de texto se ajustara al JFrame, es decir, hará un salto de linea si ya ocupó todo el ancho.
        this.text.setLineWrap(true);
        this.text.setWrapStyleWord(true);
        this.textView.setLineWrap(true);
        this.textView.setWrapStyleWord(true);
        this.textView.setEditable(false);

        //las siguientes 5 lineas se usan para crear espacios alrededor de los objetos especificados
        this.indication.setBorder(border);
        this.textArea.setBorder(border);
        this.indication2.setBorder(border);
        this.textViewArea.setBorder(border);
        this.buttons.setBorder(border);
        
        //estas 2 líneas agregan una barra de desplazamiento vertical a las caja de texto (JScrollPane) 
        textArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textViewArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        build();
        setVisible(true);
    }

    private void build() {

        buildListeners();

        textPanel.add(indication, BorderLayout.NORTH);
        textPanel.add(textArea, BorderLayout.CENTER);

        this.add(textPanel);

        buttons.add(showOptions);

        textViewPanel.add(indication2, BorderLayout.NORTH);
        textViewPanel.add(textViewArea, BorderLayout.CENTER);
        textViewPanel.add(buttons, BorderLayout.SOUTH);

        this.add(textViewPanel);
    }

    private void buildListeners() {

        this.operations.getExecute().addActionListener((ActionEvent e) -> {
            String wordToFind = operations.wordToFind();
            
            if (operations.getExecute().getText().equals("Buscar")) {

            } 
            else if (operations.getExecute().getText().equals("Reemplazar")) {
                String wordForReplace = operations.wordForReplace();
            }
            
            operations.cleanTextBoxes();
        });

        this.showOptions.addActionListener((ActionEvent e) -> {
            this.operations.setVisible(true);
            this.setEnabled(false);
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
