package dataProvider.enums;

public enum ItemsEnum {
    NORMAL {
        public String getPanvelCode() {
            return "114780";
        }
    };

    public abstract String getPanvelCode();
}
