package JianZhiOffer;

public class Singleton {
    // 1.懒汉式
//    // 构造方法私有化
//    private DesignPattern.Singleton(){}
//    //类内部创建实例
//    private static DesignPattern.Singleton instance = null;
//    //双重检查加锁
//    public static DesignPattern.Singleton getInstance(){
//        if(instance==null){
//            synchronized (DesignPattern.Singleton.class){
//                if(instance==null){
//                    instance = new DesignPattern.Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    //2.饿汉式
    // 利用JVM特性，static部分只会在类加载时被初始化一次
    private Singleton(){}
    private static class SingletonHolder{
        private static Singleton instance = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }




}
