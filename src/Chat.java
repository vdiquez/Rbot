import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class Chat extends JFrame {
    Proto pt;
    JPanel panel1, panel2, panel21, panel11, panel23;
    JLabel etiqueta;

    public Chat(ControlChat cch, Proto pt, VentanaPanel vp) {
        this.setTitle("Control a Distancia");
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pt = pt;


        etiqueta = new JLabel("Vista Primera Persona");

        GridLayout gl = new GridLayout(1, 2);

        this.getContentPane().setLayout(gl);
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);

        panel1 = new JPanel();
        panel11 = new JPanel();
        panel2 = new JPanel();
        panel21 = new JPanel();
        panel23 = new JPanel();

        panel2.setLayout(new GridLayout(3, 1));
        panel1.setLayout(new GridLayout(0, 1));
        panel11.setLayout(new BorderLayout());
        panel23.setLayout(new GridLayout(3, 2));
        panel11.add("Center", pt.dameCanvas());
        pt.dameCanvas().addKeyListener(cch);
        panel1.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel11.setBorder(new TitledBorder("Vista Primera Persona"));

        panel2.setBorder(new EmptyBorder(10, 0, 10, 0));
        panel23.setBorder(new TitledBorder("Controles"));

        this.getContentPane().add(panel1);
        this.getContentPane().add(panel2);
        panel1.add(panel11);
        panel2.add(panel23);

        JMenuBar barraMenu = new JMenuBar();
        this.setJMenuBar(barraMenu);
        JMenu menuC = new JMenu("Comunicaciones");
        JMenuItem itemDP = new JMenuItem("Ubicacion y Destino");
        itemDP.addActionListener(vp);

        barraMenu.add(menuC);
        menuC.add(itemDP);

        JLabel mVertical = new JLabel("Movimiento Vertical");

        panel23.add(mVertical);

        Double min = new Double(-18);
        Double max = new Double(58);
        Double inic = new Double(0.0);
        Double paso = new Double(1);

        SpinnerNumberModel controlNum = new SpinnerNumberModel(inic, min, max, paso);

        JSpinner mv = new JSpinner(controlNum);

        panel23.add(mv);


        JLabel azmt = new JLabel("Azimut");

        panel23.add(azmt);

        Double min2 = new Double(-90.0);
        Double max2 = new Double(90.0);
        Double inic2 = new Double(0.0);
        Double paso2 = new Double(2);

        SpinnerNumberModel controlNum2 = new SpinnerNumberModel(inic2, min2, max2, paso2);

        JSpinner azim = new JSpinner(controlNum2);

        panel23.add(azim);


        JLabel elv = new JLabel("Elevacion");

        panel23.add(elv);

        Double min4 = new Double(-50.0);
        Double max4 = new Double(50.0);
        Double inic4 = new Double(0.0);
        Double paso4 = new Double(2);

        SpinnerNumberModel controlNum4 = new SpinnerNumberModel(inic4, min4, max4, paso4);

        JSpinner elva = new JSpinner(controlNum4);

        panel23.add(elva);

        mv.setName("movVertical");
        azim.setName("azimut");
        elva.setName("elevacion");

        mv.addChangeListener(cch);

        azim.addChangeListener(cch);

        elva.addChangeListener(cch);

        this.setSize(700, 400);
        this.setVisible(true);
    }
}
