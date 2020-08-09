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
        this.getPhoneDesc();
        System.out.println("hello");
    }

    static long daysBetween(int from, int to) {
        int gap = to - from;
        return gap / (3600 * 24L);
    }
}
