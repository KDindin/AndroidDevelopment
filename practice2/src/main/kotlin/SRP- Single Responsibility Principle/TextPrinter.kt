package `SRP- Single Responsibility Principle`

class TextPrinter {
    var text= TextManipulator()

    public fun textPrinter(editedText: TextManipulator){
        this.text = editedText
    }
    fun printText(){
        println(this.text)
    }
    fun printSeperate(){
        println(text.toString().split(" "))
    }
}