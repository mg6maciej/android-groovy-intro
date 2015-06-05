package pl.mg6.grooid.intro

import groovy.transform.Canonical
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.Immutable

@CompileStatic
@EqualsAndHashCode(includes = 'name')
@Canonical
final class GroovyUser {

    String name
    List<GroovyUser> friends
    boolean isSuper

    static void something() {
        def user = new GroovyUser(name: 'Maciej', friends: [], isSuper: true)
        user.getFriends()
        user.@friends

        def friends = [
                new GroovyUser("Filomena", null, false),
                new GroovyUser("Maciej", null, true)
        ]
        GroovyUser alek = new GroovyUser("Alek", friends, true)

        def superfriends = alek.friends
                .findAll { it.isSuper }
                .collect { it.name }

    }
}
