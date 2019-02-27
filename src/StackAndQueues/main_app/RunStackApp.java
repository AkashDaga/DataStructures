package StackAndQueues.main_app;

import StackAndQueues.utils.StackUtils;

public class RunStackApp {
    public static void main(String args[]){
        StackUtils stackUtils = StackUtils.getInstance();
        stackUtils.createStack();
    }
}
