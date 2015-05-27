package pl.mg6.grooid.intro

import groovy.transform.CompileStatic
import retrofit.http.GET
import retrofit.http.Path
import rx.Observable

@CompileStatic
interface UserApi {

    @GET("/users/{user}")
    Observable<User> call(@Path("user") String user)
}
