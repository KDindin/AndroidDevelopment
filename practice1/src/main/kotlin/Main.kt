fun main(args: Array<String>) {
  var aiszhan = Pupil("Aizhan", "Daulet", 16)
  var gulzhan = Pupil("Gulzhan", "teley", 15)
  var almat = Pupil("Almat", "Dauken", 15)
  var math = Subject("Math", 2)
  var pe = Subject("PE", 1)
  var teacher = Teacher("Aia", "Zharkyn", 25)

  teacher.takeSubject(pe)
  teacher.addPupilToClass(aiszhan)
  teacher.addPupilToClass(gulzhan)
  teacher.addPupilToClass(almat)

  for(pupil in teacher.myPupils){
    println(pupil.name)
  }
  println()
  for(subject in teacher.mySubjects){
    println(subject.name)
  }
}