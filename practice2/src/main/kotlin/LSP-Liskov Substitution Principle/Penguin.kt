package `LSP-Liskov Substitution Principle`

class Penguin:Bird {
    override fun eat() {
        println("Eating krill")
    }

    override fun move() {
        println("Funny moving ")
    }

}