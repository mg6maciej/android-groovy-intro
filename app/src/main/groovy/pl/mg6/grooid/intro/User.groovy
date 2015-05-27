package pl.mg6.grooid.intro

import groovy.transform.EqualsAndHashCode
import groovy.transform.TupleConstructor


@TupleConstructor
@EqualsAndHashCode(includes = ['name', 'organizations'])
final class User {

    String name
    String company
    List<String> organizations
}
