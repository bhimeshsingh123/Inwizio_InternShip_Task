import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Task {
    private String title;
    private String status;

    public Task(String title) {
        this.title = title;
        this.status = "New"; // Default status
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return title + " - " + status;
    }
}

public class ToDoListApp {
    private DefaultListModel<Task> listModel;
    private JList<Task> taskList;
    private JTextArea taskArea;
    private JComboBox<String> statusBox;

    public ToDoListApp() {
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        taskArea = new JTextArea(3, 20);
        JScrollPane taskScrollPane = new JScrollPane(taskArea);

        statusBox = new JComboBox<>(new String[] { "New", "In Progress", "Completed", "Cancelled" });
        JButton addButton = new JButton("Add Task");
        JButton editButton = new JButton("Edit Task");
        JButton removeButton = new JButton("Remove Task");
        JButton showButton = new JButton("Show All");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(taskScrollPane, BorderLayout.NORTH);
        inputPanel.add(statusBox, BorderLayout.SOUTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(showButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskTitle = taskArea.getText().trim();
                if (!taskTitle.isEmpty()) {
                    listModel.addElement(new Task(taskTitle));
                    taskArea.setText("");
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Task selectedTask = listModel.get(selectedIndex);
                    String newTitle = taskArea.getText().trim();
                    String newStatus = (String) statusBox.getSelectedItem();
                    if (!newTitle.isEmpty()) {
                        selectedTask.setTitle(newTitle);
                    }
                    selectedTask.setStatus(newStatus);
                    taskList.repaint();
                    taskArea.setText("");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder tasks = new StringBuilder("Tasks:\n");
                for (int i = 0; i < listModel.size(); i++) {
                    tasks.append(i + 1).append(". ").append(listModel.get(i).toString()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, tasks.toString(), "Task List", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoListApp());
    }
}
