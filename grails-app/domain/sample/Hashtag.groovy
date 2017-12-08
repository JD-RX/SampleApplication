package sample

class Hashtag {
    String name
    Date dateCreated;
    Date lastUpdated;

    static constraints = {
        name nullable: false, blank: false
    }

    public Hashtag saveInstance() {

        Hashtag hashtag = this

        hashtag.validate()

        if (hashtag.hasErrors()) {
            log.error("Hashtag has validation errors : ${hashtag.errors}")
            return null
        } else {
            hashtag.save(failOnError: true, flush: true)
            log.info "${hashtag} saved successfully"
            return hashtag
        }
    }

    @Override
    public String toString(){
        return this.name
    }
}
