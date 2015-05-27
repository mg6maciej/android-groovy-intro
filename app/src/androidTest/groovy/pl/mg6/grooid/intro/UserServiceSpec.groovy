package pl.mg6.grooid.intro

import rx.Observable
import spock.lang.Specification

final class UserServiceSpec extends Specification {

    UserApi userApi = Stub(UserApi)
    OrgsApi orgsApi = Stub(OrgsApi)
    UserService service
    User result

    def "should return user"() {
        given:
        userApi.call(_) >> Observable.just(new User(name: 'Maciek'))
        def orgs = [new Organization(name: 'EL'), new Organization(name: 'Groovy')]
        orgsApi.call(_) >> Observable.just(orgs)
        service = new UserService(userApi, orgsApi)
        when:
        service.call('mg6').subscribe { result = it }
        then:
        result == new User(name: 'Maciek', organizations: ['EL', 'Groovy'])
    }
}
