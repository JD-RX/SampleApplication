package sample

import VO.TweetVO
import VO.UserVO
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class UserController {

    def assetResourceLocator
    TweetService tweetService
    UserService userService
    SpringSecurityService springSecurityService

    @Secured('ROLE_USER')
    def index(Integer max) {
        session.user = springSecurityService.getCurrentUser()
        List<TweetVO> tweets = tweetService.getTweets()
        UserVO userVO = userService.getInfo(session.user?.id)

        render view: "index", model: [user: userVO, tweets: tweets]
    }

    @Secured('ROLE_USER')
    def profile() {
        User user = User.get(params.id)
        List<TweetVO> tweets = tweetService.getUserTweets(user?.id)
        UserVO userVO = userService.getInfo(user?.id)
        render(view: "index", model: [tweets: tweets, user: userVO])
    }

    @Secured('ROLE_USER')
    def image(Long id) {
        User user = User.get(id)
        byte[] photo

        if (user.photo)
            photo = user.photo
        else {
            photo = assetResourceLocator.findAssetForURI('dummy.jpg').byteArray
        }
        response.outputStream << photo
        response.outputStream.flush()
    }

    @Secured('ROLE_USER')
    def follow(Long id){
        User user = springSecurityService.getCurrentUser()
        UserVO userVO = userService.getInfo(id)
        if(userService.addFollower(user, id)){
            log.info("Follower added!")
            flash.message = "You have started following ${userVO.name}"
        }else{
            flash.error = "Some error occured. Please try later!"
        }
        redirect action: "index"
    }
}
