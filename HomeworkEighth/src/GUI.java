import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JOptionPane;

public class GUI {

// var-s for main window
    private JFrame frame;
    private JPanel panel;
    private JPanel panelMainForGrid;
    private JPanel panelForButton;

    private Label labelChooseProgression;
    private Label labelChooseFile;
    private Label labelEnterSerialNumber;
    private Label labelProgression;
    private Label labelSumProgression;
    private Label labelElementProgression;
    private JComboBox chooseProgressionUser;
    private JComboBox chooseFileUser;
    private JTextField serialNumberUser;
    private JTextField progressionUser;
    private JTextField sumProgressionUser;
    private JTextField elementProgressionUser;
    private Button buttonFiling;

    String[] chooseProgression = new String[]{"- не выбрано -", "арифметическая", "геометрическая"};
    String[] chooseFile = new String[]{"- не выбрано -", "Liner.txt", "Exponential.txt"};

// var-s for dialog box
    private JFrame dialogBoxFrame;
    private JPanel dialogBoxPanel;
    private JPanel dialogBoxGridPanel;
    private JPanel dialogBoxButtonPanel;

    private Label dialogBoxLabelStartElement;
    private Label dialogBoxLabelNumberOfElements;
    private Label dialogBoxLabelCommonRatio;
    private JTextField dialogBoxStartElementUser;
    private JTextField dialogBoxNumberOfElementsUser;
    private JTextField dialogBoxCommonRatioUser;
    private Button dialogBoxButtonOk;

// var-s for functionality
    Series progression;
    int indexOfChosenProgression;
    int commonRatio;

    public GUI(String title, String imageIconPath) {

// creating frames and setting their properties
        frame = new JFrame();
        panel = new JPanel();
        panelMainForGrid = new JPanel();
        panelForButton = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FrameCreation frameCreation = new FrameCreation(title, imageIconPath, 80, 80, true, 700, 300, frame);
        PanelCreation panelCreation = new PanelCreation(frame, panel, panelMainForGrid, 6, 2, panelForButton, 30, 20, 30, 20);

        dialogBoxFrame = new JFrame();
        dialogBoxPanel = new JPanel();
        dialogBoxGridPanel = new JPanel();
        dialogBoxButtonPanel = new JPanel();

        FrameCreation dialogBoxFrameCreation = new FrameCreation("Дополнительные параметры", imageIconPath, 80, 80, false, 400, 170, dialogBoxFrame);
        PanelCreation dialogBoxPanelCreation = new PanelCreation(dialogBoxFrame, dialogBoxPanel, dialogBoxGridPanel, 3, 2, dialogBoxButtonPanel, 5, 5, 10, 15);

// creating elements and adding button (main window)
        labelChooseProgression = new Label();
        LabelCreation labelChooseProgressionCreation = new LabelCreation("Выберите прогрессию: ", 170, 30, 14, labelChooseProgression);
        labelChooseFile = new Label();
        LabelCreation labelChooseFileCreation = new LabelCreation("Выберите файл: ", 170, 30, 14, labelChooseFile);
        labelEnterSerialNumber = new Label();
        LabelCreation labelEnterSerialNumberCreation = new LabelCreation("Введите порядковый номер эл. прогрессии: ", 330, 30, 14, labelEnterSerialNumber);
        labelProgression = new Label();
        LabelCreation labelProgressionCreation = new LabelCreation("Прогрессия: ", 170, 30, 14, labelProgression);
        labelSumProgression = new Label();
        LabelCreation labelSumProgressionCreation = new LabelCreation("Сумма эл. прогрессии: ", 170, 30, 14, labelSumProgression);
        labelElementProgression = new Label();
        LabelCreation labelElementProgressionCreation = new LabelCreation("Элемент прогрессии по порядковому номеру: ", 340, 30, 14, labelElementProgression);
        chooseProgressionUser = new JComboBox(chooseProgression);
        chooseFileUser = new JComboBox(chooseFile);
        serialNumberUser = new JTextField("порядковый номер ...");
        progressionUser = new JTextField();
        sumProgressionUser = new JTextField();
        elementProgressionUser = new JTextField();
        buttonFiling = new Button("Записать прогрессию в файл");

        panelMainForGrid.add(labelChooseProgression);
        panelMainForGrid.add(chooseProgressionUser);
        panelMainForGrid.add(labelChooseFile);
        panelMainForGrid.add(chooseFileUser);
        panelMainForGrid.add(labelEnterSerialNumber);
        panelMainForGrid.add(serialNumberUser);
        panelMainForGrid.add(labelProgression);
        panelMainForGrid.add(progressionUser);
        panelMainForGrid.add(labelSumProgression);
        panelMainForGrid.add(sumProgressionUser);
        panelMainForGrid.add(labelElementProgression);
        panelMainForGrid.add(elementProgressionUser);
        panelForButton.add(buttonFiling, BorderLayout.EAST);

        frame.setVisible(true);

// creating and adding labels and button
        dialogBoxLabelStartElement = new Label();
        LabelCreation dialogBoxlabelChooseProgressionCreation = new LabelCreation("Первый элемент: ", 170, 30, 14, dialogBoxLabelStartElement);
        dialogBoxLabelNumberOfElements = new Label();
        LabelCreation dialogBoxlabelChooseFileCreation = new LabelCreation("Количество элементов: ", 170, 30, 14, dialogBoxLabelNumberOfElements);
        dialogBoxLabelCommonRatio = new Label();
        LabelCreation dialogBoxlabelEnterSerialNumberCreation = new LabelCreation("Шаг: ", 330, 30, 14, dialogBoxLabelCommonRatio);
        dialogBoxStartElementUser = new JTextField();
        dialogBoxNumberOfElementsUser = new JTextField();
        dialogBoxCommonRatioUser = new JTextField();
        dialogBoxButtonOk = new Button("OK");

        dialogBoxGridPanel.add(dialogBoxLabelStartElement);
        dialogBoxGridPanel.add(dialogBoxStartElementUser);
        dialogBoxGridPanel.add(dialogBoxLabelNumberOfElements);
        dialogBoxGridPanel.add(dialogBoxNumberOfElementsUser);
        dialogBoxGridPanel.add(dialogBoxLabelCommonRatio);
        dialogBoxGridPanel.add(dialogBoxCommonRatioUser);
        dialogBoxButtonPanel.add(dialogBoxButtonOk, BorderLayout.EAST);

    }

    public void setFunctionality () {

// main window
        chooseProgressionUser.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (chooseProgressionUser.getSelectedIndex() == 1 || chooseProgressionUser.getSelectedIndex() == 2) {
                    dialogBoxFrame.setVisible(true);
                    indexOfChosenProgression = chooseProgressionUser.getSelectedIndex();
                }
            }
        });

        serialNumberUser.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                serialNumberUser.selectAll();
            }
        });

        serialNumberUser.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                if (!serialNumberUser.getText() .equals("") && progression != null) {
                    try {
                        int justInt = Integer.parseInt(serialNumberUser.getText());
                        int certainElement = (int) progression.getCertainElement(justInt, commonRatio);
                        elementProgressionUser.setText(Integer.toString(certainElement));
                    } catch (NumberFormatException e1) {
                        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                            serialNumberUser.setText("");
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректный порядковый номер...", "Ошибка", JOptionPane.ERROR_MESSAGE);
                            serialNumberUser.setText("");
                        }
                    }
                }
                else if (progression == null) {
                    JOptionPane.showMessageDialog(null, "Нобходимо сформировать прогрессию...", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    serialNumberUser.setText("");
                }

            }
        });

        buttonFiling.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int index = chooseFileUser.getSelectedIndex();

                if (index == 1 && progression != null) {
                    try {
                        progression.savingToFile("C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkEighth1\\Liner.txt");
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "Проблема с файлом Liner.txt (файла не существует или неправильно указан путь)", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else if(index == 2 && progression != null) {
                    try {
                        progression.savingToFile("C:\\ALL\\PROGRAMMING\\JavaProgramming\\HomeworkEighth1\\Exponential.txt");
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "Проблема с файлом Exponential.txt (файла не существует или неправильно указан путь)", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                }

                if ((index == 1 || index == 2) && progression != null) {
                    JOptionPane.showMessageDialog(null, "Прогрессия записана!", "Информационное сообщение", JOptionPane.INFORMATION_MESSAGE);
                }
                else JOptionPane.showMessageDialog(null, "Необходимо сформировать прогрессию и(или) выбрать файл для записи...", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });

// dialogBox
        dialogBoxButtonOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                try {
                    if (indexOfChosenProgression == 1) {

                        progression = new Liner((Integer.parseInt(dialogBoxStartElementUser.getText())));
                        commonRatio = Integer.parseInt(dialogBoxCommonRatioUser.getText());
                        progression.setProgressionElements(Integer.parseInt(dialogBoxNumberOfElementsUser.getText()), commonRatio);

                    } else if (indexOfChosenProgression == 2) {

                        progression = new Exponential(Integer.parseInt(dialogBoxStartElementUser.getText()));
                        commonRatio = Integer.parseInt(dialogBoxCommonRatioUser.getText());
                        progression.setProgressionElements(Integer.parseInt(dialogBoxNumberOfElementsUser.getText()), commonRatio);
                    }

                progressionUser.setText(progression.toString());
                sumProgressionUser.setText(Integer.toString((int) progression.getSumOfElements()));

                dialogBoxFrame.setVisible(false);
                } catch (NumberFormatException el) {
                    JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректное числовое представление параметров прогрессии...", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    dialogBoxStartElementUser.setText("");
                    dialogBoxCommonRatioUser.setText("");
                    dialogBoxNumberOfElementsUser.setText("");
                }
            }
        });
    }

}
