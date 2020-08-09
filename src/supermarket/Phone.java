package supermarket;

public class Phone extends AbstractPhone {
    private double screenSize;

    @Override
    protected void test() {
        System.out.println("phone test");
    }

    private String name;
    private String os;
    private CPU cpu = new CPU();
    private WIFI wifi = new WIFI();
    private MemorySpec memory;
    private UnitSpec memoryUnit;
    private UnitSpecAbs memoryUnit2;

    public String brand;
    static int count = 1;

    interface MemorySpec {
        String getMemoryDesc();
    }

    public Phone(String name, String os, String brand, double screenSize) {
        this.name = name;
        this.os = os;
        this.brand = brand;
        this.screenSize = screenSize;

        class Memory implements MemorySpec {
            private int memorySize = 0;

            @Override
            public String getMemoryDesc() {
                return "memorySize:" + memorySize;
            }
        }

        this.memory = new Memory();
        this.memoryUnit = new UnitSpec() {
            @Override
            public String getSpec() {
                return "memoryUnit";
            }
        };

        this.memoryUnit2 = new UnitSpecAbs("hello") {
            @Override
            String getSpec() {
                return "what-" + this.spec;
            }
        };
    }

    public String describe() {
        return this.name + "-" + this.brand + "-" + this.os + "-"
                + this.screenSize + "-" + this.cpu.getCPUDesc()
                + "-" + this.wifi.getWifiDesc() + "-" + this.memory.getMemoryDesc()
                + "-" + this.memoryUnit.getSpec() + "-" + this.memoryUnit2.getSpec();
    }

    public static int getCount() {
        return count;
    }

    public static class CPU {
        private String hertz = "0";
        private int numberOfCores = 0;

        public String getCPUDesc() {
//            Phone phone = null;
//            System.out.println(phone.name);
            // 通过外部的实例来访问私有变量。
            return  "cpu desc:" + hertz + "," + numberOfCores;
        }
    }

    public class WIFI {
        private String channel = "";

        public String getWifiDesc() {
            // 可以访问到外部的私有属性
            System.out.println(Phone.this.name);
            return "wifi:" + channel;
        }
    }
}
