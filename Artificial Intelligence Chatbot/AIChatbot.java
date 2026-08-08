import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Chatbot {

    public String getResponse(String input) {

        input = input.toLowerCase().trim();

        input = input.replaceAll("[^a-zA-Z0-9 ]", "");


        if (input.contains("hello") ||
            input.contains("hi") ||
            input.contains("hey")) {

            return "Hello! How can I help you?";
        }


        else if (input.contains("how are you")) {

            return "I am doing great! Thanks for asking.";
        }

        else if (input.contains("your name") ||
                 input.contains("who are you")) {

            return "I am an AI Chatbot created using Java.";
        }


        else if (input.contains("what is ai") ||
                 input.contains("artificial intelligence")) {

            return "AI stands for Artificial Intelligence. " +
                   "It enables computers to perform tasks that normally require human intelligence.";
        }

        else if (input.contains("what is nlp") ||
                 input.contains("natural language processing")) {

            return "NLP stands for Natural Language Processing. " +
                   "It helps computers understand and process human language.";
        }

        else if (input.contains("what is java")) {

            return "Java is a popular object-oriented programming language " +
                   "used for web, desktop, mobile, and enterprise applications.";
        }


        else if (input.contains("what is oop") ||
                 input.contains("object oriented")) {

            return "OOP stands for Object-Oriented Programming. " +
                   "Its main concepts include classes, objects, inheritance, " +
                   "polymorphism, abstraction, and encapsulation.";
        }

        else if (input.contains("machine learning") ||
                 input.contains("what is ml")) {

            return "Machine Learning is a branch of AI that allows computers " +
                   "to learn patterns from data and make predictions.";
        }


        else if (input.contains("programming")) {

            return "Programming is the process of writing instructions " +
                   "that tell a computer how to perform a task.";
        }

   
        else if (input.contains("college") ||
                 input.contains("university")) {

            return "College is a place where students learn academic " +
                   "and professional skills.";
        }


        else if (input.contains("help")) {

            return "You can ask me about AI, NLP, Java, OOP, Machine Learning, " +
                   "programming, or general questions.";
        }


        else if (input.contains("thank you") ||
                 input.contains("thanks")) {

            return "You're welcome! Happy to help.";
        }


        else if (input.contains("bye") ||
                 input.contains("goodbye")) {

            return "Goodbye! Have a great day!";
        }


        else {

            return "Sorry, I don't understand that yet. " +
                   "Try asking me about AI, NLP, Java, OOP, or Machine Learning.";
        }
    }
}


public class AIChatbot extends JFrame implements ActionListener {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;
    Chatbot chatbot;

    AIChatbot() {

        chatbot = new Chatbot();

        setTitle("Artificial Intelligence Chatbot");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel heading = new JLabel(
                "Artificial Intelligence Chatbot",
                SwingConstants.CENTER
        );

        heading.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        add(heading, BorderLayout.NORTH);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        chatArea.append(
                "Bot: Hello! I am your AI Chatbot.\n"
        );

        chatArea.append(
                "Bot: Ask me something!\n\n"
        );

        JScrollPane scrollPane =
                new JScrollPane(chatArea);

        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel =
                new JPanel(new BorderLayout(5, 5));

        inputField = new JTextField();

        sendButton =
                new JButton("Send");

        bottomPanel.add(
                inputField,
                BorderLayout.CENTER
        );

        bottomPanel.add(
                sendButton,
                BorderLayout.EAST
        );

        add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        sendButton.addActionListener(this);

  
        inputField.addActionListener(this);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String userInput =
                inputField.getText().trim();

        if (userInput.isEmpty()) {
            return;
        }


        chatArea.append(
                "You: " + userInput + "\n"
        );


        String response =
                chatbot.getResponse(userInput);

        chatArea.append(
                "Bot: " + response + "\n\n"
        );

        inputField.setText("");
    }


    public static void main(String[] args) {

        new AIChatbot();
    }
}
