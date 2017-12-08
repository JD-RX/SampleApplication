package CO

import grails.validation.Validateable

class TweetCO  implements Validateable{

    String message

    static constraints = {
        message nullable: false, blank: false
    }
}
