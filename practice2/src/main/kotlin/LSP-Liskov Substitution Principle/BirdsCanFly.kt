package `LSP-Liskov Substitution Principle`

abstract class BirdsCanFly:Bird {
    private var isFlying = false;
    open fun flyUp(){
        isFlying = true;
    }
    open fun flyDown(){
        isFlying = false;
    }
}