class Teacher(name:String, surname:String, age:Int){
    var mySubjects = arrayOf<Subject>()
    var myPupils = arrayOf<Pupil>()

    fun addPupilToClass(pupil: Pupil){
        myPupils += pupil
    }
    fun takeSubject(subject: Subject){
        mySubjects += subject
    }
}