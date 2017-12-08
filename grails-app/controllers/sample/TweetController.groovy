package sample

import CO.TweetCO
import grails.plugin.springsecurity.annotation.Secured

class TweetController {

    TweetService tweetService

    def index() { }

    @Secured('ROLE_USER')
    def save(TweetCO tweetCO){
        User owner = session.user
        Tweet tweet = new Tweet(message: tweetCO.message, owner: owner)

        if(tweetService.saveInstance(tweet)) {
            log.info "Tweet added successfully!"
            flash.message = "Tweet added successfully!"
        }
        else{
            log.error "Tweet could not be saved!"
            flash.error = "Tweet could not be saved!"
        }
        redirect(controller: "user", action: "index")
    }

    @Secured('ROLE_USER')
    def delete(){
        Tweet tweet = Tweet.load(params.id)
        tweetService.deleteInstance(tweet)
        flash.message = "Tweet deleted successfully!"
        redirect(controller: "user", action: "index")
    }
}
