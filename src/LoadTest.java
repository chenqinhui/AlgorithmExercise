public class LoadTest {
    public static void main(String[] args) throws ClassNotFoundException{
        ClassLoader loader = LoadTest.class.getClassLoader();
        System.out.println(loader);
        //加载类，不执行初始化块
        // loader.loadClass("Test");

        // 加载类，执行初始化块
        //Class.forName("Test");
        Class.forName("Test",false,loader);
    }
}



