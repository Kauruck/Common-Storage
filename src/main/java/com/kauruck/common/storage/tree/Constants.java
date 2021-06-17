package com.kauruck.common.storage.tree;

public class Constants {

    public static TraversOrder TO_STRING_TRAVERSE_ORDER = TraversOrder.PreOrder;
    public static TraversOrder List_TRAVERSE_ORDER = TraversOrder.InOrder;



    public static enum TraversOrder{
        InOrder,
        PreOrder,
        PostOrder
    }
}
