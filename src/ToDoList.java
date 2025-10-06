import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoList extends JFrame implements ActionListener {

    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;
    private JButton addButton, deleteButton, clearButton;

    public ToDoList() {
        // Frame setup
        setTitle("To-Do List");
        setSize(400, 450);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        JLabel title = new JLabel("📝 To-Do List");
        title.setBounds(120, 20, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        add(title);

        // Input field
        taskInput = new JTextField();
        taskInput.setBounds(40, 70, 220, 30);
        taskInput.setBackground(Color.DARK_GRAY);
        taskInput.setForeground(Color.WHITE);
        taskInput.setCaretColor(Color.WHITE);
        taskInput.setFont(new Font("Arial", Font.PLAIN, 14));
        add(taskInput);

        // Add Button
        addButton = new JButton("Add");
        addButton.setBounds(280, 70, 80, 30);
        addButton.setBackground(new Color(0, 102, 204)); // Blue
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(this);
        add(addButton);

        // Task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setBackground(Color.WHITE);
        taskList.setForeground(Color.BLACK);
        taskList.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(40, 120, 320, 200);
        add(scrollPane);

        // Buttons
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(40, 340, 120, 40);
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.addActionListener(this);
        add(deleteButton);

        clearButton = new JButton("Clear All");
        clearButton.setBounds(240, 340, 120, 40);
        clearButton.setBackground(new Color(0, 102, 204));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.addActionListener(this);
        add(clearButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInput.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Enter a task first!");
            }
        } else if (e.getSource() == deleteButton) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Select a task to delete!");
            }
        } else if (e.getSource() == clearButton) {
            int confirm = JOptionPane.showConfirmDialog(this, "Clear all tasks?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                taskListModel.clear();
            }
        }
    }

    public static void main(String[] args) {
        new ToDoList();
    }
}
