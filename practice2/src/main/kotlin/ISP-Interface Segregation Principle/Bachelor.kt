package `ISP-Interface Segregation Principle`

class Bachelor: Student {
    override fun study() {
        println("Study hard")
    }

    override fun getMark() {
        println("Get A")
    }

}