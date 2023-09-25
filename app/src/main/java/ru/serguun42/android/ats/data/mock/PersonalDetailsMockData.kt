package ru.serguun42.android.ats.data.mock

class PersonalDetailsMockData() {
    var fullname: String = "John Doe"
    var dob: String = "1990-10-20"
    var locationCity: String = "Moscow"
    var locationCountry: String = "Russia"
    var jobTitle: String = "Operation Commissioning Supervisor"

    data class WorkPlace(
        var companyName: String = "Dunder Mifflin Paper Company, Inc",
        var jobPosition: String = "Quality Assurance",
        var startDate: String = "2005-03-24",
        var endDate: String = "2013-05-16"
    )

    var lastWorkPlace = WorkPlace()
}