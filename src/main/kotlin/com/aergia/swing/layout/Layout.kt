package com.aergia.swing.layout

import net.miginfocom.layout.AC
import net.miginfocom.layout.ConstraintParser
import net.miginfocom.layout.LC

class Layout() {

    var layoutConstraints = LC()
        private set
    var columnConstraints = AC()
        private set
    var rowConstraints = AC()
        private set

    fun constraints(constrains: String = "", init: LC.() -> Unit = {}) {
        if (constrains != "") {
            layoutConstraints = ConstraintParser.parseLayoutConstraint(constrains)
        }

        layoutConstraints.init()
    }

    fun columns(constrains: String = "", init: AC.() -> Unit = {}) {
        if (constrains != "") {
            columnConstraints = ConstraintParser.parseColumnConstraints(constrains)
        }

        columnConstraints.init()
    }

    fun rows(constrains: String = "", init: AC.() -> Unit = {}) {
        if (constrains != "") {
            rowConstraints = ConstraintParser.parseRowConstraints(constrains)
        }

        rowConstraints.init()
    }
}