package ds3;

import java.io.Serializable;

public interface Agent extends Serializable, Runnable {
    void setCurrentNode(Node node);
    boolean shouldProceed();
    String getSort();
}
