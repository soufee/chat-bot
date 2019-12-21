package mainpack

import java.awt.*
import java.awt.event.*
import java.lang.Exception
import javax.swing.*
import javax.swing.text.SimpleAttributeSet
import javax.swing.text.StyledDocument

class SimpleChatBot : JFrame(), ActionListener {
    val TITLE_OF_PROGRAM = "Chatter: simple chatbot"
    val START_LOCATION = 200
    val WINDOW_WIDTH = 350
    val WINDOW_HEIGHT = 450
    var dialogue: JTextArea
    var ai: JCheckBox
    var message: JTextField
    //var sbot: SimpleBot

    init {
        title = TITLE_OF_PROGRAM
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        bounds = Rectangle(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT)

        dialogue = JTextArea()
        dialogue.lineWrap = true
        val scrollBar = JScrollPane(dialogue)
        add(BorderLayout.CENTER, scrollBar)

        val bp = JPanel()
        bp.layout = BoxLayout(bp, BoxLayout.X_AXIS)
        ai = JCheckBox("AI")
        //ai.doClick()
        message = JTextField()
        // message.addActionListener(this)
        val enter = JButton("Enter")
        enter.addActionListener(this)
        bp.add(ai)
        bp.add(message)
        bp.add(enter)
        add(BorderLayout.CENTER, scrollBar)
        add(BorderLayout.SOUTH, bp)
        isVisible = true

    }

    override fun actionPerformed(e: ActionEvent?) {
        if (message.text.trim().length > 0) {
            dialogue.append("me_: ${message.text}\n")
        }
        message.text = ""
        message.requestFocusInWindow()
    }
}
