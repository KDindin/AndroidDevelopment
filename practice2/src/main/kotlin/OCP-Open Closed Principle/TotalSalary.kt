package `OCP-Open Closed Principle`

class TotalSalary {
    fun calculateTotalSalary(workers: ArrayList<Employee>): Double{
        var salary: Double = 0.toDouble();
        for (worker in workers) {
            salary += worker.getSalary();
        }
        return salary;
    }
}