package pl.mg6.grooid.intro

import groovy.transform.CompileStatic
import rx.Observable

@CompileStatic
final class ApiStubFactory {

    UserApi createUserApi() {
        return {
            return Observable.just(new User(name: 'Maciej'))
        } as UserApi
    }
}
