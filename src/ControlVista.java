import javax.swing.*;


public class ControlVista extends JFrame {
    public ControlVista(Controlll cs)

    {
        super("Control Del Punto de Vista");
        Double min1 = new Double(-90.0);
        Double max1 = new Double(90.0);
        Double inic1 = new Double(0.0);
        Double paso1 = new Double(2);

        Double min2 = new Double(-50.0);
        Double max2 = new Double(50.0);
        Double inic2 = new Double(0.0);
        Double paso2 = new Double(2);

        Double min3 = new Double(-1.8);
        Double max3 = new Double(5.8);
        Double inic3 = new Double(0.0);
        Double paso3 = new Double(0.1);

        Double min4 = new Double(-10000000.0);
        Double max4 = new Double(10000000.0);
        Double inic4 = new Double(0.0);
        Double paso4 = new Double(0.1);

        Double min5 = new Double(-1000000000.0);
        Double max5 = new Double(100000000000.0);
        Double inic5 = new Double(0.0);
        Double paso5 = new Double(5.0);

        SpinnerNumberModel controlNum1 = new SpinnerNumberModel(inic1, min1, max1, paso1);

        SpinnerNumberModel controlNum2 = new SpinnerNumberModel(inic2, min2, max2, paso2);

        SpinnerNumberModel controlNum3 = new SpinnerNumberModel(inic3, min3, max3, paso3);

        SpinnerNumberModel controlNum4 = new SpinnerNumberModel(inic4, min4, max4, paso4);

        SpinnerNumberModel controlNum5 = new SpinnerNumberModel(inic5, min5, max5, paso5);

        JSpinner controlEjeX = new JSpinner(controlNum1);

        JSpinner controlEjeY = new JSpinner(controlNum2);

        JSpinner controlEjeZ = new JSpinner(controlNum3);

        JSpinner controlEjeD = new JSpinner(controlNum4);

        JSpinner controlEjeE = new JSpinner(controlNum5);

        JPanel panel = new JPanel();

        JLabel etq1 = new JLabel("Girar Punto de Vista");
        panel.add(etq1);
        panel.add(controlEjeX);

        JLabel etq2 = new JLabel("Elevacion del Punto de Vista +-");
        panel.add(etq2);
        panel.add(controlEjeY);

        JLabel etq3 = new JLabel("Subir o Bajar el Punto de Vista");
        panel.add(etq3);
        panel.add(controlEjeZ);

        JLabel etq4 = new JLabel("Acercarse o Alejarse");
        panel.add(etq4);
        panel.add(controlEjeD);

        JLabel etq5 = new JLabel("Avanzar o Retroceder");
        panel.add(etq5);
        panel.add(controlEjeE);

        controlEjeX.setName("girar");

        controlEjeY.setName("elevar");

        controlEjeZ.setName("subirBajar");

        controlEjeD.setName("alejarAcercar");

        controlEjeE.setName("avanzarRetroceder");

        controlEjeX.addChangeListener(cs);

        controlEjeY.addChangeListener(cs);

        controlEjeZ.addChangeListener(cs);

        controlEjeD.addChangeListener(cs);

        controlEjeE.addChangeListener(cs);

        this.getContentPane().add(panel);
        this.pack();
    }
}