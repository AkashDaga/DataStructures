package StackAndQueues.main_app;

import StackAndQueues.utils.QueueUtils;

public class RunQueueApp {
    public static void main(String args[]){
        QueueUtils queueUtils = QueueUtils.getInstance();
        queueUtils.createQueue();
    }
}
