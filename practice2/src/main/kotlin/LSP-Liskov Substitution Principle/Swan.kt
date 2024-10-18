package `LSP-Liskov Substitution Principle`

class Swan: BirdsCanFly() {
    override fun eat() {
        println("Eating")
    }

    override fun move() {
        println("Moving")
    }

    override fun flyUp() {
        super.flyUp()
        println("Flying up")
    }

    override fun flyDown() {
        super.flyDown()
        println("Flying down")
    }
}