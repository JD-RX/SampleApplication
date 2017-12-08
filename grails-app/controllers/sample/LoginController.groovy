package sample

import CO.UserCO
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

class LoginController {

    UserService userService
    SpringSecurityService springSecurityService

    def index() {
        if (session.user) {
            forward(controller: "user", action: "index")
        }else {
            render view: "index"
        }
    }

    def register(UserCO userCO) {
        User newUser = userCO.properties
        newUser.username = userCO.userName

        if(!params.pic?.empty)
        {
            if(["image/png", "image/jpeg", "image/jpg"].contains(params.pic?.contentType))
                newUser.photo = params.pic.bytes
        }

        if(userService.saveInstance(newUser)) {
            springSecurityService.reauthenticate(newUser.username, newUser.password)
            log.info "User saved successfully!"
            session.user = springSecurityService.currentUser
            redirect(controller: "user", action: "index")
        }
        else{
            log.error "User could not be saved!"
            render (view: "index", model: [user: newUser])
            return
        }
    }

    def logout() {
        session.invalidate()
        redirect(action:'index')
    }
}
