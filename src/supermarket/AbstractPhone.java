package supermarket;

public abstract class AbstractPhone implements PhoneIterface {

    @Override
    public boolean isHot() {
        return false;
    }

    /**
     * @return 手机描述
     */
    @Override
    public String getPhoneDesc() {
        return null;
    }

    protected abstract void test();
}
