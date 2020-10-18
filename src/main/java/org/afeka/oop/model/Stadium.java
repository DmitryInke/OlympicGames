package org.afeka.oop.model;

public class Stadium {
    private String name;
    private String address;
    private int capacity;

    public Stadium(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Stadium))
            return false;
        Stadium temp = (Stadium) other;
        return name.equalsIgnoreCase(temp.name) || address.equalsIgnoreCase(temp.address);
    }

    @Override
    public String toString() {
        return "Stadium " + name + ", address: " + address + ", capacity: " + capacity + "";
    }

}
