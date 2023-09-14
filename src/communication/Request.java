package communication;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Request implements Serializable{
    
    private Operation operation;
    private Object object;

    public Request() {
    }

    public Request(Operation operation, Object object) {
        this.operation = operation;
        this.object = object;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Request{" + "operation=" + operation + ", object=" + object + '}';
    }
    
}
