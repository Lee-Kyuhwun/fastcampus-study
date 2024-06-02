import dev.be.demo5.cal.Calculator
import spock.lang.Specification

class CalculatorGroovyTest extends Specification {
    def "sum"() {
        given:
        def a = 10
        def b = 20
        def calculator = new Calculator()
        def expected = 30

        when:
        def result = calculator.sum(a, b)

        then:
        result == expected

        where:
        a  | b
        10 | 20
        20 | 30
        30 | 40

    }
}
