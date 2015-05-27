package pl.mg6.grooid.intro

import com.google.gson.annotations.SerializedName
import groovy.transform.Immutable

@Immutable
final class Organization {

    @SerializedName('login')
    String name
    String description
}
