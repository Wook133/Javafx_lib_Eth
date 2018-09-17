package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Information
{
    private StringProperty cowAddress = new SimpleStringProperty();
    private StringProperty ownerAddress = new SimpleStringProperty();
    private StringProperty info = new SimpleStringProperty();

    public Information(String cowAddress, String ownerAddress, String info) {
        this.cowAddress.set(cowAddress);
        this.ownerAddress.set(ownerAddress);
        this.info.set(info);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", cowAddress.get(), ownerAddress.get(), info.get());
    }

    public String getCowAddress() {
        return cowAddress.get();
    }

    public StringProperty cowAddressProperty() {
        return cowAddress;
    }

    public void setCowAddress(String cowAddress) {
        this.cowAddress.set(cowAddress);
    }

    public String getOwnerAddress() {
        return ownerAddress.get();
    }

    public StringProperty ownerAddressProperty() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress.set(ownerAddress);
    }

    public String getInfo() {
        return info.get();
    }

    public StringProperty infoProperty() {
        return info;
    }

    public void setInfo(String info) {
        this.info.set(info);
    }
}
