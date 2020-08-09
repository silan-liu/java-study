package supermarket;

public interface PhoneIterface {

    /**
     * @return 是否热门
     */
    boolean isHot();

    /**
     * @return 手机描述
     */
    String getPhoneDesc();

    default void hello() {
        System.out.println("hello");
    }
}
