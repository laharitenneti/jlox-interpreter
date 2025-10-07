package jloxinterpreter;

class Return extends RuntimeException {
    //this class is for control-flow and not error handling
    //Because once 'return' is encountered, that fxn has to be exited. Exceptions help w this.
    final Object value;

    Return(Object value) {
        super(null, null, false, false); //disables unnecessary JVM code
        this.value = value;
    }
}
