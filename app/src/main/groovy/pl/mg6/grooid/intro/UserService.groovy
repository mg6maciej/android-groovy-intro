package pl.mg6.grooid.intro

import groovy.transform.CompileStatic
import retrofit.RestAdapter
import rx.Observable
import rx.functions.Func2

@CompileStatic
final class UserService {

    private UserApi api
    private OrgsApi orgsApi

    UserService(UserApi api, OrgsApi orgsApi) {
        this.orgsApi = orgsApi
        this.api = api
    }

    UserService() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint('https://api.github.com')
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
        api = adapter.create(UserApi)
        orgsApi = adapter.create(OrgsApi)
    }

    Observable<User> call(String name) {
        return api.call(name)
                .zipWith(orgsApi.call(name), addOrgsFunc)
    }

    private Func2<User, List<Organization>, User> getAddOrgsFunc() {
        return this.&addOrgs as Func2<User, List<Organization>, User>
    }

    private User addOrgs(User user, List<Organization> orgs) {
        user.organizations = orgs.collect { it.name }
        return user
    }
}
