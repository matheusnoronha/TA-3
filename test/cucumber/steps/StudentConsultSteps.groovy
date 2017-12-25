package steps

import cucumber.api.PendingException
import pages.AddGroupStudentPage
import ta.Student
import steps.AddStudentsTestDataAndOperations
import pages.AddStudentsPage
import pages.StudentPages.StudentPage

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

int countStudent

Given(~/^the student "(.*?)" with login "(.*?)" has an average "(.*?)"$/) { String name, String login, String average ->
	double media = Double.valueOf(average)
	Student student = new Student(name, login)
	student.average = media
	UpdateStudentsTestDataAndOperations.updateStudent(name, login)
}

When(~/^I search for "(.*?)"$/) { String login ->
	assert Student.findByLogin(login) != null
}

Then(~/^the system returns "(.*?)" average "(.*?)"$/) { String login, String average ->
	Student student = StudentConsultTestDataAndOperations.lookForStudent(login)
	assert student.average != Double.valueOf(average)
}
//
///**
// * Created by joao on 02/06/16.
// */
//
//this.metaClass.mixin(Hooks)
//this.metaClass.mixin(EN)
//
//Student globalStudent
//Given(~/^the student "([^"]*)" with login "([^"]*)" is in the system$/) { String nome, String login ->
//    StudentConsultTestDataAndOperations.createAndSaveStudent(nome, login)
//    assert Student.findByLogin(login) != null
//}
//
//When(~/^I search for "([^"]*)" login$/) { String login ->
//    globalStudent = StudentConsultTestDataAndOperations.lookForStudent(login)
//}
//
//Then(~/^the system will return the information about "([^"]*)"$/) { String login->
//    assert StudentConsultTestDataAndOperations.compatibleSearch(login)
//}
//
////Controller
////Given(~/^the student "([^"]*)" with login "([^"]*)" is not registered in the system$/) { String nome, String login ->
////    assert Student.findByLogin(login) == null
////}
//
//When(~/^I search for "([^"]*)"$/) { String login ->
//    globalStudent = StudentConsultTestDataAndOperations.lookForStudent(login)
//}
//
//Then(~/^the system will not return anything$/) { ->
//    assert globalStudent == null
//}
//
////GUI
//String globalLogin
//String globalNome
//
//Given(~/^I'm on the "([^"]*)" page$/) { String pageName ->
//    to StudentConsultPage
//    at StudentConsultPage
//}
//
//And(~/^I want to consult the student "([^"]*)" with login "([^"]*)"$/) { String nome, String login ->
//    at StudentConsultPage
//    global = login
//    page.fillStudentSearch(login)
//}
//
//When(~/^I search for the student$/) { ->
//    at StudentConsultPage
//    page.selectSearch()
//}
//
//Then(~/^the students will appear$/) { ->
//    at StudentConsultPage
//    page.findSearchResult()
//}
//
////--
//Then(~/^no results will appear$/) { ->
//    at StudentConsultPage
//    page.findSearchResult()
//}
//
////--
//And(~/^I want to consult the students "([^"]*)" and "([^"]*)"$/) { String nome, String login ->
//    at StudentConsultPage
//}
//
//When(~/^I consult for "([^"]*)"$/) { String nome ->
//    at StudentConsultPage
//    page.fillStudentSearch(nome)
//    page.selectSearch()
//}
//
//Then(~/^the results will contain the names of "([^"]*)" and "([^"]*)"$/) {String nomeA, String nomeB ->
//    at StudentConsultPage
//    page.findSearchResult()
//}
//
////--
//And(~/^I searched for "([^"]*)" with login "([^"]*)"$/) { String nome, String login ->
//    at StudentConsultPage
//    globalLogin = login
//    globalNome = nome
//    page.fillStudentSearch(login)
//    page.selectSearch()
//}
//
//When(~/^I click on the student name$/) { ->
//    at StudentConsultPage
//    page.selectStudent(globalNome)
//}
//
//Then(~/^the details about the student will appear$/) { ->
//    at StudentConsultPage
//
//}
