package pl.mg6.grooid.intro

import spock.lang.Specification
import spock.lang.Unroll

final class GroovyUserSpec extends Specification {

    @Unroll
    def "groovy user"() {
        expect:
        new GroovyUser(name: myName).name == expectedName
        where:
        myName   | expectedName
        'Maciej' | 'Maciej'
        'Maciej' | 'Maciej'
    }
}
