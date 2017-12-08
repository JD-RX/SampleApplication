package sample

import VO.UserVO
import grails.transaction.Transactional

@Transactional
class UserService {

    def serviceMethod() {

    }

    public UserVO getInfo(Long id) {
        UserVO userVO = null

        if (id) {
            User user = User.findById(id)
            if (user) {
                userVO = new UserVO(userId: user.id, name: user.name, userName: user.username, emailID: user.emailID)
            }
        }

        return userVO
    }

    public User addFollower(User user, Long followId) {
            User follow = User.get(followId)
            user.addToFollowers(follow)

            if (user.hasErrors()) {
                log.error("User has validation errors : ${user.errors}")
                user = null
            } else {
                user.save()
                log.info "${user} now follows ${followId}"
            }
        return user
    }

    public User saveInstance(User user) {

        user.validate()

        if (user.hasErrors()) {
            log.error("User has validation errors : ${user.errors}")
            user = null
        } else {
            Role role = Role.findByAuthority("ROLE_USER")
            user.save()
            SecUserRole.create(user, role, true)
            log.info "${user} saved successfully"
        }

        return user
    }
}
