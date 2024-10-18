package `OCP-Open Closed Principle`

class Manager(var mySalary: Double):Employee{
    override fun getSalary(): Double {
        return mySalary;
    }


}