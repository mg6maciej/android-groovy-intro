package pl.mg6.grooid.intro

import groovy.transform.CompileStatic
import retrofit.http.GET
import retrofit.http.Path
import rx.Observable

@CompileStatic
interface OrgsApi {

    @GET('/users/{user}/orgs')
    Observable<List<Organization>> call(@Path('user') String user)
}
