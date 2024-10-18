package `OCP-Open Closed Principle`

class CEO(var salary: Int, var experience: Double): Employee{
    override fun getSalary(): Double {
        return this.experience * 0.12 + salary;
    }
}