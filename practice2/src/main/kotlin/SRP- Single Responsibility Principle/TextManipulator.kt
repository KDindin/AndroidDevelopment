package `SRP- Single Responsibility Principle`

class TextManipulator{
    private var text: String =""

    fun textChanging(text: String){
        this.text = text
    }
    fun getText(): String{
        return this.text;
    }
    fun textConcat(text:String){
        this.text += text
    }
    fun textReplace(oldText:String, newText:String ){
        if(this.text.contains(oldText)){
            this.text = this.text.replace(this.text, newText)
        }
    }


}