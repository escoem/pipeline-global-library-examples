package escoem;

class CallableExample extends jenkins.security.MasterToSlaveCallable<Void, Exception> implements Serializable {
    private static long serialVersionUID = -1L;
    public CallableExample() {        
    }
    public Void call() throws Exception {
        System.out.println("HOLA SLAVE!!!");
    }
}