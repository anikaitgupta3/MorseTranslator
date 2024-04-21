package org.hyperskill.morsetranslator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tvtext=findViewById<TextView>(R.id.tv_text)
        var tvmorse=findViewById<TextView>(R.id.tv_morse)
        var ettext=findViewById<EditText>(R.id.et_text)
        var etmorse=findViewById<EditText>(R.id.et_morse)
        var btclear=findViewById<Button>(R.id.bt_clear)
        var btguide=findViewById<Button>(R.id.bt_guide)

        btclear.setOnClickListener{
            ettext.setText("")
            etmorse.setText("")
        }
        val morsemap= mapOf<Char,String>(
            'A' to  ".-",
            'B' to  "-...",
            'C' to  "-.-.",
            'D' to  "-..",
            'E' to  ".",
            'F' to  "..-.",
            'G' to  "--.",
            'H' to  "....",
            'I' to  "..",
            'J' to  ".---",
            'K' to  "-.-",
            'L' to  ".-..",
            'M' to  "--",
            'N' to  "-.",
            'O' to  "---",
            'P' to  ".--.",
            'Q' to  "--.-",
            'R' to  ".-.",
            'S' to  "...",
            'T' to  "-",
            'U' to  "..-",
            'V' to  "...-",
            'W' to  ".--",
            'X' to  "-..-",
            'Y' to  "-.--",
            'Z' to  "--..",
            'a' to  ".-",
            'b' to  "-...",
            'c' to  "-.-.",
            'd' to  "-..",
            'e' to  ".",
            'f' to  "..-.",
            'g' to  "--.",
            'h' to  "....",
            'i' to  "..",
            'j' to  ".---",
            'k' to  "-.-",
            'l' to  ".-..",
            'm' to  "--",
            'n' to  "-.",
            'o' to  "---",
            'p' to  ".--.",
            'q' to  "--.-",
            'r' to  ".-.",
            's' to  "...",
            't' to  "-",
            'u' to  "..-",
            'v' to  "...-",
            'w' to  ".--",
            'x' to  "-..-",
            'y' to  "-.--",
            'z' to  "--..",
            '0' to  "-----",
            '1' to  ".----",
            '2' to  "..---",
            '3' to  "...--",
            '4' to  "....-",
            '5' to  ".....",
            '6' to  "-....",
            '7' to  "--...",
            '8' to  "---..",
            '9' to  "----."
        )
        val morserevmap= mapOf<String,Char>(
             ".-" to 'A',
             "-..." to 'B',
             "-.-." to 'C',
             "-.." to 'D',
             "." to 'E',
             "..-." to 'F',
             "--." to 'G',
             "...." to 'H',
             ".." to 'I',
             ".---" to 'J',
             "-.-" to 'K',
             ".-.." to 'L',
             "--" to 'M',
             "-." to 'N',
             "---" to 'O',
             ".--." to 'P',
             "--.-" to 'Q',
             ".-." to 'R',
             "..." to 'S',
             "-" to 'T',
             "..-" to 'U',
             "...-" to 'V',
             ".--" to 'W',
             "-..-" to 'X',
             "-.--" to 'Y',
             "--.." to 'Z',
             "-----" to '0',
             ".----" to '1',
             "..---" to '2',
             "...--" to '3',
             "....-" to '4',
             "....." to '5',
             "-...." to '6',
             "--..." to '7',
             "---.." to '8',
             "----." to '9'
        )
        ettext.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // this function is called before text is edited
                /*if (count > after) { // Character removed
                    //val targetEditText = if (editText1.hasFocus()) editText2 else editText1
                    val difference = count - after
                    etmorse.setSelection(etmorse.selectionStart - difference)
                }*/
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                //etmorse.addTextChangedListener(this)

                // this function is called when text is edited
                //toastMsg("text is edited and onTextChangedListener is called.")
                /*if (TextUtils.isEmpty(s.toString())) {
                    //Toast.makeText(this, "Empty field not allowed!", Toast.LENGTH_SHORT).show()
                    billvalue.setText("")
                    tipperc.text=""
                } else {
                    //Toast.makeText(this, "Proceed..", Toast.LENGTH_SHORT).show()
                    var value=s.toString()
                    var value1=value.toBigDecimal()
                    value1=value1.setScale(2,RoundingMode.DOWN)
                    value=value1.toString()



                    if(value=="0.00"){
                        billvalue.setText("")
                        tipperc.text=""
                    }
                    else {
                        billvalue.setText("Bill Value: \$" + value)
                        val tippercent=seekbar.progress
                        tipperc.text="Tip: ${tippercent}%"
                    }*/


                /*var value=edittext.text.toString()
                var value1=value.toBigDecimal()
                value1=value1.setScale(2,RoundingMode.DOWN)
                value=value1.toString()





                billvalue.setText("Bill Value: \$"+value)*/

            }

            override fun afterTextChanged(s: Editable) {
                // this function is called after text is edited
                var help=s.toString()
                var newmorse=StringBuilder()
                for(c in help){
                    if(c==' '){
                        newmorse.append("   ")
                    }
                    else if(morsemap.containsKey(c)){
                        newmorse.append(morsemap[c])
                    }
                    else {
                        newmorse.append("?")
                    }
                    newmorse.append(" ")
                }
                etmorse.removeTextChangedListener(this)
                etmorse.setText(newmorse)
            }

        })
        etmorse.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // this function is called before text is edited
                /*if (count > after) { // Character removed
                    //val targetEditText = if (editText1.hasFocus()) editText2 else editText1
                    val difference = count - after
                    ettext.setSelection(ettext.selectionStart - difference)
                }*/
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                //ettext.addTextChangedListener(this)

                /*var help=s.toString()
                var newmorse=""
                for(c in help){
                    if(c==' '){
                        newmorse+="    "
                    }
                    else if(morse.containsKey(c)){
                        newmorse+=morse[c]
                    }
                    else {
                        newmorse += "?"
                    }
                }
                etmorse.setText(newmorse)*/


                // this function is called when text is edited
                //toastMsg("text is edited and onTextChangedListener is called.")
                /*if (TextUtils.isEmpty(s.toString())) {
                    //Toast.makeText(this, "Empty field not allowed!", Toast.LENGTH_SHORT).show()
                    billvalue.setText("")
                    tipperc.text=""
                } else {
                    //Toast.makeText(this, "Proceed..", Toast.LENGTH_SHORT).show()
                    var value=s.toString()
                    var value1=value.toBigDecimal()
                    value1=value1.setScale(2,RoundingMode.DOWN)
                    value=value1.toString()



                    if(value=="0.00"){
                        billvalue.setText("")
                        tipperc.text=""
                    }
                    else {
                        billvalue.setText("Bill Value: \$" + value)
                        val tippercent=seekbar.progress
                        tipperc.text="Tip: ${tippercent}%"
                    }*/


                /*var value=edittext.text.toString()
                var value1=value.toBigDecimal()
                value1=value1.setScale(2,RoundingMode.DOWN)
                value=value1.toString()





                billvalue.setText("Bill Value: \$"+value)*/

            }

            override fun afterTextChanged(s: Editable) {
                // this function is called after text is edited
                var help=s.toString()
                var newtext=""
                val helparraylist=help.split("    ")
                for(c in helparraylist){
                    val helparraylist2=c.split(" ")
                    for(c1 in helparraylist2){
                        if(morserevmap.containsKey(c1)) {
                            newtext += morserevmap[c1]
                        }
                    }
                    newtext+=" "
                }
                ettext.removeTextChangedListener(this)
                ettext.setText(newtext)
            }

        })
        /*
            Tests for android can not guarantee the correctness of solutions that make use of
            mutation on "static" variables. You should avoid using those.
            Consider "static" as being anything on kotlin that is transpiled to java
            into a static variable. That includes global variables and variables inside
            singletons declared with keyword object, including companion object.
            This limitation is related to the use of JUnit on tests. JUnit re-instantiate all
            instance variable for each test method, but it does not re-instantiate static variables.
            The use of static variable to hold state can lead to state from one test to spill over
            to another test and cause unexpected results.
            Using mutation on static variables is considered a bad practice anyway and no measure
            attempting to give support to that pattern will be made.
         */
    }
}