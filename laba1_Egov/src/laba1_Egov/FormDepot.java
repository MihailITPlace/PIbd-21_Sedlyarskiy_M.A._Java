package laba1_Egov;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FormDepot extends JFrame {

    JFrame frame;
    private JPanel contentPane;
    private JTextField textField;
    private static JList list;

    private ITransport transport;
    private MultiLevelDepot depot;

    private final int countLevel = 5;

    private FormTrainConfig select;
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

    public void getTrain() {
        select = new FormTrainConfig(frame);
        if (select.res()) {
            ITransport train = select.train;
            int place = depot.getAt(list.getSelectedIndex()).addTransport(train);
            if (place < 0) {
                JOptionPane.showMessageDialog(null, "No free place");
            }
        }
    }

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

        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < countLevel; i++) {
            listModel.addElement("\u0423\u0440\u043E\u0432\u0435\u043D\u044C " + Integer.toString(i + 1));
        }

        list = new JList(listModel);
        list.setBounds(648, 11, 206, 107);
        contentPane.add(list);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setSelectedIndex(0);

        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //panelDepot.setList(list);
                panelDepot.repaint();
            }
        };
        list.addListSelectionListener(listSelectionListener);

        depot = new MultiLevelDepot(countLevel, panelDepot.getWidth(), panelDepot.getHeight());
        panelDepot.setDepot(depot);
        panelDepot.setList(list);

        JButton buttonAddTrain = new JButton("Add train");
        buttonAddTrain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                getTrain();
                panelDepot.repaint();
            }
        });
        buttonAddTrain.setBounds(648, 130, 206, 70);
        contentPane.add(buttonAddTrain);

        JPanel panelGroupElements = new JPanel();
        panelGroupElements.setBounds(648, 232, 206, 177);
        contentPane.add(panelGroupElements);
        panelGroupElements.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u041C\u0435\u0441\u0442\u043E");
        lblNewLabel.setBounds(10, 14, 31, 14);
        panelGroupElements.add(lblNewLabel);

        JPanelDraw panelTakeTrain = new JPanelDraw();
        panelTakeTrain.setBounds(10, 73, 186, 93);
        panelGroupElements.add(panelTakeTrain);

        JButton buttonTakeTrain = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C \u0441\u043E\u0441\u0442\u0430\u0432");
        buttonTakeTrain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (list.getSelectedIndex() == -1) {
                    return;
                }

                int numberOfPlace = 0;
                try {
                    numberOfPlace = Integer.parseInt(textField.getText());
                } catch (Exception ex)
                {
                    textField.setText("Invalid input");
                    return;
                }

                if (numberOfPlace >= depot.getAt(list.getSelectedIndex())._places.size() || numberOfPlace < 0)
                {
                    textField.setText("Invalid input");
                    return;
                }

                transport = depot.getAt(list.getSelectedIndex()).removeTransport(numberOfPlace);
                if (transport != null) {
                    transport.SetPosition(5, 5, panelTakeTrain.getWidth(), panelTakeTrain.getHeight());
                }

                panelTakeTrain.setTransport(transport);
                panelTakeTrain.repaint();
                panelDepot.repaint();
            }
        });
        buttonTakeTrain.setBounds(20, 39, 176, 23);
        panelGroupElements.add(buttonTakeTrain);

        textField = new JTextField();
        textField.setBounds(60, 11, 136, 20);
        panelGroupElements.add(textField);
        textField.setColumns(10);
    }
}

