package sample

class SampleTagLib {
    static namespace = "sa"

    def showFollowButton = {
        attributes, body ->
            Long userId = attributes.userId
            String userName = attributes.userName
            User loggedInUser = User.get(session.user?.id)
            List followerIds = loggedInUser.followers.collect{it.id}
            if((userId != session.user?.id) && !(followerIds.contains(userId))){
                out << link(controller: "user", action: "follow", class:"btn btn-primary", title:"Follow ${userName}", params:[id:userId], {"Follow"})
            }
    }
}
