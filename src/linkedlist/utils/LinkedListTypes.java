package linkedlist.utils;

import linkedlist.utils.*;

public enum LinkedListTypes {
    SINGLE_LINKED_LIST(SingleLinkedListUtils.class),
    DOUBLY_LINKED_LIST(DoublyLinkedListUtils.class),
    CIRCULAR_SINGLE_LIKED_LIST(CircularSingleLinkedListUtils.class),
    CIRCULAR_DOUBLE_LIKED_LIST(CircularDoublyLinkedListUtils.class);

    private Class<? extends AbstractUtils> respectiveClass;

    LinkedListTypes(Class<? extends AbstractUtils> respectiveClass){
        this.respectiveClass = respectiveClass;
    };

    public Class<? extends AbstractUtils> getTheClass(){
        return respectiveClass;
    }
}
