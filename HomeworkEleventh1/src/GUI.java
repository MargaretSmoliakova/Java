import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Маргарита on 27.01.2017.
 */

public class GUI {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel panelForList = new JPanel();
    JPanel panelBottom = new JPanel();

    JLabel label;

    private DefaultListModel<String> defaultListModel = new DefaultListModel<>();
    String[] strings = {"Германия", "Франция", "Бельгия", "Латвия", "Россия", "Австрия", "Филиппины", "Аргентина"};
    String[] capitals = {"Берлин", "Париж", "Брюссель", "Рига", "Москва", "Вена", "Манила", "Буэнос-Айрес"};
    JList list = new JList(strings);

    private final Map<String, ImageIcon> imageMap;
    private final Map<String, String> capitalsMap;

    public GUI() {

// frame creation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setTitle("11.1");
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

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(400, 350));
        list.setBorder(new EmptyBorder(10, 20, 20, 10));

        label = new JLabel("Здесь будет отображаться выбранный Вами элемент...");

        imageMap = createImageMap();
        capitalsMap = createCapitalsMap();

        ListCellRenderer myRenderer = new MyListCellRenderer();
        list.setCellRenderer(myRenderer);

        panelForList.add(scrollPane);
        panelBottom.add(label);

        setFunctionality();

        frame.setVisible(true);
    }

    private void setFunctionality () {
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                String chosenElement = list.getSelectedValue().toString();

                label.setText(chosenElement + ", " + capitalsMap.get(chosenElement));
                label.setIcon(imageMap.get(chosenElement));
            }
        });


    }

    public class MyListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setIcon(imageMap.get((String) value));
            label.setHorizontalTextPosition(JLabel.RIGHT);

            return label;
        }
    }

    private Map<String, ImageIcon> createImageMap() {
        Map<String, ImageIcon> map = new HashMap<>();

        for (String s : strings) {
            map.put(s, new ImageIcon("images\\" + s + ".png"));
        }

        return map;
    }

    private Map<String, String> createCapitalsMap() {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) map.put(strings[i], capitals[i]);

        return map;
    }
}
