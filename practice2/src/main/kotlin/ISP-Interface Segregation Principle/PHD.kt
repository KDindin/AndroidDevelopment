package `ISP-Interface Segregation Principle`

class PHD: Student, ResearcherStudent {
    override fun study() {
        println("Practice")
    }

    override fun getMark() {
        println("Job is more important")
    }

    override fun doResearch() {
        println("Doing research")
    }
}