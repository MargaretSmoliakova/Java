

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Маргарита on 30.01.2017.
 */
public class GUI {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel panelForList = new JPanel();
        JPanel panelBottom = new JPanel();

        JLabel label;
        MyTableModel tableMy;
        JButton buttonAddRow = new JButton("Добавить");

        private DefaultListModel<String> defaultListModel = new DefaultListModel<>();

        String[] headers = {"Флаг страны", "Страны", "Столица", "Цена", "Выбрать"};
        String[] countries = {"Германия", "Франция", "Бельгия", "Латвия", "Россия", "Австрия", "Филиппины", "Аргентина"};
        String[] capitals = {"Берлин", "Париж", "Брюссель", "Рига", "Москва", "Вена", "Манила", "Буэнос-Айрес"};
        String[] prices = {"67.30", "55.90", "80.0", "30.50", "798.34", "45.00", "678.56", "843.60"};
        Object[][] strings = new Object[6][];

        JTable table;

        double sumPrice;

        private Map<String, ImageIcon> imageMap;
        private Map<String, String> capitalsMap;
        private Map<String, String> pricesMap;

    public GUI() {

// table and maps creation
        imageMap = createImageMap();
        capitalsMap = createCapitalsMap();
        pricesMap = createPriceMap();
        label = new JLabel("Сумма поездки составляет: 0.0$");

        int i = 0;
        for (int j = 0; j < strings.length; j++) {
            Object object = countries[i];
            strings[j] = new Object[]{imageMap.get(object), object, capitalsMap.get(object), pricesMap.get(object), false};
            i++;
        }

        tableMy = new MyTableModel(strings, headers);
        table = new JTable(tableMy);

// frame creation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setTitle("11.2");
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("smile.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        frame.setIconImage(imageIcon.getImage());
        frame.setResizable(true);
        frame.setSize(500, 500);

// panels and elements creation

        panel.add(panelForList);
        panelForList.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        panel.add(panelBottom);
        panelBottom.setBorder(BorderFactory.createEmptyBorder(20, 10, 30, 10));
        frame.add(panel);

        panel.setLayout(new BorderLayout());
        panel.add(panelForList, BorderLayout.NORTH);
        panel.add(panelBottom, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400,350));
        table.setRowHeight(60);
        table.setRowMargin(2);

        panelForList.setLayout(new BorderLayout());
        panelBottom.setLayout(new BorderLayout());

        panelForList.add(scrollPane);
        panelBottom.add(label, BorderLayout.CENTER);
        panelBottom.add(buttonAddRow, BorderLayout.EAST);

// adding listeners

        tableMy.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                //JOptionPane.showMessageDialog(null, "column: " + e.getColumn() + " row" + e.getFirstRow());

                if (e.getColumn() == 4) {

                    double tempDouble = 0.00;
                    try {
                        tempDouble = Double.parseDouble((String)table.getValueAt(e.getFirstRow(), e.getColumn() - 1));
                    } catch (NumberFormatException el) {
                        JOptionPane.showMessageDialog(null, "\nВы не ввели стоимость поездки в добавленную страну.\nМы изменили стоимость на 0.00$.\n\nИзменить стоимость поездки возможно в случае, когда страна не выбрана.", "Информационное сообщение", JOptionPane.INFORMATION_MESSAGE);
                        tableMy.setValueAt("0.00", e.getFirstRow(), e.getColumn() - 1);
                    }
                    boolean tempBoolean = (boolean)table.getValueAt(e.getFirstRow(), e.getColumn());

                    if (tempBoolean) {
                        sumPrice = Math.round((sumPrice + tempDouble) * 100);
                        sumPrice /= 100;
                    }
                    else if (!tempBoolean) {
                        sumPrice = Math.round((sumPrice - tempDouble) * 100);
                        sumPrice /= 100;
                    }

                    label.setText("Сумма поездки составляет: " + Double.toString(sumPrice) + "$");
                }
            }
        });

        buttonAddRow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableMy.addRow(new Object[] {new ImageIcon("images\\Страна.png"), "Страна", "Столица", "Цена", false});
            }
        });

        frame.setVisible(true);
    }

    private Map<String, ImageIcon> createImageMap() {
        Map<String, ImageIcon> map = new HashMap<>();

        for (String s : countries) {
            map.put(s, new ImageIcon(("images\\" + s + ".png")));
        }

        return map;
    }

    private Map<String, String> createCapitalsMap() {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) map.put(countries[i], capitals[i]);

        return map;
    }

    private Map<String, String> createPriceMap() {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) map.put(countries[i], prices[i]);

        return map;
    }
}
