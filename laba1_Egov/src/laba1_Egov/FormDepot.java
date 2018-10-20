package laba1_Egov;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormDepot extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    private ITransport transport;
    private Depot<ITransport> depot;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormDepot frame = new FormDepot();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public FormDepot() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 458);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanelDepot panelDepot = new JPanelDepot();
        panelDepot.setBounds(10, 11, 608, 398);
        contentPane.add(panelDepot);

        depot = new Depot<ITransport>(15, panelDepot.getWidth(), panelDepot.getHeight());
        panelDepot.setDepot(depot);

        JButton buttonSetElectricLocomotive = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043C\u043E\u043D\u043E\u0440\u0435\u043B\u044C\u0441");
        buttonSetElectricLocomotive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Color firstColor = JColorChooser.showDialog(null, "Choose a Color", Color.WHITE);
                Color secondColor = JColorChooser.showDialog(null, "Choose a Color", Color.WHITE);
                transport = new Monorail(100 + (int) (Math.random() * 300), 1000 +
                        (int) (Math.random() * 2000), firstColor, secondColor, true,
                        true, true, 1000);
                depot.addTransport(transport);
                panelDepot.repaint();
            }
        });
        buttonSetElectricLocomotive.setBounds(648, 21, 206, 68);
        contentPane.add(buttonSetElectricLocomotive);

        JButton buttonSetMonorail = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043B\u043E\u043A\u043E\u043C\u043E\u0442\u0438\u0432");
        buttonSetMonorail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Color firstColor = JColorChooser.showDialog(null, "Choose a Color", Color.WHITE);
                transport = new ElectricLocomotive(100 + (int) (Math.random() * 300), 1000 +
                        (int) (Math.random() * 2000), firstColor);
                depot.addTransport(transport);
                panelDepot.repaint();
            }
        });
        buttonSetMonorail.setBounds(648, 100, 206, 68);
        contentPane.add(buttonSetMonorail);

        JPanel panelGroupElements = new JPanel();
        panelGroupElements.setBounds(648, 204, 206, 205);
        contentPane.add(panelGroupElements);
        panelGroupElements.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u041C\u0435\u0441\u0442\u043E");
        lblNewLabel.setBounds(10, 14, 40, 14);
        panelGroupElements.add(lblNewLabel);

        JPanelDraw panelTakeTrain = new JPanelDraw();
        panelTakeTrain.setBounds(10, 72, 186, 122);
        panelGroupElements.add(panelTakeTrain);

        JButton buttonTakeTrain = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C \u0441\u043E\u0441\u0442\u0430\u0432");
        buttonTakeTrain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int numberOfPlace = 0;
                try {
                    numberOfPlace = Integer.parseInt(textField.getText());
                } catch (Exception ex)
                {
                    textField.setText("Invalid input");
                    return;
                }

                if (numberOfPlace >= depot._places.size() || numberOfPlace < 0)
                {
                    textField.setText("Invalid input");
                    return;
                }

                transport = depot.removeTransport(numberOfPlace);
                if (transport != null) {
                    transport.SetPosition(5, 5, panelTakeTrain.getWidth(), panelTakeTrain.getHeight());
                }

                panelTakeTrain.setTransport(transport);
                panelTakeTrain.repaint();
                panelDepot.repaint();
            }
        });
        buttonTakeTrain.setBounds(10, 39, 186, 23);
        panelGroupElements.add(buttonTakeTrain);

        textField = new JTextField();
        textField.setBounds(60, 11, 136, 20);
        panelGroupElements.add(textField);
        textField.setColumns(10);
    }
}

