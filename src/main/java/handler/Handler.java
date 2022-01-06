package handler;

public abstract class Handler {

    private Handler next;

    public abstract void process(Object data);


    public void next(Object data) {
        next.process(data);
    }

    public void setNext(Handler handler) {
        this.next = handler;
    }
}
