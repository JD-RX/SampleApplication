package sample

import VO.TweetVO
import grails.transaction.Transactional

@Transactional
class TweetService {

    def serviceMethod() {

    }

    public List<TweetVO> getUserTweets(Long id){
        User user = User.findById(id)
        List<Tweet> tweets = Tweet.getTweetsByUser(user)
        List<TweetVO> tweetVOList = []

        tweets.each {Tweet tweet ->
            tweetVOList.add(new TweetVO(id: tweet.id, ownerId: tweet.owner.id, ownerName: tweet.owner.name, ownerUserName: tweet.owner.username, message: tweet.message, createdDate: tweet.dateCreated))
        }

        return tweetVOList
    }

    public List<TweetVO> getTweets(){
        List<Tweet> tweets = Tweet.list([sort: "dateCreated", order: "desc"])
        List<TweetVO> tweetVOList = []

        tweets.each {Tweet tweet ->
            tweetVOList.add(new TweetVO(id: tweet.id, ownerId: tweet.owner.id, ownerName: tweet.owner.name, ownerUserName: tweet.owner.username, message: tweet.message, createdDate: tweet.dateCreated))
        }

        return tweetVOList
    }

    public Tweet saveInstance(Tweet tweet) {

        tweet.validate()

        if (tweet.hasErrors()) {
            log.error("Tweet has validation errors : ${tweet.errors}")
            tweet = null
        } else {
            tweet.save()
            log.info "${tweet} saved successfully"
        }

        return tweet
    }

    public Tweet deleteInstance(Tweet tweet){
        tweet.delete()
    }
}
