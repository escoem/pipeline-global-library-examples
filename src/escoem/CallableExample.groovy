package escoem;

static class CallableExample extends jenkins.security.MasterToSlaveCallable<Void, Exception> implements Serializable {
    public Void call() throws Exception {
        System.out.println("HOLA SLAVE!!!")
    }
}