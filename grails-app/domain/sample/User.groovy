package sample

import VO.UserVO
import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {
    String username
    String name
    Integer age
    String password
    String emailID
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    Date dateCreated
    Date lastUpdated
    byte[] photo
    //List<Long> followers

    static hasMany = [followers: User, tweets: Tweet]
    static constraints = {
        username blank: false, unique: true
        followers joinTable: [name: 'followers']
        emailID unique: true, blank: false, nullable: false, email: true
        password blank: false, password: true, minSize: 5
        name nullable: false, blank: false
        age min: 0, max: 100
        tweets cascade: 'all-delete-orphan'
        photo(nullable: true)
    }

    static mapping = {
        password column: '`password`'
        photo sqlType: 'longblob'
    }

    Set<Role> getAuthorities() {
        (SecUserRole.findAllBySecUser(this) as List<SecUserRole>)*.role as Set<Role>
    }

    @Override
    public String toString(){
        return this.username
    }
}
