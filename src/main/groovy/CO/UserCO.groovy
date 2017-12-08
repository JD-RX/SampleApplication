package CO

import grails.validation.Validateable

class UserCO implements Validateable{
    String userName
    String name
    Integer age
    String password
    String emailID

    static constraints = {
        userName blank: false, unique: true
        emailID (unique: true, blank: false, nullable: false, email: true)
        password(nullable: false, blank: false, minSize: 5)
        name(nullable: false, blank: false)
        age(min: 0, max: 100)
    }
}
