package com.dawn.java8;

import com.dawn.utils.Log;

public class DefaultInterfaceDemo implements A, B {

    private static final String TAG = "DefaultInterfaceDemo";

    public static void main(String[] args) {
        DefaultInterfaceDemo demo = new DefaultInterfaceDemo();
        Log.d(TAG, demo.getDefaultName(""));
        Log.d(TAG, demo.getDefaultName());
    }

    // 与接口意义相同，必须实现抽象方法
    @Override
    public String getName() {
        return A.NAME;
    }

    @Override
    public String getName(String defaultName) {
        return A.NAME;
    }

    /** 接口A、B中有相同的default方法，必须重写该方法，这里重写调用了接口B的方法，可按需重写 */
    @Override
    public String getDefaultName() {
        return B.super.getDefaultName();
    }
}

interface A {
    /** redundant public/static/final
     * 接口中定义的成员变量全部是public、static、final类型，即全部是对外开放的静态常量*/
    public static final int ID = 1;
    String NAME = "A";

    /**  redundant public
     * 接口中定义的抽象方法全部是public的，即全部对外开放 */
    public String getName();
    String getName(String defaultName);

    /**  redundant public
     * Java8新增：接口中定义的static方法也是public的且必须实现，即全部是已实现的静态的接口方法
     * 静态方法不可继承*/
    public static String getLocalName() {
        return NAME;
    }
    static String getLocalName(String defaultName) {
        return NAME;
    }

    /** redundant public
    * Java8新增：接口中定义的default方法也是public的且必须实现，即全部是已经实现的接口方法*/
    public default String getDefaultName(String defaultName) {
        return NAME;
    }
    /* default 与 static 不可同时修饰接口定义的方法 */
    /*static*/ default String getDefaultName() {
        return NAME;
    }
}

interface B {
    String NAME = "B";
    default String getDefaultName() {
        return NAME;
    }
}