package sample

class Tweet {
    String message
    Date dateCreated;
    Date lastUpdated;

    static belongsTo = [owner: User]
    static hasMany = [hashtags: Hashtag]

    static constraints = {
        message(nullable: false, blank: false)
    }

    public static List<Tweet> getTweetsByUser(User user){
        return Tweet.createCriteria().list {
            eq("owner", user)
            order("dateCreated", "desc")
        }
    }

    @Override
    public String toString(){
        return this.message
    }
}
