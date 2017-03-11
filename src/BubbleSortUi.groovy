import groovy.swing.SwingBuilder

import static java.awt.GridBagConstraints.CENTER
import static java.awt.GridBagConstraints.EAST
import static java.awt.GridBagConstraints.HORIZONTAL
import static java.awt.GridBagConstraints.NONE
import static java.awt.GridBagConstraints.REMAINDER
import static java.awt.GridBagConstraints.SOUTHEAST
import static javax.swing.JFrame.EXIT_ON_CLOSE

new SwingBuilder().edt {
    frame(
            title: 'Bubble Sort',
            minimumSize: [300, 120],
            pack: true,
            show: true,
            locationRelativeTo: null,
            defaultCloseOperation: EXIT_ON_CLOSE) {
        lookAndFeel 'nimbus'
        gridBagLayout()
        label(
                text: 'List:',
                constraints: gbc(
                        gridx: 0,
                        gridy: 0,
                        gridwidth: 1,
                        gridheight: 1,
                        fill: NONE,
                        anchor: EAST,
                        insets: [5, 5, 0, 0],
                        weightx: 0,
                        weighty: 0
                )
        )
        def listTextField = textField(
                constraints: gbc(
                        gridx: 1,
                        gridy: 0,
                        gridwidth: REMAINDER,
                        gridheight: 1,
                        fill: HORIZONTAL,
                        anchor: CENTER,
                        insets: [5, 5, 0, 5],
                        weightx: 1.0,
                        weighty: 0
                ),
                columns: 30
        )
        label(
                text: 'Sorted:',
                constraints: gbc(
                        gridx: 0,
                        gridy: 1,
                        gridwidth: 1,
                        gridheight: 1,
                        fill: NONE,
                        anchor: EAST,
                        insets: [5, 5, 0, 0],
                        weightx: 0,
                        weighty: 0
                )
        )
        def sortedTextField = textField(
                constraints: gbc(
                        gridx: 1,
                        gridy: 1,
                        gridwidth: REMAINDER,
                        gridheight: 1,
                        fill: HORIZONTAL,
                        anchor: CENTER,
                        insets: [5, 5, 0, 5],
                        weightx: 1.0,
                        weighty: 0
                ),
                enabled: true,
                editable: false
        )
        label(
                constraints: gbc(
                        gridx: 0,
                        gridy: 2,
                        gridwidth: 2,
                        gridheight: 1,
                        fill: HORIZONTAL,
                        anchor: CENTER,
                        insets: [5, 5, 5, 0],
                        weightx: 1,
                        weighty: 1
                )
        )
        button(
                text: 'Clear',
                constraints: gbc(
                        gridx: 2,
                        gridy: 2,
                        gridwidth: 1,
                        gridheight: 1,
                        fill: NONE,
                        anchor: SOUTHEAST,
                        insets: [5, 5, 5, 0],
                        weightx: 0,
                        weighty: 1
                ),
                actionPerformed: {
                    println 'CLEAR'
                    listTextField.setText('')
                    sortedTextField.setText('')
                }
        )
        button(
                text: 'Sort',
                constraints: gbc(
                        gridx: 3,
                        gridy: 2,
                        gridwidth: 1,
                        gridheight: 1,
                        fill: NONE,
                        anchor: SOUTHEAST,
                        insets: [5, 5, 5, 5],
                        weightx: 0,
                        weighty: 1
                ),
                actionPerformed: {
                    println 'SORT'
                    sortedTextField.text = sortTextFromTextField(listTextField.text)
                }
        )
    }
}

String sortTextFromTextField(text) {
    int[] list = text.tokenize(' ') as int[]
    bubbleSort(list, list.size())
    return list.join(' ')
}


/**
 * Sort the given list of integers, using the bubble sort algorithm (recursively).
 *
 * @param list The list to sort.
 * @param n The first Nth number of items to sort in the list.
 */
def bubbleSort(int[] list, int n) {
    if (n == 1) {
        return
    }

    for (int i = 0; i < n - 1; i++) {
        if (list[i] > list[i + 1]) {
            list.swap(i, i + 1)
        }
    }

    println list

    bubbleSort(list, n - 1)
}
